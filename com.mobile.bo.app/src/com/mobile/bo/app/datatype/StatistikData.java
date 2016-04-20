package com.mobile.bo.app.datatype;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import com.mobile.framework.common.DateFormatter;

public class StatistikData {
	private Date TANGGAL;
	private int TARGETPROSPEK;
	private int TARGETKENALAN;
	private int TARGETPENDEKATAN;
	private int TARGETCLOSING;
	private ArrayList<DetailAktualData> AKTUALDATA=new ArrayList<DetailAktualData>();
	
	public StatistikData(){
		
	}
	public Date getTANGGAL() {
		return TANGGAL;
	}
	public void setTANGGAL(Date tANGGAL) {
		TANGGAL = tANGGAL;
	}
	public int getTARGETPROSPEK() {
		return TARGETPROSPEK;
	}
	public void setTARGETPROSPEK(int tARGETPROSPEK) {
		TARGETPROSPEK = tARGETPROSPEK;
	}
	public int getTARGETKENALAN() {
		return TARGETKENALAN;
	}
	public void setTARGETKENALAN(int tARGETKENALAN) {
		TARGETKENALAN = tARGETKENALAN;
	}
	public int getTARGETPENDEKATAN() {
		return TARGETPENDEKATAN;
	}
	public void setTARGETPENDEKATAN(int tARGETPENDEKATAN) {
		TARGETPENDEKATAN = tARGETPENDEKATAN;
	}
	public int getTARGETCLOSING() {
		return TARGETCLOSING;
	}
	public void setTARGETCLOSING(int tARGETCLOSING) {
		TARGETCLOSING = tARGETCLOSING;
	}
	
	public ArrayList<DetailAktualData> getAKTUALDATA() {
		return AKTUALDATA;
	}
	public void setAKTUALDATA(ArrayList<DetailAktualData> aKTUALDATA) {
		AKTUALDATA = aKTUALDATA;
	}
	public void updateStatistikDataFromJSON(JSONObject obj) throws Exception{
		TANGGAL = DateFormatter.formatDateYYYMMDD(obj.getString("TANGGAL"));
		TARGETPROSPEK = Integer.parseInt(obj.getString("TARGETPROSPECT"));
		TARGETKENALAN = Integer.parseInt(obj.getString("TARGETKENALAN"));
		TARGETPENDEKATAN = Integer.parseInt(obj.getString("TARGETPENDEKATAN"));
		TARGETCLOSING = Integer.parseInt(obj.getString("TARGETCLOSING"));
		
		JSONArray arrObjAktual = new JSONArray(obj.getString("AKTUAL"));	
		
		for (int i=0;i<arrObjAktual.length();i++){						
			JSONObject objAktual = arrObjAktual.getJSONObject(i);
			DetailAktualData ad=new DetailAktualData();	
			ad.updateDetailAktualDataFromJSON(objAktual);					
			AKTUALDATA.add(ad);
		}
	}
}
