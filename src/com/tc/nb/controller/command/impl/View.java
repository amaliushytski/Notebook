package com.tc.nb.controller.command.impl;

import com.tc.nb.controller.NoteResponse;
import com.tc.nb.controller.command.Command;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.service.exception.ServiceException;

public class View implements Command {

	private final char paramDelimeter = ' ';

	@Override
	public NoteResponse execute(String request) throws DAOException, ServiceException {

		String response = request.substring(request.indexOf(paramDelimeter) + 1);

		if (response == "") {
			System.out.println("No data");
		} else {

			System.out.println(response);
			System.out.println("-------------");

		}

		return new NoteResponse(200);
	}

}
