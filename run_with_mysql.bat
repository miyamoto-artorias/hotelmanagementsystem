@echo off
echo Running Hotel Management System with MySQL connector...

rem Set the base directory
set BASE_DIR=C:\Users\altya\Desktop\Hotel Management System

rem Include MySQL connector in the classpath
set CLASSPATH=%BASE_DIR%\lib\mysql-connector-j-8.3.0.jar;%BASE_DIR%\src;%BASE_DIR%\bin

rem Create bin directory if it doesn't exist
if not exist "%BASE_DIR%\bin" mkdir "%BASE_DIR%\bin"

rem Compile the application
echo Compiling application...
javac -d "%BASE_DIR%\bin" -cp "%CLASSPATH%" "%BASE_DIR%\src\Views\Login.java"

rem Run the application
echo Starting application...
java -cp "%CLASSPATH%;%BASE_DIR%\bin" Views.Login

echo Done!
pause
