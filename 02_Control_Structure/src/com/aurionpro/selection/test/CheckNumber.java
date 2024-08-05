package com.aurionpro.selection.test;

import java.util.Scanner;

public class CheckNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number1 = sc.nextInt();
		
		if(number1 < 0) {
			System.out.println("The number is negative");
		}else {
			System.out.println("The number is positive");
		}

	}

}
