package com.assignment.test;

public class TimeConvA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalMinutes = Integer.parseInt(args[0]);
		
		int hours = totalMinutes / 60;
		int minutes = totalMinutes % 60;
		
		System.out.println(totalMinutes + " minutes is equals to " + hours + " hours " + "and " + minutes + " minutes ");

	}

}
