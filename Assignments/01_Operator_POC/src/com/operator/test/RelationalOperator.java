package com.operator.test;

public class RelationalOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// they are used to check the relations between the two variables
		// return the boolean result
		// extensively used in the looping statement
		
		//1. Equalto (==)
		String hello = "Hello";
		String world = "World";
		System.out.println("Are they equal " + (hello == world));
		
		//2. Not Equal to (!=)
		// return true if they are not equal to ;
		System.out.println("Are they equal " + (hello != world));
		
		//3. Greater than and less than
		int number1 = 10;
		int number2 = 25;
		System.out.println("Is Number1 greater than Number2 " + (number1 > number2));
		System.out.println("Is Number1 smaller than Number2 " + (number1 < number2));
		
		//4. Greater than equal to and lesser than equal to 
		int number3 = 26;
		int number4 = 25;
		System.out.println("Is Number1 greater than equal to Number2 " + (number1 >= number2));
		System.out.println("Is Number1 lesser than equal to Number2 " + (number1 <= number2));
		
		
		
		
		

	}

}
