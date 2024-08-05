package com.aurionpro.srp.violations.test;

import com.aurionpro.ocp.solution.DiwaliInterest;
import com.aurionpro.ocp.solution.FixedDeposit;

public class FixedDepositSolutionTest {

	public static void main(String[] args) {
		FixedDeposit fixedDeposit = new FixedDeposit(100, "Nishank", 40000, 3, new DiwaliInterest());
		System.out.println(fixedDeposit.calculateSimpleInterest());

	}

}
