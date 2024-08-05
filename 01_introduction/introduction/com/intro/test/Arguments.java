package com.intro.test;

public class Arguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1 = Integer.parseInt(args[0]);
		int number2 = Integer.parseInt(args[1]);
		
		System.out.println("Before Swapping");
		System.out.println("Number1 is: " + number1 + " Number2 is " + number2);
		
		number1 = number1 + number2;
		number2 = number1 - number2;
		number1 = number1 - number2;
		
		System.out.println("After Swapping");
		System.out.println("Number1 is: " + number1 + " Number2 is " + number2);

	}

}
