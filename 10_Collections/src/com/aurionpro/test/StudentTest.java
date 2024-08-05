package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.Student;
import com.aurionpro.model.StudentComparators;;

public class StudentTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		List<Student> students = new ArrayList<Student>();
		//entering the elements
//		readStudent(scanner, students);
		//accessing the elements
//		printDetails(students);
		
		students.add(new Student(2, "nishank", 80));
		students.add(new Student(4, "jain", 75));
		students.add(new Student(1, "abcc", 85));
		students.add(new Student(5, "xyzz", 90));
		
		System.out.println("Unsorted Student list");
		for(Student student: students)
			System.out.println(student);
		
		Collections.sort(students, new StudentComparators.StudentRollNoComparator());
		System.out.println("Sorted student list based on Roll No");
		
		for(Student student: students)
			System.out.println(student);
		Collections.sort(students, new StudentComparators.StudentPercentageComparator() );
		System.out.println("Sorted student list based on Percentage");
		
		for(Student student: students)
			System.out.println(student);
		Collections.sort(students, new StudentComparators.StudentNameComparator());
		System.out.println("Sorted student list based on Name");
		
		for(Student student: students)
			System.out.println(student);	
		

	}
	private static void readStudent(Scanner scanner, List<Student> students) {
		for(int i=0;i<10;i++) {
			System.out.println("Enter the rollNo");
			int rollNo = scanner.nextInt();
			System.out.println("Enter the name");
			String name = scanner.next();
			System.out.println("Enter the percentage");
			double percentage = scanner.nextDouble();
			
			students.add(new Student (rollNo, name, percentage));
		}
		
	}
		private static void printDetails( List<Student> students) {
			for(Student student: students)
				System.out.println(student);
		}

}
