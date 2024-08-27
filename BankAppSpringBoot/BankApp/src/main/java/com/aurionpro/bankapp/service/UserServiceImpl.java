package com.aurionpro.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.dto.UserDto;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public User addUser(User user) {
		User savedUser = userRepository.save(user);
		Customer customer = new Customer();
        customer.setUser(savedUser);
        customerRepository.save(customer);

        return savedUser;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public User toUserMapper(UserDto userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		return user;
	}
	
	public UserDto toUserDtoMapper(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

	@Override
	public UserDto updateUser(int userId, UserDto userDto) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if(!optionalUser.isPresent())
			return null;
		User dbUser = optionalUser.get();
		dbUser.setEmail(userDto.getEmail());
	    dbUser.setFirstName(userDto.getFirstName());
	    dbUser.setLastName(userDto.getLastName());
	    dbUser.setPassword(userDto.getPassword());
		User updatedUser = userRepository.save(dbUser);
		return toUserDtoMapper(updatedUser);
		
	}
	
	
	
	

}
