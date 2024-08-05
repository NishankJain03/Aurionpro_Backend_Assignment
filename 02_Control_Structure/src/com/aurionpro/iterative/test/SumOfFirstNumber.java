package com.aurionpro.iterative.test;

public class SumOfFirstNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 1;
		int sum = 0;
		while(number <= 100) {
			sum += number;
			number++;
		}
		System.out.println("The sum of first 100 number is " + sum);

	}

}
