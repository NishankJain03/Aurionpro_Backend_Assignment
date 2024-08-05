package com.aurionpro.model;

import java.util.Comparator;

public class EmployeeComparator {
	public static class EmployeeIdComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getEmployeeId()-o2.getEmployeeId();
		}
		
	}
	
	public static class EmployeeNameComparator implements Comparator<Employee>{
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}
	
	public static class EmployeeSalaryComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.getSalary() > o2.getSalary())
				return 1;
			if(o1.getSalary() < o2.getSalary())
				return -1;
			return 0;
		}

	}
}
