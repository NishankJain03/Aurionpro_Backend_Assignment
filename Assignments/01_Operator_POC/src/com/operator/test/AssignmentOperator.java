package com.operator.test;

public class AssignmentOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// these operators are used to assign value to the variable
		// types --> simple (=) and compound (other operator along with =)
		
		//simple 
		int number1 = 2;
		char ch = 'y';
		
		//compound
		// perform implicit type casting
		// for example x = 5 and if we add 4.5 using
		// x = x + 4.5 // throws error
		// x += 4.5 // returns 9
		//1. (+=) --> a = a + b
		int number2 = 10;
		System.out.println("Addition is " + (number2 += 10));
		System.out.println("Subtraction is " + (number2 -= 10));
		System.out.println("Division is " + (number2 /= 10));
		System.out.println("Multiplication is " + (number2 *= 10));
		System.out.println("Modulo is " + (number2 %= 10));
		
		
		
		
		

	}

}
