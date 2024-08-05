package com.aurionpro.iterative.test;

import java.util.Scanner;

public class CalculateSumDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Number");
		int number = scanner.nextInt();
		int sum = 0;
		while(number > 0) {
			int remainder = number% 10;
			sum += remainder;
			number /= 10;		
		}
		System.out.println("Sum of digits " + sum);
		
		scanner.close();
	}

}
