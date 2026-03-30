# 🚀 Quantity Measurement Application

## 📏 TDD | Microservices | Clean Architecture | Scalable System

---

## 🧠 Project Overview

The **Quantity Measurement Application** is a production-ready system designed to handle:

* ✅ Unit comparison (Feet, Inches, Yards, etc.)
* ✅ Unit conversion
* ✅ Arithmetic operations on quantities

Built using modern engineering practices:

* 🧪 Test-Driven Development (TDD)
* 🧱 Microservices Architecture
* ♻️ DRY Principle
* 🧼 Clean Code Practices
* 🔐 Secure Authentication (JWT + Google Auth)

---

## 📸 Application flow concepts

> 📷 Client & Server Communication via JWT secure 

<img width="1536" height="1024" alt="d19994b0-ac4d-4275-ba3c-1be1ac7ce352" src="https://github.com/user-attachments/assets/ea90ad19-d906-4be6-b218-4324dc95af0e" />

---

# ☁️ UC21 – Microservices Architecture

📅 **28 Mar 2026**
🔖 **Branch:** `feature/UC21-MicroservicesArchitecture`

---

## 🎯 Objective

Refactor the monolithic system into a scalable **Microservices Architecture**:

* Independent services
* Separate deployments
* High scalability & maintainability

---

## 🧠 Tech Stack

| Layer            | Technology           |
| ---------------- | -------------------- |
| Backend          | Spring Boot          |
| Microservices    | Spring Cloud         |
| Service Registry | Eureka Server        |
| API Gateway      | Spring Cloud Gateway |
| Security         | JWT + Google OAuth   |
| Communication    | REST APIs            |

---

## 🏗️ System Architecture

```
                ┌──────────────────────┐
                │     API Gateway      │
                │       (8080)         │
                └─────────┬────────────┘
                          │
        ┌─────────────────┼─────────────────┐
        ▼                 ▼                 ▼
┌──────────────┐  ┌──────────────┐  ┌──────────────┐
│ Auth Service │  │ Quantity Svc │  │ Admin Service│
│   (8081)     │  │   (8082)     │  │   (8083)     │
└──────────────┘  └──────────────┘  └──────────────┘
                          │
                          ▼
                ┌──────────────────┐
                │ Eureka Server    │
                │     (8761)       │
                └──────────────────┘
```

---

## ⚙️ Services & Ports

| Service Name        | Artifact ID        | Port | Responsibility                       |
| ------------------- | ------------------ | ---- | ------------------------------------ |
| 🧭 Eureka Server    | `eureka-server`    | 8761 | Service Registry                     |
| 🚪 API Gateway      | `api-gateway`      | 8080 | Entry point, routing, JWT validation |
| 🔐 Auth Service     | `auth-service`     | 8081 | Login, JWT, Google Authentication    |
| 📏 Quantity Service | `quantity-service` | 8082 | Unit conversion & business logic     |
| 🛠 Admin Service    | `admin-service`    | 8083 | Monitoring & control                 |

---

## 🔄 Request Flow

### 🔐 Authentication Flow

```
Client → Login → Auth Service → JWT Token
```

### 📡 Authorized Request Flow

```
Client → Request (JWT)
        ↓
API Gateway (Validate Token)
        ↓
Route Request
        ↓
Quantity Service (Business Logic)
```

---

## ✅ Key Features

* 🔐 JWT + Google OAuth Authentication
* 🌐 Centralized API Gateway
* 🔍 Eureka Service Discovery
* 🔄 Loose Coupling with Microservices
* 📈 Scalable & Production-Ready
* 🧪 Fully TDD-driven development

---

## 🚀 How to Run

### 1️⃣ Start Services (Order Matters)

```bash
# 1. Eureka Server
cd eureka-server
mvn spring-boot:run

# 2. API Gateway
cd api-gateway
mvn spring-boot:run

# 3. Auth Service
cd auth-service
mvn spring-boot:run

# 4. Quantity Service
cd quantity-service
mvn spring-boot:run

# 5. Admin Service
cd admin-service
mvn spring-boot:run
```

---

## 🌐 Service URLs

| Service          | URL                   |
| ---------------- | --------------------- |
| Eureka Dashboard | http://localhost:8761 |
| API Gateway      | http://localhost:8080 |
| Auth Service     | http://localhost:8081 |
| Quantity Service | http://localhost:8082 |
| Admin Service    | http://localhost:8083 |

---

## 📦 Repository

🔗 https://github.com/GitHubArvind01/QuantityMeasurementApp/tree/feature/UC21-MicroservicesArchitecture

---

## 💡 Future Enhancements

* 🔄 Circuit Breaker (Resilience4j)
* 📊 Distributed Tracing (Zipkin)
* 📜 Centralized Config Server
* 📡 Kafka Event Streaming
* 🧪 Integration Testing

---

## 👨‍💻 Author

**Arvind Kumar**
🚀 Backend & Microservices Developer

---
