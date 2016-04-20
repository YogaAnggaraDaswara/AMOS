package com.mobile.app.activity.blackbox;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.util.ByteArrayBuffer;

import bii.mobile.mitra.R;

import com.mobile.app.activity.blackbox.BlackboxActivity;
import com.mobile.app.activity.common.FollowUpBlackbox;
import com.mobile.app.activity.common.PreviewImage;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.media.CameraDialog;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.dataprovider.FollowUpDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.dataprovider.PhotoDataProvider;
import com.mobile.bo.app.dataprovider.ProspekDataProvider;
import com.mobile.bo.app.datatype.FollowupData;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.common.FileUtility;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.framework.media.CameraActionListener;
import com.mobile.framework.media.CameraPreview;
import com.mobile.services.app.services.JSONServiceHandler;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class BlackboxDetailActivity extends Activity {
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
    private BlackboxDetail blackboxdetail;
    private FollowUpBlackbox followUp;
    private PreviewImage previewimg = null;
    private MasterContent prevShownViewParent = null;
    private MasterContent prevShownViewChild = null;
    private ArrayList<String> listdataprospek = null;
    private ArrayList<String> listdatafollowup = null;
    private List<ImageView> imgView = null;
    private List<TextView> lblView = null;
    private int INITINDEXRECORD = 0;
    private int currIndexParent = 0;
    private int currIndexChild = 0;
    private Context ctx;
    private ProspekData prospekData = null;
    private FollowupData followupData = null;
    private String paramIntentId = "";
    private String prospekView = "";
    private ProgressDialog dlgProgress = null;
    private static final String TAG = "Blackbox Detail Activity";

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
        ActivityHandler.gotoActivity(ctx, BlackboxActivity.class, null);
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
                paramIntentId = intent.getStringExtra(AppConstants.KEYINITIALINDEX);
            }
            if (intent.hasExtra(AppConstants.KEYPROSPEKVIEW)) {
                prospekView = intent.getStringExtra(AppConstants.KEYPROSPEKVIEW);
            }
        }

        lblHeaderUser = (TextView) findViewById(R.id.closing_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.closing_lbl_currentdate);
        contentParentContainer = (RelativeLayout) findViewById(R.id.content_parent_layout);
        contentChildContainer = (RelativeLayout) findViewById(R.id.content_child_layout);
        btnBack = (ImageView) findViewById(R.id.closing_btn_back);

        loadDataDetailBlackbox();
        loadViewDetailBlackbox();

        if (isUserDetailExist) {
            lblHeaderUser.setText(
                    String.format("%s # %s", userDetail.getNAME(), userDetail.getLOCATION()));

            lblDateTime.setText(String.format("%s", DateFormatter.format(new Date())));
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityHandler.gotoActivity(ctx, BlackboxActivity.class, null);
                finish();
            }
        });
    }

    private void loadDataDetailBlackbox() {
        if (listdataprospek != null) {
            listdataprospek.clear();
        }

        listdataprospek = prospekDataProvider.getProspekById(paramIntentId);

    }

    private void loadDataFollowUp(String parentId) {
        if (listdatafollowup != null) {
            listdatafollowup.clear();
        }
        listdatafollowup = followupDataProvider.getFollowupDetailIdByParent(parentId, prospekView);
    }

    private void loadViewDetailBlackbox() {
        blackboxdetail = null;
        blackboxdetail = new BlackboxDetail(ctx);
        blackboxdetail.getContentTitle().setText(AppConstants.getStage(prospekView));

        if (contentParentContainer != null) {
            contentParentContainer.removeView(prevShownViewParent);
        }
        if (contentChildContainer != null) {
            contentChildContainer.removeView(prevShownViewChild);
        }
        if (listdataprospek.size() > 0) {
            prospekData = prospekDataProvider.getProspekDetail(listdataprospek.get(INITINDEXRECORD));
            loadDataFollowUp(prospekData.getID().toString());
            manageContentPropertyParent(listdataprospek.size());
            imgView = new ArrayList<ImageView>();
            lblView = new ArrayList<TextView>();

            imgView.add(blackboxdetail.getImgView01());
            imgView.add(blackboxdetail.getImgView02());
            imgView.add(blackboxdetail.getImgView03());
            lblView.add(blackboxdetail.getLblImg01());
            lblView.add(blackboxdetail.getLblImg02());
            lblView.add(blackboxdetail.getLblImg03());
            blackboxdetail.getLblTotalRecords().setText((currIndexParent + 1) + "/" + listdataprospek.size());
            blackboxdetail.getLblKoordinat().setText(prospekData.getLATITUDE() + "," + prospekData.getLONGITUDE());
            blackboxdetail.getLblNamaUsahaValue().setText(prospekData.getNAMAUSAHA());
            blackboxdetail.getLblAlamatUsahaValue().setText(prospekData.getALAMATUSAHA());
            blackboxdetail.getLblJenisUsahaValue().setText(lovDataProvider.getLOVDetail(prospekData.getJENISUSAHA(), AppConstants.SPINNER_JENISUSAHA_ID).getDESCRIPTION());
            blackboxdetail.getLblRadiusValue().setText(lovDataProvider.getLOVDetail(prospekData.getRADIUS(), AppConstants.SPINNER_RADIUS_ID).getDESCRIPTION());
            blackboxdetail.getLblKomunitasValue().setText(lovDataProvider.getLOVDetail(prospekData.getKOMUNITAS(), AppConstants.SPINNER_KOMUNITAS_ID).getDESCRIPTION());
            blackboxdetail.getLblNamaDebiturValue().setText(prospekData.getNAMADEBITUR().equalsIgnoreCase("") ? "-" : prospekData.getNAMADEBITUR());
            if (prospekData.getTGLLAHIR() != null) {
                blackboxdetail.getLblTglLahirValue().setText(DateFormatter.formatString(prospekData.getTGLLAHIR()));
            }
            blackboxdetail.getLblHandphoneValue().setText(prospekData.getHANDPHONE().equalsIgnoreCase("") ? "-" : prospekData.getHANDPHONE());
            blackboxdetail.getLblPembiayaanValue().setText(prospekData.getJENISPEMBIAYAAN().equalsIgnoreCase("") ? "-" : lovDataProvider.getLOVDetail(prospekData.getJENISPEMBIAYAAN(), AppConstants.SPINNER_PEMBIAYAAN_ID).getDESCRIPTION());
            blackboxdetail.getLblTeleponRumahValue().setText(prospekData.getTELEPONRUMAH().equalsIgnoreCase("") ? "-" : prospekData.getTELEPONRUMAH());
            blackboxdetail.getLblAlamatRumahValue().setText(prospekData.getALAMATRUMAH().equalsIgnoreCase("") ? "-" : prospekData.getALAMATRUMAH());
            String plafond = formatCurrency(prospekData.getPLAFOND());
            blackboxdetail.getLblPlafondValue().setText(prospekData.getPLAFOND().equalsIgnoreCase("") ? "0" : plafond);
            blackboxdetail.getLblKTPValue().setText(prospekData.getKTP().equalsIgnoreCase("") ? "-" : prospekData.getKTP());
            blackboxdetail.getLblNPWPValue().setText(prospekData.getNPWP().equalsIgnoreCase("") ? "-" : prospekData.getNPWP());
            blackboxdetail.getLblSIUPSKUValue().setText(prospekData.getSIUPSKU().equalsIgnoreCase("") ? "-" : prospekData.getSIUPSKU());

            if (!prospekView.equalsIgnoreCase(AppConstants.PROSPEK_TYPE)) {
                blackboxdetail.getBtnTakePicture().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (blackboxdetail.getLblImg01().getText().toString().equalsIgnoreCase("-") ||
                                blackboxdetail.getLblImg02().getText().toString().equalsIgnoreCase("-") ||
                                blackboxdetail.getLblImg03().getText().toString().equalsIgnoreCase("-")) {

                            captureImage(imgView, lblView);
                        } else {
                            showAlert(R.string.msg_notification_error_picture);
                        }
                    }
                });
            }

            loadViewFollowUp(INITINDEXRECORD);

            blackboxdetail.getBtnBlackbox().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prospekData.setISCHECKED(true);
                    prospekDataProvider.updateProspek(prospekData);
                    ActivityHandler.gotoActivity(ctx, BlackboxActivity.class, null);
                    finish();
                }
            });

            // Load Photo
            if (!prospekView.equalsIgnoreCase(AppConstants.PROSPEK_TYPE)) {
                new PhotoTask().execute();
            }

            contentParentContainer.addView(blackboxdetail);
            prevShownViewParent = blackboxdetail;

        }
    }

    @SuppressLint("NewApi")
    public String formatCurrency(String value) {
        String numberformat = "";
        String userInput = value.replace("R", "").replace("p", "").replace(" ", "").replace(".", "");

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

    // show child
    private void loadViewFollowUp(final int idxRecordChild) {
        currIndexChild = idxRecordChild;
        followUp = null;
        followUp = new FollowUpBlackbox(ctx);
        followUp.getContentTitle().setText(R.string.form_followup_title);

        if (listdatafollowup.size() > 0) {
            followupData = null;
            followupData = followupDataProvider.getFollowupDetail(listdatafollowup.get(currIndexChild).toString());
            manageContentPropertyChild(true, followupData.isEDITABLE(), listdatafollowup.size());
            followUp.getLblTotalRecords().setText((currIndexChild + 1) + "/" + listdatafollowup.size());
            followUp.getLblStage().setText(AppConstants.getStage(followupData.getSTAGE()));
            if (followupData.getNEXTFOLLOWUP() != null) {
                followUp.getLblNextFollowUp().setText(DateFormatter.formatString(followupData.getNEXTFOLLOWUP()));
            }
            followUp.getLblCatatan().setText(followupData.getCATATAN());
            followUp.getLblAction().setText(followupData.getACTION() != null ? "-" : lovDataProvider.getLOVDetail(followupData.getACTION(), AppConstants.SPINNER_ACTION_ID).getDESCRIPTION());
            followUp.getLblStatus().setText(followupData.getSTATUS() != null ? "-" : lovDataProvider.getLOVDetail(followupData.getSTATUS(), AppConstants.SPINNER_STATUS_ID).getDESCRIPTION());
        } else {
            followUp.getLblTotalRecords().setText((currIndexChild) + "/" + listdatafollowup.size());
            manageContentPropertyChild(false, false, 0);
        }

        if (contentChildContainer != null) {
            contentChildContainer.removeView(prevShownViewChild);
        }

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


        contentChildContainer.addView(followUp);
        prevShownViewChild = followUp;
    }


    public void manageContentPropertyParent(int totalData) {
        if (prospekView.equalsIgnoreCase(AppConstants.PROSPEK_TYPE) || prospekView.equalsIgnoreCase(AppConstants.KENALAN_TYPE)) {

            if (prospekView.equalsIgnoreCase(AppConstants.PROSPEK_TYPE)) {
                    /*blackboxdetail.getLblNamaDebitur().setVisibility(View.GONE);
					blackboxdetail.getLblTglLahir().setVisibility(View.GONE);
					blackboxdetail.getLblHandphone().setVisibility(View.GONE);
					blackboxdetail.getLblPembiayaan().setVisibility(View.GONE);
					blackboxdetail.getLblFotoLokasi().setVisibility(View.GONE);	

					blackboxdetail.getLblNamaDebiturValue().setVisibility(View.GONE);
					blackboxdetail.getLblTglLahirValue().setVisibility(View.GONE);
					blackboxdetail.getLblHandphoneValue().setVisibility(View.GONE);
					blackboxdetail.getLblPembiayaanValue().setVisibility(View.GONE);
					blackboxdetail.getLayoutPhoto().setVisibility(View.GONE);		*/

                blackboxdetail.getProspek_Li_namadebitur().setVisibility(View.GONE);
                blackboxdetail.getProspek_Li_tgllahir().setVisibility(View.GONE);
                blackboxdetail.getProspek_Li_handphone().setVisibility(View.GONE);
                blackboxdetail.getProspek_Li_pembiayaan().setVisibility(View.GONE);
                blackboxdetail.getProspek_Li_image().setVisibility(View.GONE);

            }
				
				/*blackboxdetail.getLblTeleponRumahValue().setVisibility(View.GONE);
				blackboxdetail.getLblAlamatRumahValue().setVisibility(View.GONE);
				blackboxdetail.getLblPlafondValue().setVisibility(View.GONE);
				blackboxdetail.getLblKTPValue().setVisibility(View.GONE);
				blackboxdetail.getLblNPWPValue().setVisibility(View.GONE);
				blackboxdetail.getLblSIUPSKUValue().setVisibility(View.GONE);	
				
				
				blackboxdetail.getLblTeleponRumah().setVisibility(View.GONE);
				blackboxdetail.getLblAlamatRumah().setVisibility(View.GONE);
				blackboxdetail.getLblPlafond().setVisibility(View.GONE);
				blackboxdetail.getLblKTP().setVisibility(View.GONE);
				blackboxdetail.getLblNPWP().setVisibility(View.GONE);
				blackboxdetail.getLblSIUPSKU().setVisibility(View.GONE);*/


            blackboxdetail.getProspek_Li_telponrumah().setVisibility(View.GONE);
            blackboxdetail.getProspek_Li_alamatrumah().setVisibility(View.GONE);
            blackboxdetail.getProspek_Li_plafond().setVisibility(View.GONE);
            blackboxdetail.getProspek_Li_ktp().setVisibility(View.GONE);
            blackboxdetail.getProspek_Li_npwp().setVisibility(View.GONE);
            blackboxdetail.getProspek_Li_siup().setVisibility(View.GONE);
        }


        blackboxdetail.getBtnBlackbox().setVisibility(View.VISIBLE);
    }

    public void manageContentPropertyChild(boolean isExist, boolean isEditable, int totalData) {
        followUp.getBtnFirst().setVisibility(View.GONE);
        followUp.getBtnPrev().setVisibility(View.GONE);
        followUp.getBtnNext().setVisibility(View.GONE);
        followUp.getBtnLast().setVisibility(View.GONE);
        if (isExist) {
            if (totalData > 1) {
                followUp.getBtnFirst().setVisibility(View.VISIBLE);
                followUp.getBtnPrev().setVisibility(View.VISIBLE);
                followUp.getBtnNext().setVisibility(View.VISIBLE);
                followUp.getBtnLast().setVisibility(View.VISIBLE);
            }
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

    public Bitmap getPicture(String fileName) {
        System.out.println(fileName);
        File directory = new File(AppConstants.FILEPATH);
        File fileInDirectory = new File(directory, fileName);
        Bitmap imgBitmap = BitmapFactory.decodeFile(fileInDirectory.getAbsolutePath());

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
                        SetPreviewImage(_imgView.get(i), _lblView.get(i), bmp, fileName, "0");

                        break;
                    }
                }

                cameraDialog.dismiss();
            }
        });

        cameraDialog.show();

    }

    public void SetPreviewImage(final ImageView imgView, final TextView lblView, final Bitmap bmp, final String fileName, final String id) {

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previewimg = new PreviewImage(ctx);
                previewimg.getImgPreview().setImageBitmap(bmp);

                previewimg.getDeleteButton().setVisibility(View.GONE);

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

    // Task Get Image From Server
    private class PhotoTask extends AsyncTask<Void, Void, Void> {
        ArrayList<PhotoData> arrListPhoto = null;

        protected void onPreExecute() {
            blackboxdetail.getProgressBar().setText("Loading Photo ...");
            blackboxdetail.getProgressBar().setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.d(TAG, "doInbackground");
            arrListPhoto = photoDataProvider.getPhotoByProspek(prospekData.getID().toString());
            if (arrListPhoto.size() > 0) {
                for (int i = 0; i < arrListPhoto.size(); i++) {
                    if (!arrListPhoto.get(i).isISFILEALREADYAVAILABLE()) {
                        String id = arrListPhoto.get(i).getID().toString();
                        String prospekid = arrListPhoto.get(i).getPROSPEKID().toString();
                        String filename = arrListPhoto.get(i).getFILENAME().toString();

                        try {
                            DownloadImageFromUrl(id, prospekid, filename);
                            arrListPhoto.get(i).setISFILEALREADYAVAILABLE(true);
                            photoDataProvider.updatePhoto(arrListPhoto.get(i));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.d(TAG, "Message Tasks: On post Execute");

            arrListPhoto = photoDataProvider.getPhotoByProspek(prospekData.getID().toString());
            if (arrListPhoto.size() > 0) {
                for (int i = 0; i < arrListPhoto.size(); i++) {
                    try {
                        if (arrListPhoto.get(i).isISFILEALREADYAVAILABLE()) {
                            Bitmap bmp = getPicture(arrListPhoto.get(i).getFILENAME());
                            imgView.get(i).setVisibility(View.VISIBLE);
                            imgView.get(i).setImageBitmap(bmp);
                            lblView.get(i).setText(arrListPhoto.get(i).getFILENAME());
                            SetPreviewImage(imgView.get(i), lblView.get(i), bmp, arrListPhoto.get(i).getFILENAME(), arrListPhoto.get(i).getID().toString());

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            blackboxdetail.getProgressBar().setVisibility(View.GONE);
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
    }
}