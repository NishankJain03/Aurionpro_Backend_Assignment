package com.apro.model;

public class Operations {
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	public static int subtract(int num1, int num2) {
		return num1 - num2;
	}
	public static int multiply(int num1, int num2) {
		return num1 * num2;
	}
	public static int divide(int num1, int num2) {
		return num1 / num2;
	}
	public static void main(String[] args) {
		int a = 20;
		int b = 10;
		
		int sum = add(a,b);
		int diff = subtract(a,b);
		int product = multiply(a,b);
		int division = divide(a,b);
		
		System.out.println("The addition of " + a + " and " + b + " " + "is " +  sum);
		System.out.println("The subtraction of " + a + " and " + b + " " + "is " + diff);
		System.out.println("The division of " + a + " and " + b + " " + "is " + division);
		System.out.println("The multiplication of " + a + " and " + b + " " + "is " + product);
		
		
		
		
	}

}
