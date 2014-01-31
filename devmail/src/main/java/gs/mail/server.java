package gs.mail;

import java.util.Map;

import com.beust.jcommander.JCommander;
import com.gs.localmail.params.ServerAppParams;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailEx;
import com.icegreen.greenmail.util.ServerSetup;

/**
 * Local SMTP and POP3 and IMAP server: standalone and ready to be used !!!
 * Based on GreenMail libray http://www.icegreen.com/greenmail/
 */
public class server {
	public static void main(String[] args) throws InterruptedException {
		ServerAppParams params = ServerAppParams.getInstance();
		new JCommander(params, args);

		Map<String, ServerSetup> configs = GreenMailEx.getConfigs(params.portOffset);

		System.out.println(String.format("Starting local mail services (SMTP, POP3, IMAP) at ports (%s,%s,%s)...", configs.get(ServerSetup.PROTOCOL_SMTP).getPort(), configs.get(ServerSetup.PROTOCOL_POP3).getPort(), configs.get(ServerSetup.PROTOCOL_IMAP).getPort()));
		System.out.println("Create demo account test@localhost/password");

		GreenMail greenMail = new GreenMailEx(configs); // uses test ports by
														// default
		greenMail.setUser("test@localhost", "password");
		greenMail.start();
		
		System.out.println("Waiting for mail ...");
		
		Thread.sleep(9999999);
		System.out.println("Exit");
	}
}
