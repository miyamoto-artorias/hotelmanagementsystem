package Controllers;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame {
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6;
    private JComboBox<String> comboBox;
    private JRadioButton r1, r2;
    private JButton b1, b2;

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }

    public AddEmployee() {
        setBounds(450, 200, 900, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        
        JLabel l10 = new JLabel("Add Employees Details");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(195, 24, 442, 35);
        contentPane.add(l10);

        JLabel l1 = new JLabel("Name");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 70, 102, 22);
        contentPane.add(l1);

        t1 = new JTextField();
        t1.setBounds(174, 70, 156, 20);
        contentPane.add(t1);

        JLabel l2 = new JLabel("Age");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 110, 102, 22);
        contentPane.add(l2);

        t2 = new JTextField();
        t2.setBounds(174, 110, 156, 20);
        contentPane.add(t2);

        JLabel l3 = new JLabel("Gender");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 150, 102, 22);
        contentPane.add(l3);

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setBounds(174, 150, 70, 22);
        contentPane.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setBounds(244, 150, 86, 22);
        contentPane.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel l4 = new JLabel("Job");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 190, 102, 22);
        contentPane.add(l4);

        String[] jobs = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        comboBox = new JComboBox<>(jobs);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(174, 190, 156, 20);
        contentPane.add(comboBox);

        JLabel l5 = new JLabel("Salary");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 230, 102, 22);
        contentPane.add(l5);

        t3 = new JTextField();
        t3.setBounds(174, 230, 156, 20);
        contentPane.add(t3);

        JLabel l6 = new JLabel("Phone");
        l6.setForeground(new Color(25, 25, 112));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(64, 270, 102, 22);
        contentPane.add(l6);

        t4 = new JTextField();
        t4.setBounds(174, 270, 156, 20);
        contentPane.add(t4);

        JLabel l7 = new JLabel("Aadhar");
        l7.setForeground(new Color(25, 25, 112));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(64, 310, 102, 22);
        contentPane.add(l7);

        t5 = new JTextField();
        t5.setBounds(174, 310, 156, 20);
        contentPane.add(t5);

        JLabel l8 = new JLabel("Email");
        l8.setForeground(new Color(25, 25, 112));
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        l8.setBounds(64, 350, 102, 22);
        contentPane.add(l8);

        t6 = new JTextField();
        t6.setBounds(174, 350, 156, 20);
        contentPane.add(t6);

        b1 = new JButton("Save");
        b1.setBounds(64, 420, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = t1.getText();
                String age = t2.getText();
                String gender = r1.isSelected() ? "Male" : "Female";
                String job = (String) comboBox.getSelectedItem();
                String salary = t3.getText();
                String phone = t4.getText();
                String aadhar = t5.getText();
                String email = t6.getText();

                try {
                    conn c = new conn();
                    String str = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + aadhar + "', '" + email + "')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(198, 420, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        contentPane.add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/add.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410, 80, 480, 410);
        contentPane.add(image);

        contentPane.setBackground(Color.GRAY);
    }
}
