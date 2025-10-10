package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) throws ClassNotFoundException{;
	
	String url = "jdbc:mysql://localhost:3306/mydatabase";
	String username = "root";
	String password = "Mohd#022006";
	String query = "INSERT INTO employees(id, name, job_title, salary) VALUES (7, 'Abdullah', 'full stack Developer', 90000.00); ";
	
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
			System.out.println("Insert successfully." + rowsaffected + "row(s) affected." );
		}
		else 
		{
			System.out.println("Insert failed!!");
			
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