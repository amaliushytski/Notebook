package com.tc.nb.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeExtension {

	public static String getNow() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		return LocalDateTime.now().format(formatter);
	}

	public static LocalDateTime stringToLDT(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		LocalDateTime dateTime = LocalDateTime.parse(date.trim(), formatter);
		return dateTime;
	}

}
