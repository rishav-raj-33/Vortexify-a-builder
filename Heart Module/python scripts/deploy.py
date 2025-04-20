import os
import sys
import subprocess
import paramiko
from scp import SCPClient

def send_to_vm_and_run(tar_file_path, image_name, vm_info):
    host, port, username, password = vm_info['host'], vm_info['port'], vm_info['username'], vm_info['password']

    # Ensure tar file exists
    if not os.path.isfile(tar_file_path):
        print(f"[Error] The tar file does not exist: {tar_file_path}")
        sys.exit(1)

    print(f"[Info] Connecting to VM {host}:{port}...")
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    ssh.connect(host, port=port, username=username, password=password)

    # SCP the tar file to the VM
    print(f"[Info] Sending Docker image to VM...")
    with SCPClient(ssh.get_transport()) as scp:
        scp.put(tar_file_path, remote_path=f"/home/{username}/{image_name}.tar")

    # Load the Docker image on the VM
    print(f"[Info] Loading Docker image on VM...")
    stdin, stdout, stderr = ssh.exec_command(f"docker load -i /home/{username}/{image_name}.tar")
    out = stdout.read().decode().strip()
    err = stderr.read().decode().strip()
    if err:
        print(f"[VM Error] {err}")
        ssh.close()
        sys.exit(1)

    print(f"[VM Output] {out}")

    # Get available port from custom script
    print(f"[Info] Fetching available port from VM...")
    stdin, stdout, stderr = ssh.exec_command("portFinder")
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
        "container_port": available_port,
        "container_id": container_id,
        "live_link": live_link
    }

    print("\n[✓] Container deployed successfully!")
    print(result)
    ssh.close()

if __name__ == "__main__":
    if len(sys.argv) != 6:
        print("Usage: python deploy_to_vm.py <tar_file_path> <image_name> <vm_ip> <vm_username> <vm_password>")
        sys.exit(1)

    tar_file_path = sys.argv[1]
    image_name = sys.argv[2]
    vm_ip = sys.argv[3]
    vm_username = sys.argv[4]
    vm_password = sys.argv[5]

    vm_info = {
        'host': vm_ip,
        'port': 22,
        'username': vm_username,
        'password': vm_password
    }

    send_to_vm_and_run(tar_file_path, image_name, vm_info)
