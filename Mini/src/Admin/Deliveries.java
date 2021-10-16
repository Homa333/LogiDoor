package Admin;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Proj.db_helper;
import net.proteanit.sql.DbUtils;

public class Deliveries {
	private static JFrame frame;
	private static JPanel panel;
	private static JTable table;
	private static JLabel label;
	private static JButton disBut,delBut,deliBut;
	Deliveries(){
		frame = new JFrame();
		frame.setTitle("All Deliveries");
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
		
		label = new JLabel("All Deliveries");
		label.setFont(new Font("Javanese Text", Font.BOLD, 22));
		label.setBounds(27, 31, 182, 32);
		panel.add(label);
		JButton pkBut=new  JButton("All Deliveries");
		pkBut.setBounds(795, 65, 160, 25);
		panel.add(pkBut);
		pkBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "Select * FROM delivery;";
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
		JButton pickBut=new  JButton("Marked as Picked");
		pickBut.setBounds(1050, 700, 160, 25);
		panel.add(pickBut);
		pickBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(table.getModel().getValueAt(table.getSelectedRow(),17).toString().compareTo("Pending")==0) {
						try {
							int row1=table.getSelectedRow();
							String cell= table.getModel().getValueAt(row1,1).toString();
							String p= "Picked up";
							String sql= "UPDATE delivery set status ='"+p+"' where trackID='"+cell+"'";
							try {
								Connection conn = db_helper.getConnection();
								PreparedStatement psmt=conn.prepareStatement(sql);
								psmt.execute();
							}
							catch(SQLException  ex){
								System.out.println(ex.getMessage());
							}
							sql = "Select * FROM delivery;";
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
							JOptionPane.showMessageDialog(null, "Select Delivery to be Picked up");
						}
						
				}
				else {
					JOptionPane.showMessageDialog(null, "Select Pending Deliveries");	
				}
			}
			catch(ArrayIndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(null, "Select First");
			}
		}
	});
		JButton deldBut=new  JButton("Marked as Delivered");
		deldBut.setBounds(1220, 700, 160, 25);
		panel.add(deldBut);
		deldBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(table.getModel().getValueAt(table.getSelectedRow(),17).toString().compareTo("Picked up")==0) {
						try {
							int row1=table.getSelectedRow();
							String cell= table.getModel().getValueAt(row1,1).toString();
							String d= "Delivered";
							String pen="Pending";
							String sql= "UPDATE delivery set status ='"+d+"' where trackID='"+cell+"'";
							try {
								Connection conn = db_helper.getConnection();
								PreparedStatement psmt=conn.prepareStatement(sql);
								psmt.execute();
							}
							catch(SQLException  ex){
								System.out.println(ex.getMessage());
							}
							sql = "Select * FROM delivery;";
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
							JOptionPane.showMessageDialog(null, "Select Delivery that is Delivered");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Select Picked Deliveries");
					}
				}
				catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Select First");
				}
			}
		});
		frame.setVisible(true);
	}
}




