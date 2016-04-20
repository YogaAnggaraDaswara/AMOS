package com.mobile.app;

import com.mobile.bo.app.dataprovider.DataProviderManager;

import android.app.Application;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataProviderManager.attachContext(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DataProviderManager.detachContext();
    }

}
