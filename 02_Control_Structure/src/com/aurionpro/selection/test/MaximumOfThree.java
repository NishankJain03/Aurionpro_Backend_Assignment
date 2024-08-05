package com.aurionpro.selection.test;

import java.util.Scanner;

public class MaximumOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first number");
		int number1 = sc.nextInt();
		
		System.out.println("Enter the second number");
		int number2 = sc.nextInt();

		System.out.println("Enter the third number");
		int number3 = sc.nextInt();
		
		if(number1 > number2) {
			if(number3 > number1) {
				System.out.println("Number3 is greater");
			}
			else {
				System.out.println("Number1 is greater");
			}
		}else {
			if(number3 > number2) {
				System.out.println("Number3 is greater");
			}
			else {
				System.out.println("Number2 is greater");
			}
		}
	}

}
