package com.aurionpro.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
