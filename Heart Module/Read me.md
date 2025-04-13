# ❤️ Heart Module (Automation Core)

## 🧠 Module Name
**Heart Module**

---

## 🎯 Purpose

The **Heart Module** is the automation powerhouse of **Vortexify: A Builder**. It handles cloning of repositories, building Docker images, and deploying containers on the VMware VM. It serves as the functional engine behind automated project deployment.

---

## 🛠️ Technologies Used

- Python 3.x  
- [Paramiko](https://pypi.org/project/paramiko/) (for SSH automation)  
- Docker CLI  
- VMware Workstation (target deployment platform)

---

## 📌 Responsibilities

- Clone public GitHub repositories containing Dockerfiles  
- SSH into VMware-hosted Linux VMs  
- Build Docker images from cloned code  
- Run the Docker containers and expose ports  
- Return deployed application access link (IP + Port)  
- **(Future Scope)** Resource monitoring using C++ scripts

---

## 🗃️ Key Scripts

- `clone_repo.py` – Clones the user’s GitHub repository  
- `deploy_docker.py` – Builds and runs the Docker container  
- `vm_connector.py` – Establishes SSH connection and executes commands  
- `extract_link.py` – Finds exposed port and composes access URL

---

## 🔄 Input/Output

- **Input**: GitHub repository URL (provided via Brain Module)  
- **Output**: Live deployment link or error logs

