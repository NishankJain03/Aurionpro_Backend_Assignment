package com.aurionpro.bankapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "documents")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Document {
	@Column(name = "documentId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documentId;
	
	@Column(name = "name_image")
    private String name;

    @Column(name = "url")
    private String url;
    
    @Column(name = "kycStatus")
    private KycStatus kycStatus;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customerId")
    private Customer customer;
    
    
}
