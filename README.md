# Library Management System (Java + JDBC + MySQL)

## Overview

A backend-focused Library Management System developed using Java, JDBC, and MySQL following layered architecture principles.

The project implements authentication, CRUD operations, issue-return workflow, inventory management, transaction handling, and fine calculation while following DAO and Service Layer architecture.

This project was built to strengthen backend engineering fundamentals and simulate real-world business logic handling.

---

# Features

## Authentication System

* User Registration
* User Login
* Role-based user field (ADMIN / MEMBER)

---

## Book Management

* Add Book
* View Books
* Search Books
* Update Book
* Delete Book

---

## Issue & Return System

* Issue books to users
* Return issued books
* Due date handling
* Fine calculation for overdue returns
* Inventory quantity management

---

## Backend Engineering Concepts Implemented

* JDBC Connectivity
* DAO Pattern
* Service Layer Architecture
* Transaction Management
* Prepared Statements
* Multi-table Relationships
* Business Logic Separation
* Inventory Management
* Fine Calculation Logic

---

# Tech Stack

## Backend

* Java
* JDBC
* MySQL

## Architecture

* DAO Pattern
* Service Layer Architecture

## Tools

* IntelliJ IDEA
* Git
* GitHub

---

# Project Structure

```text
LibraryManagementSystem/
│
├── src/
│   ├── dao/
│   │   ├── BookDAO.java
│   │   ├── UserDAO.java
│   │   └── IssuedBookDAO.java
│   │
│   ├── database/
│   │   └── DBConnection.java
│   │
│   ├── main/
│   │   └── Main.java
│   │
│   ├── model/
│   │   ├── Book.java
│   │   ├── User.java
│   │   └── IssuedBook.java
│   │
│   └── service/
│       └── IssuedBookService.java
│
├── .gitignore
└── README.md
```

---

# Database Design

## users Table

```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    role VARCHAR(20)
);
```

---

## books Table

```sql
CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    genre VARCHAR(50),
    isbn VARCHAR(50),
    quantity INT DEFAULT 1
);
```

---

## issued_books Table

```sql
CREATE TABLE issued_books (
    id INT PRIMARY KEY AUTO_INCREMENT,

    user_id INT,
    book_id INT,

    issue_date DATE,
    due_date DATE,
    return_date DATE,

    fine DOUBLE DEFAULT 0,
    status VARCHAR(20) DEFAULT 'ISSUED',

    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(book_id) REFERENCES books(id)
);
```

---

# Transaction Handling

JDBC transactions are implemented during book issuing to maintain database consistency.

Example:

```java
conn.setAutoCommit(false);
conn.commit();
conn.rollback();
```

This prevents inconsistent updates when multiple database operations are performed together.

---

# Architecture Flow

```text
Main
 ↓
Service Layer
 ↓
DAO Layer
 ↓
Database
```

---

# Sample Workflow

## Book Issue Flow

```text
User enters Book ID
↓
System checks quantity
↓
Issue record inserted
↓
Book quantity reduced
↓
Transaction committed
```

---

## Book Return Flow

```text
User enters Issue ID
↓
System checks return status
↓
Fine calculated if overdue
↓
Return date updated
↓
Book quantity increased
```

---

# Future Improvements

* Spring Boot Migration
* REST API Development
* JWT Authentication
* Password Hashing
* Logging System
* Exception Handling
* Admin Dashboard
* CSV/PDF Report Export
* AI-based Recommendation Features

---

# Learning Outcomes

This project helped strengthen understanding of:

* Java Backend Development
* JDBC
* MySQL Relationships
* Transactions
* Layered Architecture
* Backend Business Logic
* Service Layer Design
* Git & GitHub Workflow

---
# Screenshots

## Login

![Login](screenshots/login.png)

## Main Menu

![Menu](screenshots/menu.png)

## Add Book

![Add Book](screenshots/add-book.png)

## View Books

![View Books](screenshots/view-books.png)

# GitHub

This project is actively being improved with more backend features and Spring Boot migration planned in future updates.

---

# Author

Ayush Kulshreshtha

GitHub:
[https://github.com/Ayush0612005](https://github.com/Ayush0612005)
