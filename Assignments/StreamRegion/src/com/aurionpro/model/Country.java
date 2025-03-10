package com.aurionpro.model;

public class Country {
	private String countryCode;
	private String countryName;
	private Region regionId;
	public Country(String countryCode, String countryName, Region region) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.regionId = region;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Region getRegion() {
		return regionId;
	}
	public void setRegion(Region region) {
		this.regionId = region;
	}
	
	
}
