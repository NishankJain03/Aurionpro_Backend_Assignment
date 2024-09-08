package com.aurionpro.bankapp.service;

import com.aurionpro.bankapp.dto.CustomerDto;
import com.aurionpro.bankapp.entity.Customer;

public interface CustomerService {

	CustomerDto updateCustomerDetails(int customerId, CustomerDto customerDto);
	CustomerDto addCustomerDetail(CustomerDto customerDto);
	CustomerDto addUserforCustomer(int userId, CustomerDto customerDto);
	CustomerDto updatePassword(int customerId, String oldPassword, String newPassword);
	CustomerDto getCustomerById(int customerId);
}
