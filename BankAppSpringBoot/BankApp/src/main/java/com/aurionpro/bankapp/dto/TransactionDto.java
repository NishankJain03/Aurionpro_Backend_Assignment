package com.aurionpro.bankapp.dto;

import java.time.LocalDate;

import com.aurionpro.bankapp.entity.Accounts;
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

	private Accounts senderAccount;
	private Accounts receiverAccount;
	private LocalDate transactionDate;
	private double transactionAmount;	
	private TransactionStatus transactionStatus;
}
