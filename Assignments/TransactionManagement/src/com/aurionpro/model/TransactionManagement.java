package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManagement {
	private static Connection connection;
	String withdrawQuery = "Update accounts set balance = balance - ? where account_number = ?";
	String depositQuery = "Update accounts set balance = balance + ? where account_number = ?";
	public void connectToDo() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root");
				System.out.println("Connection Successful");
				connection.setAutoCommit(false);
				
				PreparedStatement withdrawStatement = connection.prepareStatement(withdrawQuery);
				withdrawStatement.setDouble(1, 500);
				withdrawStatement.setString(2, "accout123");
				int rowsAffectedWithdraw = withdrawStatement.executeUpdate();
				
				
				PreparedStatement depositStatement = connection.prepareStatement(depositQuery);
				depositStatement.setDouble(1, 500);
				depositStatement.setString(2, "account456");
				int rowsAffectedDeposit = depositStatement.executeUpdate();
				
				if(rowsAffectedWithdraw <= 0 && rowsAffectedDeposit <= 0) {
					connection.rollback();
					System.out.println("Transaction Failed");
					return;
				}
				connection.commit();
				System.out.println("Transaction Successfull");
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
