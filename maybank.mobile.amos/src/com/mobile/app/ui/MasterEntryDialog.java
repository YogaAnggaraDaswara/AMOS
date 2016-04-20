package com.mobile.app.ui;

import maybank.mobile.amos.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class MasterEntryDialog extends Dialog {

    private TextView contentTitle;

    private RelativeLayout contentBody, contentHeader;

    private Object objData;

    public MasterEntryDialog(Context context) {
        super(context, R.style.master_dialog_notitle_borderless);
        setContentView(R.layout.master_dialog_layout);
        contentHeader = (RelativeLayout) findViewById(R.id.master_dialog_content_header);
        contentTitle = (TextView) findViewById(R.id.master_dialog_lbl_title);
        contentBody = (RelativeLayout) findViewById(R.id.master_dialog_content_body);
        onInitMasterEntryDialogContentView(context);
        this.setCanceledOnTouchOutside(false);
    }

    protected abstract void onInitMasterEntryDialogContentView(Context context);

    public abstract View checkContentValidation();

    public TextView getContentTitle() {
        return contentTitle;
    }

    public RelativeLayout getContentHeader() {
        return contentHeader;
    }

    public RelativeLayout getContentBody() {
        return contentBody;
    }

    public void setDataObject(Object data) {
        objData = data;
    }

    public Object getDataObject() {
        return objData;
    }
}
