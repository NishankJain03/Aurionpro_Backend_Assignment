package com.aurionpro.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankapp.dto.AccountDto;
import com.aurionpro.bankapp.dto.PageResponse;
import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.service.AccountService;

@RestController
@RequestMapping("/bankapplication")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/account/getAllAccount")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PageResponse<AccountDto>> getAllAccount(@RequestParam int pageNumber, @RequestParam int pageSize){
		return ResponseEntity.ok(accountService.getAllAccount(pageNumber, pageSize));
	}
	
	
}
