import sys
import paramiko

def stop_docker_container(container_id, vm_info):
    host, port, username, password = vm_info['host'], vm_info['port'], vm_info['username'], vm_info['password']

    print(f"[Info] Connecting to VM {host}:{port}...")
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    ssh.connect(host, port=port, username=username, password=password)

    # Stop the container
    print(f"[Info] Stopping container {container_id}...")
    stop_cmd = f"docker stop {container_id}"

    stdin, stdout, stderr = ssh.exec_command(stop_cmd)
    out = stdout.read().decode().strip()
    err = stderr.read().decode().strip()
    if err:
        print(f"[VM Error] {err}")
        ssh.close()
        sys.exit(1)

    print(f"[Info] Container {container_id} stopped successfully.")
    ssh.close()

if __name__ == "__main__":
    if len(sys.argv) != 5:
        print("Usage: python stop_docker.py <container_id> <vm_ip> <vm_username> <vm_password>")
        sys.exit(1)

    container_id = sys.argv[1]
    vm_ip = sys.argv[2]
    vm_username = sys.argv[3]
    vm_password = sys.argv[4]

    vm_info = {
        'host': vm_ip,
        'port': 22,
        'username': vm_username,
        'password': vm_password
    }

    stop_docker_container(container_id, vm_info)
