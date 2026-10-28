# 🏥 Hospital Management System (HMS)

A complete, production-ready Hospital Management System web application built using **Java (JSP, Servlets, JDBC)**, **MySQL**, and **HTML5/Bootstrap**, following the MVC architecture.

---

## 📋 System Overview

The Hospital Management System streamlines hospital administrative operations, doctor schedules, patient records, and receptionist workflows.

### 👥 User Roles & Features:
1. 👨‍⚕️ **Admin Portal** (`/adminLogin.jsp`):
   - **Doctor Management**: Add new doctors, browse all doctors with live search, delete doctors.
   - **Receptionist Management**: Add and delete hospital receptionists with contact details.
   - **Worker Management**: Add and delete hospital support staff.
   - **Patient Management**: Register new patients, edit existing patient records, search and delete patient files.
   - **Live Statistics Dashboard**: Real-time counts of active patients, doctors, receptionists, and workers.
2. 👤 **User / Staff Portal** (`/index.jsp`):
   - User account registration & secure authentication.
   - Add patient records and browse active patient directories.

---

## 🛠️ Technology Stack

- **Frontend**: JSP (JavaServer Pages), Bootstrap 4, FontAwesome, JavaScript (jQuery)
- **Backend**: Java Servlets 3.1+ (MVC Pattern)
- **Database**: MySQL 5.7+ / 8.x (via JDBC PreparedStatement)
- **Dependencies**: Included in `web/WEB-INF/lib/` (MySQL Connector/J 8.0, Servlet API, JSTL)
- **Build Tools**: Apache Maven (`pom.xml`) & Apache Ant / NetBeans / Eclipse

---

## 📂 Project Architecture

```bash
Tech.Bits/
├── hospital.sql                  # Complete MySQL schema & initial sample records
├── pom.xml                       # Standard Maven build configuration
├── build.xml                     # NetBeans/Ant build configuration
├── src/
│   └── java/
│       ├── Controller/           # Servlets (Login, Register, Add, Update, Delete)
│       │   ├── AdminLogin.java
│       │   ├── AdminRegister.java
│       │   ├── UserLogin.java
│       │   ├── UserRegister.java
│       │   ├── AddDoctor.java
│       │   ├── AddPatient.java
│       │   ├── AddRecp.java
│       │   ├── AddWorker.java
│       │   └── updatePatient.java
│       ├── Database/
│       │   └── DatabaseConnection.java  # JDBC Connection manager (MySQL 8+ compatible)
│       └── dao/                  # Data Access Objects
└── web/                          # JSP Views & Web Assets
    ├── WEB-INF/
    │   ├── web.xml               # Web deployment descriptor
    │   └── lib/                  # Bundled runtime JARs
    ├── AdminHome.jsp             # Admin analytics dashboard
    ├── UserHome.jsp              # User portal dashboard
    ├── adminDoctorList.jsp       # Doctor directory with live search & delete
    ├── adminPatientList.jsp      # Patient directory with edit & delete
    ├── adminRecpList.jsp         # Receptionist directory with delete
    ├── adminWorkerList.jsp       # Worker directory with delete
    ├── deleteDoctor.jsp          # Doctor deletion handler
    ├── deletePatient.jsp         # Patient deletion handler
    ├── deleteRecp.jsp            # Receptionist deletion handler
    ├── deleteWorker.jsp          # Worker deletion handler
    ├── updatePatient.jsp         # Patient record update form
    └── index.jsp                 # User login & landing page
```

---

## ⚙️ Setup & Deployment Guide

### 1. Database Setup
1. Start your local MySQL server.
2. Import `hospital.sql`:
   ```bash
   mysql -u root -p < hospital.sql
   ```
   *(Or open MySQL Workbench / phpMyAdmin and run `hospital.sql`)*

3. Configure Database Credentials:
   - Edit `src/java/Database/DatabaseConnection.java` (defaults: `user: root`, `pass: root`, `db: hospital`).
   - Or set environment variables:
     ```bash
     export DB_HOST=localhost
     export DB_PORT=3306
     export DB_NAME=hospital
     export DB_USER=root
     export DB_PASS=your_password
     ```

### 2. Build & Deploy

#### Option A: Run in IntelliJ IDEA / Eclipse / NetBeans
1. Open the project folder in your IDE.
2. Configure **Apache Tomcat 8.5+** or **Tomcat 9/10**.
3. Deploy `Tech.Bits` as a Web Application / WAR artifact.
4. Run server and access:
   ```
   http://localhost:8080/Tech.Bits/
   ```

#### Option B: Build with Maven
```bash
mvn clean package
```
Generates `target/HospitalManagementSystem.war`, which you can drop directly into Tomcat's `webapps/` folder.

---

## 👨‍💻 Author

**Anurag Kumar**  
GitHub: [@the-anurag14](https://github.com/the-anurag14)
