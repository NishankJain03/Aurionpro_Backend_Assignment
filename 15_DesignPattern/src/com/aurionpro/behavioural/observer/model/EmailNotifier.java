package com.aurionpro.behavioural.observer.model;

public class EmailNotifier implements IAccount{

	@Override
	public void notifyApp(Account account, String message, double previousBalance) {
		System.out.println("Email notification: \n " + message  + "Previous Balance is " + previousBalance +" Current Balance is " + account.getBalance());
		
	}
	
}
