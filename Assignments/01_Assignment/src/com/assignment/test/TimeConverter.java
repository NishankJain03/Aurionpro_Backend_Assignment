package com.assignment.test;

import java.util.Scanner;

public class TimeConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of minutes: ");
		int totalMinutes = sc.nextInt();
		
		int hours = totalMinutes / 60;
		int minutes = totalMinutes % 60;
		
		System.out.println(totalMinutes + " minutes is equals to " + hours + " hours " + "and " + minutes + " minutes ");
		
		

	}

}
