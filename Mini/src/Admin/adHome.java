package Admin;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Proj.db_helper;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class adHome{
	private static JFrame frame;
	private static JPanel panel;
	private static JTable table;
	private static JLabel label;
	private static JButton disBut;
	private static JButton delBut,deliBut;
	public adHome() {
		frame = new JFrame();
		frame.setTitle("Admin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(5, 5, 1500, 800);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 120, 1450, 550);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel("LogiDoor Admin");
		label.setFont(new Font("Javanese Text", Font.BOLD, 22));
		label.setBounds(27, 31, 182, 32);
		panel.add(label);
		
		disBut = new JButton("Display all Users");
		disBut.setBounds(348, 65, 133, 25);
		panel.add(disBut);
		disBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "Select * FROM userdata;";
				try  {
					Connection conn = db_helper.getConnection();
			        Statement stmt  = conn.createStatement();
			        ResultSet rs    = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));

				   } catch (SQLException  ex) {
				       System.out.println(ex.getMessage());
				   }
			}
		});
		delBut = new JButton("Delete User");
		delBut.setBounds(493, 65, 119, 25);
		panel.add(delBut);
		delBut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int row1=table.getSelectedRow();
					String cell= table.getModel().getValueAt(row1,0).toString();
					String sql= "DELETE from userdata where ID='"+cell+"'";
					try {
						Connection conn = db_helper.getConnection();
						PreparedStatement psmt=conn.prepareStatement(sql);
						psmt.execute();
					}
					catch(SQLException  ex){
						System.out.println(ex.getMessage());
					}
					sql = "Select * FROM userdata;";
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
						 
						        if (preferredWidth >= maxWidth)
						        {
						            preferredWidth = maxWidth;
						            break;
						        }
						    }
						 
						    tableColumn.setPreferredWidth( preferredWidth );
						}
	
					}
					catch (SQLException  ex) {
					       System.out.println(ex.getMessage());
					 }
				}
				catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Select user to Delete");
				}
			}
		});
		deliBut=new JButton("All Deliveries");
		deliBut.setBounds(620, 65, 160, 25);
		panel.add(deliBut);
		deliBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Deliveries();
			}
		});

		frame.setVisible(true);
	}
}









