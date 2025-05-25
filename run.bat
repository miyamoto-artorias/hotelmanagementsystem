@echo off
set CLASSPATH=.;C:\Users\altya\Desktop\Hotel Management System\lib\mysql-connector-j-8.3.0.jar;C:\Users\altya\Desktop\Hotel Management System\src
cd C:\Users\altya\Desktop\Hotel Management System\src
javac -d ../bin Views/Login.java
cd ../bin
java Views.Login
