package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.InsufficientBalanceException;
import com.aurionpro.model.Account;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the account Number");
		int accountNumber = scanner.nextInt();
		System.out.println("Enter the name");
		String name = scanner.next();
		System.out.println("Enter the balance");
		double balance = scanner.nextDouble();
		
		Account account = new Account(accountNumber, name, balance);
		while(true) {
			System.out.println("ATM Menu");
        	System.out.println("1. Check Balance");
        	System.out.println("2. Deposit Money");
        	System.out.println("3. Withdraw Money");
        	System.out.println("4. Exit");
        	System.out.println("Choose Options");
        	
        	int choice = scanner.nextInt();
        	
        	switch(choice) {
        	case 1:
        		System.out.println("Account balance " + account.getBalance());
        		break;
        	case 2:
        		System.out.println("Enter the amount to credit");
        		double creditAmount = scanner.nextDouble();
        		account.credit(creditAmount);
        		break;
        	case 3:
        		System.out.println("Enter the amount to debit");
        		double depositAmount = scanner.nextDouble();
        		try {
        		account.debit(depositAmount);
        		}catch (InsufficientBalanceException e) {
        			System.out.println(e.getMessage());
        		}
        		break;
        	case 4:
        		System.out.println("Existing");
        		break;
        	default:
        		System.out.println("Invalid option");
        	}
        	
        	
		}	
		
//		System.out.println(account);

	}

}
