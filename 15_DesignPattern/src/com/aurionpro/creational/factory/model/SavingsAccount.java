package com.aurionpro.creational.factory.model;

public class SavingsAccount implements IAccount{
	private double balance;
	public SavingsAccount(double balance) {
		// TODO Auto-generated constructor stub
		this.balance = balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	@Override
	public void credit(int amount) {
		if(amount < 0) {
			System.out.println("Enter valid value");
			return;
		}
		balance += amount;
		System.out.println("Amount credited successfully New balance is " + balance);
	}

	@Override
	public void debit(int amount) {
		
		if(amount < 0) {
			System.out.println("Invalid amount");
			return;
		}
		if(balance <= amount) {
			System.out.println("Insufficient balance");
			return;
		}
		balance -= amount;
		System.out.println("Amount debited successfully New balance is " + balance);
		
	}
	
}
