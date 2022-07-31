package com.capgemini.makereservationservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.capgemini.makereservationservice.service.EmailService;

@Component
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender mailSender;
	public void sendSimpleEmail(String toEmail, String subject, String body) {
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("guptavishu0508@gmail.com");
			message.setTo(toEmail);
			message.setText(body);
			message.setSubject(subject);
			
			mailSender.send(message);
			
			
			System.out.println("Mail Sent...");
		}

}
