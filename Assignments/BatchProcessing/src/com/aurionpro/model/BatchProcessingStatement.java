package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingStatement {
	private static Connection connection;
	public void connectToDo() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root");
				System.out.println("Connection Successful");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public void startBatchProcessing() {
		try {
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			statement.addBatch("INSERT INTO Employee (name, job_title, salary) VALUES ('Emily Clark', 'UI/UX Designer', 75000.00)");
			statement.addBatch("INSERT INTO Employee (name, job_title, salary) SELECT 'Daniel Garcia', 'Business Analyst', 79000.00");
			statement.addBatch("INSERT INTO Employee (name, job_title, salary) VALUES ('Fiona Martinez', 'HR Specialist', 65500.00)");
			statement.addBatch("INSERT INTO Employee (name, job_title, salary) VALUES ('George Wilson', 'Sales Manager', 83000.00)");
			int[] batchResult = statement.executeBatch();
			connection.commit();
			System.out.println("Batch Executed successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
