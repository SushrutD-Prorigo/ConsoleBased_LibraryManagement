package com.libraryManagement.book;

import java.util.Scanner;

public class Book {

	private int bookId;
	private String bookAuthor;
	private String booktitle;
	private int bookCount;
	private int bookPrice;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public void addBook()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Book Title:");
		this.setBooktitle(sc.nextLine());
		
		System.out.println("Author name:");
		this.setBookAuthor(sc.nextLine());
		
		System.out.println("Price:");
		this.setBookPrice(sc.nextInt());
		
		System.out.println("Copies:");
		this.setBookCount(sc.nextInt());
		
		sc.close();
	}
	
	
}
