package com.tc.nb.service;

import java.util.List;

import com.tc.nb.entity.Note;
import com.tc.nb.service.exception.ServiceException;

public interface NotesViewService {

	void view(List<Note> records) throws ServiceException;
}
