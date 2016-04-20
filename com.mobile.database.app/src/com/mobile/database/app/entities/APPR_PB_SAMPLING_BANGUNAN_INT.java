package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_PB_SAMPLING_BANGUNAN_INT")
public class APPR_PB_SAMPLING_BANGUNAN_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_PB_SAMPLING_BANGUNAN_INT_PK",dataType=DataType.STRING) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String SEQ;
	@DatabaseField(dataType=DataType.STRING,width=50) private String ITEM;
	@DatabaseField(dataType=DataType.STRING,width=10) private String AVAILABLE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String MEASUREMENT_UNIT;
	@DatabaseField(dataType=DataType.STRING,width=50) private String INFO;
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
	public String getAP_REGNO() {
		return AP_REGNO;
	}
	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
	public String getITEM() {
		return ITEM;
	}
	public void setITEM(String iTEM) {
		ITEM = iTEM;
	}
	public String getAVAILABLE() {
		return AVAILABLE;
	}
	public void setAVAILABLE(String aVAILABLE) {
		AVAILABLE = aVAILABLE;
	}
	public String getMEASUREMENT_UNIT() {
		return MEASUREMENT_UNIT;
	}
	public void setMEASUREMENT_UNIT(String mEASUREMENT_UNIT) {
		MEASUREMENT_UNIT = mEASUREMENT_UNIT;
	}
	public String getINFO() {
		return INFO;
	}
	public void setINFO(String iNFO) {
		INFO = iNFO;
	}



}
