package com.icegreen.greenmail.smtp;

import com.gs.localmail.EmailLogger;
import com.icegreen.greenmail.imap.ImapHostManager;
import com.icegreen.greenmail.user.UserManager;

public class SmtpManagerEx extends SmtpManager {	
	private final EmailLogger emailLogger = new EmailLogger();
	
	public SmtpManagerEx(ImapHostManager imapHostManager, UserManager userManager) {
		super(imapHostManager, userManager);
	}

	@Override
	public synchronized void send(SmtpState state) {
		emailLogger.log(state.getMessage().getMessage());
		super.send(state);
	}
}
