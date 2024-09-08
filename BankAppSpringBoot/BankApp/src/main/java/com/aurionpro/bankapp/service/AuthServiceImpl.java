package com.aurionpro.bankapp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.dto.LoginDto;
import com.aurionpro.bankapp.dto.RegisterDto;
import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.AccountStatus;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.Role;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.exception.UserApiException;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.repository.RegisterRepository;
import com.aurionpro.bankapp.repository.RoleRepository;
import com.aurionpro.bankapp.security.JwtTokenProvider;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	
	
	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Override
	public User register(RegisterDto registerDto) {
		if (registerRepository.existsByUsername(registerDto.getUsername())) {
	        throw new UserApiException(HttpStatus.BAD_REQUEST, "User Already Exists");
	    }

	    // Create and save the User entity first to ensure userId is generated
	    User user = new User();
	    user.setUsername(registerDto.getUsername());
	    user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
	    

	    // Set roles for the user
	    List<Role> roles = new ArrayList<>();
	    Role userRole = roleRepository.findByRoleName(registerDto.getRole())
	                                  .orElseThrow(() -> new RuntimeException("Role not found"));
	    roles.add(userRole);
	    user.setRoles(roles);

//	    // Save the User entity to generate userId
//	    
//
//	    // Now associate the saved user with the customer
//	    Customer customer = customerRepository.findById(customerId)
//	                                          .orElseThrow(() -> new RuntimeException("Customer not found"));
	    
	    User savedUser = registerRepository.save(user);
	    logger.info("User Registered Successfully");
	    
//	    customer.setUser(savedUser);
//	    customerRepository.save(customer);

	    return savedUser;
	}

	@Override
	public String login(LoginDto loginDto) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = jwtTokenProvider.generateToken(authentication);
			logger.info("Login Successful");
			return token;
			
		}catch(BadCredentialsException e) {
			throw new UserApiException(HttpStatus.NOT_FOUND, "Username and Password is incorrect");
		}
	}

	

}
