package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
public class Z_CashCheckupData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5034907241756435940L;
	private long TOTALTABUNGAN;
	private long TOTALTAGIHAN;
	private long TOTALCASHPICKUP;
	private ArrayList<TabunganData> TABUNGAN = new ArrayList<TabunganData>();
	private ArrayList<TagihanData> TAGIHAN = new ArrayList<TagihanData>();
	
	public long getTOTALTABUNGAN() {
		return TOTALTABUNGAN;
	}
	public void setTOTALTABUNGAN(long tOTALTABUNGAN) {
		TOTALTABUNGAN = tOTALTABUNGAN;
	}
	public long getTOTALTAGIHAN() {
		return TOTALTAGIHAN;
	}
	public void setTOTALTAGIHAN(long tOTALTAGIHAN) {
		TOTALTAGIHAN = tOTALTAGIHAN;
	}
	public long getTOTALCASHPICKUP() {
		return TOTALCASHPICKUP;
	}
	public void setTOTALCASHPICKUP(long tOTALCASHPICKUP) {
		TOTALCASHPICKUP = tOTALCASHPICKUP;
	}
	public ArrayList<TabunganData> getTABUNGAN() {
		return TABUNGAN;
	}
	public void setTABUNGAN(ArrayList<TabunganData> tABUNGAN) {
		TABUNGAN = tABUNGAN;
	}
	public ArrayList<TagihanData> getTAGIHAN() {
		return TAGIHAN;
	}
	public void setTAGIHAN(ArrayList<TagihanData> tAGIHAN) {
		TAGIHAN = tAGIHAN;
	}
	
	public void updateCashCheckupFromJSON(JSONObject obj) throws Exception{
		TOTALTABUNGAN = Long.parseLong(obj.getString("TOTALTABUNGAN"));
		TOTALTAGIHAN = Long.parseLong(obj.getString("TOTALTAGIHAN"));
		TOTALCASHPICKUP = Long.parseLong(obj.getString("TOTALCASHPICKUP"));
		
		JSONArray arrTabungan= new JSONArray(obj.getString("TABUNGAN"));
		if (arrTabungan.length() > 0){
			for (int i=0;i< arrTabungan.length();i++){
				JSONObject objTabungan= arrTabungan.getJSONObject(i);
				TabunganData td=new TabunganData();
				td.updateTabunganFromJSON(objTabungan);
				TABUNGAN.add(td);
			}
		}
		
		JSONArray arrTagihan= new JSONArray(obj.getString("TAGIHAN"));
		if (arrTagihan.length() > 0){
			for (int i=0;i< arrTagihan.length();i++){
				JSONObject objTagihan= arrTagihan.getJSONObject(i);
				TagihanData td=new TagihanData();
				td.updateTagihanFromJSON(objTagihan);
				TAGIHAN.add(td);
			}
		}
	}
}
