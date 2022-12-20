package com.tc.nb.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.tc.nb.dal.impl.FileNotesDAO;
import com.tc.nb.entity.Note;
import com.tc.nb.service.impl.NotesCreateServiceImpl;
import com.tc.nb.service.impl.NotesFindServiceImpl;
import com.tc.nb.service.impl.NotesViewServiceImpl;

public class Main {

	public static void main(String[] args) throws Exception {

		NotesFindServiceImpl service = new NotesFindServiceImpl();
		//Find note by content
		List<Note> notes = service.findByContent("Test");
		//Find note by date range
		List<Note> notes = service.findByDateRange(LocalDateTime.parse("2022-12-01T15:39:46.510000"),
				LocalDateTime.parse("2022-12-02T15:39:46.510000"));

		NotesViewServiceImpl view = new NotesViewServiceImpl();

		view.view(notes);

		NotesCreateServiceImpl save = new NotesCreateServiceImpl();
		//Add a new note
		save.add(new Note(LocalDateTime.now(), "New text", "Test content added in main file"));

	}
}
