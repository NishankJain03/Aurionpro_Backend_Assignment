package com.aurionpro.srp.violations.test;

import com.aurionpro.srp.violations.model.Invoice;
import com.aurionpro.srp.violations.model.InvoicePrinter;
import com.aurionpro.srp.violations.model.TaxCalculator;

public class InvoiceTest {

	public static void main(String[] args) {
		Invoice invoices = new Invoice(123, "Invoice of Electronics", 235000, 15);
		TaxCalculator taxCalculator = new TaxCalculator(invoices);
		InvoicePrinter invoicePrinter = new InvoicePrinter(invoices, taxCalculator);
		
		invoicePrinter.printInvoice();

	}

}
