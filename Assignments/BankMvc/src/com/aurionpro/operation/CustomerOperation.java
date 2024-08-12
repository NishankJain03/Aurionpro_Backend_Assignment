package com.aurionpro.operation;
import com.aurionpro.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CustomerOperation {
	 public Customer fetchCustomerById(Connection connection, String customerId) throws SQLException {
	        String query = "SELECT c.CustomerID, u.FirstName, u.LastName, u.Email FROM Customers c "
	                     + "JOIN Users u ON c.UserID = u.UserID WHERE c.CustomerID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        	 stmt.setInt(1, Integer.parseInt(customerId)); 
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    Customer customer = new Customer();
	                    customer.setCustomerID(rs.getInt("CustomerID")); 
	                    customer.setFirstName(rs.getString("FirstName"));
	                    customer.setLastName(rs.getString("LastName"));
	                    customer.setEmail(rs.getString("Email"));
	                    return customer;
	                }
	            }
	        }
	        return null;
	    }
}	
