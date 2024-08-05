package com.assignment.test;

import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your weight in kilograms: ");
		double weight = sc.nextDouble();
		
		System.out.println("Enter your height in meters: ");
		double height = sc.nextDouble();
		
		double bmi = weight / (height * height);
		
		System.out.println("Your Body Mass Index (BMI) is " + bmi);
		
		if(bmi < 18.5) {
			System.out.println(" You are underweight");
		} else if(bmi >= 18.5 && bmi < 24.9) {
			System.out.println(" You have a normal weight");
		} else if(bmi >= 25 && bmi < 29.9) {
			System.out.println(" You are overweight");
		} else {
			System.out.println(" You are obese");
		}
		

	}

}
