package com.aurionpro.bankapp.controller;

import java.util.List;

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

import com.aurionpro.bankapp.dto.AccountDto;
import com.aurionpro.bankapp.dto.CustomerAccountInfoDto;
import com.aurionpro.bankapp.dto.PageResponse;
import com.aurionpro.bankapp.dto.RoleDto;
import com.aurionpro.bankapp.dto.TransactionDto;
import com.aurionpro.bankapp.dto.RegisterDto;
import com.aurionpro.bankapp.service.AdminService;

@RestController
@RequestMapping("/bankapplication")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin/addAccount")
	private ResponseEntity<AccountDto> addAccountNumber(@RequestParam int customerId, @RequestBody AccountDto accountDto){
		return ResponseEntity.ok(adminService.addAccount(customerId, accountDto));
	}
	
	@GetMapping("/admin/getAllTransaction")
	private ResponseEntity<PageResponse<TransactionDto>> getAllAdminTransaction(@RequestParam int pageNumber, @RequestParam int pageSize){
		return ResponseEntity.ok(adminService.getAllTransaction(pageNumber, pageSize));
	}
	
	@GetMapping("/admin/getAllCustomer")
	private ResponseEntity<PageResponse<CustomerAccountInfoDto>> getAllAdminCustomer(@RequestParam int pageNumber, @RequestParam int pageSize){
		return ResponseEntity.ok(adminService.getAllCustomer(pageNumber, pageSize));
	}
	@PostMapping("/admin/deleteAccount")
	public ResponseEntity<AccountDto> inactiveAccount(@RequestParam long accountNumber){
		return ResponseEntity.ok(adminService.deleteAccount(accountNumber));
	}
	@GetMapping("/admin/getAccountSortByBalance")
	private ResponseEntity<PageResponse<AccountDto>> getAllAccountBalance(@RequestParam int pageNumber, @RequestParam int pageSize){
		return ResponseEntity.ok(adminService.getAllAccountOrderByBalance(pageNumber, pageSize));
	}
	
	@PostMapping("/admin/activateAccount")
	private ResponseEntity<AccountDto> activeAccount(@RequestParam long accountNumber){
		return ResponseEntity.ok(adminService.activateAccount(accountNumber));
	}
	
}
