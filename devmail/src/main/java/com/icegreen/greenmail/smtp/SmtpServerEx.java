/*
 * Copyright (c) 2006 Wael Chatila / Icegreen Technologies. All Rights Reserved.
 * This software is released under the LGPL which is available at http://www.gnu.org/copyleft/lesser.html
 * This file has been used and modified. Original file can be found on http://foedus.sourceforge.net
 */
package com.icegreen.greenmail.smtp;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import com.icegreen.greenmail.Managers;
import com.icegreen.greenmail.foedus.util.InMemoryWorkspace;
import com.icegreen.greenmail.smtp.commands.SmtpCommandRegistry;
import com.icegreen.greenmail.util.ServerSetup;

public class SmtpServerEx extends SmtpServer {

	private SmtpManagerEx smtpManagerEx;

	public SmtpServerEx(ServerSetup setup, Managers managers) {
		super(setup, managers);
	}

	@Override
	public void run() {
		try {
			try {
				serverSocket = openServerSocket();
				setRunning(true);
				synchronized (this) {
					this.notifyAll();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			while (keepOn()) {
				try {
					Socket clientSocket = serverSocket.accept();
					SmtpHandler smtpHandler = new SmtpHandler(new SmtpCommandRegistry(), getSmtpManager(managers), new InMemoryWorkspace(), clientSocket);
					handlers.add(smtpHandler);
					smtpHandler.start();
				} catch (SocketException ignored) {
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}
		} finally {
			quit();
		}
	}

	private SmtpManager getSmtpManager(Managers managers) {
		if (smtpManagerEx == null) {
			smtpManagerEx = new SmtpManagerEx(managers.getImapHostManager(), managers.getUserManager());
		}
		return smtpManagerEx;
	}
}