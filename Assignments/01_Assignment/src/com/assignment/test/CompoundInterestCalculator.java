package com.assignment.test;

import java.util.Scanner;

public class CompoundInterestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the principal amount");
		double principal = sc.nextDouble();
		
		System.out.println("Enter the rate of interest (in %) ");
		double rate = sc.nextDouble();
		
		System.out.println("Enter the time period (in years");
		double time = sc.nextDouble();
		
		double amount = principal * Math.pow((1 + rate / 100), time);
		double compoundInterest = amount - principal;
		
		System.out.println("The compound Interest is " + compoundInterest);

	}

}
