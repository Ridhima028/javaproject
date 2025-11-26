import java.io.*;
import java.util.*;

public class DeploymentGuide {
    public static void main(String[] args) throws Exception {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("EMPLOYEE MANAGEMENT SYSTEM - DEPLOYMENT GUIDE");
        System.out.println("=".repeat(60) + "\n");
        
        System.out.println("Since Tomcat is not installed, here are your options:\n");
        
        System.out.println("OPTION 1: Download & Install Tomcat (Recommended)");
        System.out.println("-".repeat(60));
        System.out.println("1. Download Tomcat 9.0.70 from:");
        System.out.println("   https://tomcat.apache.org/download-90.cgi");
        System.out.println("   (Binary Distributions → Windows zip)\n");
        
        System.out.println("2. Extract to C:\\ (will create C:\\apache-tomcat-9.0.70)");
        System.out.println("   - Right-click tomcat.zip → Extract All");
        System.out.println("   - Or: tar xzf tomcat.zip\n");
        
        System.out.println("3. Copy emp project to webapps:");
        System.out.println("   xcopy /E /I C:\\Users\\hp\\Downloads\\emp");
        System.out.println("   C:\\apache-tomcat-9.0.70\\webapps\\emp\n");
        
        System.out.println("4. Start Tomcat:");
        System.out.println("   C:\\apache-tomcat-9.0.70\\bin\\startup.bat\n");
        
        System.out.println("5. Access application:");
        System.out.println("   http://localhost:8080/emp\n");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("OPTION 2: Use IDE (Eclipse/IntelliJ/VS Code)");
        System.out.println("-".repeat(60));
        System.out.println("1. Install Eclipse IDE (includes Tomcat plugin)");
        System.out.println("2. Import project into Eclipse");
        System.out.println("3. Right-click project → Run on Server");
        System.out.println("4. Select Apache Tomcat from list");
        System.out.println("5. Application opens automatically\n");
        
        System.out.println("=".repeat(60));
        System.out.println("DATABASE SETUP (Both Options)");
        System.out.println("-".repeat(60));
        System.out.println("Before deploying, setup your database:\n");
        System.out.println("1. Open MySQL Command Line or MySQL Workbench");
        System.out.println("2. Copy-paste content from: database-setup.sql");
        System.out.println("3. Execute the SQL script\n");
        
        System.out.println("Expected output:");
        System.out.println("   Query OK, 1 row affected (database created)");
        System.out.println("   Query OK, 0 rows affected (table created)\n");
        
        System.out.println("=".repeat(60));
        System.out.println("CONFIGURATION BEFORE DEPLOYING");
        System.out.println("-".repeat(60));
        System.out.println("Edit: src/connection/DBConnect.java");
        System.out.println("Change line 15 from:");
        System.out.println("   \"YOUR_PASSWORD\"");
        System.out.println("To your actual MySQL password:\n");
        System.out.println("Example:");
        System.out.println("   conn = DriverManager.getConnection(");
        System.out.println("       \"jdbc:mysql://localhost:3306/employee_db\",");
        System.out.println("       \"root\",");
        System.out.println("       \"your_password_here\"");
        System.out.println("   );\n");
        
        System.out.println("=".repeat(60));
        System.out.println("PROJECT STRUCTURE VERIFICATION");
        System.out.println("-".repeat(60));
        
        File empDir = new File("C:\\Users\\hp\\Downloads\\emp");
        System.out.println("\n✅ Project Location:");
        System.out.println("   " + empDir.getAbsolutePath());
        System.out.println("   Status: " + (empDir.exists() ? "EXISTS ✓" : "NOT FOUND ✗"));
        
        File srcDir = new File(empDir, "src");
        System.out.println("\n✅ Source Code:");
        System.out.println("   " + new File(srcDir, "servlet").exists() + " - 5 Servlets");
        System.out.println("   " + new File(srcDir, "dao").exists() + " - DAO Layer");
        System.out.println("   " + new File(srcDir, "model").exists() + " - Employee Model");
        System.out.println("   " + new File(srcDir, "connection").exists() + " - DB Connection");
        
        File webDir = new File(empDir, "web");
        System.out.println("\n✅ Web Content:");
        System.out.println("   " + new File(webDir, "index.jsp").exists() + " - Home Page");
        System.out.println("   " + new File(webDir, "view-employees.jsp").exists() + " - Employee List");
        System.out.println("   " + new File(webDir, "add-employee.jsp").exists() + " - Add Form");
        System.out.println("   " + new File(webDir, "edit-employee.jsp").exists() + " - Edit Form");
        System.out.println("   " + new File(new File(webDir, "WEB-INF"), "web.xml").exists() + " - Web Config");
        
        File binDir = new File(empDir, "bin");
        System.out.println("\n✅ Compiled Classes:");
        System.out.println("   " + binDir.exists() + " - bin/ directory exists");
        System.out.println("   " + new File(binDir, "model").exists() + " - model/*.class");
        System.out.println("   " + new File(binDir, "dao").exists() + " - dao/*.class");
        System.out.println("   " + new File(binDir, "servlet").exists() + " - servlet/*.class");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("WHAT HAPPENS AFTER DEPLOYMENT");
        System.out.println("-".repeat(60));
        System.out.println("1. Browser opens to http://localhost:8080/emp");
        System.out.println("2. You see the home page with navigation");
        System.out.println("3. Click 'View Employees' to see the list (empty initially)");
        System.out.println("4. Click 'Add New Employee' to add first employee");
        System.out.println("5. Fill form and submit");
        System.out.println("6. Employee appears in the list");
        System.out.println("7. You can now Edit or Delete employees\n");
        
        System.out.println("=".repeat(60));
        System.out.println("TROUBLESHOOTING");
        System.out.println("-".repeat(60));
        System.out.println("Error: 404 Not Found");
        System.out.println("  → Verify emp folder is in $TOMCAT_HOME/webapps/");
        System.out.println("  → Check if Tomcat is running\n");
        
        System.out.println("Error: Database Connection Failed");
        System.out.println("  → Verify MySQL is running");
        System.out.println("  → Check password in DBConnect.java");
        System.out.println("  → Verify employee_db database exists\n");
        
        System.out.println("Error: Blank Page");
        System.out.println("  → Check Tomcat logs: logs/catalina.out");
        System.out.println("  → Refresh browser cache (Ctrl+Shift+Delete)\n");
        
        System.out.println("=".repeat(60));
        System.out.println("QUICK COMMANDS");
        System.out.println("-".repeat(60));
        System.out.println("Stop Tomcat:");
        System.out.println("  C:\\apache-tomcat-9.0.70\\bin\\shutdown.bat\n");
        
        System.out.println("View Tomcat logs:");
        System.out.println("  C:\\apache-tomcat-9.0.70\\logs\\catalina.out\n");
        
        System.out.println("Check if Tomcat is running:");
        System.out.println("  http://localhost:8080/\n");
        
        System.out.println("=".repeat(60));
        System.out.println("NEXT STEPS");
        System.out.println("-".repeat(60));
        System.out.println("\n✅ Step 1: Download Tomcat 9.0.70");
        System.out.println("✅ Step 2: Extract to C:\\apache-tomcat-9.0.70");
        System.out.println("✅ Step 3: Create database (run database-setup.sql)");
        System.out.println("✅ Step 4: Update password in DBConnect.java");
        System.out.println("✅ Step 5: Copy emp folder to webapps/");
        System.out.println("✅ Step 6: Start Tomcat (startup.bat)");
        System.out.println("✅ Step 7: Open http://localhost:8080/emp");
        System.out.println("✅ Step 8: Test the application!\n");
        
        System.out.println("=".repeat(60));
        System.out.println("For more details, check these files:");
        System.out.println("  • QUICK_FIX.md");
        System.out.println("  • DEPLOYMENT.md");
        System.out.println("  • README.md");
        System.out.println("  • CHECKLIST.md");
        System.out.println("=".repeat(60) + "\n");
    }
}
