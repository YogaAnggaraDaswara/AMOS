package com.mobile.bo.app.datatype;

import java.util.ArrayList;
import java.util.Date;
import org.json.JSONObject;
import com.mobile.framework.common.DateFormatter;

public class MotionTrackerData {

	private Date TANGGAL;
	private ArrayList<MotionTrackerDetailData> AKTUAL;
	
	public MotionTrackerData(){
		
	}

	public Date getTANGGAL() {
		return TANGGAL;
	}

	public void setTANGGAL(Date tANGGAL) {
		TANGGAL = tANGGAL;
	}

	public ArrayList<MotionTrackerDetailData> getAKTUAL() {
		return AKTUAL;
	}

	public void setAKTUAL(ArrayList<MotionTrackerDetailData> aKTUAL) {
		AKTUAL = aKTUAL;
	}
	
	public void updateDetailAktualDataFromJSON(JSONObject obj) throws Exception{
		TANGGAL = DateFormatter.formatDateYYYMMDD(obj.getString("TANGGAL"));
	}
}
