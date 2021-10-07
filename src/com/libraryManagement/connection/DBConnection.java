package com.libraryManagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public Connection con=null;
	
	public Connection getConnection()
	{
		
		try {
			this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","root");
			System.out.println("Connecting.........");
		} catch (SQLException e) {
			System.out.println("Unable to Connect Database....!");
			e.printStackTrace();
		}	
		return con;
	}

	
	public void closeConnectin()
	{
		try {
			this.con.close();
			System.out.println("Connection Closed.....!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Close Connection....!");
			e.printStackTrace();
		}
	}
}
