package com.assignment.test;

import java.util.Scanner;

public class HeightWiseBillCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the height in cms");
		double height = scanner.nextDouble();
	
		int charge = 0;
		if(height > 120) {
			System.out.println("Can Ride");
			System.out.println("Enter the age");
			int age = scanner.nextInt();
			if(age < 12) {
				charge += 5;
			} else if (age >= 12 && age < 18) {
				charge += 7;
			} else if(age >= 18) {
				if(age >= 45 && age <= 55) {
					charge += 0;
				}else {
					charge += 12;
					}
				}
			System.out.println("Do you want Photos");
			boolean isPhoto = scanner.nextBoolean();
			if(isPhoto) {
				charge += 3;
			}
			
			}
		else {
			System.out.println("You can't ride");
		}
		
		System.out.println("Total Bill is "  + charge);
		
		scanner.close();
		
		
	}

}
