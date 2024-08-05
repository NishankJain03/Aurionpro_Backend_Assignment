package com.aurionpro.exception;

public class AgeNotValidException extends RuntimeException{
	private int age;
	
	public AgeNotValidException(int age) {
		this.age = age;
	}

	public String getMessage() {
		return "Age cannot be less than 18. You have entered :" + age;
	}
}
