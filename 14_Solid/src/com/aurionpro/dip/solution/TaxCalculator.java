package com.aurionpro.dip.solution;

import com.aurionpro.dip.violation.model.DBLogger;

public class TaxCalculator {
	private ILogger ilogger;
	
	public TaxCalculator(ILogger ilogger) {
		super();
		this.ilogger = ilogger;
	}

	public void calculateTax(int amount, int rate) {
		int tax = 0;
		try {
			tax = amount / rate;
			System.out.println(tax);
		}catch(Exception e) {
			new DBLogger().log("Divide by zero");
			new FileLogger().log("Divide by zero");
		}
	}
}
