package com.aurionpro.behavioural.observer.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private long accountNumber;
	private String name;
	private double balance;
	private List<IAccount> notifiers;
	public Account(long accountNumber, String name, double balance) {
		super();
		this.notifiers = new ArrayList<>();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void credit(int amount) {
		if(amount < 0) {
			System.out.println("Enter valid value");
			return;
		}
		double previousBalance = balance;
		balance += amount;
		System.out.println("Amount credited successfully New balance is " + balance);
//		this.notificationState = "Credit The Previous Balance is " + (balance - amount);
		sendNotification("credit", previousBalance);
		
	}
	public void debit(int amount) {
		
		if(amount < 0) {
			System.out.println("Invalid amount");
			return;
		}
		if(balance <= amount) {
			System.out.println("Insufficient balance");
			return;
		}
		double previousBalance = balance;
		balance -= amount;
		System.out.println("Amount debited successfully New balance is " + balance);
//		this.notificationState = "debit Previous Balance is " + (balance + amount);
		sendNotification("debit", previousBalance);
		
	}
	
	public void registerNotifier(IAccount notify) {
		notifiers.add(notify);
	}
	
	public void sendNotification(String message, double previousBalance) {
		for(IAccount notifier: notifiers) {
			notifier.notifyApp(this, message, previousBalance);
		}
	}
	
	
	
}
