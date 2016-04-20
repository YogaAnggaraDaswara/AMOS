package com.mobile.app.activity.map;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterContent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class Location extends MasterContent {
    private TableLayout tableLayout;
    private TextView lblTitle;

    public Location(Context context) {
        super(context);
    }

    public Location(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Location(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.location_content_layout, getContentBody());
        getContentTitle().setVisibility(View.GONE);
        getContentFooter().setVisibility(View.GONE);
        tableLayout = (TableLayout) getContentBody().findViewById(R.id.location_tableLayout);
        lblTitle = (TextView) getContentBody().findViewById(R.id.location_lbl_user_information);
    }

    @Override
    public View checkContentValidation() {
        // TODO Auto-generated method stub
        return null;
    }

    public TableLayout getTableLayout() {
        return tableLayout;
    }

    public TextView getLblTitle() {
        return lblTitle;
    }
}
