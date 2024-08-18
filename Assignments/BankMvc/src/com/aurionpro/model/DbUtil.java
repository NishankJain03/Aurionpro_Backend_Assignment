package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DbUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/bankmvc";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection successful.");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Database driver not found.", e);
        }
    }

    public List<Transaction> getAllTransactions(Connection connection, int userID) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT " +
                "s.AccountNumber AS SenderAccountNumber, " +
                "r.AccountNumber AS ReceiverAccountNumber, " +
                "t.TransactionType, " +
                "t.Amount, " +
                "t.TransactionDate " +
                "FROM Transactions t " +
                "JOIN Accounts s ON t.SenderAccountID = s.AccountID " +
                "LEFT JOIN Accounts r ON t.ReceiverAccountID = r.AccountID " +
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

    public List<Transaction> getAllAdminTransactions(Connection connection) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT " +
                "s.AccountNumber AS SenderAccountNumber, " +
                "r.AccountNumber AS ReceiverAccountNumber, " +
                "t.TransactionType, " +
                "t.Amount, " +
                "t.TransactionDate " +
                "FROM Transactions t " +
                "JOIN Accounts s ON t.SenderAccountID = s.AccountID " +
                "LEFT JOIN Accounts r ON t.ReceiverAccountID = r.AccountID " +
                "JOIN Customers c ON s.CustomerID = c.CustomerID";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
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
   
    public List<Transaction> getFilteredTransactions(Connection connection, String search, String type, String startDate, String endDate) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT " +
                "s.AccountNumber AS SenderAccountNumber, " +
                "r.AccountNumber AS ReceiverAccountNumber, " +
                "t.TransactionType, " +
                "t.Amount, " +
                "t.TransactionDate " +
                "FROM Transactions t " +
                "JOIN Accounts s ON t.SenderAccountID = s.AccountID " +
                "LEFT JOIN Accounts r ON t.ReceiverAccountID = r.AccountID " +
                "JOIN Customers c ON s.CustomerID = c.CustomerID " +
                "WHERE 1=1");

        if (search != null && !search.isEmpty()) {
            query.append(" AND (s.AccountNumber LIKE ? OR r.AccountNumber LIKE ? OR t.TransactionType LIKE ?)");
        }
        if (type != null && !type.isEmpty()) {
            query.append(" AND t.TransactionType = ?");
        }
        if (startDate != null && !startDate.isEmpty()) {
            query.append(" AND t.TransactionDate >= ?");
        }
        if (endDate != null && !endDate.isEmpty()) {
            query.append(" AND t.TransactionDate <= ?");
        }

        try (PreparedStatement stmt = connection.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (search != null && !search.isEmpty()) {
                stmt.setString(paramIndex++, "%" + search + "%");
                stmt.setString(paramIndex++, "%" + search + "%");
                stmt.setString(paramIndex++, "%" + search + "%");
            }
            if (type != null && !type.isEmpty()) {
                stmt.setString(paramIndex++, type);
            }
            if (startDate != null && !startDate.isEmpty()) {
                stmt.setTimestamp(paramIndex++, convertStringToTimestamp(startDate));
            }
            if (endDate != null && !endDate.isEmpty()) {
                stmt.setTimestamp(paramIndex++, convertStringToTimestamp(endDate));
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    transactions.add(new Transaction(
                        rs.getString("SenderAccountNumber"),
                        rs.getString("ReceiverAccountNumber"),
                        rs.getString("TransactionType"),
                        rs.getBigDecimal("Amount"),
                        rs.getTimestamp("TransactionDate")
                    ));
                }
            }
        }
        return transactions;
    }

    private Timestamp convertStringToTimestamp(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(dateString);
            return new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Or throw an exception if you prefer
        }
    }
    
    public List<Transaction> getFilteredTransactions(Connection connection, Integer userID, String search, String type, String startDate, String endDate, String sortBy, String sortOrder) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT " +
                "sa.AccountNumber AS SenderAccountNumber, " +
                "COALESCE(ra.AccountNumber, 'N/A') AS ReceiverAccountNumber, " +
                "t.TransactionType, " +
                "t.Amount, " +
                "t.TransactionDate " +
                "FROM Transactions t " +
                "JOIN Accounts sa ON t.SenderAccountID = sa.AccountID " +
                "LEFT JOIN Accounts ra ON t.ReceiverAccountID = ra.AccountID " +
                "JOIN Customers c ON sa.CustomerID = c.CustomerID " +
                "JOIN Users u ON c.UserID = u.UserID " +
                "WHERE u.UserID = ?");

        // Add filters based on search parameters
        if (search != null && !search.isEmpty()) {
            query.append(" AND (sa.AccountNumber LIKE ? OR ra.AccountNumber LIKE ? OR t.TransactionType LIKE ?)");
        }
        if (type != null && !type.isEmpty()) {
            query.append(" AND t.TransactionType = ?");
        }
        if (startDate != null && !startDate.isEmpty()) {
            query.append(" AND t.TransactionDate >= ?");
        }
        if (endDate != null && !endDate.isEmpty()) {
            query.append(" AND t.TransactionDate <= ?");
        }

        // Append sorting
        query.append(" ORDER BY ").append(sortBy).append(" ").append(sortOrder);

        try (PreparedStatement stmt = connection.prepareStatement(query.toString())) {
            int paramIndex = 1;
            stmt.setInt(paramIndex++, userID);

            // Set parameters for search
            if (search != null && !search.isEmpty()) {
                stmt.setString(paramIndex++, "%" + search + "%");
                stmt.setString(paramIndex++, "%" + search + "%");
                stmt.setString(paramIndex++, "%" + search + "%");
            }
            // Set parameters for type
            if (type != null && !type.isEmpty()) {
                stmt.setString(paramIndex++, type);
            }
            // Set parameters for date range
            if (startDate != null && !startDate.isEmpty()) {
                stmt.setTimestamp(paramIndex++, convertStringToTimestamp(startDate));
            }
            if (endDate != null && !endDate.isEmpty()) {
                stmt.setTimestamp(paramIndex++, convertStringToTimestamp(endDate));
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    transactions.add(new Transaction(
                        rs.getString("SenderAccountNumber"),
                        rs.getString("ReceiverAccountNumber"),
                        rs.getString("TransactionType"),
                        rs.getBigDecimal("Amount"),
                        rs.getTimestamp("TransactionDate")
                    ));
                }
            }
        }
        return transactions;
    }




    
    
//    public List<Transaction> getFilteredTransactions(Connection connection, String type) throws SQLException {
//        List<Transaction> transactions = new ArrayList<>();
//        String query = "SELECT " +
//        	    "a1.AccountNumber AS SenderAccountNumber, " +
//        	    "COALESCE(a2.AccountNumber, 'N/A') AS ReceiverAccountNumber, " +
//        	    "t.TransactionType, " +
//        	    "t.Amount, " +
//        	    "t.TransactionDate, " +
//        	    "COALESCE(u1.FirstName, 'Unknown') AS SenderFirstName, " +
//        	    "COALESCE(u1.LastName, 'Unknown') AS SenderLastName, " +
//        	    "COALESCE(u2.FirstName, 'N/A') AS ReceiverFirstName, " +
//        	    "COALESCE(u2.LastName, 'N/A') AS ReceiverLastName " +
//        	    "FROM Transactions t " +
//        	    "JOIN Accounts a1 ON t.SenderAccountID = a1.AccountID " +
//        	    "LEFT JOIN Accounts a2 ON t.ReceiverAccountID = a2.AccountID " +
//        	    "LEFT JOIN Customers c1 ON a1.CustomerID = c1.CustomerID " +
//        	    "LEFT JOIN Customers c2 ON a2.CustomerID = c2.CustomerID " +
//        	    "LEFT JOIN Users u1 ON c1.UserID = u1.UserID " +
//        	    "LEFT JOIN Users u2 ON c2.UserID = u2.UserID ";
//        	    
//
//
//        if (type != null && !"all".equalsIgnoreCase(type)) {
//            query +="WHERE t.TransactionType = ?" +
//            	    "LIMIT 0, 1000;";
//        }
//
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            if (type != null && !"all".equalsIgnoreCase(type)) {
//                stmt.setString(1, type);
//            }
//
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    String senderAccountNumber = rs.getString("SenderAccountNumber");
//                    String receiverAccountNumber = rs.getString("ReceiverAccountNumber");
//                    String transactionType = rs.getString("TransactionType");
//                    BigDecimal amount = rs.getBigDecimal("Amount");
//                    Timestamp transactionDate = rs.getTimestamp("TransactionDate");
//
//                    Transaction transaction = new Transaction(senderAccountNumber, receiverAccountNumber, transactionType, amount, transactionDate);
//                    transactions.add(transaction);
//                }
//            }
//        }
//
//        return transactions;
//    
//    }
    
}
