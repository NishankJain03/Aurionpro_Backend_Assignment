package com.aurionpro.exceptions;

public class EmailException extends RuntimeException{
	public static class NullPointerException extends EmailException{
		public String getMessage() {
			return "Email address is null";
		}
	}
	
	public static class EmailIsEmpty extends EmailException{
		public String getMessage() {
			return "Email address is empty";
		}
	}
	
	public static class EmailLengthExceeds extends EmailException{
		public String getMessage() {
			return "Email address length exceeds the maximum limit set";
		}
	}
	
	public static class InvalidEmailFormat extends EmailException{
		public String getMessage() {
			return "Invalid Email Format";
		}
	}
	
	public static class WhiteSpace extends EmailException{
		public String getMessage() {
			return "There should be no whitespace";
		}
	}
	
	public static class PasswordLengthLess extends EmailException{
		public String getMessage() {
			return "Password length should be greater than eight";
		}
	}
	public static class MissingUpperCaseLetter extends EmailException{
		public String getMessage() {
			return "Password must contain atleast one UpperCase Letter";
		}
	}
	public static class MissingSpecialCharacter extends EmailException{
		public String getMessage() {
			return "Password must contain atleast one Special Character ";
		}
	}
	public static class MissingDigits extends EmailException{
		public String getMessage() {
			return "Password must contain atleast one digit";
		}
	}
	
}
