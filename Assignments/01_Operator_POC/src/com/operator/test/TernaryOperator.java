package com.operator.test;

public class TernaryOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// takes the three operand
		// its the one liner replacement of if and else statement
		// syntax --> variable = Expression1 ? Expression2: Expression 3
		
		// it operates similar to that of
		//if(expression1){
		//	variable = expression2
		//} else {
		//	variable = expression3
		//}
		
		int number1 = 20;
		int number2 = 10;
		
		int res = (number1 > number2) ? (number1 + number2) : (number1 - number2);
		System.out.println("Result is " + res);

	}

}
