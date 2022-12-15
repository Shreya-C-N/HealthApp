package com.valtech.health.app.service;

import org.springframework.web.bind.annotation.RequestMapping;

public interface SendEMail {

	/* (non-Javadoc)
	 * @see com.valtech.health.app.service.SendMail#sendMail(java.lang.String, java.lang.String, java.lang.String)
	 */
	void sendMail(String email, String subject, String body);

}