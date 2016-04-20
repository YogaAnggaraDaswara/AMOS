package com.mobile.app;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import maybank.mobile.amos.R;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobile.app.configuration.AppConstants;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.JSONServiceHandler;
import com.mobile.services.app.services.ServiceDataProvider;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.CHECKVERSION;


public class UpgradeActivity extends Activity {

    private static final String LOG_TAG = "AppUpgrade";
    private MyWebReceiver receiver;
    private int versionCode = 0;
    String appURI = "";
    private Button btncheck;
    private Button btnUpgrade;
    private DownloadManager downloadManager;
    private long downloadReference;
    public static final String REQUEST_STRING = "myRequest";
    public static final String RESPONSE_STRING = "myResponse";
    public static final String RESPONSE_MESSAGE = "myResponseMessage";
    private static final int REGISTRATION_TIMEOUT = 3 * 1000;
    private static final int WAIT_TIMEOUT = 30 * 1000;
    private String responseMessage = "";
    private ProgressDialog pDialog;

    // Progress dialog type (0 - for Horizontal progress bar)
    public static final int progress_bar_type = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upgradeactivity);

        //Overall information about the contents of a package
        //This corresponds to all of the information collected from AndroidManifest.xml.
        PackageInfo pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        //get the app version Name for display
        String version = pInfo.versionName;
        //get the app version Code for checking
        versionCode = pInfo.versionCode;
        //display the current version in a TextView
        TextView versionText = (TextView) findViewById(R.id.versionName);
        versionText.setText(version);
        btncheck = (Button) findViewById(R.id.checkversion);
        btnUpgrade = (Button) findViewById(R.id.Upgrade);
        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmation(R.string.app_title, R.string.str_confirmation_logout);
            }
        });


        btnUpgrade.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DownloadFileFromURL().execute(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/RetrieveAPK");

            }
        });

	  
	 /* //Broadcast receiver for our Web Request 
	  IntentFilter filter = new IntentFilter(MyWebReceiver.PROCESS_RESPONSE);
	  filter.addCategory(Intent.CATEGORY_DEFAULT);
	  receiver = new MyWebReceiver();
	  registerReceiver(receiver, filter);
	 
	  //Broadcast receiver for the download manager
	  filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
	  registerReceiver(downloadReceiver, filter);
	 
	  //check of internet is available before making a web service request
	  if(isNetworkAvailable(this)){
	   Intent msgIntent = new Intent(this, WebServiceUpgrade.class);
	   msgIntent.putExtra(WebServiceUpgrade.REQUEST_STRING, "http://192.168.0.114/biimobile/contract/FileManagerService.svc/CheckAppVersion");
	   startService(msgIntent);
	  }*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onDestroy() {
	/*  //unregister your receivers
	  this.unregisterReceiver(receiver);
	  this.unregisterReceiver(downloadReceiver);
	  super.onDestroy();*/
    }

    public void showConfirmation(int title, int message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                doLogout();
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton(R.string.str_cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    private void doLogout() {
        ActivityHandler.gotoActivity(this, LoginActivity.class, null);
        finish();
    }

    private void downloadapk() {
        try {
            URL url = new URL(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/RetrieveAPK");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            File sdcard = Environment.getExternalStorageDirectory();
            File file = new File(AppConstants.FILEUPDATE, "BII.MITRA.apk");

            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();

            byte[] buffer = new byte[1024];
            int bufferLength = 0;

            while ((bufferLength = inputStream.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, bufferLength);
            }
            fileOutput.close();
            //this.checkUnknownSourceEnability();
            this.installApk();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type:
                pDialog = new ProgressDialog(this);
                pDialog.setMessage("Downloading file. Please wait...");
                pDialog.setIndeterminate(false);
                //pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pDialog.setCancelable(false);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }

    private void installApk() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(new File(AppConstants.FILEUPDATE + "BII.MITRA.apk"));
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        startActivity(intent);
    }

    //check for internet connection
    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    Log.v(LOG_TAG, String.valueOf(i));
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        Log.v(LOG_TAG, "connected!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //broadcast receiver to get notification when the web request finishes
    public class MyWebReceiver extends BroadcastReceiver {

        public static final String PROCESS_RESPONSE = "com.mobile.app.intent.action.PROCESS_RESPONSE";

        @Override
        public void onReceive(Context context, Intent intent) {

            String reponseMessage = intent.getStringExtra(WebServiceUpgrade.RESPONSE_MESSAGE);
            Log.v(LOG_TAG, reponseMessage);

            //parse the JSON response
            JSONObject responseObj;
            try {
                responseObj = new JSONObject(reponseMessage);
                boolean success = responseObj.getBoolean("success");
                //if the reponse was successful check further
                if (success) {
                    //get the latest version from the JSON string
                    int latestVersion = responseObj.getInt("latestVersion");
                    //get the lastest application URI from the JSON string
                    appURI = responseObj.getString("appURI");
                    //check if we need to upgrade?
                    if (latestVersion > versionCode) {
                        //oh yeah we do need an upgrade, let the user know send an alert message
                        AlertDialog.Builder builder = new AlertDialog.Builder(UpgradeActivity.this);
                        builder.setMessage("There is newer version of this application available, click OK to upgrade now?")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    //if the user agrees to upgrade
                                    public void onClick(DialogInterface dialog, int id) {
                                        //start downloading the file using the download manager
                                        downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                                        Uri Download_Uri = Uri.parse(appURI);
                                        DownloadManager.Request request = new DownloadManager.Request(Download_Uri);
                                        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
                                        request.setAllowedOverRoaming(false);
                                        request.setTitle("My Andorid App Download");
                                        request.setDestinationInExternalFilesDir(UpgradeActivity.this, Environment.DIRECTORY_DOWNLOADS, "MyAndroidApp.apk");
                                        downloadReference = downloadManager.enqueue(request);
                                    }
                                })
                                .setNegativeButton("Remind Later", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // User cancelled the dialog
                                    }
                                });
                        //show the alert message
                        builder.create().show();
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    //broadcast receiver to get notification about ongoing downloads
    private BroadcastReceiver downloadReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            //check if the broadcast message is for our Enqueued download
            long referenceId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            if (downloadReference == referenceId) {

                Log.v(LOG_TAG, "Downloading of the new app version complete");
                //start the installation of the latest version
                Intent installIntent = new Intent(Intent.ACTION_VIEW);
                installIntent.setDataAndType(downloadManager.getUriForDownloadedFile(downloadReference),
                        "application/vnd.android.package-archive");
                installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(installIntent);

            }
        }
    };

    /**
     * Background Async Task to download file
     */
    class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(ProgressDialog.STYLE_SPINNER);
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {

                URL url = new URL(f_url[0]);
                //HttpURLConnection connection = new HttpURLConnection(url);


                HttpURLConnection conection = (HttpURLConnection) url.openConnection();
                int responseCode = conection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // URLConnection conection = url.openConnection();
                    //conection.connect();
                    // getting file length

                    int lenghtOfFile = 1000;
                    String ContenctType = conection.getContentType();
	  
	            /* if(lenghtOfFile<0){
	            	 
	            	 lenghtOfFile = Integer.parseInt(conection.getHeaderField("Content-Length"));
	             }*/
                    // input stream to read file - with 8k buffer
                    InputStream input = new BufferedInputStream(url.openStream(), 8192);
                    /// save image to sdcard
                    File folder = new File(AppConstants.FILEUPDATE);
                    boolean success = true;
                    if (!folder.exists()) {
                        success = folder.mkdirs();
                    }
                    if (success) {
                        // Do something on success
                    } else {
                        // Do something else on failure
                    }
                    // Output stream to write file
                    try {
                        File fileApk = new File(AppConstants.FILEUPDATE + "BII.MITRA.apk");
                        if (!fileApk.exists()) {
                            fileApk.delete();
                        }
                    } catch (Exception ex) {

                    }

                    OutputStream output = new FileOutputStream(AppConstants.FILEUPDATE + "BII.MITRA.apk");

                    byte data[] = new byte[1024];

                    long total = 0;

                    while ((count = input.read(data)) != -1) {
                        total += count;
                        // publishing the progress....
                        // After this onProgressUpdate will be called
                        if (isCancelled()) {
                            input.close();
                            return null;
                        }
                        //if (lenghtOfFile > 0) // only if total length is known
                        //	 publishProgress("" + (int) (total * 100 / lenghtOfFile));

                        //publishProgress(""+(int)((total*100)/lenghtOfFile));

                        // writing data to file
                        output.write(data, 0, count);
                    }

                    // flushing output
                    output.flush();

                    // closing streams
                    output.close();
                    input.close();

                } else {
                    System.out.println("No file to download. Server replied HTTP code: " + responseCode);
                }
                conection.disconnect();
            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));


        }

        /**
         * After completing background task
         * Dismiss the progress dialog
         * *
         */
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
            dismissDialog(progress_bar_type);
            installApk();
        }

    }

}

