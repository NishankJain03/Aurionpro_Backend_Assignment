package com.aurionpro.srp.violations.model;

public class InvoicePrinter {
	private Invoice invoice;
	private TaxCalculator taxCalculator;
	
	public InvoicePrinter(Invoice invoice, TaxCalculator taxCalculator) {
		super();
		this.invoice = invoice;
		this.taxCalculator = taxCalculator;
	}

	public void printInvoice() {
		double tax = taxCalculator.calculateTax();
		double totalAmount = invoice.getAmount() + tax;
		System.out.println("Invoice ID: " + invoice.getInvoiceId());
        System.out.println("Description: " + invoice.getDescription());
        System.out.println("Amount: " + invoice.getAmount());
        System.out.println("Tax: " + tax);
        System.out.println("Total Amount: " + totalAmount);
	}
}	
