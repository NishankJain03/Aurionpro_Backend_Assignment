package com.aurionpo.abstractFactory.model;

import java.util.Scanner;

public class CurrentAccountFactory implements IAccountFactory{

	@Override
	public IAccount makeAccount(Scanner scanner) {
		long accountNumber = (long) (Math.random() * Math.pow(10, 10));
		System.out.println("Enter the name");
		String name = scanner.next();
		System.out.println("Enter the balance");
		double balance = scanner.nextDouble();
		// TODO Auto-generated method stub
		return new CurrentAccount(accountNumber, name, balance, 50000);
	}

}
