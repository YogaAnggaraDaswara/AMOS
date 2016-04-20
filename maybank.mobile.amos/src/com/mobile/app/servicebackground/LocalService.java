package com.mobile.app.servicebackground;

import java.util.ArrayList;

//import com.mobile.app.activity.common.GPSTracker;
import com.mobile.app.configuration.AppConstants;
import com.mobile.bo.app.dataprovider.ScheduleDataProvider;
import com.mobile.bo.app.datatype.ScheduleData;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
//import android.widget.Toast;

public class LocalService extends Service {

    private static final String TAG = "LeadsDataService";
    //	private ScheduledExecutorService scheduler;
    private Context ctx;
    private Alarm BlackboxPendingAlarm = new Alarm();
    private Alarm SubmitProspekPendingAlarm = new Alarm();
    private Alarm DeleteProspekPendingAlarm = new Alarm();
    private Alarm UpdatedProspekPendingAlarm = new Alarm();
    private Alarm GPSAlarm = new Alarm();
    private Alarm GPSUploadPendingAlarm = new Alarm();
    private Alarm StateHistoryAlarm = new Alarm();
    private Alarm LoginHistoryAlarm = new Alarm();
    private Alarm MessageAlarm = new Alarm();
    private Alarm PendingUploadDeletedPhotoAlarm = new Alarm();
    private Alarm PendingUploadPhotoAlarm = new Alarm();
    private ScheduleDataProvider scheduleDataProvider;
    private ArrayList<ScheduleData> arrSchedules;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        //Toast.makeText(this, "LeadsDataService onStartCommand", Toast.LENGTH_LONG).show();

        if (arrSchedules.size() > 0) {
            for (int i = 0; i < arrSchedules.size(); i++) {
                long interval = 0;
                if (arrSchedules.get(i).getTYPE().equalsIgnoreCase(AppConstants.SCHEDULE_TYPE_SECOND)) {
                    interval = 1000 * Long.parseLong(arrSchedules.get(i).getINTERVAL());
                } else if (arrSchedules.get(i).getTYPE().equalsIgnoreCase(AppConstants.SCHEDULE_TYPE_MINUTE)) {
                    interval = 1000 * 60 * Long.parseLong(arrSchedules.get(i).getINTERVAL());
                } else if (arrSchedules.get(i).getTYPE().equalsIgnoreCase(AppConstants.SCHEDULE_TYPE_HOUR)) {
                    interval = 1000 * 60 * 60 * Long.parseLong(arrSchedules.get(i).getINTERVAL());
                }

                String start = arrSchedules.get(i).getSTART();
                String end = arrSchedules.get(i).getEND();
                String alarmId = arrSchedules.get(i).getID();

            
                if (alarmId.equalsIgnoreCase("" + AppConstants.ALARM_CLEANING)) {
                    GPSAlarm.SetAlarm(ctx, AppConstants.ALARM_CLEANING, interval, start, end);
                }

               
                
            }
        }

        return START_STICKY;
    }


    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");

        //Toast.makeText(this, "LeadsDataService Created", Toast.LENGTH_LONG).show();
        ctx = this;
        //GPSTracker tracker = GPSTracker.getInstance();
        //tracker.getLocation(ctx);
        BackgroundDataHelper backgrounddatahelper = BackgroundDataHelper.getInstance();
        backgrounddatahelper.setIMEI(ctx);
        NetworkDataHelper networkDataHelper = NetworkDataHelper.getInstance();
        networkDataHelper.setContext(ctx);
        scheduleDataProvider = new ScheduleDataProvider();
        arrSchedules = scheduleDataProvider.getAllSchedule();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        //Log.d(TAG, "onStart");
        Toast.makeText(this, "LeadsDataService Started", Toast.LENGTH_LONG).show();
        //loadTask();
    }

    @Override
    public void onDestroy() {
        //Toast.makeText(this, "LeadsDataService Stopped", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "LeadsDataService End", Toast.LENGTH_LONG).show();
    }

	
}
