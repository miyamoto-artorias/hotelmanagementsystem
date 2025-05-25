package Model;
import Controllers.DbUtils;
import Controllers.DAO.RoomDAO;
import Views.Reception;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Room extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel lblAvailability;
    private JLabel lblCleanStatus;
    private JLabel lblPrice;
    private JLabel lblBedType;
    private JLabel lblRoomNumber;
    private RoomDAO roomDAO;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Room frame = new Room();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Room() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/adding.jpg"));
        Image i3 = i1.getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500, -60, 550, 600);
        contentPane.add(l1);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 480, 400);
        contentPane.add(scrollPane);

        roomDAO = new RoomDAO();
        
        // Initialize with data automatically
        loadRoomData();

        JButton btnRefreshData = new JButton("Refresh Data");
        btnRefreshData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadRoomData();
            }
        });
        btnRefreshData.setBounds(100, 470, 120, 30);
        btnRefreshData.setBackground(Color.BLACK);
        btnRefreshData.setForeground(Color.WHITE);
        contentPane.add(btnRefreshData);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton.setBounds(290, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        lblRoomNumber = new JLabel("Room Number");
        lblRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRoomNumber.setBounds(20, 15, 90, 14);
        contentPane.add(lblRoomNumber);

        lblAvailability = new JLabel("Availability");
        lblAvailability.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblAvailability.setBounds(120, 15, 69, 14);
        contentPane.add(lblAvailability);

        lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCleanStatus.setBounds(220, 15, 76, 14);
        contentPane.add(lblCleanStatus);

        lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPrice.setBounds(330, 15, 46, 14);
        contentPane.add(lblPrice);

        lblBedType = new JLabel("Bed Type");
        lblBedType.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblBedType.setBounds(420, 15, 76, 14);
        contentPane.add(lblBedType);

        getContentPane().setBackground(Color.WHITE);
    }
    
    private void loadRoomData() {
        try {
            roomDAO.loadRoomDataToTable(table);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading room data: " + e.getMessage());
        }
    }
}
