package com.aurionpro.bankapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {
	
	@Column(name = "transactionId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	@Column(name = "transactionStatus")
	private TransactionStatus transactionStatus;
	
	@Column(name = "transactionAmount")
	private double transactionAmount;
	
	@Column(name = "transactionDate")
	private LocalDate transactionDate;
	
	@ManyToOne
    @JoinColumn(name = "senderAccountId", referencedColumnName = "accountId")
    private Accounts senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiverAccountId", referencedColumnName = "accountId")
    private Accounts receiverAccount;
}
