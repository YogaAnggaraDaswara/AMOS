package com.mobile.app.servicebackground;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.jar.Pack200.Packer;
import android.net.Uri;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

import maybank.mobile.amos.R;

import com.google.gson.Gson;
import com.mobile.app.LoginActivity;
import com.mobile.app.UpgradeActivity;
//import com.mobile.app.activity.common.GPSTracker;
//import com.mobile.app.activity.inbox.InboxActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.bo.app.dataprovider.Amos_Entry_Debitur;
import com.mobile.bo.app.dataprovider.Appr_Attachment;
import com.mobile.bo.app.dataprovider.Appr_Email;
import com.mobile.bo.app.dataprovider.FollowUpDataProvider;
import com.mobile.bo.app.dataprovider.GeoLocationDataProvider;
import com.mobile.bo.app.dataprovider.LoginHistoryDataProvider;
import com.mobile.bo.app.dataprovider.MessageDataProvider;
import com.mobile.bo.app.dataprovider.PhotoDataProvider;
import com.mobile.bo.app.dataprovider.ProspekDataProvider;
import com.mobile.bo.app.dataprovider.StateHistoryDataProvider;
import com.mobile.bo.app.dataprovider.UserDataProvider;
import com.mobile.bo.app.datatype.DataType_Amos_Debitur_Int;
import com.mobile.bo.app.datatype.DataType_Amos_Email;
import com.mobile.bo.app.datatype.Datatype_attachment;
import com.mobile.bo.app.datatype.GeoLocationData;
import com.mobile.bo.app.datatype.LoginHistoryData;
import com.mobile.bo.app.datatype.MessageData;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.bo.app.datatype.StateHistoryData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.database.app.common.DataConverter;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.common.FileUtility;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.CHECKVERSION;
import com.mobile.services.app.datatype.DATA_RESPONSE_SCORE;
import com.mobile.services.app.datatype.PHOTORESPONSE;
import com.mobile.services.app.datatype.PROSPEKRESPONSE;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.JSONServiceHandler;
import com.mobile.services.app.services.ServiceDataProvider;

import android.R.integer;
import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class Alarm extends BroadcastReceiver {
    private static final String TAG = "Alarm Service";
    protected LocationManager _locationManager;
    private Appr_Email appr_Email = new Appr_Email();
	private ArrayList<DataType_Amos_Email> dataType_Amos_Email = new ArrayList<DataType_Amos_Email>();
	
	private PhotoDataProvider photoDataProvider;
	private PhotoData photodata;
    Context ctx;
    PackageManager packageManager;
    int versionName = 0;
    private UserData userDetail;
	private Appr_Attachment appr_Attachment;
	private PhotoDataProvider photoData;
    @SuppressWarnings("deprecation")
    @SuppressLint("Wakelock")
    @Override
    public void onReceive(Context context, Intent intent) {
        //////
    	appr_Attachment=new Appr_Attachment();
    	photoData=new PhotoDataProvider();
    	appr_Email = new Appr_Email();
    	dataType_Amos_Email = new ArrayList<DataType_Amos_Email>();
    	photoDataProvider=new PhotoDataProvider();
    	photodata=new PhotoData();
    	ctx=context;
    	try {
			userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(context, UserData.class, AppConstants.USER_SESSION);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
            /*boolean itsWork = SystemClock.setCurrentTimeMillis(1330082817000);
			System.out.println(itsWork); */

            Calendar c = Calendar.getInstance();
            c.set(2013, 8, 15, 12, 34, 56);
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            am.setTime(c.getTimeInMillis());


        } catch (Exception ex) {
            Log.wtf("Calender", ex.getMessage().toString());

        }

        //////

        int scheduletype = intent.getExtras().getInt("code");
        String startTime = intent.getExtras().getString("start") + ":001";
        String endTime = intent.getExtras().getString("end") + ":01";
        //Toast.makeText(context, "" + scheduletype, //Toast.LENGTH_LONG).show();


        Date date = new Date();
        SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currDate = new Date(parseFormat.format(date));

        Date startDate = DateFormatter.formatYYYYMMDDHHmmss((currDate.getYear() + 1900) + "/" + (currDate.getMonth() + 1) + "/" + (currDate.getDate()) + " " + startTime);
        Date endtDate = DateFormatter.formatYYYYMMDDHHmmss((currDate.getYear() + 1900) + "/" + (currDate.getMonth() + 1) + "/" + (currDate.getDate()) + " " + endTime);

        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();
        
        
        if (currDate.after(startDate) && currDate.before(endtDate)) {
        	
        	if(scheduletype == AppConstants.ALARM_CLEANING){
            // //Toast.makeText(context, "Scheduler GPS Run Every Minute "+startTime+" - "+endTime, //Toast.LENGTH_LONG).show();
            try {
               // _locationManager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
               // boolean _isGPSEnabled = _locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                //if (!_isGPSEnabled)
            	
                //new GetDataPDF().execute();
                //new GetDataGenPDF().execute();
                //new GetDataImage().execute();

                //CheckUpgradeTask(context);
                SendEmail();
                //SendImage();
                //if (!isURLReachable(ctx)) {
                //    notificationVPN(ctx);
                //}


               // new GPSTask().execute();
                //notificationVersion(context);
            } catch (Exception ex) {
                Log.wtf("GPS Check", ex.getMessage().toString());

            
            }
        
        	}
        }
        
       /*
        if (scheduletype == AppConstants.ALARM_PENDINGUPLOADPHOTOTAKS && currDate.after(startDate) && currDate.before(endtDate)) {
            //Toast.makeText(context, "Scheduler PendingUploadedPhotosTask Run Every Minute"+startTime+" - "+endTime, //Toast.LENGTH_LONG).show();
            new PendingUploadPhotosTask().execute();
        }*/

        wl.release();
    }

    static public boolean isURLReachable(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()) {
                try {
                    URL url = new URL("http://10.225.16.30");   // Change to "http://google.com" for www  test.
                    //URL url = new URL("http://172.17.23.60");   // Change to "http://google.com" for www  test.
                    //URL url = new URL("http://172.17.23.60");   // Change to "http://google.com" for www  test.
                    HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                    urlc.setConnectTimeout(10 * 1000);          // 10 s.
                    urlc.connect();
                    if (urlc.getResponseCode() == 200) {        // 200 = "OK" code (http connection is fine).
                        Log.wtf("Connection", "Success !");
                        return true;
                    } else {
                        return false;
                    }
                } catch (MalformedURLException e1) {
                    return false;
                } catch (IOException e) {
                    return false;
                }
            } else {
                setMobileDataEnabled(context, true);
            }
        } catch (Exception ex) {

            Log.wtf("connection", ex.getMessage());
        }
        return false;
    }
    
    private void SendImage(){
    	ArrayList<PhotoData> arrdataPhoto = photoDataProvider.getATTACHMENTByProspekAll();
		if (arrdataPhoto.size() > 0) {
//							Gson gsondataPhoto = new Gson();
			for (int i = 0; i < arrdataPhoto.size(); i++) {
				photodata = new PhotoData();
				
				//String ISALREADYUPLOADEDTOSERVER =  arrdataPhoto.get(i).getISALREADYUPLOADEDTOSERVER();
				//if(ISALREADYUPLOADEDTOSERVER.toString().equals("0")) { // belum terupload
					ArrayList<NameValuePair> params2 = new ArrayList<NameValuePair>();
					
					String[] splitImg = arrdataPhoto.get(i).getFILENAME().toString().split("___.");
					String imgName = splitImg[0] + "___";
					String imgExt = splitImg[1];
					
					params2.add(new BasicNameValuePair("ID", arrdataPhoto.get(i).getID().toString()));
					params2.add(new BasicNameValuePair("AP_REGNO", arrdataPhoto.get(i).getAP_REGNO().toString()));
					params2.add(new BasicNameValuePair("FILENAME", arrdataPhoto.get(i).getFILENAME().toString()));
					params2.add(new BasicNameValuePair("DOC_CODE", arrdataPhoto.get(i).getATTACH_TYPE().toString()));
					params2.add(new BasicNameValuePair("FILE_CAB", "DOC"));
					params2.add(new BasicNameValuePair("FILE_NAME", imgName));
					params2.add(new BasicNameValuePair("FILE_EXT", imgExt));
					params2.add(new BasicNameValuePair("UPLOADER", arrdataPhoto.get(i).getUPLOADBY().toString()));
					params2.add(new BasicNameValuePair("FILE_PATH", ""));
					
					try{
						params2.add(new BasicNameValuePair("UPLOADDATE", DataConverter.dateTimeToString(arrdataPhoto.get(i).getUPLOADDATE())));
					}
					catch(Exception ex)
					{
						params2.add(new BasicNameValuePair("UPLOADDATE", ""));
					}
					try{
						PHOTORESPONSE photoResponse = ServiceDataProvider.uploadProspekPhoto(params2, arrdataPhoto.get(i).getFILENAME().toString());
						
						String photoresStatus = photoResponse.getSTATUS().toString();
						if (photoresStatus.toString().equals("1")) {
							photodata = photoDataProvider.getATTACHMENTDetail(arrdataPhoto.get(i).getID().toString());
							photodata.setID(arrdataPhoto.get(i).getID().toString());
				            photodata.setAP_REGNO(arrdataPhoto.get(i).getAP_REGNO().toString());
				            photodata.setISALREADYUPLOADEDTOSERVER("1"); // terupload
				            photoDataProvider.updateATTACHMENT(photodata);
				            FileUtility.deleteFile(photodata.getFILENAME().toString(), AppConstants.FILEPATH);
				            
				            //photoDataProvider.deleteATTACHMENTById(arrdataPhoto.get(i).getID().toString());
							//uploadBit = AppConstants.BERHASIL;
						} else {
							//uploadBit = AppConstants.GAGALUPLOADFILE;
							break;
						}
						
						
					}
					catch(Exception ex)
					{
						
					}
					
					
					
				//}
			}
		}
    }
    private void SendEmail() {
    	try{
    	dataType_Amos_Email=appr_Email.getAllEmail();
    	 for (int i = 0; i < dataType_Amos_Email.size(); i++) {
    		 DataType_Amos_Email DataType_Amos_Email1=new DataType_Amos_Email();
    		 DataType_Amos_Email1 = dataType_Amos_Email.get(i);					
				if (DataType_Amos_Email1 !=null){
					try {
						Gson gsondata=new Gson();
						
						ArrayList<DATA_RESPONSE_SCORE> Response = ServiceDataProvider.submitData_email(gsondata.toJson(DataType_Amos_Email1).toString());
						if (Response != null){
							if (Response.size() > 0){
								for (int a=0;i<Response.size();i++ ){
									DATA_RESPONSE_SCORE objRes= Response.get(a);
									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)) {
										String id=objRes.getID();
										appr_Email.deleteEmail(DataType_Amos_Email1.getID());
										
							
										
									}
								}	
							}		
						}
						else{
							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
						}
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}

				DataType_Amos_Email1 = null;
    	 }
    	}
    	 catch (Exception e) {
    		 Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
		}
    }

    private Boolean CheckIPServer() {
        boolean network = false;
        try {
            if (InetAddress.getByAddress("192.168.43.62".getBytes()).isReachable(1000) == true) {
                //Boolean variable named network
                network = true; //Ping works
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return network;
    }

    private void notificationVPN(Context context) {
        long time = new Date().getTime();
        String tmpStr = String.valueOf(time);
        String last4Str = tmpStr.substring(tmpStr.length() - 5);
        int notificationId = Integer.valueOf(AppConstants.IDNOTIFVPN);

        int icon = R.drawable.vpn;
        CharSequence tickerText = "VPN Status";
        long when = System.currentTimeMillis();
        Notification notification = new Notification(icon, tickerText, when);

        CharSequence contentTitle = "Pemberitahuan";
        CharSequence contentText = "VPN Tidak Dinyalakan";
        //Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        //PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, 0);
        notification.setLatestEventInfo(context, contentTitle, contentText, null);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.PRIORITY_HIGH;
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notificationId, notification);


    }

    private void notificationGPS(Context context) {
        long time = new Date().getTime();
        String tmpStr = String.valueOf(time);
        String last4Str = tmpStr.substring(tmpStr.length() - 5);
        int notificationId = Integer.valueOf(AppConstants.IDNOTIFGPS);

        int icon = R.drawable.gps;
        CharSequence tickerText = "GPS Status";
        long when = System.currentTimeMillis();
        Notification notification = new Notification(icon, tickerText, when);

        CharSequence contentTitle = "Pemberitahuan";
        CharSequence contentText = "GPS Tidak Dinyalakan";
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, 0);
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.PRIORITY_HIGH;
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notificationId, notification);


    }

    private static void setMobileDataEnabled(Context context, boolean enabled) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        try {
            final ConnectivityManager conman = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            final Class conmanClass = Class.forName(conman.getClass().getName());
            final java.lang.reflect.Field iConnectivityManagerField = conmanClass.getDeclaredField("mService");
            iConnectivityManagerField.setAccessible(true);
            final Object iConnectivityManager = iConnectivityManagerField.get(conman);
            final Class iConnectivityManagerClass = Class.forName(iConnectivityManager.getClass().getName());
            final Method setMobileDataEnabledMethod = iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
            setMobileDataEnabledMethod.setAccessible(true);
            setMobileDataEnabledMethod.invoke(iConnectivityManager, enabled);
        } catch (Exception ex) {

            Log.wtf("Open Mobile Data", ex.getMessage().toString());
        }
    }

    private Activity getApplicationContext() {
        // TODO Auto-generated method stub
        return null;
    }

    private void notificationVersion(Context context, int intVersion) {
        long time = new Date().getTime();
        String tmpStr = String.valueOf(time);
        String last4Str = tmpStr.substring(tmpStr.length() - 5);
        int notificationId = Integer.valueOf("88" + last4Str);

        int icon = R.drawable.icon_app;
        CharSequence tickerText = "Update Mobile Lead";
        long when = System.currentTimeMillis();
        Notification notification = new Notification(icon, tickerText, when);

        CharSequence contentTitle = "Update BII Mitra Leads Versi " + intVersion;
        CharSequence contentText = "Silahkan ketuk untuk update aplikasi";
        Intent notificationIntent = new Intent(context, UpgradeActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.PRIORITY_HIGH;
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(AppConstants.IDNOTIFVERSION, notification);


    }

    private void notificationMessage(Context context, int totalMessage) {

        long time = new Date().getTime();
        String tmpStr = String.valueOf(time);
        String last4Str = tmpStr.substring(tmpStr.length() - 5);
        int notificationId = Integer.valueOf("99" + last4Str);

        int icon = R.drawable.newmessage;
        CharSequence tickerText = "Message";
        long when = System.currentTimeMillis();
        Notification notification = new Notification(icon, tickerText, when);

        CharSequence contentTitle = "Ada " + totalMessage + " Pesan Baru";
        CharSequence contentText = "Silahkan ketuk untuk masuk aplikasi";
        Intent notificationIntent = new Intent(context, LoginActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.PRIORITY_HIGH;
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(AppConstants.IDNOTIFINBOX, notification);


    }

    public void SetAlarm(Context context, int reqcode, long interval, String start, String end) {
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, Alarm.class);
        intent.putExtra("code", reqcode);
        intent.putExtra("start", start);
        intent.putExtra("end", end);
        PendingIntent pendingintent = PendingIntent.getBroadcast(context, reqcode, intent, 0);
        am.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), interval, pendingintent);
    }

    public void CancelAlarm(Context context) {
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }

    /**
     * Activity To be scheduled *
     */
   
    // Task Pending Upload Photo
    private class PendingUploadPhotosTask extends AsyncTask<Void, Void, Void> {
        PhotoDataProvider photoDataProvider = new PhotoDataProvider();
        ProspekDataProvider prospekDataProvider = new ProspekDataProvider();

        @Override
        protected Void doInBackground(Void... photoId) {
            Log.d(TAG, "doInbackground");
            /* ArrayList<PhotoData> arrListPhoto = photoDataProvider.getPendingUploadedPhotos();
            if (arrListPhoto.size() > 0) {
                for (int i = 0; i < arrListPhoto.size(); i++) {
                    try {

                        PhotoData photo = arrListPhoto.get(i);
                        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                        params.add(new BasicNameValuePair("id", photo.getID().toString()));
                        params.add(new BasicNameValuePair("prospekid", photo.getPROSPEKID()));
                        params.add(new BasicNameValuePair("filename", photo.getFILENAME()));

                        PHOTORESPONSE photoResponse = ServiceDataProvider.uploadProspekPhoto(params, photo.getFILENAME());

                        if (photoResponse != null) {
                            if (photoResponse.getFILENAME().equalsIgnoreCase(photo.getFILENAME())) {
                                photo.setISALREADYUPLOADEDTOSERVER(true);
                                photo.setISPENDINGUPLOADED(false);
                            }
                            photoDataProvider.updatePhoto(photo);
                        }

                        // Remove photo which parent is not exist anymore, case:after submit blackbox or  submit closing
                        ProspekData prospek = prospekDataProvider.getProspekByProspekId(photo.getPROSPEKID());
                        if (prospek == null) {
                            FileUtility.deleteFile(photo.getFILENAME(), AppConstants.FILEPATH);
                            photoDataProvider.deletePhotoByFileName(photo.getFILENAME());
                        }

                        photoResponse = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }*/

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.d(TAG, "Pending Uploaded Photos Tasks: On post Execute");
            photoDataProvider = null;
            prospekDataProvider = null;
        }
    }
    
    private void CheckUpgradeTask(Context context) {
        Log.d(TAG, "doInbackground");
        packageManager = context.getPackageManager();

        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                versionName = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                versionName = 0;
            }

        }
        try {
            ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>();
            params1.add(new BasicNameValuePair("appname", "AMOS"));
            params1.add(new BasicNameValuePair("Imei", "11111"));
            SERVICEDATARESPONSE versionResponse = ServiceDataProvider.CheckVersion(params1);

            if (versionResponse != null) {
                ArrayList<CHECKVERSION> arrvERSIONData = ServiceData.getVersion(new JSONArray(versionResponse.getResults()));
                //Toast.makeText(context, "" + arrvERSIONData.get(0).LATESTVERSION.toString() + "===" + versionName, //Toast.LENGTH_LONG).show();
                if (Integer.parseInt(arrvERSIONData.get(0).LATESTVERSION.toString()) > versionName) {
                    notificationVersion(context, Integer.parseInt(arrvERSIONData.get(0).LATESTVERSION.toString()));
                }

            }

        } catch (Exception ex) {
            //Toast.makeText(context, "" + ex.getMessage(), //Toast.LENGTH_LONG).show();

        }

    }
   
    private class GetDataImage extends AsyncTask<Void, Void,Void> {
  		boolean bolstatus=false;
  		@Override
  		protected Void doInBackground(Void... params) {
  			
  			
  				ArrayList<PhotoData> arrdata = photoData.getPendingDownloadATTACHMENTs();
				if (arrdata.size() > 0){
					for (int x=0;x<arrdata.size();x++ ){
						PhotoData appr_Attachmentdata=arrdata.get(x);
						
						if(appr_Attachmentdata.getISALREADYDOWNLOD().equals("0") ||  appr_Attachmentdata.getISALREADYDOWNLOD().equals("") ||  appr_Attachmentdata.getISALREADYDOWNLOD()==null )
						{
							try{
				         		DownloadImageFromUrlImage(appr_Attachmentdata.getCOL_ID().toString(),appr_Attachmentdata.getAP_REGNO().toString() ,appr_Attachmentdata.getFILEFOLDER() + "/" + appr_Attachmentdata.getFILENAME().toString() ,appr_Attachmentdata.getFILENAME().toString());
				                appr_Attachmentdata.setISALREADYDOWNLOD("1");	  
				         		photoData.updateATTACHMENT(appr_Attachmentdata);
							} catch (Exception e) {
				 				// TODO Auto-generated catch block
				 				e.printStackTrace();
				 			}	
						}
					}
				}
				else{
					//Log.d(TAG, "No data to be syncronized");
				}
				arrdata = null;
  			
				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			
  		 }	 
      }

    public String DownloadImageFromUrl(String AP_REGNO, String COL_ID, String GENERATE_TYPE,String GENERATE_TYPE_REFF) throws Exception {
    	  String fileName="Test.pdf";
        //if (!file.exists()) {
            URL url = new URL(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/RetrieveFileGen/?AP_REGNO=" + AP_REGNO + "&COL_ID=" + COL_ID + "&GENERATE_TYPE=" + GENERATE_TYPE + "&GENERATE_TYPE_REFF=" + GENERATE_TYPE_REFF );
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
    public String DownloadImageFromUrlPDF(String AP_REGNO, String COL_ID, String FILENAME) throws Exception {
  	  String fileName="Test.pdf";
      //if (!file.exists()) {
  	      URL url = new URL(Uri.decode(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/RetrieveFileGenPDF/?AP_REGNO=" + URLEncoder.encode(AP_REGNO) + "&COL_ID=" + URLEncoder.encode(COL_ID) + "&FILENAME=" + URLEncoder.encode(FILENAME) ));
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
    public void DownloadImageFromUrlImage(String id, String prospekId, String fileName,String fileName1) throws Exception {
    	try{
        File file = new File(AppConstants.FILEPATH + fileName1);
        if (!file.exists()) {
            URL url = new URL(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/RetrieveFile/?AP_REGNO=" + prospekId + "&ID=" + id + "&filename=" + URLEncoder.encode(fileName) + "&filename1=" + URLEncoder.encode(fileName1));
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
            FileOutputStream fos = new FileOutputStream(AppConstants.FILEPATH + fileName1);
            fos.write(baf.toByteArray());
            fos.close();
        }
	}
	catch(Exception ex){
		
	}
    }
}
