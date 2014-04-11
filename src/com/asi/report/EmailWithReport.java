package com.asi.report;

import java.io.FileInputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailWithReport {

	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	public static final String SMTP_PORT = "465";
	public static final String emailMsgTxt = "Test Message Contents";
	public static final String emailSubjectTxt = "HRMS Automation Log File";
	public static final String emailFromAddress = "raghavkolhatkar@gmail.com";
	public static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	public static final String[] sendTo = { "raghavkolhatkar@gmail.com" };
	public static String emailUserName = null;
	public static String emailPassword = null;
	
	
	public void sendSSLMessage(String recipients[], String subject,
			String message, String from, String file) throws MessagingException {
		boolean debug = true;

		String file_name = file;

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");

		
		Properties properties = new Properties();
		try {
	        properties.load(new FileInputStream("../AutomationProject/config/email.properties"));	    	
	        emailUserName=properties.getProperty("username_auth_email");
	        emailPassword=properties.getProperty("password_auth_email");
	    } catch (Exception e) {
	      System.out.println("Gotch");
	    }
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								emailUserName, emailPassword);
					}
				});

		session.setDebug(debug);

		Message msg = new MimeMessage(session);
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		MimeBodyPart body = new MimeBodyPart();
	//	body.setText("Please Find the attached file for Automation logs");
		body.setText(message);
		
		// do attachment
		MimeBodyPart attachMent = new MimeBodyPart();

		FileDataSource dataSource = new FileDataSource(file_name);
		attachMent.setDataHandler(new DataHandler(dataSource));
		attachMent.setFileName("../AutomationProject/reports/HRMS_TestResult_Report.xls");
		attachMent.setDisposition(MimeBodyPart.ATTACHMENT);
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(body);
		multipart.addBodyPart(attachMent);
		msg.setContent(multipart);

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		// msg.setContent(message, "text/plain");
		Transport.send(msg);
	}
	
	/*
	public static void main(String args[]) throws MessagingException
	{
		
		EmailWithReport eamilRpt = new EmailWithReport();
		String mailBody =" HRMS Automation !! " ;
	
		
		String[] sendToIDs = null;
		 Properties properties = new Properties();
		  
			String[] send_To = new String[1];
			String emailSubjectTxt = null;
			String emailFromAddress = null;
			String reportFilePath = null;
		    try {
		        properties.load(new FileInputStream("../AutomationProject/config/email.properties"));	    	
		    	String sendTo =properties.getProperty("send_to");
		    	//String[] send_To = new String[1];
		    	send_To[0]=sendTo;
		    	emailSubjectTxt =properties.getProperty("email_subject_txt");
		    	emailFromAddress =properties.getProperty("email_from_address");
		    	reportFilePath = properties.getProperty("csv_file_path");
		    } catch (Exception e) {
		      System.out.println("Gotch");
		    }
	    
	  
		System.out.println (" Send To" + send_To [0]);
	    System.out.println (" emailSubjectTxt " + emailSubjectTxt);
	    System.out.println (" mailBody " + mailBody );
	    System.out.println (" emailFromAddress " + emailFromAddress);
	    System.out.println (" reportFilePath " + reportFilePath);
	    
	    
	    
		eamilRpt.sendSSLMessage(send_To, emailSubjectTxt, mailBody, emailFromAddress, reportFilePath);
	    
	}*/
}
