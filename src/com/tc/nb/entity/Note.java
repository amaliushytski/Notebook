package com.tc.nb.entity;

import java.time.LocalDateTime;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(content, date, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(content, other.content) && Objects.equals(date, other.date)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return date + ";" + title + ";" + content + "\n";
	}
}
