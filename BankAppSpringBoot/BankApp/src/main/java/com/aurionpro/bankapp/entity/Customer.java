package com.aurionpro.bankapp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Column(name = "customerId")
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int customerId;
	
	@Column(name = "firstName")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabetic characters are allowed")
	@NotNull(message = "FirstName cannot be null")
	@NotBlank(message = "FirstName cannot be blank")
    private String firstName;

    @Column(name = "lastName")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabetic characters are allowed")
	@NotNull(message = "Lastname cannot be null")
	@NotBlank(message = "lastname cannot be blank")
    private String lastName;

    @Column(name = "email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid email address")
	@NotNull(message = "Email cannot be null")
	@NotBlank(message = "Eamil cannot be blank")
    private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "customer", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	private List<Account> accounts;
	
	@JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    private List<Document> documents;
	
	
}
