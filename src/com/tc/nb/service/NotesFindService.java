package com.tc.nb.service;

import java.time.LocalDateTime;
import java.util.List;
import com.tc.nb.entity.Note;
import com.tc.nb.service.exception.ServiceException;

public interface NotesFindService {

	List<Note> findByTitle(String title) throws ServiceException;

	List<Note> findByContent(String content) throws ServiceException;

	List<Note> findByDate(LocalDateTime date) throws ServiceException;

	List<Note> findByDateRange(LocalDateTime dateFrom, LocalDateTime dateTo) throws ServiceException;

}
