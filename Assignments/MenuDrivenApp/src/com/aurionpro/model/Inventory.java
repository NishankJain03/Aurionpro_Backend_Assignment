package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Inventory {
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
	public static void insertInventory() throws SQLException {
        System.out.print("Enter InventoryId: ");
        int id = scanner.nextInt();
        System.out.print("Enter ProductId: ");
        int productId = scanner.nextInt();
        System.out.print("Enter QuantityOnHand: ");
        int quantityOnHand = scanner.nextInt();
        
        String sql = "INSERT INTO Inventory (InventoryId, ProductId, QuantityOnHand) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, productId);
            pstmt.setInt(3, quantityOnHand);
            pstmt.executeUpdate();
        }
        System.out.println("Successfully Inserted the Records");
    }
	public static void updateInventory() throws SQLException{
    	System.out.print("Enter InventoryId of the record to update: ");
        int inventoryId = scanner.nextInt();
        System.out.print("Enter new QuantityOnHand: ");
        int quantityOnHand = scanner.nextInt();
        
        String sql = "Update inventory set QuantityOnHand = ? where InventoryId = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setInt(1, quantityOnHand);
        	preparedStatement.setInt(2, inventoryId);
        	int result = preparedStatement.executeUpdate();
        	if(result > 0) {
        		System.out.println("Updated the records");
        		return;
        	}
        	System.out.println("No records found");
        }
    }
	public static void deleteInventory() throws SQLException{
    	System.out.print("Enter InventoryId of the record to delete: ");
        int inventoryId = scanner.nextInt();
        String sql = "DELETE FROM inventory WHERE InventoryId = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setInt(1, inventoryId);
        	int result = preparedStatement.executeUpdate();
        	if(result > 0) {
        		System.out.println("Deleted the records");
        		return;
        	}
        	System.out.println("No records found");
        }
    }
	public static void readInventory() throws SQLException{
    	String sql = "Select * from inventory";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet dbInventoryData = preparedStatement.executeQuery();
    		while(dbInventoryData.next()) {
    			System.out.println(dbInventoryData.getInt("InventoryId")+"\t"+
    			dbInventoryData.getInt("ProductId")+"\t"+ dbInventoryData.getInt("QuantityOnHand"));
    		}
    	}
    }
	
}
