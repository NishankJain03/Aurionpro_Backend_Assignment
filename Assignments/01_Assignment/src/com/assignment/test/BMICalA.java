package com.assignment.test;

public class BMICalA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double weight = Double.parseDouble(args[0]);
		
		double height = Double.parseDouble(args[1]);
		
		double bmi = weight / (height * height);
		
		System.out.printf("Your Body Mass Index (BMI) is " + bmi);
		
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
