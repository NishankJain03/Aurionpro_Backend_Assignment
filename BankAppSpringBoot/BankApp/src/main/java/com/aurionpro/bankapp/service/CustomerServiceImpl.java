package com.aurionpro.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.dto.CustomerDto;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.mapper.CustomerMapper;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.repository.RegisterRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Override
	public CustomerDto updateCustomerDetails(int customerId, CustomerDto customerDto) {
		Customer dbCustomer = customerRepository.findById(customerId)
				.orElseThrow(() -> new NullPointerException("Customer Not Found"));
		if (customerDto.getFirstname() != null && !customerDto.getFirstname().isEmpty())
			dbCustomer.setFirstName(customerDto.getFirstname());
		if (customerDto.getLastname() != null && !customerDto.getLastname().isEmpty())
			dbCustomer.setLastName(customerDto.getLastname());
		if (customerDto.getEmail() != null && !customerDto.getEmail().isEmpty())
			dbCustomer.setEmail(customerDto.getEmail());
		Customer updatedCustomer = customerRepository.save(dbCustomer);
		logger.info("Customer Details Updated successfully");
		return CustomerMapper.toCustomerDtoMapper(updatedCustomer);
	}

	@Override
	@Transactional
	public CustomerDto addCustomerDetail(CustomerDto customerDto) {
		Customer customer = CustomerMapper.toCustomerMapper(customerDto);
		Customer updatedCustomer = customerRepository.save(customer);
		logger.info("Customer Added successfully");
		return CustomerMapper.toCustomerDtoMapper(updatedCustomer);
	}

	@Override
	public CustomerDto addUserforCustomer(int userId, CustomerDto customerDto) {
		User user = registerRepository.findById(userId).orElseThrow(() -> new NullPointerException("User not found"));

		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstname());
		customer.setLastName(customerDto.getLastname());
		customer.setEmail(customerDto.getEmail());

		customer.setUser(user);
		Customer savedCustomer = customerRepository.save(customer);
		logger.info("User Id is generated for the customer");

		CustomerDto savedCustomerDto = new CustomerDto();
		savedCustomerDto.setCustomerId(savedCustomer.getCustomerId());
		savedCustomerDto.setFirstname(savedCustomer.getFirstName());
		savedCustomerDto.setLastname(savedCustomer.getLastName());
		savedCustomerDto.setEmail(savedCustomer.getEmail());

		return savedCustomerDto;

	}

	@Override
	public CustomerDto updatePassword(int customerId, String oldPassword, String newPassword) {
		 Optional<Customer> customerOptional = customerRepository.findById(customerId);
	        if (customerOptional.isEmpty()) {
	            throw new RuntimeException("Customer noT FOUND");
	        }

	        Customer customer = customerOptional.get();
	        User user = customer.getUser();

	        // Check if the old password matches the encoded password in the database
	        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
	            throw new RuntimeException("Old password is incorrect.");
	        }

	        // Set the new password (encode it before saving)
	        user.setPassword(passwordEncoder.encode(newPassword));
	        
	        // Save the updated User
	        registerRepository.save(user);
	        Customer updatedCustomer = customerRepository.save(customer);
	        // Save the updated Customer
	        return CustomerMapper.toCustomerDtoMapper(updatedCustomer);
	}

	@Override
	public CustomerDto getCustomerById(int customerId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication.getName());
		Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new NullPointerException("Customer Not Found"));
		System.out.println(customer.getUser().getUserId());
		User user = registerRepository.findByUsername(authentication.getName()).get();
		System.out.println(user.getUserId());
		if(customer.getUser().getUserId() != user.getUserId())
			
			throw new RuntimeException("You are not authorized to view this customer's details");
		return CustomerMapper.toCustomerDtoMapper(customer);
	}

}
