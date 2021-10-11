package com.libraryManagement.Controller;

import java.sql.Connection;
import java.util.Scanner;

import com.libraryManagement.book.AddBookToDatabase;
import com.libraryManagement.book.Availability;
import com.libraryManagement.book.GetBooksFromDatabase;
import com.libraryManagement.book.OrderBook;
import com.libraryManagement.book.SearchBook;
import com.libraryManagement.connection.DBConnection;
import com.libraryManagement.records.AddRecordToDatabase;
import com.libraryManagement.records.Fine;
import com.libraryManagement.records.FineNotPaid;
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
		System.out.println("1.Admin \n2.Student \n3.Exit");
		Scanner keyboard=new Scanner(System.in);
		int choice=keyboard.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("------>>>>>>>>");
			System.out.println("1.Add Student.");
			System.out.println("2.Add Book.");
			System.out.println("3.Search student.");
			System.out.println("4.Pay fine");
			System.out.println("5.List of Student who have not returned book");
			System.out.println("6.List of studetn who haven't paid fine");
			System.out.println("7.Back");
			int key=keyboard.nextInt();
			switch (key) 
			{
			case 1:
				AddStudentToDatabase.addStudent(connectionObj);
				break;
				
			case 2:
				AddBookToDatabase.addBook(connectionObj);
				break;
				
			case 3:
				SearchStudentByName.searchStudent(connectionObj);
				break;
				
			case 4:
				Fine.payFine(connectionObj);
				break;
				
			case 5:
				StudentNotReturnedBook.listOfStudentNotReturnedBook(connectionObj);
				break;
				
			case 6:
				FineNotPaid.listOfUnpaidFine(connectionObj);
				break;
			
			default:
				System.out.println("Try Again...!");
			}
			break;
		case 2:
				System.out.println("------->>>>>>>>");
				System.out.println("1.Search Book.");
				System.out.println("2.Issue a Book");
				System.out.println("3.Return Book");
				System.out.println("4.Display books.");
				System.out.println("5.Order a book.");
				System.out.println("6.Back");
				int key2=keyboard.nextInt();
				switch(key2)
				{
				case 1:
					SearchBook.searchBookDetails(connectionObj);
					break;
				
				case 2:
					AddRecordToDatabase.addRecord(connectionObj);
					break;
					
				case 3:
					ReturningBook.returnBook(connectionObj);
					break;
					
				case 4:
					GetBooksFromDatabase.getAllBooks(connectionObj);
					break;
				case 5:
					System.out.println("Enter book name");
					String name=keyboard.next();
					OrderBook.orderABOok(connectionObj,name);
					break;
				default:
					System.out.println("Try Again...!");
				}
				break;
		case 3:
			System.out.println("THANK YOU....");
			connect.closeConnectin();
			keyboard.close();
			System.exit(0);
			break;
			default:
				System.out.println("Try again");
		}
		}
	}

}
