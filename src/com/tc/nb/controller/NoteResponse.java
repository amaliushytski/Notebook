package com.tc.nb.controller;

public class NoteResponse {

	private int statusCode;

	private String response;

	public NoteResponse() {
	}

	public NoteResponse(int statusCode, String response) {
		this.statusCode = statusCode;
		this.response = response;
	}

	public NoteResponse(int statusCode) {
		this.statusCode = statusCode;
	}

	public void setStatusCode(int StatusCode) {
		this.statusCode = StatusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getResponse() {
		return response;
	}
}
