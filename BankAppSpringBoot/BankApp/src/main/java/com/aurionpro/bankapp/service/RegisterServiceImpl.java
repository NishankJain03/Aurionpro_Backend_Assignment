package com.aurionpro.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.dto.LoginDto;
import com.aurionpro.bankapp.dto.PageResponse;
import com.aurionpro.bankapp.dto.RegisterDto;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.repository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public RegisterDto toRegisterDtoMapper(User user) {
		RegisterDto registerDto = new RegisterDto();
		registerDto.setUsername(user.getUsername());
		registerDto.setPassword(user.getPassword());
		if (user.getRoles() != null && !user.getRoles().isEmpty()) {
	        registerDto.setRole(user.getRoles().get(0).getRoleName());
	    }
		return registerDto;
		
	}
	
	public static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

	@Override
	public PageResponse<RegisterDto> getAllUser(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		Page<User> userPage = registerRepository.findAll(pageable);
		
		List<RegisterDto> registerDto = userPage.getContent().stream()
												.map(this :: toRegisterDtoMapper)
												.toList();
		
		PageResponse<RegisterDto> registerResponse = new PageResponse<>();
		registerResponse.setTotalPAges(userPage.getTotalPages());
		registerResponse.setTotalElements(userPage.getTotalElements());
		registerResponse.setSze(userPage.getSize());
		registerResponse.setContents(registerDto);
		registerResponse.setLastPage(userPage.isLast());
		return registerResponse;
	}
	
	public LoginDto toLoginDtoMapper(User user) {
		LoginDto loginDto = new LoginDto();
		loginDto.setUsername(user.getUsername());
		loginDto.setPassword(user.getPassword());
		return loginDto;
	}

}
