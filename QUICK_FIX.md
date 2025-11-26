# Quick Fix for "404 Not Found" Error

The error you're seeing means Tomcat cannot find the application. This is likely because the project wasn't deployed properly or Tomcat doesn't see the correct file structure.

## Immediate Fix (3 Steps)

### Step 1: Update MySQL Credentials
Open `src/connection/DBConnect.java` and update:

```java
conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/employee_db",
    "root",
    "YOUR_ACTUAL_PASSWORD"  // ← Change this
);
```

### Step 2: Setup Database
Run this SQL in MySQL:

```sql
CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);
```

### Step 3: Deploy to Tomcat

**Option A: Automatic (Windows)**
1. Update `deploy.bat` with your Tomcat path
2. Run: `deploy.bat`
3. Wait for Tomcat to start (10-30 seconds)
4. Open: `http://localhost:8080/emp`

**Option B: Manual**
1. Stop Tomcat
2. Copy entire `emp` folder to `$TOMCAT_HOME/webapps/`
3. Start Tomcat
4. Open: `http://localhost:8080/emp`

---

## If 404 Still Appears

### Method 1: Clean Deployment
```bash
# Stop Tomcat first, then:
rmdir /s /q "C:\apache-tomcat-9.0.70\webapps\emp"
rmdir /s /q "C:\apache-tomcat-9.0.70\work\Catalina\localhost\emp"

# Copy the project folder
xcopy /E /I c:\Users\hp\Downloads\emp C:\apache-tomcat-9.0.70\webapps\emp

# Start Tomcat and wait 15 seconds
# Then open: http://localhost:8080/emp
```

### Method 2: Verify Deployment
1. Check if Tomcat is running: `http://localhost:8080/`
2. Check if emp app is deployed:
   - File exists: `$TOMCAT_HOME/webapps/emp/index.jsp`
   - Or: `$TOMCAT_HOME/webapps/emp/WEB-INF/web.xml`
3. Check Tomcat logs: `$TOMCAT_HOME/logs/catalina.out`

### Method 3: Using IDE
If using Eclipse or VS Code:
1. Right-click project → Run on Server
2. Select Tomcat from list
3. Click Finish
4. Browser should open automatically

---

## Required Files Verification

Check that these files exist:

**Web Content:**
- ✅ `web/index.jsp`
- ✅ `web/view-employees.jsp`
- ✅ `web/add-employee.jsp`
- ✅ `web/edit-employee.jsp`
- ✅ `web/WEB-INF/web.xml`

**Java Classes:**
- ✅ `src/servlet/ViewEmployeesServlet.java`
- ✅ `src/servlet/AddEmployeeServlet.java`
- ✅ `src/servlet/EditEmployeeServlet.java`
- ✅ `src/servlet/DeleteEmployeeServlet.java`
- ✅ `src/servlet/AddEmployeePageServlet.java`
- ✅ `src/dao/EmployeeDAO.java`
- ✅ `src/model/employee.java`
- ✅ `src/connection/DBConnect.java`

---

## Common Issues & Fixes

| Issue | Fix |
|-------|-----|
| 404 Not Found | Clean deployment, restart Tomcat |
| Database error | Check MySQL credentials in DBConnect.java |
| Blank page | Check Tomcat logs for errors |
| File not found in browser | Verify web.xml servlet mappings |

---

## Still Not Working?

1. **Verify Tomcat is running:**
   ```
   http://localhost:8080/manager/html
   ```

2. **Check Tomcat version (needs 9.0+):**
   ```
   $TOMCAT_HOME/bin/version.bat
   ```

3. **View Tomcat errors:**
   ```
   $TOMCAT_HOME/logs/catalina.out
   ```

4. **Rebuild project in IDE:**
   - VS Code: `Ctrl+Shift+B`
   - Eclipse: Right-click → Build Project

---

Once deployed successfully, you should see the home page:

```
┌──────────────────────────────────────┐
│  Welcome to Employee Management      │
│                                       │
│  [View Employees]  [Add New Employee]│
└──────────────────────────────────────┘
```

Good luck! 🚀
