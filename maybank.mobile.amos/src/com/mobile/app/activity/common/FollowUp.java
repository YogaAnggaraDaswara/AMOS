package com.mobile.app.activity.common;

import bii.mobile.mitra.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.app.ui.MasterContent;
import com.mobile.framework.common.StringUtility;
import com.mobile.framework.widget.ExSpinner;

@SuppressLint("ResourceAsColor")
public class FollowUp extends MasterContent {
    private TextView lblTotalRecords;
    private TextView lblStage;
    private EditText txtNextFollowUp;
    private EditText txtCatatan;
    private ExSpinner spnAction;
    private ExSpinner spnStatus;
    private Button btnSave;
    private Button btnAdd;
    private Button btnDelete;
    private Button btnFirst;
    private Button btnPrev;
    private Button btnNext;
    private Button btnLast;
    private ImageView datePickerFollowUp;


    public FollowUp(Context context) {
        super(context);
    }

    public FollowUp(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FollowUp(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.followup_layout, getContentBody());
        lblTotalRecords = (TextView) getContentBody().findViewById(R.id.followup_view_lbl_totalrecords_value);
        lblStage = (TextView) getContentBody().findViewById(R.id.followup_view_lbl_stage_value);
        txtNextFollowUp = (EditText) getContentBody().findViewById(R.id.followup_view_txt_nextfollowup_value);
        txtCatatan = (EditText) getContentBody().findViewById(R.id.followup_view_txt_catatan_value);
        spnAction = (ExSpinner) getContentBody().findViewById(R.id.followup_view_spn_actionby);
        spnStatus = (ExSpinner) getContentBody().findViewById(R.id.followup_view_spn_status);
        btnSave = (Button) getContentBody().findViewById(R.id.followup_view_btn_save);
        btnAdd = (Button) getContentBody().findViewById(R.id.followup_view_btn_add);
        btnDelete = (Button) getContentBody().findViewById(R.id.followup_view_btn_delete);
        btnFirst = (Button) getContentBody().findViewById(R.id.followup_view_btn_first);
        btnPrev = (Button) getContentBody().findViewById(R.id.followup_view_btn_prev);
        btnNext = (Button) getContentBody().findViewById(R.id.followup_view_btn_next);
        btnLast = (Button) getContentBody().findViewById(R.id.followup_view_btn_last);
        datePickerFollowUp = (ImageView) getContentBody().findViewById(R.id.followup_view_img_nextfollowup);

        getContentTitle().setBackgroundColor(R.color.color_green_dark);
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
        if (StringUtility.isEmpty(txtNextFollowUp.getText().toString())) {
            return txtNextFollowUp;
        }
        //if (StringUtility.isEmpty(txtCatatan.getText().toString())) {
        //	return txtCatatan;
        //}
        if (StringUtility.isEmpty(spnAction.getSelectedListOfValue().toString())) {
            return spnAction;
        }
        if (StringUtility.isEmpty(spnStatus.getSelectedListOfValue().toString())) {
            return spnStatus;
        }
        return null;
    }

    public TextView getLblTotalRecords() {
        return lblTotalRecords;
    }

    public TextView getLblStage() {
        return lblStage;
    }

    public EditText getTxtNextFollowUp() {
        return txtNextFollowUp;
    }

    public EditText getTxtCatatan() {
        return txtCatatan;
    }

    public ExSpinner getSpnAction() {
        return spnAction;
    }

    public ExSpinner getSpnStatus() {
        return spnStatus;
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

    public ImageView getDatePickerFollowUp() {
        return datePickerFollowUp;
    }
}
