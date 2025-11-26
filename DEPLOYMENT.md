# Deployment Instructions

## To Fix the 404 Error

The project structure has been configured correctly. Follow these steps to deploy:

### Step 1: Clear Previous Deployment
1. Stop Tomcat server
2. Delete the `emp` folder from `$TOMCAT_HOME/webapps/`
3. Delete `emp.war` if it exists in `$TOMCAT_HOME/webapps/`

### Step 2: Rebuild the Project
In VS Code or Eclipse:
- **VS Code**: Press `Ctrl+Shift+B` to build
- **Eclipse**: Right-click project → Build Project

### Step 3: Deploy to Tomcat

#### Option A: Copy Project Folder
```bash
# Windows Command Prompt
xcopy /E /I "c:\Users\hp\Downloads\emp" "%TOMCAT_HOME%\webapps\emp"
```

#### Option B: Create WAR File (Recommended)
```bash
# Using Maven
cd c:\Users\hp\Downloads\emp
mvn clean package

# Copy the generated WAR file to Tomcat
copy target\emp-app-1.0-SNAPSHOT.war %TOMCAT_HOME%\webapps\emp.war
```

### Step 4: Start Tomcat
- Navigate to `$TOMCAT_HOME/bin/`
- Run: `startup.bat` (Windows)

### Step 5: Access Application
Open your browser and go to:
```
http://localhost:8080/emp
```

---

## Troubleshooting

### Error: "The requested URL /emp was not found"
**Solution:**
1. Make sure Tomcat is running: `http://localhost:8080/manager/html`
2. Check if `emp` application is deployed and started
3. If not, manually copy the project folder to `$TOMCAT_HOME/webapps/`

### Error: "404 Not Found - /emp"
**Solutions:**
1. Delete `$TOMCAT_HOME/webapps/emp` folder completely
2. Delete `$TOMCAT_HOME/work/Catalina/localhost/emp` folder
3. Restart Tomcat
4. Copy the `emp` project folder to `$TOMCAT_HOME/webapps/` again

### Error: Database Connection Failed
1. Ensure MySQL is running
2. Check credentials in `src/connection/DBConnect.java`
3. Verify database `employee_db` exists
4. Run the `database-setup.sql` file

### Servlet Not Found (404)
1. Verify `web/WEB-INF/web.xml` exists and has correct servlet mappings
2. Check servlet names match the `<servlet-class>` paths
3. Rebuild and redeploy the project

---

## Project Structure After Deployment

Tomcat will expand the application as follows:
```
$TOMCAT_HOME/webapps/emp/
├── index.jsp
├── view-employees.jsp
├── add-employee.jsp
├── edit-employee.jsp
├── WEB-INF/
│   ├── web.xml
│   └── classes/
│       ├── servlet/
│       │   └── *.class files
│       ├── dao/
│       │   └── *.class files
│       ├── model/
│       │   └── *.class files
│       └── connection/
│           └── *.class files
```

---

## Quick Deployment Checklist

- [ ] MySQL server is running
- [ ] Database `employee_db` exists with `employees` table
- [ ] Tomcat server is installed
- [ ] `DBConnect.java` has correct MySQL credentials
- [ ] Project built successfully (no compile errors)
- [ ] All 5 servlets and 4 JSP files are created
- [ ] `web.xml` exists with servlet mappings
- [ ] `.settings` folder contains Eclipse WDT configuration

Once all boxes are checked, redeploy and refresh your browser!
