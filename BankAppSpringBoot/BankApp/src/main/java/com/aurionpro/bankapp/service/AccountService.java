package com.aurionpro.bankapp.service;

import java.util.List;

import com.aurionpro.bankapp.dto.AccountDto;
import com.aurionpro.bankapp.dto.PageResponse;

public interface AccountService {
	PageResponse<AccountDto> getAllAccount(int pageNumber, int pageSize);
}
