package com.tc.nb.view.impl;

import java.util.List;

import com.tc.nb.entity.Note;
import com.tc.nb.view.NotesView;

public class NotesViewImpl implements NotesView {
	@Override
	public void view(List<Note> records) {

		if (records == null || records.size() == 0) {
			System.out.println("No records found");
		} else {
			for (int i = 0; i < records.size(); i++) {
				System.out.println(records.get(i).getDate());
				System.out.println(records.get(i).getTitle());
				System.out.println(records.get(i).getContent());
				System.out.println("-------------");
			}
		}
	}
}
