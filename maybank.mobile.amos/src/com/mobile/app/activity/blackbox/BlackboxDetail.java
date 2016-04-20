package com.mobile.app.activity.blackbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterContent;
import com.mobile.framework.widget.TextProgressBar;

public class BlackboxDetail extends MasterContent {
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

    private TextView lblNamaUsahaValue;
    private TextView lblAlamatUsahaValue;
    private TextView lblJenisUsahaValue;
    private TextView lblRadiusValue;
    private TextView lblKomunitasValue;

    private TextView lblNamaDebiturValue;
    private TextView lblTglLahirValue;
    private TextView lblHandphoneValue;
    private TextView lblPembiayaanValue;

    private TextView lblTeleponRumahValue;
    private TextView lblAlamatRumahValue;
    private TextView lblPlafondValue;
    private TextView lblKTPValue;
    private TextView lblNPWPValue;
    private TextView lblSIUPSKUValue;

    private LinearLayout layoutTglLahir;
    private LinearLayout layoutPhoto;
    private LinearLayout layoutHandphone;
    private LinearLayout layoutTeleponRumah;

    private Button btnSave;
    private Button btnAdd;
    private Button btnDelete;
    private Button btnFirst;
    private Button btnPrev;
    private Button btnNext;
    private Button btnLast;
    private Button btnTakePicture;
    private Button btnSearch;
    private Button btnSubmit;
    private Button btnBlackbox;

    private TextView lblImg01;
    private TextView lblImg02;
    private TextView lblImg03;
    private ImageView imgView01;
    private ImageView imgView02;
    private ImageView imgView03;
    private TextProgressBar progressBar;

    /////
    private LinearLayout prospek_Li_namadebitur;

    public LinearLayout getProspek_Li_namadebitur() {
        return prospek_Li_namadebitur;
    }

    public void setProspek_Li_namadebitur(LinearLayout prospek_Li_namadebitur) {
        this.prospek_Li_namadebitur = prospek_Li_namadebitur;
    }

    public LinearLayout getProspek_Li_tgllahir() {
        return prospek_Li_tgllahir;
    }

    public void setProspek_Li_tgllahir(LinearLayout prospek_Li_tgllahir) {
        this.prospek_Li_tgllahir = prospek_Li_tgllahir;
    }

    public LinearLayout getProspek_Li_handphone() {
        return prospek_Li_handphone;
    }

    public void setProspek_Li_handphone(LinearLayout prospek_Li_handphone) {
        this.prospek_Li_handphone = prospek_Li_handphone;
    }

    public LinearLayout getProspek_Li_telponrumah() {
        return prospek_Li_telponrumah;
    }

    public void setProspek_Li_telponrumah(LinearLayout prospek_Li_telponrumah) {
        this.prospek_Li_telponrumah = prospek_Li_telponrumah;
    }

    public LinearLayout getProspek_Li_alamatrumah() {
        return prospek_Li_alamatrumah;
    }

    public void setProspek_Li_alamatrumah(LinearLayout prospek_Li_alamatrumah) {
        this.prospek_Li_alamatrumah = prospek_Li_alamatrumah;
    }

    public LinearLayout getProspek_Li_pembiayaan() {
        return prospek_Li_pembiayaan;
    }

    public void setProspek_Li_pembiayaan(LinearLayout prospek_Li_pembiayaan) {
        this.prospek_Li_pembiayaan = prospek_Li_pembiayaan;
    }

    public LinearLayout getProspek_Li_plafond() {
        return prospek_Li_plafond;
    }

    public void setProspek_Li_plafond(LinearLayout prospek_Li_plafond) {
        this.prospek_Li_plafond = prospek_Li_plafond;
    }

    public LinearLayout getProspek_Li_ktp() {
        return prospek_Li_ktp;
    }

    public void setProspek_Li_ktp(LinearLayout prospek_Li_ktp) {
        this.prospek_Li_ktp = prospek_Li_ktp;
    }

    public LinearLayout getProspek_Li_npwp() {
        return prospek_Li_npwp;
    }

    public void setProspek_Li_npwp(LinearLayout prospek_Li_npwp) {
        this.prospek_Li_npwp = prospek_Li_npwp;
    }

    public LinearLayout getProspek_Li_siup() {
        return prospek_Li_siup;
    }

    public void setProspek_Li_siup(LinearLayout prospek_Li_siup) {
        this.prospek_Li_siup = prospek_Li_siup;
    }

    public LinearLayout getProspek_Li_image() {
        return prospek_Li_image;
    }

    public void setProspek_Li_image(LinearLayout prospek_Li_image) {
        this.prospek_Li_image = prospek_Li_image;
    }

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
    public BlackboxDetail(Context context) {
        super(context);
    }

    public BlackboxDetail(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BlackboxDetail(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.blackbox_form_layout, getContentBody());
        lblTotalRecords = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_totalrecords_value);
        lblKoordinat = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_koordinat_value);

        lblNamaUsahaValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_nama_value);
        lblAlamatUsahaValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_alamat_value);
        lblJenisUsahaValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_spn_jenis);
        lblRadiusValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_spn_radius);
        lblKomunitasValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_spn_komunitas);


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

        lblNamaDebiturValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_namadebitur_value);
        lblTglLahirValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_tgllahir_value);
        lblHandphoneValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_handphone_value);
        lblPembiayaanValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_pembiayaan_value);

        lblTeleponRumahValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_teleponrumah_value);
        lblAlamatRumahValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_alamatrumah_value);
        lblPlafondValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_plafon_value);
        lblKTPValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_ktp_value);
        lblNPWPValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_npwp_value);
        lblSIUPSKUValue = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_siupsku_value);

        layoutTglLahir = (LinearLayout) getContentBody().findViewById(R.id.prospek_view_linearlayout_tgllahir);
        layoutPhoto = (LinearLayout) getContentBody().findViewById(R.id.prospek_view_linearlayout_photo);
        layoutHandphone = (LinearLayout) getContentBody().findViewById(R.id.prospek_view_linearlayout_handphone);
        layoutTeleponRumah = (LinearLayout) getContentBody().findViewById(R.id.prospek_view_linearlayout_teleponrumah);
        btnTakePicture = (Button) getContentBody().findViewById(R.id.prospek_view_btn_takepicture);

        imgView01 = (ImageView) getContentBody().findViewById(R.id.kenalan_view_img_01);
        imgView02 = (ImageView) getContentBody().findViewById(R.id.kenalan_view_img_02);
        imgView03 = (ImageView) getContentBody().findViewById(R.id.kenalan_view_img_03);
        lblImg01 = (TextView) getContentBody().findViewById(R.id.kenalan_view_lbl_01);
        lblImg02 = (TextView) getContentBody().findViewById(R.id.kenalan_view_lbl_02);
        lblImg03 = (TextView) getContentBody().findViewById(R.id.kenalan_view_lbl_03);
        progressBar = (TextProgressBar) getContentBody().findViewById(R.id.prospek_prg_loading_indicator);

        btnSave = (Button) getContentBody().findViewById(R.id.prospek_view_btn_save);
        btnAdd = (Button) getContentBody().findViewById(R.id.prospek_view_btn_add);
        btnDelete = (Button) getContentBody().findViewById(R.id.prospek_view_btn_delete);
        btnFirst = (Button) getContentBody().findViewById(R.id.prospek_view_btn_first);
        btnPrev = (Button) getContentBody().findViewById(R.id.prospek_view_btn_prev);
        btnNext = (Button) getContentBody().findViewById(R.id.prospek_view_btn_next);
        btnLast = (Button) getContentBody().findViewById(R.id.prospek_view_btn_last);
        btnSearch = (Button) getContentBody().findViewById(R.id.prospek_view_btn_search);
        btnSubmit = (Button) getContentBody().findViewById(R.id.prospek_view_btn_submit);
        btnBlackbox = (Button) getContentBody().findViewById(R.id.prospek_view_btn_blackbox);

        lblNamaDebitur.setVisibility(View.VISIBLE);
        lblTglLahir.setVisibility(View.VISIBLE);
        lblHandphone.setVisibility(View.VISIBLE);
        lblPembiayaan.setVisibility(View.VISIBLE);
        lblFotoLokasi.setVisibility(View.VISIBLE);

        lblTeleponRumah.setVisibility(View.VISIBLE);
        lblAlamatRumah.setVisibility(View.VISIBLE);
        lblPlafond.setVisibility(View.VISIBLE);
        lblKTP.setVisibility(View.VISIBLE);
        lblNPWP.setVisibility(View.VISIBLE);
        lblSIUPSKU.setVisibility(View.VISIBLE);
        layoutPhoto.setVisibility(View.VISIBLE);
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

    @Override
    public View checkContentValidation() {
        return null;
    }

    public TextView getLblKoordinat() {
        return lblKoordinat;
    }

    public TextView getLblNamaUsahaValue() {
        return lblNamaUsahaValue;
    }

    public TextView getLblAlamatUsahaValue() {
        return lblAlamatUsahaValue;
    }

    public TextView getLblJenisUsahaValue() {
        return lblJenisUsahaValue;
    }

    public TextView getLblRadiusValue() {
        return lblRadiusValue;
    }

    public TextView getLblKomunitasValue() {
        return lblKomunitasValue;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public Button getBtnAdd() {
        return btnAdd;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public Button getBtnFirst() {
        return btnFirst;
    }

    public Button getBtnPrev() {
        return btnPrev;
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public Button getBtnLast() {
        return btnLast;
    }

    public TextView getLblTotalRecords() {
        return lblTotalRecords;
    }

    public TextView getLblNamaDebitur() {
        return lblNamaDebitur;
    }

    public void setLblNamaDebitur(TextView lblNamaDebitur) {
        this.lblNamaDebitur = lblNamaDebitur;
    }

    public TextView getLblTglLahir() {
        return lblTglLahir;
    }

    public void setLblTglLahir(TextView lblTglLahir) {
        this.lblTglLahir = lblTglLahir;
    }

    public TextView getLblHandphone() {
        return lblHandphone;
    }

    public void setLblHandphone(TextView lblHandphone) {
        this.lblHandphone = lblHandphone;
    }

    public TextView getLblPembiayaan() {
        return lblPembiayaan;
    }

    public void setLblPembiayaan(TextView lblPembiayaan) {
        this.lblPembiayaan = lblPembiayaan;
    }

    public TextView getLblFotoLokasi() {
        return lblFotoLokasi;
    }

    public void setLblFotoLokasi(TextView lblFotoLokasi) {
        this.lblFotoLokasi = lblFotoLokasi;
    }

    public TextView getLblTeleponRumah() {
        return lblTeleponRumah;
    }

    public void setLblTeleponRumah(TextView lblTeleponRumah) {
        this.lblTeleponRumah = lblTeleponRumah;
    }

    public TextView getLblAlamatRumah() {
        return lblAlamatRumah;
    }

    public void setLblAlamatRumah(TextView lblAlamatRumah) {
        this.lblAlamatRumah = lblAlamatRumah;
    }

    public TextView getLblPlafond() {
        return lblPlafond;
    }

    public void setLblPlafond(TextView lblPlafond) {
        this.lblPlafond = lblPlafond;
    }

    public TextView getLblKTP() {
        return lblKTP;
    }

    public void setLblKTP(TextView lblKTP) {
        this.lblKTP = lblKTP;
    }

    public TextView getLblNPWP() {
        return lblNPWP;
    }

    public void setLblNPWP(TextView lblNPWP) {
        this.lblNPWP = lblNPWP;
    }

    public TextView getLblSIUPSKU() {
        return lblSIUPSKU;
    }

    public void setLblSIUPSKU(TextView lblSIUPSKU) {
        this.lblSIUPSKU = lblSIUPSKU;
    }

    public TextView getLblNamaDebiturValue() {
        return lblNamaDebiturValue;
    }

    public TextView getLblTglLahirValue() {
        return lblTglLahirValue;
    }

    public TextView getLblHandphoneValue() {
        return lblHandphoneValue;
    }

    public TextView getLblPembiayaanValue() {
        return lblPembiayaanValue;
    }

    public TextView getLblTeleponRumahValue() {
        return lblTeleponRumahValue;
    }

    public TextView getLblAlamatRumahValue() {
        return lblAlamatRumahValue;
    }

    public TextView getLblPlafondValue() {
        return lblPlafondValue;
    }

    public TextView getLblKTPValue() {
        return lblKTPValue;
    }

    public TextView getLblNPWPValue() {
        return lblNPWPValue;
    }

    public TextView getLblSIUPSKUValue() {
        return lblSIUPSKUValue;
    }

    public LinearLayout getLayoutTglLahir() {
        return layoutTglLahir;
    }

    public void setLayoutTglLahir(LinearLayout layoutTglLahir) {
        this.layoutTglLahir = layoutTglLahir;
    }

    public LinearLayout getLayoutPhoto() {
        return layoutPhoto;
    }

    public void setLayoutPhoto(LinearLayout layoutPhoto) {
        this.layoutPhoto = layoutPhoto;
    }

    public LinearLayout getLayoutHandphone() {
        return layoutHandphone;
    }

    public void setLayoutHandphone(LinearLayout layoutHandphone) {
        this.layoutHandphone = layoutHandphone;
    }

    public LinearLayout getLayoutTeleponRumah() {
        return layoutTeleponRumah;
    }

    public void setLayoutTeleponRumah(LinearLayout layoutTeleponRumah) {
        this.layoutTeleponRumah = layoutTeleponRumah;
    }

    public Button getBtnTakePicture() {
        return btnTakePicture;
    }

    public void setBtnTakePicture(Button btnTakePicture) {
        this.btnTakePicture = btnTakePicture;
    }

    public TextView getLblImg01() {
        return lblImg01;
    }

    public void setLblImg01(TextView lblImg01) {
        this.lblImg01 = lblImg01;
    }

    public TextView getLblImg02() {
        return lblImg02;
    }

    public void setLblImg02(TextView lblImg02) {
        this.lblImg02 = lblImg02;
    }

    public TextView getLblImg03() {
        return lblImg03;
    }

    public void setLblImg03(TextView lblImg03) {
        this.lblImg03 = lblImg03;
    }

    public ImageView getImgView01() {
        return imgView01;
    }

    public void setImgView01(ImageView imgView01) {
        this.imgView01 = imgView01;
    }

    public ImageView getImgView02() {
        return imgView02;
    }

    public void setImgView02(ImageView imgView02) {
        this.imgView02 = imgView02;
    }

    public ImageView getImgView03() {
        return imgView03;
    }

    public void setImgView03(ImageView imgView03) {
        this.imgView03 = imgView03;
    }

    public void setLblTotalRecords(TextView lblTotalRecords) {
        this.lblTotalRecords = lblTotalRecords;
    }

    public void setLblKoordinat(TextView lblKoordinat) {
        this.lblKoordinat = lblKoordinat;
    }

    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public void setBtnFirst(Button btnFirst) {
        this.btnFirst = btnFirst;
    }

    public void setBtnPrev(Button btnPrev) {
        this.btnPrev = btnPrev;
    }

    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }

    public void setBtnLast(Button btnLast) {
        this.btnLast = btnLast;
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

    public TextProgressBar getProgressBar() {
        return progressBar;
    }
}
