package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_RTB_IMB_INT")
public class APPR_RTB_IMB_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_RTB_IMB_INTS_PK",dataType=DataType.STRING,width=30) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=4) private String IMB_SEQ;
	@DatabaseField(dataType=DataType.STRING,width=20) private String IMB_NO;
	@DatabaseField(dataType=DataType.STRING,width=8) private String IMB_DATE;
	@DatabaseField(dataType=DataType.STRING,width=200) private String IMB_PURPOSE;
	public String getCOL_ID() {
		return COL_ID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}
	public String getIMB_SEQ() {
		return IMB_SEQ;
	}
	public void setIMB_SEQ(String iMB_SEQ) {
		IMB_SEQ = iMB_SEQ;
	}
	public String getIMB_NO() {
		return IMB_NO;
	}
	public void setIMB_NO(String iMB_NO) {
		IMB_NO = iMB_NO;
	}
	public Date getIMB_DATE() {
		return DataConverter.stringToDate(IMB_DATE);
	}
	public void setIMB_DATE(Date iMB_DATE) {
		IMB_DATE = DataConverter.dateToString(iMB_DATE);
	}
	public String getIMB_PURPOSE() {
		return IMB_PURPOSE;
	}
	public void setIMB_PURPOSE(String iMB_PURPOSE) {
		IMB_PURPOSE = iMB_PURPOSE;
	}

	


}
