package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_COLLATERAL;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_SAMPLING_BANGUNAN_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Pb_sampling_bangunan implements Serializable {

	/**
	 * 
	 */
	public String ID;
	public String COL_ID;
	public String AP_REGNO;
	public String SEQ;
	public String ITEM;
	public String AVAILABLE;
	public String MEASUREMENT_UNIT;
	public String INFO;





	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 ID=obj.getString("ID");
		 COL_ID=obj.getString("COL_ID");
		 AP_REGNO=obj.getString("AP_REGNO");
		 SEQ=obj.getString("SEQ");
		 ITEM=obj.getString("ITEM");
		 AVAILABLE=obj.getString("AVAILABLE");
		 MEASUREMENT_UNIT=obj.getString("MEASUREMENT_UNIT");
		 INFO=obj.getString("INFO");




	 }
    
	 public Datatype_Appr_Pb_sampling_bangunan() {
	    	update("",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_Pb_sampling_bangunan(APPR_PB_SAMPLING_BANGUNAN_INT Data) {
			update(Data);
	}
		

	public APPR_PB_SAMPLING_BANGUNAN_INT toRowData(){
		APPR_PB_SAMPLING_BANGUNAN_INT rowData= new APPR_PB_SAMPLING_BANGUNAN_INT();
		rowData.setID(ID);
		rowData.setCOL_ID(COL_ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setSEQ(SEQ);
		rowData.setITEM(ITEM);
		rowData.setAVAILABLE(AVAILABLE);
		rowData.setMEASUREMENT_UNIT(MEASUREMENT_UNIT);
		rowData.setINFO(INFO);

		return rowData;
	}
	
	public void update(APPR_PB_SAMPLING_BANGUNAN_INT rowData) {
		ID=rowData.getID();
		COL_ID=rowData.getCOL_ID();
		AP_REGNO=rowData.getAP_REGNO();
		SEQ=rowData.getSEQ();
		ITEM=rowData.getITEM();
		AVAILABLE=rowData.getAVAILABLE();
		MEASUREMENT_UNIT=rowData.getMEASUREMENT_UNIT();
		INFO=rowData.getINFO();


	}
	
	public void update(String id,
			String col_id,
			String ap_regno,
			String seq,
			String item,
			String available,
			String measurement_unit,
			String info){
		ID=id;
		COL_ID=col_id;
		AP_REGNO=ap_regno;
		SEQ=seq;
		ITEM=item;
		AVAILABLE=available;
		MEASUREMENT_UNIT=measurement_unit;
		INFO=info;



}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCOL_ID() {
		return COL_ID;
	}

	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getSEQ() {
		return SEQ;
	}

	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}

	public String getITEM() {
		return ITEM;
	}

	public void setITEM(String iTEM) {
		ITEM = iTEM;
	}

	public String getAVAILABLE() {
		return AVAILABLE;
	}

	public void setAVAILABLE(String aVAILABLE) {
		AVAILABLE = aVAILABLE;
	}

	public String getMEASUREMENT_UNIT() {
		return MEASUREMENT_UNIT;
	}

	public void setMEASUREMENT_UNIT(String mEASUREMENT_UNIT) {
		MEASUREMENT_UNIT = mEASUREMENT_UNIT;
	}

	public String getINFO() {
		return INFO;
	}

	public void setINFO(String iNFO) {
		INFO = iNFO;
	}

	
	
	
}
