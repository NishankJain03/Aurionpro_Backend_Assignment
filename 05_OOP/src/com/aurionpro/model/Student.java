package com.aurionpro.model;

public class Student {
	private int rollNo;
	private String name;
	private int age;
	private double percentage;
	
	
	//default constructor
	public Student() {
		this.rollNo = 79;
		this.name = "nishank";
		this.age = 21;
		this.percentage = 89;
	}
	
	//parameterized 
	public Student(int rollNo, String name, int age, double percentage) {
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.percentage = percentage;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getRollNo() {
		return this.rollNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	
	
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public double getPercentage() {
		return this.percentage;
	}
}


