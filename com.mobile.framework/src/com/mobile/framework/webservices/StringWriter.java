package com.mobile.framework.webservices;

public class StringWriter {

	StringBuilder sb = new StringBuilder();

	public StringWriter() {

	}

	public void write(String string) {
		sb.append(string);
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}
