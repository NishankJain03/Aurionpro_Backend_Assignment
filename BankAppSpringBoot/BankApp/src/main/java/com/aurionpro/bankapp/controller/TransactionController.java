package com.aurionpro.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankapp.entity.Transaction;
import com.aurionpro.bankapp.service.TransactionService;

@RestController
@RequestMapping("/bankapplication")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/process")
    public ResponseEntity<Transaction> processTransaction(
            @RequestParam long senderAccountId,
            @RequestParam(required = false) Long receiverAccountId,
            @RequestBody Transaction transaction) {

        Transaction processedTransaction = transactionService.processTransaction(
                senderAccountId, 
                receiverAccountId != null ? receiverAccountId : 0, 
                transaction
        );

        return ResponseEntity.ok(processedTransaction);
    }
}	
