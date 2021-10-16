package Proj;
import java.sql.*;

public class db_helper {
	 private static final String url = "jdbc:mysql://localhost:3306/mini";
	 public static Connection getConnection() throws SQLException  {
		 Connection con=null;
		 con=DriverManager.getConnection(url,"root","root123");
		return con;
	 }
}