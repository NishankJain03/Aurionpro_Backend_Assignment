package com.aurionpro.bankapp.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.dto.DocumentDto;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.Document;
import com.aurionpro.bankapp.entity.KycStatus;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	private CloudService cloudService;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);
	@Override
	public ResponseEntity<Map> uploadImage(int customerId, DocumentDto documentDto) {
		try {
            if (documentDto.getName().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            if (documentDto.getFile().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new RuntimeException("Customer not found"));

            Document document = new Document();
            document.setName(documentDto.getName());
            document.setUrl(cloudService.uploadFile(documentDto.getFile(), "folder_1"));

            if (document.getUrl() == null) {
                return ResponseEntity.badRequest().build();
            }
            document.setCustomer(customer);	
            document.setKycStatus(KycStatus.PENDING);
            logger.info("Document Uploaded Successfully");
            documentRepository.save(document);
            return ResponseEntity.ok().body(Map.of("url", document.getUrl()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	@Override
	public Document getDocumentById(int documentId) {
		return documentRepository.findById(documentId)
	            .orElseThrow(() -> new RuntimeException("Document not found"));
	}
	@Override
	public void updateDocumentStatus(int documentId, KycStatus status) {
		Document document = documentRepository.findById(documentId)
	            .orElseThrow(() -> new RuntimeException("Document not found"));
	        document.setKycStatus(status);
	        logger.info("Document Status update successfully");
	        documentRepository.save(document);
		
	}

}
