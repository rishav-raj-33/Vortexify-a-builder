# 🖥️ Skin Module (User Interface Layer)

## 📛 Module Name
**Skin Module**

---

## 🎯 Purpose

The **Skin Module** is the front-facing layer of Vortexify. Built with Laravel’s MVC architecture, it provides the user interface for login, registration, deployment input, and viewing history. It maintains a clean, user-friendly experience.

---

## 🛠️ Technologies Used

- Laravel 10+ (PHP 8.x)  
- Blade Templates  
- Laravel Auth  
- Bootstrap  
- MySQL  

---

## 📌 Responsibilities

- User authentication and session management  
- Dashboard for users to input GitHub repo URLs  
- View past deployment logs and access links  
- Show real-time deployment status (via AJAX or API polling)  
- Password reset page *(via React or Blade templates)*

---

## 🔗 Routes Overview

- `/login`, `/register` – User authentication  
- `/dashboard` – GitHub URL input + deployment logs  
- `/history` – View previous deployments  
- `/reset-password` – Password reset UI

---

## 🧾 Views

- `auth/login.blade.php`  
- `auth/register.blade.php`  
- `dashboard.blade.php`  
- `deployment_history.blade.php`  
- `reset_password.blade.php`  

---

## 🔄 Integration

- Sends requests to **Brain Module APIs**  
- Uses MySQL database for user data  
- Can optionally invoke **React components** for enhanced UX *(optional)*
