# System Design Document: Vortexify - A Builder

> **Prepared by:** Rishav Raj  
> **Assisted by:** [ChatGPT](https://openai.com/chatgpt)  
> **Date:** 7 April 2025

---

## 1. Project Overview

**Vortexify: A Builder** is a modular DevOps automation platform designed to streamline code deployment from Git repositories to VMware environments.  
It features a unique three-module architecture:

- **Skin** (UI Layer)  
- **Brain** (Backend Intelligence)  
- **Heart** (Automation Core)  

This system enables users to log in, manage projects, automate builds, and deploy containers effortlessly.

---

## 2. System Architecture

### 🧩 Modules Breakdown

#### 1. Skin Module (UI Layer)
- Built using **Laravel MVC Framework**
- Handles **user authentication**, **dashboard UI**, and **project management views**
- Uses **React** (optional) for password reset and dynamic UI flows

#### 2. Brain Module (Backend Layer)
- Built with **Spring Boot (Java)**
- Responsible for **user management**, **project metadata**, **deployment status**, and **API endpoints**
- Uses **MySQL** to store:
  - User-to-deployment mappings  
  - Container information  
  - Logs

#### 3. Heart Module (Automation Layer)
- Written in **Python** and **Shell Scripts**
- Performs:
  - Git repository cloning  
  - Docker image building  
  - Shell script execution  
  - VMware image deployment  
- **Future Plan:** Integrate **C++** for high-performance logging

---

## 3. Deployment Workflow

1. User logs in through the **Laravel UI**
2. User submits a **Git URL** and selects deployment configurations
3. **Brain** validates input and records deployment intent
4. **Brain** sends task parameters to **Heart**
5. **Heart**:
   - Clones Git repository  
   - Builds Docker image  
   - Deploys image to VMware
6. **Brain** updates:
   - Deployment status  
   - Container ID  
   - User ID  
   - Timestamps
7. *(Optional)* Logs are generated for future **C++** integration

---

## 4. Technologies Used

- **Frontend:** Laravel, React (Optional)  
- **Backend:** Spring Boot (Java)  
- **Automation:** Python, Shell Scripts  
- **Containerization:** Docker  
- **Virtualization:** VMware  
- **Database:** MySQL  
- **Performance Logging (Future):** C++

---

## 5. Features

- Role-based access control and user management  
- Automated deployment pipeline  
- Git-based code ingestion  
- Docker image creation  
- VMware virtual machine deployment  
- Modular, scalable architecture  
- **Future Enhancements:**
  - Logging via C++
  - Load balancing
  - Kubernetes integration (hardware-permitting)

---

## 6. User Roles & Interactions

### 👤 Admin
- Manage all deployments  
- View logs  
- Modify user roles

### 👨‍💻 Developer / User
- Submit Git repositories  
- Track deployment status  
- Receive feedback and logs

---

## 7. Future Roadmap

- Integrate **C++** for real-time container performance logging  
- **React-based** dynamic password recovery  
- **Multi-VM** deployment support  
- **Ansible** for provisioning (optional)  
- RESTful **API exposure** for external integration

---

## 8. System Design Evaluation

- **Scalability:** Independent module scaling  
- **Security:** Token-based authentication, DB validation, potential HTTPS  
- **Maintainability:** Clear separation of code and functionality  
- **Extensibility:** Easy integration of future tools (e.g., K8s, Ansible)

---

## 9. Use Case & Relevance

This project is ideal for **organizations** seeking an **on-premise DevOps automation builder** tailored for **VMware infrastructures**.  
It showcases **industry-level architecture** and is a **strong portfolio project** for aspiring **DevOps engineers**, **backend architects**, and **automation experts**.

---

## 10. Conclusion

**Vortexify** is more than just a builder — it's a **robust deployment platform** that combines:

- Smart automation  
- Clean, modular architecture  
- Real-world applicability  
- Future extensibility

It’s built to address critical deployment challenges in **mid to large-scale environments**.

---
