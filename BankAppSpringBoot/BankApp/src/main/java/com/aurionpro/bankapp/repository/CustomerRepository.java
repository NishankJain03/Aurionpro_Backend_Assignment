package com.aurionpro.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.Customer;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Customer findByUser_UserId(int userId);
	Customer findByUser_Username(String username);
	Customer findByAccounts_AccountNumber(long accountId);
}
