package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {
	private Connection connection;
	private Statement statement;
	private static DbUtil dbUtil = null;
	
	private DbUtil() {
		
	}
	public static DbUtil getDbUtil() {
		if(dbUtil == null)
			dbUtil = new DbUtil();
		return dbUtil;
	}
	public void connectToDo() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmvc", "root", "root");
					System.out.println("Connection Successful");
					statement = connection.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public List<Transaction> getAllTransactions(int userID) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT " +
                     "s.AccountNumber AS SenderAccountNumber, " +
                     "r.AccountNumber AS ReceiverAccountNumber, " +
                     "t.TransactionType, " +
                     "t.Amount, " +
                     "t.TransactionDate " +
                     "FROM Transactions t " +
                     "JOIN Accounts s ON t.SenderAccountID = s.AccountID " +
                     "JOIN Accounts r ON t.ReceiverAccountID = r.AccountID " +
                     "JOIN Customers c ON s.CustomerID = c.CustomerID " +
                     "WHERE c.UserID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction(
                    rs.getString("SenderAccountNumber"),
                    rs.getString("ReceiverAccountNumber"),
                    rs.getString("TransactionType"),
                    rs.getBigDecimal("Amount"),
                    rs.getTimestamp("TransactionDate")
                );
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
	
	
	
	
	
}
