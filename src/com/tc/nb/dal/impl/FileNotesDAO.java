package com.tc.nb.dal.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import com.tc.nb.dal.NotesDAO;
import com.tc.nb.entity.Note;

public class FileNotesDAO implements NotesDAO {

	private List<Note> notes = new ArrayList<Note>();

	private static final String SOURCE_PATH = "/Users/a/my_notebook/src/resources/notes.txt";

	public FileNotesDAO() {
		try {
			FileReader fr = new FileReader(SOURCE_PATH);
			BufferedReader reader = new BufferedReader(fr);
			String newReadLine;

			while ((newReadLine = reader.readLine()) != null) {
				try {
					String[] data = newReadLine.split(";");
					String title = data[1];
					String content = data[2];
					LocalDateTime dateTime = LocalDateTime.parse(data[0]);
					Note x = new Note(dateTime, title, content);
					notes.add(x);
				} catch (Exception e) {
					continue;
				}
			}
			reader.close();
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
