package com.gs.localmail.params;

import com.beust.jcommander.Parameter;

public class ServerAppParams extends AbstractAppParams {
	public static final ServerAppParams INSTANCE = new ServerAppParams();
	
	public static ServerAppParams getInstance() {
		return INSTANCE;
	}
	
	@Parameter(names = { "-p", "--portoffset" }, description = "Port offset (ex: -p 8000 makes application listens to 8025 for SMTP).")
	public int portOffset = 8000;
}
