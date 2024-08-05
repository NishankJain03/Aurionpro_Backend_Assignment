package com.aurionpro.model;

import java.util.List;
import java.util.function.DoubleToLongFunction;


public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	List<INotifier> notifiers;
	public Account(int accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
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
	public List<INotifier> getNotifiers() {
		return notifiers;
	}
	public void setNotifiers(List<INotifier> notifiers) {
		this.notifiers = notifiers;
	}
	
	public void deposit(int amount) {
		if(amount < 0) {
			System.out.println("Invalid amount");
			return;
		}
		double previousBalance = balance;
		balance += amount;
		System.out.println("Amount credit successfully New balance is " + balance);
		sendNotification("credit", previousBalance);
	}
	
	public void withdraw(int amount) {
		if(amount < 0) {
			System.out.println("Invalid amount");
			return;
		}
		double previousBalance = balance;
		balance -= amount;
		System.out.println("Debited successfully");
		sendNotification("debit", previousBalance);
	}
	
	public void registerNotifier(List<INotifier> notifiers) {
		for(INotifier notifier : notifiers) {
			setNotifiers(notifiers);
		}
	}
	
	public void sendNotification(String message, double previousBalance) {
		for(INotifier notifier : notifiers) {
			notifier.notifyApp(this, message, previousBalance);
		}
	}
	
	
	
	
	
}
