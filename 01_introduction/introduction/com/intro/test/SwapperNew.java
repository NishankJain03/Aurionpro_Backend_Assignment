package com.intro.test;

import java.util.Scanner;

public class SwapperNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First Number");
		int number1 = sc.nextInt();
		System.out.println("Enter the Second Number");
		int number2 = sc.nextInt();
		
		System.out.println("Before Swapping");
		System.out.println("Number1 is: " + number1 + " Number2 is " + number2);
		
		number1 = number1 + number2;
		number2 = number1 - number2;
		number1 = number1 - number2;
		
		System.out.println("After Swapping");
		System.out.println("Number1 is: " + number1 + " Number2 is " + number2);

	}

}
