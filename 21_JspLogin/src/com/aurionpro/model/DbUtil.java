package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	private Connection connection;
	private Statement statement;
	private static DbUtil dbUtil = null;
	
	private DbUtil() {
		
	}
	public static DbUtil getDbUtil() {
		if(dbUtil == null)
			dbUtil = new DbUtil();
		return dbUtil;
	}
	public void connectToDo() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userscredential", "root", "root");
					System.out.println("Connection Successful");
					statement = connection.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public ResultSet getAllUsers() {
		ResultSet dbUsers = null;
		try {
			dbUsers = statement.executeQuery("select * from users");
			System.out.println(dbUsers);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbUsers;
		
	}
	
	public boolean validateCredentials(String username, String password) {
		ResultSet dbUsers = getAllUsers();
		
		try {
			while(dbUsers.next()) {
				if(dbUsers.getString("username").equals(username)) {
					if(dbUsers.getString("password").equals(password)) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
