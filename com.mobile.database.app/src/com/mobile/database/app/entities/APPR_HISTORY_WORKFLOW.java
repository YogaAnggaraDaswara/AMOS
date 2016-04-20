package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_HISTORY_WORKFLOW")
public class APPR_HISTORY_WORKFLOW {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_HISTORY_WORKFLOW_PK",dataType=DataType.STRING) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=100) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=100) private String ALT_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String ALT_DESC;
	@DatabaseField(dataType=DataType.STRING,width=100) private String TR_CODE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String TR_DESC;
	@DatabaseField(dataType=DataType.STRING,width=100) private String TR_BY;
	@DatabaseField(dataType=DataType.STRING,width=100) private String TR_START;
	@DatabaseField(dataType=DataType.STRING,width=100) private String TR_END;
	@DatabaseField(dataType=DataType.STRING,width=100) private String AGING;
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
	public String getALT_TYPE() {
		return ALT_TYPE;
	}
	public void setALT_TYPE(String aLT_TYPE) {
		ALT_TYPE = aLT_TYPE;
	}
	public String getALT_DESC() {
		return ALT_DESC;
	}
	public void setALT_DESC(String aLT_DESC) {
		ALT_DESC = aLT_DESC;
	}
	public String getTR_CODE() {
		return TR_CODE;
	}
	public void setTR_CODE(String tR_CODE) {
		TR_CODE = tR_CODE;
	}
	public String getTR_DESC() {
		return TR_DESC;
	}
	public void setTR_DESC(String tR_DESC) {
		TR_DESC = tR_DESC;
	}
	public String getTR_BY() {
		return TR_BY;
	}
	public void setTR_BY(String tR_BY) {
		TR_BY = tR_BY;
	}
	public String getTR_START() {
		return TR_START;
	}
	public void setTR_START(String tR_START) {
		TR_START = tR_START;
	}
	public String getTR_END() {
		return TR_END;
	}
	public void setTR_END(String tR_END) {
		TR_END = tR_END;
	}
	public String getAGING() {
		return AGING;
	}
	public void setAGING(String aGING) {
		AGING = aGING;
	}



}
