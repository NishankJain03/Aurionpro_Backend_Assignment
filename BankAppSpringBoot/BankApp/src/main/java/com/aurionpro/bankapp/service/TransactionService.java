package com.aurionpro.bankapp.service;

import com.aurionpro.bankapp.entity.Transaction;

public interface TransactionService {
	Transaction processTransaction(long senderAccountId, Long receiverAccountId, Transaction transaction);
}
