package com.assignment.test;

import java.util.Scanner;

public class TrapezoidAreaCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the length of the first base");
		double base1 = sc.nextDouble();
		
		System.out.println("Enter the length of the second base");
		double base2 = sc.nextDouble();
		
		System.out.println("Enter the height of the trapezoid");
		double height = sc.nextDouble();
		
		double area = ((base1 + base2) / 2 ) * height;
		
		System.out.println("The area of the trapezoid is " + area);
		

	}

}
