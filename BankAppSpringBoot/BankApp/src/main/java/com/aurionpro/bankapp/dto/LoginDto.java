package com.aurionpro.bankapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class LoginDto {
	
	@NotBlank(message = "Username cannot be blank")
	private String username;
	
	@NotBlank(message = "Password cannot be blank")
	private String password;
}
