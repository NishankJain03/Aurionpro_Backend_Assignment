package com.intro.test;

import java.util.Scanner;

public class Swapper {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter the First Number");
		int num1 = sc.nextInt();
		System.out.println("Enter the Second Number");
		int num2 = sc.nextInt();
		
		System.out.println("Before Swapping");
		System.out.println("Number1 is: " + num1 + " Number2 is " + num2);
		
		int temp = num1;
		num1 = num2;
		num2 = temp;
		
		System.out.println("After Swapping");
		System.out.println("Number1 is: " + num1 + " Number2 is " + num2);
		

	}

}
