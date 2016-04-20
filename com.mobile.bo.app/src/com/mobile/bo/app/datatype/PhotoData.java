package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.ATTACHMENT;

public class PhotoData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7967484269530763870L;
	public String ID  ;
	public String AP_REGNO  ;
	public String ATTACH_ID  ;
	public String ATTACH_SEQ  ;
	public String FILEFOLDER  ;
	public String FILENAME  ;
	public String FILETYPE  ;
	public String FILESIZE  ;
	public String UPLOADBY  ;
	public Date UPLOADDATE  ;
	public String ATTACH_TYPE;
	public String ATTACH_TYPE_CODE;
	public String COL_ID;
	public String ISALREADYUPLOADEDTOSERVER;
	public String ISALREADYDOWNLOD;
	
	
	public PhotoData(){
		update( "",
				"",
				"",
				"",
				"",
				"",
				"",
				"",
				"",
				null,"","","","","");
	}

	public PhotoData(ATTACHMENT photo) {
		update(photo);
	}
	
	
	public ATTACHMENT toRowData(){
		ATTACHMENT rowData= new ATTACHMENT();
		rowData.setID(ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setATTACH_ID(ATTACH_ID);
		rowData.setATTACH_SEQ(ATTACH_SEQ);
		rowData.setFILEFOLDER(FILEFOLDER);
		rowData.setFILENAME(FILENAME);
		rowData.setFILETYPE(FILETYPE);
		rowData.setFILESIZE(FILESIZE);
		rowData.setUPLOADBY(UPLOADBY);
		rowData.setUPLOADDATE(UPLOADDATE);
		rowData.setATTACH_TYPE(ATTACH_TYPE);
		rowData.setATTACH_TYPE_CODE(ATTACH_TYPE_CODE);
		rowData.setCOL_ID(COL_ID);
		rowData.setISALREADYUPLOADEDTOSERVER(ISALREADYUPLOADEDTOSERVER);
		rowData.setISALREADYDOWNLOD(ISALREADYDOWNLOD);
		
		return rowData;
	}
	
	public void update(ATTACHMENT rowData) {
		ID  =rowData.getID();
		AP_REGNO=rowData.getAP_REGNO();
		ATTACH_ID=rowData.getATTACH_ID();
		ATTACH_SEQ=rowData.getATTACH_SEQ();
		FILEFOLDER=rowData.getFILEFOLDER();
		FILENAME=rowData.getFILENAME();
		FILETYPE=rowData.getFILETYPE();
		FILESIZE=rowData.getFILESIZE();
		UPLOADBY=rowData.getUPLOADBY();
		UPLOADDATE=rowData.getUPLOADDATE();
		ATTACH_TYPE=rowData.getATTACH_TYPE();
		ATTACH_TYPE_CODE=rowData.getATTACH_TYPE_CODE();
		COL_ID=rowData.getCOL_ID();
		ISALREADYUPLOADEDTOSERVER=rowData.getISALREADYUPLOADEDTOSERVER();
		ISALREADYDOWNLOD=rowData.getISALREADYDOWNLOD();
		
		
	}
	
	
	public void updatePhotoBlackboxFromJSON(JSONObject obj) throws Exception{
		ID  =obj.getString("ID");
		AP_REGNO=obj.getString("AP_REGNO");
		ATTACH_ID=obj.getString("ATTACH_ID");
		ATTACH_SEQ=obj.getString("ATTACH_SEQ");
		FILEFOLDER=obj.getString("FILEFOLDER");
		FILENAME=obj.getString("FILENAME");
		FILETYPE=obj.getString("FILETYPE");
		FILESIZE=obj.getString("FILESIZE");
		UPLOADBY=obj.getString("UPLOADBY");
		UPLOADDATE= DataConverter.stringToDate(obj.getString("UPLOADDATE"));
		ATTACH_TYPE=obj.getString("ATTACH_TYPE");
		ATTACH_TYPE_CODE=obj.getString("ATTACH_TYPE_CODE");
		COL_ID=obj.getString("COL_ID");
		ISALREADYUPLOADEDTOSERVER= obj.getString("ISALREADYUPLOADEDTOSERVER"); 
		ISALREADYDOWNLOD=obj.getString("ISALREADYDOWNLOD");
	}
	public void update(String id,String ap_regno,
			String attach_id,
			String attach_seq,
			String filefolder,
			String filename,
			String filetype,
			String filesize,
			String uploadby,
			Date uploaddate,
			String attach_type,
			String attach_type_code,
			String col_id,
			String iSALREADYUPLOADEDTOSERVER,
			String iSALREADYDOWNLOD
			){
		ID=id;
		AP_REGNO=ap_regno;
		ATTACH_ID=attach_id;
		ATTACH_SEQ=attach_seq;
		FILEFOLDER=filefolder;
		FILENAME=filename;
		FILETYPE=filetype;
		FILESIZE=filesize;
		UPLOADBY=uploadby;
		UPLOADDATE=uploaddate;
		ATTACH_TYPE=attach_type;
		ATTACH_TYPE_CODE=attach_type_code;
		COL_ID=col_id;
		ISALREADYUPLOADEDTOSERVER= iSALREADYUPLOADEDTOSERVER; 
		ISALREADYDOWNLOD=iSALREADYDOWNLOD;

}
	
	public String getISALREADYUPLOADEDTOSERVER() {
		return ISALREADYUPLOADEDTOSERVER;
	}

	public void setISALREADYUPLOADEDTOSERVER(String iSALREADYUPLOADEDTOSERVER) {
		ISALREADYUPLOADEDTOSERVER = iSALREADYUPLOADEDTOSERVER;
	}

	public String getISALREADYDOWNLOD() {
		return ISALREADYDOWNLOD;
	}

	public void setISALREADYDOWNLOD(String iSALREADYDOWNLOD) {
		ISALREADYDOWNLOD = iSALREADYDOWNLOD;
	}

	public String getCOL_ID() {
		return COL_ID;
	}

	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}

	public String getATTACH_TYPE() {
		return ATTACH_TYPE;
	}

	public void setATTACH_TYPE(String aTTACH_TYPE) {
		ATTACH_TYPE = aTTACH_TYPE;
	}

	public String getATTACH_TYPE_CODE() {
		return ATTACH_TYPE_CODE;
	}

	public void setATTACH_TYPE_CODE(String aTTACH_TYPE_CODE) {
		ATTACH_TYPE_CODE = aTTACH_TYPE_CODE;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getATTACH_ID() {
		return ATTACH_ID;
	}

	public void setATTACH_ID(String aTTACH_ID) {
		ATTACH_ID = aTTACH_ID;
	}

	public String getATTACH_SEQ() {
		return ATTACH_SEQ;
	}

	public void setATTACH_SEQ(String aTTACH_SEQ) {
		ATTACH_SEQ = aTTACH_SEQ;
	}

	public String getFILEFOLDER() {
		return FILEFOLDER;
	}

	public void setFILEFOLDER(String fILEFOLDER) {
		FILEFOLDER = fILEFOLDER;
	}

	public String getFILENAME() {
		return FILENAME;
	}

	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
	}

	public String getFILETYPE() {
		return FILETYPE;
	}

	public void setFILETYPE(String fILETYPE) {
		FILETYPE = fILETYPE;
	}

	public String getFILESIZE() {
		return FILESIZE;
	}

	public void setFILESIZE(String fILESIZE) {
		FILESIZE = fILESIZE;
	}

	public String getUPLOADBY() {
		return UPLOADBY;
	}

	public void setUPLOADBY(String uPLOADBY) {
		UPLOADBY = uPLOADBY;
	}

	public Date getUPLOADDATE() {
		return UPLOADDATE;
	}

	public void setUPLOADDATE(Date uPLOADDATE) {
		UPLOADDATE = uPLOADDATE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
