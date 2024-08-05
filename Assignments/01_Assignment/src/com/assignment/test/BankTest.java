package com.assignment.test;

import java.util.Scanner;
import java.util.Random;

import com.assignment.model.AccountType;
import com.assignment.model.Bank;

public class BankTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
//		long acconutNumber = (long) (Math.random() * Math.pow(10, 10));
//		System.out.println("Enter the number of accounts");
		boolean isEqual = false;
		boolean accountCreated = true;
		Bank accounts[] = null;
		
		boolean exit = false;
		
		System.out.println("Enter the number of account to create");
		int size = scanner.nextInt();
		accounts = new Bank[size];
		accountCreated = true;
		
		//account creation
		for(int i=0; i<accounts.length; i++) {
			long accountNumber = (long) (Math.random() * Math.pow(10, 10));
			System.out.println("Enter the name of account holder " + accountNumber);
			String name = scanner.next();
			
			for(int j=0;j<accounts.length;j++) {
				if(accounts[j] != null && accounts[j].getName().equals(name)) {
    				System.out.println("Account holder with name already exits");
    				isEqual = true;
    			}
			}
			if(isEqual) {
				break;
			}
			System.out.println("Enter the initial balance for account " + (i+1));
    			double balance = scanner.nextDouble();
    			System.out.println("Enter the type of account for acconut " + (i+1));
    			System.out.println("Press S for Savings or C for Current");
    			String accountType = scanner.next();
    			if(accountType == "S") {
    				accounts[i] = new Bank(accountNumber, name, balance, AccountType.savings);
    				return;
    			}
    			accounts[i] = new Bank(accountNumber, name, balance, AccountType.current);
    			   			
		}
		
		while(!exit) {
			System.out.println("ATM Menu");
        	System.out.println("1. Check Balance");
        	System.out.println("2. Deposit Money");
        	System.out.println("3. Withdraw Money");
        	System.out.println("4. Exit");
        	System.out.println("Choose Options");
        	
        	int choice = scanner.nextInt();
        	
        	switch(choice) {
        	case 1:
        		if(accountCreated) {
        			System.out.println("Enter the name of the account holder");
        			String name = scanner.next();
        			Bank account = findAccount(accounts, name);
        			if(account != null) {
        				System.out.println("Account balance " + account.getBalance());
        			}else {
        				System.out.println("Account not found");
        			}
        			
        		}else {
        			System.out.println("Account not created");
        		}
        		break;
        	case 2:
        		if(accountCreated) {
        			System.out.println("Enter the name of the account holder");
        			String name = scanner.next();
        			Bank account = findAccount(accounts, name);
        			if(account != null) {
        				System.out.println("Enter the amount to credit");
        				double amount = scanner.nextDouble();
        				account.credit(amount);
        			}else {
        				System.out.println("Account not found");
        			}
        			
        		}else {
        			System.out.println("Account not created");
        		}
        		break;
        	case 3:
        		if(accountCreated) {
        			System.out.println("Enter the name of the account holder");
        			String name = scanner.next();
        			Bank account = findAccount(accounts, name);
        			if(account != null) {
        				System.out.println("Enter the amount to debit");
        				double amount = scanner.nextDouble();
        				account.debit(amount);
        			}else {
        				System.out.println("Account not found");
        			}
        			
        		}else {
        			System.out.println("Account not created");
        		}
        		break;
        	case 4:
        		exit = true;
        		System.out.println("Existing");
        		break;
        	default:
        		System.out.println("Invalid option");
        	}
        	
        	
		}	
	if(accountCreated) {
		Bank maxBalanceAccount = Bank.getMaximumBalance(accounts);
		if(maxBalanceAccount != null) {
			System.out.println("Account with max Balance is ");
			maxBalanceAccount.displayDetails();
		}else{
			System.out.println("No account available");
		}
	}
		
	}
	private static Bank findAccount(Bank accounts[], String name) {
		for(int i=0;i<accounts.length; i++) {
			if(accounts[i].getName().equals(name)) {
				return accounts[i];
			}
		}
		return null;
	}	

}
