package com.tc.nb.main;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.tc.nb.dal.impl.FileNotesDAO;
import com.tc.nb.entity.Note;

public class Main {

	public static void main(String[] args) {

		FileNotesDAO y = new FileNotesDAO();
		List<Note> notes = y.load();
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse("2010-11-09 11:44", formatter);

		for (Note note : notes) {
			System.out.println(note.getDate());
			System.out.println(note.getContent());
			System.out.println(note.getTitle());
			System.out.println("-------------");
		}

		y.save(new Note(dateTime,"Hello1","Test content1"));
		
	}

}
