package com.aurionpro.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankapp.dto.CustomerDto;
import com.aurionpro.bankapp.dto.TransactionDto;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.service.CustomerService;

@RestController
@RequestMapping("/bankapplication")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PreAuthorize("hasRole('CUSTOMER')")
	@PutMapping("/updateCustomerDetail")
	public ResponseEntity<CustomerDto> updateCustomerDetails(@RequestParam int customerId, @RequestBody CustomerDto customerDto ){
		return ResponseEntity.ok(customerService.updateCustomerDetails(customerId, customerDto));
	}
	
	@PostMapping("/addCustomerDetails")
	public ResponseEntity<CustomerDto> addCustomerDetail(@RequestBody CustomerDto customerDto){
		return ResponseEntity.ok(customerService.addCustomerDetail(customerDto));
	}
	
	@PostMapping("/addUserforCustomer")
	public ResponseEntity<CustomerDto> addUserIdtoCustomer(@RequestParam int userId, @RequestBody CustomerDto customerDto){
		return ResponseEntity.ok(customerService.addUserforCustomer(userId, customerDto));
	}
	
	 @PutMapping("/customers/password")
	    public ResponseEntity<CustomerDto> updatePassword(
									            @RequestParam("customerId") int customerId,
									            @RequestParam("oldPassword") String oldPassword,
									            @RequestParam("newPassword") String newPassword) 
	    {
	        return ResponseEntity.ok(customerService.updatePassword(customerId, oldPassword, newPassword));
	    }
	 
	 @GetMapping("/getCustomerById")
	 public ResponseEntity<CustomerDto> getCustomerSelfDetails(@RequestParam int customerId){
		 return ResponseEntity.ok(customerService.getCustomerById(customerId));
	 }
}
