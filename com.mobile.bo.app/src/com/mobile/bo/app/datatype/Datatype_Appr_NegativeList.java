package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_INBOXS;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_NEGATIVELIST_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_NegativeList implements Serializable {

	/**
	 * 
	 */
	public String ID;
	public String COL_ID;
	public String NEG_SEQ;
	public String NEG_CODE;


	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 ID=obj.getString("ID");
		 COL_ID=obj.getString("COL_ID");
		 NEG_SEQ=obj.getString("NEG_SEQ");
		 NEG_CODE=obj.getString("NEG_CODE");

	 }
    
	 public Datatype_Appr_NegativeList() {
	    	update("",
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_NegativeList(APPR_NEGATIVELIST_INT Data) {
			update(Data);
	}
		

	public APPR_NEGATIVELIST_INT toRowData(){
		APPR_NEGATIVELIST_INT rowData= new APPR_NEGATIVELIST_INT();
		rowData.setID(ID);
		rowData.setCOL_ID(COL_ID);
		rowData.setNEG_SEQ(NEG_SEQ);
		rowData.setNEG_CODE(NEG_CODE);

		
		return rowData;
	}
	
	public void update(APPR_NEGATIVELIST_INT rowData) {
		ID=rowData.getID();
		COL_ID=rowData.getCOL_ID();
		NEG_SEQ=rowData.getNEG_SEQ();
		NEG_CODE=rowData.getNEG_CODE();

		

	}
	
	public void update(String id,
			String col_id,
			String neg_seq,
			String neg_code
			){
		ID=id;
		COL_ID=col_id;
		NEG_SEQ=neg_seq;
		NEG_CODE=neg_code;


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

	public String getNEG_SEQ() {
		return NEG_SEQ;
	}

	public void setNEG_SEQ(String nEG_SEQ) {
		NEG_SEQ = nEG_SEQ;
	}

	public String getNEG_CODE() {
		return NEG_CODE;
	}

	public void setNEG_CODE(String nEG_CODE) {
		NEG_CODE = nEG_CODE;
	}

	

	
}
