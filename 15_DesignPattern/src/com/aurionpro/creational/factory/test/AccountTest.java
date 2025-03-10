package com.aurionpro.creational.factory.test;

import com.aurionpro.creational.factory.model.AccountFactory;
import com.aurionpro.creational.factory.model.IAccount;

public class AccountTest {

	public static void main(String[] args) {
		IAccount account;
		
		account = AccountFactory.makeAccount("Savings", 34000);
		account.credit(34000);
		account.debit(21000);
		
		account = AccountFactory.makeAccount("Current", 23000);
		account.credit(25000);
		account.debit(24000);

	}

}
