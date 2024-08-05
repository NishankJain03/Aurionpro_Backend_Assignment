package com.assignment.test;

public class DistCalA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x1 = Double.parseDouble(args[0]);
		
		double y1 = Double.parseDouble(args[1]);
		
		double x2 = Double.parseDouble(args[2]);
		
		double y2 = Double.parseDouble(args[3]);
		
		double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) );
		
		System.out.println("The distance between the point " + x1 + " , " + x2 + " " + " and " + y1 + " , " + y2 + " is " + distance);

	}

}
