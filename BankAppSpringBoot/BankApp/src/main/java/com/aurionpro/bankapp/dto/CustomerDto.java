package com.aurionpro.bankapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private int customerId;
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabetic characters are allowed")
	@NotNull(message = "FirstName cannot be null")
	@NotBlank(message = "FirstName cannot be blank")
	private String firstname;
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabetic characters are allowed")
	@NotNull(message = "LastName cannot be null")
	@NotBlank(message = "LastName cannot be blank")
	private String lastname;
	
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid email address")
	@NotNull(message = "Email cannot be null") 
	@NotBlank(message = "Email cannot be blank")
	private String email;
}
