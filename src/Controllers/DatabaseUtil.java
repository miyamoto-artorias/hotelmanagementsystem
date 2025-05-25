package Controllers;

import java.sql.*;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Logger;

/**
 * A utility class for managing database connections with explicit driver loading.
 * This class attempts multiple methods to load the MySQL JDBC driver.
 */
public class DatabaseUtil {
    
    static {
        try {
            // Try multiple methods to load the driver
            loadDriverUsingClasspath();
        } catch (Exception e) {
            System.err.println("Failed to load MySQL driver: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Attempts to load the MySQL JDBC driver using the standard classpath approach.
     */
    private static void loadDriverUsingClasspath() {
        try {
            System.out.println("Attempting to load MySQL JDBC driver from classpath...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC driver loaded successfully from classpath!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found in classpath.");
            
            // If loading from classpath fails, try direct JAR loading
            try {
                loadDriverFromJar();
            } catch (Exception e2) {
                System.err.println("Failed to load driver from JAR: " + e2.getMessage());
            }
        }
    }
    
    /**
     * Attempts to load the MySQL JDBC driver directly from the JAR file.
     */
    private static void loadDriverFromJar() throws Exception {
        String jarPath = "C:/Users/altya/Desktop/Hotel Management System/lib/mysql-connector-j-8.3.0.jar";
        System.out.println("Attempting to load MySQL JDBC driver from JAR: " + jarPath);
        
        File file = new File(jarPath);
        if (!file.exists()) {
            System.err.println("MySQL connector JAR not found at: " + jarPath);
            return;
        }
        
        // Create a URL class loader and load the driver
        URLClassLoader classLoader = new URLClassLoader(new URL[]{file.toURI().toURL()});
        Class<?> driverClass = Class.forName("com.mysql.cj.jdbc.Driver", true, classLoader);
        
        // Register the driver
        Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();
        DriverManager.registerDriver(new DriverShim(driver));
        
        System.out.println("MySQL JDBC driver loaded successfully from JAR!");
    }
    
    /**
     * Creates a connection to the database.
     */
    public static Connection getConnection() throws SQLException {
        try {
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotelmanagementsystem", 
                "root", 
                ""
            );
            System.out.println("Connected to database successfully!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Helper class to wrap a dynamically loaded JDBC driver.
     */
    private static class DriverShim implements Driver {
        private Driver driver;
        
        DriverShim(Driver driver) {
            this.driver = driver;
        }
        
        public boolean acceptsURL(String url) throws SQLException {
            return driver.acceptsURL(url);
        }
        
        public Connection connect(String url, java.util.Properties info) throws SQLException {
            return driver.connect(url, info);
        }
        
        public int getMajorVersion() {
            return driver.getMajorVersion();
        }
        
        public int getMinorVersion() {
            return driver.getMinorVersion();
        }
        
        public DriverPropertyInfo[] getPropertyInfo(String url, java.util.Properties info) throws SQLException {
            return driver.getPropertyInfo(url, info);
        }
        
        public boolean jdbcCompliant() {
            return driver.jdbcCompliant();
        }
        
        public Logger getParentLogger() {
            try {
                return driver.getParentLogger();
            } catch (SQLException e) {
                return null;
            }
        }
    }
}
