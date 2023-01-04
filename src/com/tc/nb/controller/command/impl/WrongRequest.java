package com.tc.nb.controller.command.impl;

import com.tc.nb.controller.NoteResponse;
import com.tc.nb.controller.command.Command;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.service.exception.ServiceException;

public class WrongRequest implements Command {

	@Override
	public NoteResponse execute(String request) throws ServiceException, DAOException {

		return new NoteResponse(400, "Bad request");
	}

}
