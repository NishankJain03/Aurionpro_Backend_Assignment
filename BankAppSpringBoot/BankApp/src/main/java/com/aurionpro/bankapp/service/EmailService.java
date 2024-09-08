package com.aurionpro.bankapp.service;

import com.aurionpro.bankapp.entity.EmailDetails;

public interface EmailService {
	String sendMail(EmailDetails details);
	String sendMailWithAttachment(EmailDetails details);
}
