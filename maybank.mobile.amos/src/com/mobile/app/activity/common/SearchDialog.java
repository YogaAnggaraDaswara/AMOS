package com.mobile.app.activity.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.framework.common.StringUtility;
import com.mobile.framework.widget.ExSpinner;

public class SearchDialog extends MasterEntryDialog {
    private EditText txtNamaUsaha;
    private EditText txtNamaDebitur;
    private ExSpinner spnJenisUsaha;
    private ExSpinner spnJenisPembiayaan;
    private Button btnSearch;
    private Button btnCancel;


    public SearchDialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.search_layout, getContentBody());
        getContentTitle().setText(context.getString(R.string.form_search_title));

        getContentHeader().getLayoutParams().height = 500;
        getContentHeader().invalidate();

        txtNamaUsaha = (EditText) getContentBody().findViewById(R.id.search_view_txt_namausaha);
        txtNamaDebitur = (EditText) getContentBody().findViewById(R.id.search_view_txt_namadebitur);
        spnJenisUsaha = (ExSpinner) getContentBody().findViewById(R.id.search_view_spn_jenisusaha);
        spnJenisPembiayaan = (ExSpinner) getContentBody().findViewById(R.id.search_view_spn_jenispembiayaan);
        btnSearch = (Button) getContentBody().findViewById(R.id.search_view_btn_search);
        btnCancel = (Button) getContentBody().findViewById(R.id.search_view_btn_cancel);
    }

    @Override
    public View checkContentValidation() {
        // TODO Auto-generated method stub
        return null;
    }

    public int validateSearchContent() {
        int counter = 0;
        if (StringUtility.isEmpty(txtNamaUsaha.getText().toString())) {
            counter++;
        }
        if (StringUtility.isEmpty(txtNamaDebitur.getText().toString())) {
            counter++;
        }
        if (StringUtility.isEmpty(spnJenisUsaha.getSelectedListOfValue().toString())) {
            counter++;
        }
        if (StringUtility.isEmpty(spnJenisPembiayaan.getSelectedListOfValue().toString())) {
            counter++;
        }
        return counter;
    }

    public EditText getTxtNamaUsaha() {
        return txtNamaUsaha;
    }

    public EditText getTxtNamaDebitur() {
        return txtNamaDebitur;
    }

    public ExSpinner getSpnJenisUsaha() {
        return spnJenisUsaha;
    }

    public ExSpinner getSpnJenisPembiayaan() {
        return spnJenisPembiayaan;
    }

    public Button getBtnSearch() {
        return btnSearch;
    }

    public Button getBtnCancel() {
        return btnCancel;
    }

}
