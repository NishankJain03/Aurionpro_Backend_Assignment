package com.aurionpro.bankapp.service;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.dto.TransactionDto;
import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.AccountStatus;
import com.aurionpro.bankapp.entity.CsvUtils;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.Document;
import com.aurionpro.bankapp.entity.EmailDetails;
import com.aurionpro.bankapp.entity.KycStatus;
import com.aurionpro.bankapp.entity.Transaction;
import com.aurionpro.bankapp.entity.TransactionStatus;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.mapper.TransactionMapper;
import com.aurionpro.bankapp.repository.AccountsRepository;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.repository.DocumentRepository;
import com.aurionpro.bankapp.repository.RegisterRepository;
import com.aurionpro.bankapp.repository.TransactionRepository;

import io.jsonwebtoken.io.IOException;
import jakarta.transaction.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private RegisterRepository registerRepository;

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Override
	@Transactional
	public Transaction processTransaction(long senderAccountId, Long receiverAccountId, Transaction transaction) {
		Account senderAccount = accountsRepository.findByAccountNumber(senderAccountId)
				.orElseThrow(() -> new RuntimeException("Sender Not Found"));
		Customer customer = customerRepository.findByAccounts_AccountNumber(senderAccountId);
		Document document = documentRepository.findByCustomer(customer);
		String transactionType = transaction.getTransactionStatus().toString();
		String message = String.format("Transaction of type %s successful. Amount: %.2f", transactionType,
				transaction.getTransactionAmount());

		EmailDetails emailDetails = new EmailDetails();
		emailDetails.setRecipient("nishankjain122@gmail.com");
		emailDetails.setSubject("Transaction Notification");
		emailDetails.setMsgBody(message);
		switch (transaction.getTransactionStatus()) {
		case CREDIT:
			if (transaction.getTransactionAmount() < 0)
				throw new RuntimeException("Credit Amount Should be Greater than zero");
			if (receiverAccountId != null)
				throw new RuntimeException("Receiver account Id is present");
			if (senderAccount.getAccountStatus().equals(AccountStatus.INACTIVE))
				throw new RuntimeException("Cannot credit since account is inactive");
			if (!document.getKycStatus().equals(KycStatus.APPROVED))
				throw new RuntimeException("You first need to approve your kyc status");
			senderAccount.setBalance(senderAccount.getBalance() + transaction.getTransactionAmount());
			transaction.setSenderAccount(senderAccount);
			logger.info("Credit successful");
			break;

		case DEBIT:
			if (senderAccount.getBalance() < transaction.getTransactionAmount()
					&& transaction.getTransactionAmount() < 0) {
				throw new RuntimeException("Insufficient balance");
			}
			if (transaction.getTransactionAmount() < 0)
				throw new RuntimeException("Debit Amount should be greater than zero");
			if (receiverAccountId != null)
				throw new RuntimeException("Receiver account Id is present");
			if (senderAccount.getAccountStatus().equals(AccountStatus.INACTIVE))
				throw new RuntimeException("Cannot debit since account is inactive");
			if (!document.getKycStatus().equals(KycStatus.APPROVED))
				throw new RuntimeException("You first need to approve your kyc status");
			senderAccount.setBalance(senderAccount.getBalance() - transaction.getTransactionAmount());
			transaction.setSenderAccount(senderAccount);
			logger.info("Debited successfully");
			break;

		case TRANSFER:
			Optional<Account> optionalReceiverAccount = accountsRepository.findByAccountNumber(receiverAccountId);
			if (!optionalReceiverAccount.isPresent()) {
				throw new RuntimeException("Receiver account not found");
			}

			Account receiverAccount = optionalReceiverAccount.get();

			if (senderAccount.getBalance() < transaction.getTransactionAmount()) {
				throw new RuntimeException("Insufficient balance");
			}
			if (transaction.getTransactionAmount() < 0)
				throw new RuntimeException("Transfer Amount should be greater than zero");
			if (senderAccount.getAccountId() == receiverAccount.getAccountId())
				throw new RuntimeException("Sender & Receiver Account Number cannot be same");
			if (senderAccount.getAccountStatus().equals(AccountStatus.INACTIVE)
					|| receiverAccount.getAccountStatus().equals(AccountStatus.INACTIVE))
				throw new RuntimeException("Cannot perform transfer since account is inactive");
			if (!document.getKycStatus().equals(KycStatus.APPROVED))
				throw new RuntimeException("You first need to approve your kyc status");
			senderAccount.setBalance(senderAccount.getBalance() - transaction.getTransactionAmount());
			receiverAccount.setBalance(receiverAccount.getBalance() + transaction.getTransactionAmount());

			transaction.setSenderAccount(senderAccount);
			transaction.setReceiverAccount(receiverAccount);
			logger.info("Amount Transfered successfully");
			EmailDetails receiverEmailDetails = new EmailDetails();
			receiverEmailDetails.setRecipient(receiverAccount.getCustomer().getEmail());
			receiverEmailDetails.setSubject("Transaction Notification");
			receiverEmailDetails.setMsgBody(message);
			emailService.sendMail(receiverEmailDetails);
			break;

		default:
			throw new RuntimeException("Invalid transaction type");
		}
		transaction.setTransactionDate(LocalDateTime.now());

		accountsRepository.save(senderAccount);
		if (transaction.getTransactionStatus() == TransactionStatus.TRANSFER) {
			accountsRepository.save(transaction.getReceiverAccount());
		}
		Transaction savedTransaction = transactionRepository.save(transaction);
		emailService.sendMail(emailDetails);
		return savedTransaction;
	}

	@Override
	public List<Transaction> getTransactionsByUserId(long accountNumber) {
		List<Transaction> transactions = transactionRepository.findBySenderAccount_AccountNumberOrReceiverAccount_AccountNumber(accountNumber, accountNumber);
		File csvFile;
        try {
            csvFile = CsvUtils.createCsvFile(transactions);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create CSV file", e);
        }
        // Send Email
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient("nishankjain122@gmail.com");
        emailDetails.setSubject("Transaction Report");
        emailDetails.setMsgBody("Please find the attached transaction report.");
        emailDetails.setAttachment(csvFile.getAbsolutePath());
        emailService.sendMailWithAttachment(emailDetails);

		return  transactions;
	}

	@Override
	public List<TransactionDto> getTransactionForAccount(long accountNumber) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication.getName());
		
		boolean flag = false;
		List<Account> accounts = customerRepository.findByUser_Username(authentication.getName()).getAccounts();
		for(Account account: accounts) {
			if(account.getAccountNumber() == accountNumber)
				flag = true;
		}
		if(flag==false)
			throw new RuntimeException("User does not have specified account");
		
		
		List<TransactionDto> transactionDtos = new ArrayList<>();
		
		List<Transaction> transactions = transactionRepository.findBySenderAccount_AccountNumberOrReceiverAccount_AccountNumber(accountNumber, accountNumber);
		
		for(Transaction transaction : transactions) {
			transactionDtos.add(TransactionMapper.toTransactionDtoMapper(transaction));
		}
		
		return transactionDtos;
	}

	@Override
	public List<TransactionDto> getTransactionFromDate(LocalDateTime startDate, LocalDateTime endDate) {
		List<Transaction> transactions = transactionRepository.findByTransactionDateBetween(startDate, endDate);
		List<TransactionDto> transactionDtos = new ArrayList<>();
		
		for(Transaction transaction : transactions) {
			transactionDtos.add(TransactionMapper.toTransactionDtoMapper(transaction));
		}
		return transactionDtos;
	}

}
