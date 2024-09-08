package com.aurionpro.bankapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.User;
import java.util.List;


public interface RegisterRepository extends JpaRepository<User, Integer>{
	boolean existsByUsername(String username);
	Optional<User> findByUsername(String username);
}
