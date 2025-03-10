package com.aurionpro.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccountInfoDto {
	private String firstName;
	private String lastName;
	private long accountNumber;
	private double balance;
}
