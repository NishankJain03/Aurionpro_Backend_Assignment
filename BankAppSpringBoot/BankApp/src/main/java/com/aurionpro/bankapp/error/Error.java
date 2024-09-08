package com.aurionpro.bankapp.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Error {
	private int statusCode;
	private String errorMessage;
	private long timeStamp;
}