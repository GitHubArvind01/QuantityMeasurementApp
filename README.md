# 🚀 Quantity Measurement Application  
## 📏 Test-Driven Development (TDD) | OOP | Clean Code | DRY Principle  

---

## 🧠 Project Overview

The **Quantity Measurement Application** is designed to validate equality, conversion, and arithmetic operations between different measurement units such as Feet, Inches, Yards, etc.

This project was implemented incrementally using:

- ✅ Test-Driven Development (TDD)
- ✅ Feature Branch Workflow
- ✅ Clean Code Practices
- ✅ DRY (Don't Repeat Yourself) Principle
- ✅ Proper Unit Conversion Strategy

---

# 🗄 UC16 – JDBC Database Integration
📅 **11 March 2026**  
🔖 **Branch:** `feature/UC16-JDBCPersistence`

## 🎯 Objective
Enable **persistent storage of measurement data** using **JDBC and relational database design**.

---

## 🧠 Technologies Used

- Java JDBC
- Maven Dependency Management
- SQL Database
- Connection Pooling
- Prepared Statements

---

## 🗄 Database Schema

```
users
 ├── id
 ├── name
 ├── email

measurements
 ├── id
 ├── value
 ├── unit
 ├── category

measurement_units
 ├── id
 ├── unit_name
 ├── conversion_factor
```

---

## ⚙ Core Concepts Applied

- JDBC Connection Handling
- Connection Pooling
- Parameterized SQL Queries
- Resource Management
- Transaction Handling
- Exception Hierarchy
- Configuration Management

---

## ✅ Implementation

- Integrated **JDBC persistence layer**
- Implemented **Connection Pool**
- Used **Prepared Statements for security**
- Created **Repository layer for database operations**
- Applied **SQL best practices**

🔗 Repository  
- [feature/UC16-JDBCPersistence](https://github.com/GitHubArvind01/QuantityMeasurementApp/tree/feature/UC16-JDBCPersistence/src/main/java/com/app/quantitymeasurementapp)

---