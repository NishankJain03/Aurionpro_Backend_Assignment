package com.aurionpro.selection.test;

import java.util.Scanner;

public class TemperatureConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the temperature");
		double temperature = sc.nextDouble();
		
		System.out.println("Choose conversion:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        
        int choice = sc.nextInt();
        
        switch(choice) {
        case 1:
        	double fahrenheit = (temperature * 9 / 5) + 32;
        	System.out.println("Celsius to Farenheit " + fahrenheit + " F");
        	break;
        case 2: 
        	double celsius = (temperature - 32) * 5 / 9;
        	System.out.println("Farenheit to Celsius " + celsius + " °C");
        	break;
        case 3:
        	double kelvin = temperature + 273.15;
        	System.out.println("Celsius to Kelvin " + kelvin + " K");
        	break;
        case 4: 
        	double Kcelsius = temperature - 273.15;
        	System.out.println("Kelvin to Celsius " + Kcelsius + " °C");
        	break;
        case 5:
        	double Fkelvin = (temperature - 32) * 5 / 9 + 273.15;
        	System.out.println("Fahrenheit to Kelvin " + Fkelvin + " F");
        	break;
        case 6:
        	double kFarenheit = (temperature - 273.15) * 9 / 5 + 32;
        	System.out.println("Kelvin to Fahrenheit " + kFarenheit + " K");
        	break;
        default:
        	System.out.println("Please choose valid conversion operation");
        	
        }

	}

}
