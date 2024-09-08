package com.aurionpro.bankapp.entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import com.aurionpro.bankapp.dto.TransactionDto;

import io.jsonwebtoken.io.IOException;

public class CsvUtils {
	public static File createCsvFile(List<Transaction> transactions) throws IOException {
        File csvFile = new File("transactions.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            writer.write("TransactionId,TransactionAmount,TransactionDate,TransactionStatus,SenderAccount,ReceiverAccount\n");
            for (Transaction transaction : transactions) {
            	Account account = transaction.getReceiverAccount();
            	String receiver = "self";
            	if(account != null)
            		receiver = String.valueOf(account.getAccountNumber());
            	String line = String.format("%d,%f,%s,%s,%s,%s\n",
            		    transaction.getTransactionId(),
            		    transaction.getTransactionAmount(),
            		    transaction.getTransactionDate(),
            		    transaction.getTransactionStatus(),
            		    String.valueOf(transaction.getSenderAccount().getAccountNumber()),            		    
            		    receiver);
                writer.write(line);
            }
        } catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return csvFile;
    }
}
