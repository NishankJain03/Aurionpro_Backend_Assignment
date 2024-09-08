package com.aurionpro.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankapp.dto.JwtAuthResponse;
import com.aurionpro.bankapp.dto.LoginDto;
import com.aurionpro.bankapp.dto.RegisterDto;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/bankapplication")
public class LoginController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody RegisterDto registrationDto){
		return ResponseEntity.ok(authService.register(registrationDto));
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam("captcha") String captcha, 
            HttpServletRequest request, @RequestBody LoginDto loginDto){
		 String captchaSession = (String) request.getSession().getAttribute("captcha");

	        if (captcha.equals(captchaSession)) {
	            String token = authService.login(loginDto);
	            JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
	            jwtAuthResponse.setAccessToken(token);
	            return ResponseEntity.ok(jwtAuthResponse);
	        } else {
	            return ResponseEntity.badRequest().body("Invalid CAPTCHA");
	        }
	}
}
