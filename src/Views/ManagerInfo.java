/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import DAO.EmployeeDAO;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ManagerInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblJob;
	private JLabel lblName;
	private JLabel lblDepartment;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerInfo frame = new ManagerInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}
	
	public ManagerInfo() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(430, 200, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		contentPane.add(table);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(450, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblJob = new JLabel("Age");
		lblJob.setBounds(159, 11, 46, 14);
		contentPane.add(lblJob);
		
		lblName = new JLabel("Gender");
		lblName.setBounds(273, 11, 46, 14);
		contentPane.add(lblName);
		
		lblDepartment = new JLabel("Job");
		lblDepartment.setBounds(416, 11, 86, 14);
		contentPane.add(lblDepartment);
                
                JLabel l1 = new JLabel("Salary");
		l1.setBounds(536, 11, 86, 14);
		contentPane.add(l1);
                
                JLabel l2 = new JLabel("Phone");
		l2.setBounds(656, 11, 86, 14);
		contentPane.add(l2);
                
                JLabel l3 = new JLabel("Aadhar");
		l3.setBounds(786, 11, 86, 14);
		contentPane.add(l3);
                
                JLabel l4 = new JLabel("Gmail");
		l4.setBounds(896, 11, 86, 14);
		contentPane.add(l4);
                
                getContentPane().setBackground(Color.WHITE);
                
                // Load manager data automatically when the view is opened
                EmployeeDAO employeeDAO = new EmployeeDAO();
                employeeDAO.loadManagerDataToTable(table);
	}
}