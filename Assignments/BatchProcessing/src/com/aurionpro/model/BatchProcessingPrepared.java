package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BatchProcessingPrepared {
	private static Connection connection;
	private static Scanner scanner = new Scanner(System.in);
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
			String query = "Insert into employee(name, job_title, salary) VALUES (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			boolean hasEnd = false;
			while(!hasEnd) {
				System.out.println("Enter the name of employee");
				String name = scanner.next();
				System.out.println("Enter the job title of employee");
				String job_title = scanner.next();
				System.out.println("Enter the salary");
				double salary = scanner.nextDouble();
				
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, job_title);
				preparedStatement.setDouble(3, salary);
				
				preparedStatement.addBatch();
				
				System.out.println("Add more values Y/N");
				String decision = scanner.next();
				if(decision.toUpperCase().equals("N")) {
					hasEnd = true;
				}
			}
			
			int[] batchResult = preparedStatement.executeBatch();
			connection.commit();
			System.out.println("Batch executed successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
