package com.aurionpro.bankapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.dto.AccountDto;
import com.aurionpro.bankapp.dto.PageResponse;
import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.mapper.AccountMapper;
import com.aurionpro.bankapp.repository.AccountsRepository;
import com.aurionpro.bankapp.repository.CustomerRepository;

@Service
public class AccountsServiceImpl implements AccountService {

	@Autowired
	private AccountsRepository accountsRepository;

	public Account toAccountMapper(AccountDto accountDto) {
		Account accounts = new Account();
		accounts.setAccountNumber(accountDto.getAccountNumber());
		accounts.setBalance(accountDto.getBalance());

		return accounts;
	}

	@Override
	public PageResponse<AccountDto> getAllAccount(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		Page<Account> accountPage = accountsRepository.findAll(pageable);

		List<AccountDto> accountDtos = accountPage.getContent().stream()
												.map(AccountMapper ::toAccountDtoMapper)
												.collect(Collectors.toList());
		PageResponse<AccountDto> accountResponse = new PageResponse<>();
		accountResponse.setTotalPAges(accountPage.getTotalPages());
		accountResponse.setTotalElements(accountPage.getTotalElements());
		accountResponse.setSze(accountPage.getSize());
		accountResponse.setContents(accountDtos);
		accountResponse.setLastPage(accountPage.isLast());
		
		return accountResponse;
	}
}
