package com.aurionpro.test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.aurionpro.model.Inventory;
import com.aurionpro.model.Product;
import com.aurionpro.model.QueriesMenu;

public class QueriesMenuTest {
	private static Scanner scanner = new Scanner(System.in);
	private static QueriesMenu queriesMenu;
	private static Inventory inventory = new Inventory();
	private static Product product = new Product();
	public static void main(String[] args) {
		queriesMenu = new QueriesMenu();
		queriesMenu.connectToDo();
		
		while(true) {
			System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Read");
            System.out.println("5. Execute Queries");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
            case 1:
                try {
					insert();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                break;
            case 2:
                try {
					update();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                break;
            case 3:
                try {
					delete();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                break;
            case 4:
                try {
					read();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                break;
            case 5:
            	try {
					executeQueries();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                break;
            case 6:
            	System.out.println("Exiting...");
            	System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
		}
		 

	}
	private static void insert() throws SQLException{
		System.out.println("Choose table to insert into:");
        System.out.println("1. Supplier");
        System.out.println("2. Product");
        System.out.println("3. Order");
        System.out.println("4. OrderDetails");
        System.out.println("5. Inventory");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
        case 1:
        	queriesMenu.insertSupplier();
            break;
        case 2:
        	product.insertProduct();
            break;
        case 3:
            queriesMenu.insertOrder();
            break;
        case 4:
        	queriesMenu.insertOrderdetails();
            break;
        case 5:
        	inventory.insertInventory();
            break;
        default:
            System.out.println("Invalid choice.");
    }
	}
	private static void update() throws SQLException{
		System.out.println("Choose table to update into:");
        System.out.println("1. Supplier");
        System.out.println("2. Product");
        System.out.println("3. Order");
        System.out.println("4. OrderDetails");
        System.out.println("5. Inventory");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
        case 1:
            queriesMenu.updateSupplier();
            break;
        case 2:
            product.updateProduct();
            break;
        case 3:
            queriesMenu.updateOrder();
            break;
        case 4:
            queriesMenu.updateOrderDetails();
            break;
        case 5:
            inventory.updateInventory();
            break;
        default:
            System.out.println("Invalid choice.");
    }
	}
	private static void delete() throws SQLException{
		System.out.println("Choose table to delete into:");
        System.out.println("1. Supplier");
        System.out.println("2. Inventory");
        System.out.println("3. OrderDetails");
        System.out.println("4. Order");
        System.out.println("5. Product");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
        case 1:
            queriesMenu.deleteSupplier();
            break;
        case 2:
            inventory.deleteInventory();
            break;
        case 3:
        	queriesMenu.deleteOrderDetails();
            break;
        case 4:
            queriesMenu.deleteOrder();
            break;
        case 5:
        	product.deleteProduct();
            break;
        default:
            System.out.println("Invalid choice.");
    }
	}
	private static void read() throws SQLException{
		System.out.println("Choose table to read into:");
        System.out.println("1. Supplier");
        System.out.println("2. Product");
        System.out.println("3. Order");
        System.out.println("4. OrderDetails");
        System.out.println("5. Inventory");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
        case 1:
            queriesMenu.readSupplier();
            break;
        case 2:
            product.readProduct();
            break;
        case 3:
            queriesMenu.readOrder();
            break;
        case 4:
            queriesMenu.readOrderDetails();
            break;
        case 5:
            inventory.readInventory();
            break;
        default:
            System.out.println("Invalid choice.");
    }
	}
	private static void executeQueries() throws SQLException {
        System.out.println("Choose a query to execute:");
        System.out.println("1. List all products along with their Supplier name");
        System.out.println("2. Find all suppliers who have supplied a specific product");
        System.out.println("3. Find all orders placed within the last month");
        System.out.println("4. Get total quantity ordered for each product");
        System.out.println("5. Retrieve all orders along with the total amount spent for each order");
        System.out.println("6. List suppliers who have not supplied any products");
        System.out.println("7. Find products supplied by more than one supplier");
        System.out.println("8. Get all orders with their details");
        System.out.println("9. List all products and their current inventory level");
        System.out.println("10. Get the average inventory level for each product");
        System.out.print("Choose a query option: ");
        int queryChoice = scanner.nextInt();

        switch (queryChoice) {
            case 1:
                queriesMenu.listProductsWithSupplier();
                break;
            case 2:
            	queriesMenu.findSuppliersByProduct();
                break;
            case 3:
            	queriesMenu.findOrdersLastMonth();
                break;
            case 4:
            	queriesMenu.totalQuantityOrdered();
                break;
            case 5:
            	queriesMenu.retrieveOrderTotalAmount();
                break;
            case 6:
            	queriesMenu.listSuppliersWithNoProducts();
                break;
            case 7:
            	queriesMenu.findProductsMultipleSuppliers();
                break;
            case 8:
            	queriesMenu.getOrdersWithDetails();
                break;
            case 9:
            	queriesMenu.listProductsInventoryLevel();
                break;
            case 10:
            	queriesMenu.averageInventoryLevel();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
	 
}
