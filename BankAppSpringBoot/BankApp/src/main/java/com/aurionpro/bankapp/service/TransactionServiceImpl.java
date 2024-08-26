package com.aurionpro.bankapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.entity.Accounts;
import com.aurionpro.bankapp.entity.Transaction;
import com.aurionpro.bankapp.entity.TransactionStatus;
import com.aurionpro.bankapp.repository.AccountsRepository;
import com.aurionpro.bankapp.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private TransactionRepository transactionRepository;

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
	
}
