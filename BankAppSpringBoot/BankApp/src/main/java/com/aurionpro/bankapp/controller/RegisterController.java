package com.aurionpro.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankapp.dto.LoginDto;
import com.aurionpro.bankapp.dto.PageResponse;
import com.aurionpro.bankapp.dto.RegisterDto;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.service.RegisterService;

@RestController
@RequestMapping("/bankapplication")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/user/getAllUser")
	public ResponseEntity<PageResponse<RegisterDto>> getAllUser(@RequestParam int pageNumber, @RequestParam int pageSize){
		return ResponseEntity.ok(registerService.getAllUser(pageNumber, pageSize));
	}
	
}
