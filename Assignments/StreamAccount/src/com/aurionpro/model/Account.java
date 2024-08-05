package com.aurionpro.model;

import java.util.List;
import java.util.Optional;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	List<Account> accounts;
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
	
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	
	public Optional<Account> getMinimumBalance() {
		return accounts.stream().min((number1,number2) -> Double.compare(number1.getBalance() ,number2.getBalance()));
	}
	
	public Optional<Account> getMaxBalance(){
		return accounts.stream().max((number1,number2) -> Double.compare(number1.getBalance(), number2.getBalance()));
	}
	
	
	
}
