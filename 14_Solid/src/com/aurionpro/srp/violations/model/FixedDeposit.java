package com.aurionpro.srp.violations.model;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principal;
	private int duration;
	private FestivalType festivalType;
	
	public FixedDeposit(int accountNumber, String name, double principal, int duration, FestivalType festivalType) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festivalType = festivalType;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public FestivalType getFestivalType() {
		return festivalType;
	}
	public void setFestivalType(FestivalType festivalType) {
		this.festivalType = festivalType;
	}
	
	private double getInterestRates() {
		switch(festivalType) {
		case NEWYEAR:
			return 8.0;
		case DIWALI:
			return 8.5;
		case HOLI:
			return 7.5;
		case OTHERS:
			default:
			return 6.5;
		}
	}
	
	public double calculateSimpleInterest() {
		double rate = getInterestRates();
		return (principal * duration * rate) /100;
	}
}
