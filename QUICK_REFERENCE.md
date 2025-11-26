# QUICK REFERENCE CARD

## 🚀 DEPLOYMENT IN 6 STEPS

```
Step 1: Download Tomcat 9.0.70
        https://tomcat.apache.org/download-90.cgi
        
Step 2: Extract to C:\apache-tomcat-9.0.70
        
Step 3: Create database (run in MySQL):
        CREATE DATABASE employee_db;
        CREATE TABLE employees (
            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(100),
            email VARCHAR(100),
            salary DECIMAL(10,2)
        );
        
Step 4: Update password in:
        src/connection/DBConnect.java
        Change: "YOUR_PASSWORD" → your real password
        
Step 5: Deploy project:
        xcopy /E /I C:\Users\hp\Downloads\emp 
        C:\apache-tomcat-9.0.70\webapps\emp
        
Step 6: Start Tomcat & Access:
        C:\apache-tomcat-9.0.70\bin\startup.bat
        http://localhost:8080/emp
```

---

## 📁 PROJECT STRUCTURE

```
emp/
├── src/servlet/           5 Servlets
├── src/dao/              1 DAO class
├── src/model/            Employee model
├── src/connection/       DB connection
├── web/*.jsp             4 JSP pages
├── web/WEB-INF/          Servlet config
├── bin/                  Compiled classes
├── pom.xml              Maven config
└── Documentation/        8 guide files
```

---

## 🔗 ENDPOINTS

```
GET  /emp/                    Home
GET  /emp/view-employees      List
GET  /emp/add-employee-page   Add form
POST /emp/add-employee        Create
GET  /emp/edit-employee?id=1  Edit form
POST /emp/edit-employee       Update
GET  /emp/delete-employee?id=1 Delete
```

---

## 🛠️ COMMANDS

```
# Start Tomcat
C:\apache-tomcat-9.0.70\bin\startup.bat

# Stop Tomcat
C:\apache-tomcat-9.0.70\bin\shutdown.bat

# View Logs
C:\apache-tomcat-9.0.70\logs\catalina.out

# Check Status
http://localhost:8080/

# Access App
http://localhost:8080/emp
```

---

## ✅ VERIFICATION CHECKLIST

```
Database:
  ☐ MySQL running
  ☐ employee_db exists
  ☐ employees table created

Code:
  ☐ All Java files compiled
  ☐ JSP files created
  ☐ web.xml configured

Deployment:
  ☐ Tomcat installed
  ☐ emp folder in webapps/
  ☐ Password updated in DBConnect.java
  ☐ Tomcat started

Testing:
  ☐ http://localhost:8080/emp loads
  ☐ View Employees works
  ☐ Add Employee works
  ☐ Edit Employee works
  ☐ Delete Employee works
```

---

## 🐛 TROUBLESHOOTING

```
404 Not Found:
  1. Check: $TOMCAT_HOME/webapps/emp exists
  2. Restart Tomcat
  3. Clear browser cache (Ctrl+Shift+Delete)

Database Connection Failed:
  1. Verify MySQL is running
  2. Check password in DBConnect.java
  3. Verify database name is "employee_db"

Blank Page / 500 Error:
  1. Check logs: $TOMCAT_HOME/logs/catalina.out
  2. Verify all classes compiled
  3. Restart Tomcat

Servlets Not Found:
  1. Check web.xml has all mappings
  2. Verify servlet class paths
  3. Rebuild and redeploy
```

---

## 📚 DOCUMENTATION FILES

| File | Purpose |
|------|---------|
| INDEX.md | Overview of all docs |
| START_HERE.md | Quick introduction |
| DEPLOYMENT.md | Detailed steps |
| QUICK_FIX.md | Common fixes |
| CHECKLIST.md | Pre-launch check |
| README.md | Full reference |
| DEPLOYMENT_SUMMARY.md | Complete summary |
| FIXED.md | What was fixed |

---

## 💾 DATABASE SCHEMA

```sql
employees table:
┌────┬─────────┬────────────┬────────┐
│ id │ name    │ email      │ salary │
├────┼─────────┼────────────┼────────┤
│ 1  │ John    │ john@...   │ 50000  │
│ 2  │ Jane    │ jane@...   │ 55000  │
└────┴─────────┴────────────┴────────┘
```

---

## 🎯 KEY FEATURES

✅ Create - Add employees
✅ Read - View employee list
✅ Update - Edit employee info
✅ Delete - Remove employees
✅ Database - MySQL persistence
✅ Web - Responsive JSP UI
✅ Security - Prepared statements

---

## 📊 QUICK STATS

```
Java Classes:       8 files ✅
JSP Pages:          4 files ✅
Configuration:      6 files ✅
Documentation:      8 files ✅
Total Lines Code:   ~1,000 ✅
Compilation Status: SUCCESS ✅
Errors:             ZERO ✅
```

---

## 🎓 TECH STACK

```
Java 11+
├── Servlets (HTTP handlers)
├── JSP (View layer)
└── JDBC (Database)

MySQL Database
├── Connection
├── Queries
└── Data Persistence

Tomcat 9.0
├── Servlet Container
├── JSP Engine
└── HTTP Server
```

---

## ⏱️ TIMING

```
Download Tomcat:     5 min
Setup Database:      5 min
Configure Password:  2 min
Deploy Project:      2 min
Start Tomcat:        1 min
────────────────────────
Total:              15 min
```

---

**Status: READY TO DEPLOY! 🚀**

Last Updated: November 26, 2025
Project: Employee Management System
