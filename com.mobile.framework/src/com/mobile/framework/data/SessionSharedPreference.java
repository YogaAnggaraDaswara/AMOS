package com.mobile.framework.data;

import com.google.gson.Gson;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionSharedPreference {
	private static SharedPreferences prefs;
	private static SharedPreferences.Editor prefsEditor;
	
	public static SharedPreferences getSharedPreferences(Context ctx){
		return PreferenceManager.getDefaultSharedPreferences(ctx);
	}
	
	public static void storeDataToSharesPreference(Context ctx,Object obj,String key){
		prefs = getSharedPreferences(ctx);
		prefsEditor = prefs.edit();
		prefsEditor.remove(key);
		Gson gson = new Gson();
	    String json = gson.toJson(obj);
	    prefsEditor.putString(key, json);
	    prefsEditor.commit();
	}
	
	public static  Object getDataFromSharedPreference(Context ctx,Class<?> cls,String key) throws Exception{
		prefs = getSharedPreferences(ctx);
	    Gson gson = new Gson();
	    String json = prefs.getString(key, "");
	    Object obj = gson.fromJson(json, cls);
	    return obj;
	}
	
	public static void removeDataFromSharePreference(Context ctx,String key){
		prefs = getSharedPreferences(ctx);
		prefsEditor = prefs.edit();
		prefsEditor.remove(key);
	}
}
