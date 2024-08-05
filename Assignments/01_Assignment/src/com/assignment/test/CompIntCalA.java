package com.assignment.test;

import java.util.Scanner;

public class CompIntCalA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double principal = Double.parseDouble(args[0]);
		
		double rate = Double.parseDouble(args[1]);
		
		double time = Double.parseDouble(args[2]);
		
		double amount = principal * Math.pow((1 + rate / 100), time);
		double compoundInterest = amount - principal;
		
		System.out.println("The compound Interest is " + compoundInterest);

	}

}
