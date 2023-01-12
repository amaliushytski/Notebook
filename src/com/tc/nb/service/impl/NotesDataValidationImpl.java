package com.tc.nb.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.tc.nb.service.NotesDataValidation;
import com.tc.nb.service.exception.ServiceException;

public class NotesDataValidationImpl implements NotesDataValidation {

	@Override
	public boolean isDateValid(LocalDateTime date) throws ServiceException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

		try {
			date = formatter.parse(date.toString(), LocalDateTime::from);
			return true;
		} catch (DateTimeParseException e) {
			throw new ServiceException("Entered date and time have wrong fromat", e);
		}
	}

	@Override
	public boolean isDateEmpty(LocalDateTime date) throws ServiceException {
		if (date != null) {
			return true;
		}
		throw new ServiceException("Please set date and time");
	}

	@Override
	public boolean isTitleValid(String title) throws ServiceException {
		if (title != null & title != " " & title != "") {
			return true;
		}
		throw new ServiceException("Title is not present");
	}

	@Override
	public boolean isContentValid(String content) throws ServiceException {
		if (content != null & content != " " & content != "") {
			return true;
		}
		throw new ServiceException("Content is not present");
	}
}
