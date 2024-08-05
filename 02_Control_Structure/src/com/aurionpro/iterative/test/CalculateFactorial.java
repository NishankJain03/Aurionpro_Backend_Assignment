package com.aurionpro.iterative.test;

import java.util.Scanner;

public class CalculateFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = scanner.nextInt();
		int sum = 1;
		for(int i=number; i>=1;i--) {
			sum = sum * i;
		}
		System.out.println("Factorial " + sum);

	}

}
