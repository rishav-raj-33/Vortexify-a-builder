# 🧠 Brain Module (Backend Intelligence)

## 📛 Module Name
**Brain Module**

---

## 🎯 Purpose

The **Brain Module** serves as the central coordinator of the system. It provides REST APIs to receive user input, validate repository links, and trigger **Heart Module** automation. It also manages user deployment history and authentication tasks like password reset.

---

## 🛠️ Technologies Used

- Java 17+  
- Spring Boot Framework  
- Spring Security  
- MySQL (read/write via Laravel DB layer)  
- RESTful Web Services  
- JavaMailSender *(for password reset feature — optional)*

---

## 📌 Responsibilities

- Expose REST endpoints for GitHub link submission and status queries  
- Validate incoming GitHub URLs and user tokens  
- Trigger Heart Module via command-line or REST call  
- Track user deployment history  
- Map deployments to user IDs  

---

## 🔗 Endpoints Overview

- `POST /deploy` – Accept GitHub repo link and user ID  
- `GET /status/{userId}` – Check deployment status  
- `POST /forgot-password` – Send reset token email  
- `PUT /reset-password` – Accept new password using token  

---

## 🔄 Integration

- Communicates with Heart Module over local/remote shell  
- Database interactions handled via **Laravel ORM** or **JDBC templates**

