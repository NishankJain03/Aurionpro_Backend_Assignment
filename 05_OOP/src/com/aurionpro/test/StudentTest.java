package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Student student = new Student();
		System.out.println("Name " + student.getName());
		System.out.println("Age " + student.getAge());
		System.out.println("Rollno " + student.getRollNo());
		System.out.println("Percentage " + student.getPercentage());
		
		System.out.println("Enter the name");
		String name = scanner.next();
		System.out.println("Enter the age");
		int age = scanner.nextInt();
		System.out.println("Enter the Rollno");
		int rollno = scanner.nextInt();
		System.out.println("Enter the percentage");
		float percent = scanner.nextFloat();
		
		Student student1 = new Student(rollno, name, age, percent);  //parameterized constructor
		
		System.out.println("Name " + student1.getName());
		System.out.println("Age " + student1.getAge());
		System.out.println("Rollno " + student1.getRollNo());
		System.out.println("Percentage " + student1.getPercentage());
		
		
		
		
		

		scanner.close();
	}

}
