package com.aurionpro.creational.singleton.model;

public class DatabaseConnection {
	private static DatabaseConnection databaseConnection;
	
	public DatabaseConnection() {
		System.out.println("Database Created");
	}
	
	public static DatabaseConnection getDatabase() {
		if(databaseConnection == null)
			databaseConnection = new DatabaseConnection();
		return databaseConnection;
	}
	
	public void status() {
		System.out.println("Database Connection Successful");
	}
	
}
