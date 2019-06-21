package com.sample.google.timezone;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeCommon {
	public static DateFormat basicFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static DateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static DateFormat fullFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	public static Timestamp utcRoot;
	static {
		try {
			utcRoot = new Timestamp(DateTimeCommon.basicFormat.parse("1970-01-01").getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
