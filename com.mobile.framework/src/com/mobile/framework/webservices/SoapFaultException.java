package com.mobile.framework.webservices;

@SuppressWarnings("serial")
public class SoapFaultException extends Exception {

	public SoapFaultException(String code, String text, String response) {
		super(code);
		faultCode = code;
		faultString = text;
		httpResponse = response;
	}

	private String faultCode;

	public String getFaultCode() {
		return faultCode;
	}

	private String faultString;

	public String getFaultString() {
		return faultString;
	}

	private String httpResponse;

	public String getHttpResponse() {
		return httpResponse;
	}

}
