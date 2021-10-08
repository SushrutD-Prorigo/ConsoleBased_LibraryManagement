package com.libraryManagement.records;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import com.libraryManagement.book.Availability;

public class AddRecordToDatabase extends Records {
	
	public static void addRecord(Connection con)
	{
		Records recordObj=new Records();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Student ID :");
		recordObj.setStudentId(sc.nextInt());
		
		System.out.println("Book ID : ");
		recordObj.setBookId(sc.nextInt());
		
		System.out.println("Issue Date : ");
		String date=sc.next();
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-mm-dd").parse(date);
			recordObj.setIssueDate(date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			recordObj.setDueDate(recordObj.getIssueDate().plusDays(5));
		} catch (ParseException e) {
			System.out.println("Invalid Date Format");
			e.printStackTrace();
		}
		System.out.println("Issue date :"+recordObj.getIssueDate());
		recordObj.setDueDate(recordObj.getIssueDate().plusDays(5));
		System.out.println("Due Date : "+recordObj.getDueDate());
		try {
			String query="insert into record values(default,?,?,?,?,null,null,null)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, recordObj.getStudentId());
			ps.setInt(2, recordObj.getBookId());
			ps.setString(3, recordObj.getIssueDate().toString());
			ps.setString(4, recordObj.getDueDate().toString());
			int count=ps.executeUpdate();
			if(count>0)
				System.out.println("Book Issued \n Due Date : "+recordObj.getDueDate());
			else
				System.out.println("Not avalilable....");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to process....!");
		}
		
	}

}
