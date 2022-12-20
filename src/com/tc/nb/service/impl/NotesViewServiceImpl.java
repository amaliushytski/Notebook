package com.tc.nb.service.impl;

import java.util.List;

import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesViewService;
import com.tc.nb.service.exception.ServiceException;

public class NotesViewServiceImpl implements NotesViewService {

	@Override
	public void view(List<Note> records) throws ServiceException {

//		for (Note note : records) {
		for (int i = 0; i < records.size(); i++)
			if (records.size() > 0) {
				System.out.println(records.get(i).getDate());
				System.out.println(records.get(i).getTitle());
				System.out.println(records.get(i).getContent());
				System.out.println("-------------");
			} else if (i == 0) {
				System.out.println("No records found");
			}
	}
}
