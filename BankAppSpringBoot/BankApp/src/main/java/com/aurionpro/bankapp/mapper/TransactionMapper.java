package com.aurionpro.bankapp.mapper;

import com.aurionpro.bankapp.dto.TransactionDto;
import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.Transaction;

public class TransactionMapper {
//	public static Transaction toTransactionMapper(TransactionDto transactionDto) {
//		Transaction transaction = new Transaction();
//		transaction.setSenderAccount(transactionDto.getSenderAccount());
//		transaction.setReceiverAccount(transactionDto.getReceiverAccount());
//		transaction.setTransactionAmount(transactionDto.getTransactionAmount());
//		transaction.setTransactionDate(transactionDto.getTransactionDate());
//		transaction.setTransactionStatus(transactionDto.getTransactionStatus());
//		return transaction;
//	}
	
	public static TransactionDto toTransactionDtoMapper(Transaction transaction) {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setTransactionId(transaction.getTransactionId());
		transactionDto.setSenderAccount(transaction.getSenderAccount().getAccountNumber());
		Account account = transaction.getReceiverAccount();
    	long receiver = 0L;
    	if(account != null)
    		receiver = transaction.getReceiverAccount().getAccountNumber();
		transactionDto.setReceiverAccount(receiver);
		transactionDto.setTransactionAmount(transaction.getTransactionAmount());
		transactionDto.setTransactionDate(transaction.getTransactionDate());
		transactionDto.setTransactionStatus(transaction.getTransactionStatus());
		return transactionDto;
	}
}
