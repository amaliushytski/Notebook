package com.tc.nb.service.impl;

import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesCreateService;
import com.tc.nb.service.exception.ServiceException;

public class NotesCreateServiceImpl implements NotesCreateService {

	@Override
	public void add(Note n) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		NotesDataValidationImpl toValidate = new NotesDataValidationImpl();

		// Validation of Date, Title, Content
		if (toValidate.isDateEmpty(n.getDate()) & toValidate.isDateValid(n.getDate())
				& toValidate.isTitleValid(n.getTitle()) & toValidate.isContentValid(n.getContent())) {

			try {
				notesDAO.save(n);
			} catch (DAOException e) {
				throw new ServiceException("Note is not saved", e);
			}
		}
	}
}