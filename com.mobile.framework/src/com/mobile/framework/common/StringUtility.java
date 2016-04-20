package com.mobile.framework.common;

public class StringUtility {

	public static boolean isEmpty(Object value) {
		if (!(value instanceof String)) {
			return false;
		}

		return isEmpty((String) value);
	}

	public static boolean isEmpty(String value) {
		if (value == null) {
			return false;
		}

		if (value.length() > 0) {
			return false;
		}

		return true;
	}
}
