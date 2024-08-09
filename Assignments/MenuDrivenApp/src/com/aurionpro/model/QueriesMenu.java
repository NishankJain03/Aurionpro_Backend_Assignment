package com.aurionpro.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.mysql.cj.protocol.Resultset;

public class QueriesMenu {
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
    
    public static void insertOrderdetails() throws SQLException{
    	System.out.print("Enter OrderDetailsId: ");
        int id = scanner.nextInt();
        System.out.print("Enter OrderId: ");
        int orderId = scanner.nextInt();
        System.out.print("Enter ProductId: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        
        String sql = "INSERT INTO orderdetails (OrderDetailId, OrderId, ProductId, Quantity, Price) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, orderId);
            pstmt.setInt(3, productId);
            pstmt.setInt(4, quantity);
            pstmt.setDouble(5, price);
            pstmt.executeUpdate();
        }
        System.out.println("Successfully Inserted the Records");
    }
    public static void insertOrder() throws SQLException{
    	System.out.print("Enter OrderId: ");
        int id = scanner.nextInt();
        System.out.print("Enter OrderDate (yyyy-mm-dd): ");
        String date = scanner.next();
        System.out.print("Enter SupplierID: ");
        int supplierId = scanner.nextInt();
        
        String sql = "INSERT INTO `Order` (OrderId, OrderDate, SupplierID) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setDate(2, Date.valueOf(date));
            pstmt.setInt(3, supplierId);
            pstmt.executeUpdate();
        }
        System.out.println("Successfully Inserted the Records");
    }

    public static void insertSupplier() throws SQLException {
        System.out.print("Enter SupplierID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter ContactInfo: ");
        String contactInfo = scanner.next();
        System.out.print("Enter Address: ");
        String address = scanner.next();
        
        String sql = "INSERT INTO suppliers (SupplierID, Name, ContactInfo, Address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, contactInfo);
            pstmt.setString(4, address);
            pstmt.executeUpdate();
        }
        System.out.println("Successfully Inserted the Records");
    }
    
    
    public static void updateSupplier() throws SQLException{
    	System.out.print("Enter SupplierID of the record to update: ");
        int supplierId = scanner.nextInt();
        System.out.print("Enter new Name: ");
        String name = scanner.next();
        System.out.print("Enter new ContactInfo: ");
        String contactInfo = scanner.next();
        System.out.print("Enter new Address: ");
        String address = scanner.next();
        
        String sql = "Update suppliers set Name = ?, ContactInfo = ?, Address = ? where supplierId = ?";
        
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setString(1, name);
        	preparedStatement.setString(2, contactInfo);
        	preparedStatement.setString(3, address);
        	int result = preparedStatement.executeUpdate();
        	if(result > 0) {
        		System.out.println("Updated the records");
        		return;
        	}
        	System.out.println("No records found");
        }
        
        
    }
  
    public static void updateOrder() throws SQLException{
    	System.out.println("Enter the order Id ");
    	int orderId = scanner.nextInt();
    	System.out.println("Enter the orderdate to update (yyyy-mm-dd)");
    	String orderDate = scanner.next();
    	String sql = "Update order set OrderDate = ?, where OrderId = ?";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setString(1, orderDate);
        	preparedStatement.setInt(2, orderId);
        	int result = preparedStatement.executeUpdate();
        	if(result > 0) {
        		System.out.println("Updated the records");
        		return;
        	}
        	System.out.println("No records found");
        }
    }
    
    public static void updateOrderDetails() throws SQLException{
    	System.out.println("Enter the orderDetails ID");
    	int OrderDetailsId = scanner.nextInt();
    	System.out.println("Enter the quantity to update");
    	int quantity = scanner.nextInt();
    	System.out.println("Enter the price to update");
    	double price = scanner.nextDouble();
    	
    	String sql = "Update order set Quantity = ? Price = ?, where OrderDetailsId = ?";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setInt(1, quantity);
        	preparedStatement.setDouble(2, price);
        	preparedStatement.setInt(3, OrderDetailsId);
        	int result = preparedStatement.executeUpdate();
        	if(result > 0) {
        		System.out.println("Updated the records");
        		return;
        	}
        	System.out.println("No records found");
        }
    }
    
    public static void deleteSupplier() throws SQLException{
    	System.out.print("Enter SupplierId of the record to delete: ");
        int supplierId = scanner.nextInt();
        String sql = "DELETE FROM suppliers WHERE SupplierId = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setInt(1, supplierId);
        	int result = preparedStatement.executeUpdate();
        	if(result > 0) {
        		System.out.println("Deleted the records");
        		return;
        	}
        	System.out.println("No records found");
        }
    }
    public static void deleteOrder() throws SQLException{
    	System.out.print("Enter OrderId of the record to delete: ");
        int orderId = scanner.nextInt();
        String sql = "DELETE FROM orders WHERE OrderId = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setInt(1, orderId);
        	int result = preparedStatement.executeUpdate();
        	if(result > 0) {
        		System.out.println("Deleted the records");
        		return;
        	}
        	System.out.println("No records found");
        }
    }
    public static void deleteOrderDetails() throws SQLException{
    	System.out.print("Enter orderDetailsId of the record to delete: ");
        int orderDetailsId = scanner.nextInt();
        String sql = "DELETE FROM orderdetails WHERE OrderDetailId = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setInt(1, orderDetailsId);
        	int result = preparedStatement.executeUpdate();
        	if(result > 0) {
        		System.out.println("Deleted the records");
        		return;
        	}
        	System.out.println("No records found");
        }
    }
    public static void readSupplier() throws SQLException{
    	String sql = "Select * from suppliers";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet dbSupplierData = preparedStatement.executeQuery();
    		while(dbSupplierData.next()) {
    			System.out.println(dbSupplierData.getInt("SupplierId")+"\t"+
    		dbSupplierData.getString("Name")+"\t"+ dbSupplierData.getString("ContactInfo")+"\t"+
    			dbSupplierData.getString("Address"));
    		}
    	}
    }
    public static void readOrder() throws SQLException{
    	String sql = "Select * from orders";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet dbOrderData = preparedStatement.executeQuery();
    		while(dbOrderData.next()) {
    			System.out.println(dbOrderData.getInt("OrderId")+"\t"+
    			dbOrderData.getString("OrderDate")+"\t"+ dbOrderData.getInt("SupplierId"));
    		}
    	}
    }
    public static void readOrderDetails() throws SQLException{
    	String sql = "Select * from orderdetails";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet dbOrderDetailsData = preparedStatement.executeQuery();
    		while(dbOrderDetailsData.next()) {
    			System.out.println(dbOrderDetailsData.getInt("OrderDetailId")+"\t"+
    			dbOrderDetailsData.getInt("OrderId")+"\t"+ dbOrderDetailsData.getInt("ProductId")+"\t"+
    			dbOrderDetailsData.getInt("Quantity")+"\t"+dbOrderDetailsData.getInt("Price"));
    		}
    	}
    }
    
    public static void listProductsWithSupplier() throws SQLException {
        String sql = "SELECT products.Name AS ProductName, suppliers.Name AS SupplierName " +
                     "FROM products LEFT JOIN suppliers ON products.SupplierId = suppliers.SupplierId";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet  listProductsWithSupplier = preparedStatement.executeQuery()) {
            while (listProductsWithSupplier.next()) {
               System.out.println("Product Name" + listProductsWithSupplier.getString("ProductName")+"\t"+
            		   listProductsWithSupplier.getString("SupplierName"));
            }
        }
    }
    
    public static void findSuppliersByProduct() throws SQLException{
    	String sql = "SELECT products.Name AS ProductName, suppliers.Name AS SupplierName from products Right Join  suppliers  " + 
    			"ON products.SupplierId = suppliers.SupplierId";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet findSuppliersByProduct = preparedStatement.executeQuery();
    		while(findSuppliersByProduct.next()) {
    			System.out.println("Product Name" + findSuppliersByProduct.getString("ProductName")+"\t"+
    					findSuppliersByProduct.getString("SupplierName"));
             }
    		}
    	}
    public static void findOrdersLastMonth() throws SQLException{
    	String sql = "SELECT * FROM orders WHERE OrderDate >= now() - interval 1 month AND OrderDate < now()";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet findOrdersLastMonth = preparedStatement.executeQuery();
    		while(findOrdersLastMonth.next()) {
    			System.out.println(findOrdersLastMonth.getInt("OrderId")+"\t"+
    					findOrdersLastMonth.getString("OrderDate")+"\t"+ findOrdersLastMonth.getInt("SupplierId"));
    		}
    	}
    }
    public static void totalQuantityOrdered() throws SQLException{
    	String sql = "Select products.Name AS ProductName, SUM(orderdetails.Quantity) AS TotalQuantity from orderdetails INNER Join products \r\n" + 
    			"ON orderdetails.ProductId = products.ProductId Group BY products.Name";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet totalQuantityOrdered = preparedStatement.executeQuery();
    		while(totalQuantityOrdered.next()) {
    			System.out.println(totalQuantityOrdered.getString("ProductName")+"\t"+ totalQuantityOrdered.getString("TotalQuantity"));
    		}
    	}
    }
    public static void retrieveOrderTotalAmount() throws SQLException{
    	String sql = "Select orderdetails.OrderId AS OrderId, (orderdetails.Quantity * orderdetails.Price) AS TotalAmountSpent from orderdetails INNER JOIN orders ON orderdetails.OrderId = orders.OrderId";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet retrieveOrderTotalAmount = preparedStatement.executeQuery();
    		while(retrieveOrderTotalAmount.next()) {
    			System.out.println(retrieveOrderTotalAmount.getInt("OrderId")+"\t"+ retrieveOrderTotalAmount.getInt("TotalAmountSpent"));
    		}
    	}
    }
    public static void listSuppliersWithNoProducts() throws SQLException{
    	String sql = "SELECT suppliers.SupplierID AS SupplierID, suppliers.Name AS SupplierName, ContactInfo, Address FROM Suppliers LEFT JOIN Products ON suppliers.SupplierID = products.SupplierID WHERE products.SupplierID IS NULL";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet listSuppliersWithNoProducts = preparedStatement.executeQuery();
    		while(listSuppliersWithNoProducts.next()) {
    			System.out.println(listSuppliersWithNoProducts.getInt("SupplierId")+"\t"+ listSuppliersWithNoProducts.getString("SupplierName")
    			+"\t"+ listSuppliersWithNoProducts.getString("ContactInfo")+"\t"+ listSuppliersWithNoProducts.getString("Address"));
    		}
    	}
    }
    public static void findProductsMultipleSuppliers() throws SQLException{
    	String sql = "Select products.Name AS ProductName, COUNT(DISTINCT products.SupplierId) AS SupplierCount from products group by products.Name Having COUNT(DISTINCT products.SupplierId) > 1";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet findProductsMultipleSuppliers = preparedStatement.executeQuery();
    		while(findProductsMultipleSuppliers.next()) {
    			System.out.println(findProductsMultipleSuppliers.getString("ProductName")+"\t"+ findProductsMultipleSuppliers.getInt("SupplierCount"));
    		}
    	}
    }
    public static void getOrdersWithDetails() throws SQLException{
    	String sql = "Select orderdetails.OrderId AS OrderId, orderdetails.Quantity AS Quantity, orderdetails.Price AS Price, products.Name AS ProductName,  products.Description AS Description from orderdetails Left Join products on orderdetails.ProductId = products.ProductId";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet getOrdersWithDetails = preparedStatement.executeQuery();
    		while(getOrdersWithDetails.next()) {
    			System.out.println(getOrdersWithDetails.getInt("OrderId")+"\t"+getOrdersWithDetails.getInt("Quantity")+"\t"+getOrdersWithDetails.getInt("Price")+"\t"+getOrdersWithDetails.getString("ProductName")+"\t"+getOrdersWithDetails.getString("Description"));
    			
    		}
    	}
    }
    public static void listProductsInventoryLevel() throws SQLException{
    	String sql = "select products.Name AS ProductName, products.Description AS ProductDescription, inventory.QuantityOnHand AS InventoryLevel from products Left join inventory on inventory.ProductId = products.ProductId";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet listProductsInventoryLevel = preparedStatement.executeQuery();
    		while(listProductsInventoryLevel.next()) {
    			System.out.println(listProductsInventoryLevel.getString("ProductName")+"\t"+listProductsInventoryLevel.getString("ProductDescription")+"\t"+listProductsInventoryLevel.getInt("InventoryLevel"));
    			
    		}
    	}
    	
    }
    public static void averageInventoryLevel() throws SQLException{
    	String sql = "select products.Name AS ProductName, products.Description AS ProductDescription, avg(inventory.QuantityOnHand) AS InventoryLevel from products left join inventory on inventory.ProductId = products.ProductId group by products.Name";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		ResultSet averageInventoryLevel = preparedStatement.executeQuery();
    		while(averageInventoryLevel.next()) {
    			System.out.println(averageInventoryLevel.getString("ProductName")+"\t"+averageInventoryLevel.getString("ProductDescription")+"\t"+averageInventoryLevel.getInt("InventoryLevel"));
    			
    		}
    	}
    }
    
}

