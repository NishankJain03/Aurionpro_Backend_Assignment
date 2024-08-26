package com.aurionpro.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankapp.entity.Accounts;
import com.aurionpro.bankapp.service.AccountService;

@RestController
@RequestMapping("/bankapplication")
public class AccountsController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/addAccount")
	public ResponseEntity<Accounts> addAccounts(@RequestParam int customerId, @RequestBody Accounts accounts){
		return ResponseEntity.ok(accountService.addAccount(customerId, accounts));
	}
}
