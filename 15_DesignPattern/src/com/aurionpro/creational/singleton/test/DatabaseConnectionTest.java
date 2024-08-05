package com.aurionpro.creational.singleton.test;

import com.aurionpro.creational.singleton.model.DatabaseConnection;

public class DatabaseConnectionTest {

	public static void main(String[] args) {
		DatabaseConnection databaseConnection = DatabaseConnection.getDatabase();
		databaseConnection.status();
		System.out.println(databaseConnection.hashCode());

	}

}
