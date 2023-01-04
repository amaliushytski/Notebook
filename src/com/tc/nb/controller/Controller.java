package com.tc.nb.controller;

import com.tc.nb.controller.command.Command;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.service.exception.ServiceException;

public final class Controller {

	private final CommandProvider provider = new CommandProvider();
	private final char paramDelimeter = ' ';

	public NoteResponse executeTask(String request) throws DAOException, ServiceException {
		String commandName;
		Command executionCommand;
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = provider.getCommand(commandName);

		return executionCommand.execute(request);
	}
}
