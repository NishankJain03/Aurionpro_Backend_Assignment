package com.aurionpro.iterative.test;

import java.util.Scanner;

public class ArmstrongChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Number");
		int number = scanner.nextInt();
		int temp = number;
		
		int pow = 0;
		while(number > 0) {
			pow++;
			number /= 10;
		}
		number = temp;
		int sum = 0;
		while(number > 0) {
			int remainder = number% 10;
			sum += (int)Math.pow(remainder,pow);
			// sum += (int)Math.pow(remainder,3);
			number /= 10;		
		}
		if(sum == temp) {
			System.out.println("Number is armstrong");
		}else {
			System.out.println("Number is not armstrong");
		}
		scanner.close();
		

	}

}
