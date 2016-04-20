package com.mobile.framework.activity;

import java.io.Serializable;

public class ActivityNameValuePair implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1830194024979204085L;
	private String KEY;
	private String VALUE;
	
	public ActivityNameValuePair(String key,String value){
		KEY = key;
		VALUE = value;
	}
	public String getKEY() {
		return KEY;
	}
	public void setKEY(String kEY) {
		KEY = kEY;
	}
	public String getVALUE() {
		return VALUE;
	}
	public void setVALUE(String vALUE) {
		VALUE = vALUE;
	}
}
