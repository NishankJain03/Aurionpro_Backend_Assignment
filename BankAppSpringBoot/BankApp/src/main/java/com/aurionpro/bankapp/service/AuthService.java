package com.aurionpro.bankapp.service;

import com.aurionpro.bankapp.dto.LoginDto;
import com.aurionpro.bankapp.dto.RegisterDto;
import com.aurionpro.bankapp.entity.User;

public interface AuthService {
	User register(RegisterDto registerDto);
	String login(LoginDto loginDto);
}
