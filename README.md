# 🏦 Bank Transaction System (Spring Boot + MySQL)

## 📌 Project Overview

This project is a **Bank Transaction Management System** built using **Spring Boot** and **MySQL**.
It demonstrates how **transactions (commit & rollback)** work in real-world applications.

The system ensures **data consistency** using `@Transactional`, meaning:

* ✅ If all operations succeed → changes are committed
* ❌ If any error occurs → all changes are rolled back

---

## 🎯 Objective

To understand and implement:

* Transaction management in Spring Boot
* Database consistency using ACID properties
* Real-time money transfer between accounts

---

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **MySQL**
* **Lombok**
* **Postman (for API testing)**

---

## 📂 Project Structure

```
com.example.bank
│
├── controller      → Handles HTTP requests
├── service         → Business logic + transactions
├── repository      → Database interaction (JPA)
├── model           → Entity classes
└── BankApplication → Main class
```

---

## 🗄️ Database Setup

### 1️⃣ Create Database

```sql
CREATE DATABASE bank_db;
```

### 2️⃣ Configure `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bank_db
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ⚙️ Features

### ✅ Create Account

* Adds a new user with initial balance

### ✅ Check Balance

* Fetch account details by ID

### ✅ Transfer Money

* Transfers amount from one account to another

---

## 🔥 Transaction Logic

```java
@Transactional
public void transferMoney(int from, int to, double amount)
```

### Flow:

1. Deduct money from sender
2. Add money to receiver
3. If any error occurs → rollback

---

## 🌐 API Endpoints

### 🔹 Create Account

```
POST /bank/create
```

**Body:**

```json
{
  "name": "Swapnil",
  "balance": 1000
}
```

---

### 🔹 Get Account

```
GET /bank/{id}
```

---

### 🔹 Transfer Money

```
POST /bank/transfer?from=1&to=2&amount=100
```

---

## 🧪 Testing

### ✅ Success Case

* Money is transferred successfully
* Sender balance decreases
* Receiver balance increases

---

### ❌ Failure Case (Rollback)

* Exception is thrown intentionally
* No changes occur in database
* Ensures transaction rollback

---

## 📸 Screenshots (To be added)

* ✔ Account Creation
* ✔ Balance Check
* ✔ Successful Transaction
* ✔ Failed Transaction (Rollback)

---

## 🚀 How to Run

```bash
git clone <your-repo-url>
cd bank
./mvnw spring-boot:run
```

---

## 🧠 Key Concepts Learned

* Spring Boot project structure
* REST API development
* Database integration with JPA
* Transaction management using `@Transactional`
* Rollback mechanism

---

## 💡 Future Enhancements

* Add validation (no negative balance)
* Add exception handling
* Add authentication (Spring Security)
* Build frontend UI

---

## 👨‍💻 Author

**Swapnil Sharma**
Computer Science Engineering Student

---

## ⭐ Note

This project is built for learning purposes to understand **real-world transaction handling in backend systems**.
