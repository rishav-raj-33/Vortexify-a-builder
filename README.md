# ⚙️ Vortexify: A Builder 
"From code to container — Vortexify spins it, builds it, lives it."

> 🚀 One-click GitHub-to-Docker Deployment System on VMware  
> A modular DevOps tool built with ❤️, 🧠, and 🧑‍🎨

---

## 📌 Overview

**Vortexify** is a full-stack automation platform that lets users deploy Docker-ready GitHub repositories on a remote VMware Linux machine **in seconds**.  
It offers **GitHub integration**, **live preview links**, and **deployment tracking** — all while being modular, scalable, and beautifully organized.

---

## 🧠 Architecture Philosophy

- **Modular Design**: Separated into Heart, Brain, and Skin modules for better cohesion and scalability.
- **Multi-Stack Integration**: Uses the best technology per concern — Python for automation, Java for backend control, Laravel for UI.
- **VMware Support**: Custom integration for deploying containers into VMware virtual machines.
- **Security & Usability**: Includes optional password recovery (React) and logging via C++ (future implementation).

---


## 📁 Module Overview

### ❤️ Heart Module — The Automation Core
- Written in: Python, Shell Scripts
- Handles:
  - Git repository cloning
  - Docker image creation
  - Running containers on VMware
- Future: C++ logging for performance tracking

### 🧠 Brain Module — The Backend Intelligence
- Written in: Spring Boot (Java)
- Handles:
  - User info mapping
  - Build/deployment orchestration
  - Request coordination across modules

### 💅 Skin Module — The Interface Layer
- Written in: Laravel (PHP)
- Handles:
  - User authentication
  - UI for build and deployment flow
  - Status monitoring and dashboard
- Feature: React-based password recovery (optional/future)

---

## 🔍 Why Multi-Stack?

Using different stacks for each responsibility helps in:

| Concern          | Technology        | Justification                                                                 |
|------------------|-------------------|------------------------------------------------------------------------------|
| Automation        | Python + Shell     | Lightweight, fast, script-friendly                                           |
| Backend Logic     | Spring Boot (Java) | Robust, scalable, excellent for RESTful APIs and complex logic              |
| UI Interface      | Laravel (PHP)      | Rapid prototyping, MVC structure, templating power                          |
| Optional UI       | React              | Component-based, great for dynamic features like password reset             |
| Logging (Future)  | C++                | Low-level performance monitoring and system calls on VMware containers      |


---

### ✨ Benefits of Multi-Stack:
- 💡 **Better Code Quality**: Each language fits its role
- ⚙️ **Separation of Concerns**: Clear, testable modules
- 🚀 **Scalability**: Independent upgrades
- 📚 **Maintainability**: Easier to manage bugs and features per tech
- 🧪 **Testability**: Smaller scope tests per module

---

## 🧩 System Design Summary

- Skin Module connects users with UI
- Brain Module handles user requests and deployment flow
- Heart Module does the heavy lifting: cloning, Docker, and deployment
- Optional modules like React and C++ are integrated modularly

See full system architecture and SRS with Other Info at Resouce Directory*

---

## 🧠 System Qualities

- **Cohesion**: High within each module
- **Coupling**: Low between modules
- **Scalability**: Modular stack can scale independently
- **Readability**: Each tech follows its community best practices
- **Maintainability**: Easier due to separation
- **Testability**: High due to isolated components

---

## 🧰 Technologies Used

- **Frontend (Skin)**: `Laravel`, `Blade`, `Bootstrap`, `HTML`, `CSS`, `JS`
- **Backend (Brain)**: `Spring Boot`, `REST API`, `MySQL`, `JPA`
- **Automation (Heart)**: `Python`, `Paramiko`, `Docker`, `C++` (for logging)
- **Deployment Target**: `VMware Workstation` with `Kali LINUX + Docker`

---


<details>
<summary>📜 <strong>Software Requirements Specification (SRS)</strong></summary>

- Accepts GitHub repo links and deploys using Docker
- Live link sharing for deployed apps
- Maintains deployment history per user
- Modular structure: Heart (Automation), Brain (Backend), Skin (UI)
- Token-based password reset support
- Optional container logging using C++

</details>

---

## 📊 Skill Mapping & Difficulty

| Module  | Skill Level         | Technologies               | Complexity Level | Maintainability | Testability  |
|---------|---------------------|----------------------------|------------------|------------------|-------------|
| Heart   | Intermediate-Advanced | Python, Shell, C++        | ⭐⭐⭐⭐      | ⭐⭐⭐⭐       | ⭐⭐⭐⭐  | 
| Brain   | Advanced             | Spring Boot, Java          | ⭐⭐⭐⭐⭐    | ⭐⭐⭐⭐      | ⭐⭐⭐⭐   |
| Skin    | Intermediate         | Laravel, React (optional)  | ⭐⭐⭐         | ⭐⭐⭐         | ⭐⭐⭐     |

---


## 💡 Features

- [x] GitHub to Docker auto-deploy
- [x] Live preview link
- [x] User login/registration
- [x] Deployment tracking
- [x] Token-based password reset
- [ ] Auto SSL & teardown (Future)
- [ ] React UI (Optional)
- [ ] CI/CD pipeline integration (Coming soon)

---


## 🔐 Security Highlights

- REST APIs are secured with token authentication
- SSH communication to VM is encrypted
- Input validation & sanitization

---

## 👨‍💻 Contributors

| Name           | Module            |
|----------------|-------------------|
| Rishav Raj (🔥)| Heart,Brain,Skin |
| Your Future 👥 | Open for collab  |

---

## 🧠 Fun Fact

> The JVM is written in C++  
> The brain of Vortexify is built in Java, and its heartbeat pulses in Python 🧬

---



## 💬 Wanna Contribute?

Fork the repo → Create a feature branch → Submit a PR 🚀  
We love builders!