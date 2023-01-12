package com.tc.nb.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesFindService;
import com.tc.nb.service.exception.ServiceException;

public class NotesFindServiceImpl implements NotesFindService {

	@Override
	public List<Note> findByTitle(String title) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		List<Note> sourceList;
		try {
			sourceList = notesDAO.load();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		List<Note> foundData = new ArrayList<>();

		// Validation that Title is present and it is not just space
		NotesDataValidationImpl toValidate = new NotesDataValidationImpl();
		if (toValidate.isTitleValid(title)) {
			for (Note Note : sourceList) {
				if (Note.getTitle().contains(title)) {
					foundData.add(Note);
				}
			}
		}
		return foundData;
	}

	@Override
	public List<Note> findByContent(String content) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		List<Note> sourceList;
		try {
			sourceList = notesDAO.load();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		List<Note> foundData = new ArrayList<>();

		// Validation that Content is present and it is not just space
		NotesDataValidationImpl toValidate = new NotesDataValidationImpl();
		if (toValidate.isContentValid(content)) {
			for (Note Note : sourceList) {
				if (Note.getContent().contains(content)) {
					foundData.add(Note);
				}
			}
		}

		return foundData;
	}

	@Override
	public List<Note> findByDate(LocalDateTime date) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		List<Note> sourceList;
		try {
			sourceList = notesDAO.load();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		List<Note> foundData = new ArrayList<>();

		// Validation that date is present and valid by format
		NotesDataValidationImpl toValidate = new NotesDataValidationImpl();
		if (toValidate.isDateEmpty(date) & toValidate.isDateValid(date)) {
			for (Note Note : sourceList) {

				if (Note.getDate().equals(date)) {
					foundData.add(Note);
				}
			}
		}

		return foundData;
	}

	@Override
	public List<Note> findByDateRange(LocalDateTime dateFrom, LocalDateTime dateTo) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		List<Note> sourceList;
		try {
			sourceList = notesDAO.load();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		NotesDataValidationImpl toValidate = new NotesDataValidationImpl();

		List<Note> foundData = new ArrayList<>();

		// Validation that dates are present and valid by format
		if (toValidate.isDateEmpty(dateFrom) & toValidate.isDateEmpty(dateTo) & toValidate.isDateValid(dateFrom)
				& toValidate.isDateValid(dateTo)) {

			// Set dates range
			for (Note note : sourceList) {
				if (note.getDate().isAfter(dateFrom) & note.getDate().isBefore(dateTo)) {
					foundData.add(note);
				}
			}
		}

		return foundData;
	}

}
