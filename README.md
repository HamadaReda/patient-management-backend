# Patient Management System (Microservices)

A **backend-focused Patient Management System** built using **Microservices Architecture** with Spring Boot.  
This project represents my **first hands-on experience with microservices**, designed as a **small and focused learning project** to understand distributed systems, service communication, and backend scalability.

---

## 📌 Project Overview

The system simulates a healthcare backend responsible for managing patient data and related workflows.  
It is intentionally lightweight, focusing on **clean architecture**, **service isolation**, and **real-world backend practices** rather than feature size.

---

## 🧱 Architecture

The application follows a **microservices-based architecture**, where each service is independently developed and deployed.

### Services
- **Patient Service** – Manages patient information  
- **Billing Service** – Handles billing operations  
- **Analytics Service** – Processes and analyzes events  
- **Auth Service** – Authentication and authorization  
- **API Gateway** – Centralized routing and security  

### Communication
- **gRPC & Protocol Buffers** for synchronous inter-service communication  
- **Apache Kafka** for asynchronous, event-driven messaging  

---

## 🔐 Security

- Spring Security implementation  
- JWT-based authentication and authorization  
- Centralized security handled via the API Gateway  

---

## 🛠 Tech Stack

- **Backend:** Java, Spring Boot  
- **Security:** Spring Security, JWT  
- **Gateway:** Spring Cloud Gateway  
- **Messaging:** Apache Kafka  
- **Inter-Service Communication:** gRPC, Protocol Buffers  
- **Database:** PostgreSQL  
- **Containerization:** Docker, Docker Compose  
- **Testing:** JUnit, REST Assured  

---

## 🧪 Testing

- Integration tests written using **JUnit** and **REST Assured**  
- Focused on validating API behavior and service interactions  

---

## 🐳 Docker & Deployment

All services are containerized using **Docker**, including:
- Application services  
- PostgreSQL  
- Kafka  

---

## 🚀 Getting Started

### Prerequisites
- Java 21
- Docker
- Maven

# 🎯 Purpose of the Project

- First practical experience with Microservices Architecture
- Understanding service-to-service communication
- Applying event-driven design
- Practicing secure backend development
- Transitioning from monolithic systems to distributed architectures

# 📎 Notes

- This is a learning-focused project, not a production-scale system
- Emphasis is on architecture, communication patterns, and backend best practices

# 👤 Author

**Hamada Reda**  
Java Backend / Full Stack Developer  
Email: enghamadareda@gmail.com
LinkedIn: https://www.linkedin.com/in/hamada-reda-5200163m
GitHub: [https://github.com/HamadaReda](https://github.com/HamadaReda)




