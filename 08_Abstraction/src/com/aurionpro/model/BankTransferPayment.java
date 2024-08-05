package com.aurionpro.model;

public class BankTransferPayment extends Payment{
	
	@Override
	public void processPayments() {
		// TODO Auto-generated method stub
		System.out.println("Processing payments through bank transfer");
		
	}

	@Override
	public void refund() {
		// TODO Auto-generated method stub
		System.out.println("Refunding payments through bank transfer");
		
	}

}
