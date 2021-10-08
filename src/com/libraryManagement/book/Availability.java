package com.libraryManagement.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Availability {
	
	public static boolean isAvailable(Connection con,int bookID)
	{
		String query="select  book_count from book where book_id=?";
		boolean flag=false;
		try {
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, bookID);
			ResultSet rs=ps.executeQuery();
			int count=0;
			while(rs.next())
			{
			count=rs.getInt(1);	
			}
			if(count>0)
			{
				return true; 
			}
			else
				return false;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
			
		}
	
	}

}
