package com.valtech.health.app;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.valtech.health.app.service.EmailSenderService;

@SpringBootApplication
public class HealthAppApplication {
	
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(HealthAppApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		senderService.sendSimpleEmail("itsajayrawal2000@gmail.com", "Emergency Come Online", "Hello Doctor, the patient is ready please come online");
	}
}
