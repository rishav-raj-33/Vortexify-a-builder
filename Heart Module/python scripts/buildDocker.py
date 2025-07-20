import os
import sys
import subprocess

def build_and_export_docker_image(project_path, export_path, image_name):
    project_path = os.path.abspath(project_path)
    export_path = os.path.abspath(export_path)

    # Check project folder
    if not os.path.isdir(project_path):
        print(f"[Error] The specified project path does not exist: {project_path}")
        sys.exit(1)

    # Check Dockerfile
    dockerfile_path = os.path.join(project_path, 'Dockerfile')
    if not os.path.isfile(dockerfile_path):
        print(f"[Error] Dockerfile not found in the project directory: {dockerfile_path}")
        sys.exit(1)

    # Ensure export directory exists
    if not os.path.isdir(export_path):
        print(f"[Error] The specified export path is not a valid directory: {export_path}")
        sys.exit(1)

    # Build the image
    print(f"[Info] Building Docker image '{image_name}' from {project_path}...")
    try:
        subprocess.run(['docker', 'build', '-t', image_name, project_path], check=True)
        print(f"[Success] Docker image '{image_name}' built successfully.")
    except subprocess.CalledProcessError:
        print("[Error] Failed to build Docker image.")
        sys.exit(1)

    # Export the image to a tar file
    tar_file_path = os.path.join(export_path, image_name.replace(':', '_') + '.tar')
    print(f"[Info] Saving image to: {tar_file_path}")
    try:
        subprocess.run(['docker', 'save', '-o', tar_file_path, image_name], check=True)
        print(f"[Success] Docker image exported to: {tar_file_path}")
    except subprocess.CalledProcessError:
        print("[Error] Failed to export Docker image.")
        sys.exit(1)

if __name__ == "__main__":
    if len(sys.argv) != 4:
        print("Usage: python build_and_export_docker_image.py <project_folder_path> <export_folder_path> <image_name>")
        sys.exit(1)

    project_folder = sys.argv[1]
    export_folder = sys.argv[2]
    docker_image_name = sys.argv[3]

    build_and_export_docker_image(project_folder, export_folder, docker_image_name)
