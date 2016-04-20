package com.mobile.bo.app.datatype;

import java.util.ArrayList;
import org.json.JSONObject;
import com.google.android.gms.maps.model.LatLng;

public class MotionTrackerDetailData {
	private int JUMLAHPROSPEK;
	private int JUMLAHKENALAN;
	private int JUMLAHPENDEKATAN;
	private int JUMLAHCLOSING;
	private String USERID;
	private ArrayList<LatLng> MAPDATA;
	
	public MotionTrackerDetailData(){
		
	}

	public int getJUMLAHPROSPEK() {
		return JUMLAHPROSPEK;
	}

	public void setJUMLAHPROSPEK(int jUMLAHPROSPEK) {
		JUMLAHPROSPEK = jUMLAHPROSPEK;
	}

	public int getJUMLAHKENALAN() {
		return JUMLAHKENALAN;
	}

	public void setJUMLAHKENALAN(int jUMLAHKENALAN) {
		JUMLAHKENALAN = jUMLAHKENALAN;
	}

	public int getJUMLAHPENDEKATAN() {
		return JUMLAHPENDEKATAN;
	}

	public void setJUMLAHPENDEKATAN(int jUMLAHPENDEKATAN) {
		JUMLAHPENDEKATAN = jUMLAHPENDEKATAN;
	}

	public int getJUMLAHCLOSING() {
		return JUMLAHCLOSING;
	}

	public void setJUMLAHCLOSING(int jUMLAHCLOSING) {
		JUMLAHCLOSING = jUMLAHCLOSING;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	
	public ArrayList<LatLng> getMAPDATA() {
		return MAPDATA;
	}

	public void setMAPDATA(ArrayList<LatLng> mAPDATA) {
		MAPDATA = mAPDATA;
	}

	public void updateDetailAktualDataFromJSON(JSONObject obj) throws Exception{
		JUMLAHPROSPEK = Integer.parseInt(obj.getString("JUMLAHPROSPEK"));
		JUMLAHKENALAN = Integer.parseInt(obj.getString("JUMLAHKENALAN"));
		JUMLAHPENDEKATAN = Integer.parseInt(obj.getString("JUMLAHPENDEKATAN"));
		JUMLAHCLOSING = Integer.parseInt(obj.getString("JUMLAHCLOSING"));
		USERID = obj.getString("USERID");
	}
}
