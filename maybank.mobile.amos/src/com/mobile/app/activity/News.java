package com.mobile.app.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import maybank.mobile.amos.R;

import com.mobile.app.ui.MasterContent;

public class News extends MasterContent {
    private TextView lblTotalRecords;
    private TextView lblSubject;
    private TextView lblContent;
    private Button btnPrev;
    private Button btnNext;
    private Button btnBack;

    public News(Context context) {
        super(context);
    }

    public News(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public News(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.common_msg_content_layout, getContentBody());
        getContentTitle().setVisibility(View.GONE);
        getContentFooter().setVisibility(View.GONE);
        lblTotalRecords = (TextView) getContentBody().findViewById(R.id.common_msg_view_lbl_totalrecords_value);
        lblSubject = (TextView) getContentBody().findViewById(R.id.common_msg_view_lbl_subject);
        lblContent = (TextView) getContentBody().findViewById(R.id.common_msg_view_lbl_content);
        btnPrev = (Button) getContentBody().findViewById(R.id.common_msg_view_btn_prev);
        btnNext = (Button) getContentBody().findViewById(R.id.common_msg_view_btn_next);
        btnBack = (Button) getContentBody().findViewById(R.id.common_msg_view_btn_back);
        btnBack.setVisibility(View.VISIBLE);
    }

    @Override
    public View checkContentValidation() {
        // TODO Auto-generated method stub
        return null;
    }

    public TextView getLblContent() {
        return lblContent;
    }

    public Button getBtnPrev() {
        return btnPrev;
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public TextView getLblSubject() {
        return lblSubject;
    }

    public TextView getLblTotalRecords() {
        return lblTotalRecords;
    }
}
