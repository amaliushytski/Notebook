package com.tc.nb.controller.command.impl;

import com.tc.nb.controller.NoteResponse;
import com.tc.nb.controller.command.Command;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.extension.DateTimeExtension;
import com.tc.nb.extension.NoteHelper;
import com.tc.nb.service.exception.ServiceException;
import com.tc.nb.service.impl.NotesFindServiceImpl;

public class SearchByDate implements Command {

	private final char paramDelimeter = ' ';

	@Override
	public NoteResponse execute(String request) throws ServiceException, DAOException {

		String date = request.substring(request.indexOf(paramDelimeter));

		NotesFindServiceImpl service = new NotesFindServiceImpl();

		try {
			return new NoteResponse(200, NoteHelper.stringFormat(service.findByDate(DateTimeExtension.stringToLDT(date))));

		} catch (ServiceException e) {
			return new NoteResponse(400, "Bad request");
		}

	}

}
