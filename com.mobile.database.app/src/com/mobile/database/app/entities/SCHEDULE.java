package com.mobile.database.app.entities;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="SCHEDULE")
public class SCHEDULE {
	@DatabaseField(
			id=true, 
			unique=true,
			canBeNull=false,
			uniqueIndexName="SCHEDULE_PK",
			dataType=DataType.STRING,
			width=20)		
    private String ID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String TYPE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String INTERVAL;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String START;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String END;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getINTERVAL() {
		return INTERVAL;
	}
	public void setINTERVAL(String iNTERVAL) {
		INTERVAL = iNTERVAL;
	}
	public String getSTART() {
		return START;
	}
	public void setSTART(String sTART) {
		START = sTART;
	}
	public String getEND() {
		return END;
	}
	public void setEND(String eND) {
		END = eND;
	}
}
