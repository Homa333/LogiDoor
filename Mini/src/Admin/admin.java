package Admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Proj.db_helper;

import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class admin {
	private static JFrame frame;
	private static JPanel panel;
	private static JTextField eField;
	private static JPasswordField pField;
	public static void main(String[] args) {
		frame=new JFrame("Admin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 465, 274);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.add(panel);
		panel.setLayout(null);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 76, 396, 10);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("LogiDoor Admin Login");
		lblNewLabel.setFont(new Font("Javanese Text", Font.BOLD, 22));
		lblNewLabel.setBounds(31, 29, 300, 32);
		panel.add(lblNewLabel);
		
		JLabel eLabel = new JLabel("Email:");
		eLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		eLabel.setBounds(31, 114, 49, 19);
		panel.add(eLabel);
		
		JLabel pLabel = new JLabel("Password:");
		pLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pLabel.setBounds(31, 154, 75, 19);
		panel.add(pLabel);
		
		eField = new JTextField();
		eField.setBounds(112, 113, 294, 22);
		eField.setColumns(10);
		panel.add(eField);
		
		
		pField = new JPasswordField();
		pField.setColumns(10);
		pField.setBounds(112, 153, 294, 22);
		panel.add(pField);
		
		JButton loBut = new JButton("Login");
		loBut.setBounds(309, 188, 97, 25);
		loBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ent) {
				String email= eField.getText().toString();
				String pass=pField.getText().toString();
				String sql = "Select Email,Password FROM admin where Email='"+email+"' && Password='"+pass+"';";
				   try (Connection conn = db_helper.getConnection();
				        Statement stmt  = conn.createStatement();
				        ResultSet rs    = stmt.executeQuery(sql)) {
				       if (rs.next()) {
				    	   frame.dispose();
							new adHome();
				       }
				       else {
							JOptionPane.showMessageDialog(null, "Not a valid Username and Password");
				       }
				   } catch (SQLException ex) {
				       System.out.println(ex.getMessage());
				   }
			}
		});
		panel.add(loBut);
		frame.setVisible(true);
	}
}
