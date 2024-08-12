package com.aurionpro.model;

public class Customer {
	private int CustomerID;
    private String FirstName;
    private String LastName;
    private String Email;
    private Account account;

    // Getters and setters
    
    
    public int getCustomerID() {
        return CustomerID;
    }

    public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    
    
}
