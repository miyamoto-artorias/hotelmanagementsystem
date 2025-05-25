package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Controllers.DbUtils;
import Controllers.conn;

public class CustomerDAO {
    
    private conn connection;
    
    public CustomerDAO() {
        connection = new conn();
    }
    
    public TableModel getAllCustomers() {
        try {
            String query = "select * from Customer";
            ResultSet rs = connection.s.executeQuery(query);
            return DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void loadCustomerDataToTable(JTable table) {
        try {
            table.setModel(getAllCustomers());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
