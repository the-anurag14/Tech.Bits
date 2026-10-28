# 🏥 Hospital Management System (HMS)

A complete Hospital Management System web application built using **Java (JSP, Servlets, JDBC)**, **MySQL**, and **HTML5/CSS3/JavaScript**, following the MVC architecture.

---

## 📋 Overview

The main objective of this Hospital Management System is to streamline hospital administrative activities, staff management, patient records, and appointment scheduling online.

The application supports three primary user roles:
1. 👨‍⚕️ **Doctor**: Check appointments, view patient records and schedules.
2. 🛠️ **Admin**: Full administrative privileges to add, update, view, and delete Doctors, Receptionists, Patients, and Appointments.
3. 👩‍💼 **Receptionist**: Manage appointments, register and edit patient records.

---

## 🛠️ Technology Stack

- **Frontend**: JSP (JavaServer Pages), HTML5, CSS3, JavaScript
- **Backend**: Java Servlets, JDBC, DAO Pattern
- **Database**: MySQL
- **Build Tool / IDE**: Apache Ant / NetBeans / Eclipse
- **Server**: Apache Tomcat 8.5+

---

## 📂 Project Structure

```bash
Tech.Bits/
├── hospital.sql                  # MySQL database schema and sample data
├── build.xml                     # Ant build configuration
├── nbproject/                    # NetBeans project configuration
├── src/
│   └── java/
│       ├── Controller/           # Servlets (Login, Register, Add/Update records)
│       ├── Database/             # Database connection manager (JDBC)
│       └── dao/                  # Data Access Objects (User, Patient, Doctor, Appointment)
└── web/                          # JSP pages, assets, stylesheets, and scripts
    ├── css/                      # Stylesheets
    ├── fonts/                    # Font assets
    ├── img/                      # UI illustrations and images
    ├── js/                       # Client-side scripts
    └── *.jsp                     # Views (AdminHome, UserHome, addDoctor, etc.)
```

---

## ⚙️ Setup & Installation

### 1. Database Setup
1. Open MySQL (Command Line, MySQL Workbench, or phpMyAdmin).
2. Create and import the database:
   ```sql
   CREATE DATABASE hospital;
   USE hospital;
   SOURCE hospital.sql;
   ```
3. Check `src/java/Database/DatabaseConnection.java` and verify your MySQL credentials:
   ```java
   String url = "jdbc:mysql://localhost:3306/hospital";
   String user = "your_mysql_username";
   String password = "your_mysql_password";
   ```

### 2. Deploy on Apache Tomcat
1. Clone the repository:
   ```bash
   git clone https://github.com/the-anurag14/Tech.Bits.git
   ```
2. Open the project in **NetBeans** or **Eclipse** as a Web Application project.
3. Add the **MySQL Connector / J** (`mysql-connector-java.jar`) to the project libraries.
4. Add your **Apache Tomcat** server runtime.
5. Clean & Build the project, then click **Run**.
6. Access the application in your browser:
   ```
   http://localhost:8080/Tech.Bits/
   ```

---

## 👨‍💻 Author

**Anurag Kumar**  
GitHub: [@the-anurag14](https://github.com/the-anurag14)
