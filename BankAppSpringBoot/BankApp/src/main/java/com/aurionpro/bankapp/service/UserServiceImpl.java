package com.aurionpro.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public User addUser(User user) {
		User savedUser = userRepository.save(user);
		Customer customer = new Customer();
        customer.setUser(savedUser);
        customerRepository.save(customer);

        return savedUser;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	

}
