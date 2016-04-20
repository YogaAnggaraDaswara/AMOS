package com.mobile.app.ui;

import maybank.mobile.amos.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class MasterContent extends RelativeLayout {

    private TextView contentTitle = null;
    private RelativeLayout contentBody = null;
    private RelativeLayout contentFooter = null;
    private ProgressBar loadingIndicator = null;

    public MasterContent(Context context) {
        super(context);
        initMasterContentView(context);
    }

    public MasterContent(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMasterContentView(context);
    }

    public MasterContent(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initMasterContentView(context);
    }

    private void initMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.master_content_layout, this, true);

        contentTitle = (TextView) findViewById(R.id.master_content_lbl_content_title);
        contentBody = (RelativeLayout) findViewById(R.id.master_content_body_layout);
        contentFooter = (RelativeLayout) findViewById(R.id.master_content_footer_layout);
        loadingIndicator = (ProgressBar) findViewById(R.id.master_content_prg_loading);

        onInitMasterContentView(context);
    }

    public TextView getContentTitle() {
        return contentTitle;
    }

    public RelativeLayout getContentBody() {
        return contentBody;
    }

    public RelativeLayout getContentFooter() {
        return contentFooter;
    }

    public ProgressBar getLoadingIndicator() {
        return loadingIndicator;
    }

    public void showLoadingIndicator() {
        contentBody.setEnabled(false);
        contentFooter.setEnabled(false);
        loadingIndicator.setVisibility(View.VISIBLE);
    }

    public void hideLoadingIndicator() {
        contentBody.setEnabled(true);
        contentFooter.setEnabled(true);
        loadingIndicator.setVisibility(View.INVISIBLE);
    }

    protected abstract void onInitMasterContentView(Context context);

    public abstract View checkContentValidation();
}
