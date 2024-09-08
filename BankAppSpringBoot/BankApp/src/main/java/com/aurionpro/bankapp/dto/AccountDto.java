package com.aurionpro.bankapp.dto;

import com.aurionpro.bankapp.entity.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	private int accountId;
	private long accountNumber;
	private double balance;
	private AccountStatus accountStatus;
}
