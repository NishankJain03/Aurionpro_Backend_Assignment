package com.aurionpro.bankapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.Accounts;
import com.aurionpro.bankapp.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	List<Transaction> findBySenderAccount(Accounts senderAccount);
    List<Transaction> findByReceiverAccount(Accounts receiverAccount);
}
