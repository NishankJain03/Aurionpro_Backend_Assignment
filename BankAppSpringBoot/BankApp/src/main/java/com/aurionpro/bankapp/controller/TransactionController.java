package com.aurionpro.bankapp.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankapp.dto.TransactionDto;
import com.aurionpro.bankapp.entity.Transaction;
import com.aurionpro.bankapp.service.TransactionService;

@RestController
@RequestMapping("/bankapplication")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	@PostMapping("/perform/transaction")
	@PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<Transaction> processTransaction(
            @RequestParam long senderAccountId,
            @RequestParam(required = false) Long receiverAccountId,
            @RequestBody Transaction transaction) {

        Transaction processedTransaction = transactionService.processTransaction(
                senderAccountId, 
                receiverAccountId,
                transaction
        );

        return ResponseEntity.ok(processedTransaction);
    }
	
	
	@GetMapping("/transaction/user/{accountNumber}")
	@PreAuthorize("hasAnyRole('ADMIN')")
    public List<Transaction> getTransactionsByUserId(@PathVariable long accountNumber) {
        return transactionService.getTransactionsByUserId(accountNumber);
    }
	
	@GetMapping("/getSelfTransaction")
	@PreAuthorize("hasRole('CUSTOMER')")
	public List<TransactionDto> get(@RequestParam long accountNumber){
		return transactionService.getTransactionForAccount(accountNumber);
	}
	
	@GetMapping("/sortByDate")
	public ResponseEntity<List<TransactionDto>> transactionSortByDate(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate){
		return ResponseEntity.ok(transactionService.getTransactionFromDate(startDate, endDate));
	}
}	
