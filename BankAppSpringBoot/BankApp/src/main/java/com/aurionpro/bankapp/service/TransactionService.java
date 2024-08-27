package com.aurionpro.bankapp.service;

import java.util.List;

import com.aurionpro.bankapp.dto.TransactionDto;
import com.aurionpro.bankapp.entity.Transaction;

public interface TransactionService {
	Transaction processTransaction(long senderAccountId, Long receiverAccountId, Transaction transaction);
	List<TransactionDto> getTransactionsByUserId(int userId);
}
