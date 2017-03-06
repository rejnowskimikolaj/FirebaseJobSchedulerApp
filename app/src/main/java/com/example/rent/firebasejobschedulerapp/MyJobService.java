package com.example.rent.firebasejobschedulerapp;

import android.app.job.JobParameters;
import android.util.Log;
import android.widget.Toast;

import com.firebase.jobdispatcher.JobService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by RENT on 2017-03-06.
 */

public class MyJobService extends JobService {


    private static final String TAG = MyJobService.class.getSimpleName();

    @Override
    public boolean onStartJob(com.firebase.jobdispatcher.JobParameters job) {
        Toast.makeText(this,"Job started",Toast.LENGTH_SHORT).show();
        new WaitAsyncTask(this).execute(new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()));
        return true;
    }

    @Override
    public boolean onStopJob(com.firebase.jobdispatcher.JobParameters job) {
        Toast.makeText(this,"Job stopped.",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStopJob ");

        return false;
    }
}
