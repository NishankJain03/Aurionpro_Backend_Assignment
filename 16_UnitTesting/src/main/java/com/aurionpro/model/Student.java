package com.aurionpro.model;

public class Student {
	private IStudentService studentService;
	
	
	
	public Student(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}



	public double calculatePercentage() {
		return ((studentService.getMarks()/studentService.getNumberOfSubjects()));
	}
}
