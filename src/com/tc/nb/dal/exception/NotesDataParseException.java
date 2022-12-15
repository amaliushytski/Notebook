package com.tc.nb.dal.exception;

public class NotesDataParseException extends Exception {

	public NotesDataParseException(String message) {
		super(message);
	}

	public NotesDataParseException() {
		super();
	}

	public NotesDataParseException(Exception e) {
		super(e);
	}

	public NotesDataParseException(String message, Exception e) {
		super(message, e);
	}

}
