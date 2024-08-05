package com.aurionpro.model;

public class Reference {
	private int number1;
	public Reference(){
		System.out.println("Inside the constructor");
	}
	public Reference(int number1) {
		System.out.println("This is parameterized constructor " + number1);
	}
	
	public void print() {
		System.out.println("Inside the reference");
	}
	
	public static void staticPrint() {
		System.out.println("Inside the static reference");
	}

}
