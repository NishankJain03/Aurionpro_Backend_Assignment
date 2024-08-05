package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Account;
import com.aurionpro.model.INotifier;
import com.aurionpro.model.SMSNotification;

public class AccountTest {

	public static void main(String[] args) {
		List<INotifier> notifiers = new ArrayList<>();
		Account account = new Account(1233, "Nishank", 43000);
		notifiers.add(new SMSNotification());
		
		account.registerNotifier(notifiers);
		account.deposit(43000);
		account.withdraw(23000);

	}

}
