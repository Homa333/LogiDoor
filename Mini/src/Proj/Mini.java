package Proj;
import javax.swing.*;
import java.sql.*;
import java.awt.*;

import java.awt.event.*;
class start implements ActionListener{
	static String name,pass,ph;
	static JFrame frame;
	private static JLabel firstLabel,lastLabel,phLabel,midLabel,counLabel,cityLabel,emailLabel,passLabel,cPassLabel,label_1,label_2;
	private static JTextField fField,mField,lField,phField,counField,cityField,userField,midField,emailField;
	private static JPasswordField passField,cPassField;
	private static JButton lobut,newUser,sibut;
	private static JPanel panel;
	public static String fName,mName,lName,phNum,counName,cityName,email,password,cPassword,mainEmail;
	public void Signup()
	{
		panel = new JPanel();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 810, 545);
		frame.setTitle("LogiDoor-Signup");
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.setLayout(null);
		
		firstLabel = new JLabel("First name:* ");
		firstLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		firstLabel.setBounds(32, 32, 95, 28);
		panel.add(firstLabel);		
		midLabel = new JLabel("Middle name ");
		midLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		midLabel.setBounds(32, 75, 95, 28);
		panel.add(midLabel);
		
		lastLabel = new JLabel("Last name:*");
		lastLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lastLabel.setBounds(32, 119, 95, 28);
		panel.add(lastLabel);
				
		phLabel = new JLabel("Phone number:*");
		phLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		phLabel.setBounds(32, 160, 106, 28);
		panel.add(phLabel);		
		
		JComboBox<String> counCode = new JComboBox<String>();
		counCode.setBounds(173, 160, 55, 26);
		counCode.addItem("Code");
		counCode.addItem("+91");
		counCode.addItem("+977");
		counCode.addItem("+1");
		counCode.addItem("+81");
		panel.add(counCode);
		counCode.addActionListener(new ActionListener() {
			@Override
			 public void actionPerformed(ActionEvent e) {
				if(counCode.getSelectedItem().toString().compareTo("+91")==0) {
					counField.setText("India");
				}
				else if(counCode.getSelectedItem().toString().compareTo("+1")==0) {
					counField.setText("USA");
				}
				else if(counCode.getSelectedItem().toString().compareTo("+977")==0) {
					counField.setText("Nepal");
				}
				else if(counCode.getSelectedItem().toString().compareTo("+81")==0) {
					counField.setText("Korea");
				}
			}
		}
				);
		
		counLabel = new JLabel("Country:*");
		counLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		counLabel.setBounds(32, 203, 106, 28);
		panel.add(counLabel);
		
		cityLabel = new JLabel("City:*");
		cityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cityLabel.setBounds(32, 244, 106, 28);
		panel.add(cityLabel);
				
		emailLabel = new JLabel("Email:*");
		emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		emailLabel.setBounds(32, 284, 106, 28);
		panel.add(emailLabel);
		
		passLabel = new JLabel("Password:*");
		passLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passLabel.setBounds(32, 325, 106, 28);
		panel.add(passLabel);

		label_1 = new JLabel("@");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(321, 287, 15, 27);
		panel.add(label_1);
		
		
		label_2 = new JLabel(".com");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(435, 292, 42, 16);
		panel.add(label_2);	
		
		cPassLabel = new JLabel("Confirm Password:*");
		cPassLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cPassLabel.setBounds(32, 366, 133, 28);
		panel.add(cPassLabel);	
	
		fField = new JTextField();
		fField.setColumns(10);
		fField.setBounds(173, 33, 318, 28);
		panel.add(fField);

		mField = new JTextField();
		mField.setBounds(173, 76, 318, 28);
		panel.add(mField);
		mField.setColumns(10);
			
		lField = new JTextField();
		lField.setColumns(10);
		lField.setBounds(173, 120, 318, 28);
		panel.add(lField);
		
		counField = new JTextField();
		counField.setColumns(10);
		counField.setEditable(false);
		counField.setBounds(173, 203, 318, 28);
		panel.add(counField);

		phField = new JTextField();
		phField.setColumns(10);
		phField.setBounds(234, 160, 259, 28);
		panel.add(phField);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(173, 244, 318, 28);
		panel.add(cityField);
		
		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(173, 285, 142, 28);
		panel.add(userField);
		
		midField= new JTextField();
		midField.setColumns(10);
		midField.setBounds(345, 285, 85, 28);
		panel.add(midField);
		
		passField = new JPasswordField();
		passField.setColumns(10);
		passField.setBounds(173, 326, 318, 28);
		panel.add(passField);
		
		cPassField = new JPasswordField();
		cPassField.setColumns(10);
		cPassField.setBounds(173, 367, 318, 28);
		panel.add(cPassField);

		sibut= new JButton("Signup");
		sibut.setBounds(173, 417, 97, 25);
		sibut.addActionListener(new start());
		panel.add(sibut);
		frame.setVisible(true);
	}

	public void login() {
		panel=new JPanel();
		frame=new JFrame();
		frame.setSize(340,180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("LogiDoor-Login");
		frame.setLocationRelativeTo(null);
		panel.setBackground(new Color(201, 206, 212));
		frame.add(panel);
		panel.setLayout(null);
		emailLabel = new JLabel("Email:"); 
		emailLabel.setBounds(10, 20, 80, 25);
		panel.add(emailLabel);
		emailField=new JTextField();
		emailField.setBounds(100, 20, 200, 30);
		panel.add(emailField);
		passLabel = new JLabel("Password:");
		passLabel.setBounds(10, 60, 80, 25);
		panel.add(passLabel);
		passField = new JPasswordField();
		passField.setBounds(100,60,200,30);
		panel.add(passField);
		lobut=new JButton("Login");
		lobut.setBounds(10, 100, 100, 25);
		lobut.addActionListener(new start());
		panel.add(lobut);
		newUser =new JButton("New User");
		newUser.setBounds(120, 100, 100, 25);
		newUser.addActionListener(this);
		panel.add(newUser);
		frame.setVisible(true);
		
	}
	public void  data(int a){
		String email = emailField.getText();
		@SuppressWarnings("deprecation")
		String passw = passField.getText();
		String sql = "Select fname,email,pass FROM userdata where email='"+email+"' && pass='"+passw+"';";
	   try (Connection conn = db_helper.getConnection();
	        Statement stmt  = conn.createStatement();
	        ResultSet rs    = stmt.executeQuery(sql)) {
	       if (rs.next()) {
	    	   String user = rs.getString(1);
	    	   mainEmail=rs.getString(2);
	    	   frame.dispose();
				new Home(user);
	       }
	       else {
				JOptionPane.showMessageDialog(null, "Not a valid Username and Password");
	       }
	   } catch (SQLException ex) {
	       System.out.println(ex.getMessage());
	   }
	}
	@SuppressWarnings("deprecation")
	public void data(char b) {
		fName=fField.getText();	
		mName=mField.getText();
		lName =lField.getText();
		phNum = phField.getText();
		counName=counField.getText();
		cityName=cityField.getText();
		email=(userField.getText().toString())+"@"+ midField.getText().toString()+".com";
		password=passField.getText();
		cPassword = cPassField.getText();
		if((fName.isBlank())||(lName.isBlank())||(phNum.isBlank())||(counName.isBlank())||(cityName.isBlank())||(email.isBlank())||password.isBlank()||cPassword.isBlank()) {
			JOptionPane.showMessageDialog(null, "Information incomplete");	
		}
		else
		{
			if(password.toString().compareTo(cPassword)!=0) {
				JOptionPane.showMessageDialog(null, "Password Doesn't Match");
			}
			else 
			{
				String sql="Select email FROM userdata;";
				try {
					Connection con= db_helper.getConnection();
					Statement smt=con.createStatement();
					ResultSet rs = smt.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					int userEx=0;
					int columnsNumber = rsmd.getColumnCount();
					while (rs.next()) {
					    for (int i = 1; i <= columnsNumber; i++) {
					        String columnValue = rs.getString(i);
					        if(columnValue.compareTo(email)==0) {
					        	userEx=1;
					        }
					    }
					    System.out.println("");
					}
					if(userEx==0) {
						JOptionPane.showMessageDialog(null, "Signup successful");
						new db_helper();
						insertCandidate(fName,mName,lName,phNum,counName,cityName,email,password);
						frame.dispose();	
						login();
					}
					else 
						JOptionPane.showMessageDialog(null, "Email Already Exist");
				}
				catch(SQLException e) {
					System.out.println(e);
				}
			}
		}			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newUser) {
			frame.dispose();
			Signup();
		}
		else if(e.getSource() == lobut) {
			
			data(1);
		}
		else if(e.getSource() == sibut) {
			data('a');
		}
	}
	public static int insertCandidate(String fName,String mName,String lName,String phNum,String counName,String cityName,String email,String password) {
	
		ResultSet rs = null;
		int candidateId = 0;
		String sql = "INSERT INTO userdata(fname,midname,lname,phnum,country,city,pass,email)"
		+ "VALUES(?,?,?,?,?,?,?,?)";
		
		try (Connection conn = db_helper.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, fName);
			pstmt.setString(2, mName);
			pstmt.setString(3, lName);
			pstmt.setString(4, phNum);
			pstmt.setString(5, counName);
			pstmt.setString(6, cityName);
			pstmt.setString(7, password);
			pstmt.setString(8, email);
			
			int rowAffected = pstmt.executeUpdate();
			if(rowAffected == 1)
			{
				rs = pstmt.getGeneratedKeys();
			if(rs.next())
				candidateId = rs.getInt(1);
			
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} 
		finally {
			try {
				if(rs != null)  rs.close();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return candidateId;
	}
}

public class Mini
{
	public static void main(String []args) {
		start si = new start();
		si.login();
	}
}
