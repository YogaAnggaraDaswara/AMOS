package com.mobile.app.activity.prospek;

import bii.mobile.mitra.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.framework.common.StringUtility;
import com.mobile.framework.widget.ExSpinner;

public class ProspekDialogAdd extends MasterEntryDialog {

    private TextView lblKoordinat;
    private EditText txtNamaUsaha;
    private EditText txtAlamatUsaha;
    private ExSpinner spnJenisUsaha;
    private ExSpinner spnRadius;
    private ExSpinner spnKomunitas;
    private Button btnSave;
    private Button btnAdd;
    private Button btnDelete;
    private Button btnBack;
    private ImageView tagLokasi;
    private ProgressBar progressLoader;

    public ProspekDialogAdd(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.prospek_form_layout, getContentBody());
        getContentTitle().setText(context.getString(R.string.form_prospek_title_add));
        getContentHeader().getLayoutParams().height = 500;
        getContentHeader().invalidate();
        lblKoordinat = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_koordinat_value);
        txtNamaUsaha = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_nama_value);
        txtAlamatUsaha = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_alamat_value);
        spnJenisUsaha = (ExSpinner) getContentBody().findViewById(R.id.prospek_view_spn_jenis);
        spnRadius = (ExSpinner) getContentBody().findViewById(R.id.prospek_view_spn_radius);
        spnKomunitas = (ExSpinner) getContentBody().findViewById(R.id.prospek_view_spn_komunitas);
        btnSave = (Button) getContentBody().findViewById(R.id.prospek_view_btn_save);
        btnBack = (Button) getContentBody().findViewById(R.id.prospek_view_btn_back);
        tagLokasi = (ImageView) getContentBody().findViewById(R.id.prospek_view_img_taglokasi);
        progressLoader = (ProgressBar) getContentBody().findViewById(R.id.prospek_view_progressbar_taglokasi);
        progressLoader.getIndeterminateDrawable().setColorFilter(0xFFFF0000, android.graphics.PorterDuff.Mode.MULTIPLY);


        txtNamaUsaha.setVisibility(View.VISIBLE);
        txtAlamatUsaha.setVisibility(View.VISIBLE);
        spnJenisUsaha.setVisibility(View.VISIBLE);
        spnRadius.setVisibility(View.VISIBLE);
        spnKomunitas.setVisibility(View.VISIBLE);
        btnSave.setVisibility(View.VISIBLE);
        btnBack.setVisibility(View.VISIBLE);
    }

    @Override
    public View checkContentValidation() {
        if (StringUtility.isEmpty(txtNamaUsaha.getText().toString())) {
            return txtNamaUsaha;
        }
        if (StringUtility.isEmpty(txtAlamatUsaha.getText().toString())) {
            return txtAlamatUsaha;
        }
        if (StringUtility.isEmpty(spnJenisUsaha.getSelectedListOfValue().toString())) {
            return spnJenisUsaha;
        }
        if (StringUtility.isEmpty(spnRadius.getSelectedListOfValue().toString())) {
            return spnRadius;
        }
        if (StringUtility.isEmpty(spnKomunitas.getSelectedListOfValue().toString())) {
            return spnKomunitas;
        }
        return null;
    }

    public TextView getLblKoordinat() {
        return lblKoordinat;
    }

    public EditText getTxtNamaUsaha() {
        return txtNamaUsaha;
    }

    public EditText getTxtAlamatUsaha() {
        return txtAlamatUsaha;
    }

    public ExSpinner getSpnJenisUsaha() {
        return spnJenisUsaha;
    }

    public ExSpinner getSpnRadius() {
        return spnRadius;
    }

    public ExSpinner getSpnKomunitas() {
        return spnKomunitas;
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

    public Button getBtnBack() {
        return btnBack;
    }

    public ImageView getTagLokasi() {
        return tagLokasi;
    }

    public ProgressBar getProgressLoader() {
        return progressLoader;
    }
}
