package com.mobile.framework.common;

public class ObjectConversion {
	public String changeNumberTo2Digits(int _param){
		String newNumber=""+_param;
		if (_param < 10){
			
			newNumber= "0"+_param;
		}
		return newNumber;
	}
}
