package com.aurionpro.model;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TransactionOperation {
	private Connection connection;

	public TransactionOperation(Connection connection) {
		this.connection = connection;
	}
	public int getSenderAccountID(int userID) throws SQLException {
        String sql = "SELECT AccountID FROM Accounts WHERE CustomerID = (SELECT CustomerID FROM Customers WHERE UserID = ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getInt("AccountID") : -1;
        }
    }

    public int getAccountIDByNumber(String accountNumber) throws SQLException {
        String sql = "SELECT AccountID FROM Accounts WHERE AccountNumber = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getInt("AccountID") : -1;
        }
    }

    public boolean hasSufficientBalance(int accountID, BigDecimal amount) throws SQLException {
        String sql = "SELECT Balance FROM Accounts WHERE AccountID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, accountID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                BigDecimal balance = rs.getBigDecimal("Balance");
                return balance.compareTo(amount) >= 0;
            }
            return false;
        }
    }

    public void processTransfer(int senderAccountID, int receiverAccountID, BigDecimal amount) throws SQLException {
        String sql = "UPDATE Accounts SET Balance = Balance - ? WHERE AccountID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, amount);
            pstmt.setInt(2, senderAccountID);
            pstmt.executeUpdate();
        }

        sql = "UPDATE Accounts SET Balance = Balance + ? WHERE AccountID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, amount);
            pstmt.setInt(2, receiverAccountID);
            pstmt.executeUpdate();
        }

        sql = "INSERT INTO Transactions (SenderAccountID, ReceiverAccountID, TransactionType, Amount) VALUES (?, ?, 'Transfer', ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, senderAccountID);
            pstmt.setInt(2, receiverAccountID);
            pstmt.setBigDecimal(3, amount);
            pstmt.executeUpdate();
        }
    }

    public void processDebit(int senderAccountID, BigDecimal amount) throws SQLException {
        String sql = "UPDATE Accounts SET Balance = Balance - ? WHERE AccountID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, amount);
            pstmt.setInt(2, senderAccountID);
            pstmt.executeUpdate();
        }

        sql = "INSERT INTO Transactions (SenderAccountID, TransactionType, Amount) VALUES (?, 'Debit', ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, senderAccountID);
            pstmt.setBigDecimal(2, amount);
            pstmt.executeUpdate();
        }
    }

    public void processCredit(int senderAccountID, BigDecimal amount) throws SQLException {
        String sql = "UPDATE Accounts SET Balance = Balance + ? WHERE AccountID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, amount);
            pstmt.setInt(2, senderAccountID);
            pstmt.executeUpdate();
        }

        sql = "INSERT INTO Transactions (SenderAccountID, TransactionType, Amount) VALUES (?, 'Credit', ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, senderAccountID);
            pstmt.setBigDecimal(2, amount);
            pstmt.executeUpdate();
        }
    }
}
