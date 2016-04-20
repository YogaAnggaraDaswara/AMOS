  package com.mobile.app.servicebackground;

import com.mobile.framework.common.DeviceUtility;

import android.content.Context;

public class BackgroundDataHelper {
    private Context _context;
    private static BackgroundDataHelper _instance;
    private String _imei;

    public BackgroundDataHelper() {
        _context = null;
    }

    public static BackgroundDataHelper getInstance() {
        if (_instance == null) {
            _instance = new BackgroundDataHelper();
        }

        return _instance;
    }

    public void set_context(Context context) {
        this._context = context;
    }

    public void setIMEI(Context context) {
        this.set_context(context);
        _imei = DeviceUtility.getIMEI(_context);
    }

    public String getIMEI() {
        return _imei;
    }

}

