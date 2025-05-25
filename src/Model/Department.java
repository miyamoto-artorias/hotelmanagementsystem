package Model;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controllers.DbUtils;
import Controllers.DAO.DepartmentDAO;
import Views.Reception;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Department extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private DepartmentDAO departmentDAO;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Department frame = new Department();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void close() {
        this.dispose();
    }

    public Department() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout());
        lblNewLabel = new JLabel("Department");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panelTop.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Budget");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panelTop.add(lblNewLabel_1);

        contentPane.add(panelTop, BorderLayout.NORTH);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new FlowLayout());

        departmentDAO = new DepartmentDAO();
        
        // Load data automatically
        loadDepartmentData();
        
        JButton btnRefreshData = new JButton("Refresh Data");
        btnRefreshData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadDepartmentData();
            }
        });
        btnRefreshData.setBackground(Color.BLACK);
        btnRefreshData.setForeground(Color.WHITE);
        panelBottom.add(btnRefreshData);

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setBackground(Color.BLACK);
        btnNewButton_1.setForeground(Color.WHITE);
        panelBottom.add(btnNewButton_1);

        contentPane.add(panelBottom, BorderLayout.SOUTH);

        getContentPane().setBackground(Color.WHITE);
    }
    
    private void loadDepartmentData() {
        try {
            departmentDAO.loadDepartmentDataToTable(table);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading department data: " + e.getMessage());
        }
    }
}
