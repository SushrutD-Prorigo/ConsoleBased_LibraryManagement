package com.libraryManagement.student;


import java.time.LocalDate;


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
		return "StudentId : " + this.studentId + "\n"+"Name : " + this.studentFname+  " " + this.studentLname
				+ "\n"+ "Gender : " + this.studentGender + "\n"+"Age : " + this.studentAge + "\n"+"Class : " + this.studentClass
				+ "\n"+"BirthDate : " + this.studentBirthDate;
	}
}
