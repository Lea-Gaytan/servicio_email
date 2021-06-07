/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mailFuntions;
import java.util.Properties;
import io.micronaut.context.annotation.Value;
import io.micronaut.context.annotation.Property;
import javax.inject.Singleton;
import javax.mail.*;

//@Singleton
public class emailFuntions {

	@Value("${mail.smtp.host}")
    private String host;

	public void SendMailSmtpAuthentication(String Plantilla){

		final String fromEmail = "lea.gaytan.arlanzon@gmail.com";
		final String password = "lea.gaytan.12";
		final String toEmail = "tackett01@gmail.com";
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		//props.put("mail.smtp.host", host);
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail,"TLSEmail Testing Subject", Plantilla);
		
	}
}
