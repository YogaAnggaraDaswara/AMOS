package com.mobile.app.activity.pendekatan;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterContent;
import com.mobile.framework.common.StringUtility;
import com.mobile.framework.widget.ExSpinner;

public class Pendekatan extends MasterContent {
    private TextView lblTotalRecords;
    private TextView lblKoordinat;

    private TextView lblNamaDebitur;
    private TextView lblTglLahir;
    private TextView lblHandphone;
    private TextView lblPembiayaan;
    private TextView lblFotoLokasi;
    private TextView lblTeleponRumah;
    private TextView lblAlamatRumah;
    private TextView lblPlafond;
    private TextView lblKTP;
    private TextView lblNPWP;
    private TextView lblSIUPSKU;

    private TextView lblNamaUsaha;
    private TextView lblAlamatUsaha;
    private TextView lblJenisUsaha;
    private TextView lblRadius;
    private TextView lblKomunitas;

    private EditText txtNamaDebitur;
    private EditText txtTglLahir;
    private EditText txtHandphone;
    private ExSpinner spnPembiayaan;

    private EditText txtTeleponRumah;
    private EditText txtAlamatRumah;
    private EditText txtPlafond;
    private EditText txtKTP;
    private EditText txtNPWP;
    private EditText txtSIUPSKU;

    private LinearLayout layoutTglLahir;
    private LinearLayout layoutPhoto;
    private LinearLayout layoutHandphone;
    private LinearLayout layoutTeleponRumah;

    private Button btnSave;
    private Button btnDelete;
    private Button btnFirst;
    private Button btnPrev;
    private Button btnNext;
    private Button btnLast;
    private Button btnTakePicture;
    private Button btnSearch;
    private Button btnBlackbox;

    private Button btnSubmit;
    private TextView lblImg01;
    private TextView lblImg02;
    private TextView lblImg03;
    private ImageView imgView01;
    private ImageView imgView02;
    private ImageView imgView03;
    private ImageView datePickerTlgLahir;
    private ImageView imgHandphoneCall;
    private ImageView imgHandphoneMessage;
    private ImageView imgTeleponRumahCall;
    /////
    private LinearLayout prospek_Li_namadebitur;
    private LinearLayout prospek_Li_tgllahir;
    private LinearLayout prospek_Li_handphone;
    private LinearLayout prospek_Li_telponrumah;
    private LinearLayout prospek_Li_alamatrumah;
    private LinearLayout prospek_Li_pembiayaan;
    private LinearLayout prospek_Li_plafond;
    private LinearLayout prospek_Li_ktp;
    private LinearLayout prospek_Li_npwp;
    private LinearLayout prospek_Li_siup;
    private LinearLayout prospek_Li_image;
    private TextView lbl_koordinat_value;

    /////
    public Pendekatan(Context context) {
        super(context);
    }

    public Pendekatan(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Pendekatan(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.prospek_form_layout, getContentBody());
        lblTotalRecords = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_totalrecords_value);
        lblKoordinat = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_koordinat_value);

        lblNamaDebitur = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_namadebitur);
        lblTglLahir = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_tglahir);
        lblHandphone = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_handphone);
        lblPembiayaan = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_pembiayaan);
        lblFotoLokasi = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_picture);

        lblTeleponRumah = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_teleponrumah);
        lblAlamatRumah = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_alamatrumah);
        lblPlafond = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_plafon);
        lblKTP = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_ktp);
        lblNPWP = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_npwp);
        lblSIUPSKU = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_siupsku);


        lblNamaUsaha = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_nama_value);
        lblAlamatUsaha = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_alamat_value);
        lblJenisUsaha = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_spn_jenis);
        lblRadius = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_spn_radius);
        lblKomunitas = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_spn_komunitas);


        txtNamaDebitur = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_namadebitur_value);
        txtTglLahir = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_tgllahir_value);
        txtHandphone = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_handphone_value);
        spnPembiayaan = (ExSpinner) getContentBody().findViewById(R.id.prospek_view_spn_pembiayaan);
        datePickerTlgLahir = (ImageView) getContentBody().findViewById(R.id.prospek_view_img_tgllahir);
        imgHandphoneCall = (ImageView) getContentBody().findViewById(R.id.prospek_view_img_handphone_call);
        imgHandphoneMessage = (ImageView) getContentBody().findViewById(R.id.prospek_view_img_handphone_message);


        txtTeleponRumah = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_teleponrumah_value);
        txtAlamatRumah = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_alamatrumah_value);
        txtPlafond = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_plafon_value);
        setTextWatcher(txtPlafond);
        txtKTP = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_ktp_value);
        txtNPWP = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_npwp_value);
        txtSIUPSKU = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_siupsku_value);
        imgTeleponRumahCall = (ImageView) getContentBody().findViewById(R.id.prospek_view_img_teleponrumah_call);

        layoutTglLahir = (LinearLayout) getContentBody().findViewById(R.id.prospek_view_linearlayout_tgllahir);
        layoutPhoto = (LinearLayout) getContentBody().findViewById(R.id.prospek_view_linearlayout_photo);
        layoutHandphone = (LinearLayout) getContentBody().findViewById(R.id.prospek_view_linearlayout_handphone);
        layoutTeleponRumah = (LinearLayout) getContentBody().findViewById(R.id.prospek_view_linearlayout_teleponrumah);

        btnSave = (Button) getContentBody().findViewById(R.id.prospek_view_btn_save);
        btnDelete = (Button) getContentBody().findViewById(R.id.prospek_view_btn_delete);
        btnFirst = (Button) getContentBody().findViewById(R.id.prospek_view_btn_first);
        btnPrev = (Button) getContentBody().findViewById(R.id.prospek_view_btn_prev);
        btnNext = (Button) getContentBody().findViewById(R.id.prospek_view_btn_next);
        btnLast = (Button) getContentBody().findViewById(R.id.prospek_view_btn_last);
        btnTakePicture = (Button) getContentBody().findViewById(R.id.prospek_view_btn_takepicture);
        btnSearch = (Button) getContentBody().findViewById(R.id.prospek_view_btn_search);
        btnSubmit = (Button) getContentBody().findViewById(R.id.prospek_view_btn_submit);
        btnBlackbox = (Button) getContentBody().findViewById(R.id.prospek_view_btn_blackbox);

        imgView01 = (ImageView) getContentBody().findViewById(R.id.kenalan_view_img_01);
        imgView02 = (ImageView) getContentBody().findViewById(R.id.kenalan_view_img_02);
        imgView03 = (ImageView) getContentBody().findViewById(R.id.kenalan_view_img_03);
        lblImg01 = (TextView) getContentBody().findViewById(R.id.kenalan_view_lbl_01);
        lblImg02 = (TextView) getContentBody().findViewById(R.id.kenalan_view_lbl_02);
        lblImg03 = (TextView) getContentBody().findViewById(R.id.kenalan_view_lbl_03);
        lbl_koordinat_value = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_koordinat_value);
        lbl_koordinat_value.setVisibility(View.VISIBLE);
        lblNamaDebitur.setVisibility(View.VISIBLE);
        lblTglLahir.setVisibility(View.VISIBLE);
        lblHandphone.setVisibility(View.VISIBLE);
        lblPembiayaan.setVisibility(View.VISIBLE);
        lblFotoLokasi.setVisibility(View.VISIBLE);
        lblNamaUsaha.setVisibility(View.VISIBLE);
        lblAlamatUsaha.setVisibility(View.VISIBLE);
        lblJenisUsaha.setVisibility(View.VISIBLE);
        lblRadius.setVisibility(View.VISIBLE);
        lblKomunitas.setVisibility(View.VISIBLE);


        lblTeleponRumah.setVisibility(View.VISIBLE);
        lblAlamatRumah.setVisibility(View.VISIBLE);
        lblPlafond.setVisibility(View.VISIBLE);
        lblKTP.setVisibility(View.VISIBLE);
        lblNPWP.setVisibility(View.VISIBLE);
        lblSIUPSKU.setVisibility(View.VISIBLE);


        txtNamaDebitur.setVisibility(View.VISIBLE);
        txtTglLahir.setVisibility(View.VISIBLE);
        txtHandphone.setVisibility(View.VISIBLE);
        spnPembiayaan.setVisibility(View.VISIBLE);
        layoutTglLahir.setVisibility(View.VISIBLE);
        layoutPhoto.setVisibility(View.VISIBLE);
        layoutHandphone.setVisibility(View.VISIBLE);
        datePickerTlgLahir.setVisibility(View.VISIBLE);
        imgHandphoneCall.setVisibility(View.VISIBLE);
        imgHandphoneMessage.setVisibility(View.VISIBLE);


        txtTeleponRumah.setVisibility(View.VISIBLE);
        txtAlamatRumah.setVisibility(View.VISIBLE);
        txtPlafond.setVisibility(View.VISIBLE);
        txtKTP.setVisibility(View.VISIBLE);
        txtNPWP.setVisibility(View.VISIBLE);
        txtSIUPSKU.setVisibility(View.VISIBLE);
        imgTeleponRumahCall.setVisibility(View.VISIBLE);
        layoutTeleponRumah.setVisibility(View.VISIBLE);

        btnSave.setVisibility(View.VISIBLE);
        btnDelete.setVisibility(View.VISIBLE);
        btnFirst.setVisibility(View.VISIBLE);
        btnPrev.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);
        btnLast.setVisibility(View.VISIBLE);
        btnTakePicture.setVisibility(View.VISIBLE);
        lblTotalRecords.setVisibility(View.VISIBLE);
        getContentFooter().setVisibility(View.GONE);

        /////

        prospek_Li_namadebitur = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_namadebitur);
        prospek_Li_tgllahir = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_tgllahir);
        prospek_Li_handphone = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_handphone);
        prospek_Li_pembiayaan = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_pembiayaan);
        prospek_Li_image = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_image);

        prospek_Li_telponrumah = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_telponrumah);
        prospek_Li_alamatrumah = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_alamatrumah);

        prospek_Li_plafond = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_plafond);
        prospek_Li_ktp = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_ktp);
        prospek_Li_npwp = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_npwp);
        prospek_Li_siup = (LinearLayout) getContentBody().findViewById(R.id.prospek_Li_siup);


        prospek_Li_namadebitur.setVisibility(View.VISIBLE);
        prospek_Li_tgllahir.setVisibility(View.VISIBLE);
        prospek_Li_handphone.setVisibility(View.VISIBLE);
        prospek_Li_pembiayaan.setVisibility(View.VISIBLE);
        prospek_Li_image.setVisibility(View.VISIBLE);

        prospek_Li_telponrumah.setVisibility(View.VISIBLE);
        prospek_Li_alamatrumah.setVisibility(View.VISIBLE);

        prospek_Li_plafond.setVisibility(View.VISIBLE);
        prospek_Li_ktp.setVisibility(View.VISIBLE);
        prospek_Li_npwp.setVisibility(View.VISIBLE);
        prospek_Li_siup.setVisibility(View.VISIBLE);


        /////
    }

    public void setTextWatcher(final EditText ed) {
        TextWatcher tw = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                ed.removeTextChangedListener(this);
                try {
                    String numberformat = "";
                    String userInput = s.toString().replace("R", "").replace("p", "").replace(" ", "").replace(".", "");

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

                    numberformat = "Rp " + numberformat;

                    ed.setText(numberformat);
                    Selection.setSelection(ed.getText(), numberformat.toString().length());
                } catch (Exception e) {
                    Log.d("RESPON", e.toString());
                }

                ed.addTextChangedListener(this);
            }
        };

        ed.addTextChangedListener(tw);
    }

    public static String getFormatedCurrency(String value) {
        try {
            NumberFormat formatter = new DecimalFormat("##,##,##,###");
            return formatter.format(Double.parseDouble(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public View checkContentValidation() {
        if (StringUtility.isEmpty(txtNamaDebitur.getText().toString())) {
            return txtNamaDebitur;
        }
        //if (StringUtility.isEmpty(txtTglLahir.getText().toString())) {
        //	return txtTglLahir;
        //}
        if (StringUtility.isEmpty(txtHandphone.getText().toString())) {
            return txtHandphone;
        }
        //if (StringUtility.isEmpty(spnPembiayaan.getSelectedListOfValue().toString())) {
        //	return spnPembiayaan;
        //}
        //if (StringUtility.isEmpty(txtTeleponRumah.getText().toString())) {
        //	return txtTeleponRumah;
        //}
        //if (StringUtility.isEmpty(txtAlamatRumah.getText().toString())) {
        //	return txtAlamatRumah;
        //}
        //if (StringUtility.isEmpty(txtPlafond.getText().toString())) {
        //	return txtPlafond;
        //}
        //if (StringUtility.isEmpty(txtKTP.getText().toString())) {
        //	return txtKTP;
        //}
        //if (StringUtility.isEmpty(txtNPWP.getText().toString())) {
        //	return txtNPWP;
        //}
        //if (StringUtility.isEmpty(txtSIUPSKU.getText().toString())) {
        //	return txtSIUPSKU;
        //}
        return null;
    }

    public TextView getLblTotalRecords() {
        return lblTotalRecords;
    }

    public void setLblTotalRecords(TextView lblTotalRecords) {
        this.lblTotalRecords = lblTotalRecords;
    }

    public TextView getLblKoordinat() {
        return lblKoordinat;
    }

    public void setLblKoordinat(TextView lblKoordinat) {
        this.lblKoordinat = lblKoordinat;
    }

    public TextView getLblNamaDebitur() {
        return lblNamaDebitur;
    }

    public TextView getLblTglLahir() {
        return lblTglLahir;
    }

    public TextView getLblHandphone() {
        return lblHandphone;
    }

    public TextView getLblPembiayaan() {
        return lblPembiayaan;
    }

    public TextView getLblFotoLokasi() {
        return lblFotoLokasi;
    }

    public TextView getLblNamaUsaha() {
        return lblNamaUsaha;
    }

    public TextView getLblAlamatUsaha() {
        return lblAlamatUsaha;
    }

    public TextView getLblJenisUsaha() {
        return lblJenisUsaha;
    }

    public TextView getLblRadius() {
        return lblRadius;
    }

    public TextView getLblKomunitas() {
        return lblKomunitas;
    }

    public EditText getTxtNamaDebitur() {
        return txtNamaDebitur;
    }

    public EditText getTxtTglLahir() {
        return txtTglLahir;
    }

    public EditText getTxtHandphone() {
        return txtHandphone;
    }

    public void setTxtHandphone(EditText txtHandphone) {
        this.txtHandphone = txtHandphone;
    }

    public ExSpinner getSpnPembiayaan() {
        return spnPembiayaan;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public ImageView getDatePickerTlgLahir() {
        return datePickerTlgLahir;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public Button getBtnFirst() {
        return btnFirst;
    }

    public void setBtnFirst(Button btnFirst) {
        this.btnFirst = btnFirst;
    }

    public Button getBtnPrev() {
        return btnPrev;
    }

    public void setBtnPrev(Button btnPrev) {
        this.btnPrev = btnPrev;
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }

    public Button getBtnLast() {
        return btnLast;
    }

    public void setBtnLast(Button btnLast) {
        this.btnLast = btnLast;
    }

    public Button getBtnTakePicture() {
        return btnTakePicture;
    }

    public void setBtnTakePicture(Button btnTakePicture) {
        this.btnTakePicture = btnTakePicture;
    }

    public ImageView getImgView01() {
        return imgView01;
    }

    public ImageView getImgView02() {
        return imgView02;
    }

    public ImageView getImgView03() {
        return imgView03;
    }

    public TextView getLblImg01() {
        return lblImg01;
    }

    public TextView getLblImg02() {
        return lblImg02;
    }

    public TextView getLblImg03() {
        return lblImg03;
    }

    public ImageView getImgHandphoneCall() {
        return imgHandphoneCall;
    }

    public void setImgHandphoneCall(ImageView imgHandphoneCall) {
        this.imgHandphoneCall = imgHandphoneCall;
    }

    public ImageView getImgHandphoneMessage() {
        return imgHandphoneMessage;
    }

    public void setImgHandphoneMessage(ImageView imgHandphoneMessage) {
        this.imgHandphoneMessage = imgHandphoneMessage;
    }

    public TextView getLblTeleponRumah() {
        return lblTeleponRumah;
    }

    public TextView getLblAlamatRumah() {
        return lblAlamatRumah;
    }

    public TextView getLblPlafond() {
        return lblPlafond;
    }

    public TextView getLblKTP() {
        return lblKTP;
    }

    public TextView getLblNPWP() {
        return lblNPWP;
    }

    public TextView getLblSIUPSKU() {
        return lblSIUPSKU;
    }

    public EditText getTxtTeleponRumah() {
        return txtTeleponRumah;
    }

    public EditText getTxtAlamatRumah() {
        return txtAlamatRumah;
    }

    public EditText getTxtPlafond() {
        return txtPlafond;
    }

    public EditText getTxtKTP() {
        return txtKTP;
    }

    public EditText getTxtNPWP() {
        return txtNPWP;
    }

    public EditText getTxtSIUPSKU() {
        return txtSIUPSKU;
    }

    public LinearLayout getLayoutTglLahir() {
        return layoutTglLahir;
    }

    public LinearLayout getLayoutPhoto() {
        return layoutPhoto;
    }

    public LinearLayout getLayoutHandphone() {
        return layoutHandphone;
    }

    public LinearLayout getLayoutTeleponRumah() {
        return layoutTeleponRumah;
    }

    public ImageView getImgTeleponRumahCall() {
        return imgTeleponRumahCall;
    }

    public Button getBtnSearch() {
        return btnSearch;
    }

    public Button getBtnSubmit() {
        return btnSubmit;
    }

    public Button getBtnBlackbox() {
        return btnBlackbox;
    }
}
