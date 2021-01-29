package com.ibm.learning.emailer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

//This object gets created  by using  @Componet and refered  as beans

public class SmtpEmailSender implements iEmailerService {

	private static Log log=LogFactory.getLog(SmtpEmailSender.class);
	private JavaMailSender javaMailSender;
	
	public SmtpEmailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
		
	}
	@Override
	public void sendEmail(String emailID, String subject, String mailContent) throws MessagingException {
		log.info("SMTP mail receiver id:"+emailID);
		log.info("SMTP mail subject:"+subject);
		log.info("SMTP mail body:"+mailContent);
		log.warn("This is just a SMTP email sender");
		
	
		
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(message, true); // true indicates
 					  				                   // multipart message
		helper.setSubject("Hiiii");
		helper.setTo("bholenik12@gmail.com");
		helper.setText("<h1> Zala re Nacho  </h1>", true); // true indicates html

		// continue using helper for more functionalities
        // like adding attachments, etc.
		javaMailSender.send(message);
		
	}

}
