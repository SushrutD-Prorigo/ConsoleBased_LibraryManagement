package com.libraryManagement.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Student {
	
	private int studentId;
	private String studentFname;
	private String studentLname;
	private String studentGender;
	private int studentAge;
	private String studentClass;
	private LocalDate studentBirthDate;
	
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentFname() {
		return studentFname;
	}
	public void setStudentFname(String studentFname) {
		this.studentFname = studentFname;
	}
	public String getStudentLname() {
		return studentLname;
	}
	public void setStudentLname(String studentLname) {
		this.studentLname = studentLname;
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public LocalDate getStudentBirthDate() {
		return studentBirthDate;
	}
	public void setStudentBirthDate(LocalDate studentBirthDate) {
		this.studentBirthDate = studentBirthDate;
	}
	@Override
	public String toString() {
		return "StudentId=" + this.studentId + "\n"+" StudentFname=" + this.studentFname+ "\n"+ "StudentLname=" + this.studentLname
				+ "\n"+ " StudentGender=" + this.studentAge + "\n"+" StudentAge=" + this.studentAge + "\n"+" StudentClass=" + this.studentClass
				+ "\n"+" StudentBirthDate=" + this.studentBirthDate;
	}
	
	public void addStudent()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Students First Name:");
		this.setStudentFname(sc.next());
		
		System.out.println("Enter Students Last Name:");
		this.setStudentLname(sc.next());
		
		System.out.println("Enter Students Class:");
		this.setStudentClass(sc.next());
		
		System.out.println("Enter Students Gender:");
		this.setStudentGender(sc.next());
		
		System.out.println("Enter Students Age:");
		this.setStudentAge(sc.nextInt());
		
		System.out.println("Enter Students Birth Date:");
		String date=sc.next();
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-mm-dd").parse(date);
			this.setStudentBirthDate(date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		} catch (ParseException e) {
			System.out.println("Invalid Date Formate");
			e.printStackTrace();
		}
		
		
		sc.close();
	}
	
	
	

}
