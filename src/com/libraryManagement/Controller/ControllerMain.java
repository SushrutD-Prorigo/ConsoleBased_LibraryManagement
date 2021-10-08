package com.libraryManagement.Controller;

import java.sql.Connection;
import java.util.Scanner;

import com.libraryManagement.book.AddBookToDatabase;
import com.libraryManagement.book.GetBooksFromDatabase;
import com.libraryManagement.book.SearchBook;
import com.libraryManagement.connection.DBConnection;
import com.libraryManagement.records.AddRecordToDatabase;
import com.libraryManagement.records.Fine;
import com.libraryManagement.records.ReturningBook;
import com.libraryManagement.records.StudentNotReturnedBook;
import com.libraryManagement.student.AddStudentToDatabase;
import com.libraryManagement.student.SearchStudentByName;
import com.libraryManagement.student.StudentList;


public class ControllerMain {
	
	public static void main(String[] args) {
		
		DBConnection connect=new DBConnection();
		Connection connectionObj=connect.getConnection();
		
		if(connectionObj!=null)
			System.out.println("---- Connected ----");
		else
			System.out.println("Error in Connection...!");
		
		
		
		while(true)
		{
			System.out.println("\n-------\n");
			System.out.println("1.Display all Books.");
			System.out.println("2.Add new Book.");
			System.out.println("3.Add new Student.");
			System.out.println("4.Display Student All Details.");
			System.out.println("5.Search Book.");
			System.out.println("6.Search Student.");
			System.out.println("7.Issue a Book");
			System.out.println("8.Return Book");
			System.out.println("9.Pay fine");
			System.out.println("10.List of Student who have not returned book");
			System.out.println("11.Exit.");
			System.out.println("-------");
			System.out.println("Enter Your Choice.");
			Scanner keyboard=new Scanner(System.in);
			int choice=keyboard.nextInt();
			
			
		switch(choice)
		{
		case 1:
				GetBooksFromDatabase.getAllBooks(connectionObj);
				break;
			
		case 2:
				AddBookToDatabase.addBook(connectionObj);
				break;
			
		case 3:
				AddStudentToDatabase.addStudent(connectionObj);
				break;
			
		case 4:
				StudentList.getAllStudent(connectionObj);
				break;
			
		case 5:
				SearchBook.searchBookDetails(connectionObj);
				break;
				
		case 6:
				SearchStudentByName.searchStudent(connectionObj);
				break;
		case 7:
				AddRecordToDatabase.addRecord(connectionObj);
				break;
				
		case 8:
				ReturningBook.returnBook(connectionObj);
				break;
				
		case 9:
				Fine.payFine(connectionObj);
				break;
				
		case 10:
				StudentNotReturnedBook.listOfStudentNotReturnedBook(connectionObj);
				break;
				
		case 11:
				connect.closeConnectin();
				keyboard.close();
				System.exit(0);
				break;
		default:
				System.out.println("Ínvalid Choice..");
		}
		}
	}

}
