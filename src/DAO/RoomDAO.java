package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Controllers.DbUtils;
import Controllers.conn;

public class RoomDAO {
    
    private conn connection;
    
    public RoomDAO() {
        connection = new conn();
    }
    
    public TableModel getAllRooms() {
        try {
            String query = "select * from room";
            ResultSet rs = connection.s.executeQuery(query);
            return DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void loadRoomDataToTable(JTable table) {
        try {
            table.setModel(getAllRooms());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
