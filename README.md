# Employee Management System

A JDBC and JSP-based employee management system for managing employee records.

## Project Structure

```
emp/
├── src/
│   ├── connection/
│   │   └── DBConnect.java          # Database connection class
│   ├── dao/
│   │   └── EmployeeDAO.java         # Data Access Object for employees
│   ├── model/
│   │   └── employee.java            # Employee model class
│   ├── servlet/
│   │   ├── AddEmployeeServlet.java      # Servlet to add employees
│   │   ├── AddEmployeePageServlet.java  # Servlet to show add form
│   │   ├── ViewEmployeesServlet.java    # Servlet to list employees
│   │   ├── EditEmployeeServlet.java     # Servlet to edit employees
│   │   └── DeleteEmployeeServlet.java   # Servlet to delete employees
│   └── lib/
│       ├── servlet-api.jar
│       └── jsp-api.jar
├── web/
│   ├── index.jsp                   # Home page
│   ├── view-employees.jsp          # List all employees
│   ├── add-employee.jsp            # Add employee form
│   ├── edit-employee.jsp           # Edit employee form
│   └── WEB-INF/
│       └── web.xml                 # Web application configuration
├── .classpath                      # Eclipse classpath configuration
├── .project                        # Eclipse project configuration
├── pom.xml                         # Maven configuration
└── README.md                       # This file

```

## Features

✅ **View Employees** - Display all employees in a table format  
✅ **Add Employee** - Add new employees to the system  
✅ **Edit Employee** - Update existing employee information  
✅ **Delete Employee** - Remove employees from the system  
✅ **Database Integration** - Uses JDBC to connect to MySQL  
✅ **Responsive UI** - User-friendly JSP pages with CSS styling  

## Prerequisites

- **Java 11+** (JDK)
- **MySQL Server** (running on localhost:3306)
- **Tomcat Server** (or any servlet container)
- **Maven** (optional, for dependency management)

## Database Setup

### 1. Create Database and Table

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

### 2. Update Database Credentials

Edit `src/connection/DBConnect.java` and update:
- Database URL: `jdbc:mysql://localhost:3306/employee_db`
- Username: `root` (change if different)
- Password: `YOUR_PASSWORD` (update with your MySQL password)

```java
conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/employee_db",
    "root",
    "YOUR_PASSWORD"
);
```

## Running the Application

### Option 1: Using Tomcat

1. **Build the Project** (if using Maven)
   ```bash
   mvn clean package
   ```

2. **Deploy to Tomcat**
   - Copy the project folder to Tomcat's `webapps` directory
   - Restart Tomcat server

3. **Access the Application**
   - Open browser and go to: `http://localhost:8080/emp`

### Option 2: Using Eclipse IDE

1. Import the project as an existing Java project
2. Right-click on project → Run as → Run on Server
3. Select Tomcat server and click Finish
4. Application will open in your browser

## API Endpoints

| Method | URL Pattern | Description |
|--------|------------|-------------|
| GET | `/view-employees` | Display all employees |
| GET | `/add-employee-page` | Show add employee form |
| POST | `/add-employee` | Add new employee |
| GET | `/edit-employee?id=1` | Show edit form for employee |
| POST | `/edit-employee` | Update employee |
| GET | `/delete-employee?id=1` | Delete employee |

## DAO Methods

### EmployeeDAO Class

- `addEmployee(employee emp)` - Add a new employee
- `getAllEmployees()` - Get list of all employees
- `getEmployeeById(int id)` - Get specific employee
- `updateEmployee(employee emp)` - Update employee details
- `deleteEmployee(int id)` - Delete employee

## Notes

- The application uses MVC (Model-View-Controller) architecture
- All database operations are performed using prepared statements for security
- The system uses JDBC for database connectivity
- JSP is used for the presentation layer

## Troubleshooting

**Issue**: "Cannot resolve symbol DBConnect"
- **Solution**: Make sure `.vscode/settings.json` contains the library references

**Issue**: "Cannot connect to database"
- **Solution**: Verify MySQL is running and credentials are correct in `DBConnect.java`

**Issue**: "Servlet not found"
- **Solution**: Ensure `web.xml` is properly configured with servlet mappings

## License

This project is open source and available for educational purposes.
