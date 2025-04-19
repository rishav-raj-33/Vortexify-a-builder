import os
import sys
import subprocess
from urllib.parse import urlparse

def extract_repo_name(repo_url):
    parsed = urlparse(repo_url)
    path = parsed.path.rstrip('/')
    repo_name = path.split('/')[-1]
    if repo_name.endswith('.git'):
        repo_name = repo_name[:-4]
    return repo_name

def main():
    if len(sys.argv) != 3:
        print("Usage: python clone.py <GitHub Repo URL> <Parent Folder Path>")
        sys.exit(1)

    repo_url = sys.argv[1]
    parent_folder = sys.argv[2]

    if not os.path.exists(parent_folder):
        print(f"Error: The parent folder '{parent_folder}' does not exist.")
        sys.exit(1)

    repo_name = extract_repo_name(repo_url)
    target_path = os.path.join(parent_folder, repo_name)

    if os.path.exists(target_path):
        print(f"Error: The folder '{target_path}' already exists.")
        sys.exit(1)

    try:
        os.makedirs(target_path)
        print(f"Created folder: {target_path}")

        print("Cloning repository...")
        subprocess.run(["git", "clone", repo_url, target_path], check=True)
        print("Repository cloned successfully.")

    except Exception as e:
        print(f"An error occurred: {e}")
        sys.exit(1)

if __name__ == "__main__":
    main()
