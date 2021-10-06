package com.libraryManagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnection {
	
	public final static String url="jdbc:mysql://localhost:3306/library_management";
	public static Connection con=null;
	
	public static Connection getConnect()
	{
		
		try {
			
			con=DriverManager.getConnection(url,"root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return con;
	}

}
