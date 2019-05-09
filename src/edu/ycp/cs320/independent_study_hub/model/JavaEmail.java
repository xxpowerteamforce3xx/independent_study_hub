package edu.ycp.cs320.independent_study_hub.model;

import java.io.File;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;

public class JavaEmail {

	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;

	public static void run(String recip, Boolean found, String name, String temp_pass) throws AddressException,
			MessagingException {

		JavaEmail javaEmail = new JavaEmail();

		javaEmail.setMailServerProperties();
		javaEmail.createEmailMessage(recip, found, name, temp_pass);
		javaEmail.sendEmail();
	}

	public void setMailServerProperties() {

		String emailPort = "587";//gmail's smtp port

		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");

	}

	public void createEmailMessage(String recip, Boolean found, String name, String temp_pass) throws AddressException,
			MessagingException {
		String[] toEmails = { recip };
		String emailSubject = "Password Reset - IndependentStudyHub";
		String emailBody = null;
		if (found) {
			emailBody =	"<html>" +
						  "<head>" +
						    "<style>" +
						      ".colored {" +
						        "color: white;" +
						        "background:forestgreen;" +
						      "}" +
						      ".red {" +
						      "color: red;" +
						      "}"+ 
						      "#p {" +
						      "background:#A3DEDA;" +
						      "font-size: 14px;" +
						      "}" +
						      "#body {" +
						        "font-size: 14px;" +
						      "}" +
						    "</style>" +
						  "</head>" +
						  "<body>" +
						    "<div id='body'>" +
						      "<h1 class='colored'>Independent Study Hub - YCP - 2019</h1>" +
						      "<p> <br>Hello, <b>"+ name + "</b></p>"+
						      "<p> We've recieved a request to reset the password to the account tied to this email. Below is </p>" +
						      "<p> A temporary password. Please use it to login to your account and update your information  </p>" +
						      "<p> under MyAccount.</p>" +
						      "<p class='red'><br>TEMPORARY PASSOWRD: <b>"  + temp_pass +"</b></p>" +
						      "<p><br>Thank you, </p>" +
						      "<p>-The IndependentStudyHubTeam</p>" +
						    "</div>" +
						  "</body>" +
						 "</html>";
		
		} else {
			emailBody = "<html>" +
					  "<head>" +
					    "<style>" +
					      ".colored {" +
					        "color: white;" +
					        "background:forestgreen;" +
					      "}" +
					      ".red {" +
					      "color: red;" +
					      "}"+ 
					      "#p {" +
					      "background:#A3DEDA;" +
					      "font-size: 14px;" +
					      "}" +
					      "#body {" +
					        "font-size: 14px;" +
					      "}" +
					    "</style>" +
					  "</head>" +
					  "<body>" +
					    "<div id='body'>" +
					      "<h1 class='colored'>Independent Study Hub - YCP - 2019</h1>" +
					      "<p> <br>Hello, <b>"+ name + "</b></p>"+
					      "<p> We've recieved a request to reset the password to the account tied to this email, but this email is not in our database! </p>" +
					      "<p> This is a common technique to try and get information from the server about whether or not a certain email is tied to an account. </p>" +
					      "<p> If you do have an account with the Independent Study Hub, the email you gave to our email client is not tied to an account.</p>" +
					      "<p> Please contact an administrator and they can see the email you used to sign up. If that email is incorrect, they can fix it for you. </p>" +
					      "<p><br><br> If you do not have an account with us, please be on the look out for fraudulent activity, and have a nice day!</p>" +
					      "<p><br>Thank you, </p>" +
					      "<p>-The IndependentStudyHubTeam</p>" +
					    "</div>" +
					  "</body>" +
					 "</html>";
		}
		
		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);
		
		for (int i = 0; i < toEmails.length; i++) {		// this bit lets us scale it to more people, if wanted
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html; charset=utf-8");//for a html email
		//emailMessage.setText(emailBody);// for a text email

	}

	public void sendEmail() throws AddressException, MessagingException {

		String emailHost = "smtp.gmail.com";
		String fromUser = "independentstudyhub";//just the id alone without @gmail.com
		String fromUserEmailPassword = "6QXrXJWJJNYD9LX";

		Transport transport = mailSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}

}