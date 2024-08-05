package com.operator.test;

public class UnaryOperator {

	public static void main(String[] args) {
		// these operator are the types that need only one operand to perform any operations
		// we can perform increment, decrement, negation etc
		
		//1. Unary minus --> convert a positive value into negative value
		int number1 = 10;
		number1 = -number1;
		System.out.println("Unary Minus:" + number1);
		
		//2. 'NOT' --> convert true to false or vice versa
		int number2 = 5;
		int number3 = 1;
		boolean condition = true;
		
		System.out.println("Before Applying NOT operator " + "number2 is " + number2 + " number3 is "  + number3 + " condition is " + condition);
		System.out.println("After Applying NOT operator condition is " + !condition);
		System.out.println(!(number2 > number3));
		System.out.println(!(number3 > number2));
		
		//3. Increment(++) --> used to increment the value
		//in post increment but previous value is retained until the execution of this statement 
		// and get updated before execution of the next statement
		// after using it in an expression
		int number4 = 11;
		System.out.println("Before Incrementing number is " + number4);
		number4++;
		System.out.println("After incrementing number is " + number4);
		//pre increment
		// the operand value is incremented instantly
		int number5 = 15;
		System.out.println("Before Incrementing number is " + number5);
		++number5;
		System.out.println("After incrementing number is " + number5);
		
		//4. Decrement
		// Post Decrement(--)
		int number6 = 13;
		System.out.println("Before Decrementing number is " + number6);
		number6--;
		System.out.println("After deccrementing number is " + number6);
		//pre decrement
		int number7 = 14;
		System.out.println("Before Decrementing number is " + number7);
		--number7;
		System.out.println("After Decrementing number is " + number7);
		
		//5. Bitwise Complement(~)
		// this returns the one's complement ie it makes every 0 to 1 and every 1 to 0
		int number8 = 5;  // the binary of 5 is 0101  //since leftmost is 0 --> positive
		int result = ~number8;
		System.out.println("Bitwise Complement is " + result);
		
		//binary of 5 -> 0000 0101
		// after complement -> 1111 1010
		// leftmost is 1 --> negative then -64+32+16+8+2 = -6
		
		
		
		

	}

}
