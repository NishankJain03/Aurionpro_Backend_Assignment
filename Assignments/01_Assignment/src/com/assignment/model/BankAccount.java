package com.assignment.model;

public class BankAccount {
	private long accountNumber;
	private String name;
	private double balance;
	
	public void setAccountNumber(long accNumber) {
		accountNumber = accNumber;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setName(String fname) {
		name = fname;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBalance(double Accbalance) {
		balance = Accbalance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	
	public void depositAmount(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Amount credited successfully New balance is " + balance);
		}else {
			System.out.println("Enter valid value");
		}
	}
	
	public void withdrawMoney(double amount) {
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
