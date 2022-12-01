package com.eperium.main;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;

public final class Mailtrying
{	
	public static void main(String[] args) throws IOException 
	{
	final String username = "jenkinbunzl.testoutput";
	final String password = "ebsi@213";

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,
	new javax.mail.Authenticator() 
	{
		protected PasswordAuthentication getPasswordAuthentication() 
		{
			return new PasswordAuthentication(username, password);
		}
	  });

	try 
	{
		System.out.println("Done");
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("jenkinbunzl.testoutput"));
		String[] mailTo={/*"sprakash@salmon.com","mkumari@salmon.com","jysingh@salmon.com","dahlawat@salmon.com"*/};
		for (int i=0;i<mailTo.length;i++)
		{
			/*	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo[i]));*/
			message.addRecipients(RecipientType.TO, InternetAddress.parse(mailTo[i]));
		}
		message.setSubject("Automation Test Suite Report");
		String msg=FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/OverviewReport/Overview.html"));
		message.setContent(msg,"text/html");
		Transport.send(message);

		System.out.println("Done");

	} 
	catch (MessagingException e) 
	{
		throw new RuntimeException(e);
	}
	}
}

