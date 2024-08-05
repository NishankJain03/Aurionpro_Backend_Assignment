package com.operators.test;

public class OperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 7;
		
//		int c = a++;
//		int d = c + b++;
//		
//		System.out.println(c);
//		System.out.println(d);
		
		int result = a & b;
		
		System.out.println("Logical Operator AND " + result);
		System.out.println("Logical Operator OR " + (a | b));
		
		if((a < b) && (b > a)) {
			System.out.println("true");
		}
		
		

	}

}
