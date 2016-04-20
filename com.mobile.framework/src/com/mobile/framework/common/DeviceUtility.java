package com.mobile.framework.common;

import java.lang.reflect.Method;

import android.content.Context;
import android.telephony.TelephonyManager;

public class DeviceUtility {

	public static String getDeviceSerialNumber() {
		String sn = "11342521402058";
		
		Class<?> c;
		try {
			c = Class.forName("android.os.SystemProperties");
			Method get = c.getMethod("get", String.class);
			sn = (String) get.invoke(c, "ro.serialno");
			if (sn != null) {
				if (sn.equals("")) {
					sn = "00000000000000";
				}
			} else {
				sn = "00000000000000";
			}
		} catch (Exception e) {
			e.printStackTrace();
			sn = "00000000000000";
		}
		
		return sn;
	}
	
	public static String getIMEI(Context context){
		String imei = null;
		TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		if (tm != null){
			imei = tm.getDeviceId();
		}
		return imei;
	}
}
