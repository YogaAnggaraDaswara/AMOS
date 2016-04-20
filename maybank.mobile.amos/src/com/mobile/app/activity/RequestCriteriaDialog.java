package com.mobile.app.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import maybank.mobile.amos.R;

import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.common.StringUtility;
import com.mobile.framework.widget.ExSpinner;

public class RequestCriteriaDialog extends MasterEntryDialog {
    private EditText txtFrom;
    private EditText txtTo;
    private ExSpinner spnStage;
    private ExSpinner spnOwner;
    private ImageView datePickerFrom;
    private ImageView datePickerTo;
    private Button btnApproval;
    private Button btnCancel;

    public RequestCriteriaDialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.requestblackbox_layout, getContentBody());
        getContentTitle().setText(context.getString(R.string.form_requestblackbox));
        getContentHeader().getLayoutParams().height = 500;
        getContentHeader().invalidate();
        txtFrom = (EditText) getContentBody().findViewById(R.id.requestblackbox_view_txt_from);
        txtTo = (EditText) getContentBody().findViewById(R.id.requestblackbox_view_txt_to);
        spnStage = (ExSpinner) getContentBody().findViewById(R.id.requestblackbox_view_spn_stage);
        spnOwner = (ExSpinner) getContentBody().findViewById(R.id.requestblackbox_view_spn_owner);
        datePickerFrom = (ImageView) getContentBody().findViewById(R.id.requestblackbox_view_img_from);
        datePickerTo = (ImageView) getContentBody().findViewById(R.id.requestblackbox_view_img_to);
        btnApproval = (Button) getContentBody().findViewById(R.id.requestblackbox_view_btn_approval);
        btnCancel = (Button) getContentBody().findViewById(R.id.requestblackbox_view_btn_cancel);
    }

    @Override
    public View checkContentValidation() {
        if (StringUtility.isEmpty(txtFrom.getText().toString())) {
            return txtFrom;
        }
        if (StringUtility.isEmpty(txtTo.getText().toString())) {
            return txtTo;
        }
        if (StringUtility.isEmpty(spnStage.getSelectedListOfValue().toString())) {
            return spnStage;
        }
        if (StringUtility.isEmpty(spnOwner.getSelectedListOfValue().toString())) {
            return spnStage;
        }
        return null;
    }

    public boolean isRangeDateValid() {

        if (DateFormatter.formatDate(txtFrom.getText().toString()).after(DateFormatter.formatDate(txtTo.getText().toString()))) {
            return false;
        }
        return true;
    }

    public EditText getTxtFrom() {
        return txtFrom;
    }

    public EditText getTxtTo() {
        return txtTo;
    }

    public ExSpinner getSpnStage() {
        return spnStage;
    }

    public ExSpinner getSpnOwner() {
        return spnOwner;
    }

    public ImageView getDatePickerFrom() {
        return datePickerFrom;
    }

    public ImageView getDatePickerTo() {
        return datePickerTo;
    }

    public Button getBtnApproval() {
        return btnApproval;
    }

    public Button getBtnCancel() {
        return btnCancel;
    }

}
