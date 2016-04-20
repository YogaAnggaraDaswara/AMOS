package com.mobile.database.app;

import android.content.Context;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.LOV;
import com.mobile.database.app.entities.MESSAGE;
import com.mobile.database.app.entities.ATTACHMENT;
import com.mobile.database.app.entities.USER;
import com.mobile.database.app.entities.CONFIGSYNCHRONIZATION;
import com.mobile.database.app.entities.SCHEDULE;
import com.mobile.database.app.entities.GEOLOCATION;

import com.mobile.database.app.entities.AMOS_DOCUMENT_UPLOAD;
import com.mobile.database.app.entities.AMOS_EMAIL;
import com.mobile.database.app.entities.AMOS_ENTRY_DEBITUR_INT;
import com.mobile.database.app.entities.APPR_COLLATERAL;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_HISTORY_WORKFLOW;
import com.mobile.database.app.entities.APPR_INBOXS;
import com.mobile.database.app.entities.APPR_INBOXS_QUERY;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_NEGATIVELIST_INT;
import com.mobile.database.app.entities.APPR_PB_SAMPLING_BANGUNAN_INT;
import com.mobile.database.app.entities.APPR_STATUS;
import com.mobile.database.app.entities.APPR_VALBANGUNAN;
import com.mobile.database.app.entities.APPR_VHC_PEMBANDING_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_DATA_INT;
import com.mobile.database.app.entities.APPR_RTB_DETAIL_INT;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_RTB_PEMBANDING_INT;
import com.mobile.database.app.entities.APPR_RTB_PROGRESS_BANGUNAN_INT;
import com.mobile.database.app.entities.APPR_RTB_PROGRESS_DEVELOPER_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_SERTIFIKAT;
import com.mobile.database.app.entities.APPR_VHC_DATA_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.ATTACHMENT;
import com.mobile.database.app.entities.ATTACHMENT_FILE;
import com.mobile.database.app.entities.BLACKBOX;
import com.mobile.database.app.entities.DETAILTABUNGAN;
import com.mobile.database.app.entities.FOLLOWUP;
import com.mobile.database.app.entities.LOGINHISTORY;
import com.mobile.database.app.entities.NEWS;
import com.mobile.database.app.entities.PROSPEK;
import com.mobile.database.app.entities.STATEHISTORY;
import com.mobile.database.app.entities.TABUNGAN;
import com.mobile.database.app.entities.TAGIHAN;

public class DBConfig extends OrmLiteConfigUtil {
	
	private static final Class<?>[] classes = new Class[] { 
		   // APPR_STATUS.class,
			USER.class,
			//APPR_MAIN.class,
			ATTACHMENT.class,
			LOV.class,
			CONFIGSYNCHRONIZATION.class,
			ATTACHMENT_FILE.class,
			SCHEDULE.class,
			AMOS_EMAIL.class,
			/*LOGINHISTORY.class,
			GEOLOCATION.class,
			,
			APPR_VHC_PEMBANDING_INT.class,
			APPR_RTB_CEK_TATA_KOTA_INT.class,
			APPR_RTB_DATA_INT.class,
			APPR_RTB_DETAIL_INT.class,
			APPR_RTB_PROGRESS_BANGUNAN_INT.class,
			APPR_RTB_PROGRESS_DEVELOPER_INT.class,
			APPR_RTB_VALUATION_INT.class,
			APPR_VHC_DATA_INT.class,
			APPR_VHC_VALUATION_INT.class,
			APPR_PB_VALUATION_INT.class,
			APPR_MCH_VALUATION_INT.class,
			APPR_INBOXS.class,
			
			
			APPR_NEGATIVELIST_INT.class,
			APPR_SERTIFIKAT.class,
			APPR_RTB_IMB_INT.class,
			APPR_RTB_PEMBANDING_INT.class,
			APPR_DOKUMENT.class,
			
			APPR_HISTORY.class,
			APPR_HISTORY_WORKFLOW.class,
			APPR_COLLATERAL.class,
			APPR_VALBANGUNAN.class,
			
			APPR_PB_SAMPLING_BANGUNAN_INT.class,
			APPR_INBOXS_QUERY.class,
			ATTACHMENT_FILE.class,*/
			AMOS_ENTRY_DEBITUR_INT.class, //dsppk
			AMOS_DOCUMENT_UPLOAD.class //dsppk
			
		};
	
	public static void main(String[] args) throws Exception {
		writeConfigFile("ormlite_config.txt",classes);
	}
	
	public static Class<?>[] getTableClasses() {
		return classes;
	}
	
	private static final Object syncObject = new Object();
	private static boolean isInitialized = false;
	private static Context theContext;
	
	public static Context getAttachedContext() {
		Context retVal = null;
		if (isInitialized) {
			retVal = theContext;
		}
		return retVal;
	}

	public static boolean attachContext(Context context) {
		boolean retVal = false;
		synchronized (syncObject) {
			if (!isInitialized) {
				theContext = context;
				isInitialized = true;
			}
			retVal = isInitialized;
		}
		return retVal;
	}
	
	public static boolean detachContext() {
		boolean retVal = false;
		synchronized (syncObject) {
			if (isInitialized) {
				theContext = null;
				isInitialized = false;
			}
			retVal = !isInitialized;
		}
		return retVal;
	}
}
