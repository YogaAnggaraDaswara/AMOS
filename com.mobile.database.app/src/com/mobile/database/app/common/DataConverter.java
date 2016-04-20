package com.mobile.database.app.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverter {

	private static SimpleDateFormat DB_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat DB_DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMdd-HHmmss");
	private static SimpleDateFormat DB_DATE_TIME_MILLISECOND_FORMAT = new SimpleDateFormat("yyyyMMdd-HHmmss.SSS");
	
	public static String dateToString(Date value) {
		String retVal = "";
		
		try {
			retVal = DB_DATE_FORMAT.format(value);
		} catch (Exception e) {
//			Log.i(DataConverter.class.getName(), "Trying to Parsing invalid value, Exception: " + e.getMessage());
		}
		return retVal;
	}
	
	public static String dateTimeToString(Date value) {
		String retVal = "";
		
		try {
			retVal = DB_DATE_TIME_FORMAT.format(value);
		} catch (Exception e) {
//			Log.i(DataConverter.class.getName(), "Trying to Parsing invalid value, Exception: " + e.getMessage());
		}
		return retVal;
	}
	
	public static String dateTimeMillisecondToString(Date value) {
		String retVal = "";
		
		try {
			retVal = DB_DATE_TIME_MILLISECOND_FORMAT.format(value);
		} catch (Exception e) {
//			Log.i(DataConverter.class.getName(), "Trying to Parsing invalid value, Exception: " + e.getMessage());
		}
		return retVal;
	}
	
	public static Date stringToDate(String value) {
		Date retVal = null;
		try {
			retVal = DB_DATE_FORMAT.parse(value);
		} catch (Exception e) {
//			Log.i(DataConverter.class.getName(), "Trying to Parsing invalid value, Exception: " + e.getMessage());
		}
		return retVal;
	}
	
	public static Date stringToDateTime(String value) {
		Date retVal = null;
		try {
			retVal = DB_DATE_TIME_FORMAT.parse(value);
		} catch (Exception e) {
//			Log.i(DataConverter.class.getName(), "Trying to Parsing invalid value, Exception: " + e.getMessage());
		}
		return retVal;
	}
	
	public static Date stringToDateTimeMillisecond(String value) {
		Date retVal = null;
		try {
			retVal = DB_DATE_TIME_MILLISECOND_FORMAT.parse(value);
		} catch (Exception e) {
//			Log.i(DataConverter.class.getName(), "Trying to Parsing invalid value, Exception: " + e.getMessage());
		}
		return retVal;
	}

}
