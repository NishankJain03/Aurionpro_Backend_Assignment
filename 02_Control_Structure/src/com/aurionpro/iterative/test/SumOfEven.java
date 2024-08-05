package com.aurionpro.iterative.test;

public class SumOfEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 2;
		int evenSum = 0;
		while(number <= 100) {
			if(number % 2 == 0) {
				evenSum += number;
			}
			number++;
		}
		System.out.println("Sum of Even number is " + evenSum);

	}

}
