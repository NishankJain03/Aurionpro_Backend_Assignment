package com.aurionpro.iterative.test;

import java.util.Scanner;

public class PerfectChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int sum=0;
		int i =1;
		while(i <= number/2) {
			if(number % i == 0) {
				sum += i;
			}
			i++;
		}
		if(sum == number) {
			System.out.println("It is a perfect number");
		}else {
			System.out.println("It is not a perfect number");
		}
		
		

	}

}
