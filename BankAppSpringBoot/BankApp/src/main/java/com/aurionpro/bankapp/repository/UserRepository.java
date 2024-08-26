package com.aurionpro.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
