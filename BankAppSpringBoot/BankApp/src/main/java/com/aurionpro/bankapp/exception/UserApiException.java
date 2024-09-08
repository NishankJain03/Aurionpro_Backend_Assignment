package com.aurionpro.bankapp.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserApiException extends RuntimeException{
	
	private HttpStatus httpStatus;
	private String message;
}
