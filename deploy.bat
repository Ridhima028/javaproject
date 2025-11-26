@echo off
REM Deploy script for Employee Management System
REM This script builds the project and deploys it to Tomcat

setlocal enabledelayedexpansion

REM Set your Tomcat home directory here
set TOMCAT_HOME=C:\apache-tomcat-9.0.70

REM Check if Tomcat path is set
if not exist "%TOMCAT_HOME%" (
    echo Error: TOMCAT_HOME not found at %TOMCAT_HOME%
    echo Please update the TOMCAT_HOME variable in this script
    pause
    exit /b 1
)

echo.
echo ======================================
echo Employee Management System Deployer
echo ======================================
echo.

REM Stop Tomcat
echo [1/5] Stopping Tomcat...
taskkill /FI "WINDOWTITLE eq Tomcat*" /T /F 2>nul
timeout /t 2

REM Remove old deployment
echo [2/5] Cleaning previous deployment...
if exist "%TOMCAT_HOME%\webapps\emp" (
    rmdir /s /q "%TOMCAT_HOME%\webapps\emp"
    echo Removed old emp folder
)
if exist "%TOMCAT_HOME%\work\Catalina\localhost\emp" (
    rmdir /s /q "%TOMCAT_HOME%\work\Catalina\localhost\emp"
    echo Removed old work folder
)

REM Build the project
echo [3/5] Building project...
cd /d c:\Users\hp\Downloads\emp
call mvn clean package -q
if errorlevel 1 (
    echo Build failed!
    pause
    exit /b 1
)
echo Build successful!

REM Deploy the project
echo [4/5] Deploying to Tomcat...
xcopy /E /I /Q "c:\Users\hp\Downloads\emp" "%TOMCAT_HOME%\webapps\emp"
echo Deployment successful!

REM Start Tomcat
echo [5/5] Starting Tomcat...
start "" "%TOMCAT_HOME%\bin\startup.bat"

echo.
echo ======================================
echo Deployment Complete!
echo ======================================
echo.
echo Access the application at:
echo http://localhost:8080/emp
echo.
echo Note: Tomcat may take 10-30 seconds to fully start
pause
