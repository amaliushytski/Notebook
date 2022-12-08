package com.tc.nb.entity;

import java.time.LocalDateTime;

public class Note {

	public Note(LocalDateTime date, String title, String content) {
		super();
		this.date = date;
		this.title = title;
		this.content = content;
	}

	public Note() {
	}

	private LocalDateTime date;

	private String title;

	private String content;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
