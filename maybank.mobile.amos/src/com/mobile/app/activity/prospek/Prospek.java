package com.mobile.app.activity.prospek;

import bii.mobile.mitra.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobile.app.ui.MasterContent;
import com.mobile.framework.common.StringUtility;
import com.mobile.framework.widget.ExSpinner;

public class Prospek extends MasterContent {
    private TextView lblTotalRecords;
    private TextView lblKoordinat;
    private EditText txtNamaUsaha;
    private EditText txtAlamatUsaha;
    private ExSpinner spnJenisUsaha;
    private ExSpinner spnRadius;
    private ExSpinner spnKomunitas;
    private Button btnSave;
    private Button btnAdd;
    private Button btnDelete;
    private Button btnFirst;
    private Button btnPrev;
    private Button btnNext;
    private Button btnLast;
    private Button btnSearch;
    private Button btnSubmit;
    private Button btnBlackbox;
    private ImageView tagLokasi;
    private ProgressBar progressLoader;
    private LinearLayout layoutAction;
    private TextView lbl_koordinat_value;

    public Prospek(Context context) {
        super(context);
    }

    public Prospek(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Prospek(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.prospek_form_layout, getContentBody());
        lblTotalRecords = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_totalrecords_value);
        lblKoordinat = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_koordinat_value);
        txtNamaUsaha = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_nama_value);
        txtAlamatUsaha = (EditText) getContentBody().findViewById(R.id.prospek_view_txt_alamat_value);
        spnJenisUsaha = (ExSpinner) getContentBody().findViewById(R.id.prospek_view_spn_jenis);
        spnRadius = (ExSpinner) getContentBody().findViewById(R.id.prospek_view_spn_radius);
        spnKomunitas = (ExSpinner) getContentBody().findViewById(R.id.prospek_view_spn_komunitas);
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
        tagLokasi = (ImageView) getContentBody().findViewById(R.id.prospek_view_img_taglokasi);
        progressLoader = (ProgressBar) getContentBody().findViewById(R.id.prospek_view_progressbar_taglokasi);
        progressLoader.getIndeterminateDrawable().setColorFilter(0xFFFF0000, android.graphics.PorterDuff.Mode.MULTIPLY);
        layoutAction = (LinearLayout) getContentBody().findViewById(R.id.prospek_view_linearlayout_action);
        lbl_koordinat_value = (TextView) getContentBody().findViewById(R.id.prospek_view_lbl_koordinat_value);
        lbl_koordinat_value.setVisibility(View.VISIBLE);
        btnSave.setVisibility(View.VISIBLE);
        btnAdd.setVisibility(View.VISIBLE);
        btnDelete.setVisibility(View.VISIBLE);
        btnFirst.setVisibility(View.VISIBLE);
        btnPrev.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);
        btnLast.setVisibility(View.VISIBLE);
        lblTotalRecords.setVisibility(View.VISIBLE);
        getContentFooter().setVisibility(View.GONE);
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

    public Button getBtnSearch() {
        return btnSearch;
    }

    public Button getBtnSubmit() {
        return btnSubmit;
    }

    public Button getBtnBlackbox() {
        return btnBlackbox;
    }

    public ImageView getTagLokasi() {
        return tagLokasi;
    }

    public ProgressBar getProgressLoader() {
        return progressLoader;
    }

    public LinearLayout getLayoutAction() {
        return layoutAction;
    }
}
