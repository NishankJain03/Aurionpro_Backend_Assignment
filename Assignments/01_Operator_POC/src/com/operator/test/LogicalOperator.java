package com.operator.test;

public class LogicalOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// used to perform logical operation --> AND, OR, NOT
		// AND --> return true if all the conditions are met
		int number1 = 10;
		int number2 = 12;
		int number3 = 13;
		if((number1 > number2) && (number2 > number3)) {
			System.out.println("All the condition are met");
		} else if((number1 > number2) || (number2 < number3)) {
			System.out.println("Only one condition is met");
		}
		
		// NOT --> unary operator
		boolean result = !(number1 > number2);
		System.out.println("!(number1 > number2) " + result);
		
		

	}

}
