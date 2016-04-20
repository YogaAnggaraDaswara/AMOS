package com.mobile.app.activity.common;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat.Field;
import java.util.Date;

import bii.mobile.mitra.R;

import com.mobile.app.UpgradeActivity;
import com.mobile.app.configuration.AppConstants;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
//import android.widget.//Toast;
import android.widget.Toast;

public class GPSTracker extends Service implements android.location.LocationListener {
    /**
     * ATTRIBUTES
     */
//    private static final String TAG                             = GPSTracker.class.getSimpleName();
    private Context _context;
    private static GPSTracker _instance;
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0;                                // meters
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 0;                    // minute
    // Declaring a Location Manager
    protected LocationManager _locationManager;
    /**
     * PUBLIC ATTRIBUTES
     */
    boolean _isGPSEnabled = false;
    boolean _isNetworkEnabled = false;
    boolean _canGetLocation = false;
    public Location _location;
    double _latitude;
    double _longitude;

    public GPSTracker() {

        _context = null;
    }

    public static GPSTracker getInstance() {

        if (_instance == null) {
            _instance = new GPSTracker();
        }
        return _instance;
    }

    public void set_context(Context context) {

        this._context = context;
    }

    public Location getLocation(Context context) {

        _context = context;
        _location = null;
        _latitude = 0;
        _longitude = 0;
        try {
            _locationManager = (LocationManager) _context.getSystemService(LOCATION_SERVICE);
            _isGPSEnabled = _locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            _isNetworkEnabled = _locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!_isGPSEnabled) {
                //notificationGPS(context);
            } else {
                this._canGetLocation = true;
                if (_isGPSEnabled) {
                    //Enable GPS
                    Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
                    intent.putExtra("enabled", true);
                    context.sendBroadcast(intent);
                }
                //Toast.makeText(_context, "------- Service Keep Running -------", //Toast.LENGTH_LONG).show();
                // if GPS Enabled get lat/long using GPS Services
                if (_isGPSEnabled) {
                    if (_location == null) {
                        ////Toast.makeText(_context, "------- gps enabled -------", //Toast.LENGTH_LONG).show();
                        _locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (_locationManager != null) {
                            _location = _locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (_location != null) {
                                _latitude = _location.getLatitude();
                                _longitude = _location.getLongitude();
                                //Toast.makeText(_context, "------- AGPS last known -------"+_latitude+"-"+_longitude, //Toast.LENGTH_LONG).show();
                            }
                        } else {
                            //Toast.makeText(_context, "------- location null -------"+_latitude+"-"+_longitude, //Toast.LENGTH_LONG).show();
                        }
                    }
                }
                if (_isNetworkEnabled) {
                    _locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    if (_locationManager != null) {
                        _location = _locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (_location != null) {
                            _latitude = _location.getLatitude();
                            _longitude = _location.getLongitude();
                            //Toast.makeText(_context, "------- Network last known -------"+_latitude+"-"+_longitude, //Toast.LENGTH_LONG).show();
                        }

                    }

                }

            }
        } catch (Exception e) {
            //Toast.makeText(_context, "Error:"+e.getMessage(), //Toast.LENGTH_LONG).show();
        }


        return _location;
    }

    public void stopUsingGPS() {

        if (_locationManager != null) {
            _locationManager.removeUpdates(GPSTracker.this);
        }
    }

    public double getLatitude() {

        if (_location != null) {
            _latitude = _location.getLatitude();
        }
        return _latitude;
    }

    public double getLongitude() {

        if (_location != null) {
            _longitude = _location.getLongitude();
        }
        return _longitude;
    }

    public boolean canGetLocation() {

        return this._canGetLocation;
    }

    /**
     * Function to show settings alert dialog On pressing Settings button will lauch Settings Options
     */
    public void showSettingsAlert(String title, String msg) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(_context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(msg);
        // Settings button
        alertDialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                _context.startActivity(intent);
            }
        });
        // cancel button
        alertDialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        // show
        alertDialog.show();
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            double lon = (double) (location.getLongitude());
            double lat = (double) (location.getLatitude());
            _latitude = lat;
            _longitude = lon;
            //Toast.makeText(_context, "Found Location: Lat:"+_latitude+" Long:"+_longitude, //Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public IBinder onBind(Intent arg0) {

        return null;
    }
}