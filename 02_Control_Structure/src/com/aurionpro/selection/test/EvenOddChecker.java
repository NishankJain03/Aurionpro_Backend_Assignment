package com.aurionpro.selection.test;

import java.util.Scanner;


public class EvenOddChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int number1 = sc.nextInt();
		
		if(number1 % 2 == 0) {
			System.out.println("Number is Even");
		}else {
			System.out.println("Number is Odd");
		}

	}

}
