package com.aurionpro.exception;

public class InsufficientBalanceException extends RuntimeException{
	private double balance;

	public InsufficientBalanceException(double balance) {
		super();
		this.balance = balance;
	}
	
	public String getMessage() {
		return "You have Insufficient Balance " + balance;
	}
}
