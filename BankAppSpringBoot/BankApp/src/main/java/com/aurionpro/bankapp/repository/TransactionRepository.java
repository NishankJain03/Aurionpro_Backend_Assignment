package com.aurionpro.bankapp.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	List<Transaction> findBySenderAccount(Account senderAccount);
    List<Transaction> findByReceiverAccount(Account receiverAccount);
    List<Transaction> findBySenderAccount_AccountNumberOrReceiverAccount_AccountNumber(long senderaccountNumber, long receiveraccountNumber);
    List<Transaction> findByTransactionDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
}
