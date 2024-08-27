package com.aurionpro.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankapp.dto.UserDto;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.service.UserService;

@RestController
@RequestMapping("/bankapplication")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		userService.addUser(user);
		return "User Added Successfully";
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(userService.getAllUser());
	}

	@PutMapping("/updateUser")
	public ResponseEntity<UserDto> updateUser(@RequestParam int userId, @RequestBody UserDto userDto){
		return ResponseEntity.ok(userService.updateUser(userId, userDto));
	}
}
