package com.aurionpro.bankapp.service;

import java.util.List;

import com.aurionpro.bankapp.dto.LoginDto;
import com.aurionpro.bankapp.dto.PageResponse;
import com.aurionpro.bankapp.dto.RegisterDto;
import com.aurionpro.bankapp.entity.User;

public interface RegisterService {
	PageResponse<RegisterDto> getAllUser(int pageNumber, int pageSize);
}
