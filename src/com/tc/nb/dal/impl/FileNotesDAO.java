package com.tc.nb.dal.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.tc.nb.dal.NotesDAO;
import com.tc.nb.entity.Note;

public class FileNotesDAO implements NotesDAO {

	private List<Note> notes = new ArrayList<Note>();

	public FileNotesDAO() {
		try {
			FileReader fr = new FileReader("/Users/a/my_notebook/src/resources/notes.txt");
			BufferedReader reader = new BufferedReader(fr);
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(";");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime dateTime = LocalDateTime.parse(parts[0], formatter);
				Note x = new Note(dateTime, parts[1], parts[2]);
				notes.add(x);
			}
			fr.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public List<Note> load() {
		return notes;
	}

	@Override
	public void save(Note note) {
		notes.add(note);
		File myFile = new File("/Users/a/my_notebook/src/resources/notes.txt");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));

			for (Note Note : notes) {
				writer.write(note.getDate() + ";" + note.getTitle() + ";" + note.getContent() + "\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		// save all list in file
	}

}
