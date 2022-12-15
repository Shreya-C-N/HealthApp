package com.valtech.health.app.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class SendEMailImpl implements SendEMail {


    /* (non-Javadoc)
     * @see com.valtech.health.app.service.SendMail#sendMail(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
	@RequestMapping("de")
    public void sendMail(String email, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        // smtp.gmail.com supports TLSv1.2 and TLSv1.3
        // smtp.office365.com supports only TLSv1.2
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
 

       Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
//                System.out.println("ID: "+appProperties.getId());
//                System.out.println("Password: "+appProperties.getPassword());
                return new PasswordAuthentication("healthapp@outlook.com", "Qwertyuiop12#");
            }
        });

    }
}
