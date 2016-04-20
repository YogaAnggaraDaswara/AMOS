package com.mobile.database.app;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import sm.mobile.database.surveylocation.R;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.LruObjectCache;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.mobile.database.app.entities.AMOS_DOCUMENT_UPLOAD;
import com.mobile.database.app.entities.AMOS_EMAIL;
import com.mobile.database.app.entities.AMOS_ENTRY_DEBITUR_INT;
import com.mobile.database.app.entities.APPR_COLLATERAL;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_INBOXS;
import com.mobile.database.app.entities.APPR_INBOXS_QUERY;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_NEGATIVELIST_INT;
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
import com.mobile.database.app.entities.TABUNGAN;
import com.mobile.database.app.entities.TAGIHAN;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_HISTORY_WORKFLOW;
@SuppressWarnings("unused")
public class DBHelper extends OrmLiteSqliteOpenHelper {
	
	public static int DATABASE_VERSION =10;
	public static final String DATABASE_NAME = "pa_db_v01.sdb";	
	private static final int MAX_CACHE_OBJECT = 100;
	private static final AtomicInteger usageCounter = new AtomicInteger(0);
	private static Object syncObject = new Object();
	private static DBHelper dbHelper = null;
	private Dao<USER, String> objUSER = null;
	//private Dao<APPR_MAIN, String> objAPPR_MAIN = null;
	private Dao<ATTACHMENT, String> objATTACHMENT = null;
	private Dao<LOV, String> objLOV = null;
/*	private Dao<CONFIGSYNCHRONIZATION, String> obj = null;
	private Dao<LOGINHISTORY, String> daoLOGINHISTORY = null;
	private Dao<GEOLOCATION, String> objGEOLOCATION = null;*/
	private Dao<SCHEDULE, String> objSCHEDULE = null;
	//private Dao<APPR_VHC_PEMBANDING_INT, String> objAPPR_PB_PEMBANDING_INT = null;
	/*private Dao<APPR_RTB_CEK_TATA_KOTA_INT, String> objAPPR_RTB_CEK_TATA_KOTA_INT = null;
	private Dao<APPR_RTB_DATA_INT, String> objAPPR_RTB_DATA_INT = null;
	private Dao<APPR_RTB_DETAIL_INT, String> objAPPR_RTB_DETAIL_INT = null;
	private Dao<APPR_RTB_PROGRESS_BANGUNAN_INT, String> objAPPR_RTB_PROGRESS_BANGUNAN_INT = null;
	private Dao<APPR_RTB_PROGRESS_DEVELOPER_INT, String> objAPPR_RTB_PROGRESS_DEVELOPER_INT = null;
	private Dao<APPR_RTB_VALUATION_INT, String> objAPPR_RTB_VALUATION_INT = null;
	private Dao<APPR_VHC_DATA_INT, String> objAPPR_VHC_DATA_INT = null;
	private Dao<APPR_VHC_VALUATION_INT, String> objAPPR_VHC_VALUATION_INT = null;
	private Dao<APPR_PB_VALUATION_INT, String> objAPPR_PB_VALUATION_INT = null;
	private Dao<APPR_MCH_VALUATION_INT, String> objAPPR_MCH_VALUATION_INT = null;
	private Dao<APPR_INBOXS, String> objAPPR_INBOXS = null;
	private Dao<APPR_RTB_PEMBANDING_INT, String> objAPPR_RTB_PEMBANDING_INT = null;
	private Dao<APPR_VHC_PEMBANDING_INT, String> objAPPR_VHC_PEMBANDING_INT = null;
	private Dao<APPR_DOKUMENT, String> objAPPR_DOKUMENT = null;
	private Dao<APPR_NEGATIVELIST_INT, String> objAPPR_NEGATIVELIST_INT = null;
	private Dao<APPR_HISTORY, String> objAPPR_HISTORY = null;
	private Dao<APPR_HISTORY_WORKFLOW, String> objAPPR_HISTORY_WORKFLOW = null;
	private Dao<APPR_RTB_IMB_INT, String> objAPPR_RTB_IMB_INT = null;
	private Dao<APPR_SERTIFIKAT, String> objAPPR_SERTIFIKAT = null;
	private Dao<APPR_COLLATERAL, String> objAPPR_COLLATERAL = null;
	private Dao<APPR_VALBANGUNAN, String> objAPPR_VALBANGUNAN = null;
	private Dao<APPR_PB_SAMPLING_BANGUNAN_INT, String> objAPPR_PB_SAMPLING_BANGUNAN_INT = null;
	private Dao<APPR_INBOXS_QUERY, String> objAPPR_INBOXS_QUERY = null;
	*/
	private Dao<CONFIGSYNCHRONIZATION, String> objCONFIGSYNCHRONIZATION = null;
	private Dao<ATTACHMENT_FILE, String> objATTACHMENT_FILE = null;
	private Dao<AMOS_EMAIL, String> objAMOS_EMAIL = null;
	//private Dao<APPR_STATUS, String> objAPPR_STATUS = null;
	
	private Dao<AMOS_ENTRY_DEBITUR_INT, String> objAMOS_ENTRY_DEBITUR_INT = null; // dsppk
	private Dao<AMOS_DOCUMENT_UPLOAD, String> objAMOS_DOCUMENT_UPLOAD = null; // dsppk
	
	public static void initDB(Context context) {
		dbHelper = new DBHelper(context);
	}
	
	public static void destroyDB() {
		dbHelper.close();
	}
	
	public static DBHelper getInstance(Context context) {
		
		synchronized (syncObject) {
			if (usageCounter.getAndIncrement() == 0) {
				initDB(context);				
			}
			Log.i(DBHelper.class.getName(), "Instance DB, Ref Counter:" + usageCounter.get());
		}
		
		return dbHelper;		
	}
	
	public static DBHelper getInstance() {
		DBHelper retVal = null;
		
		synchronized (syncObject) {
			usageCounter.getAndIncrement();
			retVal = dbHelper;
			Log.i(DBHelper.class.getName(), "Instance DB, Ref Counter:" + usageCounter.get());
		}
		
		return retVal;		
	}
	
	public static void repleaseInstance() {
		synchronized (syncObject) {
			if (usageCounter.get() > 0) {
				if ((usageCounter.decrementAndGet() - 1) == 0) {
					destroyDB();
				}
			}
			Log.i(DBHelper.class.getName(), "Release DB, Ref Counter:" + usageCounter.get());
		}
	}
	
	private DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database,
			ConnectionSource connectionSource) {
		
		Log.i(getClass().getName(), "Database onCreate");
		Class<?>[] tableClasses = DBConfig.getTableClasses();
		for (Class<?> tableClass : tableClasses) {
			try {
				Log.i(getClass().getName(), "Creating Table " + tableClass.getCanonicalName());
				TableUtils.createTable(connectionSource, tableClass);
				
			} catch (SQLException e) {
				Log.e(getClass().getName(), "Unable to create datbases", e);
			}		
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase database,
			ConnectionSource connectionSource, int oldVersion, int newVersion) {
		Log.i(getClass().getName(), "Database onUpgrade");
		Class<?>[] tableClasses = DBConfig.getTableClasses();
		for (Class<?> tableClass : tableClasses) {
			Log.i(getClass().getName(), "Droping Table " + tableClass.getCanonicalName());
			//TableUtils.dropTable(connectionSource, tableClass, false);
				
		}
		//if(newVersion==6){
			try {
				//objAMOS_ENTRY_DEBITUR_INT.executeRaw("ALTER TABLE AMOS_ENTRY_DEBITUR_INT ADD COLUMN LINS_POLICYFEEFIRE STRING;");
				//objAMOS_ENTRY_DEBITUR_INT.executeRaw("ALTER TABLE AMOS_ENTRY_DEBITUR_INT ADD COLUMN FINS_POLICYFEELIFE STRING;");
				AMOS_ENTRY_DEBITUR_INT tab=new AMOS_ENTRY_DEBITUR_INT();
				tab.setFINS_POLICYFEELIFE("0");
				tab.setLINS_POLICYFEEFIRE("0");

				getAMOS_ENTRY_DEBITUR_INT().create(tab);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		//}		
		
		onCreate(database);
	}
	
	@Override
	public void close() {
		Log.i(getClass().getName(), "Database close");		
		if (usageCounter.get() == 0) {
			Log.i(getClass().getName(), "No references to database, closing database");
			
			try {
			
				
			/*	objAPPR_INBOXS.clearObjectCache();
				objAPPR_INBOXS.setObjectCache(false);
				objAPPR_INBOXS = null;*/
							
				
				objUSER.clearObjectCache();
				objUSER.setObjectCache(false);
				objUSER = null;
							
				objATTACHMENT.clearObjectCache();
				objATTACHMENT.setObjectCache(false);
				objATTACHMENT = null;
				
				/*objAPPR_MAIN.clearObjectCache();
				objAPPR_MAIN.setObjectCache(false);
				objAPPR_MAIN = null;*/
				
				objLOV.clearObjectCache();
				objLOV.setObjectCache(false);
				objLOV = null;
				
				/*daoLOGINHISTORY.clearObjectCache();
				daoLOGINHISTORY.setObjectCache(false);
				daoLOGINHISTORY = null;
				
				objGEOLOCATION.clearObjectCache();
				objGEOLOCATION.setObjectCache(false);
				objGEOLOCATION = null;*/
				
				objSCHEDULE.clearObjectCache();
				objSCHEDULE.setObjectCache(false);
				objSCHEDULE = null;
				
			
				/*objAPPR_RTB_CEK_TATA_KOTA_INT.clearObjectCache();
				objAPPR_RTB_CEK_TATA_KOTA_INT.setObjectCache(false);
				objAPPR_RTB_CEK_TATA_KOTA_INT = null;
				
				objAPPR_RTB_DATA_INT.clearObjectCache();
				objAPPR_RTB_DATA_INT.setObjectCache(false);
				objAPPR_RTB_DATA_INT = null;
				
				objAPPR_RTB_DETAIL_INT.clearObjectCache();
				objAPPR_RTB_DETAIL_INT.setObjectCache(false);
				objAPPR_RTB_DETAIL_INT = null;
				
				objAPPR_RTB_PROGRESS_BANGUNAN_INT.clearObjectCache();
				objAPPR_RTB_PROGRESS_BANGUNAN_INT.setObjectCache(false);
				objAPPR_RTB_PROGRESS_BANGUNAN_INT = null;
				
				objAPPR_RTB_PROGRESS_DEVELOPER_INT.clearObjectCache();
				objAPPR_RTB_PROGRESS_DEVELOPER_INT.setObjectCache(false);
				objAPPR_RTB_PROGRESS_DEVELOPER_INT = null;
				
				objAPPR_RTB_VALUATION_INT.clearObjectCache();
				objAPPR_RTB_VALUATION_INT.setObjectCache(false);
				objAPPR_RTB_VALUATION_INT = null;
				
				objAPPR_PB_VALUATION_INT.clearObjectCache();
				objAPPR_PB_VALUATION_INT.setObjectCache(false);
				objAPPR_PB_VALUATION_INT = null;
				
				objAPPR_VHC_DATA_INT.clearObjectCache();
				objAPPR_VHC_DATA_INT.setObjectCache(false);
				objAPPR_VHC_DATA_INT = null;
				
				objAPPR_VHC_VALUATION_INT.clearObjectCache();
				objAPPR_VHC_VALUATION_INT.setObjectCache(false);
				objAPPR_VHC_VALUATION_INT = null;
				
				objAPPR_VHC_PEMBANDING_INT.clearObjectCache();
				objAPPR_VHC_PEMBANDING_INT.setObjectCache(false);
				objAPPR_VHC_PEMBANDING_INT = null;
				
								
				objAPPR_HISTORY.clearObjectCache();
				objAPPR_HISTORY.setObjectCache(false);
				objAPPR_HISTORY = null;
				
				objAPPR_HISTORY_WORKFLOW.clearObjectCache();
				objAPPR_HISTORY_WORKFLOW.setObjectCache(false);
				objAPPR_HISTORY_WORKFLOW = null;
				
				objAPPR_RTB_IMB_INT.clearObjectCache();
				objAPPR_RTB_IMB_INT.setObjectCache(false);
				objAPPR_RTB_IMB_INT = null;
				
				objAPPR_SERTIFIKAT.clearObjectCache();
				objAPPR_SERTIFIKAT.setObjectCache(false);
				objAPPR_SERTIFIKAT = null;
				
				objAPPR_COLLATERAL.clearObjectCache();
				objAPPR_COLLATERAL.setObjectCache(false);
				objAPPR_COLLATERAL = null;
				
				objAPPR_VALBANGUNAN.clearObjectCache();
				objAPPR_VALBANGUNAN.setObjectCache(false);
				objAPPR_VALBANGUNAN = null;
				
				
				objAPPR_PB_SAMPLING_BANGUNAN_INT.clearObjectCache();
				objAPPR_PB_SAMPLING_BANGUNAN_INT.setObjectCache(false);
				objAPPR_PB_SAMPLING_BANGUNAN_INT = null;
				
				objAPPR_INBOXS_QUERY.clearObjectCache();
				objAPPR_INBOXS_QUERY.setObjectCache(false);
				objAPPR_INBOXS_QUERY = null;*/
				
				objAMOS_EMAIL.clearObjectCache();
				objAMOS_EMAIL.setObjectCache(false);
				objAMOS_EMAIL = null; // dsppk
				
				objAMOS_ENTRY_DEBITUR_INT.clearObjectCache();
				objAMOS_ENTRY_DEBITUR_INT.setObjectCache(false);
				objAMOS_ENTRY_DEBITUR_INT = null; // dsppk
				
				objAMOS_DOCUMENT_UPLOAD.clearObjectCache();
				objAMOS_DOCUMENT_UPLOAD.setObjectCache(false);
				objAMOS_DOCUMENT_UPLOAD = null; // dsppk
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			super.close();
			dbHelper = null;
		} else {
			Log.i(getClass().getName(), "There are references to database, database not closed");			
		}
	}
	/*public Dao<APPR_INBOXS, String> getAPPR_INBOXS() throws SQLException {
		if (objAPPR_INBOXS == null) {
			objAPPR_INBOXS = getDao(APPR_INBOXS.class);
			objAPPR_INBOXS.setObjectCache(true);
			objAPPR_INBOXS.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_INBOXS;
	}
	public Dao<APPR_RTB_PROGRESS_BANGUNAN_INT, String> getAPPR_RTB_PROGRESS_BANGUNAN_INT() throws SQLException {
		if (objAPPR_RTB_PROGRESS_BANGUNAN_INT == null) {
			objAPPR_RTB_PROGRESS_BANGUNAN_INT = getDao(APPR_RTB_PROGRESS_BANGUNAN_INT.class);
			objAPPR_RTB_PROGRESS_BANGUNAN_INT.setObjectCache(true);
			objAPPR_RTB_PROGRESS_BANGUNAN_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_RTB_PROGRESS_BANGUNAN_INT;
	}*/
	public Dao<USER, String> getMSTUSER() throws SQLException {
		if (objUSER == null) {
			objUSER = getDao(USER.class);
			objUSER.setObjectCache(true);
			objUSER.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objUSER;
	}


	public Dao<ATTACHMENT, String> getATTACHMENT() throws SQLException {
		if (objATTACHMENT == null) {
			objATTACHMENT = getDao(ATTACHMENT.class);
			objATTACHMENT.setObjectCache(true);
			objATTACHMENT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objATTACHMENT;
	}

	/*public Dao<APPR_MAIN, String> getAPPR_MAIN() throws SQLException {
		if (objAPPR_MAIN == null) {
			objAPPR_MAIN = getDao(APPR_MAIN.class);
			objAPPR_MAIN.setObjectCache(true);
			objAPPR_MAIN.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_MAIN;
	}*/
	public Dao<USER, String> getUSER() throws SQLException {
		if (objUSER == null) {
			objUSER = getDao(USER.class);
			objUSER.setObjectCache(true);
			objUSER.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objUSER;
	}
	public Dao<LOV, String> getLOV() throws SQLException {
		if (objLOV == null) {
			objLOV = getDao(LOV.class);
			objLOV.setObjectCache(true);
			objLOV.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objLOV;
	}
	
	

	/*public Dao<APPR_RTB_CEK_TATA_KOTA_INT, String> getAPPR_RTB_CEK_TATA_KOTA_INT() throws SQLException {
		if (objAPPR_RTB_CEK_TATA_KOTA_INT == null) {
			objAPPR_RTB_CEK_TATA_KOTA_INT = getDao(APPR_RTB_CEK_TATA_KOTA_INT.class);
			objAPPR_RTB_CEK_TATA_KOTA_INT.setObjectCache(true);
			objAPPR_RTB_CEK_TATA_KOTA_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_RTB_CEK_TATA_KOTA_INT;
	}*/
	public Dao<CONFIGSYNCHRONIZATION, String> getCONFIGSYNCHRONIZATION() throws SQLException {
		if (objCONFIGSYNCHRONIZATION == null) {
			objCONFIGSYNCHRONIZATION = getDao(CONFIGSYNCHRONIZATION.class);
			objCONFIGSYNCHRONIZATION.setObjectCache(true);
			objCONFIGSYNCHRONIZATION.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objCONFIGSYNCHRONIZATION;
	}
	/*public Dao<APPR_RTB_DATA_INT, String> getAPPR_RTB_DATA_INT() throws SQLException {
		if (objAPPR_RTB_DATA_INT == null) {
			objAPPR_RTB_DATA_INT = getDao(APPR_RTB_DATA_INT.class);
			objAPPR_RTB_DATA_INT.setObjectCache(true);
			objAPPR_RTB_DATA_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_RTB_DATA_INT;
	}*/
	
	public Dao<SCHEDULE, String> getSchedule() throws SQLException {
		if (objSCHEDULE == null) {
			objSCHEDULE = getDao(SCHEDULE.class);
			objSCHEDULE.setObjectCache(true);
			objSCHEDULE.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objSCHEDULE;
	}
	
	/*public Dao<APPR_RTB_DETAIL_INT, String> getAPPR_RTB_DETAIL_INT() throws SQLException {
		if (objAPPR_RTB_DETAIL_INT == null) {
			objAPPR_RTB_DETAIL_INT = getDao(APPR_RTB_DETAIL_INT.class);
			objAPPR_RTB_DETAIL_INT.setObjectCache(true);
			objAPPR_RTB_DETAIL_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_RTB_DETAIL_INT;
	}
	

	
	public Dao<APPR_RTB_PROGRESS_DEVELOPER_INT, String> getAPPR_RTB_PROGRESS_DEVELOPER_INT() throws SQLException {
		if (objAPPR_RTB_PROGRESS_DEVELOPER_INT == null) {
			objAPPR_RTB_PROGRESS_DEVELOPER_INT = getDao(APPR_RTB_PROGRESS_DEVELOPER_INT.class);
			objAPPR_RTB_PROGRESS_DEVELOPER_INT.setObjectCache(true);
			objAPPR_RTB_PROGRESS_DEVELOPER_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_RTB_PROGRESS_DEVELOPER_INT;
	}
	
	public Dao<GEOLOCATION, String> geoLocation() throws SQLException {
		if (objGEOLOCATION == null) {
			objGEOLOCATION = getDao(GEOLOCATION.class);
			objGEOLOCATION.setObjectCache(true);
			objGEOLOCATION.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objGEOLOCATION;
	}
	
	public Dao<APPR_RTB_VALUATION_INT, String> getAPPR_RTB_VALUATION_INT() throws SQLException {
		if (objAPPR_RTB_VALUATION_INT == null) {
			objAPPR_RTB_VALUATION_INT = getDao(APPR_RTB_VALUATION_INT.class);
			objAPPR_RTB_VALUATION_INT.setObjectCache(true);
			objAPPR_RTB_VALUATION_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_RTB_VALUATION_INT;
	}
	public Dao<APPR_PB_VALUATION_INT, String> getAPPR_PB_VALUATION_INT() throws SQLException {
		if (objAPPR_PB_VALUATION_INT == null) {
			objAPPR_PB_VALUATION_INT = getDao(APPR_PB_VALUATION_INT.class);
			objAPPR_PB_VALUATION_INT.setObjectCache(true);
			objAPPR_PB_VALUATION_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_PB_VALUATION_INT;
	}
	public Dao<APPR_VHC_DATA_INT, String> getAPPR_VHC_DATA_INT() throws SQLException {
		if (objAPPR_VHC_DATA_INT == null) {
			objAPPR_VHC_DATA_INT = getDao(APPR_VHC_DATA_INT.class);
			objAPPR_VHC_DATA_INT.setObjectCache(true);
			objAPPR_VHC_DATA_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_VHC_DATA_INT;
	}
	public Dao<APPR_MCH_VALUATION_INT, String> getAPPR_MCH_VALUATION_INT() throws SQLException {
		if (objAPPR_MCH_VALUATION_INT == null) {
			objAPPR_MCH_VALUATION_INT = getDao(APPR_MCH_VALUATION_INT.class);
			objAPPR_MCH_VALUATION_INT.setObjectCache(true);
			objAPPR_MCH_VALUATION_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_MCH_VALUATION_INT;
	}
	public Dao<APPR_VHC_VALUATION_INT, String> getAPPR_VHC_VALUATION_INT() throws SQLException {
		if (objAPPR_VHC_VALUATION_INT == null) {
			objAPPR_VHC_VALUATION_INT = getDao(APPR_VHC_VALUATION_INT.class);
			objAPPR_VHC_VALUATION_INT.setObjectCache(true);
			objAPPR_VHC_VALUATION_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_VHC_VALUATION_INT;
	}
	public Dao<APPR_RTB_PEMBANDING_INT, String> getAPPR_RTB_PEMBANDING_INT() throws SQLException {
		if (objAPPR_RTB_PEMBANDING_INT == null) {
			objAPPR_RTB_PEMBANDING_INT = getDao(APPR_RTB_PEMBANDING_INT.class);
			objAPPR_RTB_PEMBANDING_INT.setObjectCache(true);
			objAPPR_RTB_PEMBANDING_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_RTB_PEMBANDING_INT;
	}
	public Dao<APPR_VHC_PEMBANDING_INT, String> getAPPR_VHC_PEMBANDING_INT() throws SQLException {
		if (objAPPR_VHC_PEMBANDING_INT == null) {
			objAPPR_VHC_PEMBANDING_INT = getDao(APPR_VHC_PEMBANDING_INT.class);
			objAPPR_VHC_PEMBANDING_INT.setObjectCache(true);
			objAPPR_VHC_PEMBANDING_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_VHC_PEMBANDING_INT;
	}
	
	public Dao<APPR_NEGATIVELIST_INT, String> getAPPR_NEGATIVELIST_INT() throws SQLException {
		if (objAPPR_NEGATIVELIST_INT == null) {
			objAPPR_NEGATIVELIST_INT = getDao(APPR_NEGATIVELIST_INT.class);
			objAPPR_NEGATIVELIST_INT.setObjectCache(true);
			objAPPR_NEGATIVELIST_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_NEGATIVELIST_INT;
	}
	
	public Dao<APPR_DOKUMENT, String> getAPPR_DOKUMENT() throws SQLException {
		if (objAPPR_DOKUMENT == null) {
			objAPPR_DOKUMENT = getDao(APPR_DOKUMENT.class);
			objAPPR_DOKUMENT.setObjectCache(true);
			objAPPR_DOKUMENT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_DOKUMENT;
	}

	public Dao<APPR_HISTORY, String> getAPPR_HISTORY() throws SQLException {
		if (objAPPR_HISTORY == null) {
			objAPPR_HISTORY = getDao(APPR_HISTORY.class);
			objAPPR_HISTORY.setObjectCache(true);
			objAPPR_HISTORY.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_HISTORY;
	}
	
	public Dao<APPR_HISTORY_WORKFLOW, String> getAPPR_HISTORY_WORKFLOW() throws SQLException {
		if (objAPPR_HISTORY_WORKFLOW == null) {
			objAPPR_HISTORY_WORKFLOW = getDao(APPR_HISTORY_WORKFLOW.class);
			objAPPR_HISTORY_WORKFLOW.setObjectCache(true);
			objAPPR_HISTORY_WORKFLOW.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_HISTORY_WORKFLOW;
	}
	
	public Dao<APPR_RTB_IMB_INT, String> getAPPR_RTB_IMB_INT() throws SQLException {
		if (objAPPR_RTB_IMB_INT == null) {
			objAPPR_RTB_IMB_INT = getDao(APPR_RTB_IMB_INT.class);
			objAPPR_RTB_IMB_INT.setObjectCache(true);
			objAPPR_RTB_IMB_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_RTB_IMB_INT;
	}
	
	public Dao<APPR_SERTIFIKAT, String> getAPPR_SERTIFIKAT() throws SQLException {
		if (objAPPR_SERTIFIKAT == null) {
			objAPPR_SERTIFIKAT = getDao(APPR_SERTIFIKAT.class);
			objAPPR_SERTIFIKAT.setObjectCache(true);
			objAPPR_SERTIFIKAT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_SERTIFIKAT;
	}
	
	public Dao<APPR_COLLATERAL, String> getAPPR_COLLATERAL() throws SQLException {
		if (objAPPR_COLLATERAL == null) {
			objAPPR_COLLATERAL = getDao(APPR_COLLATERAL.class);
			objAPPR_COLLATERAL.setObjectCache(true);
			objAPPR_COLLATERAL.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_COLLATERAL;
	}
	public Dao<APPR_VALBANGUNAN, String> getAPPR_VALBANGUNAN() throws SQLException {
		if (objAPPR_VALBANGUNAN == null) {
			objAPPR_VALBANGUNAN = getDao(APPR_VALBANGUNAN.class);
			objAPPR_VALBANGUNAN.setObjectCache(true);
			objAPPR_VALBANGUNAN.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_VALBANGUNAN;
	}
	public Dao<APPR_PB_SAMPLING_BANGUNAN_INT, String> getAPPR_PB_SAMPLING_BANGUNAN_INT() throws SQLException {
		if (objAPPR_PB_SAMPLING_BANGUNAN_INT == null) {
			objAPPR_PB_SAMPLING_BANGUNAN_INT = getDao(APPR_PB_SAMPLING_BANGUNAN_INT.class);
			objAPPR_PB_SAMPLING_BANGUNAN_INT.setObjectCache(true);
			objAPPR_PB_SAMPLING_BANGUNAN_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_PB_SAMPLING_BANGUNAN_INT;
	}*/
	public Dao<ATTACHMENT_FILE, String> getATTACHMENT_FILE() throws SQLException {
		if (objATTACHMENT_FILE == null) {
			objATTACHMENT_FILE = getDao(ATTACHMENT_FILE.class);
			objATTACHMENT_FILE.setObjectCache(true);
			objATTACHMENT_FILE.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objATTACHMENT_FILE;
	}
	public Dao<AMOS_EMAIL, String> getAMOS_EMAIL() throws SQLException {
		if (objAMOS_EMAIL == null) {
			objAMOS_EMAIL = getDao(AMOS_EMAIL.class);
			objAMOS_EMAIL.setObjectCache(true);
			objAMOS_EMAIL.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAMOS_EMAIL;
	}
	
	/*public Dao<APPR_STATUS, String> getAPPR_STATUS() throws SQLException {
		if (objAPPR_STATUS == null) {
			objAPPR_STATUS = getDao(APPR_STATUS.class);
			objAPPR_STATUS.setObjectCache(true);
			objAPPR_STATUS.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_STATUS;
	}
	
	public Dao<APPR_INBOXS_QUERY, String> getAPPR_INBOXS_QUERY() throws SQLException {
		if (objAPPR_INBOXS_QUERY == null) {
			objAPPR_INBOXS_QUERY = getDao(APPR_INBOXS_QUERY.class);
			objAPPR_INBOXS_QUERY.setObjectCache(true);
			objAPPR_INBOXS_QUERY.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAPPR_INBOXS_QUERY;
	}*/
	
	public Dao<AMOS_ENTRY_DEBITUR_INT, String> getAMOS_ENTRY_DEBITUR_INT() throws SQLException {
		if (objAMOS_ENTRY_DEBITUR_INT == null) {
			objAMOS_ENTRY_DEBITUR_INT = getDao(AMOS_ENTRY_DEBITUR_INT.class);
			objAMOS_ENTRY_DEBITUR_INT.setObjectCache(true);
			objAMOS_ENTRY_DEBITUR_INT.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAMOS_ENTRY_DEBITUR_INT; //dsppk
	}
	
	public Dao<AMOS_DOCUMENT_UPLOAD, String> getAMOS_DOCUMENT_UPLOAD() throws SQLException {
		if (objAMOS_DOCUMENT_UPLOAD == null) {
			objAMOS_DOCUMENT_UPLOAD = getDao(AMOS_DOCUMENT_UPLOAD.class);
			objAMOS_DOCUMENT_UPLOAD.setObjectCache(true);
			objAMOS_DOCUMENT_UPLOAD.setObjectCache(new LruObjectCache(MAX_CACHE_OBJECT));
		}
		return objAMOS_DOCUMENT_UPLOAD; //dsppk
	}
	
}
