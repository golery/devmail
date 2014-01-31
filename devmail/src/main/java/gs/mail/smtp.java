package gs.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.beust.jcommander.JCommander;
import com.gs.localmail.params.SmtpAppParams;

/**
 * A simple smtp send for testing
 */
public class smtp {
	static SmtpAppParams params = SmtpAppParams.getInstance();
	public static void main(String[] args) throws InterruptedException {
		new JCommander(params, args);
		
		doSendMail();
	}
	
	static void doSendMail() {
		 // Recipient's email ID needs to be mentioned.
	      String to = params.to;

	      // Sender's email ID needs to be mentioned
	      String from = params.from;

	      // Assuming you are sending email from localhost
	      String host = params.host;
	      
	      String port = ""+params.port;

	      // Get system properties
	      Properties properties = System.getProperties();
	      
	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.port", port);
	      
	      properties.setProperty("mail.user", params.username);
	      properties.setProperty("mail.password", params.password);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject(params.subject);

	         // Now set the actual message
	         message.setText(params.body);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
}
