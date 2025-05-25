package Controllers.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Controllers.DbUtils;
import Controllers.conn;

public class DriverDAO {
    
    private conn connection;
    
    public DriverDAO() {
        connection = new conn();
    }
    
    public List<String> getAllBranches() {
        List<String> branches = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT branch FROM driver";
            ResultSet rs = connection.s.executeQuery(query);
            while (rs.next()) {
                branches.add(rs.getString("branch"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branches;
    }
    
    public TableModel getDriversByBranch(String branch) {
        try {
            String query = "SELECT * FROM driver WHERE branch = '" + branch + "'";
            ResultSet rs = connection.s.executeQuery(query);
            return DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void loadDriverDataToTable(JTable table, String branch) {
        try {
            table.setModel(getDriversByBranch(branch));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
