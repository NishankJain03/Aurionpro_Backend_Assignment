package com.aurionpro.model;

public class CreditCardPayment extends Payment{
	@Override
	public void processPayments() {
		System.out.println("Processing payments through credit card ");
	}
	
	@Override
	public void refund() {
		System.out.println("Refunding process through credit card");
	}

}
