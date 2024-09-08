package com.aurionpro.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankapp.entity.EmailDetails;
import com.aurionpro.bankapp.service.EmailService;

@RestController
@RequestMapping("/bankapplication")
public class EmailController {
	@Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDetails details) {
        String status = emailService.sendMail(details);
        return ResponseEntity.ok(status);
    }

    @PostMapping("/sendWithAttachment")
    public ResponseEntity<String> sendEmailWithAttachment(@RequestBody EmailDetails details) {
        String status = emailService.sendMailWithAttachment(details);
        return ResponseEntity.ok(status);
    }
}
