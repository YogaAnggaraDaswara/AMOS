package com.mobile.app.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import maybank.mobile.amos.R;

import com.mobile.app.ui.MasterEntryDialog;

public class NewsDialog extends MasterEntryDialog {
    RelativeLayout relativelayout;

    public NewsDialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.news_layout, getContentBody());
        getContentTitle().setText(context.getString(R.string.form_news));
        getContentHeader().getLayoutParams().height = 470;
        getContentHeader().invalidate();
        relativelayout = (RelativeLayout) getContentBody().findViewById(R.id.content_layout);
    }

    @Override
    public View checkContentValidation() {
        // TODO Auto-generated method stub
        return null;
    }

    public RelativeLayout getRelativelayout() {
        return relativelayout;
    }
}
