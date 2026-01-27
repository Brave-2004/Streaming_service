# 🎬 Streaming Service Backend

A backend REST API for a **Streaming Service** built with **Spring Boot**. The project provides core functionality for managing content, actors, genres, users, ratings, and recommendations.

---

## 🚀 Tech Stack

* **Java 17+**
* **Spring Boot**
* **Spring Security**
* **Spring Data JPA**
* **Gradle**
* **OpenAPI / Swagger**
* **Relational Database (PostgreSQL / MySQL)**

---

## 📂 Project Structure

```
streaming_service/
└── src/main/java/project/streaming_service/
    ├── config/
    │   ├── OpenApiConfig
    │   └── SecurityConfig
    │
    ├── controller/
    │   ├── ActorController
    │   ├── GenreController
    │   ├── ContentController
    │   └── UserController
    │
    ├── dto/
    │   ├── request/
    │   └── response/
    │
    ├── entity/
    ├── enums/
    ├── mapper/
    ├── repository/
    ├── service/
    ├── utils/
    └── resource/
```

---

## 📑 API Documentation

Swagger UI is available after running the application:

```
http://localhost:8080/swagger-ui.html
```

---

## 🎥 Content Functionality

The **ContentController** provides the following features:

* 🔍 Find content by ID
* ➕ Create new content
* 🎭 Add actors to content
* ⭐ Rate content
* ▶️ Watch content
* ⏸️ Continue watching content
* 📊 Get average rating of content
* 🤖 Get content recommendations
* Assign genres to content
* Assign actors to content

---

## 🎭 Actor Management

* Create actor

---

## 🎞️ Genre Management

* Create genre

---

## 👤 User Management

* User registration
* User authentication
* Watch history tracking
* Continue watching functionality

---

## 🛠️ Common CRUD Operations

All controllers support basic operations:

* ✅ Create
* ✏️ Update
* ❌ Delete
* 📄 Get by ID
* 📋 Get all

---

## ▶️ Running the Project

### 1️⃣ Clone the repository

```bash
git clone https://github.com/your-username/streaming-service.git
cd streaming-service
```

---

### 2️⃣ Create Database

Create a database in PostgreSQL (or MySQL):

```sql
CREATE DATABASE streaming_service;
```

---

### 3️⃣ Configure Database Connection

Update `application.yml` or `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/streaming_service
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

### 4️⃣ Build and Run the Project

```bash
gradle clean build
gradle bootRun
```

---

### 5️⃣ Access the Application

* API Base URL:

```
http://localhost:8080
```

* Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

---

## 📌 Future Improvements

* Recommendation algorithm optimization
* Pagination and filtering
* Caching with Redis
* Microservices architecture

---

## 👨‍💻 Author

**Jasurbek**
Backend Developer | Java & Spring Boot

---

⭐ If you like this project, don’t forget to give it a star on GitHub!
