package com.gs.localmail.params;

import com.beust.jcommander.Parameter;

public class AbstractAppParams {

	@Parameter(names = { "-h", "--help" }, help = true)
	private boolean help;

	public AbstractAppParams() {
		super();
	}

}