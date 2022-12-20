package com.tc.nb.service.exception;

public class ServiceException extends Exception {

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException() {
		super();
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}

	public ServiceException(Object printStackTrace) {
		super();
	}

}
