package com.aurionpro.bankapp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.dto.TransactionDto;
import com.aurionpro.bankapp.entity.Accounts;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.Transaction;
import com.aurionpro.bankapp.entity.TransactionStatus;
import com.aurionpro.bankapp.repository.AccountsRepository;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

	@Override
	public Transaction processTransaction(long senderAccountId, Long receiverAccountId, Transaction transaction) {
		Optional<Accounts> optionalSenderAccount = accountsRepository.findByAccountNumber(senderAccountId);
        if (!optionalSenderAccount.isPresent()) {
            throw new RuntimeException("Sender account not found");
        }

        Accounts senderAccount = optionalSenderAccount.get();

        switch (transaction.getTransactionStatus()) {
            case CREDIT:
                senderAccount.setBalance(senderAccount.getBalance() + transaction.getTransactionAmount());
                transaction.setSenderAccount(senderAccount);
                break;

            case DEBIT:
                if (senderAccount.getBalance() < transaction.getTransactionAmount()) {
                    throw new RuntimeException("Insufficient balance");
                }
                senderAccount.setBalance(senderAccount.getBalance() - transaction.getTransactionAmount());
                transaction.setSenderAccount(senderAccount);
                break;

            case TRANSFER:
                Optional<Accounts> optionalReceiverAccount = accountsRepository.findByAccountNumber(receiverAccountId);
                if (!optionalReceiverAccount.isPresent()) {
                    throw new RuntimeException("Receiver account not found");
                }

                Accounts receiverAccount = optionalReceiverAccount.get();

                if (senderAccount.getBalance() < transaction.getTransactionAmount()) {
                    throw new RuntimeException("Insufficient balance");
                }

                senderAccount.setBalance(senderAccount.getBalance() - transaction.getTransactionAmount());
                receiverAccount.setBalance(receiverAccount.getBalance() + transaction.getTransactionAmount());

                transaction.setSenderAccount(senderAccount);
                transaction.setReceiverAccount(receiverAccount);
                break;

            default:
                throw new RuntimeException("Invalid transaction type");
        }

        accountsRepository.save(senderAccount);
        if (transaction.getTransactionStatus() == TransactionStatus.TRANSFER) {
            accountsRepository.save(transaction.getReceiverAccount());
        }
        return transactionRepository.save(transaction);
	}
	
	public Transaction toTransactionMapper(TransactionDto transactionDto) {
		Transaction transaction = new Transaction();
		transaction.setSenderAccount(transactionDto.getSenderAccount());
		transaction.setReceiverAccount(transactionDto.getReceiverAccount());
		transaction.setTransactionAmount(transactionDto.getTransactionAmount());
		transaction.setTransactionDate(transactionDto.getTransactionDate());
		transaction.setTransactionStatus(transactionDto.getTransactionStatus());
		return transaction;
	}
	
	public TransactionDto toTransactionDtoMapper(Transaction transaction) {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setSenderAccount(transaction.getSenderAccount());
		transactionDto.setReceiverAccount(transaction.getReceiverAccount());
		transactionDto.setTransactionAmount(transaction.getTransactionAmount());
		transactionDto.setTransactionDate(transaction.getTransactionDate());
		transactionDto.setTransactionStatus(transaction.getTransactionStatus());
		return transactionDto;
	}

	@Override
	public List<TransactionDto> getTransactionsByUserId(int userId) {
		Customer customer = customerRepository.findByUser_UserId(userId);
        
        // Collect all accounts for this customer
        Set<Accounts> accounts = new HashSet<>(customer.getAccounts());

        // Fetch transactions for each account
        Set<Transaction> transactions = new HashSet<>();
        for (Accounts account : accounts) {
            transactions.addAll(transactionRepository.findBySenderAccount(account));
            transactions.addAll(transactionRepository.findByReceiverAccount(account));
            
        }

        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (Transaction transaction : transactions) {
            transactionDtos.add(toTransactionDtoMapper(transaction));
        }

        return transactionDtos;
	}
	
}
