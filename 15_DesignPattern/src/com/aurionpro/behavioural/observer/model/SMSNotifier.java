package com.aurionpro.behavioural.observer.model;

public class SMSNotifier implements IAccount{

	@Override
	public void notifyApp(Account account, String message, double previousBalance) {
		
		System.out.println("SMS notification: \n " + message  + "Previous Balance is " + previousBalance + " Current Balance is " + account.getBalance());	
		
	}

}
