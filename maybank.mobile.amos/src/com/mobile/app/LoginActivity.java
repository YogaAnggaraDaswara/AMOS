package com.mobile.app;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.xml.sax.Parser;



import maybank.mobile.amos.R;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.mobile.amos.DownloadActivity;
import com.mobile.app.activity.HomeActivity;
//import com.mobile.app.activity.common.FollowUp;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.media.CameraDialog;


import com.mobile.bo.app.dataprovider.Amos_Document_UploadDataProvider;
import com.mobile.bo.app.dataprovider.PhotoDataProvider;
import com.mobile.bo.app.dataprovider.ScheduleDataProvider;
import com.mobile.bo.app.dataprovider.ConfigSyncronizationDataProvider;
import com.mobile.app.servicebackground.LocalService;
import com.mobile.app.ui.MasterLoginActivity;
import com.mobile.bo.app.dataprovider.Amos_Entry_Debitur;
/*import com.mobile.bo.app.dataprovider.Appr_Cek_TataKota;
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
import com.mobile.bo.app.dataprovider.Appr_Rtb_DataDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_DetailProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Pembanding;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Progress_BangunanDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Progress_DeveloperDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.Appr_SertifikatProvider;
import com.mobile.bo.app.dataprovider.Appr_Val_BangunanDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Vhc_DataDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Vhc_Pembanding;
import com.mobile.bo.app.dataprovider.Appr_Vhc_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.Appr_mainDataProvider;
import com.mobile.bo.app.dataprovider.ConfigSyncronizationDataProvider;
import com.mobile.bo.app.dataprovider.FollowUpDataProvider;

import com.mobile.bo.app.dataprovider.LoginHistoryDataProvider;
import com.mobile.bo.app.dataprovider.MessageDataProvider;
import com.mobile.bo.app.dataprovider.NewsDataProvider;
import com.mobile.bo.app.dataprovider.PhotoDataProvider;
import com.mobile.bo.app.dataprovider.ProspekDataProvider;
import com.mobile.bo.app.dataprovider.ScheduleDataProvider;
import com.mobile.bo.app.dataprovider.TabunganDataProvider;
import com.mobile.bo.app.dataprovider.TagihanDataProvider;*/
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.dataprovider.UserDataProvider;
import com.mobile.bo.app.datatype.ConfigSyncronizationData;
import com.mobile.bo.app.datatype.DataType_Amos_Debitur_Int;
import com.mobile.bo.app.datatype.DataType_Amos_Document_Upload;
import com.mobile.bo.app.datatype.PhotoData;


/*import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
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
import com.mobile.bo.app.datatype.Datatype_attachment;
import com.mobile.bo.app.datatype.PhotoData;
//import com.mobile.bo.app.datatype.ConfigSyncronizationData;
import com.mobile.bo.app.datatype.FollowupData;*/
import com.mobile.bo.app.datatype.LoginHistoryData;
import com.mobile.bo.app.datatype.LovData;

import com.mobile.bo.app.datatype.ScheduleData;

import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.common.DeviceUtility;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.DATA_RESPONSE_SCORE;
import com.mobile.services.app.datatype.RequestCount;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.JSONServiceHandler;
import com.mobile.services.app.services.ServiceDataProvider;

import android.R.string;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.mobile.database.app.DBHelper;
public class LoginActivity extends MasterLoginActivity {
	private static final int NOTIFICATION_ID = 0;
	private Context ctx;
	private UserData userData = null;
	private String username = "";
	private String password = "";
	private boolean authCanceled = false;
	AlertDialog alertDialog = null;
	private ConfigSyncronizationDataProvider configSyncronizationDataProvider;
	private UserDataProvider userDataProvider;
	private LOVDataProvider lovDataProvider;
	private ConfigSyncronizationData configSyncronizationData;
	private ScheduleDataProvider scheduleDataProvider;
	private Amos_Entry_Debitur amos_entry_debitur_DataProvider = new Amos_Entry_Debitur();
	private Amos_Document_UploadDataProvider amos_Document_DataProvider = new Amos_Document_UploadDataProvider();
	private PhotoDataProvider photoDataProvider = new PhotoDataProvider();
	
	private ArrayList<DataType_Amos_Debitur_Int> listdataall  = null;
	private ArrayList<DataType_Amos_Document_Upload> listdocall  = null;
	private ArrayList<PhotoData> listphotoall  = null;
	
	private String typeComparation = "";
	private int Field_dATE = 0, dateRangeComparation = 0;

    @SuppressLint({"NewApi", "ShowToast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        ctx = this;
        lovDataProvider = new LOVDataProvider();
        getActionBar().setIcon(R.drawable.user);
        configSyncronizationDataProvider = new ConfigSyncronizationDataProvider();
        userDataProvider = new UserDataProvider();
        scheduleDataProvider = new ScheduleDataProvider();
        amos_entry_debitur_DataProvider = new Amos_Entry_Debitur();
        
        initLoginActivity();
       
    	/*Button Btnsave = (Button) findViewById(R.id.master_login_btn_login);

    	Btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	// getDataFromServer();
            	 //doAuthentication();
            	 //ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
           }
        }); */
    }
    
    private void loadFile1() throws Exception {
		File directory = new File(AppConstants.FILEPATH  +  "MASTER/");
		 boolean success = true;
         if (!directory.exists()) {
             success = directory.mkdirs();
         }
		
		String path = AppConstants.FILEPATH ;
		unpackZip(path,"Master.zip");
		
		Log.d("Files", "Path: " + path +  "MASTER/");
		File f = new File(path+  "MASTER/");        
		File file[] = f.listFiles();
		Log.d("Files", "Size: "+ file.length);
		if(file.length>0)
			lovDataProvider.deleteAllTabungan();
		
		for (int i=0; i < file.length; i++)
		{
			final String filename=file[i].getName().toString();
			new Thread(new Runnable() {
				String filename1=filename;
				@Override
				public void run() {
					String jsonstring;
					try {
						jsonstring = getStringFromFile(AppConstants.FILEPATH + "MASTER/"+ filename1);
					
					
						JSONArray jsonArray = new JSONArray(jsonstring);
						
						 ArrayList<LovData> arrLOVServiceData = ServiceData.getLOV(new JSONArray(jsonstring));
				         if (arrLOVServiceData.size()>0) {
				        	
				             for (int ii = 0; ii < arrLOVServiceData.size(); ii++) {
				            
				                 lovDataProvider.update(arrLOVServiceData.get(ii));
				             }
				             arrLOVServiceData = null;
				         }
				         //Toast.makeText(ctx, "Success="+filename, Toast.LENGTH_LONG);
					} catch (Exception e) {
						//Toast.makeText(ctx, "Error="+filename, Toast.LENGTH_LONG);
						e.printStackTrace();
					}
				};
			}).start();
		}
    }
    public String DownloadImageFromUrlPDF(String AP_REGNO, String COL_ID, String FILENAME) throws Exception {
    	String fileName="Test.pdf";
        //if (!file.exists()) {
    	URL url = new URL(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/RetrieveFilePDF/?AP_REGNO=" + AP_REGNO + "&COL_ID=" + COL_ID + "&filename=" + FILENAME  );
        URLConnection ucon = url.openConnection();
        Map<String, List<String>> map = ucon.getHeaderFields();
            
    	System.out.println("Printing Response Header...\n");
         
        	
    	for (Map.Entry<String, List<String>> entry : map.entrySet()) {
    		 String key = entry.getKey();
    		 try{
        		 if(key.compareTo("sfilename")==0){
        			 //List<String> value = entry.getValue(); 
        			 fileName=entry.getValue().get(0);
        			 
        			 //System.out.println(values);
        			 //System.out.println(value);
        		 }
    		 }
    		 catch(Exception ex){}
    		/*System.out.println("Key : " + entry.getKey()
                               + " ,Value : " + entry.getValue());
    		if(entry.getKey().compareTo(AppConstants.HEADERFILE)==0)
    		{
    			fileName=entry.getValue().toString();
    		}	
    		String xx=entry.getKey().toString();
    		System.out.println( xx);*/
    	}
         
        File file = new File(AppConstants.FILEPATH + AP_REGNO + "/" + fileName);
            
        InputStream is = ucon.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
           /*
            * Read bytes to the Buffer until there is nothing more to read(-1).
            */
        ByteArrayBuffer baf = new ByteArrayBuffer(50);
        int current = 0;
        while ((current = bis.read()) != -1) {
            baf.append((byte) current);
        }

        /// save image to sdcard
        File folder = new File(AppConstants.FILEPATH + AP_REGNO);
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdirs();
        }
        if (success) {
            // Do something on success
        } else {
            // Do something else on failure
        }
        FileOutputStream fos = new FileOutputStream(AppConstants.FILEPATH  + AP_REGNO + "/" + fileName);
        fos.write(baf.toByteArray());
        fos.close();
        //Datatype_attachment attachment =new Datatype_attachment();
        
      return fileName;
         
        //}
    }

    private void initLoginActivity() {
		initializeConfigSynchronization();
//		configureData();
		
//		getEdtUserName().setText("WINFIS");
//		getEdtPassword().setText("Bii55555");
		getBtnLogin().setOnClickListener(new View.OnClickListener() {
		@Override
			public void onClick(View v) {
			
				authCanceled = false;
				
				if (checkContentValidation() !=null){
					showNotificationMessage(R.string.str_uncompletefield);
				}
				else
				{
					disableInput();
					showLoginProgressIndicator();
					new Thread(new Runnable() {
						@Override
						public void run() {
							boolean retVal = false;
							updateAuthenticationParameter();
							retVal = doAuthentication();
							
							if (!authCanceled) 
							{
								if (retVal) {
									getDataFromServer();
									checkobsoleteData();
									runOnUiThread(new Runnable() {
										public void run() {
											setStrProgressMessage("Checking & Initilize Data");
											initializeContentDataFromService();
											hideLoginProgressIndicator();
											SessionSharedPreference.storeDataToSharesPreference(ctx, userData, AppConstants.USER_SESSION);	
											
											finish();
										}
									});
								} else {
									runOnUiThread(new Runnable() {
										public void run() {
											hideLoginProgressIndicator();
											showNotificationMessage(R.string.str_auth_fail);
											enableInput();
										}
									});
								}
							} else {
								runOnUiThread(new Runnable() {
									public void run() {
										enableInput();
										hideLoginProgressIndicator();
									}
								});							
							}
						}
					}).start();
				  }
			}
		});
		
	}
    
    private void checkobsoleteData() {

 		ArrayList<ScheduleData> arrSchedules = scheduleDataProvider.getProspekSchedule();
 		if (arrSchedules.size() > 0 ) {				 		
 		
	 		boolean synchronizeBlackbox = true;					 	
//		 	if (configSyncronizationData.getLASTSYNCHRONIZEBLACKBOX() !=null)
//			{
//				if (DateFormatter.formatDateOnly(new Date()).after(DateFormatter.formatDateOnly(configSyncronizationData.getLASTSYNCHRONIZEBLACKBOX()))){synchronizeBlackbox=true;}
//			}
//		 	else{synchronizeBlackbox=true;}
		 	///test 
//		 	synchronizeBlackbox=true;
		 	if (synchronizeBlackbox){
				
				//new dhimas clear data
				ScheduleData schedule = scheduleDataProvider.getDetailSchedule(AppConstants.PAGEBLACKBOX);
				if (schedule != null) {
					dateRangeComparation = Integer.parseInt(schedule.getINTERVAL());
					typeComparation = schedule.getTYPE();
				}
		 		
		 		if(typeComparation.toString().equals(AppConstants.SCHEDULE_TYPE_DAYS)) {
		 			Field_dATE = Calendar.DATE;
				} else if(typeComparation.toString().equals(AppConstants.SCHEDULE_TYPE_HOUR)) {
					Field_dATE = Calendar.HOUR;
				} else if(typeComparation.toString().equals(AppConstants.SCHEDULE_TYPE_MINUTE)) {
					Field_dATE = Calendar.MINUTE;
				}
		 		
		 		ClearEntryDebitur();
		 		/*
				clearDocument();
				//end clear data
				*/
				
		 	}
 		}
    }

    private void showNotificationMessage(int messageId) {
		if (alertDialog == null) {
			Builder alertBuilder = new AlertDialog.Builder(this);
			alertBuilder.setTitle(R.string.str_form_login);
			alertBuilder.setMessage(messageId);
			alertBuilder.setCancelable(false);
			alertBuilder.setIcon(R.drawable.icon_info);
			alertBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					alertDialog.dismiss();
					alertDialog = null;
				}
			});
			alertDialog = alertBuilder.create();
			alertDialog.show();
		}
	}
    
    public void initializeConfigSynchronization(){
		int retVal = configSyncronizationDataProvider.getAllConfigSyncronizationDataCount();
		if (retVal == 0){
			configSyncronizationDataProvider.updateConfigSyncronization(new ConfigSyncronizationData("1",null,null,null,null,null,null,null));
		}
		configSyncronizationData = configSyncronizationDataProvider.getConfigSyncronizationData();
	}
	
    ////
    public void DownloadImageFromUrl() throws Exception {
    	String fileName="Master.zip";
    	String fileName1="Master.txt";
    	
        File file = new File(AppConstants.FILEPATH + fileName);
        File file1 = new File(AppConstants.FILEPATH + fileName1);
        if (file.exists()) {
        	file.delete();
        	
        }
        if (file1.exists()) {
        	file1.delete();
        	
        }
            URL url = new URL(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/getDataMaster");
            URLConnection ucon = url.openConnection();
            InputStream is = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
               /*
	            * Read bytes to the Buffer until there is nothing more to read(-1).
	            */
            ByteArrayBuffer baf = new ByteArrayBuffer(50);
            int current = 0;
            while ((current = bis.read()) != -1) {
                baf.append((byte) current);
            }

            /// save image to sdcard
            File folder = new File(AppConstants.FILEPATH);
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {
                // Do something on success
            } else {
                // Do something else on failure
            }
            FileOutputStream fos = new FileOutputStream(AppConstants.FILEPATH + fileName);
            fos.write(baf.toByteArray());
            fos.close();
        
}

    ////


    @Override
    public void onBackPressed() {
    	ActivityHandler.gotoActivity(ctx, LoginActivity.class, null);
        finish();
//		System.exit(0);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onDestroy() {
        //userDataProvider.release();
        super.onDestroy();
    }

    @Override
	protected void onResume() {
	    super.onResume();
	}

   /* @Override
    protected void onPause() {
        super.onPause();
    }*/

    private void updateAuthenticationParameter() {
	    username = getEdtUserName().getText().toString();
	    password = getEdtPassword().getText().toString();
    }
    
    private void getDataFromServer(){
    	try {

		 	try {
			  		//sinkron data schedule
	        		ArrayList<NameValuePair> params1=new ArrayList<NameValuePair>();
			        params1.add(new BasicNameValuePair("Userid", username));

			        SERVICEDATARESPONSE scheduleResponse= ServiceDataProvider.getScheduler(params1);
					if (scheduleResponse != null){
						ArrayList<ScheduleData> arrScheduleService= ServiceData.getSchedules(new JSONArray(scheduleResponse.getResults()));
						if (scheduleResponse.getStatus() == 1){
							for (int i=0;i<arrScheduleService.size();i++){
								scheduleDataProvider.updateSchedule(arrScheduleService.get(i));
							}
							arrScheduleService = null;
						}								
					} 
					scheduleResponse = null;
					//configSyncronizationData.setLASTSYNCHRONIZESCHEDULE(new Date());
			 }
			 catch(Exception e){
				 e.printStackTrace();
			 }
		  
		/*	
	       ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
	       int intCount = 0;
	       SERVICEDATARESPONSE masterCountResponse = ServiceDataProvider.getDataMasterCount(params);
	       if (masterCountResponse != null) {
	           ArrayList<RequestCount> arrTabunganCountData = ServiceData.getDataMasterCount(new JSONArray(masterCountResponse.getResults()));
	           if (masterCountResponse.getStatus() == 1) {
	               RequestCount contentdata = arrTabunganCountData.get(0);
	               intCount = Integer.parseInt(contentdata.getPAGES().toString());
	               if(intCount>0)
	              	 lovDataProvider.deleteAllTabungan();
	               
	               //for (int a = 0; a < intCount; a++) {
	               int a=1;
	                   String sPages = "" + (a + 1);

	               	ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>();
	                      params1.add(new BasicNameValuePair("PART", "" + sPages ));
	                      //params1.add(new BasicNameValuePair("BRANCHID", "" + userData.getUNIT() ));
	                      SERVICEDATARESPONSE lovResponse = ServiceDataProvider.getLOV(params1);
	                     
	                     if (lovResponse != null) {
	                         ArrayList<LovData> arrLOVServiceData = ServiceData.getLOV(new JSONArray(lovResponse.getResults()));
	                         if (lovResponse.getStatus() == 1) {
	                             for (int i = 0; i < arrLOVServiceData.size(); i++) {
	                            
	                                 lovDataProvider.update(arrLOVServiceData.get(i));
	                             }
	                             arrLOVServiceData = null;
	                         }
	                         //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
	                     }
	                     lovResponse = null;
	               //}
	               
	           }
		
	       }
		  	    */	
	           
	   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	   }
	}
    private void loadFile() throws Exception{
			File directory = new File(AppConstants.FILEPATH  +  "MASTER/");
			 boolean success = true;
	         if (!directory.exists()) {
	             success = directory.mkdirs();
	         }
			
			String path = AppConstants.FILEPATH ;
			unpackZip(path,"Master.zip");
			
			Log.d("Files", "Path: " + path +  "MASTER/");
			File f = new File(path+  "MASTER/");        
			File file[] = f.listFiles();
			Log.d("Files", "Size: "+ file.length);
			if(file.length>0)
				lovDataProvider.deleteAllTabungan();
			
			for (int i=0; i < file.length; i++)
			{
				final String filename=file[i].getName().toString();
				new Thread(new Runnable() {
					String filename1=filename;
					@Override
					public void run() {
						
					
						String jsonstring;
						try {
							jsonstring = getStringFromFile(AppConstants.FILEPATH + "MASTER/"+ filename1);
						
						
							JSONArray jsonArray = new JSONArray(jsonstring);
							
							 ArrayList<LovData> arrLOVServiceData = ServiceData.getLOV(new JSONArray(jsonstring));
					         if (arrLOVServiceData.size()>0) {
					        	
					             for (int ii = 0; ii < arrLOVServiceData.size(); ii++) {
					            
					                 lovDataProvider.update(arrLOVServiceData.get(ii));
					             }
					             arrLOVServiceData = null;
					         }
					         //Toast.makeText(ctx, "Success="+filename, Toast.LENGTH_LONG);
						} catch (Exception e) {
							//Toast.makeText(ctx, "Error="+filename, Toast.LENGTH_LONG);
							e.printStackTrace();
						}
					};
				}).start();
			}
	}
	private class GetDataMaster extends AsyncTask<Void, Void,Void> {
  		boolean bolstatus=false;
  		@Override
  		protected Void doInBackground(Void... params) {
  			//try{
  					
  					//setStrProgressMessage("Downloading Data...");
					try {
						DownloadImageFromUrl();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//setStrProgressMessage("Checking & Initilize Data");
					try {
						loadFile();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//hideLoginProgressIndicator();
  			//}
  			//catch(Exception e){
  			//	 e.printStackTrace();
  			//}
			return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			hideLoginProgressIndicator();
  		 }	 
      }
	public static String getStringFromFile (String filename) throws Exception {
		File yourFile = new File(filename);
        FileInputStream stream = new FileInputStream(yourFile);
        String jString = null;
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            /* Instead of using default, pass in a decoder. */
            jString = Charset.defaultCharset().decode(bb).toString();
          }
          finally {
            stream.close();
          }       
	    return jString;
	}
	private boolean unpackZip(String path, String zipname)
	{       
	     InputStream is;
	     ZipInputStream zis;
	     try 
	     {
	         is = new FileInputStream(path + zipname);
	         zis = new ZipInputStream(new BufferedInputStream(is));          
	         ZipEntry ze;

	         while((ze = zis.getNextEntry()) != null) 
	         {
	             ByteArrayOutputStream baos = new ByteArrayOutputStream();
	             byte[] buffer = new byte[1024];
	             int count;

	             String filename = ze.getName();
	             FileOutputStream fout = new FileOutputStream(path + "MASTER/"+ filename);

	             // reading and writing
	             while((count = zis.read(buffer)) != -1) 
	             {
	                 baos.write(buffer, 0, count);
	                 byte[] bytes = baos.toByteArray();
	                 fout.write(bytes);             
	                 baos.reset();
	             }

	             fout.close();               
	             zis.closeEntry();
	         }

	         zis.close();
	     } 
	     catch(IOException e)
	     {
	         e.printStackTrace();
	         return false;
	     }

	    return true;
	}
	private boolean doAuthentication() {
		
		/*try{
		ArrayList<NameValuePair> params1=new ArrayList<NameValuePair>();
        params1.add(new BasicNameValuePair("Userid", "MITRA1"));
        params1.add(new BasicNameValuePair("Imei", "11111"));
        SERVICEDATARESPONSE versionResponse = ServiceDataProvider.CheckVersion(params1);
		if (versionResponse != null){
			ArrayList<CHECKVERSION> arrvERSIONData= ServiceData.getVersion(new JSONArray(versionResponse.getResults()));
			
		}
		
		}
		catch(Exception ex){
			
			
		}
		*/
        boolean retVal = false;
        String imei = DeviceUtility.getIMEI(ctx);
        LoginHistoryData loginHistoryData = new LoginHistoryData(username, password, "", "", null, imei);
        userData = userDataProvider.getUser(username, password);
        try {
            SERVICEDATARESPONSE response = ServiceDataProvider.doLogin(username, password, imei, AppConstants.MODULEID);
            //Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show();
            if (response != null) {
                UserData userServiceData = ServiceData.getUser(new JSONArray(response.getResults()).getJSONObject(0));
                if (response.getStatus() == 1) {
                    int userCount = userDataProvider.getAllUserCount();
                    //if (userCount == 0){
                    userDataProvider.updateUser(userServiceData);
                    userData = userDataProvider.getUser(username, password);
                    retVal = true;
                    //}
                    //else{
                    if (userData != null && userServiceData.getUSERID().equalsIgnoreCase(userData.getUSERID()) && userServiceData.getIMEI().equalsIgnoreCase(imei)) {
                        loginHistoryData.setSTATUS(AppConstants.LOGINSUCCESS);
                        loginHistoryData.setDESCRIPTION("Login Success");
                        retVal = true;
                    } else {
                        loginHistoryData.setSTATUS(AppConstants.LOGINFAILED);
                        loginHistoryData.setDESCRIPTION("UserId & Password didn't match to user local device");
                    }
                    //}
                } else {
                    loginHistoryData.setSTATUS(AppConstants.LOGINFAILED);
                    loginHistoryData.setDESCRIPTION("Response From Server Null");
                    retVal = true;
                }
                userServiceData = null;
            }

            response = null;
        } catch (Exception e) {
            // System.out.println(e.getMessage().toString());
            if (userData != null) {
                loginHistoryData.setSTATUS(AppConstants.LOGINSUCCESS);
                loginHistoryData.setDESCRIPTION("Cannot connect to server. Authentication is using local device");
                retVal = true;
            } else {
                loginHistoryData.setSTATUS(AppConstants.LOGINFAILED);
                loginHistoryData.setDESCRIPTION("Exception:" + e.getMessage());
            }
        } finally {
           /* loginHistoryData.setDATE(new Date());
            loginHistoryDataProvider.updateLoginHistory(loginHistoryData);
            loginHistoryData = null;*/
        }

        return retVal;

    }

	//Start service background
	public void startServiceBackground()
  	{	
		if (isBackgroundServiceRunning()){
			stopServiceBackground();
		}
		Toast.makeText(this, "Background process is started", Toast.LENGTH_LONG).show();
  		startService(new Intent(this, LocalService.class));
  	}
  	
	//Stop service background
  	public void stopServiceBackground()
  	{
  		stopService(new Intent(this, LocalService.class));
  	}
  	
  	private boolean isBackgroundServiceRunning() {
  	    ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
  	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
  	        if ("com.mobile.app.servicebackground.LocalService".equals(service.service.getClassName())) {
  	            return true;
  	        }
  	    }
  	    return false;
  	}
  	public void initializeContentDataFromService(){
  		try {
			scheduleDataProvider.delete("1");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  		//scheduleDataProvider.updateSchedule(new ScheduleData("1","2","1","07:07:00","23:00:00")); 
		 if (configSyncronizationData != null){
			 try {
				 
				 try {
					 boolean synchronizeLov = false;
					 if (configSyncronizationData.getLASTSYNCHRONIZELOV() !=null)
						{
						 	if (DateFormatter.formatDateOnly(new Date()).after(DateFormatter.formatDateOnly(configSyncronizationData.getLASTSYNCHRONIZELOV()))){
						 		synchronizeLov = true;
					 		}
						}
					 	else{ synchronizeLov = true;}
					 	
					 	if (synchronizeLov){
					 		
					 		configSyncronizationData.setLASTSYNCHRONIZELOV(new Date());
					 		scheduleDataProvider.updateSchedule(new ScheduleData("1","2","1","07:07:00","23:00:00")); 
					 		ActivityHandler.gotoActivity(ctx,DownloadActivity.class,null);
					 		
					 	}
					 	else{
					 		ActivityHandler.gotoActivity(ctx,HomeActivity.class,null);
					 	}
					 }
					 catch(Exception e){
						 e.printStackTrace();
					 }
				 
		        }
		        catch (Exception e){
		        	e.printStackTrace();
		        }
			 	finally {
			 		configSyncronizationDataProvider.updateConfigSyncronization(configSyncronizationData);
			 		configSyncronizationData = null;
			 	}				 
		 }
		 
		ArrayList<ScheduleData> arrSchedule= scheduleDataProvider.getAllSchedule();
		if (arrSchedule.size() > 0){ 
			startServiceBackground();
		}
		       
  	}
	
//  	private class ClearEntryDebitur extends AsyncTask<Void, Void,Void> {
	private void ClearEntryDebitur () {
//  		ProgressDialog dialogWait = ProgressDialog.show(ctx, "Loading", "Please wait...", true);
  		ArrayList<String> debiturID = new ArrayList<String>();
//  		@Override
//		protected Void doInBackground(Void... params) 
//		{
			if (listdataall != null) {
				listdataall.clear();
			}
			Amos_Entry_Debitur amos_Entry_Debitur=new Amos_Entry_Debitur();
			listdataall = amos_entry_debitur_DataProvider.getAllAmos_Entry_Debitur(userData.getUSERID());
			if (listdataall.size() > 0) {
				for (int i=0;i<listdataall.size();i++) {
					try {
						DataType_Amos_Debitur_Int arrdata = amos_Entry_Debitur.getAllAmos_Entry_Debitur_by_seq(listdataall.get(i).getID().toString());
						if (arrdata.getAP_CREATEDATE() != null) {
							
							String crtDate = DateFormatter.formatStringYYYYMMdd(arrdata.getAP_CREATEDATE(), true);
							Date CreateDate  = DateFormatter.formatYYYYMMDDHHmmss(crtDate);
							
							Calendar c = Calendar.getInstance();
							c.getTimeInMillis();
							c.setTime(CreateDate);
							c.add(Field_dATE, dateRangeComparation);
							
							String dateNow = DateFormatter.formatStringYYYYMMDDHHmmss(new Date());
							Date Date_Now = DateFormatter.formatYYYYMMDDHHmmss(dateNow);
							
							String dateNow2 = DateFormatter.formatStringYYYYMMDDHHmmss(c.getTime());
							Date Create_Date = DateFormatter.formatYYYYMMDDHHmmss(dateNow2);
							
							if (Date_Now.after(Create_Date)) {
								Gson gsondata = new Gson();
								ArrayList<DATA_RESPONSE_SCORE> Response = ServiceDataProvider.uploadPendingSubmited(gsondata.toJson(arrdata).toString());
								if (Response != null){
									if (Response.size() > 0){
										for (int y=0;y<Response.size();y++ ){
											DATA_RESPONSE_SCORE objRes= Response.get(i);
											if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)) {
												debiturID.add(objRes.getID().toString());
											} else { }
										}	
									}		
								}
								else{
									//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
								}
							}
						}
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}
			}
//			return null;
//		}
  		
//  		@Override
//		protected void onPostExecute(Void result) {
  			if(debiturID.size() >0) {
	  			for (int i=0;i<debiturID.size();i++) {
					try {
						amos_entry_debitur_DataProvider.deleteTransaksiById(debiturID.get(i).toString());
					} catch (Exception e) {}
				}
	  		}
//  			dialogWait.dismiss();
//	  	}
	}
	
	private void clearDocument()
	{

		if (listdocall != null) {
			listdocall.clear();
		}
		
		listdocall = amos_Document_DataProvider.getAllData_search_by_USERID(userData.getUSERID());
		if (listdocall.size() > 0) {
			for (int i=0;i<listdocall.size();i++) {
				
				DataType_Amos_Document_Upload datax = listdocall.get(i);
				if (datax.getDOC_RECVDATE() != null && datax.getISALREADYSUBMIT().toString().equals("1")) {
					
					String crtDate = DateFormatter.formatStringYYYYMMdd(datax.getDOC_RECVDATE(), true);
					Date CreateDate  = DateFormatter.formatYYYYMMDDHHmmss(crtDate);
					
					Calendar c = Calendar.getInstance();
					c.setTime(CreateDate);
					c.getTimeInMillis();
					c.add(Field_dATE, dateRangeComparation);
					
					String dateNow = DateFormatter.formatStringYYYYMMdd(new Date(), true);
					Date Date_Now = DateFormatter.formatYYYYMMDDHHmmss(dateNow);
					Date Create_Date = DateFormatter.formatDateOnly(c.getTime());
					
					if (Date_Now.after(Create_Date)) {
						try {
//							amos_Document_DataProvider.deleteDocumentById(datax.getID());
						} catch (Exception e) {}
					}
				}
				
				clearPic(datax.getAP_REGNO().toString(), datax.getDOC_CODE().toString());
				
			}
		}
	}
	
	private void clearPic(String cOdE, String NoApK) 
	{
		if (listphotoall != null) {
			listphotoall.clear();
		}
		
		listphotoall = photoDataProvider.getATTACHMENTByNomorAndCode(NoApK, cOdE);
		if (listphotoall.size() > 0) {
			for (int i=0;i<listphotoall.size();i++) {
				
				PhotoData datax = listphotoall.get(i);
				if (datax.getUPLOADDATE() != null) {
					
					String crtDate = DateFormatter.formatStringYYYYMMdd(datax.getUPLOADDATE(), true);
					Date CreateDate  = DateFormatter.formatYYYYMMDDHHmmss(crtDate);
					



					Calendar c = Calendar.getInstance();
					c.setTime(CreateDate);
					c.getTimeInMillis();
					c.add(Field_dATE, dateRangeComparation);
					
					String dateNow = DateFormatter.formatStringYYYYMMdd(new Date(), true);
					Date Date_Now = DateFormatter.formatYYYYMMDDHHmmss(dateNow);

					Date Create_Date = DateFormatter.formatDateOnly(c.getTime());
					
					String IDS = datax.getID();
					String NAMES = datax.getFILENAME();
					
					if (Date_Now.after(Create_Date)) {
						try {
//							FileUtility.deleteFile(NAMES, AppConstants.FILEPATH);
//							photoDataProvider.deleteATTACHMENTById(IDS);
						} catch (Exception e) {}




					}

				}
			}
		}


	}

}
