# Multi-Database Connection: H2 & MySQL  

## 📌 Overview  
This project demonstrates how to configure and connect a Spring Boot application to multiple databases—**H2 (in-memory)** and **MySQL**. The project is designed to manage separate data sources efficiently using **Spring Data JPA**.

## 🚀 Features  
- Supports **H2** (for in-memory testing) and **MySQL** (for persistent storage).  
- Uses **Spring Boot Data JPA** with separate **DataSources, EntityManagers, and TransactionManagers**.  
- Provides a structured approach for handling multiple databases in a single Spring Boot application.  

## ⚙️ Technologies Used  
- **Spring Boot**  
- **Spring Data JPA**  
- **H2 Database** (In-Memory)  
- **MySQL**  
- **Hibernate**  
- **Maven**  

## 🛠 Configuration  

### **1️⃣ MySQL Configuration**  
Ensure you have MySQL installed and running. Update the application properties (`application.yml` or `application.properties`) with the correct database credentials.  

#### **🔹 application.properties (MySQL Configuration)**
```properties
spring.datasource.mysql.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.mysql.username=root
spring.datasource.mysql.password=your_password
spring.datasource.mysql.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

### **2️⃣ H2 Database Configuration**  
H2 is an in-memory database that is useful for testing.  

#### **🔹 application.properties (H2 Configuration)**
```properties
spring.datasource.h2.url=jdbc:h2:mem:testdb
spring.datasource.h2.driver-class-name=org.h2.Driver
spring.datasource.h2.username=sa
spring.datasource.h2.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## 📌 Database Entity Setup  

### **MySQL Entity Example**
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
```

### **H2 Entity Example**
```java
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Double price;
}
```

## 🔥 Running the Project  
1. Clone the repository:  
   ```sh
   git clone https://github.com/Sahani199890/MultipleDBConnection.git
   cd your-repository
   ```

2. Update the **application.properties** file with your MySQL credentials.  

3. Run the application using Maven:  
   ```sh
   mvn spring-boot:run
   ```

4. Access the **H2 Console** (for testing):  
   ```
   http://localhost:8080/h2-console
   ```

## 🤝 Contributing  
Feel free to submit issues or pull requests if you'd like to improve this project.  

## 📜 License  
This project is licensed under the MIT License.  
