package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aurionpro.model.Employee;
import com.aurionpro.model.EmployeeComparator;

public class EmployeeSet {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(2, "nishank", 80000.0));
		employees.add(new Employee(4, "jain", 75000.0));
		employees.add(new Employee(1, "abcc", 85000.0));
		employees.add(new Employee(5, "xyzz", 90000.0));
		
		System.out.println("Sorted list of employee based on employeeid");
		Collections.sort(employees, new EmployeeComparator.EmployeeIdComparator());
		for(Employee employee : employees)
			System.out.println(employee);
		
		System.out.println("Sorted list of employee based on name");
		Collections.sort(employees, new EmployeeComparator.EmployeeNameComparator());
		for(Employee employee : employees)
			System.out.println(employee);

		System.out.println("Sorted list of employee based on salary");
		Collections.sort(employees, new EmployeeComparator.EmployeeSalaryComparator());
		for(Employee employee : employees)
			System.out.println(employee);
		
		

	}

}
