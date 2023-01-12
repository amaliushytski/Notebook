package com.tc.nb.service;

import java.time.LocalDateTime;

import com.tc.nb.service.exception.ServiceException;

public interface NotesDataValidation {

	boolean isDateValid(LocalDateTime date) throws ServiceException;

	boolean isDateEmpty(LocalDateTime date) throws ServiceException;

	boolean isTitleValid(String title) throws ServiceException;

	boolean isContentValid(String title) throws ServiceException;
}
