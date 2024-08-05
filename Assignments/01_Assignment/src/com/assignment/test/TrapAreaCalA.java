package com.assignment.test;

public class TrapAreaCalA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double base1 = Double.parseDouble(args[0]);
		
		double base2 = Double.parseDouble(args[1]);
		
		double height = Double.parseDouble(args[2]);
		
		double area = ((base1 + base2) / 2 ) * height;
		
		System.out.println("The area of the trapezoid is " + area);
		

	}

}
