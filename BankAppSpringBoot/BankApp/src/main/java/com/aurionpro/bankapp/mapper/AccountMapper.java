package com.aurionpro.bankapp.mapper;

import org.springframework.http.HttpStatus;

import com.aurionpro.bankapp.dto.AccountDto;
import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.exception.UserApiException;

public class AccountMapper {
	public static Account toAccountMapper(AccountDto accountDto) {
		Account accounts = new Account();
		if(accountDto.getBalance() < 0)
			throw new RuntimeException("Balance should be greater than zero");
		if (accountDto.getBalance() < 5000) {
			throw new RuntimeException("Minimum Balance should be greater than or equals to 5000");
		}
		accounts.setBalance(accountDto.getBalance());
		long accountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		accounts.setAccountNumber(accountNumber);
		return accounts;
	}

	public static AccountDto toAccountDtoMapper(Account accounts) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountId(accounts.getAccountId());
		accountDto.setBalance(accounts.getBalance());
		accountDto.setAccountNumber(accounts.getAccountNumber());
		accountDto.setAccountStatus(accounts.getAccountStatus());
		return accountDto;
	}
}	
