package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_STATUS")
public class APPR_STATUS {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_STATUS_PK",dataType=DataType.STRING) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=500) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=500) private String APPRS_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String STATUS;
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
	public String getCOL_ID() {
		return COL_ID;
	}
	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}
	public String getAPPRS_TYPE() {
		return APPRS_TYPE;
	}
	public void setAPPRS_TYPE(String aPPRS_TYPE) {
		APPRS_TYPE = aPPRS_TYPE;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	


}
