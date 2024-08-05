package com.aurionpro.dip.solution;

public class TaxCalculatorTest {

	public static void main(String[] args) {
		TaxCalculator t1 = new TaxCalculator(new FileLogger());
		t1.calculateTax(45, 0);

	}

}
