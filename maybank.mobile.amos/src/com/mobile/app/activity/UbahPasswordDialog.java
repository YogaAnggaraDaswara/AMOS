package com.mobile.app.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import maybank.mobile.amos.R;

import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.framework.common.StringUtility;

public class UbahPasswordDialog extends MasterEntryDialog {

    private EditText txtPasswordLama;
    private EditText txtPasswordBaru;
    private EditText txtKonfirmasiPasswordBaru;
    private Button btnSave;
    private Button btnCancel;

    public UbahPasswordDialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.ubahpassword_layout, getContentBody());
        getContentTitle().setText(context.getString(R.string.form_ubahpassword_title));
        getContentHeader().getLayoutParams().height = 500;
        getContentHeader().invalidate();
        txtPasswordLama = (EditText) getContentBody().findViewById(R.id.ubahpassword_view_txt_passwordlama);
        txtPasswordBaru = (EditText) getContentBody().findViewById(R.id.ubahpassword_view_txt_passwordbaru);
        txtKonfirmasiPasswordBaru = (EditText) getContentBody().findViewById(R.id.ubahpassword_view_txt_confirmpasswordbaru);
        btnSave = (Button) getContentBody().findViewById(R.id.ubahpassword_view_btn_save);
        btnCancel = (Button) getContentBody().findViewById(R.id.ubahpassword_view_btn_cancel);

    }

    @Override
    public View checkContentValidation() {
        if (StringUtility.isEmpty(txtPasswordLama.getText().toString())) {
            return txtPasswordLama;
        }

        if (StringUtility.isEmpty(txtPasswordBaru.getText().toString())) {
            return txtPasswordBaru;
        }

        if (StringUtility.isEmpty(txtKonfirmasiPasswordBaru.getText().toString())) {
            return txtKonfirmasiPasswordBaru;
        }
        return null;
    }

    public boolean isNewPasswordEqual() {
        if (txtPasswordBaru.getText().toString().equals(txtKonfirmasiPasswordBaru.getText().toString())) {
            return true;
        }
        return false;
    }

    public EditText getTxtPasswordLama() {
        return txtPasswordLama;
    }

    public EditText getTxtPasswordBaru() {
        return txtPasswordBaru;
    }

    public EditText getTxtKonfirmasiPasswordBaru() {
        return txtKonfirmasiPasswordBaru;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public Button getBtnCancel() {
        return btnCancel;
    }
}
