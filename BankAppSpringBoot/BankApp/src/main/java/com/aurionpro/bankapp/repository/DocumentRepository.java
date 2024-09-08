package com.aurionpro.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.Document;
import java.util.List;


public interface DocumentRepository extends JpaRepository<Document, Integer>{
	Document findByCustomer(Customer customer);
	
	
}
