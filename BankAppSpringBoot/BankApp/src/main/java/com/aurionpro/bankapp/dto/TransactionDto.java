package com.aurionpro.bankapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.TransactionStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

	private int transactionId;
	private long senderAccount;
	private long receiverAccount;
	private LocalDateTime transactionDate;
	private double transactionAmount;	
	private TransactionStatus transactionStatus;
}
