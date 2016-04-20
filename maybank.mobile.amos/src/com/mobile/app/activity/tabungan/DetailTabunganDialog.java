package com.mobile.app.activity.tabungan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.framework.common.StringUtility;

public class DetailTabunganDialog extends MasterEntryDialog {
    private EditText txtNamaDebitur;
    private Button btnSearch;
    private Button btnCancel;
    private TableLayout tblDetailRekening;

    public DetailTabunganDialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tabungan_search_layout, getContentBody());
        getContentTitle().setText(context.getString(R.string.dialog_tabungan_title));
        getContentHeader().getLayoutParams().height = 500;
        getContentHeader().invalidate();

        //txtNamaDebitur = (EditText) getContentBody().findViewById(R.id.search_view_txt_namadebitur);
        //tblDetailRekening = (TableLayout) getContentBody().findViewById(R.id.search_content_table);
        //btnSearch = (Button) getContentBody().findViewById(R.id.search_view_btn_search);
        //btnCancel = (Button) getContentBody().findViewById(R.id.search_view_btn_cancel);
    }

    @Override
    public View checkContentValidation() {
        if (StringUtility.isEmpty(txtNamaDebitur.getText().toString())) {
            return txtNamaDebitur;
        }
        return null;
    }

    public EditText getTxtNamaDebitur() {
        return txtNamaDebitur;
    }

    public void setTxtNamaDebitur(EditText txtNamaDebitur) {
        this.txtNamaDebitur = txtNamaDebitur;
    }

    public Button getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    public Button getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    public TableLayout getTblDetailRekening() {
        return tblDetailRekening;
    }

    public void setTblDetailRekening(TableLayout tblDetailRekening) {
        this.tblDetailRekening = tblDetailRekening;
    }
}
