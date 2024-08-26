package com.techlabs.lending.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.lending.entity.Loan;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;



@Repository
public class LoanRepositoryImpl implements LoanRepository{

	
	@Autowired
	private EntityManager manager;
	
	
	@Override
	public List<Loan> getAllLoans() {
		TypedQuery<Loan> query = manager.createQuery("SELECT l from Loan l",Loan.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addLoan(Loan loan) {
		manager.persist(loan);
		
	}

	@Override
	@Transactional
	public void updateLoan(Loan loan) {
		Loan existingLoan = manager.find(Loan.class, loan.getLoanID());
		existingLoan.setEndDate(loan.getEndDate());
		existingLoan.setStartDate(loan.getStartDate());
		existingLoan.setLoanStatus(loan.getLoanStatus());
		existingLoan.setLoanTerm(loan.getLoanTerm());
		existingLoan.setRateofinterest(loan.getRateofinterest());
		
		manager.merge(loan);
		
	}

	@Override
	@Transactional
	public void deleteLoan(Loan loan) {
		Loan existingLoan = manager.find(Loan.class ,loan.getLoanID() );
		manager.remove(existingLoan);
		
	}

}
