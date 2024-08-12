package com.aurionpro.model;

import java.math.BigDecimal;

public class Account {
	private String accountNumber;
	private BigDecimal balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
    
    

}
