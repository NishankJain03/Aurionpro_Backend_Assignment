package com.aurionpro.iterative.test;

import java.util.Scanner;

public class PalindromeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = scanner.nextInt();
		int temp = number;
		int reverse = 0;
		while(number > 0) {
			int remainder = number % 10;
			reverse = reverse*10 + remainder;
			number /= 10;
		}
		if(temp == reverse) {
			System.out.println("It is Palindrome");
		}else {
			System.out.println("Not a palindrome");
		}
		

	}

}
