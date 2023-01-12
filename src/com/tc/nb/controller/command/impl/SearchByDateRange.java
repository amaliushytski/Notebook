package com.tc.nb.controller.command.impl;

import com.tc.nb.controller.NoteResponse;
import com.tc.nb.controller.command.Command;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.extension.DateTimeExtension;
import com.tc.nb.extension.NoteHelper;
import com.tc.nb.service.exception.ServiceException;
import com.tc.nb.service.impl.NotesFindServiceImpl;

public class SearchByDateRange implements Command {

	private final char paramDelimeter = ' ';

	private final char dateDelimeter = '|';

	@Override
	public NoteResponse execute(String request) throws ServiceException, DAOException {

		String dateFrom = request.substring(request.indexOf(paramDelimeter), request.indexOf(dateDelimeter));
		String dateTo = request.substring(request.indexOf(dateDelimeter) + 1);

		NotesFindServiceImpl service = new NotesFindServiceImpl();

		try {
			return new NoteResponse(200, NoteHelper.stringFormat(service
					.findByDateRange(DateTimeExtension.stringToLDT(dateFrom), DateTimeExtension.stringToLDT(dateTo))));
		} catch (ServiceException e) {
			return new NoteResponse(400, "Bad request");
		}

	}

}
