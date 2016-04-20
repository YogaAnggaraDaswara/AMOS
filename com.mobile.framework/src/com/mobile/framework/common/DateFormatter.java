package com.mobile.framework.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.util.Log;

public class DateFormatter {
	
	private static final SimpleDateFormat FORMAT_DDMMMYYYY_HHMMDD = new SimpleDateFormat("dd MMMM yyyy, HH:mm:ss");
	private static final SimpleDateFormat FORMAT_DDMMMYYYY = new SimpleDateFormat("dd MMMM yyyy");
	private static final SimpleDateFormat FORMAT_DDMMYYYY = new SimpleDateFormat("dd-MM-yyyy");
	private static final SimpleDateFormat FORMAT_YYYYMMDD = new SimpleDateFormat("yyyy/MM/dd");
	private static final SimpleDateFormat FORMAT_YYYYMMDDHHmmss = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static final SimpleDateFormat FORMAT_DDMMYYYYHHMMSS = new SimpleDateFormat("DDMMyyyyHHmmss");

	
	public static Date formatDateYYYMMDD(String value) {
		Date retVal = null;
		try {
			retVal = FORMAT_YYYYMMDD.parse(value);
		} catch (Exception e) {}
		return retVal;
	}
	
	public static Date formatDate(String value) {
		Date retVal = null;
		try {
			retVal = FORMAT_DDMMYYYY.parse(value);
		} catch (Exception e) {}
		return retVal;
	}
	
	public static Date formatYYYYMMDDHHmmss(String value) {
		Date retVal = null;
		try {
			retVal = FORMAT_YYYYMMDDHHmmss.parse(value);
		} catch (Exception e) {}
		return retVal;
	}
	
	public static String formatStringYYYYMMDDHHmmss(Date date) {
		return FORMAT_YYYYMMDDHHmmss.format(date);
	}
	
	public static Date formatDateOnly(Date date) {
		return formatDate(FORMAT_DDMMYYYY.format(date));
	}
	
	public static String formatStringFORMATDDMMYYHHMMSS(Date date) {
		return FORMAT_DDMMYYYYHHMMSS.format(date);
	}
	
	public static String formatString(Date date) {
		return FORMAT_DDMMYYYY.format(date);
	}
	
	public static String formatStringYYYYMMdd(Date date,boolean includetime) {
		if (includetime){
			return FORMAT_YYYYMMDDHHmmss.format(date);
		}
		else{
			return FORMAT_YYYYMMDD.format(date);
		}
	}
	
	public static String format(Date date) {
		return format(date, false);
	}
	
	public static String format(Date date, boolean includeTime) {
		String retVal = "";
		try {
			if (includeTime) {
				retVal = FORMAT_DDMMMYYYY_HHMMDD.format(date);
			} else {
				retVal = FORMAT_DDMMMYYYY.format(date);
			}
		} catch(Exception ex) {
			Log.i(DeviceUtility.class.getName(), 
					String.format("formatDDMMMYYYY fail, Exception: %s", ex.getMessage()));
		}
		
		return retVal;
	}
	
	public static int getDay()  
    {  
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		Date d = new Date();
		String day = sdf.format(d);
		
		Map<String,Integer> mp=new HashMap<String,Integer>();  
        mp.put("Sunday",0);  
        mp.put("Monday",1);  
        mp.put("Tuesday",2);  
        mp.put("Wednesday",3);  
        mp.put("Thursday",4);  
        mp.put("Friday",5);  
        mp.put("Saturday",6);  
          
        return mp.get(day).intValue(); 
    } 
	
}
