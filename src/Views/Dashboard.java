package Views;

import java.awt.*;
import javax.swing.*;

import Controllers.AddDrivers;
import Controllers.AddEmployee;
import Controllers.AddRoom;

import java.awt.event.*;

public class Dashboard extends JFrame {

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setForeground(Color.CYAN);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/hotel/management/system/icons/dash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel newLabel = new JLabel(i3);

        newLabel.setBounds(0, 0, 800, 700);
        add(newLabel);

                JLabel hotelManagementSystem = new JLabel(" Welcomes ", JLabel.CENTER);
        hotelManagementSystem.setForeground(Color.DARK_GRAY);
        hotelManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
        
        hotelManagementSystem.setBounds(-20, -250, 800, 700);
        hotelManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
        hotelManagementSystem.setVerticalAlignment(SwingConstants.CENTER);
        
        newLabel.add(hotelManagementSystem);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu hotelSystem = new JMenu("HOTEL MANAGEMENT");
        hotelSystem.setForeground(Color.DARK_GRAY);
        menuBar.add(hotelSystem);

        JMenuItem reception = new JMenuItem("RECEPTION");
        hotelSystem.add(reception);

        JMenu adminSystem = new JMenu("ADMIN");
        adminSystem.setForeground(Color.DARK_GRAY);
        menuBar.add(adminSystem);

        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        adminSystem.add(addEmployee);

        addEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddEmployee().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem addRoom = new JMenuItem("ADD ROOMS");
        adminSystem.add(addRoom);

        addRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddRoom().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        reception.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Reception();
            }
        });

        JMenuItem addDrivers = new JMenuItem("ADD DRIVERS");
        adminSystem.add(addDrivers);

        addDrivers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddDrivers().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(800, 700);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
