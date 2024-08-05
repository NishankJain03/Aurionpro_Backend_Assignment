package com.aurionpro.model;

public class AccountApp {
	private long accountNumber;
	private String name;
	private double balance;
	public AccountApp(long accountNumber, String name, double balance) {
		super();
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
	@Override
	public String toString() {
		return "AccountApp [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
