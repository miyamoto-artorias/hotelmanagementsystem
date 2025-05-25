package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controllers.conn;

public class CheckOutDAO {
    
    private conn connection;
    
    public CheckOutDAO() {
        connection = new conn();
    }
    
    public List<String> getAllCustomerNumbers() {
        List<String> customerNumbers = new ArrayList<>();
        try {
            String query = "select * from customer";
            ResultSet rs = connection.s.executeQuery(query);
            while (rs.next()) {
                customerNumbers.add(rs.getString("number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerNumbers;
    }
    
    public String getRoomNumberByCustomerNumber(String customerNumber) {
        try {
            String query = "select * from customer where number = '" + customerNumber + "'";
            ResultSet rs = connection.s.executeQuery(query);
            if (rs.next()) {
                return rs.getString("room_number").trim();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public boolean checkOutCustomer(String customerId, String roomNumber) {
        try {
            String deleteSQL = "DELETE FROM customer WHERE number = ?";
            String updateRoomSQL = "UPDATE room SET availability = 'Available' WHERE roomnumber = ?";
            
            PreparedStatement pst = connection.c.prepareStatement(deleteSQL);
            pst.setString(1, customerId);
            pst.executeUpdate();
            
            pst = connection.c.prepareStatement(updateRoomSQL);
            pst.setString(1, roomNumber);
            pst.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
