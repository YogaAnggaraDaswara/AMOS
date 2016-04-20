package com.mobile.app.activity.prospek;

import bii.mobile.mitra.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.activity.blackbox.BlackboxActivity;
import com.mobile.app.activity.common.FollowUp;
import com.mobile.app.activity.common.FollowUpDialogAdd;
import com.mobile.app.activity.common.GPSTracker;
import com.mobile.app.activity.common.SearchDialog;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.dataprovider.FollowUpDataProvider;
import com.mobile.bo.app.dataprovider.GeoLocationDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.dataprovider.ProspekDataProvider;
import com.mobile.bo.app.datatype.FollowupData;
import com.mobile.bo.app.datatype.GeoLocationData;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.bo.app.datatype.StateHistoryData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.framework.widget.ISpinnerItem;
import com.mobile.services.app.datatype.PROSPEKRESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

import android.os.Bundle;
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

public class ProspekActivity extends Activity {
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
    private LOVDataProvider lovDataProvider;
    private ProspekDataProvider prospekDataProvider;
    private FollowUpDataProvider followupDataProvider;
    private RelativeLayout contentParentContainer;
    private RelativeLayout contentChildContainer;
    private ImageView btnBack;
    private Prospek prospek;
    private ProspekDialogAdd leadsAddDialog;
    private FollowUp followUp;
    private SearchDialog searchDialog;
    private FollowUpDialogAdd followUpDialog;
    private ArrayList<ISpinnerItem> lovJenisUsaha = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovRadius = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovKomunitas = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovAction = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovStatus = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovJenisPembiayaan = new ArrayList<ISpinnerItem>();
    private MasterContent prevShownViewParent = null;
    private MasterContent prevShownViewChild = null;
    private ArrayList<String> listdataprospek = null;
    private ArrayList<String> listdatafollowup = null;
    private int INITINDEXRECORD = 0;
    private int currIndexParent = 0;
    private int currIndexChild = 0;
    private String LATITUDE = "0";
    private String LONGITUDE = "0";
    private GPSTracker tracker;
    private ProspekData prospekData = null;
    private FollowupData followupData = null;
    private Context ctx;
    private int paramIntentId = 0;
    private String paramIntentSource = "";
    private ProgressDialog dlgProgress = null;
    private Timer timerGetLocation;
    private static int INTERVAL_GET_LOCATION = 30;
    private GeoLocationDataProvider geoLocationDataProvider = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        lovDataProvider = new LOVDataProvider();
        prospekDataProvider = new ProspekDataProvider();
        followupDataProvider = new FollowUpDataProvider();
        geoLocationDataProvider = new GeoLocationDataProvider();
        tracker = GPSTracker.getInstance();
        initActivity();
    }

    @Override
    protected void onDestroy() {
        lovDataProvider.release();
        prospekDataProvider.release();
        followupDataProvider.release();
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
        setContentView(R.layout.prospek_layout);

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

        lblHeaderUser = (TextView) findViewById(R.id.prospek_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.prospek_lbl_currentdate);
        contentParentContainer = (RelativeLayout) findViewById(R.id.content_parent_layout);
        contentChildContainer = (RelativeLayout) findViewById(R.id.content_child_layout);
        btnBack = (ImageView) findViewById(R.id.prospek_btn_back);
        lovAction = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_ACTION_ID));
        lovStatus = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_STATUS_ID));
        lovRadius = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_RADIUS_ID));
        lovKomunitas = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_KOMUNITAS_ID));
        lovJenisUsaha = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_JENISUSAHA_ID));
        lovJenisPembiayaan = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PEMBIAYAAN_ID));

        loadDataProspek();
        if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
            loadViewProspek(paramIntentId);
        } else if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEBLACKBOX)) {
            loadViewProspek(INITINDEXRECORD);
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

    private void loadDataProspek() {
        if (listdataprospek != null) {
            listdataprospek.clear();
        }
        if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
            listdataprospek = prospekDataProvider.getAllProspekId(AppConstants.PROSPEK_TYPE);
        } else if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEBLACKBOX)) {
            listdataprospek = prospekDataProvider.getProspekById("" + paramIntentId);
        }
    }

    private void loadDataFollowUp(String parentId) {
        if (listdatafollowup != null) {
            listdatafollowup.clear();
        }
        listdatafollowup = followupDataProvider.getFollowupDetailIdByParent(parentId, AppConstants.PROSPEK_TYPE);
    }

    private void loadViewProspek(final int idxRecord) {

//		tracker.getLocation(ctx);
        currIndexParent = idxRecord;
        prospek = null;
        prospek = new Prospek(ctx);
        prospek.getContentTitle().setText(R.string.form_prospek_title);
        prospek.getSpnJenisUsaha().setListOfValue(lovJenisUsaha, false);
        prospek.getSpnRadius().setListOfValue(lovRadius, false);
        prospek.getSpnKomunitas().setListOfValue(lovKomunitas, false);

        if (listdataprospek.size() > 0) {
            prospekData = prospekDataProvider.getProspekDetail(listdataprospek.get(idxRecord));
            loadDataFollowUp(prospekData.getID().toString());
            manageContentPropertyParent(true, listdataprospek.size());
            prospek.getContentTitle().setText(AppConstants.getStage(AppConstants.PROSPEK_TYPE));
            prospek.getLblTotalRecords().setText((currIndexParent + 1) + "/" + listdataprospek.size());
            prospek.getLblKoordinat().setText(prospekData.getLATITUDE() + "," + prospekData.getLONGITUDE());
            prospek.getTxtNamaUsaha().setText(prospekData.getNAMAUSAHA());
            prospek.getTxtAlamatUsaha().setText(prospekData.getALAMATUSAHA());
            prospek.getSpnJenisUsaha().setSelectedListOfValue(prospekData.getJENISUSAHA());
            prospek.getSpnRadius().setSelectedListOfValue(prospekData.getRADIUS());
            prospek.getSpnKomunitas().setSelectedListOfValue(prospekData.getKOMUNITAS());
            loadViewFollowUp(INITINDEXRECORD);

            if (prospekData.getLATITUDE().equalsIgnoreCase("0")) {
                prospek.getTagLokasi().setVisibility(View.VISIBLE);
            }

            prospek.getTagLokasi().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prospek.getTagLokasi().setVisibility(View.GONE);
                    prospek.getLayoutAction().setEnabled(false);
                    timerGetLocation = new Timer();
                    timerGetLocation.scheduleAtFixedRate(new TimerTask() {
                        public void run() {
                            INTERVAL_GET_LOCATION--;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    prospek.getProgressLoader().setVisibility(View.VISIBLE);
                                    if (INTERVAL_GET_LOCATION == 0) {
                                        timerGetLocation.cancel();
                                        INTERVAL_GET_LOCATION = 30;
                                        prospek.getProgressLoader().setVisibility(View.GONE);
                                        prospek.getLayoutAction().setEnabled(true);

                                        if (tracker.getLatitude() == 0) {
                                            prospek.getTagLokasi().setVisibility(View.VISIBLE);
                                        }
                                        prospek.getLblKoordinat().setText(tracker.getLatitude() + "," + tracker.getLongitude());
                                    } else {
                                        prospek.getLblKoordinat().setText("Mencari Lokasi: " + INTERVAL_GET_LOCATION + " s");
                                    }
                                }
                            });
                        }
                    }, AppConstants.TIMERDELAY, AppConstants.TIMERPERIOD);
                }
            });


        } else {
            prospek.getLblTotalRecords().setText((currIndexParent) + "/" + listdataprospek.size());
            manageContentPropertyParent(false, 0);
            if (contentChildContainer != null) {
                contentChildContainer.removeView(prevShownViewChild);
            }
        }

        if (contentParentContainer != null) {
            contentParentContainer.removeView(prevShownViewParent);
        }

        // handle action button
        prospek.getBtnAdd().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFormAddLeads();
            }
        });

        prospek.getBtnSave().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prospek.checkContentValidation() == null) {
                    showProgressIndicator();
                    updateProspek(AppConstants.SAVE);
                    // update to server
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
                                                    followupDataProvider.updatePendingUpdatedFollowUpToServer(prospekData.getID(), AppConstants.PROSPEK_TYPE);
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

                                        if (!isException) {
                                            showAlert(R.string.msg_notification_submit_success);
                                        } else {
                                            showAlert(R.string.msg_notification_submit_error);
                                        }

                                        loadViewProspek(idxRecord);
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

        prospek.getBtnSubmit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prospek.checkContentValidation() == null) {
                    showProgressIndicator();
                    updateProspek(AppConstants.SUBMIT);
                    try {
                        prospekData.setISPENDINGUPDATEDTOSERVER(false);
                        followupDataProvider.updatePendingUpdatedFollowUpToServer(prospekData.getID(), AppConstants.PROSPEK_TYPE);
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
                                                    followupDataProvider.updateFollowUpByParentAndType(prospekid, objRes.getID(), AppConstants.PROSPEK_TYPE);
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

                                        StateHistoryData stateHistoryProspek = new StateHistoryData(prospekid, prospekData.getID().toString(), AppConstants.PROSPEK_TYPE, prospekData.getDATE(), new Date(), userDetail.getUSERID());
                                        prospekDataProvider.updateStateHistory(stateHistoryProspek);

                                        if (!isException) {
                                            showAlert(R.string.msg_notification_submit_success);
                                        } else {
                                            showAlert(R.string.msg_notification_submit_error);
                                        }

                                        loadDataProspek();
                                        loadViewProspek(INITINDEXRECORD);
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

        prospek.getBtnBlackbox().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
                    if (prospek.checkContentValidation() == null) {
                        showProgressIndicator();
                        updateProspek(AppConstants.BLACKBOX);
                        try {
                            prospekData.setISPENDINGUPDATEDTOSERVER(false);
                            followupDataProvider.updatePendingUpdatedFollowUpToServer(prospekData.getID(), AppConstants.PROSPEK_TYPE);
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
                                                        followupDataProvider.updateFollowUpByParentAndType(prospekid, objRes.getID(), AppConstants.PROSPEK_TYPE);
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
                                            StateHistoryData stateHistoryProspek = new StateHistoryData(prospekid, prospekData.getID().toString(), AppConstants.PROSPEK_TYPE, prospekData.getDATE(), new Date(), userDetail.getUSERID());
                                            prospekDataProvider.updateStateHistory(stateHistoryProspek);
                                            if (!isException) {
                                                try {
                                                    followupDataProvider.deleteFollowUpByParent(prospekData.getID().toString());
                                                    prospekDataProvider.deleteProspekById(prospekData.getID().toString());
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                showAlert(R.string.msg_notification_blackbox_success);
                                            } else {
                                                showAlert(R.string.msg_notification_blackbox_pending);
                                            }

                                            loadDataProspek();
                                            loadViewProspek(INITINDEXRECORD);
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

        prospek.getBtnDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDelete(true);
            }
        });

        prospek.getBtnFirst().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currIndexParent != 0) {
                    loadViewProspek(0);
                }
            }
        });

        prospek.getBtnPrev().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int previndex = currIndexParent - 1 <= 0 ? 0 : currIndexParent - 1;
                loadViewProspek(previndex);
            }
        });

        prospek.getBtnNext().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextindex = currIndexParent + 1 >= listdataprospek.size() - 1 ? listdataprospek.size() - 1 : currIndexParent + 1;
                loadViewProspek(nextindex);
            }
        });

        prospek.getBtnLast().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currIndexParent != listdataprospek.size() - 1) {
                    loadViewProspek(listdataprospek.size() - 1);
                }
            }
        });

        prospek.getBtnSearch().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFormSearch();
            }
        });


        contentParentContainer.addView(prospek);
        prevShownViewParent = prospek;
    }

    @SuppressWarnings("deprecation")
    public void updateProspek(int state) {
        Date currdate = prospekData.getDATE();
        String time = currdate.getHours() + ":" + currdate.getMinutes() + ":" + currdate.getSeconds();
        String namausaha = prospek.getTxtNamaUsaha().getText().toString();
        String alamat = prospek.getTxtAlamatUsaha().getText().toString();
        String jenisusaha = prospek.getSpnJenisUsaha().getSelectedListOfValue().toString();
        String radius = prospek.getSpnRadius().getSelectedListOfValue().toString();
        String komunitas = prospek.getSpnKomunitas().getSelectedListOfValue().toString();

        if (prospekData.getLATITUDE().equalsIgnoreCase("0")) {
            if (tracker.getLatitude() == 0) {
                GeoLocationData geolocationdata = geoLocationDataProvider.getLastGeoLocation();
                if (geolocationdata != null) {
                    prospekData.setLATITUDE(geolocationdata.getLATITUDE());
                    prospekData.setLONGITUDE(geolocationdata.getLONGITUDE());
                }
            } else {
                prospekData.setLATITUDE("" + tracker.getLatitude());
                prospekData.setLONGITUDE("" + tracker.getLongitude());
            }
        }


        if (state == AppConstants.SAVE) {
            prospekData.update(userDetail.getUSERID(), prospekData.getLATITUDE(), prospekData.getLONGITUDE(), currdate, time, namausaha, alamat, jenisusaha, radius, komunitas, false, false, AppConstants.PROSPEK_TYPE, prospekData.getPROSPEKID(), null);
        } else if (state == AppConstants.SUBMIT) {
            prospekData.update(userDetail.getUSERID(), prospekData.getLATITUDE(), prospekData.getLONGITUDE(), currdate, time, namausaha, alamat, jenisusaha, radius, komunitas, false, false, AppConstants.KENALAN_TYPE, prospekData.getPROSPEKID(), new Date());
            prospekData.setSUBMITDATE(new Date());
        } else if (state == AppConstants.BLACKBOX) {
            prospekData.update(userDetail.getUSERID(), prospekData.getLATITUDE(), prospekData.getLONGITUDE(), currdate, time, namausaha, alamat, jenisusaha, radius, komunitas, true, false, AppConstants.PROSPEK_TYPE, prospekData.getPROSPEKID(), new Date());
            prospekData.setSUBMITDATE(new Date());
        } else if (state == AppConstants.DELETE) {
            prospekData.setSTAGE(AppConstants.DELETED_TYPE);
            prospekData.setSUBMITDATE(new Date());
        }
        prospekData.setPREVIOUSSTAGE(AppConstants.PROSPEK_TYPE);
        prospekData.setUNIT(userDetail.getUNIT());
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
            followupData = followupDataProvider.getFollowupDetail(listdatafollowup.get(currIndexChild).toString());
            manageContentPropertyChild(true, followupData.isEDITABLE(), listdatafollowup.size());
            followUp.getLblTotalRecords().setText((currIndexChild + 1) + "/" + listdatafollowup.size());
            followUp.getLblStage().setText(AppConstants.getStage(followupData.getSTAGE()));
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
                    final String catatan = followUp.getTxtCatatan().getText().toString();
                    final Date nextfollowup = DateFormatter.formatDate(followUp.getTxtNextFollowUp().getText().toString());
                    final String action = followUp.getSpnAction().getSelectedListOfValue().toString();
                    final String status = followUp.getSpnStatus().getSelectedListOfValue().toString();

                    followupData.update(userDetail.getUSERID(), AppConstants.PROSPEK_TYPE, nextfollowup, status, catatan, true, action);

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
                showConfirmationDelete(false);
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

    private void showFormAddLeads() {
        leadsAddDialog = new ProspekDialogAdd(ctx);
        leadsAddDialog.getSpnJenisUsaha().setListOfValue(lovJenisUsaha, false);
        leadsAddDialog.getSpnRadius().setListOfValue(lovRadius, false);
        leadsAddDialog.getSpnKomunitas().setListOfValue(lovKomunitas, false);
        leadsAddDialog.getLblKoordinat().setText(tracker.getLatitude() + "," + tracker.getLongitude());
        leadsAddDialog.getContentTitle().setText(AppConstants.getStage(AppConstants.PROSPEK_TYPE));

        if (tracker.getLatitude() == 0) {
            leadsAddDialog.getTagLokasi().setVisibility(View.VISIBLE);
        }

        leadsAddDialog.getTagLokasi().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leadsAddDialog.getBtnSave().setEnabled(false);
                leadsAddDialog.getBtnBack().setEnabled(false);
                leadsAddDialog.getTagLokasi().setVisibility(View.GONE);

                timerGetLocation = new Timer();
                timerGetLocation.scheduleAtFixedRate(new TimerTask() {
                    public void run() {
                        INTERVAL_GET_LOCATION--;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                leadsAddDialog.getProgressLoader().setVisibility(View.VISIBLE);
                                if (INTERVAL_GET_LOCATION == 0) {
                                    timerGetLocation.cancel();
                                    INTERVAL_GET_LOCATION = 30;
                                    leadsAddDialog.getProgressLoader().setVisibility(View.GONE);
                                    leadsAddDialog.getBtnSave().setEnabled(true);
                                    leadsAddDialog.getBtnBack().setEnabled(true);

                                    if (tracker.getLatitude() == 0) {
                                        leadsAddDialog.getTagLokasi().setVisibility(View.VISIBLE);

                                    }
                                    leadsAddDialog.getLblKoordinat().setText(tracker.getLatitude() + "," + tracker.getLongitude());
                                } else {
                                    leadsAddDialog.getLblKoordinat().setText("Mencari Lokasi: " + INTERVAL_GET_LOCATION + " s");
                                }
                            }
                        });
                    }
                }, AppConstants.TIMERDELAY, AppConstants.TIMERPERIOD);
            }
        });

        leadsAddDialog.getBtnSave().setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {
                if (leadsAddDialog.checkContentValidation() == null) {
                    showProgressIndicator();

                    String prospekId = "P" + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date()) + userDetail.getUSERID();
                    Date currdate = new Date();
                    String time = currdate.getHours() + ":" + currdate.getMinutes() + ":" + currdate.getSeconds();
                    String namausaha = leadsAddDialog.getTxtNamaUsaha().getText().toString();
                    String alamat = leadsAddDialog.getTxtAlamatUsaha().getText().toString();
                    String jenisusaha = leadsAddDialog.getSpnJenisUsaha().getSelectedListOfValue().toString();
                    String radius = leadsAddDialog.getSpnRadius().getSelectedListOfValue().toString();
                    String komunitas = leadsAddDialog.getSpnKomunitas().getSelectedListOfValue().toString();

                    final ProspekData pd = new ProspekData();
                    pd.update(userDetail.getUSERID(), LATITUDE, LONGITUDE, currdate, time, namausaha, alamat, jenisusaha, radius, komunitas, false, false, AppConstants.PROSPEK_TYPE, "", null);
                    pd.setPREVIOUSSTAGE(AppConstants.PROSPEK_TYPE);

                    if (tracker.getLatitude() == 0) {
                        GeoLocationData geolocationdata = geoLocationDataProvider.getLastGeoLocation();
                        if (geolocationdata != null) {
                            pd.setLATITUDE(geolocationdata.getLATITUDE());
                            pd.setLONGITUDE(geolocationdata.getLONGITUDE());
                        }
                    } else {
                        pd.setLATITUDE("" + tracker.getLatitude());
                        pd.setLONGITUDE("" + tracker.getLongitude());
                    }

                    pd.setID(prospekId);
                    pd.setISBLACKBOXFROMSERVER(false);
                    pd.setUNIT(userDetail.getUNIT());

                    // update to server
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    boolean isException = false;
                                    String prospekid = "";
                                    try {
                                        ArrayList<PROSPEKRESPONSE> prospekResponse = ServiceDataProvider.updateNewDataProspek(pd, null);
                                        if (prospekResponse != null) {
                                            if (prospekResponse.size() > 0) {
                                                PROSPEKRESPONSE objRes = prospekResponse.get(0);
                                                if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE) && objRes.getID().equalsIgnoreCase(pd.getID().toString())) {
                                                    prospekid = objRes.getPROSPEKID();
                                                    pd.setPROSPEKID(prospekid);
                                                } else {
                                                    showAlert(R.string.msg_notification_submit_failed);
                                                    return;
                                                }
                                                objRes = null;
                                            }
                                        }
                                        prospekResponse = null;
                                    } catch (Exception e) {
                                        pd.setISPENDINGUPDATEDTOSERVER(true);
                                        isException = true;
                                    }

                                    int retVal = prospekDataProvider.updateProspek(pd);
                                    if (retVal > 0) {

                                        if (!isException) {
                                            showAlert(R.string.msg_notification_submit_success);
                                        } else {
                                            showAlert(R.string.msg_notification_submit_error);
                                        }

                                        leadsAddDialog.dismiss();
                                        leadsAddDialog = null;
                                        loadDataProspek();
                                        loadViewProspek(listdataprospek.size() - 1);
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


        leadsAddDialog.getBtnBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leadsAddDialog.dismiss();
                leadsAddDialog = null;
            }
        });

        leadsAddDialog.show();
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
                    String namausaha = searchDialog.getTxtNamaUsaha().getText().toString();//.equalsIgnoreCase("")?null:searchDialog.getTxtNamaUsaha().getText().toString();
                    String namadebitur = searchDialog.getTxtNamaDebitur().getText().toString();//.equalsIgnoreCase("")?null:searchDialog.getTxtNamaDebitur().getText().toString();
                    String jenisusaha = searchDialog.getSpnJenisUsaha().getSelectedListOfValue().toString();//.equalsIgnoreCase("")?null:searchDialog.getSpnJenisUsaha().getSelectedListOfValue().toString();
                    String jenispembiayaan = searchDialog.getSpnJenisPembiayaan().getSelectedListOfValue().toString();//.equalsIgnoreCase("")?null:searchDialog.getSpnJenisPembiayaan().getSelectedListOfValue().toString();

                    ProspekData searchData = prospekDataProvider.searchProspekOr(namausaha, namadebitur, jenisusaha, jenispembiayaan, AppConstants.PROSPEK_TYPE);
                    ////
                    if (searchData != null) {
                        for (int i = 0; i < listdataprospek.size(); i++) {
                            if (listdataprospek.get(i).equalsIgnoreCase(searchData.getID().toString())) {
                                idxFound = i;
                                found = true;
                                break;
                            }

                        }
                    }

                    ////
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
							searchData = prospekDataProvider.searchProspekOr(namausaha, namadebitur, jenisusaha, jenispembiayaan,AppConstants.PROSPEK_TYPE);
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
                        loadViewProspek(idxFound);
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

    private void showFormAddFollowUp() {
        followUpDialog = new FollowUpDialogAdd(ctx);
        followUpDialog.getLblStage().setText(R.string.title_activity_prospek);
        followUpDialog.getSpnAction().setListOfValue(lovAction, false);
        followUpDialog.getSpnStatus().setListOfValue(lovStatus, false);

        followUpDialog.getBtnSave().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (followUpDialog.checkContentValidation() == null) {
                    showProgressIndicator();

                    String followupId = "F" + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date()) + userDetail.getUSERID();
                    final String parentId = prospekData.getID().toString();
                    Date nextfollowup = DateFormatter.formatDate(followUpDialog.getTxtNextFollowUp().getText().toString());
                    String catatan = followUpDialog.getTxtCatatan().getText().toString();
                    String action = followUpDialog.getSpnAction().getSelectedListOfValue().toString();
                    String status = followUpDialog.getSpnStatus().getSelectedListOfValue().toString();

                    final FollowupData fu = new FollowupData();
                    fu.update(userDetail.getUSERID(), AppConstants.PROSPEK_TYPE, nextfollowup, status, catatan, true, action, parentId);
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


    public void deleteRecordParent() {
        try {
            String idObj = prospekData.getID().toString();
            followupDataProvider.deleteFollowUpByParent(idObj);
            prospekDataProvider.deleteProspekById(idObj);
            showAlert(R.string.msg_notification_delete_success);
            listdataprospek.remove(idObj);
            prospek = null;
            loadViewProspek(INITINDEXRECORD);
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

    public void manageContentPropertyParent(boolean status, int totalData) {
        prospek.getBtnFirst().setVisibility(View.GONE);
        prospek.getBtnPrev().setVisibility(View.GONE);
        prospek.getBtnNext().setVisibility(View.GONE);
        prospek.getBtnLast().setVisibility(View.GONE);
        if (status) {
            prospek.getTxtNamaUsaha().setVisibility(View.VISIBLE);
            prospek.getTxtAlamatUsaha().setVisibility(View.VISIBLE);
            prospek.getSpnJenisUsaha().setVisibility(View.VISIBLE);
            prospek.getSpnRadius().setVisibility(View.VISIBLE);
            prospek.getSpnKomunitas().setVisibility(View.VISIBLE);

            if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEHOME)) {
                prospek.getBtnSave().setVisibility(View.VISIBLE);
                prospek.getBtnDelete().setVisibility(View.GONE);
                prospek.getBtnSubmit().setVisibility(View.VISIBLE);
                prospek.getBtnBlackbox().setVisibility(View.VISIBLE);
            } else if (paramIntentSource.equalsIgnoreCase(AppConstants.PAGEBLACKBOX)) {
                prospek.getBtnSave().setVisibility(View.GONE);
                prospek.getBtnDelete().setVisibility(View.GONE);
                prospek.getBtnSubmit().setVisibility(View.GONE);
                prospek.getBtnBlackbox().setVisibility(View.GONE);
                prospek.getBtnAdd().setVisibility(View.GONE);
            }


            if (totalData > 1) {
                prospek.getBtnFirst().setVisibility(View.VISIBLE);
                prospek.getBtnPrev().setVisibility(View.VISIBLE);
                prospek.getBtnNext().setVisibility(View.VISIBLE);
                prospek.getBtnLast().setVisibility(View.VISIBLE);
                prospek.getBtnSearch().setVisibility(View.VISIBLE);
            }
        } else {
            prospek.getTxtNamaUsaha().setVisibility(View.GONE);
            prospek.getTxtAlamatUsaha().setVisibility(View.GONE);
            prospek.getSpnJenisUsaha().setVisibility(View.GONE);
            prospek.getSpnRadius().setVisibility(View.GONE);
            prospek.getSpnKomunitas().setVisibility(View.GONE);
            prospek.getBtnSave().setVisibility(View.GONE);
            prospek.getBtnDelete().setVisibility(View.GONE);
            prospek.getBtnSubmit().setVisibility(View.GONE);
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
        alertDialog.setTitle(R.string.form_prospek_title_add);
        alertDialog.setMessage(messageId);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void showConfirmationDelete(final boolean isparent) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.form_prospek_title);
        alertDialog.setMessage(R.string.msg_notification_delete);
        alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (isparent) {
                    deleteProspek();
                    //deleteRecordParent();
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

    // DatePicker Listener
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

    public void deleteProspek() {
        updateProspek(AppConstants.DELETE);
        try {
            prospekData.setISPENDINGUPDATEDTOSERVER(false);
            followupDataProvider.updatePendingUpdatedFollowUpToServer(prospekData.getID(), AppConstants.PROSPEK_TYPE);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showProgressIndicator();
                        boolean isException = false;
                        String prospekid = prospekData.getPROSPEKID();
                        try {
                            ArrayList<ProspekData> prospeks = new ArrayList<ProspekData>();
                            prospeks.add(prospekData);
                            ArrayList<PROSPEKRESPONSE> prospekResponse = ServiceDataProvider.submitDataProspek(prospeks, AppConstants.DIRECT_EXCLUDE_SUBMIT);
                            if (prospekResponse != null) {
                                if (prospekResponse.size() > 0) {
                                    PROSPEKRESPONSE objRes = prospekResponse.get(0);
                                    if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE) && objRes.getID().equalsIgnoreCase(prospekData.getID().toString())) {
                                        prospekid = objRes.getPROSPEKID();
                                    } else {
                                        showAlert(R.string.msg_notification_delete_error_submit);
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
                            StateHistoryData stateHistoryProspek = new StateHistoryData(prospekid, prospekData.getID().toString(), AppConstants.DELETED_TYPE, prospekData.getDATE(), new Date(), userDetail.getUSERID());
                            prospekDataProvider.updateStateHistory(stateHistoryProspek);
                            if (!isException) {
                                try {
                                    followupDataProvider.deleteFollowUpByParent(prospekData.getID().toString());
                                    prospekDataProvider.deleteProspekById(prospekData.getID().toString());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                showAlert(R.string.msg_notification_delete_success_submit);
                            } else {
                                showAlert(R.string.msg_notification_delete_error_submit);
                            }

                            loadDataProspek();
                            loadViewProspek(INITINDEXRECORD);
                        } else {
                            showAlert(R.string.msg_notification_delete_error_submit);
                        }
                        hideProgressIndicator();
                    }
                });
            }
        }).start();
    }
}
