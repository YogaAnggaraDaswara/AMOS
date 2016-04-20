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
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_History implements Serializable {

	/**
	 * 
	 */
	public String ID;
	public String COL_ID;
	public String COL_SEQ;
	public String COL_DESC;
	public String COL_ADDR1;
	public String MARKETVALUE;
	public String SAFETYMARGIN;
	public String LIQVALUE;
	public String LIQFISIK;
	public String LIQIMB;
	public String MARKETFISIK;
	public String MARKETIMB;
	public String SAMPLINGCOUNT;
	public String TOTALITEM;



	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 ID=obj.getString("ID");
		 COL_ID=obj.getString("COL_ID");
		 COL_SEQ=obj.getString("COL_SEQ");
		 COL_DESC=obj.getString("COL_DESC");
		 COL_ADDR1=obj.getString("COL_ADDR1");
		 MARKETVALUE=obj.getString("MARKETVALUE");
		 SAFETYMARGIN=obj.getString("SAFETYMARGIN");
		 LIQVALUE=obj.getString("LIQVALUE");
		 LIQFISIK=obj.getString("LIQFISIK");
		 LIQIMB=obj.getString("LIQIMB");
		 MARKETFISIK=obj.getString("MARKETFISIK");
		 MARKETIMB=obj.getString("MARKETIMB");
		 SAMPLINGCOUNT=obj.getString("SAMPLINGCOUNT");
		 TOTALITEM=obj.getString("TOTALITEM");



	 }
    
	 public Datatype_Appr_History() {
	    	update("",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_History(APPR_HISTORY Data) {
			update(Data);
	}
		

	public APPR_HISTORY toRowData(){
		APPR_HISTORY rowData= new APPR_HISTORY();
		rowData.setID(ID);
		rowData.setCOL_ID(COL_ID);
		rowData.setCOL_SEQ(COL_SEQ);
		rowData.setCOL_DESC(COL_DESC);
		rowData.setCOL_ADDR1(COL_ADDR1);
		rowData.setMARKETVALUE(MARKETVALUE);
		rowData.setSAFETYMARGIN(SAFETYMARGIN);
		rowData.setLIQVALUE(LIQVALUE);
		rowData.setLIQFISIK(LIQFISIK);
		rowData.setLIQIMB(LIQIMB);
		rowData.setMARKETFISIK(MARKETFISIK);
		rowData.setMARKETIMB(MARKETIMB);
		rowData.setSAMPLINGCOUNT(SAMPLINGCOUNT);
		rowData.setTOTALITEM(TOTALITEM);


	
		return rowData;
	}
	
	public void update(APPR_HISTORY rowData) {
		ID=rowData.getID();
		COL_ID=rowData.getCOL_ID();
		COL_SEQ=rowData.getCOL_SEQ();
		COL_DESC=rowData.getCOL_DESC();
		COL_ADDR1=rowData.getCOL_ADDR1();
		MARKETVALUE=rowData.getMARKETVALUE();
		SAFETYMARGIN=rowData.getSAFETYMARGIN();
		LIQVALUE=rowData.getLIQVALUE();
		LIQFISIK=rowData.getLIQFISIK();
		LIQIMB=rowData.getLIQIMB();
		MARKETFISIK=rowData.getMARKETFISIK();
		MARKETIMB=rowData.getMARKETIMB();
		SAMPLINGCOUNT=rowData.getSAMPLINGCOUNT();
		TOTALITEM=rowData.getTOTALITEM();



	}
	
	public void update(String id,
			String col_id,
			String col_seq,
			String col_desc,
			String col_addr1,
			String marketvalue,
			String safetymargin,
			String liqvalue,
			String liqfisik,
			String liqimb,
			String marketfisik,
			String marketimb,
			String samplingcount,
			String totalitem){
		ID=id;
		COL_ID=col_id;
		COL_SEQ=col_seq;
		COL_DESC=col_desc;
		COL_ADDR1=col_addr1;
		MARKETVALUE=marketvalue;
		SAFETYMARGIN=safetymargin;
		LIQVALUE=liqvalue;
		LIQFISIK=liqfisik;
		LIQIMB=liqimb;
		MARKETFISIK=marketfisik;
		MARKETIMB=marketimb;
		SAMPLINGCOUNT=samplingcount;
		TOTALITEM=totalitem;


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

	public String getCOL_SEQ() {
		return COL_SEQ;
	}

	public void setCOL_SEQ(String cOL_SEQ) {
		COL_SEQ = cOL_SEQ;
	}

	public String getCOL_DESC() {
		return COL_DESC;
	}

	public void setCOL_DESC(String cOL_DESC) {
		COL_DESC = cOL_DESC;
	}

	public String getCOL_ADDR1() {
		return COL_ADDR1;
	}

	public void setCOL_ADDR1(String cOL_ADDR1) {
		COL_ADDR1 = cOL_ADDR1;
	}

	public String getMARKETVALUE() {
		return MARKETVALUE;
	}

	public void setMARKETVALUE(String mARKETVALUE) {
		MARKETVALUE = mARKETVALUE;
	}

	public String getSAFETYMARGIN() {
		return SAFETYMARGIN;
	}

	public void setSAFETYMARGIN(String sAFETYMARGIN) {
		SAFETYMARGIN = sAFETYMARGIN;
	}

	public String getLIQVALUE() {
		return LIQVALUE;
	}

	public void setLIQVALUE(String lIQVALUE) {
		LIQVALUE = lIQVALUE;
	}

	public String getLIQFISIK() {
		return LIQFISIK;
	}

	public void setLIQFISIK(String lIQFISIK) {
		LIQFISIK = lIQFISIK;
	}

	public String getLIQIMB() {
		return LIQIMB;
	}

	public void setLIQIMB(String lIQIMB) {
		LIQIMB = lIQIMB;
	}

	public String getMARKETFISIK() {
		return MARKETFISIK;
	}

	public void setMARKETFISIK(String mARKETFISIK) {
		MARKETFISIK = mARKETFISIK;
	}

	public String getMARKETIMB() {
		return MARKETIMB;
	}

	public void setMARKETIMB(String mARKETIMB) {
		MARKETIMB = mARKETIMB;
	}

	public String getSAMPLINGCOUNT() {
		return SAMPLINGCOUNT;
	}

	public void setSAMPLINGCOUNT(String sAMPLINGCOUNT) {
		SAMPLINGCOUNT = sAMPLINGCOUNT;
	}

	public String getTOTALITEM() {
		return TOTALITEM;
	}

	public void setTOTALITEM(String tOTALITEM) {
		TOTALITEM = tOTALITEM;
	}

	
	

	
}
