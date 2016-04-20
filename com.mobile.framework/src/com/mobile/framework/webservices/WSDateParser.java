package com.mobile.framework.webservices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WSDateParser {

	public static Date parse(String val) {

		// yyyy-MM-dd'T'HH:mm:ss'Z'

		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		Date retVal = null;
		try {
			retVal = sd.parse(val);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;

		// // remove z...
		// if (val.endsWith("z") || val.endsWith("Z"))
		// val = val.substring(0, val.length() - 1);
		//
		// if (val.equalsIgnoreCase("0001-01-01T00:00:00"))
		// return null;
		//
		// String[] tokens = val.split("T");
		//
		// String datePart = tokens[0];
		// String timePart = tokens[1];
		//
		// String[] dateParts = datePart.split("-");
		// String[] timeParts = null;
		//
		// if (datePart.indexOf("+") >=0 ) {
		// // GMT format
		// timePart.split(":");
		//
		// } else {
		// // millisecond format
		// timePart.split(":");
		// }
		//
		// Integer year = Integer.parseInt(dateParts[0]);
		// Integer month = Integer.parseInt(dateParts[1]);
		// Integer day = Integer.parseInt(dateParts[2]);
		//
		// Integer hour = Integer.parseInt(timeParts[0]);
		// Integer min = Integer.parseInt(timeParts[1]);
		//
		// String secPart = timeParts[2];
		// String millParts[] = secPart.split("\\.");
		//
		// int sec = Integer.parseInt(millParts[0]);
		//
		// int mill = 0;
		//
		// if (millParts.length == 2)
		// mill = Integer.parseInt(millParts[1]);
		//
		// Calendar cl = Calendar.getInstance();
		// cl.set(Calendar.YEAR, year);
		// // java considers 0 as January...
		// cl.set(Calendar.MONTH, month - 1);
		// cl.set(Calendar.DAY_OF_MONTH, day);
		// cl.set(Calendar.HOUR_OF_DAY, hour);
		// cl.set(Calendar.MINUTE, min);
		// cl.set(Calendar.SECOND, sec);
		// cl.set(Calendar.MILLISECOND, mill);
		//
		// return cl.getTime();
	}

	public static String toString(Date val) {
		// Calendar c = Calendar.getInstance();
		// c.setTime(val);

		if (val == null)
			return "0001-01-01T00:00:00";

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'Z'");
		return sdf.format(val);

	}

}
