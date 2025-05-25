package Views;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Controllers.DbUtils;
import Controllers.DAO.DriverDAO;

public class PickUp extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private Choice c1;
    private DriverDAO driverDAO;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PickUp frame = new PickUp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PickUp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Initialize the DriverDAO
        driverDAO = new DriverDAO();

        JLabel lblPickUpService = new JLabel("Pick Up Service");
        lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPickUpService.setBounds(90, 11, 158, 25);
        contentPane.add(lblPickUpService);

        JLabel lblTypeOfCar = new JLabel("Type of Car");
        lblTypeOfCar.setBounds(32, 97, 89, 14);
        contentPane.add(lblTypeOfCar);

        c1 = new Choice();
        c1.setBounds(123, 94, 150, 25);
        contentPane.add(c1);

        JLabel lblInfo = new JLabel("Name");
        lblInfo.setBounds(24, 208, 46, 14);
        contentPane.add(lblInfo);

        JButton btnRegister = new JButton("Display");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String branch = c1.getSelectedItem();
                driverDAO.loadDriverDataToTable(table, branch);
            }
        });
        btnRegister.setBounds(200, 500, 120, 30);
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setForeground(Color.WHITE);
        contentPane.add(btnRegister);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(420, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(24, 233, 750, 250);
        contentPane.add(scrollPane);

        JLabel lblNewLabel = new JLabel("Age");
        lblNewLabel.setBounds(165, 208, 46, 14);
        contentPane.add(lblNewLabel);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(264, 208, 46, 14);
        contentPane.add(lblGender);

        JLabel lblTypeOfDriver = new JLabel("Company");
        lblTypeOfDriver.setBounds(366, 208, 80, 14);
        contentPane.add(lblTypeOfDriver);

        JLabel lblDateOfThe = new JLabel("Brand");
        lblDateOfThe.setBounds(486, 208, 105, 14);
        contentPane.add(lblDateOfThe);

        JLabel lblAirport = new JLabel("Available");
        lblAirport.setBounds(600, 208, 86, 14);
        contentPane.add(lblAirport);

        JLabel lblAvailable = new JLabel("Location");
        lblAvailable.setBounds(700, 208, 73, 14);
        contentPane.add(lblAvailable);

        getContentPane().setBackground(Color.WHITE);
        populateChoice();
        
        // Load initial data automatically if there are branches available
        if (c1.getItemCount() > 0) {
            driverDAO.loadDriverDataToTable(table, c1.getItem(0));
        }
    }

    private void populateChoice() {
        List<String> branches = driverDAO.getAllBranches();
        for (String branch : branches) {
            c1.add(branch);
        }
    }
}
