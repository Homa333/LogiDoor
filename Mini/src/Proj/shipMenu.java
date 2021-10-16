package Proj;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
interface  recur{
	public void recursion();
}
public class shipMenu implements recur {
		private JFrame frame;
		private JPanel panel;
		private JLabel pLabel;
		private JTextField nameField,cityField,streetField,preField,postField,emailField, phField,numPackField,wtField;
		private JComboBox<String> stateBox,counBox;
		@SuppressWarnings("unused")
		private static int i=0,serPrice,wtPrice,transPrice,packPrice,num,totPricew;
		private static String trackID,sName,sAdd,sEmail,sPhone,rName,rAdd,rEmail,rPhone,pack;
		private static String fromCoun,toCoun,wt,trans,ser,confCheck;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	shipMenu(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 622, 579);
		panel=new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		frame.setVisible(true);
		if(i==0)
			pLabel = new JLabel("where are you shipping the product from? ");
		else
			pLabel = new JLabel("where are you shipping the product to? ");
		pLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		pLabel.setBounds(0, 36, 604, 66);
		panel.add(pLabel);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		nameLabel.setBounds(36, 115, 55, 21);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(149, 115, 301, 21);
		nameField.setColumns(10);
		nameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(nameField);
		
		
		JLabel addrLabel = new JLabel("Address:");
		addrLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		addrLabel.setBounds(36, 155, 65, 21);
		panel.add(addrLabel);
		
		stateBox = new JComboBox<String>();
		stateBox.setModel(new DefaultComboBoxModel(new String[] {"State"}));
		stateBox.setForeground(Color.BLACK);
		stateBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		stateBox.setBackground(Color.WHITE);
		stateBox.setBounds(149, 190, 301, 22);
		panel.add(stateBox);
		
		counBox = new JComboBox<String>();
		counBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		counBox.setModel(new DefaultComboBoxModel(new String[] {"Country", "India", "America", "Nepal", "South Korea"}));
		counBox.setBackground(Color.WHITE);
		counBox.setForeground(Color.BLACK);
		counBox.setBounds(149, 155, 301, 22);
		panel.add(counBox);
		counBox.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				if (counBox.getSelectedItem().toString().equals("India")) {
					stateBox.setModel(new DefaultComboBoxModel(new String[] {"State",
							"Jammu and Kashmir",
							"Punjab",
							"Himachal Pradesh",
							"Haryana",
							"Delhi",
							"Rajasthan",
							"Uttar Pradesh",
							"Uttarakhand",
							"Madhya Pradesh",
							"Chattisgarh",
							"Gujarat",
							"Maharashtra",
							"Karnataka",
							"Goa",
							"Kerala",
							"Tamil nadu",
							"Andhra pradesh",
							"Telangana",
							"Orissa",
							"Bihar",
							"Jharkhand",
							"West Bengal",
							"Assam",
							"Arunach Pradesh",
							"Sikkim",
							"Meghalaya",
							"Mizoram",
							"Nagaland",
							"Tripura"}));
				}
				else if(counBox.getSelectedItem().toString().equals("America")) {
					stateBox.setModel(new DefaultComboBoxModel(new String[] {"State",
							"Alabama",
							"Alaska",
							"Arizona",
							"Arkansas",
							"California",
							"Colorado",
							"Connecticut",
							"Delaware",
							"Florida",
							"Georgia",
							"Hawaii",
							"Idaho",
							"IllinoisIndiana",
							"Iowa",
							"Kansas",
							"Kentucky",
							"Louisiana",
							"Maine",
							"Maryland",
							"Massachusetts",
							"Michigan",
							"Minnesota",
							"Mississippi",
							"Missouri",
							"MontanaNebraska",
							"Nevada",
							"New Hampshire",
							"New Jersey",
							"New Mexico",
							"New York",
							"North Carolina",
							"North Dakota",
							"Ohio",
							"Oklahoma",
							"Oregon",
							"PennsylvaniaRhode Island",
							"South Carolina",
							"South Dakota",
							"Tennessee",
							"Texas",
							"Utah",
							"Vermont",
							"Virginia",
							"Washington",
							"West Virginia",
							"Wisconsin",
							"Wyoming"
					}));						
				}
				else if(counBox.getSelectedItem().toString().equals("Nepal")) {
					stateBox.setModel(new DefaultComboBoxModel(new String[] {"State",
							"Province No. 1",
							"Province No. 2",
							"Bagmati",
							"Gandaki",
							"Province No. 5",
							"Karnali",
							"Sudurpaschim"
					}));
				}
				else if(counBox.getSelectedItem().toString().equals("South Korea")){
					stateBox.setModel(new DefaultComboBoxModel(new String[] {"State",
							"Chungcheong",
							"Gangwon",
							"Gyeonggi",
							"Gyeongsang",
							"Jeolla"
					}));
				}
			}
		});
		
		cityField = new JTextField("City");
		cityField.setForeground(Color.GRAY);
		cityField.setFont(new Font("Tahoma", Font.ITALIC, 13));
		cityField.setColumns(10);
		cityField.setBounds(149, 225, 301, 21);
		cityField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cityField.setText("");
				cityField.setForeground(Color.black);
				cityField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			}
		});
		panel.add(cityField);
		
		streetField = new JTextField("Street");
		streetField.setForeground(Color.GRAY);
		streetField.setFont(new Font("Tahoma", Font.ITALIC, 13));
		streetField.setColumns(10);
		streetField.setBounds(149, 260, 301, 21);
		streetField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				streetField.setText("");
				streetField.setForeground(Color.black);
				streetField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				
			}
		});
		panel.add(streetField);
		
		preField = new JTextField("Apartment,building,suite,floor etc.");
		preField.setForeground(Color.GRAY);
		preField.setFont(new Font("Tahoma", Font.ITALIC, 13));
		preField.setColumns(10);
		preField.setBounds(149, 294, 301, 21);
		preField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preField.setText("");
				preField.setForeground(Color.black);
				preField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			}
		});
		panel.add(preField);
		
		JLabel postLabel = new JLabel("Postal Code:");
		postLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		postLabel.setBounds(36, 327, 83, 21);
		panel.add(postLabel);
		
		postField = new JTextField();
		postField.setColumns(10);
		postField.setBounds(149, 328, 301, 21);
		postField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(postField);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		emailLabel.setBounds(36, 361, 83, 21);
		panel.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(149, 362, 301, 21);
		emailField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(emailField);
		
		JLabel phLabel = new JLabel("Phone number:");
		phLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		phLabel.setBounds(36, 395, 109, 21);
		panel.add(phLabel);
		
		phField = new JTextField();
		phField.setColumns(10);
		phField.setBounds(149,396, 301, 21);
		phField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(phField);
		JButton nextButton = new JButton("Next");
		nextButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		nextButton.setBounds(379, 441, 71, 21);
		panel.add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				String name=nameField.getText().toString();
				String country=counBox.getSelectedItem().toString();
				String state=stateBox.getSelectedItem().toString();
				String city=cityField.getText().toString();
				String street=streetField.getText().toString();
				String pre=preField.getText().toString();
				String postal=postField.getText().toString();
				String email=emailField.getText().toString();
				String phone=phField.getText().toString();
				if(name.isEmpty()||country.compareTo("Country")==0||state.compareTo("State")==0||city.isBlank()||street.isEmpty()||pre.isBlank()||postal.isBlank()||email.isBlank()||phone.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Information incomplete");
				}	
				else if(i==0) {
					i++;
					fromCoun=counBox.getSelectedItem().toString();
					sName=nameField.getText().toString();
					sEmail=emailField.getText().toString();
					sPhone=phField.getText().toString();
					sAdd=new String(preField.getText().toString()+","+streetField.getText().toString()+","+cityField.getText().toString()+","+stateBox.getSelectedItem().toString()+","+counBox.getSelectedItem().toString()+","+postField.getText().toString());
					frame.dispose();
					@SuppressWarnings("unused")
					shipMenu recurr = new shipMenu();
				}
				else if(i==1){
					toCoun=counBox.getSelectedItem().toString();
					rName=nameField.getText().toString();
					rEmail=emailField.getText().toString();
					rPhone=phField.getText().toString();
					rAdd=new String(preField.getText().toString()+","+streetField.getText().toString()+","+cityField.getText().toString()+","+stateBox.getSelectedItem().toString()+","+counBox.getSelectedItem().toString()+","+postField.getText().toString());
					frame.dispose();
					pack_detail(fromCoun,toCoun);
					i++;
				}
			}
		});
	}
	public void recursion() {
		new shipMenu();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void pack_detail(String fromCoun,String toCoun) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 674, 430);
		frame.setVisible(true);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblPackageDetails = new JLabel("Package Details");
		lblPackageDetails.setBounds(0, 42, 594, 33);
		lblPackageDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPackageDetails.setFont(new Font("Algerian", Font.BOLD, 18));
		panel.add(lblPackageDetails);
		
		JLabel numPackLabel = new JLabel("No. of Packages:");
		numPackLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		numPackLabel.setBounds(34, 115, 115, 21);
		panel.add(numPackLabel);
		
		numPackField = new JTextField();
		numPackField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		numPackField.setColumns(10);
		numPackField.setBounds(161, 116, 301, 21);
		panel.add(numPackField);
		
		wtField = new JTextField();
		wtField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		wtField.setColumns(10);
		wtField.setBounds(161, 185, 260, 21);
		panel.add(wtField);
		JLabel packLabel = new JLabel("Package type:");
		packLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		packLabel.setBounds(34, 149, 115, 21);
		panel.add(packLabel);
		
		JComboBox<String> packBox = new JComboBox<String>();
		packBox.setModel(new DefaultComboBoxModel(new String[] {"Customer Supplied", "LogiDoor Letter", "LogiDoor Small", "LogiDoor Medium","LogiDoor Large"}));
		pack=packBox.getSelectedItem().toString();
		packBox.setForeground(Color.BLACK);
		packBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		packBox.setBackground(Color.WHITE);
		packBox.setBounds(161, 150, 301, 22);
		panel.add(packBox);
		
		JLabel wtLabel = new JLabel("Weight:");
		wtLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		wtLabel.setBounds(34, 184, 115, 21);
		panel.add(wtLabel);
		
		JLabel kgLabel = new JLabel("kgs");
		kgLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		kgLabel.setBounds(433, 184, 115, 21);
		panel.add(kgLabel);
		
		JLabel confLabel = new JLabel("Confirmation:");
		confLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		confLabel.setBounds(34, 218, 105, 21);
		panel.add(confLabel);
		
		JComboBox<String> confBox = new JComboBox<String>();
		confBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Signature", "Adult Signature(age 21 over)"}));
		confBox.setForeground(Color.BLACK);
		confBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confBox.setBackground(Color.WHITE);
		confBox.setBounds(161, 218, 301, 22);
		panel.add(confBox);
		
		JLabel transLabel = new JLabel("Transport:");
		transLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		transLabel.setBounds(34, 252, 105, 21);
		panel.add(transLabel);
		
		JComboBox<String> transBox = new JComboBox<String>();
		if(fromCoun.compareTo(toCoun)==0)
			transBox.setModel(new DefaultComboBoxModel(new String[] {"Select Transport","Road", "Railway", "Air"}));
		else 
			transBox.setModel(new DefaultComboBoxModel(new String[] {"Select Transport","Water", "Air"}));
		transBox.setForeground(Color.BLACK);
		transBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		transBox.setBackground(Color.WHITE);
		transBox.setBounds(161, 252, 301, 22);
		panel.add(transBox);

		JLabel serLabel = new JLabel("Services:");
		serLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		serLabel.setBounds(34, 286, 92, 21);
		panel.add(serLabel);
		
		JComboBox<String> serBox = new JComboBox<String>();
		serBox.setModel(new DefaultComboBoxModel(new String[] {"Select Transport","LogiDoor saver pack", "LogiDoor Express ", "LogiDoor Express plus"}));
		serBox.setForeground(Color.BLACK);
		serBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		serBox.setBackground(Color.WHITE);
		serBox.setBounds(161, 286, 301, 22);
		panel.add(serBox);
		
		JButton nextButton = new JButton("Next");
		nextButton.setBounds(365, 321, 97, 25);
		panel.add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(numPackField.getText().toString().isBlank()||wtField.getText().toString().isBlank()||transBox.getSelectedItem().toString().compareTo("Select Transport")==0||serBox.getSelectedItem().toString().compareTo("Select Service")==0){
					JOptionPane.showMessageDialog(null, "Details Incomplete");
				}		
				else {
					confCheck=confBox.getSelectedItem().toString();
					num=Integer.parseInt(numPackField.getText().toString());
					wt=wtField.getText().toString();
					int weight=Integer.parseInt(wt);
					if(weight<=80)
					{	
						if(weight>0||weight<=10)
							wtPrice=10;
						else if(weight>10||weight<=30)
							wtPrice=15;
						else if(weight>30||weight<=80)
							wtPrice=20;
						if(pack.compareTo("Customer Supplied")==0)
							packPrice=0;
						else if(pack.compareTo("LogiDoor Letter")==0)
							packPrice=2;
						else if(pack.compareTo("LogiDoor Small")==0)
							packPrice=4;
						else if(pack.compareTo("LogiDoor Medium")==0)
							packPrice=6;
						else if(pack.compareTo("LogiDoor Large")==0)
							packPrice=8;
						trans = transBox.getSelectedItem().toString();
						if(trans.compareTo("Road")==0)
							transPrice=10;
						else if(trans.compareTo("Railway")==0)
							transPrice=15;
						else if(trans.compareTo("Water")==0)
							transPrice=30;
						else if(trans.compareTo("Air")==0)
							transPrice=60;
						ser = serBox.getSelectedItem().toString();
						if(ser.compareTo("LogiDoor saver pack")==0)
							serPrice=10;
						else if(ser.compareTo("LogiDoor Express ")==0)
							serPrice=20;
						else if(ser.compareTo("LogiDoor Express plus")==0)
							serPrice=60;
						totPricew=transPrice+serPrice+wtPrice;
						confirmPage(totPricew);
					}
					else
						JOptionPane.showMessageDialog(null, "Weight Exceeded");				
				}
			}
		});
	}
	void confirmPage(int pricew){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 622, 640);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(panel);
		panel.setLayout(null);
		
		JLabel confLabel = new JLabel("Confirm Details");
		confLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		confLabel.setBounds(-6, 13, 604, 66);
		panel.add(confLabel);
		
		JLabel sNameLabel = new JLabel("Sender Name: ");
		sNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sNameLabel.setBounds(44, 80, 104, 21);
		panel.add(sNameLabel);
		
		JLabel sAddLabel = new JLabel("Sender Address: ");
		sAddLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sAddLabel.setBounds(44, 114, 123, 21);
		panel.add(sAddLabel);
		
		JLabel sEmailLabel = new JLabel("Sender Email:");
		sEmailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sEmailLabel.setBounds(44, 148, 123, 21);
		panel.add(sEmailLabel);
		
		JLabel sPhLabel = new JLabel("Sender Phone:");
		sPhLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sPhLabel.setBounds(44, 182, 123, 21);
		panel.add(sPhLabel);
		
		JLabel rPhLabel = new JLabel("Reciever Phone:");
		rPhLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rPhLabel.setBounds(44, 333, 123, 21);
		panel.add(rPhLabel);
		
		JLabel lblRecieverAddress = new JLabel("Reciever Address: ");
		lblRecieverAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRecieverAddress.setBounds(44, 265, 123, 21);
		panel.add(lblRecieverAddress);
		
		JLabel rNameLabel = new JLabel("Reciever Name:");
		rNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rNameLabel.setBounds(44, 231, 123, 21);
		panel.add(rNameLabel);
		
		JLabel rEmailLabel = new JLabel("Reciever Email:");
		rEmailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rEmailLabel.setBounds(44, 299, 123, 21);
		panel.add(rEmailLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-6, 216, 620, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-6, 367, 620, 2);
		panel.add(separator_1);
		
		JLabel lblNumberOfPackages = new JLabel("No. of Packages:");
		lblNumberOfPackages.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNumberOfPackages.setBounds(44, 386, 112, 21);
		panel.add(lblNumberOfPackages);
		
		JLabel label = new JLabel("Package type:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label.setBounds(44, 420, 115, 21);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Weight:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_1.setBounds(44, 454, 115, 21);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Confirmation:");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_2.setBounds(44, 488, 105, 21);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Transport:");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_3.setBounds(44, 519, 105, 21);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Services:");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_4.setBounds(332, 386, 92, 21);
		panel.add(label_4);
		
		JLabel sNLabel = new JLabel(sName);
		sNLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sNLabel.setBounds(178, 80, 327, 21);
		panel.add(sNLabel);
		
		JLabel sALabel = new JLabel(sAdd);
		sALabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sALabel.setBounds(179, 114, 399, 21);
		panel.add(sALabel);
		
		JLabel sELabel = new JLabel(sEmail);
		sELabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sELabel.setBounds(179, 148, 327, 21);
		panel.add(sELabel);
		
		JLabel sPLAbel = new JLabel(sPhone);
		sPLAbel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sPLAbel.setBounds(179, 182, 327, 21);
		panel.add(sPLAbel);
		
		JLabel rNLabel = new JLabel(rName);
		rNLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rNLabel.setBounds(179, 231, 327, 21);
		panel.add(rNLabel);
		
		JLabel rALabel = new JLabel(rAdd);
		rALabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rALabel.setBounds(179, 265, 399, 21);
		panel.add(rALabel);
		
		JLabel rELabel = new JLabel(rEmail);
		rELabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rELabel.setBounds(179, 299, 327, 21);
		panel.add(rELabel);
		
		JLabel rPLabel = new JLabel(rPhone);
		rPLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rPLabel.setBounds(179, 333, 327, 21);
		panel.add(rPLabel);
		
		JLabel nPLabel = new JLabel(Integer.toString(num));
		nPLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		nPLabel.setBounds(162, 386, 158, 21);
		panel.add(nPLabel);
		
		JLabel pTLabel = new JLabel(pack);
		pTLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pTLabel.setBounds(162, 420, 158, 21);
		panel.add(pTLabel);
		
		JLabel wtLabel = new JLabel(wt+"kgs");
		wtLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		wtLabel.setBounds(162, 454, 158, 21);
		panel.add(wtLabel);
		
		JLabel coLabel = new JLabel(confCheck);
		coLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		coLabel.setBounds(161, 488, 158, 21);
		panel.add(coLabel);
		
		JLabel tLabel = new JLabel(trans);
		tLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tLabel.setBounds(161, 519, 158, 21);
		panel.add(tLabel);
		
		JLabel serLabel = new JLabel(ser);
		serLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		serLabel.setBounds(403, 386, 189, 21);
		panel.add(serLabel);
		
		JLabel lblEstimatedPrice = new JLabel("Estimated Price:");
		lblEstimatedPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEstimatedPrice.setBounds(44, 553, 123, 21);
		panel.add(lblEstimatedPrice);
		
		JLabel ePriceLabel = new JLabel("$ "+Integer.toString(pricew));
		ePriceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ePriceLabel.setBounds(162, 556, 158, 21);
		panel.add(ePriceLabel);
		
		JButton confButton = new JButton("Confirm");
		confButton.setBounds(447, 543, 97, 25);
		panel.add(confButton);
		confButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				insertData1();
				
				JOptionPane.showMessageDialog(null, "Shipment Confirmed with TrackID "+trackID);
			}
		});
	}
	public static int insertData1() {
		ResultSet rs = null;
		int candidateId = 0;
		java.util.Date date=null;
			String sql = "INSERT INTO delivery(sendername,senderAddress,senderEmail,senderPhone,recievername,recieverAddress,recieverEmail,recieverPhone,nPack,pType,wt,conf,trans,service,estPrice,trackID,status,mainEmail)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			DateFormat dateFormat=null;
			date = Calendar.getInstance().getTime();
			dateFormat = new SimpleDateFormat("MMddHHmmss");  
			trackID=new String("LD"+dateFormat.format(date));
			try (Connection conn = db_helper.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
						pstmt.setString(1, sName);
						pstmt.setString(2, sAdd);
						pstmt.setString(3, sEmail);
						pstmt.setString(4, sPhone);
						pstmt.setString(5, rName);
						pstmt.setString(6, rAdd);
						pstmt.setString(7, rEmail);
						pstmt.setString(8, rPhone);
						pstmt.setString(9, Integer.toString(num));
						pstmt.setString(10, pack);
						pstmt.setString(11, wt);
						pstmt.setString(12, confCheck);
						pstmt.setString(13, trans);
						pstmt.setString(14, ser);
						pstmt.setString(15, Integer.toString(totPricew));
						pstmt.setString(16, trackID);
						pstmt.setString(17, "Pending");
						pstmt.setString(18, start.mainEmail);
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
