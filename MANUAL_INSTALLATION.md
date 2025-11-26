# 📥 MANUAL TOMCAT INSTALLATION & DEPLOYMENT GUIDE

## Quick Summary
Since automatic download failed, follow these manual steps to get your application running.

---

## 🎯 OPTION 1: Quick Setup (Recommended - 15 minutes)

### Step 1: Download Tomcat (3 minutes)
```
1. Open browser and go to:
   https://tomcat.apache.org/download-90.cgi

2. Under "Binary Distributions", click:
   apache-tomcat-9.0.70-windows-x64.zip

3. Save to: C:\ (your C drive)
   File name will be: apache-tomcat-9.0.70-windows-x64.zip
```

### Step 2: Extract Tomcat (2 minutes)
```
1. Open File Explorer
2. Go to C:\ 
3. Right-click on: apache-tomcat-9.0.70-windows-x64.zip
4. Select: Extract All
5. Click "Extract"
   This creates: C:\apache-tomcat-9.0.70
```

### Step 3: Create Database (3 minutes)
```
1. Open MySQL Command Line or MySQL Workbench
2. Copy and paste this entire block:

CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);

3. Execute (press Enter or click Execute button)
```

### Step 4: Update Password (2 minutes)
```
1. Open: C:\Users\hp\Downloads\emp\src\connection\DBConnect.java
2. Find line 15 that says:
   "YOUR_PASSWORD"
3. Replace with your MySQL password
4. Save the file
```

### Step 5: Deploy Project (3 minutes)
```
1. Open Command Prompt
2. Run this command:

xcopy /E /I C:\Users\hp\Downloads\emp C:\apache-tomcat-9.0.70\webapps\emp

3. Press Enter and wait for "files copied"
```

### Step 6: Start Tomcat (1 minute)
```
1. Open Command Prompt
2. Run:
   C:\apache-tomcat-9.0.70\bin\startup.bat

3. Wait 10-15 seconds for Tomcat to start
```

### Step 7: Access Application (1 minute)
```
1. Open your web browser
2. Go to:
   http://localhost:8080/emp

3. You should see the Employee Management System homepage!
```

---

## 🔍 Verification Checklist

After each step, verify:

### After Extracting Tomcat:
```
Check if this folder exists:
C:\apache-tomcat-9.0.70\bin\
C:\apache-tomcat-9.0.70\webapps\
C:\apache-tomcat-9.0.70\logs\
```

### After Creating Database:
```
In MySQL, run:
SHOW DATABASES;

You should see: employee_db in the list
```

### After Deploying Project:
```
Check if folder exists:
C:\apache-tomcat-9.0.70\webapps\emp

And contains:
- index.jsp
- web/WEB-INF/web.xml
- src/ folder
```

### After Starting Tomcat:
```
Check:
1. Tomcat console window appears and doesn't close
2. No red error messages
3. Last line says something like "Server startup in X ms"
```

### After Opening Browser:
```
You should see:
- Page title: "Employee Management System"
- Two buttons: "View Employees" and "Add New Employee"
- Purple gradient background
```

---

## 🚨 Troubleshooting

### Problem: "Cannot find Tomcat"
**Solution:**
1. Make sure you extracted to C:\
2. Verify folder name is exactly: apache-tomcat-9.0.70
3. Check that bin/ folder exists inside it

### Problem: "404 Not Found"
**Solution:**
1. Check emp folder is in C:\apache-tomcat-9.0.70\webapps\
2. Verify index.jsp exists in webapps\emp\
3. Stop Tomcat (shutdown.bat)
4. Delete emp folder
5. Copy again with xcopy command
6. Restart Tomcat

### Problem: "Database Connection Failed"
**Solution:**
1. Check MySQL is running
2. Verify password in DBConnect.java is correct
3. Check employee_db database exists
4. Try connecting with: mysql -u root -p

### Problem: "Blank page" or error
**Solution:**
1. Check Tomcat logs:
   C:\apache-tomcat-9.0.70\logs\catalina.out
2. Restart Tomcat
3. Clear browser cache (Ctrl+Shift+Delete)
4. Try different browser (Chrome, Firefox, Edge)

### Problem: "Port 8080 in use"
**Solution:**
```
1. Open Command Prompt as Administrator
2. Run:
   netstat -ano | findstr :8080

3. Note the PID number
4. Run:
   taskkill /PID <number> /F
5. Try Tomcat again
```

---

## 🎯 What Happens Next

Once application loads at http://localhost:8080/emp:

### Home Page
```
Title: "Welcome to Employee Management System"
Two buttons:
  - View Employees
  - Add New Employee
```

### Click "View Employees"
```
Shows an empty table (no employees yet)
Buttons to add, edit, or delete
```

### Click "Add New Employee"
```
Form appears with fields:
  - Name
  - Email
  - Salary
Button: "Add Employee"
```

### Fill and Submit Form
```
Enter:
  Name: John Doe
  Email: john@example.com
  Salary: 50000

Click "Add Employee"
Redirects to employee list
John Doe appears in the table!
```

### Edit/Delete Buttons
```
Each employee has:
  - Edit button (blue) - modify details
  - Delete button (red) - remove employee
```

---

## 📋 Step-by-Step Visual Guide

```
Your Computer
    ↓
[1. Download Tomcat ZIP] → Save to C:\
    ↓
[2. Extract ZIP] → Creates C:\apache-tomcat-9.0.70\
    ↓
[3. Create MySQL Database] → employee_db ready
    ↓
[4. Update Password] → DBConnect.java configured
    ↓
[5. Copy emp Project] → To webapps\emp\
    ↓
[6. Start Tomcat] → startup.bat
    ↓
[7. Open Browser] → http://localhost:8080/emp
    ↓
APPLICATION RUNNING! 🚀
```

---

## ⏱️ Time Breakdown

```
Download Tomcat:        3 minutes
Extract:                2 minutes
Database Setup:         3 minutes
Update Password:        2 minutes
Deploy Project:         3 minutes
Start Tomcat:           1 minute
Open Browser:           1 minute
────────────────────────────────
TOTAL:                  15 minutes
```

---

## 📝 Commands Reference

### Copy Project
```batch
xcopy /E /I C:\Users\hp\Downloads\emp C:\apache-tomcat-9.0.70\webapps\emp
```

### Start Tomcat
```batch
C:\apache-tomcat-9.0.70\bin\startup.bat
```

### Stop Tomcat
```batch
C:\apache-tomcat-9.0.70\bin\shutdown.bat
```

### Access Application
```
http://localhost:8080/emp
```

### Test Tomcat
```
http://localhost:8080/
```

### MySQL Commands
```batch
mysql -u root -p
SHOW DATABASES;
USE employee_db;
SHOW TABLES;
SELECT * FROM employees;
```

---

## 🎓 What You're Installing

### Apache Tomcat
- Web server for Java applications
- Runs servlets and JSP files
- Listens on port 8080
- Free and open source

### MySQL Database
- Stores employee data
- Runs on port 3306
- Persists data between sessions

### Your Application
- 5 servlets handling requests
- 4 JSP pages for user interface
- DAO layer for database access
- MVC architecture

---

## ✅ Success Indicators

You'll know everything is working when:

```
✅ Tomcat console window stays open (no errors)
✅ Browser loads http://localhost:8080/emp
✅ You see purple home page with two buttons
✅ Click "View Employees" shows empty list
✅ Can add employee and see it in list
✅ Can edit employee details
✅ Can delete employee
✅ Refresh page - employee still there (persistence!)
```

---

## 🚀 Ready to Go!

Follow the 7 steps above and your Employee Management System will be running!

**All the files are already prepared in:**
```
C:\Users\hp\Downloads\emp\
```

**Just need to:**
1. Install Tomcat
2. Setup database
3. Update password
4. Deploy
5. Start Tomcat
6. Open browser

**That's it! Your application will be live!** 🎉

---

## 📞 Quick Help

**Need more details?** Check these files in C:\Users\hp\Downloads\emp\

- `QUICK_REFERENCE.md` - Command cheatsheet
- `DEPLOYMENT.md` - Detailed guide
- `QUICK_FIX.md` - Problem solutions
- `README.md` - Full reference

**Everything is ready!** Just follow the 7 steps above! 🚀
