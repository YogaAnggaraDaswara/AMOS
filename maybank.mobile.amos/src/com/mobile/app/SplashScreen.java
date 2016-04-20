package com.mobile.app;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import com.mobile.amos.DownloadActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.MasterActivity;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_DokumentDataProvider;
import com.mobile.bo.app.dataprovider.Appr_HistoryProvider;
import com.mobile.bo.app.dataprovider.Appr_History_WorkflowProvider;
import com.mobile.bo.app.dataprovider.Appr_ImbProvider;
import com.mobile.bo.app.dataprovider.Appr_InboxDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Mch_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.Appr_NegativeProvider;
import com.mobile.bo.app.dataprovider.Appr_PB_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Pb_SamplingBangunan_Provider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_DetailProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Pembanding;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Progress_BangunanDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Progress_DeveloperDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.Appr_SertifikatProvider;
import com.mobile.bo.app.dataprovider.Appr_Val_BangunanDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Vhc_Pembanding;
import com.mobile.bo.app.dataprovider.Appr_Vhc_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.DataProviderManager;
import com.mobile.bo.app.dataprovider.Appr_mainDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Cek_TataKota;
import com.mobile.bo.app.dataprovider.Appr_Rtb_DataDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Vhc_DataDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_Appr_History;
import com.mobile.bo.app.datatype.Datatype_Appr_History_Workflow;
import com.mobile.bo.app.datatype.Datatype_Appr_Inbox;
import com.mobile.bo.app.datatype.Datatype_Appr_Mch_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_NegativeList;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_sampling_bangunan;
import com.mobile.bo.app.datatype.Datatype_Appr_Progress_Bangunan_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Progress_Developer_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Cek_Tata_Kota_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Data_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Detail_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Pembanding_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Sertifikat;
import com.mobile.bo.app.datatype.Datatype_Appr_Vch_Data_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Vhc_Pembanding_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Vhc_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.bo.app.datatype.Datatype_Appr_valBangunan;
import com.mobile.bo.app.datatype.Datatype_Apprs_Main;
import com.mobile.bo.app.datatype.LoginHistoryData;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.database.app.DBHelper;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DeviceUtility;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.RequestCount;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

import maybank.mobile.amos.R;
import com.mobile.bo.app.datatype.LovData;
//import com.mobile.app.activity.HomeActivity;
//import com.mobile.app.servicebackground.LocalService;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;
public class SplashScreen extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;
	private LOVDataProvider lovDataProvider;
	private Appr_Cek_TataKota appr_Cek_TataKotaDataProvider;
	private Appr_Vhc_DataDataProvider appr_Vhc_DataDataProvider;
	private Appr_Rtb_DataDataProvider appr_Rtb_DataDataProvider;
	private Appr_Rtb_DetailProvider appr_Rtb_DetailProvider;
	private Appr_Vhc_ValuationDataProvider appr_Vhc_ValuationDataProvider;
	private Appr_Rtb_ValuationDataProvider appr_Rtb_ValuationDataProvider;
	private Appr_PB_ValuationDataProvider appr_PB_ValuationDataProvider;
	private Appr_Mch_ValuationDataProvider appr_Mch_ValuationDataProvider;
	private Appr_Rtb_Progress_BangunanDataProvider appr_Rtb_Progress_BangunanDataProvider;
	private Appr_Rtb_Progress_DeveloperDataProvider appr_Rtb_Progress_DeveloperDataProvider;
	private Appr_Pb_SamplingBangunan_Provider appr_Pb_SamplingBangunan_Provider;
	private Appr_InboxDataProvider appr_InboxDataProvider;
	private Appr_DokumentDataProvider appr_DokumentDataProvider;
	private Appr_Rtb_Pembanding appr_Rtb_Pembanding;
	private Appr_Vhc_Pembanding appr_Vhc_Pembanding;
	private Appr_HistoryProvider appr_HistoryProvider;
	private Appr_History_WorkflowProvider appr_History_WorkflowProvider;
	private Appr_Collateral appr_CollateralProvider;
	private Appr_SertifikatProvider appr_SertifikatProvider;
	private Appr_ImbProvider appr_ImbProvider;
	private Appr_NegativeProvider appr_NegativeProvider;
	private Appr_Val_BangunanDataProvider appr_Val_BangunanDataProvider;
	private Context ctx;
	 private ArrayList<Datatype_Appr_Inbox> listdata = null;
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		 String imei = DeviceUtility.getIMEI(this);
		     
	        try {
	            SERVICEDATARESPONSE response = ServiceDataProvider.doLogin("29297", "P@ssw0rd", imei, AppConstants.MODULEID);
	        }
	        catch(Exception ex){
	        	
	        	
	        }
        DBHelper db = DBHelper.getInstance(DataProviderManager.getAttachedContext());
*/
        initSplashScreen();
        ctx = this;
        //downloadapk(this);
    }

    private void initSplashScreen() {
        Log.i(getClass().getName(), "MasterActivity, initSplashScreen");
        setContentView(R.layout.splash_screen_layout);
     /*   Intent i = new Intent(SplashScreen.this, MainActivity.class);   
    	String keyIdentifer  = null;
    	i.putExtra("AP_REGNO", "M-025-201505-0001");
    	i.putExtra("COL_ID", "c92198cf-aa06-46ea-9e8a-0711c8a943a6");
    	i.putExtra("COL_TYPE", "RE");
    	i.putExtra("APPRAISE_TYPE", "K");
    	 startActivity(i);
    */	 
        //startServiceBackground();
        run();
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);*/
    }

    private boolean isBackgroundServiceRunning() {
       /* ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if ("com.mobile.app.servicebackground.LocalService".equals(service.service.getClassName())) {
                return true;
            }
        }*/
        return false;
    }

    public void startServiceBackground() {
       /* if (!isBackgroundServiceRunning()) {
            //Toast.makeText(this, "Background process is started", Toast.LENGTH_LONG).show();
            //startService(new Intent(this, LocalService.class));
        }*/
    }
    private void run(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean retVal = true;
                      if (retVal) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                //initializeContentDataFromService();
                                ActivityHandler.gotoActivity(ctx, LoginActivity.class, null);
                                finish();
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            public void run() {
                               
                            }
                        });
                    }

            }
        }).start();
     }
        public void initializeContentDataFromService() {
     }
}
