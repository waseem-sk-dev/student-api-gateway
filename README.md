# 🧩 Student Config Server

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2023.x-blue)](https://spring.io/projects/spring-cloud)
[![Java](https://img.shields.io/badge/Java-17%2B-orange)](https://openjdk.org/)

The **Student API Gateway** is the entry point for all requests to the Student Microservices architecture.
It provides intelligent routing, load balancing, authentication, and cross-cutting concerns like logging and rate limiting.

---

## 🧠 Purpose

In a microservices architecture, each service runs independently.
The **API Gateway** acts as a **unified access layer**, routing client requests to the appropriate microservice and simplifying communication.

It acts as a proxy for:

- 🧭 ` student-eureka-server`  
- 🧩 `student-config-server`  
- 🎓 `student-course-service`  
- 👨‍🎓 `student-service`

---

## 🏗️ Architecture Overview

- **student-api-gateway**  
  - Port: 8080 (Default)

- **Other Microservices**  
  - Registered with Eureka Server
  - Routed through the Gateway
 
# Example Request Flow:

<p align="center">
  🧑‍💻 <b>Client</b> ➜ 🌐 <b>API Gateway</b> ➜ 🧭 <b>Eureka Server</b> ➜ 🎓 <b>Student Service</b>
</p>




---

## ⚙️ Tech Stack

| Technology | Purpose |
|-------------|----------|
| **Java 17+** | Programming language |
| **Spring Boot** | Application framework |
| **Spring Cloud Gateway** | Routing and load balancing |
| **Spring Cloud Netflix Eureka** | Service discovery |
| **Spring Cloud Config Client** | Externalized configuration |
| **Maven** | Dependency management and build tool |

---

## 🧩 Sample Configuration (application.yml)


# ============================
# Server Configuration
# ============================
server:
  port: 8080

# ============================
# Spring Application Details
# ============================
spring:
  application:
    name: student-api-gateway

  # ============================
  # Spring Cloud Gateway Routes
  # ============================
  cloud:
    gateway:
      routes:
        - id: student-service
          uri: lb://STUDENT-SERVICE
          predicates:
            - Path=/students/**

        - id: course-service
          uri: lb://STUDENT-COURSE-SERVICE
          predicates:
            - Path=/courses/**

# ============================
# Eureka Client Configuration
# ============================
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/


---

## 🚀 Running the Application

> **Using Maven**
> ```bash
> mvn clean install
> mvn spring-boot:run
> ```

---

## 🔍 Testing the Configuration Endpoint

> Once started, the gateway will be available at:

> `http://localhost:8080`
>
> Testing the Routes Assuming all services are up and registered in Eureka:
> | Endpoint                              | Routes To                | Description         |
| ------------------------------------- | ------------------------ | ------------------- |
| `http://localhost:8080/students/all`  | `student-service`        | Fetch all students  |
| `http://localhost:8080/students/{id}` | `student-service`        | Fetch student by ID |
| `http://localhost:8080/courses/all`   | `student-course-service` | Fetch all courses   |
| `http://localhost:8080/courses/{id}`  | `student-course-service` | Fetch course by ID  |

---

## 📦 Project Structure

> ```
> student-api-gateway/
> ├── src/
> │   ├── main/
> │   │   ├── java/com/student/gateway
> │   │   │   └── StudentApiGatewayApplication.java
> │   │   └── resources/
> │   │       └── application.yml
> │   └── test/
> ├── pom.xml
> └── README.md
> ```

---

## 🤝 Contributing

> Contributions are welcome!  
> If you’d like to improve configuration management, add documentation, or extend environments, feel free to open a PR.

---

## 👨‍💻 Author

> **Waseem Shaikh**  
> Backend Developer – Java | Spring Boot | Microservices  
> GitHub: [@waseem-sk-dev](https://github.com/waseem-sk-dev)

---

## 🪪 License

> This project is licensed under the **MIT License** – see the LICENSE file for details.
