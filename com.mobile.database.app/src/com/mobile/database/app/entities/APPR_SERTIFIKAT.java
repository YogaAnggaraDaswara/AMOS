package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_SERTIFIKAT")
public class APPR_SERTIFIKAT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_SERTIFIKAT_PK",dataType=DataType.STRING,width=16) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=4) private String COL_SEQ;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_DOK_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_DOK_NO;
	@DatabaseField(dataType=DataType.STRING,width=8) private String COL_DOK_DATE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String COL_DOK_EXPDATE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_DOK_NAME;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_RELATIONSHIP;
	
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
