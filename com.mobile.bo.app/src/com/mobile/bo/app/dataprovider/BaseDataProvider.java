package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.database.app.DBHelper;
import com.mobile.database.app.entities.AMOS_DOCUMENT_UPLOAD;
import com.mobile.database.app.entities.AMOS_EMAIL;
import com.mobile.database.app.entities.APPR_COLLATERAL;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_HISTORY_WORKFLOW;
import com.mobile.database.app.entities.APPR_INBOXS;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_SAMPLING_BANGUNAN_INT;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_SERTIFIKAT;
import com.mobile.database.app.entities.APPR_STATUS;
import com.mobile.database.app.entities.APPR_VALBANGUNAN;
import com.mobile.database.app.entities.APPR_VHC_PEMBANDING_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_DATA_INT;
import com.mobile.database.app.entities.APPR_RTB_DETAIL_INT;
import com.mobile.database.app.entities.APPR_RTB_PEMBANDING_INT;
import com.mobile.database.app.entities.APPR_RTB_PROGRESS_BANGUNAN_INT;
import com.mobile.database.app.entities.APPR_RTB_PROGRESS_DEVELOPER_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_DATA_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.ATTACHMENT;
import com.mobile.database.app.entities.ATTACHMENT_FILE;
import com.mobile.database.app.entities.BLACKBOX;
import com.mobile.database.app.entities.CONFIGSYNCHRONIZATION;
import com.mobile.database.app.entities.DETAILTABUNGAN;
import com.mobile.database.app.entities.FOLLOWUP;
import com.mobile.database.app.entities.GEOLOCATION;
import com.mobile.database.app.entities.LOGINHISTORY;
import com.mobile.database.app.entities.LOV;
import com.mobile.database.app.entities.MESSAGE;
import com.mobile.database.app.entities.ATTACHMENT;
import com.mobile.database.app.entities.USER;
import com.mobile.database.app.entities.NEWS;
import com.mobile.database.app.entities.PROSPEK;
import com.mobile.database.app.entities.SCHEDULE;
import com.mobile.database.app.entities.STATEHISTORY;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_NEGATIVELIST_INT;

import com.mobile.database.app.entities.AMOS_ENTRY_DEBITUR_INT; // dsppk


public abstract class BaseDataProvider {
	private DBHelper db;
	private Dao<USER, String> daoUSER = null;
	private Dao<APPR_MAIN, String> daoAPPR_MAIN = null;
	private Dao<ATTACHMENT, String> daoATTACHMENT = null;
	private Dao<LOV, String> daoLOV = null;
	private Dao<CONFIGSYNCHRONIZATION, String> daoCONFIGSYNCHRONIZATION = null;
	private Dao<LOGINHISTORY, String> daoLOGINHISTORY = null;
	private Dao<GEOLOCATION, String> daoGEOLOCATION = null;
	private Dao<SCHEDULE, String> daoSCHEDULE = null;
	private Dao<APPR_VHC_PEMBANDING_INT, String> daoAPPR_PB_PEMBANDING_INT = null;
	private Dao<APPR_RTB_CEK_TATA_KOTA_INT, String> daoAPPR_RTB_CEK_TATA_KOTA_INT = null;
	private Dao<APPR_RTB_DATA_INT, String> daoAPPR_RTB_DATA_INT = null;
	private Dao<APPR_RTB_DETAIL_INT, String> daoAPPR_RTB_DETAIL_INT = null;
	private Dao<APPR_RTB_PROGRESS_BANGUNAN_INT, String> daoAPPR_RTB_PROGRESS_BANGUNAN_INT = null;
	private Dao<APPR_RTB_PROGRESS_DEVELOPER_INT, String> daoAPPR_RTB_PROGRESS_DEVELOPER_INT = null;
	private Dao<APPR_RTB_VALUATION_INT, String> daoAPPR_RTB_VALUATION_INT = null;
	private Dao<APPR_VHC_DATA_INT, String> daoAPPR_VHC_DATA_INT = null;
	private Dao<APPR_VHC_VALUATION_INT, String> daoAPPR_VHC_VALUATION_INT = null;
	private Dao<APPR_PB_VALUATION_INT, String> daoAPPR_PB_VALUATION_INT = null;
	private Dao<APPR_MCH_VALUATION_INT, String> daoAPPR_MCH_VALUATION_INT = null;
	private Dao<APPR_INBOXS, String> daoAPPR_INBOXS = null;
	private Dao<APPR_RTB_PEMBANDING_INT, String> daoAPPR_RTB_PEMBANDING_INT = null;
	
	private Dao<APPR_VHC_PEMBANDING_INT, String> daoAPPR_VHC_PEMBANDING_INT = null;
	private Dao<APPR_DOKUMENT, String> daoAPPR_DOKUMENT = null;
	private Dao<APPR_NEGATIVELIST_INT, String> daoAPPR_NEGATIVELIST_INT = null;
	private Dao<APPR_RTB_IMB_INT, String> daoRTB_IMB_INT = null;
	private Dao<APPR_SERTIFIKAT, String> daoAPPR_SERTIFIKAT = null;
	private Dao<APPR_HISTORY, String> daoAPPR_HISTORY = null;
	private Dao<APPR_HISTORY_WORKFLOW, String> daoAPPR_HISTORY_WORKFLOW = null;
	private Dao<com.mobile.database.app.entities.APPR_RTB_IMB_INT, String> daoAPPR_RTB_IMB_INT;
	private Dao<com.mobile.database.app.entities.APPR_COLLATERAL, String> daoAPPR_COLLATERAL;
	private Dao<com.mobile.database.app.entities.APPR_VALBANGUNAN, String> daoAPPR_VALBANGUNAN;
	private Dao<com.mobile.database.app.entities.APPR_PB_SAMPLING_BANGUNAN_INT, String> daoAPPR_PB_SAMPLING_BANGUNAN_INT;
	private Dao<com.mobile.database.app.entities.ATTACHMENT_FILE, String> daoATTACHMENT_FILE;
	private Dao<com.mobile.database.app.entities.APPR_STATUS, String> daoAPPRS_STATUS;
	private Dao<com.mobile.database.app.entities.AMOS_EMAIL, String> daoAMOS_EMAIL;
	
	private Dao<AMOS_ENTRY_DEBITUR_INT, String> daoAMOS_ENTRY_DEBITUR_INT = null; // dsppk
	private Dao<AMOS_DOCUMENT_UPLOAD, String> daoAMOS_DOCUMENT_UPLOAD = null; // dsppk
	
	public BaseDataProvider() {
		init();
	}
	
	private void init() {
		if (DataProviderManager.getAttachedContext() == null) {
			throw new NullPointerException("Can't get attached context for database");
		}
		
		db = DBHelper.getInstance(DataProviderManager.getAttachedContext());
		try {
			daoUSER = db.getUSER();
			//daoAPPR_MAIN =db.getAPPR_MAIN();
			daoCONFIGSYNCHRONIZATION =db.getCONFIGSYNCHRONIZATION();
			/*daoAPPR_RTB_VALUATION_INT = db.getAPPR_RTB_VALUATION_INT();
			daoAPPR_PB_VALUATION_INT = db.getAPPR_PB_VALUATION_INT();
			daoAPPR_MCH_VALUATION_INT = db.getAPPR_MCH_VALUATION_INT();
			daoAPPR_VHC_VALUATION_INT = db.getAPPR_VHC_VALUATION_INT();*/
			daoLOV = db.getLOV();
	/*		daoAPPR_VHC_DATA_INT=db.getAPPR_VHC_DATA_INT();
			daoAPPR_RTB_DATA_INT=db.getAPPR_RTB_DATA_INT();
			daoAPPR_RTB_PROGRESS_BANGUNAN_INT=db.getAPPR_RTB_PROGRESS_BANGUNAN_INT();
			daoAPPR_RTB_PROGRESS_DEVELOPER_INT=db.getAPPR_RTB_PROGRESS_DEVELOPER_INT();
			daoAPPR_RTB_DETAIL_INT=db.getAPPR_RTB_DETAIL_INT();
			daoAPPR_RTB_CEK_TATA_KOTA_INT = db.getAPPR_RTB_CEK_TATA_KOTA_INT();
			daoAPPR_INBOXS=db.getAPPR_INBOXS();
			
			daoAPPR_RTB_PEMBANDING_INT=db.getAPPR_RTB_PEMBANDING_INT();
			daoAPPR_VHC_PEMBANDING_INT=db.getAPPR_VHC_PEMBANDING_INT();
			
			daoAPPR_DOKUMENT=db.getAPPR_DOKUMENT();
			daoAPPR_NEGATIVELIST_INT=db.getAPPR_NEGATIVELIST_INT();
			daoAPPR_HISTORY=db.getAPPR_HISTORY();
			daoAPPR_HISTORY_WORKFLOW=db.getAPPR_HISTORY_WORKFLOW();
			daoAPPR_RTB_IMB_INT=db.getAPPR_RTB_IMB_INT();
			daoAPPR_SERTIFIKAT=db.getAPPR_SERTIFIKAT();
			daoAPPR_COLLATERAL=db.getAPPR_COLLATERAL();
			daoAPPR_VALBANGUNAN=db.getAPPR_VALBANGUNAN();
			daoAPPR_PB_SAMPLING_BANGUNAN_INT=db.getAPPR_PB_SAMPLING_BANGUNAN_INT();*/
			daoATTACHMENT=db.getATTACHMENT();
			daoATTACHMENT_FILE=db.getATTACHMENT_FILE();
			daoSCHEDULE=db.getSchedule();
			daoAMOS_EMAIL=db.getAMOS_EMAIL();
			//daoAPPRS_STATUS=db.getAPPR_STATUS();
			
			daoAMOS_ENTRY_DEBITUR_INT = db.getAMOS_ENTRY_DEBITUR_INT();
			daoAMOS_DOCUMENT_UPLOAD = db.getAMOS_DOCUMENT_UPLOAD();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected DBHelper getDb() {
		return db;
	}
	protected boolean isDaoMstUserExist() {
		return (daoUSER != null ? true: false);
	}
	protected boolean isDaoAPPR_STATUSExist() {
		return (daoAPPRS_STATUS != null ? true : false);
	}
	protected boolean isDaoAPPR_MAINExist() {
		return (daoAPPR_MAIN != null ? true : false);
	}
	protected boolean isDaoAPPR_RTB_VALUATION_INTExist() {
		return (daoAPPR_RTB_VALUATION_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_PB_PEMBANDING_INTExist() {
		return (daoAPPR_PB_PEMBANDING_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_PB_VALUATION_INTExist() {
		return (daoAPPR_PB_VALUATION_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_MCH_VALUATION_INTExist() {
		return (daoAPPR_MCH_VALUATION_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_VHC_DATA_INTExist() {
		return (daoAPPR_VHC_DATA_INT != null ? true : false);
	}
	protected boolean isDaoLOVExist() {
		return (daoLOV != null ? true : false);
	}
	protected boolean isDaoAPPR_VHC_VALUATION_INTExist() {
		return (daoAPPR_VHC_VALUATION_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_RTB_DATA_INTExist() {
		return (daoAPPR_RTB_DATA_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_RTB_PROGRESS_BANGUNAN_INTExist() {
		return (daoAPPR_RTB_PROGRESS_BANGUNAN_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_RTB_PROGRESS_DEVELOPER_INTExist() {
		return (daoAPPR_RTB_PROGRESS_DEVELOPER_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_RTB_DETAIL_INTExist() {
		return (daoAPPR_RTB_DETAIL_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_RTB_CEK_TATA_KOTA_INTExist() {
		return (daoAPPR_RTB_CEK_TATA_KOTA_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_INBOXExist() {
		return (daoAPPR_INBOXS != null ? true : false);
	}	
	protected boolean isDaoAPPR_RTB_PEMBANDING_INTExist() {
		return (daoAPPR_RTB_PEMBANDING_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_VHC_PEMBANDING_INTExist() {
		return (daoAPPR_VHC_PEMBANDING_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_DOKUMENTExist() {
		return (daoAPPR_DOKUMENT != null ? true : false);
	}
	protected boolean isDaoAPPR_NEGATIVELIST_INTExist() {
		return (daoAPPR_NEGATIVELIST_INT != null ? true : false);
	}
	protected boolean isDaoAPPR_HISTORYExist() {
		return (daoAPPR_HISTORY != null ? true : false);
	}
	protected boolean isDaoAPPR_HISTORY_WORKFLOWExist() {
		return (daoAPPR_HISTORY_WORKFLOW != null ? true : false);
	}
	protected boolean isDaoAPPR_RTB_IMB_INTExist() {
		return (daoAPPR_RTB_IMB_INT != null ? true : false);
	}
	
	protected boolean isDaoAPPR_SERTIFIKATExist() {
		return (daoAPPR_SERTIFIKAT != null ? true : false);
	}
	protected boolean isDaoAPPR_COLLATERALExist() {
		return (daoAPPR_COLLATERAL != null ? true : false);
	}
	protected boolean isDaoAPPR_VALBANGUNANExist() {
		return (daoAPPR_VALBANGUNAN != null ? true : false);
	}
	protected boolean isDaoAPPR_PB_SAMPLING_BANGUNAN_INTExist() {
		return (daoAPPR_PB_SAMPLING_BANGUNAN_INT != null ? true : false);
	}
	protected boolean isDaoSCHEDULEExist() {
		return (daoSCHEDULE != null ? true : false);
	}
	protected boolean isDaoConfigSynchronizationExist() {
		return (daoCONFIGSYNCHRONIZATION != null ? true : false);
	}
	protected boolean isDaoATTACHMENT_FILEExist() {
		return (daoATTACHMENT_FILE != null ? true : false);
	}
	protected boolean isDaoAMOS_EMAILExist() {
		return (daoAMOS_EMAIL != null ? true : false);
	}
	
	protected boolean isDaoAMOS_ENTRY_DEBITUR_INTExist() {
		return (daoAMOS_ENTRY_DEBITUR_INT != null ? true : false); // dsppk
	}
	
	protected boolean isDaoAMOS_DOCUMENT_UPLOADExist() {
		return (daoAMOS_DOCUMENT_UPLOAD != null ? true : false); // dsppk
	}
	
	/*
	protected boolean isDaoMESSAGEExist() {
		return (daoMESSAGE != null ? true : false);
	}
	protected boolean isDaoNEWSExist() {
		return (daoNEWS != null ? true : false);
	}
	protected boolean isDaoSTATEHISTORYExist() {
		return (daoSTATEHISTORY != null ? true : false);
	}
	
	protected boolean isDaoBLACKBOXExist() {
		return (daoBLACKBOX != null ? true : false);
	}	
	protected boolean isDaoTABUNGANExist() {
		return (daoTABUNGAN != null ? true : false);
	}
	protected boolean isDaoTAGIHANExist() {
		return (daoTAGIHAN != null ? true : false);
	}
	protected boolean isDaoGEOLOCATIONExist() {
		return (daoGEOLOCATION != null ? true : false);
	}
	
	
	protected boolean isDaoLoginHistoryExist() {
		return (daoLOGINHISTORY != null ? true : false);
	}
	protected boolean isDaoDetailTabunganExist() {
		return (daoDETAILTABUNGAN != null ? true : false);
	}
	
	
	*/
	////
	protected boolean isDaoATTACHMENTExist() {
		return (daoATTACHMENT != null ? true : false);
	}
	protected Dao<APPR_STATUS, String> getDoaAPPR_STATUS() {
		return daoAPPRS_STATUS;
	}
	protected Dao<APPR_MAIN, String> getDoaAPPR_MAIN() {
		return daoAPPR_MAIN;
	}
	protected Dao<APPR_RTB_VALUATION_INT, String> getDoaAPPR_RTB_VALUATION_INT() {
		return daoAPPR_RTB_VALUATION_INT;
	}
	public Dao<LOV, String> getDaoLOV() {
		return daoLOV;
	}
	protected Dao<APPR_PB_VALUATION_INT, String> getDoaAPPR_PB_VALUATION_INT() {
		return daoAPPR_PB_VALUATION_INT;
	}
	protected Dao<APPR_MCH_VALUATION_INT, String> getDoaAPPR_MCH_VALUATION_INT() {
		return daoAPPR_MCH_VALUATION_INT;
	}
	protected Dao<APPR_VHC_VALUATION_INT, String> getDoaAPPR_VHC_VALUATION_INT() {
		return daoAPPR_VHC_VALUATION_INT;
	}
	protected Dao<APPR_VHC_DATA_INT, String> getDoaAPPR_VHC_DATA_INT() {
		return daoAPPR_VHC_DATA_INT;
	}
	protected Dao<APPR_RTB_DATA_INT, String> getDoaAPPR_RTB_DATA_INT() {
		return daoAPPR_RTB_DATA_INT;
	}
	protected Dao<APPR_RTB_PROGRESS_BANGUNAN_INT, String> getDoaAPPR_RTB_PROGRESS_BANGUNAN_INT() {
		return daoAPPR_RTB_PROGRESS_BANGUNAN_INT;
		
	}
	protected Dao<APPR_RTB_PROGRESS_DEVELOPER_INT, String> getDoaAPPR_RTB_PROGRESS_DEVELOPER_INT() {
		return daoAPPR_RTB_PROGRESS_DEVELOPER_INT;
		
	}
	protected Dao<APPR_RTB_DETAIL_INT, String> getDoaAPPR_RTB_DETAIL_INT() {
		return daoAPPR_RTB_DETAIL_INT;
		
	}
	protected Dao<APPR_RTB_CEK_TATA_KOTA_INT, String> getDoaAPPR_RTB_CEK_TATA_KOTA_INT() {
		return daoAPPR_RTB_CEK_TATA_KOTA_INT;
		
	}
	protected Dao<APPR_INBOXS, String> getdoaAPPR_INBOXS() {
		return daoAPPR_INBOXS;
		
	}
	protected Dao<USER, String> getdoaUSER() {
		return daoUSER;
		
	}
	public Dao<ATTACHMENT, String> getDaoATTACHMENT() {
		return daoATTACHMENT;
	}
	
	public Dao<APPR_RTB_PEMBANDING_INT, String> getAPPR_RTB_PEMBANDING_INT() {
		return daoAPPR_RTB_PEMBANDING_INT;
	}
	public Dao<APPR_VHC_PEMBANDING_INT, String> getAPPR_VHC_PEMBANDING_INT() {
		return daoAPPR_VHC_PEMBANDING_INT;
	}
	public Dao<APPR_DOKUMENT, String> getDoaAPPR_DOKUMENT() {
		return daoAPPR_DOKUMENT;
	}
	public Dao<APPR_NEGATIVELIST_INT, String> getDoaAPPR_NEGATIVELIST_INT() {
		return daoAPPR_NEGATIVELIST_INT;
	}
	public Dao<APPR_HISTORY, String> getDoaAPPR_HISTORY() {
		return daoAPPR_HISTORY;
	}
	public Dao<APPR_HISTORY_WORKFLOW, String> getDoaAPPR_HISTORY_WORKFLOW() {
		return daoAPPR_HISTORY_WORKFLOW;
	}
	public Dao<APPR_RTB_IMB_INT, String> getDoaAPPR_RTB_IMB_INT() {
		return daoAPPR_RTB_IMB_INT;
	}
	public Dao<APPR_SERTIFIKAT, String> getDoaAPPR_SERTIFIKAT() {
		return daoAPPR_SERTIFIKAT;
	}
	public Dao<APPR_COLLATERAL, String> getDoaAPPR_COLLATERAL() {
		return daoAPPR_COLLATERAL;
	}
	public Dao<APPR_VALBANGUNAN, String> getDoaAPPR_VALBANGUNAN() {
		return daoAPPR_VALBANGUNAN;
	}
	public Dao<APPR_PB_SAMPLING_BANGUNAN_INT, String> getDoaAPPR_PB_SAMPLING_BANGUNAN_INT() {
		return daoAPPR_PB_SAMPLING_BANGUNAN_INT;
	}
	public Dao<SCHEDULE, String> getDaoSCHEDULE() {
		return daoSCHEDULE;
	}
	public Dao<CONFIGSYNCHRONIZATION, String> getDaoCONFIGSYNCHRONIZATION() {
		return daoCONFIGSYNCHRONIZATION;
	}
	public Dao<ATTACHMENT_FILE, String> getDaoATTACHMENT_FILE() {
		return daoATTACHMENT_FILE;
	}
	public Dao<AMOS_EMAIL, String> getDaoAMOS_EMAIL() {
		return daoAMOS_EMAIL;
	}
	public Dao<AMOS_ENTRY_DEBITUR_INT, String> getAMOS_ENTRY_DEBITUR_INT() {
		return daoAMOS_ENTRY_DEBITUR_INT; // dsppk
	}
	
	public Dao<AMOS_DOCUMENT_UPLOAD, String> getAMOS_DOCUMENT_UPLOAD() {
		return daoAMOS_DOCUMENT_UPLOAD; // dsppk
	}
	
	/*
	protected Dao<USER, String> getDaoMstUser() {
		return daoMstUser;
	}
	
	public Dao<FOLLOWUP, String> getDaoFOLLOWUP() {
		return daoFOLLOWUP;
	}

	public Dao<PROSPEK, String> getDaoPROSPEK() {
		return daoPROSPEK;
	}

	
	
	public Dao<MESSAGE, String> getDaoMESSAGE() {
		return daoMESSAGE;
	}
	
	public Dao<NEWS, String> getDaoNEWS() {
		return daoNEWS;
	}
	public Dao<STATEHISTORY, String> getDaoSTATEHISTORY() {
		return daoSTATEHISTORY;
	}
	public Dao<SCHEDULE, String> getDaoSCHEDULE() {
		return daoSCHEDULE;
	}
	public Dao<BLACKBOX, String> getDaoBLACKBOX() {
		return daoBLACKBOX;
	}
	public Dao<TABUNGAN, String> getDaoTABUNGAN() {
		return daoTABUNGAN;
	}
	public Dao<TAGIHAN, String> getDaoTAGIHAN() {
		return daoTAGIHAN;
	}
	public Dao<GEOLOCATION, String> getDaoGEOLOCATION() {
		return daoGEOLOCATION;
	}
	
	
	
	public Dao<LOGINHISTORY, String> getDaoLOGINHISTORY() {
		return daoLOGINHISTORY;
	}
	
	public Dao<DETAILTABUNGAN, String> getDaoDETAILTABUNGAN() {
		return daoDETAILTABUNGAN;
	}
	

	public void deleteRecordsInTables() {
		
		
		if (isDaoMstUserExist()) {
			DeleteBuilder<USER, String> dBuilder1 = getDaoMstUser().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("USERID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		
		if (isDaoFOLLOWUPExist()) {
			DeleteBuilder<FOLLOWUP, String> dBuilder1 = getDaoFOLLOWUP().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		if (isDaoPROSPEKExist()) {
			DeleteBuilder<PROSPEK, String> dBuilder1 = getDaoPROSPEK().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		
		if (isDaoLOVExist()) {
			DeleteBuilder<LOV, String> dBuilder1 = getDaoLOV().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		if (isDaoMESSAGEExist()) {
			DeleteBuilder<MESSAGE, String> dBuilder1 = getDaoMESSAGE().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		if (isDaoNEWSExist()) {
			DeleteBuilder<NEWS, String> dBuilder1 = getDaoNEWS().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		if (isDaoSTATEHISTORYExist()) {
			DeleteBuilder<STATEHISTORY, String> dBuilder1 = getDaoSTATEHISTORY().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		if (isDaoSCHEDULEExist()) {
			DeleteBuilder<SCHEDULE, String> dBuilder1 = getDaoSCHEDULE().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		if (isDaoBLACKBOXExist()) {
			DeleteBuilder<BLACKBOX, String> dBuilder1 = getDaoBLACKBOX().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		if (isDaoTABUNGANExist()) {
			DeleteBuilder<TABUNGAN, String> dBuilder1 = getDaoTABUNGAN().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("NOMORREKENING").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		if (isDaoTAGIHANExist()) {
			DeleteBuilder<TAGIHAN, String> dBuilder1 = getDaoTAGIHAN().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		if (isDaoGEOLOCATIONExist()) {
			DeleteBuilder<GEOLOCATION, String> dBuilder1 = getDaoGEOLOCATION().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		if (isDaoConfigSynchronizationExist()) {
			DeleteBuilder<CONFIGSYNCHRONIZATION, String> dBuilder1 = getDaoCONFIGSYNCHRONIZATION().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		if (isDaoLoginHistoryExist()) {
			DeleteBuilder<LOGINHISTORY, String> dBuilder1 = getDaoLOGINHISTORY().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		if (isDaoDetailTabunganExist()) {
			DeleteBuilder<DETAILTABUNGAN, String> dBuilder1 = getDaoDETAILTABUNGAN().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("NOTABUNGAN").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
		
		if (isDaoPhotoExist()) {
			DeleteBuilder<PHOTO, String> dBuilder1 = getDaoPHOTO().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
	}
	*/
	public void release() {
		daoAPPR_MAIN = null;
		/*daoFOLLOWUP=null;
		daoPROSPEK=null;
		daoLOV=null;
		daoMESSAGE=null;
		daoNEWS=null;
		daoSCHEDULE=null;
		daoSTATEHISTORY=null;
		daoBLACKBOX=null;
		daoTABUNGAN=null;
		daoTAGIHAN=null;
		daoGEOLOCATION=null;
		daoCONFIGSYNCHRONIZATION=null;
		daoLOGINHISTORY=null;
		daoDETAILTABUNGAN=null;
		daoPHOTO = null;*/
		DBHelper.repleaseInstance();
	}
}
