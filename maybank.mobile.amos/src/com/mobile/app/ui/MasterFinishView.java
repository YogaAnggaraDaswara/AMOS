package com.mobile.app.ui;

import maybank.mobile.amos.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MasterFinishView extends MasterContent {

    private Button nextButton;
    private Button backButton;
    private TextView lblMessage;
    private Button btnSave;
    private Button btnRevert;

    public MasterFinishView(Context context) {
        super(context);
    }

    public MasterFinishView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MasterFinishView(Context context, AttributeSet attrs,
                            int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onInitMasterContentView(Context context) {

        LayoutInflater.from(context).inflate(R.layout.master_finish_view, getContentBody());

        lblMessage = (TextView) getContentBody().findViewById(R.id.master_finish_lbl_message);
        btnRevert = (Button) getContentBody().findViewById(R.id.master_finish_btn_revert);
        btnSave = (Button) getContentBody().findViewById(R.id.master_finish_btn_save);

        LayoutInflater.from(context).inflate(R.layout.master_content_default_footer_layout, getContentFooter());

        nextButton = (Button) getContentFooter().findViewById(R.id.join_visit_default_footer_btn_next);
        backButton = (Button) getContentFooter().findViewById(R.id.join_visit_default_footer_btn_back);
    }

    @Override
    public View checkContentValidation() {
        return null;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public TextView getLblMessage() {
        return lblMessage;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public Button getBtnRevert() {
        return btnRevert;
    }
}
