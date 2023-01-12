package com.tc.nb.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import com.tc.nb.controller.Controller;
import com.tc.nb.controller.NoteResponse;
import com.tc.nb.dal.impl.FileNotesDAO;
import com.tc.nb.entity.Note;
import com.tc.nb.service.exception.ServiceException;
import com.tc.nb.service.impl.NotesCreateServiceImpl;
import com.tc.nb.service.impl.NotesFindServiceImpl;
import com.tc.nb.view.impl.NotesViewImpl;

public class Main {

	public static void main(String[] args) throws Exception {
//
//		NotesFindServiceImpl service = new NotesFindServiceImpl();
//
//		List<Note> notes1 = service.findByContent("Test");
//		List<Note> notes = service.findByDateRange(LocalDateTime.parse("2022-12-01T15:39:46.510"),
//				LocalDateTime.parse("2022-12-16T15:39:46.510"));
//
//		NotesViewImpl view = new NotesViewImpl();
//
//		view.view(notes);
//
//		NotesCreateServiceImpl save = new NotesCreateServiceImpl();
//
//		save.add(new Note(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS), "New text", "Test content added in main file"));
//		
		Controller controller = new Controller();
//		controller.executeTask("save New title from controller; Content from controller");
//
		// controller.executeTask("SEARCH_BY_TITLE text");
//		controller.executeTask("SEARCH_BY_CONTENT test");
//		controller.executeTask("SEARCH_BY_DATE 2022-12-01T15:39:46.511");
//		controller.executeTask("SEARCH_BY_DATE_RANGE 2022-12-01T15:39:46.510 | 2022-12-01T15:39:46.510");
		NoteResponse response = controller.executeTask("save New title from controller; Content from controller");
		controller.executeTask("VIEW " + response.getResponse());

		response = controller.executeTask("SEARCH_BY_TITLE text");
		controller.executeTask("VIEW " + response.getResponse());

		response = controller.executeTask("SEARCH_BY_CONTENT controller");
		controller.executeTask("VIEW " + response.getResponse());

		response = controller.executeTask("SEARCH_BY_DATE 2022-12-09T15:20:34.209");
		controller.executeTask("VIEW " + response.getResponse());

		response = controller.executeTask("SEARCH_BY_DATE_RANGE 2022-12-09T15:20:34.209 | 2022-12-29T15:20:34.209");
		controller.executeTask("VIEW " + response.getResponse());

		// service.findByDateRange(null, null);

//		FileNotesDAO y = null;
//		try {
//			y = new FileNotesDAO();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

//		List<Note> notes = y.load();
//
//		LocalDateTime dateTime = LocalDateTime.parse("2012-11-14T11:44");
//
//		System.out.println(dateTime);

//		for (Note note : notes) {
//			System.out.println(note.getDate());
//			System.out.println(note.getContent());
//			System.out.println(note.getTitle());
//			System.out.println("-------------");
//		}

//		y.save(new Note(LocalDateTime.now(), "New text", "Test content added in main file"));

	}
}
