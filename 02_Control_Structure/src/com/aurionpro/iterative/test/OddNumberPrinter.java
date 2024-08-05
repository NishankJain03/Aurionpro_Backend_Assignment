package com.aurionpro.iterative.test;

public class OddNumberPrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 1;
		while(number <= 100) {
			if(number % 2 != 0) System.out.println("Odd number is " + number);
			number ++;
		}

	}

}
