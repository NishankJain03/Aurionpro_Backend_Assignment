package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exceptions.EmailException.EmailIsEmpty;
import com.aurionpro.exceptions.EmailException.EmailLengthExceeds;
import com.aurionpro.exceptions.EmailException.InvalidEmailFormat;
import com.aurionpro.exceptions.EmailException.MissingDigits;
import com.aurionpro.exceptions.EmailException.MissingSpecialCharacter;
import com.aurionpro.exceptions.EmailException.MissingUpperCaseLetter;
import com.aurionpro.exceptions.EmailException.PasswordLengthLess;
import com.aurionpro.exceptions.EmailException.WhiteSpace;
import com.aurionpro.model.UserLogin;

public class UserLoginTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the email");
		String email = scanner.nextLine();
		
		UserLogin userLogin = new UserLogin(email, "");
		boolean checkEmailValidation = false;
		boolean checkPasswordValidation = false;
		try {
			userLogin.validateEmail(email);
			checkEmailValidation = true;
			System.out.println("Email is Valid");
			
			System.out.println("Enter the password");
			String password =  scanner.next();
			userLogin.setPassword(password);
			
			checkPasswordValidation = passwordExceptionHandler(userLogin, password, checkPasswordValidation);
			
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}catch(EmailIsEmpty e) {
			System.out.println(e.getMessage());
		}catch(EmailLengthExceeds e) {
			System.out.println(e.getMessage());
		}catch(InvalidEmailFormat e) {
			System.out.println(e.getMessage());
		}catch(WhiteSpace e) {
			System.out.println(e.getMessage());
		}
		
		if(checkEmailValidation && checkPasswordValidation)
			System.out.println(userLogin);
	}
	
	private static boolean passwordExceptionHandler(UserLogin userLogin, String password, boolean checkPasswordValidation) {
		try {
			userLogin.validatePassword(password);
			System.out.println("Password is valid");
			return true;
		}catch(PasswordLengthLess e) {
			System.out.println(e.getMessage());
		}catch(MissingUpperCaseLetter e) {
			System.out.println(e.getMessage());
		}catch(MissingSpecialCharacter e) {
			System.out.println(e.getMessage());
		}catch(MissingDigits e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

}
