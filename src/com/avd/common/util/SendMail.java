package com.avd.common.util;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;


public class SendMail {

	// public static void sendEmail(String receipent , String loginId, String
	// pass , String firstName,String mailMessg) {

	public static void sendEmail(String receipent, String firstName,
			String mailMessg) {
		
			String host="mail.ilfstechnologies.com";
		  final String user="saroj.nayak@ilfstechnologies.com";//change accordingly
		  final String password="pass@123";//change accordingly
		  
		/*
		 * String text = " Dear " + firstName +
		 * "<BR> Please find below details for your login <BR> " +
		 * " Login Id : " + loginId + " <BR>" + " Password : " + pass + " <BR>"
		 * + " Thanks & Regards <BR> " + " CLR MP ";
		 */

		System.out.println(" ---- receipent --- " + receipent);

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					receipent));

			message.setSubject(" Welcome " + firstName);
			message.setText(mailMessg);

			message.setContent(mailMessg, "text/html; charset=utf-8");

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void sendEmailimg(String receipent, String subject,
			String htmlbody, Map<String, String> mapInlineImages) {

		String host = "mail.mohinimart.com";
		final String user = "mohinimart@mohinimart.com";// change
																	// accordingly
		final String password = "sapravdh";// change accordingly
		/*
		 * String text = " Dear " + firstName +
		 * "<BR> Please find below details for your login <BR> " +
		 * " Login Id : " + loginId + " <BR>" + " Password : " + pass + " <BR>"
		 * + " Thanks & Regards <BR> " + " CLR MP ";
		 */

		System.out.println(" ---- receipent --- " + receipent);

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable","true");
	/*	props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
*/
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					receipent));
			message.setSubject(subject);

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(htmlbody, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static void sendEmail(String host ,String mail,String pwd,String receipent, String firstName,
			String mailMessg) {
		
		
		  final String user=mail;
		  final String password=pwd;
		  
		/*
		 * String text = " Dear " + firstName +
		 * "<BR> Please find below details for your login <BR> " +
		 * " Login Id : " + loginId + " <BR>" + " Password : " + pass + " <BR>"
		 * + " Thanks & Regards <BR> " + " CLR MP ";
		 */

		System.out.println(" ---- receipent --- " + receipent);

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					receipent));

			message.setSubject(" Welcome " + firstName);
			message.setText(mailMessg);

			message.setContent(mailMessg, "text/html; charset=utf-8");

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}