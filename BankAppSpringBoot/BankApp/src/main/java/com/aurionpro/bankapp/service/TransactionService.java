package com.aurionpro.bankapp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.aurionpro.bankapp.dto.TransactionDto;
import com.aurionpro.bankapp.entity.Transaction;

public interface TransactionService {
	Transaction processTransaction(long senderAccountId, Long receiverAccountId, Transaction transaction);
	List<Transaction> getTransactionsByUserId(long accountNumber);
	List<TransactionDto> getTransactionForAccount(long accountNumber);
	List<TransactionDto> getTransactionFromDate(LocalDateTime startDate, LocalDateTime endDate);
}
