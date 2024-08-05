package com.aurionpro.test;

import com.aurionpro.model.BankTransferPayment;
import com.aurionpro.model.CreditCardPayment;
import com.aurionpro.model.PayPalPayments;
import com.aurionpro.model.Payment;

public class PaymentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Payment payment;
		payment = new CreditCardPayment();
		payment.processPayments();
		payment.refund();
		
		payment = new PayPalPayments();
		payment.processPayments();
		payment.refund();
		
		payment = new BankTransferPayment();
		payment.processPayments();
		payment.refund();

	}

}
//here we are achieving both the polymorphism and abstraction

//data abstraction
//the abstract methods are the methods that are only declared and subclass have the responsibility to define it 
//for the abstract method the class need to be declared as abstract and the object of the abstract methods cannot be created
//the abstract methods are written to derive that method according to the use case of the subclasses

//you cannot create the object of the abstract class but the references can be created