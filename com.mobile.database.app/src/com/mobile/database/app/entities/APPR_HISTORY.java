package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_HISTORY")
public class APPR_HISTORY {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_HISTORY_PK",dataType=DataType.STRING) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_SEQ;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_DESC;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_ADDR1;
	@DatabaseField(dataType=DataType.STRING,width=100) private String MARKETVALUE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String SAFETYMARGIN;
	@DatabaseField(dataType=DataType.STRING,width=100) private String LIQVALUE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String LIQFISIK;
	@DatabaseField(dataType=DataType.STRING,width=100) private String LIQIMB;
	@DatabaseField(dataType=DataType.STRING,width=100) private String MARKETFISIK;
	@DatabaseField(dataType=DataType.STRING,width=100) private String MARKETIMB;
	@DatabaseField(dataType=DataType.STRING,width=100) private String SAMPLINGCOUNT;
	@DatabaseField(dataType=DataType.STRING,width=100) private String TOTALITEM;
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
