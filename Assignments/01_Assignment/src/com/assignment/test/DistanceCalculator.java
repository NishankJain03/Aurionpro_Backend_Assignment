package com.assignment.test;

import java.util.Scanner;

public class DistanceCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the x1 coordinate");
		double x1 = sc.nextDouble();
		
		System.out.println("Enter the y1 coordinate");
		double y1 = sc.nextDouble();
		
		System.out.println("Enter the x2 coordinate");
		double x2 = sc.nextDouble();
		
		System.out.println("Enter the y2 coordinate");
		double y2 = sc.nextDouble();
		
		double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) );
		
		System.out.println("The distance between the point " + x1 + " , " + x2 + " " + " and " + y1 + " , " + y2 + " is " + distance);

	}

}
