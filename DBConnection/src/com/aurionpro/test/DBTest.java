package com.aurionpro.test;

import com.aurionpro.model.DBConnection;

public class DBTest {
	public static void main(String[] args) {
		DBConnection dbConnection = new DBConnection();
		dbConnection.connectToDb();
	}

}
