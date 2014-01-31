package com.icegreen.greenmail.util;

import java.util.HashMap;
import java.util.Map;

import com.icegreen.greenmail.smtp.SmtpServerEx;

/**
 * @author Wael Chatila
 * @version $Id: $
 * @since Jan 28, 2006
 */
public class GreenMailEx extends GreenMail {
    /**
     * Creates a SMTP, SMTPS, POP3, POP3S, IMAP, and IMAPS server binding onto non-default ports.
     * The ports numbers are defined in {@link ServerSetupTest}
     */
    public GreenMailEx(Map<String, ServerSetup> configs) {
        super(configs.values().toArray(new ServerSetup[0]));                
        services.put(ServerSetup.PROTOCOL_SMTP, new SmtpServerEx(configs.get(ServerSetup.PROTOCOL_SMTP), managers));
    }
    
    public static Map<String, ServerSetup> getConfigs(int portOffset) {
    	Map<String, ServerSetup> map = new HashMap<String, ServerSetup>();    	
        ServerSetup SMTP = new ServerSetup(25+portOffset, null, ServerSetup.PROTOCOL_SMTP);
        ServerSetup POP3 = new ServerSetup(110+portOffset, null, ServerSetup.PROTOCOL_POP3);
        ServerSetup IMAP = new ServerSetup(143+portOffset, null, ServerSetup.PROTOCOL_IMAP);
        ServerSetup[] all = {SMTP, POP3, IMAP};
        for (ServerSetup config : all) {
        	map.put(config.getProtocol(), config);
        }
		return map;
    }
}
