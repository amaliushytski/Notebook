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
import com.tc.nb.dal.exception.NotesDataParseException;
import com.tc.nb.entity.Note;

public class FileNotesDAO implements NotesDAO {

	private List<Note> notes = new ArrayList<Note>();

	private static final String SOURCE_PATH = "/Users/a/my_notebook/src/resources/notes.txt";

	private static final int CREATION_DATE = 0;

	private static final int TITLE = 1;

	private static final int CONTENT = 2;

	private static final String EMPTY_STRING = "";

	public FileNotesDAO() throws Exception {
		BufferedReader reader = null;
		FileReader fr = null;
		try {
			fr = new FileReader(SOURCE_PATH);
			reader = new BufferedReader(fr);
			String newReadLine;

			while ((newReadLine = reader.readLine()) != null) {
				try {
					if (newReadLine != EMPTY_STRING) {
						String[] data = newReadLine.split(";");
						LocalDateTime dateTime = LocalDateTime.parse(data[CREATION_DATE]);
						Note x = new Note(dateTime, data[TITLE], data[CONTENT]);
						notes.add(x);
					}
				} catch (DateTimeParseException e) {
					throw new NotesDataParseException("Row can't be empty: " + e.getMessage());
				}
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			reader.close();
		}
	}

	@Override
	public List<Note> load() {
		return notes;
	}

	@Override
	public void save(Note note) {
		notes.add(note);
		File myFile = new File(SOURCE_PATH);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));

			writer.write(LocalDateTime.now() + ";" + note.getTitle() + ";" + note.getContent() + "\n");
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
