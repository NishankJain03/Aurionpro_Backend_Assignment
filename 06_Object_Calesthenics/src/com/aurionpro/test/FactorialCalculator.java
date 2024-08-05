package com.aurionpro.test;

import java.util.Scanner;

public class FactorialCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number");
		Integer number = scanner.nextInt();
		
		int factorial = calculateFactorial(number);
		if(factorial == -1) {
			System.out.println("Cannot calculate factorial of negative number ");
			return;
		}
		System.out.println("Factorial is " + factorial);

	}
	
	private static int calculateFactorial(int number) {
		if(number == 0 || number < 0) return 1;
		int fact = 1;
		for(int i=1; i<=number;i++) {
			fact = fact * i;
		}
		return fact;
	}

}

// wrap all the primitive and strings --> int --> Integer
// use only one dot per line
// dont abbreviate
// keep all the entities small
// dont use any classes with more than two instance variable
// use first-class collection
// dont use getter/setters/properties