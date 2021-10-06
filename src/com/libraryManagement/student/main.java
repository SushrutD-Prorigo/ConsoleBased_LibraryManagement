package com.libraryManagement.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.libraryManagement.book.Book;
import com.libraryManagement.connection.DBConnection;

public class main {
	
	public static void main(String[] args) {
		
		//Student student=new Student();
		//student.addStudent();
		//System.out.println(student.toString());
		
		
		DBConnection connectDB=new DBConnection();
		Connection con=connectDB.getConnect();
		if(con!=null)
		{
		System.out.println("Success");
		
		}
		else
			System.out.println("Eror");
	
	Book book=new Book();
	book.addBook();
	String str="insert into book(book_name,book_author,book_cost,book_copies) values(?,?,?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(str);
		ps.setString(1, book.getBooktitle());
		ps.setString(2, book.getBookAuthor());
		ps.setInt(3, book.getBookPrice());
		ps.setInt(4, book.getBookCount());
		boolean flag=ps.execute();
		if(flag)
		{
			System.out.println("Inserted");
			
		}
		else
			System.out.println("Error whileadding");
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		//----
	String query="select * from book";
	
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("-------");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
			System.out.println(rs.getInt(5));
			System.out.println("-------");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	}}
