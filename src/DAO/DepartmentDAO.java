package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Controllers.DbUtils;
import Controllers.conn;

public class DepartmentDAO {
    
    private conn connection;
    
    public DepartmentDAO() {
        connection = new conn();
    }
    
    public TableModel getAllDepartments() {
        try {
            String query = "select * from Department";
            ResultSet rs = connection.s.executeQuery(query);
            return DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void loadDepartmentDataToTable(JTable table) {
        try {
            table.setModel(getAllDepartments());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
