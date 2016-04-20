package com.mobile.app.activity.cashcheckup;

import java.util.ArrayList;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import bii.mobile.mitra.R;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.datatype.CashCheckupData;
import com.mobile.bo.app.datatype.MitraData;
import com.mobile.bo.app.datatype.TabunganData;
import com.mobile.bo.app.datatype.TagihanData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CashCheckUpActivity extends Activity {
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
    private RelativeLayout contentContainer;
    private ExSpinner spnMitra;
    private ImageView btnBack;
    private ArrayList<ISpinnerItem> lovMitra = new ArrayList<ISpinnerItem>();
    private MasterContent prevShownView = null;
    private Context ctx;
    private ArrayList<MitraData> mitraData;
    private CashCheckupData cashCheckupData;
    private CashCheckup cashCheckup;
    private ProgressDialog dlgProgress = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
        setContentView(R.layout.cashcheckup_layout);
        try {
            userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
            isUserDetailExist = true;
        } catch (Exception e) {
            finish();
            return;
        }

        lblHeaderUser = (TextView) findViewById(R.id.cashcheckup_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.cashcheckup_lbl_currentdate);
        contentContainer = (RelativeLayout) findViewById(R.id.content_layout);
        btnBack = (ImageView) findViewById(R.id.cashcheckup_btn_back);
        spnMitra = (ExSpinner) findViewById(R.id.cashcheckup_view_spn_mitra);

        spnMitra.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                        String selectedMitra = (String) spnMitra.getSelectedListOfValue(position);
                        if (!selectedMitra.equalsIgnoreCase("")) {
                            contentContainer.setVisibility(View.VISIBLE);
                            populateCashCheckup(selectedMitra);
                        } else {
                            contentContainer.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub
                    }
                });

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

        populateMitra();
    }

    private void populateMitra() {
        showProgressIndicator();
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                            params.add(new BasicNameValuePair("userid", userDetail.getUSERID()));

                            SERVICEDATARESPONSE mitraResponse = ServiceDataProvider.getMitra(params);
                            if (mitraResponse != null) {
                                mitraData = ServiceData.getMitra(new JSONArray(mitraResponse.getResults()));
                                if (mitraResponse.getStatus() == 1) {
                                    lovMitra = ListOfValueAdapter.createESAdapterMitra(mitraData);
                                    spnMitra.setListOfValue(lovMitra, false);
                                }
                            }
                            mitraResponse = null;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        hideProgressIndicator();
                    }
                });
            }
        }).start();
    }


    private void populateCashCheckup(final String idMitra) {
        showProgressIndicator();
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                            params.add(new BasicNameValuePair("userid", idMitra));
                            params.add(new BasicNameValuePair("tanggal", DateFormatter.formatStringYYYYMMdd(new Date(), false)));

                            SERVICEDATARESPONSE cashCheckupResponse = ServiceDataProvider.getCashPickup(params);
                            if (cashCheckupResponse != null) {
                                cashCheckupData = ServiceData.getCheckupData(new JSONObject(cashCheckupResponse.getResults()));
                                if (cashCheckupResponse.getStatus() == 1) {
                                    loadCashCheckupView();
                                }
                            }
                            cashCheckupResponse = null;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        hideProgressIndicator();
                    }
                });
            }
        }).start();
    }

    private void loadCashCheckupView() {
        cashCheckup = new CashCheckup(ctx);
        //  table tabungan
        if (cashCheckupData.getTABUNGAN().size() > 0) {
            cashCheckup.getContentTabungan().setVisibility(View.VISIBLE);
            TableRow rowHeaderTable = new TableRow(ctx);
            rowHeaderTable.setBackgroundColor(Color.BLUE);
            rowHeaderTable.setPadding(0, 0, 0, 2);
            for (int headerIdx = 0; headerIdx < AppConstants.HEADER_TABLE_TAGIHAN.length; headerIdx++) {
                TextView header = new TextView(ctx);
                header.setText(AppConstants.HEADER_TABLE_TAGIHAN[headerIdx]);
                rowHeaderTable.addView(header);
            }
            cashCheckup.getTblTabungan().addView(rowHeaderTable);

            for (int i = 0; i < cashCheckupData.getTABUNGAN().size(); i++) {
                TabunganData contentdata = cashCheckupData.getTABUNGAN().get(i);

                final TableRow rowContentTable = new TableRow(this);
                if ((i + 1) % 2 == 0) {
                    rowContentTable.setBackgroundColor(Color.BLUE);
                } else {
                    rowContentTable.setBackgroundColor(Color.WHITE);
                }

                TextView counter = new TextView(ctx);
                counter.setText("" + (i + 1));
                rowContentTable.addView(counter);


                TextView tv_rekening = new TextView(ctx);
                tv_rekening.setText(contentdata.getNOMORREKENING());
                rowContentTable.addView(tv_rekening);

                TextView tv_namadebitur = new TextView(ctx);
                tv_namadebitur.setText(contentdata.getNAMADEBITUR());
                rowContentTable.addView(tv_namadebitur);

                TextView tv_nominal = new TextView(ctx);
                tv_nominal.setText(contentdata.getJUMLAHTABUNGAN());
                rowContentTable.addView(tv_nominal);

                cashCheckup.getTblTabungan().addView(rowContentTable);
            }

            cashCheckup.getLblTotalTabungan().setText("" + cashCheckupData.getTOTALTABUNGAN());
        }

        // tagihan
        if (cashCheckupData.getTABUNGAN().size() > 0) {
            cashCheckup.getContentTagihan().setVisibility(View.VISIBLE);

            TableRow rowHeaderTable = new TableRow(ctx);
            rowHeaderTable.setBackgroundColor(Color.BLUE);
            rowHeaderTable.setPadding(0, 0, 0, 2);
            for (int headerIdx = 0; headerIdx < AppConstants.HEADER_TABLE_TAGIHAN.length; headerIdx++) {
                TextView header = new TextView(ctx);
                header.setText(AppConstants.HEADER_TABLE_TAGIHAN[headerIdx]);
                rowHeaderTable.addView(header);
            }
            cashCheckup.getTblTagihan().addView(rowHeaderTable);

            for (int i = 0; i < cashCheckupData.getTAGIHAN().size(); i++) {
                TagihanData contentdata = cashCheckupData.getTAGIHAN().get(i);

                final TableRow rowContentTable = new TableRow(this);
                if ((i + 1) % 2 == 0) {
                    rowContentTable.setBackgroundColor(Color.BLUE);
                } else {
                    rowContentTable.setBackgroundColor(Color.WHITE);
                }

                TextView counter = new TextView(ctx);
                counter.setText("" + (i + 1));
                rowContentTable.addView(counter);


                TextView tv_rekening = new TextView(ctx);
                tv_rekening.setText(contentdata.getNOMORREKENING());
                rowContentTable.addView(tv_rekening);

                TextView tv_namadebitur = new TextView(ctx);
                tv_namadebitur.setText(contentdata.getNAMADEBITUR());
                rowContentTable.addView(tv_namadebitur);

                TextView tv_nominal = new TextView(ctx);
                tv_nominal.setText(contentdata.getTAGIHAN());
                rowContentTable.addView(tv_nominal);

                cashCheckup.getTblTagihan().addView(rowContentTable);
            }

            cashCheckup.getLblTotalTagihan().setText("" + cashCheckupData.getTOTALTAGIHAN());

        }
        cashCheckup.getContentCashPickup().setVisibility(View.VISIBLE);
        cashCheckup.getLblTotalCashPickup().setText("" + cashCheckupData.getTOTALCASHPICKUP());

        if (cashCheckupData.getTABUNGAN().size() > 0 || cashCheckupData.getTAGIHAN().size() > 0) {
            cashCheckup.getContentAction().setVisibility(View.VISIBLE);
        }


        cashCheckup.getBtnSetuju().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approveUnApproveTransaksi(AppConstants.STATUSAPPROVED);
            }
        });

        cashCheckup.getBtnTidakSetuju().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approveUnApproveTransaksi(AppConstants.STATUSUNAPPROVED);
            }
        });

        contentContainer.addView(cashCheckup);
        prevShownView = cashCheckup;
    }

    public void approveUnApproveTransaksi(final String status) {
        showProgressIndicator();
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                            params.add(new BasicNameValuePair("USERID", spnMitra.getSelectedListOfValue().toString()));
                            params.add(new BasicNameValuePair("STATUS", status));

                            SERVICEDATARESPONSE response = ServiceDataProvider.approveCashCheckup(params);
                            if (response != null) {
                                if (response.getStatus() == 1) {
                                    spnMitra.setSelection(0);
                                    showAlert(R.string.msg_notification_submit_success);
                                } else {
                                    showAlert(R.string.msg_notification_submit_failed);
                                }
                            }

                            response = null;
                        } catch (Exception e) {
                            showAlert(R.string.msg_notification_submit_failed);
                        }
                        hideProgressIndicator();
                    }

                });
            }

            ;
        }).start();
    }

    public void showAlert(int messageId) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.title_activity_cashcheckup);
        alertDialog.setMessage(messageId);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void showProgressIndicator() {
        if (dlgProgress == null) {
            dlgProgress = new ProgressDialog(this);
            dlgProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dlgProgress.setTitle(getString(R.string.str_informasi));
            dlgProgress.setMessage("Data Sedang Dimuat");
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
                                    dlgProgress.setMessage("Data Sedang Dimuat");
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
}
