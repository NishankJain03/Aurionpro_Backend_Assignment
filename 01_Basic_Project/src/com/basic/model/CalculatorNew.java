package com.basic.model;
import java.util.*;
public class CalculatorNew {
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	public static int subtract(int num1, int num2) {
		return num1 - num2;
	}
	public static int multiply(int num1, int num2) {
		return num1 * num2;
	}
	public static int divide(int num1, int num2) {
		if(num2 == 0) {
			System.out.println("Cannot divide by zero");
			return 0;
		}
		return num1 / num2;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two numbers");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		
		char operation = 'y';
		while(operation != 'x') {
			System.out.println("Enter the operation need to perform");
			operation = sc.next().charAt(0);
			switch(operation) {
			case '+':
				System.out.println("The addition of " + num1 + " and " + num2 + " is " + add(num1, num2));
				break;
			case '-':
				System.out.println("The subtraction of " + num1 + " and " + num2 + " is " + subtract(num1, num2));
				break;
			case '*':
				System.out.println("The product of " + num1 + " and " + num2 + " is " + multiply(num1, num2));
				break;
			case '/':
				System.out.println("The division of " + num1 + " and " + num2 + " is " + divide(num1, num2));
				break;
			case 'x':
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid Operation");
			}
		}
		sc.close();
		
	}
}
