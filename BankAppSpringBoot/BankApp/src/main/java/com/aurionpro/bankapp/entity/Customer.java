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
@Data
public class Customer {
	
	@Column(name = "customerId")
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int customerId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "customer", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	List<Accounts> accounts;
	
	
}
