package com.aurionpro.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

import com.aurionpro.bankapp.dto.DocumentDto;
import com.aurionpro.bankapp.entity.Document;
import com.aurionpro.bankapp.entity.KycStatus;
import com.aurionpro.bankapp.service.DocumentService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/bankapplication")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@PostMapping("/upload/document")
	public ResponseEntity<Map> upload(@RequestParam int customerId, DocumentDto documentDto){
		try {
			return documentService.uploadImage(customerId, documentDto);
		}catch(Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/getDocument")
	public ResponseEntity<Document> getDocumentById(@RequestParam int documentId){
		return ResponseEntity.ok(documentService.getDocumentById(documentId));
	}
	
	@PutMapping("/documentStatus")
	public ResponseEntity<Map<String, String>> updateDocumentStatus(@RequestParam int documentId, @RequestParam KycStatus status){
		documentService.updateDocumentStatus(documentId, status);
		return ResponseEntity.ok(Map.of("message", "Document status updated successfully"));
	}
}
