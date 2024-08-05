package com.aurionpro.test;

import com.aurionpro.model.BankTransferPayments;
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
		
		payment = new BankTransferPayments();
		payment.processPayments();
		payment.refund();

	}

}

//similarly we cannot create a object but can create a reference 
// also reference can access to any object of the class implementing the interface
// in interface all the methods are only declared but cannot be defined
// also the class which implements this had to compulsorily define all the methods 
// one interface can extends another interface
// from java 8 we can define the method in the interface for that we need to declared default keyword
// we can write this method in the class that implements interface that method will be overridden but if we not override 
// then the default version of the method is called
//another way to define the method in the interface is using the static and it be can called using the name of the interface

