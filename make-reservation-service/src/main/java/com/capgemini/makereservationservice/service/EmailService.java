package com.capgemini.makereservationservice.service;

import org.springframework.stereotype.Service;


@Service
public interface EmailService {
	public void sendSimpleEmail(String toEmail , String subject , String body);
}
