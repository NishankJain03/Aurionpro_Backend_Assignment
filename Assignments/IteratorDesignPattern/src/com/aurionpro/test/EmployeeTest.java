package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Employee;
import com.aurionpro.model.EmployeeIterator;

public class EmployeeTest {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Nishank", 50000));
		employees.add(new Employee("rahul", 343333));
		employees.add(new Employee("raj", 45000));
		employees.add(new Employee("rahulll", 53000));
		employees.add(new Employee("ra", 20000));
		
		EmployeeIterator employeeIterator = new EmployeeIterator(employees);
		
		double totalSalary = 0;
		while(employeeIterator.hasNext()) {
			totalSalary += employeeIterator.next().getSalary();
		}
		
		System.out.println("Total Salary " + totalSalary);

	}

}
