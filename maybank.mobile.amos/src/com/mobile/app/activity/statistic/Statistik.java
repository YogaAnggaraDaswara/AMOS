package com.mobile.app.activity.statistic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterContent;

public class Statistik extends MasterContent {
    private TableLayout tableLayout;
    private TextView lblTargetTitle;
    private TextView lblProspekValue;
    private TextView lblKenalanValue;
    private TextView lblPendekatanValue;
    private TextView lblClosingValue;

    public Statistik(Context context) {
        super(context);
    }

    public Statistik(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Statistik(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.statistik_content_layout, getContentBody());
        getContentTitle().setVisibility(View.GONE);
        getContentFooter().setVisibility(View.GONE);
        tableLayout = (TableLayout) getContentBody().findViewById(R.id.statistik_tableLayout);
        lblTargetTitle = (TextView) getContentBody().findViewById(R.id.statistik_content_view_target);
        lblProspekValue = (TextView) getContentBody().findViewById(R.id.statistik_content_view_prospek_value);
        lblKenalanValue = (TextView) getContentBody().findViewById(R.id.statistik_content_view_kenalan_value);
        lblPendekatanValue = (TextView) getContentBody().findViewById(R.id.statistik_content_view_pendekatan_value);
        lblClosingValue = (TextView) getContentBody().findViewById(R.id.statistik_content_view_closing_value);
    }

    @Override
    public View checkContentValidation() {
        // TODO Auto-generated method stub
        return null;
    }

    public TableLayout getTableLayout() {
        return tableLayout;
    }

    public TextView getLblTargetTitle() {
        return lblTargetTitle;
    }

    public TextView getLblProspekValue() {
        return lblProspekValue;
    }

    public TextView getLblKenalanValue() {
        return lblKenalanValue;
    }

    public TextView getLblPendekatanValue() {
        return lblPendekatanValue;
    }

    public TextView getLblClosingValue() {
        return lblClosingValue;
    }
}
