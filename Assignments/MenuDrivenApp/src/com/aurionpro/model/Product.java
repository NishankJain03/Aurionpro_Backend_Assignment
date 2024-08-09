package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Product {
	private static Connection connection;
	private static Scanner scanner = new Scanner(System.in);
	public void connectToDo() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scm", "root", "root");
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
	public static void insertProduct() throws SQLException {
        System.out.print("Enter ProductId: ");
        int id = scanner.nextInt();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Description: ");
        String description = scanner.next();
        System.out.print("Enter SupplierId: ");
        int supplierId = scanner.nextInt();
        
        String sql = "INSERT INTO Product (ProductId, Name, Description, SupplierId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, description);
            pstmt.setInt(4, supplierId);
            pstmt.executeUpdate();
            connection.commit();
        }
        System.out.println("Successfully Inserted the Records");
    }
	public static void updateProduct() throws SQLException{
    	System.out.println("Enter the product Id");
    	int productId = scanner.nextInt();
    	System.out.println("Enter the name to update");
    	String name = scanner.next();
    	System.out.println("Enter the description to update");
    	String description = scanner.next();
    	
    	String sql = "Update products set Name = ?, Description = ? where ProductId = ?";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setString(1, name);
        	preparedStatement.setString(2, description);
        	preparedStatement.setInt(3, productId);
        	int result = preparedStatement.executeUpdate();
        	if(result > 0) {
        		System.out.println("Updated the records");
        		return;
        	}
        	System.out.println("No records found");
        }
    	
    }
	public static void deleteProduct() throws SQLException{
    	System.out.print("Enter ProductId of the record to delete: ");
        int productId = scanner.nextInt();
        String sql = "DELETE FROM products WHERE ProductId = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setInt(1, productId);
        	int result = preparedStatement.executeUpdate();
        	if(result > 0) {
        		System.out.println("Deleted the records");
        		return;
        	}
        	System.out.println("No records found");
        }
    }
	public static void readProduct() throws SQLException{
    	String sql = "Select * from products";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet dbProductData = preparedStatement.executeQuery();
    		while(dbProductData.next()) {
    			System.out.println(dbProductData.getInt("ProductId")+"\t"+
    			dbProductData.getString("Name")+"\t"+ dbProductData.getString("Description")+"\t"+
    			dbProductData.getInt("SupplierId"));
    		}
    	}
    }
}
