import os
import sys
import subprocess
import paramiko
from scp import SCPClient

def build_docker_image(project_path, image_name, export_path):
    project_path = os.path.abspath(project_path)
    export_path = os.path.abspath(export_path)

    if not os.path.isdir(project_path):
        print(f"[Error] Project path does not exist: {project_path}")
        sys.exit(1)

    dockerfile = os.path.join(project_path, 'Dockerfile')
    if not os.path.isfile(dockerfile):
        print(f"[Error] Dockerfile not found in: {dockerfile}")
        sys.exit(1)

    # Build the image
    print(f"[Info] Building Docker image '{image_name}'...")
    subprocess.run(['docker', 'build', '-t', image_name, project_path], check=True)

    # Save image as tar
    tar_path = os.path.join(export_path, f"{image_name}.tar")
    print(f"[Info] Saving Docker image to: {tar_path}")
    subprocess.run(['docker', 'save', '-o', tar_path, image_name], check=True)

    return tar_path

def send_to_vm_and_run(tar_file_path, image_name, vm_info):
    host, port, username, password = vm_info['host'], vm_info['port'], vm_info['username'], vm_info['password']

    print(f"[Info] Connecting to VM {host}:{port}...")
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    ssh.connect(host, port=port, username=username, password=password)

    # SCP the tar file
    print(f"[Info] Sending Docker image to VM...")
    with SCPClient(ssh.get_transport()) as scp:
        scp.put(tar_file_path, remote_path=f"/home/{username}/{image_name}.tar")

    # Load the image
    print(f"[Info] Loading image on VM...")
    ssh.exec_command(f"docker load -i /home/{username}/{image_name}.tar")

    # Get available port from custom script
    print(f"[Info] Fetching available port from VM...")
    stdin, stdout, stderr = ssh.exec_command(f"bash /home/{username}/get_available_port.sh")
    available_port = stdout.read().decode().strip()
    error = stderr.read().decode().strip()
    if error:
        print(f"[VM Error] {error}")
        ssh.close()
        sys.exit(1)

    # Run the container with available port mapped to container port 8080
    run_cmd = f"docker run -d -p {available_port}:8080 --name {image_name}_container {image_name}"
    stdin, stdout, stderr = ssh.exec_command(run_cmd)
    container_id = stdout.read().decode().strip()
    error = stderr.read().decode().strip()
    if error:
        print(f"[VM Error] {error}")
        ssh.close()
        sys.exit(1)

    # Final result
    live_link = f"http://{host}:{available_port}"
    result = {
        "container_port": "8080",
        "container_id": container_id,
        "live_link": live_link
    }

    print("\n[✓] Container deployed successfully!")
    print(result)
    ssh.close()

if __name__ == "__main__":
    if len(sys.argv) != 6:
        print("Usage: python deploy_to_vm.py <project_path> <export_path> <image_name> <vm_ip> <vm_password>")
        sys.exit(1)

    project_path = sys.argv[1]
    export_path = sys.argv[2]
    image_name = sys.argv[3]
    vm_ip = sys.argv[4]
    vm_password = sys.argv[5]

    vm_info = {
        'host': vm_ip,
        'port': 22,
        'username': 'your-vm-username',  # ← replace this with actual username
        'password': vm_password
    }

    tar_file = build_docker_image(project_path, image_name, export_path)
    send_to_vm_and_run(tar_file, image_name, vm_info)
