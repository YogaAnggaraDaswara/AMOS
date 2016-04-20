package com.mobile.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;


public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

        //downloadapk(context);
         
/*         Intent intent1 = new Intent(Intent.ACTION_VIEW);
         Uri uri = Uri.fromFile(new File("/sdcard/filename.apk"));
         intent1.setDataAndType(uri, "application/vnd.android.package-archive");
         context.startActivity(intent1);*/
         
        /* Intent updateIntent = new Intent(Intent.ACTION_VIEW,
                   Uri.parse("http://192.168.0.101/biimobile/bii.mobile.mitra.apk"));
         context.startActivity(updateIntent);*/

        //int interval;
        //interval=6000;
        //AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        //PendingIntent pi = PendingIntent.getService(context, 0, new Intent(context, LoginActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        //am.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + interval, interval, pi);
    }

    private void installApk() {

    }

    private void downloadapk(Context i) {
        try {
            URL url = new URL("http://192.168.0.101/biimobile/bii.mobile.mitra.apk");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            File sdcard = Environment.getExternalStorageDirectory();
            File file = new File(sdcard, "bii.mobile.mitra.apk");

            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();

            byte[] buffer = new byte[1024];
            int bufferLength = 0;

            while ((bufferLength = inputStream.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, bufferLength);
            }
            fileOutput.close();
            // this.checkUnknownSourceEnability();
            // this.initiateInstallation();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(new File("/sdcard/filename.apk"));
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            i.startActivity(intent);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
