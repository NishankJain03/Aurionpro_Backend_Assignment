package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.aurionpro.model.AccountApp;

public class AccountAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		List<AccountApp> account = new ArrayList<AccountApp>();
		System.out.println("Enter the number of account to be created");
		int size = scanner.nextInt();
		
		for(int i=0;i<size;i++) {
			long randomNumber = (long) (Math.random() * Math.pow(10, 10));
			System.out.println("Enter the name of the account holder");
			String name = scanner.next();
			System.out.println("Enter the balance");
			double balance = scanner.nextDouble();
			
			account.add(new AccountApp (randomNumber, name, balance));
		}
		
		AccountApp maxBalance = maximumBalance(account);
		System.out.println("Account with Maximum Balance is " + maxBalance);
		
		//sort the elements
		sortDescending(account);
		
		//printing the elements
		for(AccountApp accounts: account) {
			System.out.println(accounts);
		}
		
		
	}
	private static AccountApp maximumBalance(List<AccountApp> account) {
		AccountApp maxBalance = account.get(0);
		
		for(AccountApp accounts: account) {
			if(accounts.getBalance() > maxBalance.getBalance()) {
				maxBalance = accounts;
			}
		}
		return maxBalance;
			
	}
	private static void sortDescending(List<AccountApp> account) {
		for(int i=0; i< account.size(); i++) {
			for(int j=0; j<account.size()-i-1; j++) {
				if(account.get(j).getBalance() > account.get(j+1).getBalance() ) {
					AccountApp temp = account.get(j);
					account.set(j, account.get(j + 1));
	                account.set(j + 1, temp);
				}
			}
		}
	}

}
