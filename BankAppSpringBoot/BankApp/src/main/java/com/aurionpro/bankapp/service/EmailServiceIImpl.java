package com.aurionpro.bankapp.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.entity.EmailDetails;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceIImpl implements EmailService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendMailWithAttachment(EmailDetails details) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try {

	        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	        mimeMessageHelper.setFrom(sender);
	        mimeMessageHelper.setTo(details.getRecipient());
	        mimeMessageHelper.setText(details.getMsgBody());
	        mimeMessageHelper.setSubject(details.getSubject());
	        FileSystemResource file  = new FileSystemResource( new File(details.getAttachment()));

	        mimeMessageHelper.addAttachment(file.getFilename(), file);

	        javaMailSender.send(mimeMessage);
	        return "Mail sent Successfully";
	    }
	    catch (MessagingException e) {
	        return "Error while sending mail!!!";
	    }
	}

	@Override
	public String sendMail(EmailDetails details) {
		try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(details.getSubject());
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        } catch (MessagingException e) {
            return "Error while sending mail!!!";
        }
	}

}
