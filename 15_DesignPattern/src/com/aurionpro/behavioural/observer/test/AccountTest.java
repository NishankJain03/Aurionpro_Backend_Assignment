package com.aurionpro.behavioural.observer.test;

import java.util.Scanner;

import com.aurionpro.behavioural.observer.model.Account;
import com.aurionpro.behavioural.observer.model.EmailNotifier;
import com.aurionpro.behavioural.observer.model.SMSNotifier;

public class AccountTest {

	public static void main(String[] args) {
		Account account = new Account(123333, "nishank", 430000);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount to credit");
		int amount = scanner.nextInt();
		account.registerNotifier(new SMSNotifier());
		account.registerNotifier(new EmailNotifier());
		account.credit(amount);
		
		System.out.println("Enter the amount to debit");
		int debitAmount = scanner.nextInt();
		account.debit(debitAmount);

	}

}
