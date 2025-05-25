@echo off
echo ===================================================
echo Hotel Management System - Complete Startup Script
echo ===================================================

set BASE_DIR=C:\Users\altya\Desktop\Hotel Management System
set MYSQL_JAR=%BASE_DIR%\lib\mysql-connector-j-8.3.0.jar
set BIN_DIR=%BASE_DIR%\bin
set SRC_DIR=%BASE_DIR%\src

echo Checking for MySQL Connector JAR...
if not exist "%MYSQL_JAR%" (
    echo ERROR: MySQL Connector JAR not found at %MYSQL_JAR%
    echo Please download it from https://dev.mysql.com/downloads/connector/j/
    pause
    exit /b 1
)

echo Creating bin directory if it doesn't exist...
if not exist "%BIN_DIR%" mkdir "%BIN_DIR%"

echo Setting up classpath...
set CLASSPATH=%MYSQL_JAR%;%SRC_DIR%;%BIN_DIR%

echo Compiling application...
javac -d "%BIN_DIR%" -cp "%CLASSPATH%" "%SRC_DIR%\Controllers\DatabaseUtil.java"
javac -d "%BIN_DIR%" -cp "%CLASSPATH%" "%SRC_DIR%\Controllers\JDBCTest.java"

echo Running JDBC test to verify connection...
java -cp "%CLASSPATH%" Controllers.JDBCTest

echo If the test was successful, press any key to continue launching the application...
pause

echo Compiling main application...
javac -d "%BIN_DIR%" -cp "%CLASSPATH%" "%SRC_DIR%\Views\Login.java"

echo Starting application...
java -cp "%CLASSPATH%" Views.Login

echo Application exited.
pause
