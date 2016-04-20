package com.mobile.app.ui;

import maybank.mobile.amos.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public abstract class MasterNagivationLinear extends LinearLayout {

    private LinearLayout navigationBody = null;

    public MasterNagivationLinear(Context context) {
        super(context);
        initMasterContentView(context);
    }

    public MasterNagivationLinear(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMasterContentView(context);
    }

    private void initMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.master_navigation_master_layout, this, true);
        navigationBody = (LinearLayout) findViewById(R.id.master_navigation_body_layout);
        onInitMasterNavigationView(context);
    }

    public LinearLayout getNavigationBody() {
        return navigationBody;
    }

    protected abstract void onInitMasterNavigationView(Context context);

}
