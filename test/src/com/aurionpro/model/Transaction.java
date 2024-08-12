package com.aurionpro.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction {
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private String transactionType;
    private BigDecimal amount;
    private Timestamp transactionDate;

    public Transaction(String senderAccountNumber, String receiverAccountNumber, String transactionType, BigDecimal amount, Timestamp transactionDate) {
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }
}