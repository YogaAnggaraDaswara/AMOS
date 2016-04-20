package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_NEGATIVELIST_INT")
public class APPR_NEGATIVELIST_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_NEGATIVELIST_INT_PK",dataType=DataType.STRING,width=30) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=4) private String NEG_SEQ;
	@DatabaseField(dataType=DataType.STRING,width=10) private String NEG_CODE;
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
	public String getNEG_SEQ() {
		return NEG_SEQ;
	}
	public void setNEG_SEQ(String nEG_SEQ) {
		NEG_SEQ = nEG_SEQ;
	}
	public String getNEG_CODE() {
		return NEG_CODE;
	}
	public void setNEG_CODE(String nEG_CODE) {
		NEG_CODE = nEG_CODE;
	}

	
	

	
	


}
