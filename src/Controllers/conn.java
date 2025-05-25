package Controllers;

import java.sql.*;  
import Controllers.DatabaseUtil;

public class conn{
    public Connection c;
    public Statement s;
    public conn(){  
        try{  
            System.out.println("Attempting to create database connection via DatabaseUtil...");
            c = DatabaseUtil.getConnection();
            
            if (c != null) {
                System.out.println("Connection successful, creating statement...");
                s = c.createStatement();
                System.out.println("Statement created successfully");
            } else {
                System.out.println("Warning: Connection is null");
            }
           
        } catch(SQLException e){ 
            System.out.println("SQL Error in conn class:");
            e.printStackTrace();
        } catch(Exception e){ 
            System.out.println("Unexpected error in conn class:");
            e.printStackTrace();
        }  
    }  
}  

