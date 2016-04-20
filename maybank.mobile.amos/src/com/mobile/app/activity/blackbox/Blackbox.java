package com.mobile.app.activity.blackbox;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterContent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class Blackbox extends MasterContent {
    private TableLayout tableLayout;
    private Button btnRequest;

    public Blackbox(Context context) {
        super(context);
    }

    public Blackbox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Blackbox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.blackbox_content_layout, getContentBody());
        getContentTitle().setVisibility(View.GONE);
        getContentFooter().setVisibility(View.GONE);
        tableLayout = (TableLayout) getContentBody().findViewById(R.id.blackbox_tableLayout);
        btnRequest = (Button) getContentBody().findViewById(R.id.blackbox_view_btn_request);
    }

    @Override
    public View checkContentValidation() {
        // TODO Auto-generated method stub
        return null;
    }

    public TableLayout getTableLayout() {
        return tableLayout;
    }

    public Button getBtnRequest() {
        return btnRequest;
    }

}
