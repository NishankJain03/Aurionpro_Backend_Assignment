package com.aurionpro.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
