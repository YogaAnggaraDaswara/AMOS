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
import com.mobile.database.app.entities.APPR_SERTIFIKAT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Sertifikat implements Serializable {

	/**
	 * 
	 */
	public String ID;
	public String COL_ID;
	public String COL_SEQ;
	public String COL_DOK_TYPE;
	public String COL_DOK_NO;
	public String COL_DOK_DATE;
	public String COL_DOK_EXPDATE;
	public String COL_DOK_NAME;
	public String COL_RELATIONSHIP;





	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 ID=obj.getString("ID");
		 COL_ID=obj.getString("COL_ID");
		 COL_SEQ=obj.getString("COL_SEQ");
		 COL_DOK_TYPE=obj.getString("COL_DOK_TYPE");
		 COL_DOK_NO=obj.getString("COL_DOK_NO");
		 COL_DOK_DATE=obj.getString("COL_DOK_DATE");
		 COL_DOK_EXPDATE=obj.getString("COL_DOK_EXPDATE");
		 COL_DOK_NAME=obj.getString("COL_DOK_NAME");
		 COL_RELATIONSHIP=obj.getString("COL_RELATIONSHIP");


	 }
    
	 public Datatype_Appr_Sertifikat() {
	    	update("",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_Sertifikat(APPR_SERTIFIKAT Data) {
			update(Data);
	}
		

	public APPR_SERTIFIKAT toRowData(){
		APPR_SERTIFIKAT rowData= new APPR_SERTIFIKAT();
		rowData.setID(ID);
		rowData.setCOL_ID(COL_ID);
		rowData.setCOL_SEQ(COL_SEQ);
		rowData.setCOL_DOK_TYPE(COL_DOK_TYPE);
		rowData.setCOL_DOK_NO(COL_DOK_NO);
		rowData.setCOL_DOK_DATE(COL_DOK_DATE);
		rowData.setCOL_DOK_EXPDATE(COL_DOK_EXPDATE);
		rowData.setCOL_DOK_NAME(COL_DOK_NAME);
		rowData.setCOL_RELATIONSHIP(COL_RELATIONSHIP);




	
		return rowData;
	}
	
	public void update(APPR_SERTIFIKAT rowData) {
		ID=rowData.getID();
		COL_ID=rowData.getCOL_ID();
		COL_SEQ=rowData.getCOL_SEQ();
		COL_DOK_TYPE=rowData.getCOL_DOK_TYPE();
		COL_DOK_NO=rowData.getCOL_DOK_NO();
		COL_DOK_DATE=rowData.getCOL_DOK_DATE();
		COL_DOK_EXPDATE=rowData.getCOL_DOK_EXPDATE();
		COL_DOK_NAME=rowData.getCOL_DOK_NAME();
		COL_RELATIONSHIP=rowData.getCOL_RELATIONSHIP();


	}
	
	public void update(String id,
			String col_id,
			String col_seq,
			String col_dok_type,
			String col_dok_no,
			String col_dok_date,
			String col_dok_expdate,
			String col_dok_name,
			String col_relationship){
		ID=id;
		COL_ID=col_id;
		COL_SEQ=col_seq;
		COL_DOK_TYPE=col_dok_type;
		COL_DOK_NO=col_dok_no;
		COL_DOK_DATE=col_dok_date;
		COL_DOK_EXPDATE=col_dok_expdate;
		COL_DOK_NAME=col_dok_name;
		COL_RELATIONSHIP=col_relationship;


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

	public String getCOL_DOK_TYPE() {
		return COL_DOK_TYPE;
	}

	public void setCOL_DOK_TYPE(String cOL_DOK_TYPE) {
		COL_DOK_TYPE = cOL_DOK_TYPE;
	}

	public String getCOL_DOK_NO() {
		return COL_DOK_NO;
	}

	public void setCOL_DOK_NO(String cOL_DOK_NO) {
		COL_DOK_NO = cOL_DOK_NO;
	}

	public String getCOL_DOK_DATE() {
		return COL_DOK_DATE;
	}

	public void setCOL_DOK_DATE(String cOL_DOK_DATE) {
		COL_DOK_DATE = cOL_DOK_DATE;
	}

	public String getCOL_DOK_EXPDATE() {
		return COL_DOK_EXPDATE;
	}

	public void setCOL_DOK_EXPDATE(String cOL_DOK_EXPDATE) {
		COL_DOK_EXPDATE = cOL_DOK_EXPDATE;
	}

	public String getCOL_DOK_NAME() {
		return COL_DOK_NAME;
	}

	public void setCOL_DOK_NAME(String cOL_DOK_NAME) {
		COL_DOK_NAME = cOL_DOK_NAME;
	}

	public String getCOL_RELATIONSHIP() {
		return COL_RELATIONSHIP;
	}

	public void setCOL_RELATIONSHIP(String cOL_RELATIONSHIP) {
		COL_RELATIONSHIP = cOL_RELATIONSHIP;
	}

	
}
