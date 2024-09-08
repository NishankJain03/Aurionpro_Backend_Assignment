package com.aurionpro.bankapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.dto.AccountDto;
import com.aurionpro.bankapp.dto.CustomerAccountInfoDto;
import com.aurionpro.bankapp.dto.PageResponse;
import com.aurionpro.bankapp.dto.RoleDto;
import com.aurionpro.bankapp.dto.TransactionDto;
import com.aurionpro.bankapp.dto.RegisterDto;
import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.AccountStatus;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.EmailDetails;
import com.aurionpro.bankapp.entity.Role;
import com.aurionpro.bankapp.entity.Transaction;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.mapper.AccountMapper;
import com.aurionpro.bankapp.mapper.TransactionMapper;
import com.aurionpro.bankapp.repository.AccountsRepository;
import com.aurionpro.bankapp.repository.AdminRepository;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.repository.RoleRepository;
import com.aurionpro.bankapp.repository.TransactionRepository;
import com.aurionpro.bankapp.repository.RegisterRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private TransactionRepository transactionRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private EmailService emailService;

	public EmailDetails EmailDetails(String message, String subject) {
		EmailDetails emailDetails = new EmailDetails();
		emailDetails.setRecipient("nishankjain122@gmail.com");
		emailDetails.setSubject(subject);
		emailDetails.setMsgBody(message);
		return emailDetails;
	}
	@Override
	public AccountDto addAccount(int customerId, AccountDto accountDto) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new NullPointerException("Customer Not Found"));

		Account accounts = AccountMapper.toAccountMapper(accountDto);
		accounts.setCustomer(customer);
		accounts.setAccountStatus(AccountStatus.ACTIVE);
		String message = String.format("Account has been created successfully, Your Account Number is %d and Your Balance is %.2f", accounts.getAccountNumber(), accounts.getBalance());
		String subject = "Account Creation Notification";
		EmailDetails emailDetails = EmailDetails(message, subject);
		Account savedAccounts = accountsRepository.save(accounts);
		logger.info("Account Added Successfully");
		emailService.sendMail(emailDetails);
		return AccountMapper.toAccountDtoMapper(savedAccounts);
	}
	
	public PageResponse<TransactionDto> getPageResponse(Page<Transaction> transactionPage, List<TransactionDto> transactionDtos){
		PageResponse<TransactionDto> transactionResponse = new PageResponse<>();
		transactionResponse.setTotalPAges(transactionPage.getTotalPages());
		transactionResponse.setTotalElements(transactionPage.getTotalElements());
		transactionResponse.setSze(transactionPage.getSize());
		transactionResponse.setContents(transactionDtos);
		transactionResponse.setLastPage(transactionPage.isLast());

		return transactionResponse;
	}

	@Override
	public PageResponse<TransactionDto> getAllTransaction(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Transaction> transactionPage = transactionRepository.findAll(pageable);
		List<TransactionDto> transactionDtos = transactionPage.getContent().stream()
				.map(TransactionMapper::toTransactionDtoMapper).toList();
		return getPageResponse(transactionPage, transactionDtos);
	}

	@Override
	public PageResponse<CustomerAccountInfoDto> getAllCustomer(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		Page<Customer> customersPage = customerRepository.findAll(pageable);
		
		List<CustomerAccountInfoDto> customerAccountInfoDtos = new ArrayList<>();

		for (Customer customer : customersPage.getContent()) {
			String firstName = customer.getFirstName();
			String lastName = customer.getLastName();

			for (Account account : customer.getAccounts()) {
				CustomerAccountInfoDto dto = new CustomerAccountInfoDto(firstName, lastName, account.getAccountNumber(),
						account.getBalance());
				customerAccountInfoDtos.add(dto);
			}
		}
		PageResponse<CustomerAccountInfoDto> customerResponse = new PageResponse<>();
		customerResponse.setTotalPAges(customersPage.getTotalPages());
		customerResponse.setTotalElements(customersPage.getTotalElements());
		customerResponse.setSze(customersPage.getSize());
		customerResponse.setLastPage(customersPage.isLast());
		customerResponse.setContents(customerAccountInfoDtos);
		
		return customerResponse;
	}

	@Override
	public AccountDto deleteAccount(long accountNumber) {
		Account account = accountsRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new NullPointerException("Account Number Not Found"));
		
		if(account.getAccountStatus().equals(AccountStatus.INACTIVE))
			throw new NullPointerException("Account is already INACTIVE");
		account.setAccountStatus(AccountStatus.INACTIVE);
		
		Account updatedAccount = accountsRepository.save(account);
		logger.info("Account has been deleted successfully");
		String message = "Your Account has been Deactived from Now Onwards";
		String subject = "Account Deactivation Alert";
		EmailDetails emailDetails = EmailDetails(message, subject);
		emailService.sendMail(emailDetails);
		return AccountMapper.toAccountDtoMapper(updatedAccount);
	}
	

	@Override
	public PageResponse<AccountDto> getAllAccountOrderByBalance(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		Page<Account> accountPage = accountsRepository.findAll(pageable);
		
		List<AccountDto> accountDtos = new ArrayList<>(accountPage.getContent().stream()
	            .map(AccountMapper::toAccountDtoMapper)
	            .collect(Collectors.toList()));
		accountDtos.sort((a1, a2) -> Double.compare(a2.getBalance(), a1.getBalance()));
		PageResponse<AccountDto> accountResponse = new PageResponse<>();
		accountResponse.setTotalPAges(accountPage.getTotalPages());
		accountResponse.setTotalElements(accountPage.getTotalElements());
		accountResponse.setSze(accountPage.getSize());
		accountResponse.setContents(accountDtos);
		accountResponse.setLastPage(accountPage.isLast());
		return accountResponse;
		
	}
	@Override
	public AccountDto activateAccount(long accountNumber) {
		Account account = accountsRepository.findByAccountNumber(accountNumber).orElseThrow(()-> new NullPointerException("Account Number is not present"));
		if(account.getAccountStatus() == AccountStatus.ACTIVE)
			throw new NullPointerException("Account is already active");
		account.setAccountStatus(AccountStatus.ACTIVE);	
		Account updatedAccount = accountsRepository.save(account);
		logger.info("Account has been activated successfully");
		String message = "Your Account has been Activated from Now Onwards";
		String subject = "Account Activation Alert";
		EmailDetails emailDetails = EmailDetails(message, subject);
		emailService.sendMail(emailDetails);
		return AccountMapper.toAccountDtoMapper(updatedAccount);
	}

}

