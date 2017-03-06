package com.example.rent.firebasejobschedulerapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by RENT on 2017-03-06.
 */

public class WaitAsyncTask extends AsyncTask<String,Void,String> {


    private static final String TAG = WaitAsyncTask.class.getSimpleName() ;
    public static final String MSG = "messageAction";

    private Context ctxt;

    public WaitAsyncTask(Context ctxt) {
        this.ctxt = ctxt;
    }

    @Override
    protected String doInBackground(String... strings) {

        Log.d(TAG, "doInBackground: STARTED: "+strings[0]);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
    }

    @Override
    protected void onPostExecute(String timestamp) {
        broadcastMessage(timestamp);
    }

    private void broadcastMessage(String message){

        Intent messageIntent = new Intent(MSG);
        messageIntent.putExtra("message", message);
        LocalBroadcastManager.getInstance(ctxt).sendBroadcast(messageIntent);
    }

}
