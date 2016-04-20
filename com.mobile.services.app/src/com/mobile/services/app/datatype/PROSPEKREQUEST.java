package com.mobile.services.app.datatype;

import java.io.Serializable;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.mobile.bo.app.dataprovider.FollowUpDataProvider;
import com.mobile.bo.app.datatype.FollowupData;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.framework.common.DateFormatter;

public class PROSPEKREQUEST implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6591761474507211697L;
	private String ID;
	private String PROSPEKID;
    private String USERID;		
    private String LATITUDE;
    private String LONGITUDE;
    private String DATE;		
    private String TIME ;		
    private String NAMAUSAHA ;		
    private String ALAMATUSAHA ;		
    private String JENISUSAHA ;		
    private String RADIUS ;		
    private String KOMUNITAS ;
    private String NAMADEBITUR;
    private String TGLLAHIR;
    private String JENISPEMBIAYAAN;
    private String HANDPHONE;
    private String TELEPONRUMAH;
    private String ALAMATRUMAH;
    private String PLAFOND;
    private String KTP;
    private String NPWP;
    private String SIUPSKU;
    private String APREQNO;
    private String SUBMITDATE;
    private String STAGE;
    private String ISBLACKBOX ;
    private String ISUPLOADED ;
    private String ISPENDINGUPLOADED;
    private String UNIT;
    private ArrayList<FOLLOWUPDATAREQUEST> FOLLOWUP=new ArrayList<FOLLOWUPDATAREQUEST>();

    public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPROSPEKID() {
		return PROSPEKID;
	}
	public void setPROSPEKID(String pROSPEKID) {
		PROSPEKID = pROSPEKID;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getLATITUDE() {
		return LATITUDE;
	}
	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}
	public String getLONGITUDE() {
		return LONGITUDE;
	}
	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public String getTIME() {
		return TIME;
	}
	public void setTIME(String tIME) {
		TIME = tIME;
	}
	public String getNAMAUSAHA() {
		return NAMAUSAHA;
	}
	public void setNAMAUSAHA(String nAMAUSAHA) {
		NAMAUSAHA = nAMAUSAHA;
	}
	public String getALAMATUSAHA() {
		return ALAMATUSAHA;
	}
	public void setALAMATUSAHA(String aLAMATUSAHA) {
		ALAMATUSAHA = aLAMATUSAHA;
	}
	public String getJENISUSAHA() {
		return JENISUSAHA;
	}
	public void setJENISUSAHA(String jENISUSAHA) {
		JENISUSAHA = jENISUSAHA;
	}
	public String getRADIUS() {
		return RADIUS;
	}
	public void setRADIUS(String rADIUS) {
		RADIUS = rADIUS;
	}
	public String getKOMUNITAS() {
		return KOMUNITAS;
	}
	public void setKOMUNITAS(String kOMUNITAS) {
		KOMUNITAS = kOMUNITAS;
	}
	public String getNAMADEBITUR() {
		return NAMADEBITUR;
	}
	public void setNAMADEBITUR(String nAMADEBITUR) {
		NAMADEBITUR = nAMADEBITUR;
	}
	public String getTGLLAHIR() {
		return TGLLAHIR;
	}
	public void setTGLLAHIR(String tGLLAHIR) {
		TGLLAHIR = tGLLAHIR;
	}
	public String getJENISPEMBIAYAAN() {
		return JENISPEMBIAYAAN;
	}
	public void setJENISPEMBIAYAAN(String jENISPEMBIAYAAN) {
		JENISPEMBIAYAAN = jENISPEMBIAYAAN;
	}
	public String getHANDPHONE() {
		return HANDPHONE;
	}
	public void setHANDPHONE(String hANDPHONE) {
		HANDPHONE = hANDPHONE;
	}
	public String getTELEPONRUMAH() {
		return TELEPONRUMAH;
	}
	public void setTELEPONRUMAH(String tELEPONRUMAH) {
		TELEPONRUMAH = tELEPONRUMAH;
	}
	public String getALAMATRUMAH() {
		return ALAMATRUMAH;
	}
	public void setALAMATRUMAH(String aLAMATRUMAH) {
		ALAMATRUMAH = aLAMATRUMAH;
	}
	public String getPLAFOND() {
		return PLAFOND;
	}
	public void setPLAFOND(String pLAFOND) {
		PLAFOND = pLAFOND;
	}
	public String getKTP() {
		return KTP;
	}
	public void setKTP(String kTP) {
		KTP = kTP;
	}
	public String getNPWP() {
		return NPWP;
	}
	public void setNPWP(String nPWP) {
		NPWP = nPWP;
	}
	public String getSIUPSKU() {
		return SIUPSKU;
	}
	public void setSIUPSKU(String sIUPSKU) {
		SIUPSKU = sIUPSKU;
	}
	public String getAPREQNO() {
		return APREQNO;
	}
	public void setAPREQNO(String aPREQNO) {
		APREQNO = aPREQNO;
	}
	public String getSUBMITDATE() {
		return SUBMITDATE;
	}
	public void setSUBMITDATE(String sUBMITDATE) {
		SUBMITDATE = sUBMITDATE;
	}
	public String getSTAGE() {
		return STAGE;
	}
	public void setSTAGE(String sTAGE) {
		STAGE = sTAGE;
	}
	public String isISBLACKBOX() {
		return ISBLACKBOX;
	}
	public void setISBLACKBOX(String iSBLACKBOX) {
		ISBLACKBOX = iSBLACKBOX;
	}
	public String isISUPLOADED() {
		return ISUPLOADED;
	}
	public void setISUPLOADED(String iSUPLOADED) {
		ISUPLOADED = iSUPLOADED;
	}
	
	public ArrayList<FOLLOWUPDATAREQUEST> getFOLLOWUP() {
		return FOLLOWUP;
	}
	public void setFOLLOWUP(ArrayList<FOLLOWUPDATAREQUEST> fOLLOWUP) {
		FOLLOWUP = fOLLOWUP;
	}
	public String getUNIT() {
		return UNIT;
	}
	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}
	public String getISUPLOADED() {
		return ISUPLOADED;
	}
	public String getISPENDINGUPLOADED() {
		return ISPENDINGUPLOADED;
	}
	
	public void setISPENDINGUPLOADED(String iSPENDINGUPLOADED) {
		ISPENDINGUPLOADED = iSPENDINGUPLOADED;
	}
	public String updateToJSONString(ArrayList<ProspekData> prospeks,int actiontype) throws Exception {   
		Gson gsonprospek =  new Gson();
		ArrayList<PROSPEKREQUEST> arrayProspekRequest=new ArrayList<PROSPEKREQUEST>();
		FollowUpDataProvider followUpDataProvider=new FollowUpDataProvider();
		// pending upload
		String valueIsUploaded ="0";
		String valueIsPendingUploaded ="0";
		
		// submit
		if (actiontype == 1){
			valueIsUploaded = "1";
			valueIsPendingUploaded = "0";
		}
		// pending submit
		else if (actiontype == 2){
			valueIsUploaded = "1";
			valueIsPendingUploaded = "1";
		}

        for (int i=0;i<prospeks.size();i++){
            PROSPEKREQUEST pd=new PROSPEKREQUEST();
        	ProspekData prospek= prospeks.get(i);
        	pd.setUSERID(prospek.getUSERID());
            pd.setID(prospek.getID().toString());
            pd.setLATITUDE(prospek.getLATITUDE());
            pd.setLONGITUDE(prospek.getLONGITUDE());
            pd.setDATE(DateFormatter.formatStringYYYYMMdd(prospek.getDATE(),false));
            pd.setTIME(prospek.getTIME());
            pd.setNAMAUSAHA(prospek.getNAMAUSAHA());
            pd.setALAMATUSAHA(prospek.getALAMATUSAHA());
            pd.setJENISUSAHA(prospek.getJENISUSAHA());
            pd.setRADIUS(prospek.getRADIUS());
            pd.setKOMUNITAS(prospek.getKOMUNITAS());
            pd.setNAMADEBITUR(prospek.getNAMADEBITUR());
            pd.setISUPLOADED(valueIsUploaded);
            pd.setISPENDINGUPLOADED(valueIsPendingUploaded);
            if (prospek.getTGLLAHIR() != null){
                pd.setTGLLAHIR(DateFormatter.formatStringYYYYMMdd(prospek.getTGLLAHIR(),false));
            }
            else{
                pd.setTGLLAHIR("");
            }
            pd.setJENISPEMBIAYAAN(prospek.getJENISPEMBIAYAAN());
            pd.setHANDPHONE(prospek.getHANDPHONE());
            pd.setTELEPONRUMAH(prospek.getTELEPONRUMAH());
            pd.setALAMATRUMAH(prospek.getALAMATRUMAH());
            pd.setPLAFOND(prospek.getPLAFOND());
            pd.setKTP(prospek.getKTP());
            pd.setNPWP(prospek.getNPWP());
            pd.setSIUPSKU(prospek.getSIUPSKU());	    
            pd.setISBLACKBOX(prospek.isISBLACKBOX()?"1":"0");            
            pd.setSTAGE(prospek.getSTAGE());
            pd.setPROSPEKID(prospek.getPROSPEKID());
            
            if (prospek.getSUBMITDATE() != null){
                pd.setSUBMITDATE(DateFormatter.formatStringYYYYMMdd(prospek.getSUBMITDATE(),false));
            }
            else{
            	pd.setSUBMITDATE("");
            }
            
            pd.setUNIT(prospek.getUNIT());
            
            /*ArrayList<FOLLOWUPDATAREQUEST> arrFollowUp=new ArrayList<FOLLOWUPDATAREQUEST>();          
            ArrayList<FollowupData> arrFollowUpData = followUpDataProvider.getFollowupDetailByParent(prospek.getID().toString(), prospek.getPREVIOUSSTAGE());
            for (int j=0;j< arrFollowUpData.size();j++){
            	FollowupData fu= arrFollowUpData.get(j);
            	FOLLOWUPDATAREQUEST fdr = new FOLLOWUPDATAREQUEST();
            	
            	fdr.setID(fu.getID().toString());
            	fdr.setUSERID(fu.getUSERID());
            	fdr.setSTAGE(fu.getSTAGE());
            	fdr.setSTATUS(fu.getSTATUS());
            	fdr.setCATATAN(fu.getCATATAN());
            	fdr.setISEDITABLE(fu.isEDITABLE()?"1":"0");
            	fdr.setNEXTFOLLOWUP(DateFormatter.formatStringYYYYMMdd(fu.getNEXTFOLLOWUP(),false));
            	fdr.setACTION(fu.getACTION());
            	fdr.setPARENTID(fu.getPARENTID());
            	fdr.setPROSPEKID(fu.getPROSPEKID());
            	
            	arrFollowUp.add(fdr);
            	fdr= null;
            }*/
            //pd.setFOLLOWUP(arrFollowUp);   
            arrayProspekRequest.add(pd);
            pd = null;
        }

        return gsonprospek.toJson(arrayProspekRequest).toString();
	}
	
	
	public String updateToJSONString(ArrayList<ProspekData> prospeks) throws Exception {   
		Gson gsonprospek =  new Gson();
		ArrayList<PROSPEKREQUEST> arrayProspekRequest=new ArrayList<PROSPEKREQUEST>();
		FollowUpDataProvider followUpDataProvider=new FollowUpDataProvider();
		
        for (int i=0;i<prospeks.size();i++){
            PROSPEKREQUEST pd=new PROSPEKREQUEST();
        	ProspekData prospek= prospeks.get(i);
        	pd.setUSERID(prospek.getUSERID());
            pd.setID(prospek.getID().toString());
            pd.setLATITUDE(prospek.getLATITUDE());
            pd.setLONGITUDE(prospek.getLONGITUDE());
            pd.setDATE(DateFormatter.formatStringYYYYMMdd(prospek.getDATE(),false));
            pd.setTIME(prospek.getTIME());
            pd.setNAMAUSAHA(prospek.getNAMAUSAHA());
            pd.setALAMATUSAHA(prospek.getALAMATUSAHA());
            pd.setJENISUSAHA(prospek.getJENISUSAHA());
            pd.setRADIUS(prospek.getRADIUS());
            pd.setKOMUNITAS(prospek.getKOMUNITAS());
            pd.setNAMADEBITUR(prospek.getNAMADEBITUR());
            pd.setISUPLOADED("0");
            pd.setISPENDINGUPLOADED("0");
            if (prospek.getTGLLAHIR() != null){
                pd.setTGLLAHIR(DateFormatter.formatStringYYYYMMdd(prospek.getTGLLAHIR(),false));
            }
            else{
                pd.setTGLLAHIR("");
            }
            pd.setJENISPEMBIAYAAN(prospek.getJENISPEMBIAYAAN());
            pd.setHANDPHONE(prospek.getHANDPHONE());
            pd.setTELEPONRUMAH(prospek.getTELEPONRUMAH());
            pd.setALAMATRUMAH(prospek.getALAMATRUMAH());
            pd.setPLAFOND(prospek.getPLAFOND());
            pd.setKTP(prospek.getKTP());
            pd.setNPWP(prospek.getNPWP());
            pd.setSIUPSKU(prospek.getSIUPSKU());	    
            pd.setISBLACKBOX(prospek.isISBLACKBOX()?"1":"0");            
            pd.setSTAGE(prospek.getSTAGE());
            pd.setPROSPEKID(prospek.getPROSPEKID());
            
            if (prospek.getSUBMITDATE() != null){
                pd.setSUBMITDATE(DateFormatter.formatStringYYYYMMdd(prospek.getSUBMITDATE(),false));
            }
            else{
            	pd.setSUBMITDATE("");
            }
            
            pd.setUNIT(prospek.getUNIT());
            
            /*ArrayList<FOLLOWUPDATAREQUEST> arrFollowUp=new ArrayList<FOLLOWUPDATAREQUEST>();          
            ArrayList<FollowupData> arrFollowUpData = followUpDataProvider.getPendingUpdatedFollowUp(prospek.getID().toString(), prospek.getPREVIOUSSTAGE());
            for (int j=0;j< arrFollowUpData.size();j++){
            	FollowupData fu= arrFollowUpData.get(j);
            	FOLLOWUPDATAREQUEST fdr = new FOLLOWUPDATAREQUEST();
            	
            	fdr.setID(fu.getID().toString());
            	fdr.setUSERID(fu.getUSERID());
            	fdr.setSTAGE(fu.getSTAGE());
            	fdr.setSTATUS(fu.getSTATUS());
            	fdr.setCATATAN(fu.getCATATAN());
            	fdr.setISEDITABLE(fu.isEDITABLE()?"1":"0");
            	fdr.setNEXTFOLLOWUP(DateFormatter.formatStringYYYYMMdd(fu.getNEXTFOLLOWUP(),false));
            	fdr.setACTION(fu.getACTION());
            	fdr.setPARENTID(fu.getPARENTID());
            	fdr.setPROSPEKID(fu.getPROSPEKID());
            	
            	arrFollowUp.add(fdr);
            	fdr= null;
            }
            pd.setFOLLOWUP(arrFollowUp);   
            arrayProspekRequest.add(pd);*/
            pd = null;
        }

        return gsonprospek.toJson(arrayProspekRequest).toString();
	}
	
	
	public String updateToJSONString(ProspekData prospek,FollowupData followUp) throws Exception {   
		Gson gsonprospek =  new Gson();
		ArrayList<PROSPEKREQUEST> arrayProspekRequest=new ArrayList<PROSPEKREQUEST>();
		ArrayList<FOLLOWUPDATAREQUEST> arrFollowUp=new ArrayList<FOLLOWUPDATAREQUEST>();  
		PROSPEKREQUEST pd=new PROSPEKREQUEST();
	    FOLLOWUPDATAREQUEST fdr = new FOLLOWUPDATAREQUEST();		
        
    	pd.setUSERID(prospek.getUSERID());
        pd.setID(prospek.getID().toString());
        pd.setLATITUDE(prospek.getLATITUDE());
        pd.setLONGITUDE(prospek.getLONGITUDE());
        pd.setDATE(DateFormatter.formatStringYYYYMMdd(prospek.getDATE(),false));
        pd.setTIME(prospek.getTIME());
        pd.setNAMAUSAHA(prospek.getNAMAUSAHA());
        pd.setALAMATUSAHA(prospek.getALAMATUSAHA());
        pd.setJENISUSAHA(prospek.getJENISUSAHA());
        pd.setRADIUS(prospek.getRADIUS());
        pd.setKOMUNITAS(prospek.getKOMUNITAS());
        pd.setNAMADEBITUR(prospek.getNAMADEBITUR());
        pd.setISUPLOADED("0");
        pd.setISPENDINGUPLOADED("0");
        if (prospek.getTGLLAHIR() != null){
            pd.setTGLLAHIR(DateFormatter.formatStringYYYYMMdd(prospek.getTGLLAHIR(),false));
        }
        else{
            pd.setTGLLAHIR("");
        }
        pd.setJENISPEMBIAYAAN(prospek.getJENISPEMBIAYAAN());
        pd.setHANDPHONE(prospek.getHANDPHONE());
        pd.setTELEPONRUMAH(prospek.getTELEPONRUMAH());
        pd.setALAMATRUMAH(prospek.getALAMATRUMAH());
        pd.setPLAFOND(prospek.getPLAFOND());
        pd.setKTP(prospek.getKTP());
        pd.setNPWP(prospek.getNPWP());
        pd.setSIUPSKU(prospek.getSIUPSKU());	    
        pd.setISBLACKBOX(prospek.isISBLACKBOX()?"1":"0");            
        pd.setSTAGE(prospek.getSTAGE());
        pd.setPROSPEKID(prospek.getPROSPEKID());
        
        if (prospek.getSUBMITDATE() != null){
            pd.setSUBMITDATE(DateFormatter.formatStringYYYYMMdd(prospek.getSUBMITDATE(),false));
        }
        else{
        	pd.setSUBMITDATE("");
        }
        
        pd.setUNIT(prospek.getUNIT());
        
      
    	// set data followup
        if (followUp != null)
        {       
	    	fdr.setID(followUp.getID().toString());
	    	fdr.setUSERID(followUp.getUSERID());
	    	fdr.setSTAGE(followUp.getSTAGE());
	    	fdr.setSTATUS(followUp.getSTATUS());
	    	fdr.setCATATAN(followUp.getCATATAN());
	    	fdr.setISEDITABLE(followUp.isEDITABLE()?"1":"0");
	    	fdr.setNEXTFOLLOWUP(DateFormatter.formatStringYYYYMMdd(followUp.getNEXTFOLLOWUP(),false));
	    	fdr.setACTION(followUp.getACTION());
	    	fdr.setPARENTID(followUp.getPARENTID());
	    	fdr.setPROSPEKID(followUp.getPROSPEKID());
	    	arrFollowUp.add(fdr);
	        pd.setFOLLOWUP(arrFollowUp);   
        }
        arrayProspekRequest.add(pd);

        return gsonprospek.toJson(arrayProspekRequest).toString();
	}
    
    
}
