package com.mobile.app.activity.tagihan;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import bii.mobile.mitra.R;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.dataprovider.TagihanDataProvider;
import com.mobile.bo.app.datatype.TagihanData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
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
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;


@SuppressLint("SimpleDateFormat")
public class TagihanActivity extends Activity {
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
    private RelativeLayout contentContainer;
    private ImageView btnBack;
    private MasterContent prevShownView = null;
    private Context ctx;
    private TagihanDataProvider tagihanDataProvider;
    private ArrayList<TagihanData> listTagihan = null;
    private Tagihan tagihan = null;
    private TagihanDialog tagihanDialog = null;
    private TagihanData detailTagihan = null;
    private ProgressDialog dlgProgress = null;


    private int limit = 10;// display 5 lines of data
    private int pageNo = 0;// page
    private int pageCount = 0;// total number of pages
    private Button btnNext;
    private Button btnPrev;
    private Button btnFirst;
    private Button btnLast;
    private TextView txtPageno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        ctx = this;
        tagihanDataProvider = new TagihanDataProvider();
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
        setContentView(R.layout.tagihan_layout);
        try {
            userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
            isUserDetailExist = true;
        } catch (Exception e) {
            finish();
            return;
        }
        tagihan = new Tagihan(ctx);
        lblHeaderUser = (TextView) findViewById(R.id.tagihan_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.tagihan_lbl_currentdate);
        contentContainer = (RelativeLayout) findViewById(R.id.content_layout);

        btnBack = (ImageView) findViewById(R.id.tagihan_btn_back);
        btnNext = (Button) tagihan.getbuttonlayout().findViewById(R.id.btn_next);
        btnPrev = (Button) tagihan.getbuttonlayout().findViewById(R.id.btn_prev);
        btnFirst = (Button) tagihan.getbuttonlayout().findViewById(R.id.btn_first);
        btnLast = (Button) tagihan.getbuttonlayout().findViewById(R.id.btn_last);
        txtPageno = (TextView) tagihan.getbuttonlayout().findViewById(R.id.txtPageno);
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
        pageCount = (tagihanDataProvider.getAllTagihanCount());
        pageCount = (pageCount / limit);
        if (pageCount >= 1)
            pageNo = 1;
        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // TODO Auto-generated method stub
                    showProgressIndicator();
                    if (pageCount > pageNo) {
                        pageNo++;
                        listTagihan = tagihanDataProvider.getAllTagihan(limit, pageNo);
                        loadViewTagihan();
                        setpageNo(pageNo);
                    }
                    hideProgressIndicator();
                } catch (Exception ex) {
                    showAlert(ex.getMessage().toString());
                }
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // TODO Auto-generated method stub
                    showProgressIndicator();
                    if (pageNo > 1) {
                        pageNo--;
                        listTagihan = tagihanDataProvider.getAllTagihan(limit, pageNo);
                        loadViewTagihan();
                        setpageNo(pageNo);
                    }
                    hideProgressIndicator();
                } catch (Exception ex) {
                    showAlert(ex.getMessage().toString());
                }
            }

        });

        btnFirst.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // TODO Auto-generated method stub
                    showProgressIndicator();
                    if (pageCount > 1 && pageNo != 1) {
                        listTagihan = tagihanDataProvider.getAllTagihan(limit, 1);
                        pageNo = 1;
                        loadViewTagihan();
                        setpageNo(1);
                    }
                    hideProgressIndicator();
                    //if(pageCount==pageNo_
                    //disable pageno
                } catch (Exception ex) {
                    showAlert(ex.getMessage().toString());
                }
            }
        });
        btnLast.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    showProgressIndicator();
                    // TODO Auto-generated method stub
                    if (pageCount > 1 && pageNo != pageCount) {
                        listTagihan = tagihanDataProvider.getAllTagihan(limit, pageCount);
                        pageNo = pageCount;
                        loadViewTagihan();
                        setpageNo(pageCount);
                    }
                    hideProgressIndicator();
                    //if(pageCount==pageNo_
                    //disable pageno
                } catch (Exception ex) {
                    showAlert(ex.getMessage().toString());
                }
            }
        });

        loadDataTagihan(1);
        loadViewTagihan();
    }

    private void setpageNo(int pageNo) {
        String text = null;
        text = pageNo + "/" + pageCount;
        txtPageno.setText(text);
    }

    private void loadDataTagihan(int pageno) {
        if (listTagihan != null) {
            listTagihan.clear();
        }
        setpageNo(pageno);
        listTagihan = tagihanDataProvider.getAllTagihan(limit, pageno);
    }

    private void loadViewTagihan() {
        if (listTagihan != null) {
            if (tagihan.getTableLayout() != null)
                tagihan.getTableLayout().removeAllViews();

            //tagihan = new Tagihan(ctx);
            //{"No","No.Rekening","Nama Debitur","Nominal","Sisa Tagihan","Action"};
            Collections.sort(listTagihan);
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
            header.setWidth(25);
            header.setText("No");
            rowHeaderTable.addView(header, rowParamsDetail);

            TextView header1 = new TextView(ctx);
            header1.setGravity(Gravity.LEFT);
            header1.setTextColor(getResources().getColor(android.R.color.black));
            header1.setPadding(0, 3, 0, 3);
            header1.setTextSize(12);
            header1.setWidth(100);
            header1.setText("No.Rekening");
            rowHeaderTable.addView(header1, rowParamsDetail);

            TextView header2 = new TextView(ctx);
            header2.setGravity(Gravity.LEFT);
            header2.setTextColor(getResources().getColor(android.R.color.black));
            header2.setPadding(0, 3, 0, 3);
            header2.setTextSize(12);
            header2.setWidth(180);
            header2.setText("Nama Debitur");
            rowHeaderTable.addView(header2, rowParamsDetail);

            TextView header3 = new TextView(ctx);
            header3.setGravity(Gravity.LEFT);
            header3.setTextColor(getResources().getColor(android.R.color.black));
            header3.setPadding(0, 3, 0, 3);
            header3.setTextSize(12);
            header3.setWidth(100);
            header3.setText("Nominal");
            rowHeaderTable.addView(header3, rowParamsDetail);

            TextView header4 = new TextView(ctx);
            header4.setGravity(Gravity.LEFT);
            header4.setTextColor(getResources().getColor(android.R.color.black));
            header4.setPadding(0, 3, 0, 3);
            header4.setTextSize(12);
            header4.setWidth(100);
            header4.setText("Sisa Tagihan");
            rowHeaderTable.addView(header4, rowParamsDetail);

            TextView header5 = new TextView(ctx);
            header5.setGravity(Gravity.LEFT);
            header5.setTextColor(getResources().getColor(android.R.color.black));
            header5.setPadding(0, 3, 0, 3);
            header5.setTextSize(12);
            header5.setWidth(60);
            header5.setText("Action");
            rowHeaderTable.addView(header5, rowParamsDetail);

            tagihan.getTableLayout().addView(rowHeaderTable);

            // loop data
            int intnomor = 0;
            if (pageNo > 1)
                intnomor = pageNo * 10;

            for (int i = 0; i < listTagihan.size(); i++) {
                TagihanData contentdata = listTagihan.get(i);

                final TableRow rowContentTable = new TableRow(this);
                if ((i + 1) % 2 == 0) {
                    rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
                } else {
                    rowContentTable.setBackgroundColor(Color.WHITE);
                }

                TextView counter = new TextView(ctx);
                counter.setGravity(Gravity.LEFT);
                counter.setTextColor(getResources().getColor(android.R.color.black));
                counter.setPadding(0, 3, 0, 3);
                counter.setTextSize(12);
                counter.setWidth(25);
                counter.setText("" + (i + 1 + intnomor));
                rowContentTable.addView(counter, rowParamsDetail);


                TextView tv_valuehidden = new TextView(ctx);
                tv_valuehidden.setText(contentdata.getID().toString());
                rowContentTable.addView(tv_valuehidden);
                tv_valuehidden.setVisibility(View.GONE);

                TextView tv_rekening = new TextView(ctx);
                tv_rekening.setGravity(Gravity.LEFT);
                tv_rekening.setTextColor(getResources().getColor(android.R.color.black));
                tv_rekening.setPadding(0, 3, 0, 3);
                tv_rekening.setTextSize(12);
                tv_rekening.setWidth(100);
                tv_rekening.setText(contentdata.getNOMORREKENING());
                rowContentTable.addView(tv_rekening, rowParamsDetail);

                TextView tv_namadebitur = new TextView(ctx);
                tv_namadebitur.setGravity(Gravity.LEFT);
                tv_namadebitur.setTextColor(getResources().getColor(android.R.color.black));
                tv_namadebitur.setPadding(0, 3, 0, 3);
                tv_namadebitur.setTextSize(12);
                tv_namadebitur.setWidth(180);
                tv_namadebitur.setText(contentdata.getNAMADEBITUR());
                rowContentTable.addView(tv_namadebitur, rowParamsDetail);

                TextView tv_nominal = new TextView(ctx);
                tv_nominal.setGravity(Gravity.LEFT);
                tv_nominal.setTextColor(getResources().getColor(android.R.color.black));
                tv_nominal.setPadding(0, 3, 0, 3);
                tv_nominal.setTextSize(12);
                tv_nominal.setWidth(100);
                tv_nominal.setText(contentdata.getTAGIHAN());
                rowContentTable.addView(tv_nominal, rowParamsDetail);

                TextView tv_sisatagihan = new TextView(ctx);
                tv_sisatagihan.setGravity(Gravity.LEFT);
                tv_sisatagihan.setTextColor(getResources().getColor(android.R.color.black));
                tv_sisatagihan.setPadding(0, 3, 0, 3);
                tv_sisatagihan.setTextSize(12);
                tv_sisatagihan.setWidth(95);
                tv_sisatagihan.setText(contentdata.getSISATAGIHAN());
                rowContentTable.addView(tv_sisatagihan, rowParamsDetail);


                if (Double.parseDouble(contentdata.getSISATAGIHAN()) == 0) {
                    TextView tv_lunas = new TextView(ctx);
                    tv_lunas.setGravity(Gravity.LEFT);
                    tv_lunas.setTextColor(getResources().getColor(android.R.color.black));
                    tv_lunas.setPadding(0, 3, 0, 3);
                    tv_lunas.setTextSize(12);
                    tv_lunas.setWidth(57);
                    tv_lunas.setText(R.string.form_action_status_lunas);
                    rowContentTable.addView(tv_lunas, rowParamsDetail);
                } else {
                    Button bt_bayar = new Button(ctx);
                    bt_bayar.setGravity(Gravity.LEFT);
                    bt_bayar.setText(R.string.form_action_status_bayar);
                    rowContentTable.addView(bt_bayar, 60, 35);

                    bt_bayar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            TextView contentTrx = (TextView) rowContentTable.getChildAt(1);
                            loadDetailTagihan(contentTrx.getText().toString());
                            loadTagihanDialog();
                        }
                    });
                }
                tagihan.getTableLayout().addView(rowContentTable);
            }

            if (contentContainer != null) {
                contentContainer.removeView(prevShownView);
            }

            contentContainer.addView(tagihan);
            prevShownView = tagihan;
        }
    }

    public void loadDetailTagihan(String idTransaksi) {
        detailTagihan = tagihanDataProvider.getDetailTagihan(idTransaksi);
    }

    public String formatCurr(String value) {
        DecimalFormat df;
        DecimalFormat dfnd;
        boolean hasFractionalPart;
        df = new DecimalFormat("#,###.##");
        df.setDecimalSeparatorAlwaysShown(true);
        dfnd = new DecimalFormat("#,###.###");

        hasFractionalPart = false;
        try {
            int inilen, endlen;
            inilen = value.length();

            String v = value.toString().replace(String.valueOf(df.getDecimalFormatSymbols().getGroupingSeparator()), "");
            Number n = df.parse(v);
            //int cp = value.getSelectionStart();
            if (hasFractionalPart) {
                value = (df.format(n));
            } else {
                value = (dfnd.format(n));
            }

        } catch (NumberFormatException nfe) {
            // do nothing?
        } catch (ParseException e) {
            // do nothing?
        }

        return value;
    }

    @SuppressLint("NewApi")
    public String formatCurrency(String value) {
        String numberformat = "";
        String userInput = value.replace("R", "").replace("p", "").replace(" ", "");

        int lengthstring = userInput.length();

        int loops = (int) Math.floor(lengthstring / 3);

        if (lengthstring % 3 != 0)
            loops++;

        Log.d("RESPON " + loops, userInput.toString());

        for (int x = 0; x < loops; x++) {
            int startchar = userInput.length() - 3;

            String stringuse = "";
            if (startchar > 0) {
                stringuse = userInput.substring(startchar);
                userInput = userInput.substring(0, startchar);
            } else {
                stringuse = userInput;
            }

            if (!numberformat.isEmpty())
                numberformat = stringuse + "." + numberformat;
            else
                numberformat = stringuse + numberformat;
        }

        return numberformat = "Rp " + numberformat;

    }

    public void loadTagihanDialog() {
        tagihanDialog = new TagihanDialog(ctx);
        tagihanDialog.getTxtHandphone().setText(detailTagihan.getHANDPHONE());
        tagihanDialog.getTxtRekening().setText(detailTagihan.getNOMORREKENING());
        tagihanDialog.getTxtNamaDebitur().setText(detailTagihan.getNAMADEBITUR());
        tagihanDialog.getTxtAlamat().setText(detailTagihan.getALAMAT());
        tagihanDialog.getTxtNomorTabungan().setText(detailTagihan.getNOMORTABUNGAN());
        tagihanDialog.getTxtJenisTagihan().setText(detailTagihan.getJENISPINJAMAN());
        tagihanDialog.getTxtTenor().setText(detailTagihan.getTENOR());
        tagihanDialog.getTxtTanggalCair().setText(new SimpleDateFormat("dd MMMM yyyy").format(detailTagihan.getTANGGALCAIR()));
        tagihanDialog.getTxtPokokPinjaman().setText(formatCurrency(detailTagihan.getPOKOKPINJAMAN()));
        tagihanDialog.getTxtBungaPinjaman().setText(formatCurrency(detailTagihan.getBUNGAPINJAMAN()));
        tagihanDialog.getTxtTotalPinjaman().setText(formatCurrency(detailTagihan.getTOTALPINJAMAN()));
        tagihanDialog.getTxtTotalCicilan().setText(formatCurrency(detailTagihan.getTOTALCICILAN()));
        tagihanDialog.getTxtSisaPinjaman().setText(formatCurrency(detailTagihan.getSISAPINJAMAN()));
        tagihanDialog.getTxtTagihan().setText(formatCurrency(detailTagihan.getTAGIHAN()));
        tagihanDialog.getTxtSisaTagihan().setText(formatCurrency(detailTagihan.getSISATAGIHAN()));


        tagihanDialog.getBtnClose().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagihanDialog.dismiss();
            }
        });

        tagihanDialog.getBtnRequestPIN().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String handphone = tagihanDialog.getTxtHandphone().getText().toString();
                if (!handphone.equalsIgnoreCase("")) {
                    showProgressIndicator();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        TRANSAKSIRESPONSE response = ServiceDataProvider.requestToken(detailTagihan.getNOMORREKENING(), userDetail.getUSERID(), handphone, AppConstants.TRANSTYPETAGIHAN);
                                        if (response != null) {
                                            if (response.getSTATUS() == 1 && response.getNOMORREKENING().equalsIgnoreCase(detailTagihan.getNOMORREKENING())) {
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

        tagihanDialog.getBtnSendTransaction().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tagihanDialog.checkContentValidation() == null) {
                    if (tagihanDialog.isPembayaranValid()) {
                        showProgressIndicator();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            String namapenabung = tagihanDialog.getTxtNamaDebitur().getText().toString();
                                            String pembayaran = tagihanDialog.getTxtPembayaran().getText().toString();
                                            pembayaran = pembayaran.replace("Rp ", "").replace(".", "").replace(",", ".");
                                            String token = "1";//tagihanDialog.getTxtPin().getText().toString();
                                            String handphone = tagihanDialog.getTxtHandphone().getText().toString();
                                            String nomorRekening = detailTagihan.getNOMORREKENING();

                                            long _sisaTagihan = Long.parseLong(detailTagihan.getSISATAGIHAN());


                                            TRANSAKSIRESPONSE response = ServiceDataProvider.sendTransaksi(nomorRekening, pembayaran, token, userDetail.getUSERID(), handphone, AppConstants.TRANSTYPETAGIHAN, "", detailTagihan.getNOMORTABUNGAN(), namapenabung);
                                            if (response != null) {
                                                if (response.getSTATUS() == 1 && response.getNOMORREKENING().equalsIgnoreCase(detailTagihan.getNOMORREKENING())) {
                                                    long sisaTagihan = (_sisaTagihan - Long.parseLong(pembayaran)) <= 0 ? 0 : (_sisaTagihan - Long.parseLong(pembayaran));
                                                    detailTagihan.setHANDPHONE(handphone);
                                                    detailTagihan.setSISATAGIHAN("" + sisaTagihan);
                                                    tagihanDataProvider.updateTagihan(detailTagihan);
                                                    showAlert(R.string.msg_notification_submit_success);
                                                    tagihanDialog.dismiss();
                                                    loadDataTagihan(pageNo);
                                                    loadViewTagihan();
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
                        showAlert(R.string.msg_notification_tagihan_pembayaran);
                    }
                } else {
                    showAlert(R.string.msg_notification_submit_error);
                }
            }
        });

        tagihanDialog.show();
    }

    public void showAlert(int messageId) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.title_activity_tagihan_title_content);
        alertDialog.setMessage(messageId);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void showAlert(String messageId) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.title_activity_tagihan_title_content);
        alertDialog.setMessage(messageId);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
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
