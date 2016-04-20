package com.mobile.database.app.entities;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="LOV")
public class LOV {
	@DatabaseField(
			id=true, 
			unique=true,
			canBeNull=false,
			uniqueIndexName="LOV_PK",
			dataType=DataType.STRING,
			width=20)	
		private String ID;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=70)
    private String CODE;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=40)
    private String DESCRIPTION;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String GROUP;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String ORDERNUM;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String PARENT;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String PARENT_2;


	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public String getGROUP() {
		return GROUP;
	}

	public void setGROUP(String gROUP) {
		GROUP = gROUP;
	}

	public String getORDERNUM() {
		return ORDERNUM;
	}

	public void setORDERNUM(String oRDERNUM) {
		ORDERNUM = oRDERNUM;
	}
	
	public String getPARENT() {
		return PARENT;
	}

	public void setPARENT(String pARENT) {
		PARENT = pARENT;
	}
	
	public String getPARENT_2() {
		return PARENT_2;
	}

	public void setPARENT_2(String pARENT_2) {
		PARENT_2 = pARENT_2;
	}
}
