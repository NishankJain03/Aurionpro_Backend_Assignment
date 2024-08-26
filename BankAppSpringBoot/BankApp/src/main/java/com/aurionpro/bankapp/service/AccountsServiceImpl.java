package com.aurionpro.bankapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.entity.Accounts;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.repository.AccountsRepository;
import com.aurionpro.bankapp.repository.CustomerRepository;

@Service
public class AccountsServiceImpl implements AccountService{

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public Accounts addAccount(int customerId, Accounts accounts) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(!optionalCustomer.isPresent())
			return null;
		Customer dbCustomer = optionalCustomer.get();
		accounts.setCustomer(dbCustomer);
		return accountsRepository.save(accounts);
			
		
	}
}
