package com.aurionpro.selection.test;

import java.util.Scanner;

public class MaximumOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first number");
		int number1 = sc.nextInt();
		
		System.out.println("Enter the second number");
		int number2 = sc.nextInt();
		
		if(number1 > number2) {
			System.out.println("Number1 is greater than number2");
		}else {
			System.out.println("Number2 is greater than number1");
		}
		

	}

}
