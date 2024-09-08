package com.aurionpro.bankapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.aurionpro.bankapp.dto.DocumentDto;
import com.aurionpro.bankapp.entity.Document;
import com.aurionpro.bankapp.entity.KycStatus;

import java.util.Map;
public interface DocumentService {
	
//	@PreAuthorize("hasRole('CUSTOMER')")
	ResponseEntity<Map> uploadImage(int customerId, DocumentDto documentDto);
	
	@PreAuthorize("hasRole('ADMIN')")
	Document getDocumentById(int documentId);
	
	@PreAuthorize("hasRole('ADMIN')")
	void updateDocumentStatus(int documentId, KycStatus status);
	
	
}
