package com.aurionpro.test;

import java.util.Scanner;

public class EvenOddChecker {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = scanner.nextInt();
		
		if(number % 2 == 0) {
			System.out.println("Number is even");
			return;
		}
		System.out.println("Number is odd ");

	}

}

//Rule 2 --> dont use else keyword --> instead use return keyword