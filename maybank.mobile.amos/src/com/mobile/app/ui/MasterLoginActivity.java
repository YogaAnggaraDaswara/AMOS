package com.mobile.app.ui;

import com.mobile.framework.common.StringUtility;

import maybank.mobile.amos.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public abstract class MasterLoginActivity extends Activity {

    private EditText edtUserName;
    private EditText edtPassword;
    private TextView lblSN;
    private Button btnLogin;
    private String strProgressMessage;

    private ProgressDialog dlgProgress = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMasterLoginActivity();
    }

    public EditText getEdtUserName() {
        return edtUserName;
    }

    public EditText getEdtPassword() {
        return edtPassword;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }


    public void setStrProgressMessage(String value) {
        strProgressMessage = value;
        if (dlgProgress != null) {
            dlgProgress.setMessage(value);
        }
    }

    public String getStrProgressMessage() {
        return strProgressMessage;
    }

    public ProgressDialog getDlgProgress() {
        return dlgProgress;
    }

    public TextView getLblSN() {
        return lblSN;
    }

    private void initMasterLoginActivity() {
        setContentView(R.layout.master_login_layout);

        edtUserName = (EditText) findViewById(R.id.master_login_edt_user_name_value);
        edtPassword = (EditText) findViewById(R.id.master_login_edt_password_value);
        btnLogin = (Button) findViewById(R.id.master_login_btn_login);
        strProgressMessage = "Harap menunggu sesaat, proses authentikasi sedang dilaksanakan...";
    }


    public View checkContentValidation() {
        if (StringUtility.isEmpty(edtUserName.getText().toString())) {
            return edtUserName;
        }

        if (StringUtility.isEmpty(edtPassword.getText().toString())) {
            return edtPassword;
        }
        return null;
    }

    public void showLoginProgressIndicator() {
        if (dlgProgress == null) {
            dlgProgress = new ProgressDialog(this);
            dlgProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dlgProgress.setTitle(getString(R.string.str_login));
            dlgProgress.setMessage(strProgressMessage);
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
                                    dlgProgress.setMessage("Harap menunggu sesaat, proses authentikasi sedang dibatalkan...");
                                }
                            });
                        }
                    }).start();
                }
            });
            dlgProgress.show();
        }
    }

    public void enableInput() {
        edtUserName.setEnabled(true);
        edtPassword.setEnabled(true);
        btnLogin.setEnabled(true);
    }

    public void disableInput() {
        edtUserName.setEnabled(false);
        edtPassword.setEnabled(false);
        btnLogin.setEnabled(false);
    }

    public void hideLoginProgressIndicator() {
        if (dlgProgress != null) {
            dlgProgress.dismiss();
            dlgProgress = null;
        }
    }

    public void hideEraseProgressIndicator() {
        if (dlgProgress != null) {
            dlgProgress.dismiss();
            dlgProgress = null;
        }
    }

}
