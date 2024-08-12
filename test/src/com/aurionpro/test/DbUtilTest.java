package com.aurionpro.test;

import java.util.List;

import com.aurionpro.model.DbUtil;
import com.aurionpro.model.Transaction;

public class DbUtilTest {

	public static void main(String[] args) {
		DbUtil dbUtil = DbUtil.getDbUtil();
        
        // Connect to the database
        dbUtil.connectToDo();
        
        // Replace with an appropriate userID for testing
        int testUserID = 4; // Example userID

        // Fetch all transactions for the specified userID
        List<Transaction> transactions = dbUtil.getAllTransactions(testUserID);

        // Print transaction details to the console
        for (Transaction transaction : transactions) {
            System.out.println("Sender Account Number: " + transaction.getSenderAccountNumber());
            System.out.println("Receiver Account Number: " + transaction.getReceiverAccountNumber());
            System.out.println("Type of Transaction: " + transaction.getTransactionType());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Date: " + transaction.getTransactionDate());
            System.out.println("-------------------------");
        }

	}

}
