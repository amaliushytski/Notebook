package com.tc.nb.controller.command.impl;

import java.time.LocalDateTime;

import com.tc.nb.controller.NoteResponse;
import com.tc.nb.controller.command.Command;
import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.entity.Note;

public class Save implements Command {

	private final char paramDelimeter = ' ';

	private static final int TITLE = 0;

	private static final int CONTENT = 1;

	@Override
	public NoteResponse execute(String request) throws DAOException {
		// "SAVE New text;Test content added in main file"

		String dataRaw = request.substring(request.indexOf(paramDelimeter));

		String[] data = dataRaw.split(";");
		LocalDateTime dateTime = LocalDateTime.now();
		Note note = new Note(dateTime, data[TITLE], data[CONTENT]);

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		try {
			notesDAO.save(note);
			return new NoteResponse(200, "Successfylly");

		} catch (DAOException e) {
			return new NoteResponse(400, "Error: Bad request");

		}

	}

}
