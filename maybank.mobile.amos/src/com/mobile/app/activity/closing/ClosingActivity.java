package com.mobile.app.activity.closing;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import bii.mobile.mitra.R;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.activity.blackbox.BlackboxActivity;
import com.mobile.app.activity.common.FollowUp;
import com.mobile.app.activity.common.FollowUpDialogAdd;
import com.mobile.app.activity.common.PreviewImage;
import com.mobile.app.activity.common.SearchDialog;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.media.CameraDialog;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.dataprovider.FollowUpDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.dataprovider.PhotoDataProvider;
import com.mobile.bo.app.dataprovider.ProspekDataProvider;
import com.mobile.bo.app.datatype.FollowupData;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.bo.app.datatype.StateHistoryData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.common.FileUtility;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.framework.media.CameraActionListener;
import com.mobile.framework.media.CameraPreview;
import com.mobile.framework.widget.ISpinnerItem;
import com.mobile.services.app.datatype.PHOTORESPONSE;
import com.mobile.services.app.datatype.PROSPEKRESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class ClosingActivity extends Activity {
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
    private LOVDataProvider lovDataProvider;
    private ProspekDataProvider prospekDataProvider;
    private FollowUpDataProvider followupDataProvider;
    private PhotoDataProvider photoDataProvider;
    private RelativeLayout contentParentContainer;
    private RelativeLayout contentChildContainer;
    private ImageView btnBack;
    private Closing closing;
    private FollowUp followUp;
    private FollowUpDialogAdd followUpDialog;
    private SearchDialog searchDialog;
    private PreviewImage previewimg = null;
    private ArrayList<ISpinnerItem> lovJenisUsaha = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovRadius = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovKomunitas = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovJenisPembiayaan = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovAction = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovStatus = new ArrayList<ISpinnerItem>();
    private MasterContent prevShownViewParent = null;
    private MasterContent prevShownViewChild = null;
    private ArrayList<String> listdataprospek = null;
    private ArrayList<String> listdatafollowup = null;
    private int INITINDEXRECORD = 0;
    private int currIndexParent = 0;
    private int currIndexChild = 0;
    private String LATITUDE = "0";
    private String LONGITUDE = "0";
    private Context ctx;
    private ProspekData prospekData = null;
    private FollowupData followupData = null;
    private int paramIntentId = 0;
    private String paramIntentSource = "";
    private ProgressDialog dlgProgress = null;
    private static final String TAG = "Closing Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        lovDataProvider = new LOVDataProvider();
        prospekDataProvider = new ProspekDataProvider();
        followupDataProvider = new FollowUpDataProvider();
        photoDataProvider = new PhotoDataProvider();
        initActivity();
    }

    @Override
    protected void onDestroy() {
        lovDataProvider.release();
        prospekDataProvider.release();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
            ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        } else if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEBLACKBOX)) {
            ActivityHandler.gotoActivity(ctx, BlackboxActivity.class, null);
        }
        finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @SuppressLint("SimpleDateFormat")
    public void initActivity() {
        setContentView(R.layout.closing_layout);
        try {
            userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
            isUserDetailExist = true;
        } catch (Exception e) {
            finish();
            return;
        }

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(AppConstants.KEYINITIALINDEX)) {
                paramIntentId = Integer.parseInt(intent.getStringExtra(AppConstants.KEYINITIALINDEX));
            }
            if (intent.hasExtra(AppConstants.KEYPAGESOURCE)) {
                paramIntentSource = intent.getStringExtra(AppConstants.KEYPAGESOURCE);
            }
        }

        lblHeaderUser = (TextView) findViewById(R.id.closing_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.closing_lbl_currentdate);
        contentParentContainer = (RelativeLayout) findViewById(R.id.content_parent_layout);
        contentChildContainer = (RelativeLayout) findViewById(R.id.content_child_layout);
        btnBack = (ImageView) findViewById(R.id.closing_btn_back);
        lovJenisPembiayaan = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PEMBIAYAAN_ID));
        lovAction = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_ACTION_ID));
        lovStatus = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_STATUS_ID));
        lovRadius = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_RADIUS_ID));
        lovKomunitas = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_KOMUNITAS_ID));
        lovJenisUsaha = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_JENISUSAHA_ID));

        loadDataClosing();
        if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
            loadViewClosing(paramIntentId);
        } else if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEBLACKBOX)) {
            loadViewClosing(INITINDEXRECORD);
        }

        if (isUserDetailExist) {
            lblHeaderUser.setText(
                    String.format("%s # %s", userDetail.getNAME(), userDetail.getLOCATION()));

            lblDateTime.setText(String.format("%s", DateFormatter.format(new Date())));
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
                    ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
                } else if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEBLACKBOX)) {
                    ActivityHandler.gotoActivity(ctx, BlackboxActivity.class, null);
                }
                finish();
            }
        });
    }

    private void loadDataClosing() {
        if (listdataprospek != null) {
            listdataprospek.clear();
        }

        if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
            listdataprospek = prospekDataProvider.getAllProspekId(AppConstants.CLOSING_TYPE);
        } else if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEBLACKBOX)) {
            listdataprospek = prospekDataProvider.getProspekById("" + paramIntentId);
        }
    }

    private void loadDataFollowUp(String parentId) {
        if (listdatafollowup != null) {
            listdatafollowup.clear();
        }
        listdatafollowup = followupDataProvider.getFollowupDetailIdByParent(parentId, AppConstants.CLOSING_TYPE);

    }

    private void loadViewClosing(final int idxRecord) {
        currIndexParent = idxRecord;
        closing = null;
        closing = new Closing(ctx);
        closing.getContentTitle().setText(R.string.form_closing_title);
        closing.getSpnJenisUsaha().setListOfValue(lovJenisUsaha, false);
        closing.getSpnRadius().setListOfValue(lovRadius, false);
        closing.getSpnKomunitas().setListOfValue(lovKomunitas, false);
        closing.getSpnPembiayaan().setListOfValue(lovJenisPembiayaan, false);

        if (contentParentContainer != null) {
            contentParentContainer.removeView(prevShownViewParent);
        }
        if (contentChildContainer != null) {
            contentChildContainer.removeView(prevShownViewChild);
        }
        if (listdataprospek.size() > 0) {
            prospekData = prospekDataProvider.getProspekDetail(listdataprospek.get(idxRecord));
            loadDataFollowUp(prospekData.getID().toString());
            manageContentPropertyParent(listdataprospek.size());
            ArrayList<PhotoData> listphoto = photoDataProvider.getPhotoByProspek(prospekData.getID().toString());

            final List<ImageView> imgView = new ArrayList<ImageView>();
            final List<TextView> lblView = new ArrayList<TextView>();

            imgView.add(closing.getImgView01());
            imgView.add(closing.getImgView02());
            imgView.add(closing.getImgView03());
            lblView.add(closing.getLblImg01());
            lblView.add(closing.getLblImg02());
            lblView.add(closing.getLblImg03());
            LATITUDE = prospekData.getLATITUDE();
            LONGITUDE = prospekData.getLONGITUDE();
            closing.getContentTitle().setText(AppConstants.getStage(AppConstants.CLOSING_TYPE));
            closing.getLblTotalRecords().setText((currIndexParent + 1) + "/" + listdataprospek.size());
            closing.getLblKoordinat().setText(prospekData.getLATITUDE() + "," + prospekData.getLONGITUDE());
            closing.getTxtNamaUsaha().setText(prospekData.getNAMAUSAHA());
            closing.getTxtAlamatUsaha().setText(prospekData.getALAMATUSAHA());
            closing.getSpnJenisUsaha().setSelectedListOfValue(prospekData.getJENISUSAHA());
            closing.getSpnRadius().setSelectedListOfValue(prospekData.getRADIUS());
            closing.getSpnKomunitas().setSelectedListOfValue(prospekData.getKOMUNITAS());
            closing.getTxtNamaDebitur().setText(prospekData.getNAMADEBITUR());
            if (prospekData.getTGLLAHIR() != null) {
                closing.getTxtTglLahir().setText(DateFormatter.formatString(prospekData.getTGLLAHIR()));
            }
            closing.getTxtHandphone().setText(prospekData.getHANDPHONE());
            closing.getSpnPembiayaan().setSelectedListOfValue(prospekData.getJENISPEMBIAYAAN());
            closing.getTxtTeleponRumah().setText(prospekData.getTELEPONRUMAH());
            closing.getTxtAlamatRumah().setText(prospekData.getALAMATRUMAH());
            closing.getTxtPlafond().setText(prospekData.getPLAFOND());
            closing.getTxtKTP().setText(prospekData.getKTP());
            closing.getTxtNPWP().setText(prospekData.getNPWP());
            closing.getTxtSIUPSKU().setText(prospekData.getSIUPSKU());

            if (listphoto.size() > 0) {
                for (int i = 0; i < listphoto.size(); i++) {
                    try {
                        Bitmap bmp;
                        boolean statusAvailableImage = listphoto.get(i).isISFILEALREADYAVAILABLE();
                        if (statusAvailableImage) {
                            try {
                                bmp = getPicture(listphoto.get(i).getFILENAME());
                            } catch (Exception e) {
                                bmp = getUnAvailablePicture();
                                statusAvailableImage = false;
                            }
                        } else {
                            bmp = getUnAvailablePicture();
                        }
                        imgView.get(i).setVisibility(View.VISIBLE);
                        imgView.get(i).setImageBitmap(bmp);
                        lblView.get(i).setText(listphoto.get(i).getFILENAME());
                        SetPreviewImage(imgView.get(i), lblView.get(i), bmp, listphoto.get(i).getFILENAME(), listphoto.get(i).getID().toString(), statusAvailableImage);
                    } catch (Exception ex) {


                    }
                }
            }

            closing.getBtnTakePicture().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (closing.getLblImg01().getText().toString().equalsIgnoreCase("-") ||
                            closing.getLblImg02().getText().toString().equalsIgnoreCase("-") ||
                            closing.getLblImg03().getText().toString().equalsIgnoreCase("-")) {

                        captureImage(imgView, lblView);
                    } else {
                        showAlert(R.string.msg_notification_error_picture);
                    }
                }
            });

            loadViewFollowUp(INITINDEXRECORD);

            closing.getImgHandphoneCall().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (closing.getTxtHandphone().getText() != null) {
                        try {
                            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + closing.getTxtHandphone().getText().toString()));
                            startActivity(intent);
                            //ActivityHandler.makePhoneCall(ctx, kenalan.getTxtHandphone().getText().toString());
                        } catch (Exception e) {
                            showAlert(R.string.msg_notification_error_phonecall);
                        }
                    } else {
                        showAlert(R.string.msg_notification_update_field);
                    }
                }
            });

            closing.getImgHandphoneMessage().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (closing.getTxtHandphone().getText() != null) {
                        try {
                            ActivityHandler.sendSMS(ctx, closing.getTxtHandphone().getText().toString());
                        } catch (Exception e) {
                            showAlert(R.string.msg_notification_error_phonecall);
                        }
                    } else {
                        showAlert(R.string.msg_notification_update_field);
                    }
                }
            });

            closing.getImgTeleponRumahCall().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (closing.getTxtTeleponRumah().getText() != null) {
                        try {
                            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + closing.getTxtHandphone().getText().toString()));
                            startActivity(intent);
                            //ActivityHandler.makePhoneCall(ctx, kenalan.getTxtHandphone().getText().toString());
                        } catch (Exception e) {
                            showAlert(R.string.msg_notification_error_phonecall);
                        }
                    } else {
                        showAlert(R.string.msg_notification_update_field);
                    }
                }
            });


            closing.getBtnSave().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (closing.checkContentValidation() == null) {
                        showProgressIndicator();
                        updateProspek(AppConstants.SAVE);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        boolean isException = false;
                                        String prospekid = prospekData.getPROSPEKID();
                                        try {
                                            ArrayList<ProspekData> prospeks = new ArrayList<ProspekData>();
                                            prospeks.add(prospekData);
                                            ArrayList<PROSPEKRESPONSE> prospekResponse = ServiceDataProvider.updateExistingDataProspek(prospeks);
                                            if (prospekResponse != null) {
                                                if (prospekResponse.size() > 0) {
                                                    PROSPEKRESPONSE objRes = prospekResponse.get(0);
                                                    if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE) && objRes.getID().equalsIgnoreCase(prospekData.getID().toString())) {
                                                        prospekid = objRes.getPROSPEKID();
                                                        prospekData.setPROSPEKID(prospekid);
                                                        followupDataProvider.updatePendingUpdatedFollowUpToServer(prospekData.getID(), AppConstants.CLOSING_TYPE);
                                                    } else {
                                                        showAlert(R.string.msg_notification_submit_failed);
                                                        return;
                                                    }
                                                    objRes = null;
                                                }
                                            }
                                            prospekResponse = null;
                                        } catch (Exception e) {
                                            prospekData.setISPENDINGUPDATEDTOSERVER(true);
                                            isException = true;
                                        }

                                        int retVal = prospekDataProvider.updateProspek(prospekData);
                                        if (retVal > 0) {
                                            simpanPhoto(prospekid);
                                            if (!isException) {
                                                // UPLOAD PHOTO
                                                ArrayList<PhotoData> listphoto = photoDataProvider.getUnUploadedPhotoByProspek(prospekData.getID().toString());
                                                for (int i = 0; i < listphoto.size(); i++) {
                                                    try {
                                                        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                                                        params.add(new BasicNameValuePair("id", listphoto.get(i).getID().toString()));
                                                        params.add(new BasicNameValuePair("prospekid", listphoto.get(i).getPROSPEKID()));
                                                        params.add(new BasicNameValuePair("filename", listphoto.get(i).getFILENAME()));

                                                        PHOTORESPONSE photoResponse = ServiceDataProvider.uploadProspekPhoto(params, listphoto.get(i).getFILENAME());
                                                        if (photoResponse != null) {
                                                            if (photoResponse.getFILENAME().equalsIgnoreCase(listphoto.get(i).getFILENAME())) {
                                                                listphoto.get(i).setISALREADYUPLOADEDTOSERVER(true);
                                                            } else {
                                                                listphoto.get(i).setISPENDINGUPLOADED(true);
                                                            }
                                                            photoDataProvider.updatePhoto(listphoto.get(i));
                                                        }

                                                    } catch (Exception e) {
                                                        listphoto.get(i).setISPENDINGUPLOADED(true);
                                                        photoDataProvider.updatePhoto(listphoto.get(i));
                                                    }

                                                }
                                                showAlert(R.string.msg_notification_submit_success);
                                            } else {
                                                showAlert(R.string.msg_notification_submit_error);
                                            }

                                            loadViewClosing(idxRecord);
                                        } else {
                                            showAlert(R.string.msg_notification_update_error);
                                        }

                                        hideProgressIndicator();
                                    }
                                });
                            }
                        }).start();

                    } else {
                        showAlert(R.string.msg_notification_update_field);
                    }

                }
            });

            closing.getBtnSubmit().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (closing.checkContentValidation() == null) {
                        showProgressIndicator();
                        updateProspek(AppConstants.SUBMIT);
                        try {
                            prospekData.setISPENDINGUPDATEDTOSERVER(false);
                            followupDataProvider.updatePendingUpdatedFollowUpToServer(prospekData.getID().toString(), AppConstants.CLOSING_TYPE);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        boolean isException = false;
                                        String prospekid = prospekData.getPROSPEKID();
                                        Date startDateClosing = prospekData.getSUBMITDATE();
                                        try {
                                            ArrayList<ProspekData> prospeks = new ArrayList<ProspekData>();
                                            prospeks.add(prospekData);
                                            ArrayList<PROSPEKRESPONSE> prospekResponse = ServiceDataProvider.submitDataProspek(prospeks, AppConstants.DIRECTSUBMIT);
                                            if (prospekResponse != null) {
                                                if (prospekResponse.size() > 0) {
                                                    PROSPEKRESPONSE objRes = prospekResponse.get(0);
                                                    if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE) && objRes.getID().equalsIgnoreCase(prospekData.getID().toString())) {
                                                        prospekid = objRes.getPROSPEKID();
                                                        prospekData.setPROSPEKID(prospekid);
                                                        followupDataProvider.updateFollowUpByParentAndType(prospekid, objRes.getID(), AppConstants.CLOSING_TYPE);
                                                    } else {
                                                        showAlert(R.string.msg_notification_submit_failed);
                                                        return;
                                                    }
                                                    objRes = null;
                                                }
                                            }
                                            prospekResponse = null;
                                        } catch (Exception e) {
                                            prospekData.setISPENDINGUPLOADED(true);
                                            isException = true;
                                        }

                                        int retVal = prospekDataProvider.updateProspek(prospekData);
                                        if (retVal > 0) {
                                            simpanPhoto(prospekid);
                                            StateHistoryData stateHistoryClosing = new StateHistoryData(prospekid, prospekData.getID().toString(), AppConstants.CLOSING_TYPE, startDateClosing, new Date(), userDetail.getUSERID());
                                            prospekDataProvider.updateStateHistory(stateHistoryClosing);
                                            loadDataClosing();
                                            loadViewClosing(INITINDEXRECORD);
                                            if (!isException) {
                                                try {
                                                    // UPLOAD PHOTO
                                                    ArrayList<PhotoData> listphoto = photoDataProvider.getPhotoByProspek(prospekData.getID().toString());
                                                    for (int i = 0; i < listphoto.size(); i++) {
                                                        if (!listphoto.get(i).isISALREADYUPLOADEDTOSERVER()) {
                                                            try {
                                                                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                                                                params.add(new BasicNameValuePair("id", listphoto.get(i).getID().toString()));
                                                                params.add(new BasicNameValuePair("prospekid", listphoto.get(i).getPROSPEKID()));
                                                                params.add(new BasicNameValuePair("filename", listphoto.get(i).getFILENAME()));

                                                                PHOTORESPONSE photoResponse = ServiceDataProvider.uploadProspekPhoto(params, listphoto.get(i).getFILENAME());
                                                                if (photoResponse != null) {
                                                                    if (photoResponse.getFILENAME().equalsIgnoreCase(listphoto.get(i).getFILENAME())) {
                                                                        FileUtility.deleteFile(photoResponse.getFILENAME(), AppConstants.FILEPATH);
                                                                        photoDataProvider.deletePhotoByFileName(photoResponse.getFILENAME());
                                                                    } else {
                                                                        listphoto.get(i).setISPENDINGUPLOADED(true);
                                                                    }
                                                                    photoDataProvider.updatePhoto(listphoto.get(i));
                                                                }

                                                            } catch (Exception e) {
                                                                listphoto.get(i).setISPENDINGUPLOADED(true);
                                                                photoDataProvider.updatePhoto(listphoto.get(i));
                                                            }

                                                        } else {
                                                            FileUtility.deleteFile(listphoto.get(i).getFILENAME(), AppConstants.FILEPATH);
                                                            photoDataProvider.deletePhotoByFileName(listphoto.get(i).getFILENAME());
                                                        }
                                                    }

                                                    followupDataProvider.deleteFollowUpByParent(prospekData.getID().toString());
                                                    prospekDataProvider.deleteProspekById(prospekData.getID().toString());
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }

                                                showAlert(R.string.msg_notification_submit_success);
                                            } else {
                                                showAlert(R.string.msg_notification_submit_error);
                                            }
                                        } else {
                                            showAlert(R.string.msg_notification_update_error);
                                        }
                                        hideProgressIndicator();
                                    }
                                });
                            }
                        }).start();
                    } else {
                        showAlert(R.string.msg_notification_update_field);
                    }
                }
            });

            closing.getBtnBlackbox().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
                        if (closing.checkContentValidation() == null) {
                            showProgressIndicator();
                            updateProspek(AppConstants.BLACKBOX);
                            try {
                                prospekData.setISPENDINGUPDATEDTOSERVER(false);
                                followupDataProvider.updatePendingUpdatedFollowUpToServer(prospekData.getID().toString(), AppConstants.CLOSING_TYPE);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }

                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            boolean isException = false;
                                            String prospekid = prospekData.getPROSPEKID();
                                            Date startDateClosing = prospekData.getSUBMITDATE();
                                            try {
                                                ArrayList<ProspekData> prospeks = new ArrayList<ProspekData>();
                                                prospeks.add(prospekData);
                                                ArrayList<PROSPEKRESPONSE> prospekResponse = ServiceDataProvider.submitDataProspek(prospeks, AppConstants.DIRECT_EXCLUDE_SUBMIT);
                                                if (prospekResponse != null) {
                                                    if (prospekResponse.size() > 0) {
                                                        PROSPEKRESPONSE objRes = prospekResponse.get(0);
                                                        if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE) && objRes.getID().equalsIgnoreCase(prospekData.getID().toString())) {
                                                            prospekid = objRes.getPROSPEKID();
                                                            prospekData.setPROSPEKID(prospekid);
                                                            followupDataProvider.updateFollowUpByParentAndType(prospekid, objRes.getID(), AppConstants.CLOSING_TYPE);
                                                        } else {
                                                            showAlert(R.string.msg_notification_blackbox_error);
                                                            return;
                                                        }
                                                        objRes = null;
                                                    }
                                                }
                                                prospekResponse = null;
                                            } catch (Exception e) {
                                                prospekData.setISPENDINGUPLOADED(true);
                                                isException = true;
                                            }

                                            int retVal = prospekDataProvider.updateProspek(prospekData);
                                            if (retVal > 0) {
                                                simpanPhoto(prospekid);
                                                StateHistoryData stateHistoryClosing = new StateHistoryData(prospekid, prospekData.getID().toString(), AppConstants.CLOSING_TYPE, startDateClosing, new Date(), userDetail.getUSERID());
                                                prospekDataProvider.updateStateHistory(stateHistoryClosing);
                                                loadDataClosing();
                                                loadViewClosing(INITINDEXRECORD);
                                                if (!isException) {
                                                    try {
                                                        // UPLOAD PHOTO
                                                        ArrayList<PhotoData> listphoto = photoDataProvider.getPhotoByProspek(prospekData.getID().toString());
                                                        for (int i = 0; i < listphoto.size(); i++) {
                                                            if (!listphoto.get(i).isISALREADYUPLOADEDTOSERVER()) {
                                                                try {
                                                                    ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                                                                    params.add(new BasicNameValuePair("id", listphoto.get(i).getID().toString()));
                                                                    params.add(new BasicNameValuePair("prospekid", listphoto.get(i).getPROSPEKID()));
                                                                    params.add(new BasicNameValuePair("filename", listphoto.get(i).getFILENAME()));

                                                                    PHOTORESPONSE photoResponse = ServiceDataProvider.uploadProspekPhoto(params, listphoto.get(i).getFILENAME());
                                                                    if (photoResponse != null) {
                                                                        if (photoResponse.getFILENAME().equalsIgnoreCase(listphoto.get(i).getFILENAME())) {
                                                                            FileUtility.deleteFile(photoResponse.getFILENAME(), AppConstants.FILEPATH);
                                                                            photoDataProvider.deletePhotoByFileName(photoResponse.getFILENAME());
                                                                        } else {
                                                                            listphoto.get(i).setISPENDINGUPLOADED(true);
                                                                        }
                                                                        photoDataProvider.updatePhoto(listphoto.get(i));
                                                                    }

                                                                } catch (Exception e) {
                                                                    listphoto.get(i).setISPENDINGUPLOADED(true);
                                                                    photoDataProvider.updatePhoto(listphoto.get(i));
                                                                }

                                                            } else {
                                                                FileUtility.deleteFile(listphoto.get(i).getFILENAME(), AppConstants.FILEPATH);
                                                                photoDataProvider.deletePhotoByFileName(listphoto.get(i).getFILENAME());
                                                            }
                                                        }

                                                        followupDataProvider.deleteFollowUpByParent(prospekData.getID().toString());
                                                        prospekDataProvider.deleteProspekById(prospekData.getID().toString());
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }

                                                    showAlert(R.string.msg_notification_blackbox_success);
                                                } else {
                                                    showAlert(R.string.msg_notification_blackbox_pending);
                                                }
                                            } else {
                                                showAlert(R.string.msg_notification_update_error);
                                            }
                                            hideProgressIndicator();
                                        }
                                    });
                                }
                            }).start();
                        } else {
                            showAlert(R.string.msg_notification_update_field);
                        }
                    } else if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEBLACKBOX)) {
                        prospekData.setISCHECKED(true);
                        prospekDataProvider.updateProspek(prospekData);
                        ActivityHandler.gotoActivity(ctx, BlackboxActivity.class, null);
                        finish();
                    }
                }
            });

            closing.getBtnDelete().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showConfirmationDelete(currIndexParent, true);
                }
            });

            closing.getBtnFirst().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currIndexParent != 0) {
                        loadViewClosing(0);
                    }
                }
            });

            closing.getBtnPrev().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int previndex = currIndexParent - 1 <= 0 ? 0 : currIndexParent - 1;
                    loadViewClosing(previndex);
                }
            });

            closing.getBtnNext().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextindex = currIndexParent + 1 >= listdataprospek.size() - 1 ? listdataprospek.size() - 1 : currIndexParent + 1;
                    loadViewClosing(nextindex);
                }
            });

            closing.getBtnLast().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currIndexParent != listdataprospek.size() - 1) {
                        loadViewClosing(listdataprospek.size() - 1);
                    }
                }
            });

            closing.getDatePickerTlgLahir().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] arrTglLahir = null;

                    final Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int month = (c.get(Calendar.MONTH));
                    int day = c.get(Calendar.DAY_OF_MONTH);

                    if (!closing.getTxtTglLahir().getText().toString().equalsIgnoreCase("")) {
                        arrTglLahir = closing.getTxtTglLahir().getText().toString().split("-");
                        year = Integer.parseInt(arrTglLahir[2]);
                        month = Integer.parseInt(arrTglLahir[1]) - 1;
                        day = Integer.parseInt(arrTglLahir[0]);
                    }

                    DatePickerManager datePickerDialog = new DatePickerManager(ctx, closingDateSetListener, year, month, day);
                    datePickerDialog.show();

                }
            });

            closing.getBtnSearch().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showFormSearch();
                }
            });
            contentParentContainer.addView(closing);
            prevShownViewParent = closing;

        }
    }

    public void simpanPhoto(String prospekid) {
        try {
            ArrayList<String> arrImages = getImages();
            for (int i = 0; i < arrImages.size(); i++) {
                PhotoData photo = photoDataProvider.getPhotoByFileName(arrImages.get(i));
                if (photo != null) {
                    photo.setPROSPEKID(prospekid);
                } else {
                    photo = new PhotoData(prospekid, prospekData.getID().toString(), arrImages.get(i), false, false, true);
                    photo.setISPENDINGDELETED(false);
                    photo.setISALREADYUPLOADEDTOSERVER(false);
                }
                photoDataProvider.updatePhoto(photo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    public void updateProspek(int state) {
        Date currdate = prospekData.getDATE();
        String time = currdate.getHours() + ":" + currdate.getMinutes() + ":" + currdate.getSeconds();
        String namausaha = closing.getTxtNamaUsaha().getText().toString();
        String alamat = closing.getTxtAlamatUsaha().getText().toString();
        String jenisusaha = closing.getSpnJenisUsaha().getSelectedListOfValue().toString();
        String radius = closing.getSpnRadius().getSelectedListOfValue().toString();
        String komunitas = closing.getSpnKomunitas().getSelectedListOfValue().toString();
        String namadebitur = closing.getTxtNamaDebitur().getText().toString();
        Date tgllahir = DateFormatter.formatDate((closing.getTxtTglLahir().getText().toString()));
        String handphone = closing.getTxtHandphone().getText().toString();
        String pembiayaan = closing.getSpnPembiayaan().getSelectedListOfValue().toString();
        String teleponrumah = closing.getTxtTeleponRumah().getText().toString();
        String alamatrumah = closing.getTxtAlamatRumah().getText().toString();
        String plafon = closing.getTxtPlafond().getText().toString();
        plafon = plafon.replace("Rp ", "").replace(".", "");

        String ktp = closing.getTxtKTP().getText().toString();
        String npwp = closing.getTxtNPWP().getText().toString();
        String siupsku = closing.getTxtSIUPSKU().getText().toString();

        prospekData.update(userDetail.getUSERID(), LATITUDE, LONGITUDE, currdate, time, namausaha, alamat, jenisusaha, radius, komunitas, namadebitur, tgllahir, pembiayaan, handphone, "", teleponrumah, alamatrumah, plafon, ktp, npwp, siupsku);

        if (state == AppConstants.SUBMIT) {
            prospekData.setSUBMITDATE(new Date());
            prospekData.setSTAGE(AppConstants.RELEASED_TYPE);
        } else if (state == AppConstants.BLACKBOX) {
            prospekData.setSUBMITDATE(new Date());
            prospekData.setISBLACKBOX(true);
        }
        prospekData.setUNIT(userDetail.getUNIT());
        prospekData.setPREVIOUSSTAGE(AppConstants.CLOSING_TYPE);
    }

    // show child
    private void loadViewFollowUp(final int idxRecordChild) {
        currIndexChild = idxRecordChild;
        followUp = null;
        followUp = new FollowUp(ctx);
        followUp.getContentTitle().setText(R.string.form_followup_title);
        followUp.getSpnAction().setListOfValue(lovAction, false);
        followUp.getSpnStatus().setListOfValue(lovStatus, false);

        if (listdatafollowup.size() > 0) {
            followupData = null;
            followupData = followupDataProvider.getFollowupDetail(listdatafollowup.get(currIndexChild).toString());
            manageContentPropertyChild(true, followupData.isEDITABLE(), listdatafollowup.size());
            followUp.getLblStage().setText(AppConstants.getStage(followupData.getSTAGE()));
            followUp.getLblTotalRecords().setText((currIndexChild + 1) + "/" + listdatafollowup.size());
            if (followupData.getNEXTFOLLOWUP() != null) {
                followUp.getTxtNextFollowUp().setText(DateFormatter.formatString(followupData.getNEXTFOLLOWUP()));
            }
            followUp.getTxtCatatan().setText(followupData.getCATATAN());
            followUp.getSpnAction().setSelectedListOfValue(followupData.getACTION());
            followUp.getSpnStatus().setSelectedListOfValue(followupData.getSTATUS());

            if (followupData.isEDITABLE() && followupData.getNEXTFOLLOWUP() != null) {
                if (DateFormatter.formatDateOnly(new Date()).after(DateFormatter.formatDateOnly(followupData.getNEXTFOLLOWUP()))) {
                    followupData.setISEDITABLE(false);
                    followupDataProvider.udpateFollowUp(followupData);
                }
            }

            // on change selected spinner status
//			followUp.getSpnStatus().setOnItemSelectedListener(
//					new AdapterView.OnItemSelectedListener() {
//						@Override
//						public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long id) {
//							String selectedStatus = (String) followUp.getSpnStatus().getSelectedListOfValue(position);
//							if (!selectedStatus.equalsIgnoreCase(AppConstants.FOLLOWUPRELEASED)){
//								followupData.setSTATUS(AppConstants.FOLLOWUPRELEASED);
//								followupData.setISEDITABLE(false);
//								followupDataProvider.udpateFollowUp(followupData);								
//								manageContentPropertyChild(true,false,listdatafollowup.size());
//							}							
//						}
//			
//						@Override
//						public void onNothingSelected(AdapterView<?> arg0) {
//							// Auto-generated method stub	
//					}
//				});
        } else {
            followUp.getLblTotalRecords().setText((currIndexChild) + "/" + listdatafollowup.size());
            manageContentPropertyChild(false, false, 0);
        }

        if (contentChildContainer != null) {
            contentChildContainer.removeView(prevShownViewChild);
        }

        // handle action button
        followUp.getBtnAdd().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFormAddFollowUp();
            }
        });

        followUp.getBtnSave().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (followUp.checkContentValidation() == null) {
                    showProgressIndicator();
                    final String catatan = followUp.getTxtCatatan().getText().toString();
                    final Date nextfollowup = DateFormatter.formatDate(followUp.getTxtNextFollowUp().getText().toString());
                    final String action = followUp.getSpnAction().getSelectedListOfValue().toString();
                    final String status = followUp.getSpnStatus().getSelectedListOfValue().toString();

                    followupData.update(userDetail.getUSERID(), AppConstants.CLOSING_TYPE, nextfollowup, status, catatan, true, action);
                    // update to server
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    boolean isException = false;
                                    try {
                                        String prospekid = prospekData.getPROSPEKID();
                                        ArrayList<PROSPEKRESPONSE> prospekResponse = ServiceDataProvider.updateNewDataProspek(prospekData, followupData);
                                        if (prospekResponse != null) {
                                            if (prospekResponse.size() > 0) {
                                                PROSPEKRESPONSE objRes = prospekResponse.get(0);
                                                if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE) && objRes.getID().equalsIgnoreCase(prospekData.getID().toString())) {
                                                    prospekid = objRes.getPROSPEKID();
                                                    prospekData.setPROSPEKID(prospekid);
                                                    prospekDataProvider.updateProspek(prospekData);
                                                    followupData.setISPENDINGUPDATEDTOSERVER(false);
                                                } else {
                                                    showAlert(R.string.msg_notification_submit_failed);
                                                    return;
                                                }
                                                objRes = null;
                                            }
                                        }
                                        prospekResponse = null;
                                    } catch (Exception e) {
                                        followupData.setISPENDINGUPDATEDTOSERVER(true);
                                        isException = true;
                                    }

                                    int retVal = followupDataProvider.udpateFollowUp(followupData);
                                    if (retVal > 0) {

                                        if (!isException) {
                                            showAlert(R.string.msg_notification_submit_success);
                                        } else {
                                            showAlert(R.string.msg_notification_submit_error);
                                        }

                                        followupData.setNEXTFOLLOWUP(nextfollowup);
                                        followupData.setCATATAN(catatan);
                                        followupData.setACTION(action);
                                        followupData.setSTATUS(status);
                                    } else {
                                        showAlert(R.string.msg_notification_update_error);
                                    }
                                    hideProgressIndicator();
                                }
                            });
                        }
                    }).start();
                } else {
                    showAlert(R.string.msg_notification_update_field);
                }
            }
        });

        followUp.getBtnDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDelete(currIndexChild, false);
            }
        });


        followUp.getBtnFirst().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currIndexChild != 0) {
                    loadViewFollowUp(0);
                }
            }
        });

        followUp.getBtnPrev().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int previndex = currIndexChild - 1 <= 0 ? 0 : currIndexChild - 1;
                loadViewFollowUp(previndex);
            }
        });

        followUp.getBtnNext().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextindex = currIndexChild + 1 >= listdatafollowup.size() - 1 ? listdatafollowup.size() - 1 : currIndexChild + 1;
                loadViewFollowUp(nextindex);
            }
        });

        followUp.getBtnLast().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currIndexChild != listdatafollowup.size() - 1) {
                    loadViewFollowUp(listdatafollowup.size() - 1);
                }
            }
        });

        followUp.getDatePickerFollowUp().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] nextFollowUpDate = followUp.getTxtNextFollowUp().getText().toString().split("-");
                int year = Integer.parseInt(nextFollowUpDate[2]);
                int month = Integer.parseInt(nextFollowUpDate[1]) - 1;
                int day = Integer.parseInt(nextFollowUpDate[0]);
                final Calendar c = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(ctx, FollowUpDateSetListener, year, month, day);
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                datePickerDialog.getDatePicker().setCalendarViewShown(false);
                datePickerDialog.show();

            }
        });

        contentChildContainer.addView(followUp);
        prevShownViewChild = followUp;
    }

    private void showFormAddFollowUp() {
        followUpDialog = new FollowUpDialogAdd(ctx);
        followUpDialog.getLblStage().setText(R.string.title_activity_closing);
        followUpDialog.getSpnAction().setListOfValue(lovAction, false);
        followUpDialog.getSpnStatus().setListOfValue(lovStatus, false);

        followUpDialog.getBtnSave().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (followUpDialog.checkContentValidation() == null) {
                    String followupId = "F" + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date()) + userDetail.getUSERID();
                    final String parentId = prospekData.getID().toString();
                    Date nextfollowup = DateFormatter.formatDate(followUpDialog.getTxtNextFollowUp().getText().toString());
                    String catatan = followUpDialog.getTxtCatatan().getText().toString();
                    String action = followUpDialog.getSpnAction().getSelectedListOfValue().toString();
                    String status = followUpDialog.getSpnStatus().getSelectedListOfValue().toString();

                    final FollowupData fu = new FollowupData();
                    fu.update(userDetail.getUSERID(), AppConstants.CLOSING_TYPE, nextfollowup, status, catatan, true, action, parentId);
                    fu.setPROSPEKID(prospekData.getPROSPEKID());

                    if (status.equalsIgnoreCase(AppConstants.FOLLOWUPRELEASED)) {
                        fu.setISEDITABLE(false);
                    } else {
                        fu.setISEDITABLE(true);
                    }

                    fu.setID(followupId);


                    // update to server
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    boolean isException = false;
                                    try {
                                        String prospekid = prospekData.getPROSPEKID();
                                        ArrayList<PROSPEKRESPONSE> prospekResponse = ServiceDataProvider.updateNewDataProspek(prospekData, fu);
                                        if (prospekResponse != null) {
                                            if (prospekResponse.size() > 0) {
                                                PROSPEKRESPONSE objRes = prospekResponse.get(0);
                                                if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE) && objRes.getID().equalsIgnoreCase(prospekData.getID().toString())) {
                                                    prospekid = objRes.getPROSPEKID();
                                                    prospekData.setPROSPEKID(prospekid);
                                                    prospekDataProvider.updateProspek(prospekData);
                                                    fu.setISPENDINGUPDATEDTOSERVER(false);
                                                } else {
                                                    showAlert(R.string.msg_notification_submit_failed);
                                                    return;
                                                }
                                                objRes = null;
                                            }
                                        }
                                        prospekResponse = null;
                                    } catch (Exception e) {
                                        fu.setISPENDINGUPDATEDTOSERVER(true);
                                        isException = true;
                                    }

                                    int retVal = followupDataProvider.udpateFollowUp(fu);
                                    if (retVal > 0) {

                                        if (!isException) {
                                            showAlert(R.string.msg_notification_submit_success);
                                        } else {
                                            showAlert(R.string.msg_notification_submit_error);
                                        }

                                        followUpDialog.dismiss();
                                        followUpDialog = null;
                                        loadDataFollowUp(parentId);
                                        loadViewFollowUp(listdatafollowup.size() - 1);
                                    } else {
                                        showAlert(R.string.msg_notification_update_error);
                                    }
                                    hideProgressIndicator();
                                }
                            });
                        }
                    }).start();
                } else {
                    showAlert(R.string.msg_notification_update_field);
                }
            }
        });

        followUpDialog.getBtnBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followUpDialog.dismiss();
                followUpDialog = null;
            }
        });

        followUpDialog.getDatePickerFollowUp().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ctx, FollowUpAddDialogDateSetListener, year, month, day);
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                datePickerDialog.getDatePicker().setCalendarViewShown(false);
                datePickerDialog.show();
            }
        });

        followUpDialog.show();
    }

    private void showFormSearch() {
        searchDialog = new SearchDialog(ctx);
        searchDialog.getSpnJenisUsaha().setListOfValue(lovJenisUsaha, false);
        searchDialog.getSpnJenisPembiayaan().setListOfValue(lovJenisPembiayaan, false);

        searchDialog.getBtnSearch().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalValidatedField = searchDialog.validateSearchContent();
                if (totalValidatedField > 0) {
                    boolean found = false;
                    int idxFound = 0;
                    String namausaha = searchDialog.getTxtNamaUsaha().getText().toString();
                    String namadebitur = searchDialog.getTxtNamaDebitur().getText().toString();
                    String jenisusaha = searchDialog.getSpnJenisUsaha().getSelectedListOfValue().toString();
                    String jenispembiayaan = searchDialog.getSpnJenisPembiayaan().getSelectedListOfValue().toString();

                    ProspekData searchData = prospekDataProvider.searchProspekOr(namausaha, namadebitur, jenisusaha, jenispembiayaan, AppConstants.CLOSING_TYPE);
                    if (searchData != null) {
                        for (int i = 0; i < listdataprospek.size(); i++) {
                            if (listdataprospek.get(i).equalsIgnoreCase(searchData.getID().toString())) {
                                idxFound = i;
                                found = true;
                                break;
                            }

                        }
                    }
                    /*
					if (searchData !=null){
						for (int i=0;i< listdataprospek.size();i++){
							if (listdataprospek.get(i).equalsIgnoreCase(searchData.getID().toString())){
								idxFound = i;
								found = true;
								break;
							}					
						}
					}
					else
					{
						if (totalValidatedField == 3){
							searchData = prospekDataProvider.searchProspekOr(namausaha, namadebitur, jenisusaha, jenispembiayaan,AppConstants.CLOSING_TYPE);
							if (searchData != null){
								for (int i=0;i< listdataprospek.size();i++){
									if (listdataprospek.get(i).equalsIgnoreCase(searchData.getID().toString())){
										idxFound = i;
										found = true;
										break;
									}					
									
								}
							}
						}												
					}
					*/
                    if (found) {
                        loadViewClosing(idxFound);
                        searchDialog.dismiss();
                    } else {
                        showAlert(R.string.msg_notification_error_searchfailed);
                    }
                } else {
                    showAlert(R.string.msg_notification_update_field);
                }
            }
        });


        searchDialog.getBtnCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchDialog.dismiss();
                searchDialog = null;
            }
        });

        searchDialog.show();
    }

    public void manageContentPropertyParent(int totalData) {
        closing.getBtnFirst().setVisibility(View.GONE);
        closing.getBtnPrev().setVisibility(View.GONE);
        closing.getBtnNext().setVisibility(View.GONE);
        closing.getBtnLast().setVisibility(View.GONE);

        if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
            closing.getBtnSave().setVisibility(View.VISIBLE);
            closing.getBtnDelete().setVisibility(View.GONE);
            closing.getBtnSubmit().setVisibility(View.VISIBLE);
            closing.getBtnBlackbox().setVisibility(View.VISIBLE);
            closing.getBtnTakePicture().setVisibility(View.VISIBLE);
        } else if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEBLACKBOX)) {
            closing.getBtnSave().setVisibility(View.GONE);
            closing.getBtnDelete().setVisibility(View.GONE);
            closing.getBtnSubmit().setVisibility(View.GONE);
            closing.getBtnBlackbox().setVisibility(View.GONE);
            closing.getBtnTakePicture().setVisibility(View.GONE);
        }

        if (totalData > 1) {
            closing.getBtnFirst().setVisibility(View.VISIBLE);
            closing.getBtnPrev().setVisibility(View.VISIBLE);
            closing.getBtnNext().setVisibility(View.VISIBLE);
            closing.getBtnLast().setVisibility(View.VISIBLE);
            closing.getBtnSearch().setVisibility(View.VISIBLE);
        }
    }

    public void manageContentPropertyChild(boolean isExist, boolean isEditable, int totalData) {
        followUp.getTxtCatatan().setEnabled(isEditable);
        followUp.getSpnAction().setEnabled(isEditable);
        followUp.getSpnStatus().setEnabled(isEditable);
        followUp.getBtnSave().setEnabled(isEditable);
        followUp.getDatePickerFollowUp().setEnabled(isEditable);
        followUp.getBtnFirst().setVisibility(View.GONE);
        followUp.getBtnPrev().setVisibility(View.GONE);
        followUp.getBtnNext().setVisibility(View.GONE);
        followUp.getBtnLast().setVisibility(View.GONE);

        if (isExist) {
            followUp.getLblStage().setVisibility(View.VISIBLE);
            followUp.getTxtCatatan().setVisibility(View.VISIBLE);
            followUp.getTxtNextFollowUp().setVisibility(View.VISIBLE);
            followUp.getSpnAction().setVisibility(View.VISIBLE);
            followUp.getSpnStatus().setVisibility(View.VISIBLE);
            followUp.getDatePickerFollowUp().setVisibility(View.VISIBLE);

            if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
                followUp.getBtnSave().setVisibility(View.VISIBLE);
                followUp.getBtnDelete().setVisibility(View.GONE);
            } else if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEBLACKBOX)) {
                followUp.getBtnSave().setVisibility(View.GONE);
                followUp.getBtnDelete().setVisibility(View.GONE);
                followUp.getBtnAdd().setVisibility(View.GONE);
            }

            if (totalData > 1) {
                followUp.getBtnFirst().setVisibility(View.VISIBLE);
                followUp.getBtnPrev().setVisibility(View.VISIBLE);
                followUp.getBtnNext().setVisibility(View.VISIBLE);
                followUp.getBtnLast().setVisibility(View.VISIBLE);
            }
        } else {
            followUp.getLblStage().setVisibility(View.GONE);
            followUp.getTxtCatatan().setVisibility(View.GONE);
            followUp.getTxtNextFollowUp().setVisibility(View.GONE);
            followUp.getSpnAction().setVisibility(View.GONE);
            followUp.getSpnStatus().setVisibility(View.GONE);
            followUp.getBtnSave().setVisibility(View.GONE);
            followUp.getBtnDelete().setVisibility(View.GONE);
            followUp.getDatePickerFollowUp().setVisibility(View.GONE);
        }
    }

    // Alert Message
    public void showAlert(int messageId) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.form_closing_title);
        alertDialog.setMessage(messageId);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }


    public void showConfirmationDelete(final int _recordIdx, final boolean isparent) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.form_closing_title);
        alertDialog.setMessage(R.string.msg_notification_delete);
        alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (isparent) {
//            		  deleteRecordParent();
                } else {
                    deleteRecordChild();
                }
                dialog.dismiss();
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton(R.string.str_no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void deleteRecordParent() {
        try {
            prospekData.updateDataToNullForPendekatan();
            prospekDataProvider.updateProspek(prospekData);
            followupDataProvider.deleteFollowUpByParentAndType(prospekData.getID().toString(), AppConstants.CLOSING_TYPE);
            showAlert(R.string.msg_notification_delete_success);
            closing = null;
            loadViewClosing(currIndexParent);
        } catch (Exception e) {
            showAlert(R.string.msg_notification_delete_error);
        }
    }

    public void deleteRecordChild() {
        try {
            String idObj = followupData.getID().toString();
            followupDataProvider.deleteFollowUpById(idObj);
            showAlert(R.string.msg_notification_delete_success);
            listdatafollowup.remove(idObj);
            followUp = null;
            loadViewFollowUp(INITINDEXRECORD);
        } catch (Exception e) {
            showAlert(R.string.msg_notification_delete_error);
        }
    }

    public Bitmap getPicture(String fileName) {
        System.out.println(fileName);
        File directory = new File(AppConstants.FILEPATH);
        File fileInDirectory = new File(directory, fileName);
        Bitmap imgBitmap = BitmapFactory.decodeFile(fileInDirectory.getAbsolutePath());

        return imgBitmap;

    }

    public Bitmap getUnAvailablePicture() {
        Bitmap imgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.no_image_available);
        return imgBitmap;
    }

    @SuppressLint("SimpleDateFormat")
    public void captureImage(final List<ImageView> _imgView, final List<TextView> _lblView) {
        final CameraDialog cameraDialog = new CameraDialog(ctx);

        cameraDialog.getCameraPreview().setCameraActionListiner(new CameraActionListener() {
            @Override
            public void onPictureTaken(CameraPreview cameraPreview) {
                Bitmap bmp;
                String fileName = userDetail.getUSERID() + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date());
                FileUtility.deleteFile(fileName, AppConstants.FILEPATH);

                for (int i = 0; i < _imgView.size(); i++) {
                    if (_imgView.get(i).getDrawable() == null) {
                        fileName = fileName + "_" + (i + 1) + AppConstants.JPGEXTENSION;
                        break;
                    }

                }

                cameraDialog.getCameraPreview().savePictureTo(new File(AppConstants.FILEPATH + fileName));
                cameraDialog.getCameraPreview().stopCamera();
                FileUtility.resizeImage(fileName, AppConstants.FILEPATH);

                for (int i = 0; i < _imgView.size(); i++) {
                    if (_lblView.get(i).getText().toString().equalsIgnoreCase("-")) {
                        bmp = getPicture(fileName);
                        _imgView.get(i).setVisibility(View.VISIBLE);
                        _imgView.get(i).setImageBitmap(bmp);
                        _lblView.get(i).setText(fileName);
                        SetPreviewImage(_imgView.get(i), _lblView.get(i), bmp, fileName, "0", true);

                        break;
                    }
                }

                cameraDialog.dismiss();
            }
        });

        cameraDialog.show();

    }

    public void SetPreviewImage(final ImageView imgView, final TextView lblView, final Bitmap bmp, final String fileName, final String id, final boolean statusAvailableImage) {

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previewimg = new PreviewImage(ctx);
                previewimg.getImgPreview().setImageBitmap(bmp);

                if (!statusAvailableImage) {
                    previewimg.getDeleteButton().setVisibility(View.GONE);
                }

                previewimg.getDeleteButton().setOnClickListener(new View.OnClickListener() {
                    @SuppressWarnings("deprecation")
                    @Override
                    public void onClick(View v) {
                        try {
                            lblView.setText(R.string.str_dash);

                            if (!id.equalsIgnoreCase("0")) {
                                new DeletePhotoTask().execute(id);
                            } else {
                                FileUtility.deleteFile(fileName, AppConstants.FILEPATH);
                                showAlert(R.string.msg_notification_photo_delete_success_submit);
                            }

                            imgView.setBackgroundDrawable(null);
                            imgView.setVisibility(View.GONE);
                        } catch (Exception e) {

                        }
                        previewimg.dismiss();
                        previewimg = null;
                    }
                });

                previewimg.getCancelButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        previewimg.dismiss();
                        previewimg = null;
                    }
                });

                previewimg.show();
            }
        });
    }

    private ArrayList<String> getImages() {
        String img1 = closing.getLblImg01().getText().toString();
        String img2 = closing.getLblImg02().getText().toString();
        String img3 = closing.getLblImg03().getText().toString();

        String[] temphotos = {img1, img2, img3};
        ArrayList<String> photos = new ArrayList<String>();

        for (int i = 0; i < temphotos.length; i++) {
            if (!temphotos[i].equalsIgnoreCase("-") && !temphotos[i].equalsIgnoreCase("")) {
                photos.add(temphotos[i]);
            }
        }
        return photos;
    }

    // DatePicker Listener
    private DatePickerDialog.OnDateSetListener closingDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
            closing.getTxtTglLahir().setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener FollowUpDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
            followUp.getTxtNextFollowUp().setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };

    private DatePickerDialog.OnDateSetListener FollowUpAddDialogDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
            followUpDialog.getTxtNextFollowUp().setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };

    @SuppressWarnings("deprecation")
    public void showProgressIndicator() {
        if (dlgProgress == null) {
            dlgProgress = new ProgressDialog(this);
            dlgProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dlgProgress.setTitle(getString(R.string.str_informasi));
            dlgProgress.setMessage("Sedang Memproses Data");
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

    private class DeletePhotoTask extends AsyncTask<String, String, String> {
        boolean responseSuccess = false;
        PhotoData photoData = null;

        @Override
        protected String doInBackground(String... photoId) {
            Log.d(TAG, "doInbackground");
            photoData = photoDataProvider.getPhotoDetail(photoId[0]);
            if (photoData != null && photoData.isISALREADYUPLOADEDTOSERVER()) {
                try {
                    ArrayList<PHOTORESPONSE> arrPhotoResponse = ServiceDataProvider.deletePhoto(photoData.getPROSPEKID(), photoData.getFILENAME());
                    if (arrPhotoResponse != null) {
                        if (arrPhotoResponse.size() > 0) {
                            if (arrPhotoResponse.get(0).getFILENAME().equalsIgnoreCase(photoData.getFILENAME())) {
                                responseSuccess = true;
                            }
                        }
                    }
                    arrPhotoResponse = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (photoData != null && !photoData.isISALREADYUPLOADEDTOSERVER()) {
                responseSuccess = true;
            }

            return photoId[0];
        }

        @Override
        protected void onPostExecute(String idPhoto) {
            Log.d(TAG, "Message Tasks: On post Execute");
            if (responseSuccess) {
                FileUtility.deleteFile(photoData.getFILENAME(), AppConstants.FILEPATH);
                try {
                    photoDataProvider.deletePhotoById(photoData.getID().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                showAlert(R.string.msg_notification_photo_delete_success_submit);
            } else {
                photoData.setISPENDINGDELETED(true);
                photoDataProvider.updatePhoto(photoData);
                showAlert(R.string.msg_notification_photo_delete_error_submit);
            }
        }
    }
}
