package com.aurionpro.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aurionpro.exceptions.EmailException;

public class UserLogin {
	private String email;
	private String password;
	
	public UserLogin(String email,String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [email=" + email + ", password=" + password + "]";
	}
	
	public void validateEmail(String email) {
		if(email == null)
			throw new EmailException.NullPointerException();
		if(email.isEmpty())
			throw new EmailException.EmailIsEmpty();
		if(email.length() > 40)
			throw new EmailException.EmailLengthExceeds();
		if(!email.contains("@"))
			throw new EmailException.InvalidEmailFormat();
		if(!email.contains("."))
			throw new EmailException.InvalidEmailFormat();
		if(email.contains(" "))
			throw new EmailException.WhiteSpace();

	}
	
	public void validatePassword(String password) {
		if(password.length() < 8)
			throw new EmailException.PasswordLengthLess();
		if(!password.matches(".*[A-Z].*"))
			throw new EmailException.MissingUpperCaseLetter();
		if(!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*"))
			throw new EmailException.MissingSpecialCharacter();
		if(!password.matches(".*[0-9].*"))
			throw new EmailException.MissingDigits();
	}
	
}
