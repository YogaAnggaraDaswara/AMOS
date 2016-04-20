package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.mobile.database.app.common.DataConverter;

import com.mobile.database.app.entities.AMOS_EMAIL;
import com.mobile.database.app.entities.AMOS_ENTRY_DEBITUR_INT;

public class DataType_Amos_Email implements Serializable {
	
	/**
	 * 
	 */
	
	public String ID;
	public String AP_REGNO;
	public String TYPE;
	public String ISALREADYSUBMIT;
	public String NAMADEBITUR;
	
	public void updateMainFromJSON(JSONObject obj) throws Exception {
		ID = obj.getString("ID");
		AP_REGNO = obj.getString("AP_REGNO");
		TYPE = obj.getString("TYPE");
		ISALREADYSUBMIT = obj.getString("ISALREADYSUBMIT");
		NAMADEBITUR = obj.getString("NAMADEBITUR");
	}
	
	public DataType_Amos_Email()
	{
		update("",
			"",
			"", 
			"","");
	}
	
	public DataType_Amos_Email(AMOS_EMAIL Data) {
		update(Data);
	}
	
	public AMOS_EMAIL toRowData(){
		AMOS_EMAIL rowData= new AMOS_EMAIL();
		rowData.setID(ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setTYPE(TYPE);
		rowData.setISALREADYSUBMIT(ISALREADYSUBMIT);
		rowData.setNAMADEBITUR(NAMADEBITUR);
		return rowData;
	}
	
	public void update(AMOS_EMAIL rowData) {
		ID = rowData.getID();
		AP_REGNO = rowData.getAP_REGNO();
		TYPE = rowData.getTYPE();
		ISALREADYSUBMIT = rowData.getISALREADYSUBMIT();
		NAMADEBITUR= rowData.getNAMADEBITUR();
	}
	
	public void update(
			String id,
			String ap_regno,
			String type,
			String isreadysubmit,
			String namadebitur
	) {
		ID = id;
		AP_REGNO = ap_regno;
		TYPE = type;
		ISALREADYSUBMIT = isreadysubmit;
		NAMADEBITUR=namadebitur;
		}

	public String getNAMADEBITUR() {
		return NAMADEBITUR;
	}

	public void setNAMADEBITUR(String nAMADEBITUR) {
		NAMADEBITUR = nAMADEBITUR;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getISALREADYSUBMIT() {
		return ISALREADYSUBMIT;
	}

	public void setISALREADYSUBMIT(String iSALREADYSUBMIT) {
		ISALREADYSUBMIT = iSALREADYSUBMIT;
	}
	
	
	

}
