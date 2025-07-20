import subprocess
import sys

def delete_docker_image(image_name):
    try:
        # Check if the image exists locally
        result = subprocess.run(['docker', 'images', '-q', image_name], capture_output=True, text=True)
        image_id = result.stdout.strip()

        if not image_id:
            print(f"[Info] No local Docker image found with name or tag: {image_name}")
            return

        # Delete the image
        print(f"[Info] Deleting Docker image '{image_name}' (ID: {image_id})...")
        subprocess.run(['docker', 'rmi', '-f', image_id], check=True)
        print(f"[Success] Docker image '{image_name}' deleted successfully.")

    except subprocess.CalledProcessError as e:
        print(f"[Error] Failed to delete Docker image: {e}")
        sys.exit(1)

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python delete_docker_image.py <image_name_or_tag>")
        sys.exit(1)

    image_name = sys.argv[1]
    delete_docker_image(image_name)