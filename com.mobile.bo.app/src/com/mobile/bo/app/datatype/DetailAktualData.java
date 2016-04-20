package com.mobile.bo.app.datatype;

import java.util.Date;
import org.json.JSONObject;
import com.mobile.framework.common.DateFormatter;

public class DetailAktualData implements Comparable<Object> {
	private Date TANGGAL;
	private int JUMLAHPROSPEK;
	private int JUMLAHKENALAN;
	private int JUMLAHPENDEKATAN;
	private int JUMLAHCLOSING;
	private int BLACKBOXRETRIVAL;
	private String USERID;
	
	public DetailAktualData(){
		
	}

	public Date getTANGGAL() {
		return TANGGAL;
	}

	public void setTANGGAL(Date tANGGAL) {
		TANGGAL = tANGGAL;
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

	public int getBLACKBOXRETRIVAL() {
		return BLACKBOXRETRIVAL;
	}

	public void setBLACKBOXRETRIVAL(int bLACKBOXRETRIVAL) {
		BLACKBOXRETRIVAL = bLACKBOXRETRIVAL;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	
	public void updateDetailAktualDataFromJSON(JSONObject obj) throws Exception{
		TANGGAL = DateFormatter.formatDateYYYMMDD(obj.getString("TANGGAL"));
		JUMLAHPROSPEK = Integer.parseInt(obj.getString("JUMLAHPROSPECT"));
		JUMLAHKENALAN = Integer.parseInt(obj.getString("JUMLAHKENALAN"));
		JUMLAHPENDEKATAN = Integer.parseInt(obj.getString("JUMLAHPENDEKATAN"));
		JUMLAHCLOSING = Integer.parseInt(obj.getString("JUMLAHCLOSING"));
		BLACKBOXRETRIVAL = Integer.parseInt(obj.getString("BLACKBOXRETRIVAL"));
		USERID = obj.getString("USERID");
	}
	
	@Override
	public int compareTo(Object o1) {
		return this.getTANGGAL().compareTo(((DetailAktualData) o1).getTANGGAL());
	}
}
