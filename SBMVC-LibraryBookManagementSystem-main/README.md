# 📚 Library Book Management System

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen?style=flat-square&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6-brightgreen?style=flat-square&logo=springsecurity)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-green?style=flat-square&logo=thymeleaf)
![MySQL](https://img.shields.io/badge/MySQL-8.x-blue?style=flat-square&logo=mysql)
![Maven](https://img.shields.io/badge/Maven-3.x-red?style=flat-square&logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)

A full-stack **Library Book Management System** built with **Spring Boot MVC**, **Thymeleaf**, **Spring Security**, and **MySQL**. It supports role-based access control, book CRUD operations, search, genre filtering, sorting, and pagination.

---

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Database Setup](#database-setup)
  - [Run the Application](#run-the-application)
- [Default Roles](#-default-roles)
- [Screenshots](#-screenshots)
- [API / URL Reference](#-url-reference)
- [Contributing](#-contributing)

---

## ✨ Features

- 🔐 **Authentication & Authorization** — Login, Register with role selection (USER / ADMIN)
- 👥 **Role-Based Access Control**
  - `ROLE_USER` — View and search books
  - `ROLE_ADMIN` — Add, Edit, Delete books
- 📖 **Book Management** — Full CRUD (Create, Read, Update, Delete)
- 🔍 **Search** — Search books by title or author
- 🎭 **Genre Filter** — Filter books by genre via dropdown
- 🔃 **Sorting** — Sort by Title, Author, or Price (ascending/descending)
- 📄 **Pagination** — 5 books per page with Prev/Next navigation
- 📊 **Dashboard Cards** — Live count of Total, Available, and Issued books
- ✅ **Availability Status** — Badge showing Available / Issued per book

---

## 🛠 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.5.0 |
| Web MVC | Spring MVC |
| View Engine | Thymeleaf 3.x |
| Security | Spring Security 6 |
| ORM | Spring Data JPA / Hibernate 6 |
| Database | MySQL 8.x |
| Build Tool | Maven |
| Boilerplate | Lombok |
| CSS Framework | Bootstrap 5.3.3 |

---

## 📁 Project Structure

```
src/
└── main/
    ├── java/com/csp/lbms/
    │   ├── controller/
    │   │   ├── AuthController.java       # Register / Login
    │   │   ├── BookController.java       # Book CRUD + Search
    │   │   └── LoginController.java      # Login page route
    │   │
    │   ├── dto/
    │   │   └── RegisterDto.java          # Registration form DTO
    │   │
    │   ├── entity/
    │   │   ├── Book.java                 # Book entity
    │   │   └── User.java                 # User entity
    │   │
    │   ├── repository/
    │   │   ├── BookRepository.java       # Book JPA queries
    │   │   └── UserRepository.java       # User JPA queries
    │   │
    │   ├── service/
    │   │   ├── BookService.java          # Service interface
    │   │   └── BookServiceImpl.java      # Service implementation
    │   │
    │   ├── security/
    │   │   ├── CustomUserDetailsService.java  # UserDetailsService impl
    │   │   └── SecurityConfig.java            # Security filter chain
    │   │
    │   └── SbmvcLibraryBookManagementSystemApplication.java
    │
    └── resources/
        ├── templates/
        │   ├── index.html        # Home — book list, search, filter
        │   ├── login.html        # Login page
        │   ├── register.html     # Registration page
        │   ├── add-book.html     # Add book form
        │   └── edit-book.html    # Edit book form
        │
        ├── static/
        │   ├── css/
        │   └── js/
        │
        └── application.properties
```

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

- [Java 17+](https://adoptium.net/)
- [Maven 3.x](https://maven.apache.org/)
- [MySQL 8.x](https://dev.mysql.com/downloads/)
- Any IDE — IntelliJ IDEA / Eclipse / VS Code

---

### Database Setup

1. Open MySQL and create the database:

```sql
CREATE DATABASE testdb;
```

2. Update `src/main/resources/application.properties` with your credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useSSL=false
spring.datasource.username=root
spring.datasource.password=your_password
```

> Tables are created automatically on first run via `spring.jpa.hibernate.ddl-auto=update`

---

### Run the Application

```bash
# Clone the repository
git clone https://github.com/your-username/SBMVC-LibraryBookManagementSystem.git

# Navigate to project directory
cd SBMVC-LibraryBookManagementSystem

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application starts at: **http://localhost:8080**

---

## 👤 Default Roles

| Role | Access |
|---|---|
| `ROLE_USER` | View books, search, filter by genre |
| `ROLE_ADMIN` | All USER access + Add / Edit / Delete books |

> Roles are selected by the user at registration time. No default admin is seeded — register your first admin manually via the `/register` page.

---

## 🔗 URL Reference

| URL | Method | Access | Description |
|---|---|---|---|
| `/` | GET | USER, ADMIN | Home — book list |
| `/login` | GET | Public | Login page |
| `/register` | GET / POST | Public | Register new user |
| `/showNewBookForm` | GET | ADMIN | Add book form |
| `/saveBook` | POST | ADMIN | Save new / updated book |
| `/showFormForUpdate/{id}` | GET | ADMIN | Edit book form |
| `/deleteBook/{id}` | GET | ADMIN | Delete a book |
| `/logout` | POST | Authenticated | Logout |

---

## 🔒 Security Notes

- Passwords are encrypted using **BCryptPasswordEncoder**
- CSRF is disabled (can be re-enabled for production)
- Role validation is enforced **server-side** in `AuthController` — tampered role values from the client are rejected
- Spring Security 6 `DaoAuthenticationProvider` is used with the non-deprecated constructor

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch — `git checkout -b feature/your-feature`
3. Commit your changes — `git commit -m "Add your feature"`
4. Push to the branch — `git push origin feature/your-feature`
5. Open a Pull Request

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

> Built with ❤️ using Spring Boot + Thymeleaf + Spring Security
