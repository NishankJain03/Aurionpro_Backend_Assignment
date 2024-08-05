	package com.aurionpro.iterative.test;
	
	import java.util.Scanner;

public class PrimeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = scanner.nextInt();
		int i = 2;
		while(i < number) {
			if(number % i == 0) {
				System.out.println("It is not a prime");
				return;
			}
			i++;
			
		}
		System.out.println("It is prime");
		scanner.close();
		
	}

}
