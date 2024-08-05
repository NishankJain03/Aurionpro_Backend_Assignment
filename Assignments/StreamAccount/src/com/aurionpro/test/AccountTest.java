package com.aurionpro.test;



import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Arrays;
import java.util.Optional;

import com.aurionpro.model.Account;

public class AccountTest {

	public static void main(String[] args) {
		
		Account acc1 = new Account(101, "Aclice", 5000);
		Account acc2 = new Account(102, "Bob", 7500);
		Account acc3 = new Account(103, "Charlie", 12000);
		
		Account accContainer = new Account(0, "Account Container",0);
		accContainer.setAccounts(Arrays.asList(acc1,acc2,acc3));
		
		
		Optional<Account> minBalance = accContainer.getMinimumBalance();
		System.out.println(minBalance);
		
		Optional<Account> maxBalance = accContainer.getMaxBalance();
		System.out.println(maxBalance);
	}

}
