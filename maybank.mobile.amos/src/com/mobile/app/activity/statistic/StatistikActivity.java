package com.mobile.app.activity.statistic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import bii.mobile.mitra.R;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.datatype.DetailAktualData;
import com.mobile.bo.app.datatype.StatistikData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

@SuppressLint("SimpleDateFormat")
public class StatistikActivity extends Activity {
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
    private RelativeLayout contentContainer;
    private ImageView btnBack;
    private Statistik statistik;
    private MasterContent prevShownView = null;
    private Context ctx;
    private StatistikData totalLeadsData;
    private ProgressDialog dlgProgress = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        initActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        finish();
    }

    @SuppressLint("SimpleDateFormat")
    public void initActivity() {
        setContentView(R.layout.statistik_layout);
        try {
            userDetail = (UserData) SessionSharedPreference
                    .getDataFromSharedPreference(ctx, UserData.class,
                            AppConstants.USER_SESSION);
            isUserDetailExist = true;
        } catch (Exception e) {
            finish();
            return;
        }

        lblHeaderUser = (TextView) findViewById(R.id.statistik_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.statistik_lbl_currentdate);
        contentContainer = (RelativeLayout) findViewById(R.id.content_layout);
        btnBack = (ImageView) findViewById(R.id.statistik_btn_back);

        if (isUserDetailExist) {
            lblHeaderUser.setText(String.format("%s # %s",
                    userDetail.getUSERID(), userDetail.getLOCATION()));

            lblDateTime.setText(String.format("%s",
                    DateFormatter.format(new Date())));
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
                finish();
            }
        });

        new LoadStatistik().execute();
    }

    @SuppressLint("SimpleDateFormat")
    public void populateStatisitikView() {
        if (totalLeadsData != null) {
            statistik = new Statistik(ctx);
            //"Tgl","Jumlah Prospek","Jumlah Kenalan","Jumlah PDKT","Jumlah Closing","Ambil Blackbox
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
            header.setText("Tgl");

            rowHeaderTable.addView(header, rowParamsDetail);

            TextView header1 = new TextView(ctx);
            header1.setGravity(Gravity.LEFT);
            header1.setTextColor(getResources().getColor(android.R.color.black));
            header1.setPadding(0, 3, 0, 3);
            header1.setTextSize(12);
            header1.setWidth(70);
            header1.setText("Jml Prospek");
            rowHeaderTable.addView(header1, rowParamsDetail);

            TextView header2 = new TextView(ctx);
            header2.setGravity(Gravity.LEFT);
            header2.setTextColor(getResources().getColor(android.R.color.black));
            header2.setPadding(0, 3, 0, 3);
            header2.setTextSize(12);
            header2.setWidth(70);
            header2.setText("Jml Kenalan");
            rowHeaderTable.addView(header2, rowParamsDetail);

            TextView header3 = new TextView(ctx);
            header3.setGravity(Gravity.LEFT);
            header3.setTextColor(getResources().getColor(android.R.color.black));
            header3.setPadding(0, 3, 0, 3);
            header3.setTextSize(12);
            header3.setWidth(90);
            header3.setText("Jml Pendekatan");
            rowHeaderTable.addView(header3, rowParamsDetail);

            TextView header4 = new TextView(ctx);
            header4.setGravity(Gravity.LEFT);
            header4.setTextColor(getResources().getColor(android.R.color.black));
            header4.setPadding(0, 3, 0, 3);
            header4.setTextSize(12);
            header4.setWidth(70);
            header4.setText("Jml Closing");
            rowHeaderTable.addView(header4, rowParamsDetail);

            TextView header5 = new TextView(ctx);
            header5.setGravity(Gravity.LEFT);
            header5.setTextColor(getResources().getColor(android.R.color.black));
            header5.setPadding(0, 3, 0, 3);
            header5.setTextSize(12);
            header5.setWidth(90);
            header5.setText("Ambil Blackbox");
            rowHeaderTable.addView(header5, rowParamsDetail);

            statistik.getTableLayout().addView(rowHeaderTable);

            // loop data, fill table
            ArrayList<DetailAktualData> arrDetailAktualData = totalLeadsData.getAKTUALDATA();
            Collections.sort(arrDetailAktualData);

            for (int i = 0; i < arrDetailAktualData.size(); i++) {
                DetailAktualData contentdata = arrDetailAktualData.get(i);

                TableRow rowContentTable = new TableRow(this);
                if ((i + 1) % 2 == 0) {
                    rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
                } else {
                    rowContentTable.setBackgroundColor(Color.WHITE);
                }

                String content_date = new SimpleDateFormat("dd/MM")
                        .format(contentdata.getTANGGAL());
                TextView content_tgl = new TextView(ctx);
                content_tgl.setGravity(Gravity.LEFT);
                content_tgl.setTextColor(getResources().getColor(android.R.color.black));
                content_tgl.setPadding(0, 3, 0, 3);
                content_tgl.setTextSize(12);
                content_tgl.setWidth(50);
                content_tgl.setText(content_date);
                rowContentTable.addView(content_tgl, rowParamsDetail);


                TextView content_countprospek = new TextView(ctx);
                content_countprospek.setGravity(Gravity.LEFT);
                content_countprospek.setTextColor(getResources().getColor(android.R.color.black));
                content_countprospek.setPadding(0, 3, 0, 3);
                content_countprospek.setTextSize(12);
                content_countprospek.setWidth(70);
                content_countprospek.setText("" + contentdata.getJUMLAHPROSPEK());
                rowContentTable.addView(content_countprospek, rowParamsDetail);

                TextView content_countkenalan = new TextView(ctx);
                content_countkenalan.setGravity(Gravity.LEFT);
                content_countkenalan.setTextColor(getResources().getColor(android.R.color.black));
                content_countkenalan.setPadding(0, 3, 0, 3);
                content_countkenalan.setTextSize(12);
                content_countkenalan.setWidth(70);
                content_countkenalan.setText(""
                        + contentdata.getJUMLAHKENALAN());
                rowContentTable.addView(content_countkenalan, rowParamsDetail);

                TextView content_countpendekatan = new TextView(ctx);
                content_countpendekatan.setGravity(Gravity.LEFT);
                content_countpendekatan.setTextColor(getResources().getColor(android.R.color.black));
                content_countpendekatan.setPadding(0, 3, 0, 3);
                content_countpendekatan.setTextSize(12);
                content_countpendekatan.setWidth(90);
                content_countpendekatan.setText(""
                        + contentdata.getJUMLAHPENDEKATAN());
                rowContentTable.addView(content_countpendekatan, rowParamsDetail);

                TextView content_countclosing = new TextView(ctx);
                content_countclosing.setGravity(Gravity.LEFT);
                content_countclosing.setTextColor(getResources().getColor(android.R.color.black));
                content_countclosing.setPadding(0, 3, 0, 3);
                content_countclosing.setTextSize(12);
                content_countclosing.setWidth(90);
                content_countclosing.setText(""
                        + contentdata.getJUMLAHCLOSING());
                rowContentTable.addView(content_countclosing, rowParamsDetail);

                TextView content_countblackbox = new TextView(ctx);
                content_countblackbox.setGravity(Gravity.LEFT);
                content_countblackbox.setTextColor(getResources().getColor(android.R.color.black));
                content_countblackbox.setPadding(0, 3, 0, 3);
                content_countblackbox.setTextSize(12);
                content_countblackbox.setWidth(70);
                content_countblackbox.setText(""
                        + contentdata.getBLACKBOXRETRIVAL());

                rowContentTable.addView(content_countblackbox, rowParamsDetail);

                statistik.getTableLayout().addView(rowContentTable);
            }

            if (contentContainer != null) {
                contentContainer.removeView(prevShownView);
            }

            // fill footer information
            statistik.getLblTargetTitle().setText("Target " + new SimpleDateFormat("MMMM yyyy").format((totalLeadsData.getTANGGAL())));
            statistik.getLblProspekValue().setText(
                    "" + totalLeadsData.getTARGETPROSPEK());
            statistik.getLblKenalanValue().setText(
                    "" + totalLeadsData.getTARGETKENALAN());
            statistik.getLblPendekatanValue().setText(
                    "" + totalLeadsData.getTARGETPENDEKATAN());
            statistik.getLblClosingValue().setText(
                    "" + totalLeadsData.getTARGETCLOSING());

            contentContainer.addView(statistik);
            prevShownView = statistik;
        }
    }

    @SuppressWarnings("deprecation")
    public void showProgressIndicator() {
        if (dlgProgress == null) {
            dlgProgress = new ProgressDialog(this);
            dlgProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dlgProgress.setTitle(getString(R.string.str_informasi));
            dlgProgress.setMessage("Data Sedang Dimuat");
            dlgProgress.setCancelable(false);
            dlgProgress.setButton(getString(R.string.str_cancel),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            dlgProgress
                                                    .setMessage("Data Sedang Dimuat");
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

    private class LoadStatistik extends AsyncTask<Void, Void, Void> {
        private boolean responseSuccess = false;

        @Override
        protected void onPreExecute() {
            showProgressIndicator();
        }

        @Override
        protected Void doInBackground(Void... paramss) {
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("userid", userDetail.getUSERID()));

                SERVICEDATARESPONSE statisticResponse = ServiceDataProvider.getStatistikData(params);
                if (statisticResponse != null) {
                    totalLeadsData = ServiceData.getStatistikData(new JSONArray(statisticResponse.getResults()).getJSONObject(0));
                }
                statisticResponse = null;
                responseSuccess = true;
            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (responseSuccess) {
                populateStatisitikView();
            }
            hideProgressIndicator();
        }
    }

}
