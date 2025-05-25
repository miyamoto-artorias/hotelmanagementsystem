package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Controllers.conn;

public class LoginDAO {
    
    private conn connection;
    
    public LoginDAO() {
        System.out.println("Initializing LoginDAO...");
        connection = new conn();
        if (connection.s == null) {
            System.out.println("Warning: Statement object in LoginDAO is null");
        }
    }
    
    public boolean validateUser(String username, String password) {
        try {
            if (connection.s == null) {
                System.out.println("Error: Database connection is not available");
                return false;
            }
            
            String query = "select * from login where username='" + username + "' and password='" + password + "'";
            System.out.println("Executing query: " + query);
            
            ResultSet rs = connection.s.executeQuery(query);
            boolean result = rs.next();
            System.out.println("User validation result: " + (result ? "Success" : "Failed"));
            return result;
        } catch (SQLException e) {
            System.out.println("SQL Error during user validation:");
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.out.println("Unexpected error during user validation:");
            e.printStackTrace();
            return false;
        }
    }
}
