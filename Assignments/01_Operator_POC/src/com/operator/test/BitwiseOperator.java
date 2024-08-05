package com.operator.test;

public class BitwiseOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// these operator used to perform manipulation of individual bits of a number
		// can used with any of integer types
		// AND , OR, XOR, ~
		// AND --> if both 1 then return 1 else 0
		// OR --> if both are 0 return 0 rest 1
		// XOR --> if both same then 0 if different then 1
		
		int number1 = 5;
		int number2 = 5;
		
		System.out.println("Bitwise And is " + (number1 & number2));
		System.out.println("Bitwise And is " + (number1 | number2));
		System.out.println("Bitwise And is " + (number1 ^ number2));
		System.out.println("Bitwise And is " + ~(number1));

	}

}
