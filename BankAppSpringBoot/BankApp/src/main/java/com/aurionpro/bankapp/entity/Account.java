package com.aurionpro.bankapp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
	
	@Column(name = "accountId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	@Column(name = "accountNumber")
	private long accountNumber;
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "accountStatus")
	private AccountStatus accountStatus;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	
	@OneToMany(mappedBy = "senderAccount", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
	private List<Transaction> sentTransactions;

	@OneToMany(mappedBy = "receiverAccount", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
	private List<Transaction> receivedTransactions;
}
