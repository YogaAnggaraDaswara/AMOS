package com.mobile.database.app.entities;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="AMOS_EMAIL")
public class AMOS_EMAIL {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="AMOS_EMAIL_PK",dataType=DataType.STRING) private String ID; // h
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=4) private String TYPE;
	@DatabaseField(dataType=DataType.STRING,width=4) private String NAMADEBITUR;
	@DatabaseField(dataType=DataType.STRING,width=558) private String ISALREADYSUBMIT; //new
	public String getID() {
		return ID;
	}
	
	public String getNAMADEBITUR() {
		return NAMADEBITUR;
	}

	public void setNAMADEBITUR(String nAMADEBITUR) {
		NAMADEBITUR = nAMADEBITUR;
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
