# 👤 User Management API

A full-stack **User Management CRUD** application built with **Java + Spring Boot** in the backend and **JavaScript + Bootstrap** in the frontend. It exposes a secure RESTful API and uses **JWT (JSON Web Token)** for authentication and authorization.

---

## 🚀 Features

- ✅ Create, read, and delete users via REST API
- 🔐 JWT-based authentication and session handling
- 🔁 Password hashing using Argon2
- 🌐 Responsive and intuitive frontend with Bootstrap
- 🔍 User listing via DataTables (jQuery plugin)
- 📦 Clean API structure and modular code

---

## 🛠️ Tech Stack

### Backend
- Java 17+
- Spring Boot
- Hibernate / JPA
- MySQL
- JWT (JSON Web Token)
- Argon2 (Password hashing)

### Frontend
- HTML / CSS
- JavaScript (Vanilla)
- Bootstrap 4
- jQuery + DataTables

---

## ⚙️ How to Run

### 📌 Prerequisites

- Java 17+
- MySQL 8+
- Maven

### 🚀 Running Backend

1. Clone the repository:
   ```bash
   git clone https://github.com/Pipe-Garcia/management-users-fullstack.git
   cd management-users-fullstack

2. Update DB credentials in src/main/resources/application.properties

3. Start the server
   ```bash
   ./mvnw spring-boot:run

Server will start on: http://localhost:8080


### 🖥️ Running Frontend

  - Open usuarios.html in your browser

  - Ensure backend is running for data to load


### 🔐 JWT Authentication

  - Login endpoint issues a JWT token after verifying credentials.

  - Token is stored in localStorage.

  - All protected API requests must include the token in the Authorization header.
   
    Authorization: Bearer <your-jwt-token>


### 📋 API Endpoints

   | Method |Endpoint  |Description|
|--|--|--|
| POST |/api/usuarios  |Create new user|
|GET|/api/usuarios|Get all users|
|GET|/api/usuarios/{id}|Get user by ID|
|DELETE|/api/usuarios/{id}|Delete user by ID|
|POST|/api/login|Authenticate & get JWT|


### 📸 UI Preview


  - **✅ Register Page – Form to create new users**

  - **🔐 Login Page – Session start and token generation**

  - **📄 User List Page – Table with users fetched via API**

  - **🗑️ Delete User Flow – Confirmation and removal from DB**

  - **✏️ Update User Page (optional) – Form to edit user info (next feature)**

  - **🔐 JWT in localStorage – DevTools screenshot (Educational purposes)**

  - **🧂 Hashed Password – Example in phpMyAdmin**


    ⚠️ Nota: La contraseña se muestra hasheada en phpMyAdmin con fines educativos. En producción, la base de datos debe estar protegida adecuadamente y los hashes no deben ser expuestos.   


### 📧 Author

Developed with 💻 and ☕ by Felipe Garcia.


### ⭐️ Show Your Support

If you like this project, give it a ⭐ on GitHub and share it with others!
