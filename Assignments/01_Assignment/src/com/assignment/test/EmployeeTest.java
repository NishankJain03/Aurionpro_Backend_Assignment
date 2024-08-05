package com.assignment.test;

import java.util.Scanner;
import com.assignment.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of employee ");
		int size = scanner.nextInt();
		//Employee 1
		Employee employees[] = new Employee[size];
		
		for(int i=0; i< employees.length; i++) {
			System.out.println("Enter the Name");	
			String name = scanner.next();
			
			System.out.println("Enter the employee Id");
			int empId = scanner.nextInt();
			
			System.out.println("Enter the Salary");
			double salary = scanner.nextDouble();
			
			employees[i] = new Employee(empId, name, salary);
		}
		
		for(int i=0; i<employees.length; i++) {
			System.out.println("Employee Name "+ employees[i].getName());
			System.out.println("Employee Id " + employees[i].getEmployeeId());
			System.out.println("Employee Salary "+ employees[i].getSalary());
		}
		
		
	}

}
