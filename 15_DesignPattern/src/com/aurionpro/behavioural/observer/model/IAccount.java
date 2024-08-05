package com.aurionpro.behavioural.observer.model;

public interface IAccount {
	void notifyApp(Account account, String message, double previousBalance);
}
