package com.tc.nb.dal.exception;

public class DAOException extends Exception {

	public DAOException(String message) {
		super(message);
	}

	public DAOException() {
		super();
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}

	public DAOException(Object printStackTrace) {
		super();
	}

}
