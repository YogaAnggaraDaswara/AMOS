package com.mobile.app.activity.tagihan;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterContent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;

public class Tagihan extends MasterContent {
    private TableLayout tableLayout;
    private LinearLayout buttonLayout;

    public Tagihan(Context context) {
        super(context);
    }

    public Tagihan(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Tagihan(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tagihan_content_layout, getContentBody());
        getContentTitle().setVisibility(View.GONE);
        getContentFooter().setVisibility(View.GONE);
        tableLayout = (TableLayout) getContentBody().findViewById(R.id.tagihan_tableLayout);
        buttonLayout = (LinearLayout) getContentBody().findViewById(R.id.buttonLayout);

    }

    @Override
    public View checkContentValidation() {
        // TODO Auto-generated method stub
        return null;
    }

    public TableLayout getTableLayout() {
        return tableLayout;
    }

    public LinearLayout getbuttonlayout() {
        return buttonLayout;
    }
}
