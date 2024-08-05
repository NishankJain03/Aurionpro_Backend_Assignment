package com.aurionpro.test;

import java.util.Scanner;

public class InputValidatorTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the username");
		String username = scanner.next();
		validateUsername(username);
		
		System.out.println("Enter the password");
		String password = scanner.next();
		validatePassword(password);
		
		System.out.println("Enter the email");
		String email = scanner.next();
		validateEmail(email);
		

	}
	
	private static void validateUsername(String username) {
		if(validates(username, 3, 20)) {
			System.out.println("Username is valid");
			return;
		}
		System.out.println("Enter the valid username");
	}
	
	private static void validatePassword(String password) {
		if(validates(password, 8, 30)) {
			System.out.println("Password is valid");
			return;
		}
		System.out.println("Enter the valid password");
	}
	
	private static void validateEmail(String email) {
		if(validates(email, 5, 50) && email.contains("@") && email.contains(".")) {
			System.out.println("Email is valid");
			return;
		}
		System.out.println("Enter the valid email");
	}
	
	private static boolean validates(String input, int minLength, int maxLength) {
		if(input != null && input.length() > minLength && input.length() < maxLength) {
			return true;
		}
		return false;
	}

}
