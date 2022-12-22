package com.tc.nb.dal.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.tc.nb.dal.NotesDAO;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.entity.Note;

public class FileNotesDAO implements NotesDAO {

	private List<Note> notes = new ArrayList<Note>();

	private static final String SOURCE_PATH = "./src/resources/notes.txt";

	private static final int CREATION_DATE = 0;

	private static final int TITLE = 1;

	private static final int CONTENT = 2;

	private static final String EMPTY_STRING = "";

	public FileNotesDAO() throws DAOException {
		BufferedReader reader = null;
		FileReader fr = null;
		try {
			fr = new FileReader(SOURCE_PATH);
			reader = new BufferedReader(fr);
			String newReadLine;

			while ((newReadLine = reader.readLine()) != null) {

				if (newReadLine != EMPTY_STRING) {
					String[] data = newReadLine.split(";");
					LocalDateTime dateTime = LocalDateTime.parse(data[CREATION_DATE]);
					Note note = new Note(dateTime, data[TITLE], data[CONTENT]);
					notes.add(note);

				}

			}
		} catch (DateTimeParseException e) {
			throw new DAOException("Row can't be empty: ", e);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Note> load() throws DAOException {
		return notes;
	}

	@Override
	public void save(Note note) throws DAOException {
		notes.add(note);
		File myFile = new File(SOURCE_PATH);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(myFile, true));
			writer.append(LocalDateTime.now().toString());
			writer.append(";");
			writer.append(note.getTitle());
			writer.append(";");
			writer.append(note.getContent());
			writer.append("\n");
			writer.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
