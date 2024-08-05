package com.aurionpro.model;

public class PayPalPayments extends Payment{

	@Override
	public void processPayments() {
		// TODO Auto-generated method stub
		System.out.println("Processing payments through paypal");
		
	}

	@Override
	public void refund() {
		// TODO Auto-generated method stub
		System.out.println("Refunding payments through paypal");
		
	}
	

}
