package Proj;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import net.proteanit.sql.DbUtils;

public class Home implements ActionListener{
	private static JFrame frame;
	private static JLabel label,trackIcon,statLabel,truck;
	private static JButton shipBut,trackBut,orderBut,signOut,disBut,canBut;
	private static JPanel panel;
	private static JTextField track;
	private static JTable table;
	static String status;
	public Home(String username){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("LogiDoor");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		frame.add(panel);
		JLabel welcome = new JLabel("Welcome to LogiDoor");
		welcome.setBounds(650,40, 400,50);
		welcome.setForeground(new Color(245, 255, 250));
		welcome.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel.add(welcome);
		
		signOut = new JButton("Logout");
		signOut.setBounds(1300, 50, 100, 25);
		signOut.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(signOut);
		signOut.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);;
				start logt = new start();
				logt.login();
			}
		});
		
		
		label = new JLabel("Hello "+ username+"," );
		label.setFont(new Font("Times New Roman", Font.BOLD, 33));
		label.setForeground(new Color(245, 255, 250));
		label.setBounds(90, 150, 200, 30);
		panel.add(label); 
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Home.class.getResource("/Proj/history.png")));
		label_1.setBounds(1116, 220, 329, 288);
		panel.add(label_1);
		
		truck = new JLabel();
		truck.setIcon(new ImageIcon(Home.class.getResource("/Proj/iconfinder_Shipping_Delivery_Truck_Fast_4075944.png")));
		truck.setBounds(470, 290, 525, 214);
		panel.add(truck);
	
		trackBut = new JButton("Quick Track");
		trackBut.setForeground(Color.WHITE);
		trackBut.setHorizontalAlignment(SwingConstants.CENTER);
		trackBut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		trackBut.setBackground(new Color(210, 105, 30));
		trackBut.setBounds(100,600,150,35);
		trackBut.addActionListener(this);
		panel.add(trackBut);
		
		track = new JTextField();
		track.setBounds(100,600,150,35);
		track.setVisible(false);
		panel.add(track);

		shipBut=new JButton("Ship Items");
		shipBut.setForeground(new Color(255, 255, 255));
		shipBut.setBackground(new Color(210, 105, 30));
		shipBut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		shipBut.addActionListener(this);
		shipBut.setBounds(620,600, 150, 35);
		panel.add(shipBut);
		
		trackIcon = new JLabel();
		trackIcon.setIcon(new ImageIcon(Home.class.getResource("/Proj/track.png")));
		trackIcon.setHorizontalAlignment(SwingConstants.CENTER);
		trackIcon.setFont(new Font("Tahoma", Font.PLAIN, 25));
		trackIcon.setBounds(90,250,200,295);
		panel.add(trackIcon);
		
		orderBut = new JButton("Orders");
		orderBut.setForeground(new Color(255, 255, 255));
		orderBut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		orderBut.setBackground(new Color(210, 105, 30));
		orderBut.setBounds(1169, 600, 150, 35);
		panel.add(orderBut);
		orderBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame();
				frame.setTitle("Orders");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(5, 5, 1500, 600);
				panel = new JPanel();
				panel.setBorder(new EmptyBorder(5, 5, 5, 5));
				frame.add(panel);
				panel.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(20, 121, 1450, 400);
				panel.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				
				label = new JLabel("Orders");
				label.setFont(new Font("Javanese Text", Font.BOLD, 22));
				label.setBounds(27, 31, 182, 32);
				panel.add(label);
				
				disBut = new JButton("Display Your Orders");
				disBut.setBounds(330, 65, 150, 25);
				panel.add(disBut);
				disBut.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String sql = "select trackID,sendername,senderAddress,recievername,recieverAddress,service,estPrice,status from delivery where mainEmail='"+start.mainEmail+"' ;";
						try  {
							Connection conn = db_helper.getConnection();
					        Statement stmt  = conn.createStatement();
					        ResultSet rs    = stmt.executeQuery(sql);
							table.setModel(DbUtils.resultSetToTableModel(rs));
							for (int column = 0; column < table.getColumnCount(); column++)
							{
							    TableColumn tableColumn = table.getColumnModel().getColumn(column);
							    int preferredWidth = tableColumn.getMinWidth();
							    int maxWidth = tableColumn.getMaxWidth();
							 
							    for (int row = 0; row < table.getRowCount(); row++)
							    {
							        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
							        Component c = table.prepareRenderer(cellRenderer, row, column);
							        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
							        preferredWidth = Math.max(preferredWidth, width);
							 
							        //  We've exceeded the maximum width, no need to check other rows
							 
							        if (preferredWidth >= maxWidth)
							        {
							            preferredWidth = maxWidth;
							            break;
							        }
							    }
							 
							    tableColumn.setPreferredWidth( preferredWidth );
							}
						   } catch (SQLException  ex) {
						       System.out.println(ex.getMessage());
						   }
					}
				});
				canBut = new JButton("Cancel Order");
				canBut.setBounds(493, 65, 119, 25);
				panel.add(canBut);
				canBut.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row=table.getSelectedRow();
							String cell= table.getModel().getValueAt(row,0).toString();
							String sql= "UPDATE delivery set status='Cancelled' where trackID='"+cell+"'";
							try {
								Connection conn = db_helper.getConnection();
								PreparedStatement psmt=conn.prepareStatement(sql);
								psmt.execute();
							}
							catch(SQLException  ex){
								System.out.println(ex.getMessage());
							}
							sql = "select trackID,sendername,senderAddress,recievername,recieverAddress,service,estPrice,status from delivery where mainEmail='"+start.mainEmail+"' ;";
							try  {
								Connection conn = db_helper.getConnection();
						        Statement stmt  = conn.createStatement();
						        ResultSet rs    = stmt.executeQuery(sql);
								table.setModel(DbUtils.resultSetToTableModel(rs));
								for (int column = 0; column < table.getColumnCount(); column++)
								{
								    TableColumn tableColumn = table.getColumnModel().getColumn(column);
								    int preferredWidth = tableColumn.getMinWidth();
								    int maxWidth = tableColumn.getMaxWidth();
								 
								    for (int row1 = 0; row1 < table.getRowCount(); row1++)
								    {
								        TableCellRenderer cellRenderer = table.getCellRenderer(row1, column);
								        Component c = table.prepareRenderer(cellRenderer, row1, column);
								        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
								        preferredWidth = Math.max(preferredWidth, width);
								 
								        //  We've exceeded the maximum width, no need to check other rows
								 
								        if (preferredWidth >= maxWidth)
								        {
								            preferredWidth = maxWidth;
								            break;
								        }
								    }
								 
								    tableColumn.setPreferredWidth( preferredWidth );
								}
	
							   } catch (SQLException  ex) {
							       System.out.println(ex.getMessage());
							   }
							JOptionPane.showMessageDialog(null, "Order Cancelled");
						}
						catch(ArrayIndexOutOfBoundsException ex) {
							JOptionPane.showMessageDialog(null, "Select order to cancel");
						}
					}
				});
				frame.setVisible(true);
			}
		});
		frame.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==trackBut) {
		trackBut.setVisible(false);
		track.setVisible(true);
		statLabel = new JLabel();
		statLabel.setText("*TrackID");
		statLabel.setBounds(90,640,300,35);
		panel.add(statLabel);
		Action action = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;

			@Override
		    public void actionPerformed(ActionEvent e)
		    {
		       new db_helper();
		       String sql = "Select status FROM delivery where trackID='"+track.getText().toString()+"' ;";
		       try(Connection con = db_helper.getConnection();
		       Statement stmt  = con.createStatement();
		       ResultSet rs = stmt.executeQuery(sql); 	   
		    	){
		    	   if (rs.next()) {
		    		   status = rs.getString(1);		    		   
		    	   }
		    	  
		    	   if(status==null)
		    		   JOptionPane.showMessageDialog(null,"No Package exist with given TrackID");
		    	   else if(status.compareTo("Pending")==0) {
		    		   statLabel.setText("Your Package is yet to be picked.");
		    	   }
		    	   else if(status.compareTo("Picked")==0) {
		    		   statLabel.setText("Your Package is on the way.");
		    	   }
		    	   else if(status.compareTo("Delivered")==0){
		    		   statLabel.setText("Your Package is delivered.");
		    	   }
		    	   else if(status.compareTo("Cancelled")==0)
		    		   statLabel.setText("Your Package is cancelled.");
		       } 
		       catch (SQLException e1) {
		       }
		       trackBut.setVisible(true);
				track.setVisible(false);
		    }
		};
		track.addActionListener(action);
		}
		else if(e.getSource()==shipBut) {
			new shipMenu();
		}
	}
}