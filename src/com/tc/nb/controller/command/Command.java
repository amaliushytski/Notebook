package com.tc.nb.controller.command;

import com.tc.nb.controller.NoteResponse;
import com.tc.nb.dal.exception.DAOException;

import com.tc.nb.service.exception.ServiceException;

public interface Command {

	public NoteResponse execute(String request) throws DAOException, ServiceException;

}