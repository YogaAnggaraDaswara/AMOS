package com.mobile.bo.app.dataprovider;

import android.content.Context;

public class DataProviderManager {
	
	private static final Object syncObject = new Object();
	private static boolean isInitialized = false;
	private static Context theContext;
	
	public static Context getAttachedContext() {
		Context retVal = null;
		if (isInitialized) {
			retVal = theContext;
		}
		return retVal;
	}
	
	public static boolean attachContext(Context context) {
		boolean retVal = false;
		synchronized (syncObject) {
			if (!isInitialized) {
				theContext = context;
				isInitialized = true;
			}
			retVal = isInitialized;
		}
		return retVal;
	}
	
	public static boolean detachContext() {
		boolean retVal = false;
		synchronized (syncObject) {
			if (isInitialized) {
				theContext = null;
				isInitialized = false;
			}
			retVal = !isInitialized;
		}
		return retVal;
	}
}
