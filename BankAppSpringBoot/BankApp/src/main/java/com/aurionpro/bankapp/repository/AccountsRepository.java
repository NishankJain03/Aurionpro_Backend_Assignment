package com.aurionpro.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.Account;
import java.util.List;
import java.util.Optional;


public interface AccountsRepository extends JpaRepository<Account, Integer>{
	Optional<Account> findByAccountNumber(long accountNumber);
}
