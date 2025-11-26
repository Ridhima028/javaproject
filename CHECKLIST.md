# Pre-Deployment Checklist ✅

Complete these items before accessing the application:

## 1. Database Setup
- [ ] MySQL Server is installed and running
- [ ] Execute `database-setup.sql` to create database and table
- [ ] Verify database exists: `SHOW DATABASES;`
- [ ] Verify table exists: `USE employee_db; SHOW TABLES;`

## 2. Update Database Credentials
- [ ] Open `src/connection/DBConnect.java`
- [ ] Update MySQL username (if not `root`)
- [ ] Update MySQL password (change `YOUR_PASSWORD`)
- [ ] Save the file

## 3. Project Building
- [ ] Open project in VS Code or Eclipse
- [ ] Build project (Ctrl+Shift+B in VS Code)
- [ ] Verify no compilation errors appear
- [ ] All 5 servlets compile successfully
- [ ] All 4 JSP files are valid

## 4. Tomcat Installation
- [ ] Apache Tomcat 9.0+ is installed
- [ ] Tomcat is NOT currently running
- [ ] Note the Tomcat installation path:
  ```
  Example: C:\apache-tomcat-9.0.70
  ```

## 5. Deployment
Choose ONE method:

### Method A: Automatic Script
- [ ] Edit `deploy.bat` and set correct TOMCAT_HOME path
- [ ] Run `deploy.bat` (double-click)
- [ ] Wait for script to complete
- [ ] Tomcat will start automatically

### Method B: Manual Copy
- [ ] Stop Tomcat if running
- [ ] Delete old deployment:
  - Remove `$TOMCAT_HOME/webapps/emp` folder
  - Remove `$TOMCAT_HOME/work/Catalina/localhost/emp` folder
- [ ] Copy entire `emp` project folder to `$TOMCAT_HOME/webapps/`
- [ ] Start Tomcat: `$TOMCAT_HOME/bin/startup.bat`

### Method C: IDE Deployment
- [ ] In Eclipse/VS Code, right-click project
- [ ] Select "Run on Server"
- [ ] Choose Tomcat from server list
- [ ] Click "Finish"

## 6. Verification
- [ ] Wait 10-30 seconds for Tomcat to start
- [ ] Open browser to: `http://localhost:8080/emp`
- [ ] Should see "Employee Management System" home page
- [ ] Click "View Employees" - should load (empty or with sample data)
- [ ] Click "Add New Employee" - should show form
- [ ] Fill form and submit - should redirect to employee list

## 7. Test All Features
- [ ] Add new employee - check if saved
- [ ] View employees list - check if employee appears
- [ ] Click Edit - verify form loads with data
- [ ] Update employee - check if changes saved
- [ ] Click Delete - verify deletion works
- [ ] Check database directly in MySQL:
  ```sql
  USE employee_db;
  SELECT * FROM employees;
  ```

## 8. Troubleshooting
If any step fails:

### 404 Error
- [ ] Verify Tomcat is running: `http://localhost:8080/`
- [ ] Check if `emp` folder exists in `webapps/`
- [ ] Check file `webapps/emp/index.jsp` exists
- [ ] Clean deployment (delete and copy again)
- [ ] Restart Tomcat

### Database Connection Error
- [ ] Verify MySQL is running: `mysql -u root -p`
- [ ] Check database: `USE employee_db;`
- [ ] Check table: `SHOW TABLES;`
- [ ] Verify credentials in `DBConnect.java`
- [ ] Check MySQL port (default 3306)

### Servlet Errors (500 Internal Server Error)
- [ ] Check Tomcat logs: `logs/catalina.out`
- [ ] Rebuild project
- [ ] Verify all servlets are in `src/servlet/` folder
- [ ] Verify `web.xml` has correct servlet mappings

### JSP Blank Page
- [ ] Check Tomcat logs
- [ ] Verify JSP files are in `web/` folder
- [ ] Clear browser cache (Ctrl+Shift+Delete)
- [ ] Restart Tomcat

---

## File Structure Verification

```
emp/
├── src/
│   ├── connection/DBConnect.java ................ ✅
│   ├── dao/EmployeeDAO.java .................... ✅
│   ├── model/employee.java ..................... ✅
│   ├── servlet/
│   │   ├── AddEmployeeServlet.java ............. ✅
│   │   ├── AddEmployeePageServlet.java ......... ✅
│   │   ├── ViewEmployeesServlet.java ........... ✅
│   │   ├── EditEmployeeServlet.java ............ ✅
│   │   └── DeleteEmployeeServlet.java .......... ✅
│   └── lib/
│       ├── servlet-api.jar ..................... ✅
│       └── jsp-api.jar ......................... ✅
├── web/
│   ├── index.jsp .............................. ✅
│   ├── view-employees.jsp ..................... ✅
│   ├── add-employee.jsp ....................... ✅
│   ├── edit-employee.jsp ...................... ✅
│   └── WEB-INF/
│       └── web.xml ............................ ✅
├── .classpath ................................ ✅
├── .project .................................. ✅
├── .settings/
│   ├── org.eclipse.jdt.core.prefs ............. ✅
│   ├── org.eclipse.wst.common.component ....... ✅
│   └── org.eclipse.wst.common.project.facet.core.xml ✅
├── .vscode/
│   └── settings.json .......................... ✅
├── pom.xml ................................... ✅
└── deploy.bat ................................ ✅
```

---

## Quick Command Reference

```bash
# MySQL
mysql -u root -p
USE employee_db;
SELECT * FROM employees;

# Tomcat Start/Stop
$TOMCAT_HOME/bin/startup.bat      # Start
$TOMCAT_HOME/bin/shutdown.bat     # Stop

# Build (VS Code)
Ctrl+Shift+B

# Build (Eclipse)
Project → Build Project

# Application URL
http://localhost:8080/emp
```

---

## Success Indicators ✅

You know everything is working when you see:

1. ✅ Application loads at `http://localhost:8080/emp`
2. ✅ Home page displays with navigation buttons
3. ✅ "View Employees" shows a list or "No employees found"
4. ✅ "Add New Employee" form appears when clicked
5. ✅ Adding an employee works without errors
6. ✅ New employee appears in the list
7. ✅ Edit button loads form with existing data
8. ✅ Delete button removes employee
9. ✅ Database shows all changes in MySQL

---

## Contact & Support

If you get stuck:

1. Check the relevant `.md` file:
   - `QUICK_FIX.md` - Common issues
   - `DEPLOYMENT.md` - Deployment steps
   - `README.md` - Full documentation
   - `SETUP_GUIDE.md` - Setup information

2. Check Tomcat logs:
   ```
   $TOMCAT_HOME/logs/catalina.out
   ```

3. Verify all prerequisites are installed:
   - JDK 11+
   - MySQL 5.7+
   - Tomcat 9.0+

Good luck! 🚀 You've got this! 💪
