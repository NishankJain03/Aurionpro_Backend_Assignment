package com.aurionpro.creational.factory.model;

public class CurrentAccount implements IAccount{
	private double balance;
	
	public CurrentAccount(double balance) {
		super();
		this.balance = balance;
	}
	
	
	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	@Override
	public void credit(int amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Amount credited successfully New balance is " + balance);
		}else {
			System.out.println("Enter valid value");
		}
			
		
	}

	@Override
	public void debit(int amount) {
		if(amount > 0) {
			if(balance >= amount) {
				balance -= amount;
				System.out.println("Amount debited successfully New balance is " + balance);
			}else {
				System.out.println("Insufficient balance");
			}
		}else {
			System.out.println("Invalid amount");
		}
		
	}
	
}
