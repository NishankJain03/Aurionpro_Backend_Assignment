package com.aurionpro.bankapp.service;

import java.util.List;

import com.aurionpro.bankapp.entity.User;

public interface UserService {
	
	User addUser(User user);
	
	List<User> getAllUser();
}
