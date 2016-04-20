package com.mobile.app.servicebackground;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkDataHelper {
    private Context _context;
    private static NetworkDataHelper _instance;
    private static final String TAG = "Network Data Helper";

    public NetworkDataHelper() {
        _context = null;
    }

    public static NetworkDataHelper getInstance() {
        if (_instance == null) {
            _instance = new NetworkDataHelper();
        }

        return _instance;
    }

    public void setContext(Context context) {
        this._context = context;
    }


    public Context getContext() {
        return _context;
    }

    public boolean isNetworkConnected() {
        boolean status = false;
        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            status = true;
        }
        return status;
    }

}
