package com.mobile.app.activity.blackbox;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;

import bii.mobile.mitra.R;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.dataprovider.FollowUpDataProvider;
import com.mobile.bo.app.dataprovider.PhotoDataProvider;
import com.mobile.bo.app.dataprovider.ProspekDataProvider;
import com.mobile.bo.app.datatype.FollowupData;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.activity.ActivityNameValuePair;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.common.FileUtility;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.PROSPEKRESPONSE;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.JSONServiceHandler;
import com.mobile.services.app.services.ServiceDataProvider;

import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

@SuppressLint("SimpleDateFormat")
public class BlackboxActivity extends Activity {
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
    private RelativeLayout contentContainer;
    private ImageView btnBack;
    private MasterContent prevShownView = null;
    private Context ctx;
    private ProspekDataProvider prospekDataProvider;
    private FollowUpDataProvider followUpDataProvider = null;
    private PhotoDataProvider photoDataProvider = null;
    private ArrayList<ProspekData> listprospekdata = null;
    private Blackbox blackbox = null;
    private ProgressDialog dlgProgress = null;
    private String loadingMessage = "";
    private static final String TAG = "Blackbox";
    private ArrayList<ProspekData> arrSelectedProspek = null;
    private ArrayList<String> arrSelectedIdx = null;
    private ArrayList<String> arrUnSelectedIdx = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        prospekDataProvider = new ProspekDataProvider();
        followUpDataProvider = new FollowUpDataProvider();
        photoDataProvider = new PhotoDataProvider();
        initActivity();
    }

    @Override
    protected void onDestroy() {
        prospekDataProvider.release();
        followUpDataProvider.release();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        finish();
    }

    @SuppressLint("SimpleDateFormat")
    public void initActivity() {
        setContentView(R.layout.blackbox_layout);
        try {
            userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
            isUserDetailExist = true;
        } catch (Exception e) {
            finish();
            return;
        }

        lblHeaderUser = (TextView) findViewById(R.id.blackbox_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.blackbox_lbl_currentdate);
        contentContainer = (RelativeLayout) findViewById(R.id.content_layout);
        btnBack = (ImageView) findViewById(R.id.blackbox_btn_back);

        if (isUserDetailExist) {
            lblHeaderUser.setText(
                    String.format("%s # %s", userDetail.getNAME(), userDetail.getLOCATION()));
            lblDateTime.setText(String.format("%s", DateFormatter.format(new Date())));
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
                finish();
            }
        });

        loadProspekData();
        populateStatistikDataProspek();
    }

    private void loadProspekData() {
        if (listprospekdata != null) {
            listprospekdata.clear();
        }
        listprospekdata = prospekDataProvider.getBlackboxFromServer();
    }

    private void populateStatistikDataProspek() {
        if (listprospekdata.size() > 0) {
            viewBlackbox();
        } else {
            new LoadBlackbox().execute();
        }
    }

    private void viewBlackbox() {
        /*
			blackbox = new Blackbox(ctx);		
			
			Collections.sort(listprospekdata);			
			TableRow rowHeaderTable = new TableRow(this);
			rowHeaderTable.setBackgroundColor(Color.BLUE);
			rowHeaderTable.setPadding(0, 0, 0, 2);
			for (int i=0;i<AppConstants.HEADER_TABLE_REQUESTBLACKBOX.length;i++){
				 TextView header = new TextView(ctx);
				 header.setText(AppConstants.HEADER_TABLE_REQUESTBLACKBOX[i]);
				 rowHeaderTable.addView(header);
			}
			blackbox.getTableLayout().addView(rowHeaderTable);
						
			for(int i=0;i<listprospekdata.size();i++){
				ProspekData contentdata= listprospekdata.get(i);
				final TableRow rowContentTable = new TableRow(this);
				if ((i+1)%2==0){rowContentTable.setBackgroundColor(Color.BLUE);}
				else{rowContentTable.setBackgroundColor(Color.WHITE);}
				CheckBox content_action_allow = new CheckBox(ctx);
				if (contentdata.isISCHECKED()){
					content_action_allow.setChecked(true);
				}
				rowContentTable.addView(content_action_allow);
				
				TextView content_hiddenId = new TextView(ctx);
				content_hiddenId.setText(contentdata.getID().toString());
				content_hiddenId.setVisibility(View.GONE);
				rowContentTable.addView(content_hiddenId);
				
				TextView content_stageId = new TextView(ctx);
				content_stageId.setText(contentdata.getSTAGE());
				content_stageId.setVisibility(View.GONE);
				rowContentTable.addView(content_stageId);
				
				TextView content_stage = new TextView(ctx);
				content_stage.setText(AppConstants.getStage(contentdata.getSTAGE()));
				rowContentTable.addView(content_stage);
				
				TextView content_mitra = new TextView(ctx);
				content_mitra.setText(contentdata.getUSERID());
				rowContentTable.addView(content_mitra);
				
				TextView content_usaha = new TextView(ctx);
				content_usaha.setText(contentdata.getNAMAUSAHA());
				rowContentTable.addView(content_usaha);
				
				TextView content_date = new TextView(ctx);
				if(contentdata.getDATE() != null){
					content_date.setText(DateFormatter.formatString(contentdata.getDATE()));				
				}
				rowContentTable.addView(content_date);

				Button content_detail = new Button(ctx);
				content_detail.setText(R.string.form_action_detail);
				rowContentTable.addView(content_detail);
				*/

        blackbox = new Blackbox(ctx);
        TableRow rowHeaderTable = new TableRow(this);
        rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
        rowHeaderTable.setPadding(0, 0, 0, 2);

        TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
        rowParamsDetail.gravity = Gravity.LEFT;

        TextView header = new TextView(ctx);
        header.setGravity(Gravity.LEFT);
        header.setTextColor(getResources().getColor(android.R.color.black));
        header.setPadding(0, 3, 0, 3);
        header.setTextSize(12);
        header.setWidth(50);
        header.setText("Allow");

        rowHeaderTable.addView(header, rowParamsDetail);

        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(70);
        header1.setText("Stage");
        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(170);
        header2.setText("Mitra");
        rowHeaderTable.addView(header2, rowParamsDetail);

        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(100);
        header3.setText("Usaha");
        rowHeaderTable.addView(header3, rowParamsDetail);

        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(90);
        header4.setText("Blackbox Date");
        rowHeaderTable.addView(header4, rowParamsDetail);

        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.LEFT);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 3, 0, 3);
        header5.setTextSize(12);
        header5.setWidth(50);
        header5.setText("Lihat");
        rowHeaderTable.addView(header5, rowParamsDetail);

        blackbox.getTableLayout().addView(rowHeaderTable);

        for (int i = 0; i < listprospekdata.size(); i++) {
            final ProspekData contentdata = listprospekdata.get(i);
            final TableRow rowContentTable = new TableRow(this);
            if ((i + 1) % 2 == 0) {
                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
            } else {
                rowContentTable.setBackgroundColor(Color.WHITE);
            }
            final CheckBox content_action_allow = new CheckBox(ctx);
            content_action_allow.setGravity(Gravity.LEFT);
            content_action_allow.setWidth(50);
            if (contentdata.isISCHECKED()) {
                content_action_allow.setChecked(true);
            }
            content_action_allow.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (content_action_allow.isChecked() == false)
                        contentdata.setISCHECKED(false);
                    else
                        contentdata.setISCHECKED(true);

                    prospekDataProvider.updateProspek(contentdata);
                }
            });


            rowContentTable.addView(content_action_allow, rowParamsDetail);

            TextView content_hiddenId = new TextView(ctx);
            content_hiddenId.setText(contentdata.getID().toString());
            content_hiddenId.setVisibility(View.GONE);
            rowContentTable.addView(content_hiddenId);

            TextView content_stageId = new TextView(ctx);
            content_stageId.setText(contentdata.getSTAGE());
            content_stageId.setVisibility(View.GONE);
            rowContentTable.addView(content_stageId);

            TextView content_stage = new TextView(ctx);
            content_stage.setGravity(Gravity.LEFT);
            content_stage.setTextColor(getResources().getColor(android.R.color.black));
            content_stage.setPadding(0, 3, 0, 3);
            content_stage.setTextSize(12);
            content_stage.setWidth(70);
            content_stage.setText(AppConstants.getStage(contentdata.getSTAGE()));
            rowContentTable.addView(content_stage, rowParamsDetail);

            TextView content_mitra = new TextView(ctx);
            content_mitra.setGravity(Gravity.LEFT);
            content_mitra.setTextColor(getResources().getColor(android.R.color.black));
            content_mitra.setPadding(0, 3, 0, 3);
            content_mitra.setTextSize(12);
            content_mitra.setWidth(170);
            content_mitra.setText(contentdata.getUSERID());
            rowContentTable.addView(content_mitra, rowParamsDetail);

            TextView content_usaha = new TextView(ctx);
            content_usaha.setGravity(Gravity.LEFT);
            content_usaha.setTextColor(getResources().getColor(android.R.color.black));
            content_usaha.setPadding(0, 3, 0, 3);
            content_usaha.setTextSize(12);
            content_usaha.setWidth(100);
            content_usaha.setText(contentdata.getNAMAUSAHA());
            rowContentTable.addView(content_usaha, rowParamsDetail);

            TextView content_date = new TextView(ctx);
            content_date.setGravity(Gravity.LEFT);
            content_date.setTextColor(getResources().getColor(android.R.color.black));
            content_date.setPadding(0, 3, 0, 3);
            content_date.setTextSize(12);
            content_date.setWidth(90);
            if (contentdata.getDATE() != null) {
                content_date.setText(DateFormatter.formatString(contentdata.getDATE()));
            }
            rowContentTable.addView(content_date);

            Button content_detail = new Button(ctx);
            content_detail.setGravity(Gravity.LEFT);
            content_detail.setText(R.string.form_action_detail);
            rowContentTable.addView(content_detail, 60, 35);
            content_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView lblHiddenID = (TextView) rowContentTable.getChildAt(1);
                    TextView lblHiddenStage = (TextView) rowContentTable.getChildAt(2);

                    List<ActivityNameValuePair> params = new ArrayList<ActivityNameValuePair>();
                    params.add(new ActivityNameValuePair(AppConstants.KEYPAGESOURCE, AppConstants.PAGEBLACKBOX));
                    params.add(new ActivityNameValuePair(AppConstants.KEYINITIALINDEX, lblHiddenID.getText().toString()));

                    if (lblHiddenStage.getText().toString().equalsIgnoreCase(AppConstants.PROSPEK_TYPE)) {
                        params.add(new ActivityNameValuePair(AppConstants.KEYPROSPEKVIEW, AppConstants.PROSPEK_TYPE));
                        ActivityHandler.gotoActivity(ctx, BlackboxDetailActivity.class, params);
                        finish();
                    } else if (lblHiddenStage.getText().toString().equalsIgnoreCase(AppConstants.KENALAN_TYPE)) {
                        params.add(new ActivityNameValuePair(AppConstants.KEYPROSPEKVIEW, AppConstants.KENALAN_TYPE));
                        ActivityHandler.gotoActivity(ctx, BlackboxDetailActivity.class, params);
                        finish();
                    } else if (lblHiddenStage.getText().toString().equalsIgnoreCase(AppConstants.PENDEKATAN_TYPE)) {
                        params.add(new ActivityNameValuePair(AppConstants.KEYPROSPEKVIEW, AppConstants.PENDEKATAN_TYPE));
                        ActivityHandler.gotoActivity(ctx, BlackboxDetailActivity.class, params);
                        finish();
                    } else if (lblHiddenStage.getText().toString().equalsIgnoreCase(AppConstants.CLOSING_TYPE)) {
                        params.add(new ActivityNameValuePair(AppConstants.KEYPROSPEKVIEW, AppConstants.CLOSING_TYPE));
                        ActivityHandler.gotoActivity(ctx, BlackboxDetailActivity.class, params);
                        finish();
                    }

                }
            });


            blackbox.getTableLayout().addView(rowContentTable);
        }

        if (contentContainer != null) {
            contentContainer.removeView(prevShownView);
        }

        contentContainer.addView(blackbox);
        prevShownView = blackbox;


        blackbox.getBtnRequest().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrSelectedProspek = new ArrayList<ProspekData>();
                arrSelectedIdx = new ArrayList<String>();
                arrUnSelectedIdx = new ArrayList<String>();
                for (int i = 1; i < blackbox.getTableLayout().getChildCount(); i++) {
                    TableRow row = (TableRow) blackbox.getTableLayout().getChildAt(i);
                    CheckBox checkbox = (CheckBox) row.getChildAt(0);
                    TextView lblHiddenID = (TextView) row.getChildAt(1);
                    String prospekId = lblHiddenID.getText().toString();

                    if (checkbox.isChecked()) {
                        arrSelectedIdx.add(prospekId);
                        ProspekData prospekdata = prospekDataProvider.getProspekDetail(prospekId);
                        arrSelectedProspek.add(prospekdata);
                    } else {
                        arrUnSelectedIdx.add(prospekId);
                    }
                }

                if (arrSelectedProspek.size() > 0) {
                    new SendResponseDataBlackbox().execute();
                } else {
                    showAlert(R.string.msg_notification_unselect_row, false);
                }

            }
        });
    }

    public void showAlert(int messageId, final boolean isbacktohome) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.form_blackbox_result);
        alertDialog.setMessage(messageId);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                if (isbacktohome) {
                    ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
                    finish();
                }
            }
        });
        alertDialog.show();
    }


    @SuppressWarnings("deprecation")
    public void showProgressIndicator() {
        if (dlgProgress == null) {
            dlgProgress = new ProgressDialog(this);
            dlgProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dlgProgress.setTitle(getString(R.string.str_informasi));
            dlgProgress.setMessage("Loading Hasil Blackbox");
            dlgProgress.setCancelable(false);
            dlgProgress.setButton(getString(R.string.str_cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    dlgProgress.setMessage(loadingMessage);
                                }
                            });
                        }
                    }).start();
                }
            });
            dlgProgress.show();
        }
    }

    public void hideProgressIndicator() {
        if (dlgProgress != null) {
            dlgProgress.dismiss();
        }
    }

    private class LoadBlackbox extends AsyncTask<Void, Void, Void> {
        private boolean responseSuccess = false;

        @Override
        protected void onPreExecute() {
            loadingMessage = "Memuat Data";
            showProgressIndicator();
        }

        @Override
        protected Void doInBackground(Void... paramss) {
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("userid", userDetail.getUSERID()));
                params.add(new BasicNameValuePair("tanggal", DateFormatter.formatStringYYYYMMdd(new Date(), false)));

                SERVICEDATARESPONSE blackboxResponse = ServiceDataProvider.getBlackboxRetrievalForMitra(params);
                if (blackboxResponse != null) {
                    if (blackboxResponse.getStatus() == 1) {
                        JSONArray arrObjProspek = new JSONArray(blackboxResponse.getResults());
                        List<ProspekData> listprospekService = ServiceData.getDataBlackbox(arrObjProspek);
                        for (int i = 0; i < listprospekService.size(); i++) {
                            prospekDataProvider.updateProspek(listprospekService.get(i));
                            ProspekData prospek = prospekDataProvider.getProspekByProspekId(listprospekService.get(i).getPROSPEKID());
                            photoDataProvider.deletePhotoByProspekid(listprospekService.get(i).getPROSPEKID());
                            // insert followup
                            JSONArray arrObjFollowup = new JSONArray(arrObjProspek.getJSONObject(i).getString("FOLLOWUP"));
                            List<FollowupData> listfollowupService = ServiceData.getDataBlackbox(arrObjFollowup, prospek);
                            for (int j = 0; j < listfollowupService.size(); j++) {
                                followUpDataProvider.udpateFollowUp(listfollowupService.get(j));
                            }
                            // TODO insert photo

                            JSONArray arrObjPhoto = new JSONArray(arrObjProspek.getJSONObject(i).getString("FOTOLOKASI"));
                            List<PhotoData> listphotoService = ServiceData.getDataPhotoBlackbox(arrObjPhoto, prospek);
                            for (int j = 0; j < listphotoService.size(); j++) {
                                photoDataProvider.updatePhoto(listphotoService.get(j));
                            }
                        }
                        listprospekService = null;
                    }
                }
                blackboxResponse = null;
                responseSuccess = true;
            } catch (Exception e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.d(TAG, "Load Data Blackbox: On post Execute");
            if (responseSuccess) {
                loadProspekData();
                viewBlackbox();
            }

            hideProgressIndicator();
        }
    }


    // Task Get Image From Server
    private class SendResponseDataBlackbox extends AsyncTask<Void, Void, Void> {
        private boolean responseSuccess = false;

        protected void onPreExecute() {
            loadingMessage = "Mengirimkan Data";
            showProgressIndicator();
        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.d(TAG, "doInbackground");


            ArrayList<PROSPEKRESPONSE> blackboxResultResponse;
            try {
                blackboxResultResponse = ServiceDataProvider.sendBlackboxResultsForMitra(arrSelectedProspek);

                if (blackboxResultResponse != null) {
                    prospekDataProvider.updateBlackbox(arrSelectedIdx);
                    prospekDataProvider.deleteProspekBlackbox();
                    followUpDataProvider.deleteFollowUpByParents(arrUnSelectedIdx);

                    try {
                        // TODO Download Photo From Server
                        for (int i = 0; i < arrSelectedIdx.size(); i++) {
                            List<PhotoData> arrListPhoto = photoDataProvider.getPhotoByProspek(arrSelectedIdx.get(i));
                            for (int j = 0; j < arrListPhoto.size(); j++) {
                                String id = arrListPhoto.get(j).getID().toString();
                                String prospekid = arrListPhoto.get(j).getPROSPEKID().toString();
                                String filename = arrListPhoto.get(j).getFILENAME().toString();
                                if (!arrListPhoto.get(j).isISFILEALREADYAVAILABLE()) {
                                    try {
                                        DownloadImageFromUrl(id, prospekid, filename);
                                        arrListPhoto.get(j).setISFILEALREADYAVAILABLE(true);
                                        photoDataProvider.updatePhoto(arrListPhoto.get(j));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                    try {
                        // TODO Delete Photo Of Unselected Prospek
                        for (int i = 0; i < arrUnSelectedIdx.size(); i++) {
                            ArrayList<PhotoData> arrPhotos = photoDataProvider.getPhotoByProspek(arrUnSelectedIdx.get(i));

                            for (int j = 0; j < arrPhotos.size(); j++) {
                                PhotoData photo = arrPhotos.get(j);
                                //									try {
                                //										FileUtility.deleteFile(photo.getFILENAME(), AppConstants.FILEPATH);
                                //									}
                                //									catch(Exception e){
                                //										e.printStackTrace();
                                //									}
                                photoDataProvider.deletePhotoById(photo.getID().toString());
                            }
                        }
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                    responseSuccess = true;
                }

                blackboxResultResponse = null;

            } catch (Exception e1) {

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.d(TAG, "Response Data Blackbox: On post Execute");
            hideProgressIndicator();
            if (responseSuccess) {
                showAlert(R.string.msg_notification_submit_success, true);
            } else {
                showAlert(R.string.msg_notification_submit_failed, false);
            }
        }
    }


    public void DownloadImageFromUrl(String id, String prospekId, String fileName) throws Exception {
        Log.d(TAG, "Starting Download Image: " + fileName);

        File file = new File(AppConstants.FILEPATH + fileName);
        if (!file.exists()) {
            URL url = new URL(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/RetrieveFile/?ID=" + id + "&Prospekid=" + prospekId + "&filename=" + fileName);
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
            FileOutputStream fos = new FileOutputStream(AppConstants.FILEPATH + fileName);
            fos.write(baf.toByteArray());
            fos.close();
        }
    }
}
