package com.mobile.app.activity.tabungan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bii.mobile.mitra.R;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.activity.closing.ClosingActivity;
import com.mobile.app.activity.kenalan.KenalanActivity;
import com.mobile.app.activity.pendekatan.PendekatanActivity;
import com.mobile.app.activity.prospek.ProspekActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.dataprovider.TabunganDataProvider;
import com.mobile.bo.app.datatype.DetailTabunganData;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.bo.app.datatype.TabunganData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.database.app.entities.TABUNGAN;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.activity.ActivityNameValuePair;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.framework.widget.ISpinnerItem;
import com.mobile.services.app.datatype.TRANSAKSIRESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TabunganActivity extends Activity {
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
    private RelativeLayout contentContainer;
    private ImageView btnBack;
    private TabunganDataProvider tabunganDataProvider;
    private Tabungan tabungan;
    private MasterContent prevShownView = null;
    private Context ctx;
    private ProgressDialog dlgProgress = null;
    private DetailTabunganDialog detailTabunganDialog = null;
    private TabunganData rekeningdebitur = null;
    private String CURRENTCIF = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        ctx = this;
        tabunganDataProvider = new TabunganDataProvider();

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
        setContentView(R.layout.tabungan_layout);
        try {
            userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
            isUserDetailExist = true;
        } catch (Exception e) {
            finish();
            return;
        }

        lblHeaderUser = (TextView) findViewById(R.id.tabungan_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.tabungan_lbl_currentdate);
        contentContainer = (RelativeLayout) findViewById(R.id.content_layout);
        btnBack = (ImageView) findViewById(R.id.tabungan_btn_back);

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

        loadTabunganView();
    }


    @SuppressLint("SimpleDateFormat")
    private void loadTabunganView() {
        tabungan = new Tabungan(ctx);
        tabungan.getBtnRequestPIN().setVisibility(View.GONE);

        tabungan.getImgSearchRekening().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSearchDialogRekening();
            }
        });


        tabungan.getBtnClose().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
                finish();
            }
        });

        tabungan.getBtnRequestPIN().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String handphone = tabungan.getTxtHandphone().getText().toString();
                final String nomorRekening = tabungan.getTxtNoRekening().getText().toString();
                if (!handphone.equalsIgnoreCase("")) {
                    showProgressIndicator();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        TRANSAKSIRESPONSE response = ServiceDataProvider.requestToken(nomorRekening, userDetail.getUSERID(), handphone, AppConstants.TRANSTYPETABUNGAN);
                                        if (response != null) {
                                            if (response.getSTATUS() == 1 && response.getNOMORREKENING().equalsIgnoreCase(nomorRekening)) {
                                                showAlert(R.string.msg_notification_success_sendpin);
                                            } else {
                                                showAlert(R.string.msg_notification_error_sendpin);
                                            }
                                        }

                                        response = null;
                                    } catch (Exception e) {
                                        showAlert(R.string.msg_notification_error_sendpin);
                                    }
                                    hideProgressIndicator();
                                }

                            });
                        }

                        ;
                    }).start();
                } else {
                    showAlert(R.string.msg_notification_error_sendpin_uncompletefield);
                }
            }
        });

        tabungan.getBtnSendTransaction().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tabungan.checkContentValidation() == null) {
                    showProgressIndicator();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        String namapenabung = tabungan.getTxtNamaPenabung().getText().toString();
                                        String nomorRekening = rekeningdebitur.getNOMORREKENING().toString();
                                        String totalbayar = tabungan.getTxtSetoran().getText().toString();
                                        totalbayar = totalbayar.replace("Rp ", "").replace(".", "");
                                        String token = "1";// tabungan.getTxtPin().getText().toString();
                                        String nomorhandphone = tabungan.getTxtHandphone().getText().toString();
                                        String cif = rekeningdebitur.getCIF();
                                        String notabungan = tabungan.getTxtNoTabungan().getText().toString();

                                        TRANSAKSIRESPONSE response = ServiceDataProvider.sendTransaksi(nomorRekening, totalbayar, token, userDetail.getUSERID(), nomorhandphone, AppConstants.TRANSTYPETABUNGAN, cif, notabungan, namapenabung);
                                        if (response != null) {
                                            if (response.getSTATUS() == 1 && response.getNOMORREKENING().equalsIgnoreCase(nomorRekening)) {
                                                tabungan.getTxtNoRekening().setSelection(0);
                                                //tabungan.setTxtHandphone(nomorhandphone);
                                                rekeningdebitur.setNOHANDPHONE(nomorhandphone);
                                                tabunganDataProvider.updateTabungan(rekeningdebitur);
                                                tabungan.clearFields();
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
                } else {
                    showAlert(R.string.msg_notification_update_field);
                }
            }
        });

        if (contentContainer != null) {
            contentContainer.removeView(prevShownView);
        }

        contentContainer.addView(tabungan);
        prevShownView = tabungan;
    }

    public void loadSearchDialogRekening() {
        detailTabunganDialog = new DetailTabunganDialog(ctx);
        detailTabunganDialog.getBtnSearch().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detailTabunganDialog.checkContentValidation() == null) {


                    ArrayList<DetailTabunganData> arrDetailTabungan = new ArrayList<DetailTabunganData>();
                    ArrayList<TabunganData> arrTabunganData = tabunganDataProvider.getTabunganByDebitur(detailTabunganDialog.getTxtNamaDebitur().getText().toString());
                    ArrayList<TabunganData> arrTabunganDataTable = new ArrayList<TabunganData>();
                    if (arrTabunganData.size() > 0) {

                        for (int i = 0; i < arrTabunganData.size(); i++) {
                            rekeningdebitur = arrTabunganData.get(i);

                            ArrayList<DetailTabunganData> arrDetail1 = tabunganDataProvider.getDetailTabunganByCif(rekeningdebitur.getCIF());
                            for (DetailTabunganData rowData : arrDetail1) {
                                arrDetailTabungan.add(rowData);
                                arrTabunganDataTable.add(rekeningdebitur);
                            }

                        }
                        populateDataTabungan(arrDetailTabungan, arrTabunganDataTable);
                    } else {
                        showAlert(R.string.msg_notification_error_not_found);
                    }
                } else {
                    showAlert(R.string.msg_notification_update_field);
                }
            }
        });
        detailTabunganDialog.getBtnCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailTabunganDialog.dismiss();
            }
        });
        detailTabunganDialog.show();
    }

    public void populateDataTabungan(ArrayList<DetailTabunganData> arrDetailTabungan, ArrayList<TabunganData> arrTabunganDataTable) {

        if (detailTabunganDialog.getTblDetailRekening().getChildCount() > 0) {
            detailTabunganDialog.getTblDetailRekening().removeAllViewsInLayout();
        }

        //{"No.Rekening","Nama Debitur","Nomor Tabungan","Nama Penabung","Action"};
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
        header.setWidth(100);
        header.setText("No.Rekening");

        rowHeaderTable.addView(header, rowParamsDetail);

        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(150);
        header1.setText("Nama Debitur");
        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(100);
        header2.setText("Nomor Tabungan");
        rowHeaderTable.addView(header2, rowParamsDetail);

        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(150);
        header3.setText("Nama Penabung");
        rowHeaderTable.addView(header3, rowParamsDetail);

        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(55);
        header4.setText("Action");
        rowHeaderTable.addView(header4, rowParamsDetail);


        detailTabunganDialog.getTblDetailRekening().addView(rowHeaderTable);

        for (int i = 0; i < arrDetailTabungan.size(); i++) {
            DetailTabunganData contentdata = arrDetailTabungan.get(i);
            final TableRow rowContentTable = new TableRow(this);
            if ((i + 1) % 2 == 0) {
                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
            } else {
                rowContentTable.setBackgroundColor(Color.WHITE);
            }


            TextView content_rekeningdebitur = new TextView(ctx);
            content_rekeningdebitur.setGravity(Gravity.LEFT);
            content_rekeningdebitur.setTextColor(getResources().getColor(android.R.color.black));
            content_rekeningdebitur.setPadding(0, 3, 0, 3);
            content_rekeningdebitur.setTextSize(12);
            content_rekeningdebitur.setWidth(100);
            content_rekeningdebitur.setText(arrTabunganDataTable.get(i).getNOMORREKENING());
            rowContentTable.addView(content_rekeningdebitur, rowParamsDetail);


            TextView content_namadebitur = new TextView(ctx);
            content_namadebitur.setGravity(Gravity.LEFT);
            content_namadebitur.setTextColor(getResources().getColor(android.R.color.black));
            content_namadebitur.setPadding(0, 3, 0, 3);
            content_namadebitur.setTextSize(12);
            content_namadebitur.setWidth(150);
            content_namadebitur.setText(arrTabunganDataTable.get(i).getNAMADEBITUR());
            rowContentTable.addView(content_namadebitur, rowParamsDetail);

            TextView content_notabungan = new TextView(ctx);
            content_notabungan.setGravity(Gravity.LEFT);
            content_notabungan.setTextColor(getResources().getColor(android.R.color.black));
            content_notabungan.setPadding(0, 3, 0, 3);
            content_notabungan.setTextSize(12);
            content_notabungan.setWidth(100);
            content_notabungan.setText(contentdata.getNOTABUNGAN());
            rowContentTable.addView(content_notabungan, rowParamsDetail);

            TextView content_namapenabung = new TextView(ctx);
            content_namapenabung.setGravity(Gravity.LEFT);
            content_namapenabung.setTextColor(getResources().getColor(android.R.color.black));
            content_namapenabung.setPadding(0, 3, 0, 3);
            content_namapenabung.setTextSize(12);
            content_namapenabung.setWidth(150);
            content_namapenabung.setText(contentdata.getNAMA());
            rowContentTable.addView(content_namapenabung, rowParamsDetail);

            Button content_detail = new Button(ctx);
            content_detail.setGravity(Gravity.LEFT);
            content_detail.setText(R.string.form_action_detail);
            rowContentTable.addView(content_detail, 55, 35);

            content_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tabungan.clearFields();
                    TextView lblHiddenID = (TextView) rowContentTable.getChildAt(2);
                    TextView strNorek = (TextView) rowContentTable.getChildAt(0);
                    DetailTabunganData detailtabungan = tabunganDataProvider.getDetailTabungan(lblHiddenID.getText().toString());
                    rekeningdebitur = tabunganDataProvider.getTabungan(strNorek.getText().toString());
                    tabungan.getTxtNoRekening().setText(rekeningdebitur.getNOMORREKENING());
                    tabungan.getTxtNamaDebitur().setText(rekeningdebitur.getNAMADEBITUR());
                    tabungan.getTxtAlamat().setText(rekeningdebitur.getALAMAT());
                    tabungan.getTxtJenisTabungan().setText(rekeningdebitur.getJENISTABUNGAN());
                    tabungan.getTxtNoTabungan().setText(detailtabungan.getNOTABUNGAN());
                    tabungan.getTxtNamaPenabung().setText(detailtabungan.getNAMA());
                    tabungan.getTxtHandphone().setText(rekeningdebitur.getNOHANDPHONE());
                    tabungan.getBtnRequestPIN().setVisibility(View.GONE);
                    tabungan.getBtnSendTransaction().setVisibility(View.VISIBLE);
                    detailTabunganDialog.dismiss();
                }
            });
            detailTabunganDialog.getTblDetailRekening().addView(rowContentTable);
        }
        arrDetailTabungan = null;
    }

    public void showAlert(int messageId) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.title_activity_tabungan_title_content);
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
