package com.aurionpro.bankapp.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.aurionpro.bankapp.dto.AccountDto;
import com.aurionpro.bankapp.dto.CustomerAccountInfoDto;
import com.aurionpro.bankapp.dto.PageResponse;
import com.aurionpro.bankapp.dto.RoleDto;
import com.aurionpro.bankapp.dto.TransactionDto;
import com.aurionpro.bankapp.dto.RegisterDto;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.Role;
import com.aurionpro.bankapp.entity.User;

public interface AdminService {
	@PreAuthorize("hasRole('ADMIN')")
	AccountDto addAccount(int customerId, AccountDto accountDto);
	@PreAuthorize("hasRole('ADMIN')")
	PageResponse<TransactionDto> getAllTransaction(int pageNumber, int pageSize);
	@PreAuthorize("hasRole('ADMIN')")
	PageResponse<CustomerAccountInfoDto> getAllCustomer(int pageNumber, int pageSize);
	@PreAuthorize("hasRole('ADMIN')")
	AccountDto deleteAccount(long accountNumber);
	@PreAuthorize("hasRole('ADMIN')")
	PageResponse<AccountDto> getAllAccountOrderByBalance(int pageNumber, int pageSize);
	@PreAuthorize("hasRole('ADMIN')")
	AccountDto activateAccount(long accountNumber);
}
