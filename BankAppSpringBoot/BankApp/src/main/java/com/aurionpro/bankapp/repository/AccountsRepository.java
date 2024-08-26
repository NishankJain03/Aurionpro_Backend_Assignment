package com.aurionpro.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.Accounts;
import java.util.List;
import java.util.Optional;


public interface AccountsRepository extends JpaRepository<Accounts, Integer>{
	Optional<Accounts> findByAccountNumber(long accountNumber);
}
