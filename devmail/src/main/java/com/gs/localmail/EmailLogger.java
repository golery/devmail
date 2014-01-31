package com.gs.localmail;

import java.io.IOException;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailLogger {
	public void log(MimeMessage message) {
		try {
			doLog(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doLog(MimeMessage message) throws MessagingException, IOException {
		log("===========================================");
		logHeader(true, "FROM:", message.getFrom());
		logHeader(true, "TO:  ", message.getRecipients(RecipientType.TO));
		logHeader(false, "CC:  ", message.getRecipients(RecipientType.CC));
		logHeader(false, "BCC: ", message.getRecipients(RecipientType.BCC));
		logHeader(true, "SUBJECT: ", message.getSubject());
		log("CONTENT:");
		logBody(message.getContent());
	}

	private void logBody(Object body) throws IOException, MessagingException {
		if (body instanceof MimeMultipart) {
			MimeMultipart parts = (MimeMultipart) body;			
			for (int i = 0; i<parts.getCount(); i++) {
				logBody(parts.getBodyPart(i));
			}
		} else if (body instanceof MimeBodyPart) {
			MimeBodyPart bodyPart = (MimeBodyPart) body;
			logBody("[[PART:"+bodyPart.getContentType()+"]]");
			logBody(bodyPart.getContent());
		} else {			
			log(body.toString().trim());
		}
	}

	private void logHeader(boolean required, String name, Object value) throws MessagingException {
		if (required && value == null) {
			value = "<empty>";
		}
		if (value == null)
			return;

		String text = formatValue(value);
		log(name + text);
	}

	private String formatValue(Object value) {
		StringBuffer s = new StringBuffer();
		if (value instanceof InternetAddress[]) {
			InternetAddress[] arr = (InternetAddress[]) value;
			for (InternetAddress address : arr) {
				if (s.length() > 0)
					s.append(',');
				s.append(address.toString());
			}
		}
		return s.toString();
	}

	private void log(String s) {
		System.out.println(s);
	}
}
