# Employee Management System - Spring Boot

Welcome to the Employee Management System built with Spring Boot. This project provides a comprehensive solution for managing employee data, utilizing Spring Boot, MySQL, Thymeleaf, JPA, and other technologies.

## 🚀 Features

- **Employee CRUD Operations:** Manage employees with Create, Read, Update, and Delete operations.
- **Thymeleaf Templates:** Utilize Thymeleaf for server-side rendering and dynamic web pages.
- **JPA (Java Persistence API):** Simplify database operations with JPA for data persistence.
- **Spring Boot Web Server:** Serve the web application with the embedded Spring Boot web server.
- **RESTful API:** Expose APIs for seamless integration with other systems.

## 🛠️ Technologies Used

- **Spring Boot:** Accelerate development with the Spring framework.
- **MySQL:** Relational database for persistent storage.
- **Thymeleaf:** Server-side Java template engine for dynamic web content.
- **Spring Data JPA:** Simplifies database operations and enhances data access.
- **Spring Web:** Building web applications with Spring.
- **Web Starter Kit:** Bootstrap your web development with essential tools.

## 🚦 Getting Started

### Step 1: Spring Initializer

Use the Spring Initializer to set up the project structure and dependencies:

1. Visit [Spring Initializer](https://start.spring.io/).
2. Choose the following configurations:
   - Project: `Maven Project`
   - Language: `Java`
   - Spring Boot: `2.5.3` (or the version you prefer)
   - Packaging: `Jar`
   - Dependencies:
     - `Spring Web`
     - `Thymeleaf`
     - `Spring Data JPA`
     - `MySQL Driver`
     - `Spring Boot DevTools` (optional, for development)

3. Click "Generate" to download the project archive.

### Step 2: Configure MySQL Database

1. Create a MySQL database for the project.
2. Update the `application.properties` file with your database configurations:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_database_username
   spring.datasource.password=your_database_password
Step 3: Run the Application
Import the project into your preferred IDE (e.g., IntelliJ, Eclipse).
Build and run the application.
Step 4: Access the Application
Open your browser and navigate to http://localhost:8080.

🌐 API Documentation
Explore the API endpoints and test them using Postman:

Base URL: http://localhost:8080/api/employees
GET All Employees: GET /
GET Employee by ID: GET /{id}
Add New Employee: POST /
Update Employee: PUT /{id}
Delete Employee: DELETE /{id}


📝 Thymeleaf Templates
For web-based interaction, navigate to the web application at http://localhost:8080.

🤝 Contributing
We welcome contributions! Feel free to submit issues or pull requests. Please follow our contribution guidelines.

# How it looks

![image](https://i.imgur.com/IVFwvXc.png)

![image](https://i.imgur.com/4HtlQrh.png)


# Details

You can see details of how to make a blog with this code. (https://satoruakiyama.com/blog/building-an-application-with-spring-boot)

# Author

https://github.com/prth1234

