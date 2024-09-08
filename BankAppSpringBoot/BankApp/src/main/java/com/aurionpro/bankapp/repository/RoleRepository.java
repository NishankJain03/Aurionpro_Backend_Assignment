package com.aurionpro.bankapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRoleName(String roleName);
}
