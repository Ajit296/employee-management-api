Employee Management API

Employee Management API is a secure, production-ready REST API built with Spring Boot, PostgreSQL, Docker, JWT authentication, and Swagger documentation.
It features authentication, employee management, and role-based access control, all served behind Nginx with HTTPS

🚀 Features

Authentication
Register new users
Login and receive JWT tokens
Role-based access
Employee Management
CRUD operations for employees
Protected endpoints using JWT
Swagger API Documentation
Interactive API testing
JWT Authorization support
Production-ready Architecture
Dockerized app + PostgreSQL
Nginx reverse proxy with SSL
CSRF disabled, CORS configured

Security

HTTPS with Let’s Encrypt
Secure JWT token flow
Proper Spring Security filter chains

🛠️ Technology Stack
Layer	Technology
Backend	Java 17, Spring Boot 3, Spring Security, JWT
Database	PostgreSQL 13
API Docs	Swagger / springdoc-openapi
Containerization	Docker, Docker Compose
Reverse Proxy	Nginx
Build Tool	Maven
Security	HTTPS (Let’s Encrypt), JWT authentication
📦 Project Structure
employee-management-api/
├── src/main/java/...          # Java source code
│   ├── controller/           # AuthController, EmployeeController
│   ├── service/              # Business logic
│   ├── repository/           # Spring Data JPA Repositories
│   ├── config/               # SecurityConfig, SwaggerConfig
│   └── dto/                  # Request & Response DTOs
├── src/main/resources/
│   ├── application.yml       # App configuration
│   └── db/                   # SQL scripts (optional)
├── Dockerfile                 # Docker build file
├── docker-compose.yml         # Container orchestration
└── README.md                  # Project documentation

⚙️ Setup & Run
Clone the repository
git clone https://github.com/Ajit296/employee-management-api.git
cd employee-management-api

Build the project
mvn clean package

Run with Docker Compose
docker-compose up -d

Access the application

Base URL: https://pandaychak.com/docker-app

Swagger UI: https://pandaychak.com/docker-app/swagger-ui/index.html

🔒 Authentication Flow

Register a new user: POST /api/auth/register
Login: POST /api/auth/login → receive JWT token
Use JWT token for protected endpoints (Employee APIs)

Include token in header:

Authorization: Bearer <JWT_TOKEN>

🌐 Swagger Integration

JWT SecurityScheme defined globally

@SecurityRequirement applied only on protected APIs

Public APIs (login/register) remain open

Use Authorize 🔓 button to add JWT for testing

🔧 Nginx & HTTPS

Routes:

/ → Main app

/docker-app/ → Dockerized Spring Boot app

HTTPS terminated with Let’s Encrypt
Required proxy headers for Spring Boot:
proxy_set_header Host $host;
proxy_set_header X-Real-IP $remote_addr;
proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
proxy_set_header X-Forwarded-Proto $scheme;

💡 Best Practices Implemented

Dockerized backend and database
JWT authentication with Spring Security
Role-based access control
Reverse proxy with HTTPS
CSRF disabled, CORS configured
Swagger API documentation with selective security

🏷️ Future Enhancements

Refresh token mechanism
Role-based Swagger visibility
Nginx rate limiting
Audit logs for employee actions

CI/CD deployment (GitHub Actions / Docker Hub)

📌 Author

Ajit Kumar

Email: +91-7004576814

GitHub: https://github.com/Ajit296
