package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_imb implements Serializable {

	/**
	 * 
	 */
	public String ID;
	public String COL_ID;
	public String IMB_SEQ;
	public String IMB_NO;
	public Date IMB_DATE;
	public String IMB_PURPOSE;




	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 ID=obj.getString("ID");
		 COL_ID=obj.getString("COL_ID");
		 IMB_SEQ=obj.getString("IMB_SEQ");
		 IMB_NO=obj.getString("IMB_NO");
		 IMB_DATE=DataConverter.stringToDate(obj.getString("IMB_DATE"));
		 IMB_PURPOSE=obj.getString("IMB_PURPOSE");



	 }
    
	 public Datatype_Appr_imb() {
	    	update("",
	    			"",
	    			"",
	    			"",
	    			null,
	    			"");
		}
	    
	 public Datatype_Appr_imb(APPR_RTB_IMB_INT Data) {
			update(Data);
	}
		

	public APPR_RTB_IMB_INT toRowData(){
		APPR_RTB_IMB_INT rowData= new APPR_RTB_IMB_INT();
		rowData.setID(ID);
		rowData.setCOL_ID(COL_ID);
		rowData.setIMB_SEQ(IMB_SEQ);
		rowData.setIMB_NO(IMB_NO);
		rowData.setIMB_DATE(IMB_DATE);
		rowData.setIMB_PURPOSE(IMB_PURPOSE);



	
		return rowData;
	}
	
	public void update(APPR_RTB_IMB_INT rowData) {
		ID=rowData.getID();
		COL_ID=rowData.getCOL_ID();
		IMB_SEQ=rowData.getIMB_SEQ();
		IMB_NO=rowData.getIMB_NO();
		IMB_DATE=rowData.getIMB_DATE();
		IMB_PURPOSE=rowData.getIMB_PURPOSE();



	}
	
	public void update(String id,
			String col_id,
			String imb_seq,
			String imb_no,
			Date imb_date,
			String imb_purpose){
		ID=id;
		COL_ID=col_id;
		IMB_SEQ=imb_seq;
		IMB_NO=imb_no;
		IMB_DATE=imb_date;
		IMB_PURPOSE=imb_purpose;

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

	public String getIMB_SEQ() {
		return IMB_SEQ;
	}

	public void setIMB_SEQ(String iMB_SEQ) {
		IMB_SEQ = iMB_SEQ;
	}

	public String getIMB_NO() {
		return IMB_NO;
	}

	public void setIMB_NO(String iMB_NO) {
		IMB_NO = iMB_NO;
	}

	public Date getIMB_DATE() {
		return IMB_DATE;
	}

	public void setIMB_DATE(Date iMB_DATE) {
		IMB_DATE = iMB_DATE;
	}

	public String getIMB_PURPOSE() {
		return IMB_PURPOSE;
	}

	public void setIMB_PURPOSE(String iMB_PURPOSE) {
		IMB_PURPOSE = iMB_PURPOSE;
	}
	
}
