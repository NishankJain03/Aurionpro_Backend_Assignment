package com.aurionpro.bankapp.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.repository.RegisterRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private RegisterRepository registerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = registerRepository.findByUsername(username).orElseThrow(() -> new NullPointerException("User Not Found"));
		Set<GrantedAuthority> authorities = user
				.getRoles()	
				.stream()
				.map((role) ->  new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());
		 return new org.springframework.security.core.userdetails.User(user.getUsername(),
	             user.getPassword(),
	             authorities);	
	}

}
