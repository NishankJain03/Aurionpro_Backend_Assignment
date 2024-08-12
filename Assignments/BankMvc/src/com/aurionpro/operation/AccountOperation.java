package com.aurionpro.operation;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class AccountOperation {
	public String createAccountForCustomer(Connection connection, String customerId) {
        try {
            if (doesCustomerHaveAccount(connection, customerId)) {
                return "Customer already has an account.";
            }
            String accountNumber = generateUniqueAccountNumber(connection);
            String query = "INSERT INTO Accounts (AccountNumber, CustomerID, Balance) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
            	stmt.setString(1, accountNumber);
            	stmt.setInt(2, Integer.parseInt(customerId));
            	stmt.setBigDecimal(3, BigDecimal.ZERO);
            	int rowsAffected = stmt.executeUpdate();
            	if (rowsAffected > 0) {
            		return "Account created successfully with Account Number: " + accountNumber;
            	} 
            	return "Failed to create account.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    private boolean doesCustomerHaveAccount(Connection connection, String customerId) throws SQLException {
        String query = "SELECT COUNT(*) FROM Accounts WHERE CustomerID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(customerId));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    private String generateUniqueAccountNumber(Connection connection) {
        String accountNumber;
        boolean isUnique;
        do {
            accountNumber = generateRandomAccountNumber();
            isUnique = checkAccountNumberUnique(connection, accountNumber);
        } while (!isUnique);
        return accountNumber;
    }

    private boolean checkAccountNumberUnique(Connection connection, String accountNumber) {
        boolean isUnique = true;
        String query = "SELECT COUNT(*) FROM Accounts WHERE AccountNumber = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, accountNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    isUnique = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error checking account number uniqueness.", e);
        }
        return isUnique;
    }

    private String generateRandomAccountNumber() {
        Random random = new Random();
        int accountNumber = 1000000000 + random.nextInt(900000000);
        return String.format("%010d", accountNumber);
    }
}
