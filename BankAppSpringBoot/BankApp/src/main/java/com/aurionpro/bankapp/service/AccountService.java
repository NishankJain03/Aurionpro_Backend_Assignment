package com.aurionpro.bankapp.service;

import com.aurionpro.bankapp.entity.Accounts;

public interface AccountService {
	Accounts addAccount(int customerId, Accounts accounts);
}
