package com.aurionpro.model;

public class SMSNotification implements INotifier{

	@Override
	public void notifyApp(Account account, String message, double previousBalance) {
		System.out.println("Amount has been " + message + " successfully \n"
				+ "Your previous Balance was " + previousBalance + "\n" + 
				"Your current Balance is " + account.getBalance());
		
	}
	
}
