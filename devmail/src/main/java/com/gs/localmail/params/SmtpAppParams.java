package com.gs.localmail.params;

import com.beust.jcommander.Parameter;

public class SmtpAppParams extends AbstractAppParams {
	public static final SmtpAppParams INSTANCE = new SmtpAppParams();
	
	public static SmtpAppParams getInstance() {
		return INSTANCE;
	}
	
	@Parameter(names = { "-p", "--port" }, description = "SMTP port (default: 25)")
	public int port = 25;
	
	@Parameter(names = { "-host", "--host" }, description = "Host (default: localhost)")
	public String host = "localhost";
	
	@Parameter(names = { "-s", "--subject" }, description = "Subject (default: Greeting)")
	public String subject = "Greeting";
	
	@Parameter(names = { "-t", "--to" }, description = "To (default: test@localhost)")
	public String to= "test@localhost";
	
	@Parameter(names = { "-f", "--from" }, description = "To (default: from@localhost)")
	public String from= "from@localhost";
	
	@Parameter(names = { "-b", "--body" }, description = "Subject (default: Body)")
	public String body = "You have a new email from DevMail";
	
	@Parameter(names = { "-u", "--username" }, description = "Username (default: test@localhost)")
	public String username = "test@localhost";
	
	@Parameter(names = { "-pwd", "--password" }, description = "Password (default: password")
	public String password= "password";
}
