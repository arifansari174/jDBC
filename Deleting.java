package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Deleting {
public static void main(String[] args) throws ClassNotFoundException{;
	
	String url = "jdbc:mysql://localhost:3306/mydatabase";
	String username = "root";
	String password = "Mohd#022006";
	String query = "DELETE FROM employees where id = 7;";
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Drivers loaded successfully!!!");
	}catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}
	
	
	
	try {
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established successfully!!!");
		Statement stmt = con.createStatement();
		int rowsaffected = stmt.executeUpdate(query);
		
		if(rowsaffected>0) {
			System.out.println("Deletion successfully." + rowsaffected + "row(s) affected." );
		}
		else 
		{
			System.out.println("Deletion failed!!");
			
		}
		stmt.close();
		con.close();
		System.out.println();
		System.out.println("Connection Closed successfully!!!!");
	}catch (SQLException e) {
		System.out.println(e.getMessage());
	}
}

}