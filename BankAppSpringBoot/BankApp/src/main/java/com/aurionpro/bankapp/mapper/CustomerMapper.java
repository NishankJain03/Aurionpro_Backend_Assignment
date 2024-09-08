package com.aurionpro.bankapp.mapper;

import com.aurionpro.bankapp.dto.CustomerDto;
import com.aurionpro.bankapp.entity.Customer;

public class CustomerMapper {
	public static Customer toCustomerMapper(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setEmail(customerDto.getEmail());
		customer.setFirstName(customerDto.getFirstname());
		customer.setLastName(customerDto.getLastname());
		return customer;
	}
	
	public static CustomerDto toCustomerDtoMapper(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setFirstname(customer.getFirstName());
		customerDto.setLastname(customer.getLastName());
		customerDto.setEmail(customer.getEmail());
		return customerDto;
	}
}
