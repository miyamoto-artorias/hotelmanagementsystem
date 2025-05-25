package Controllers.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Controllers.DbUtils;
import Controllers.conn;

public class EmployeeDAO {
    
    private conn connection;
    
    public EmployeeDAO() {
        connection = new conn();
    }
    
    public TableModel getEmployeesByJob(String jobTitle) {
        try {
            String query = "select * from Employee where job = '" + jobTitle + "'";
            ResultSet rs = connection.s.executeQuery(query);
            return DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public TableModel getAllEmployees() {
        try {
            String query = "select * from Employee";
            ResultSet rs = connection.s.executeQuery(query);
            return DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void loadManagerDataToTable(JTable table) {
        try {
            table.setModel(getEmployeesByJob("Manager"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadAllEmployeeDataToTable(JTable table) {
        try {
            table.setModel(getAllEmployees());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
