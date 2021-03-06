package com.libraryManagement.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class AddStudentToDatabase extends Student{

	public static void addStudent(Connection con)
	{
		Student student=new Student();
		
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		student.setStudentFname();
		student.setStudentLname();
		student.setStudentClass();
		student.setStudentGender();
		
		System.out.println("Enter Students Age:");
		student.setStudentAge(sc.nextInt());
		
		student.setStudentBirthDate();
	
		try {
			String sql="insert into student(student_fname,student_lname,student_class,student_age,student_gender,student_birthdate) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, student.getStudentFname());
			ps.setString(2, student.getStudentLname());
			ps.setString(3, student.getStudentClass());
			ps.setInt(4, student.getStudentAge());
			ps.setString(5, student.getStudentGender());
			ps.setString(6,student.getStudentBirthDate().toString());
			int count=ps.executeUpdate();
			if(count!=0)
			{
				System.out.println("Added Student");
			}
			else
			{
				System.out.println("Error");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while Saving data to database...!");
			e.printStackTrace();
		}

	}
}
