package com.assignment.test;

import java.util.Scanner;

public class PrimePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of rows");
		int noOfRows = scanner.nextInt();
		
		int number = 2;
		for(int i = 1; i<= noOfRows; i++) {
			for(int j=1; j<=i;j++) {
				while(true) {
					boolean isPrime = true;
					for(int k = 2; k <= number/2; k++) {
						if(number % k == 0) {
							isPrime = false;
							break;
						}
					}
					if(isPrime) {
						System.out.print(number + " ");
						number++;
						break;
					}
					number++;
				}
			}
			System.out.println();
		}
		scanner.close();
		
	}

}
