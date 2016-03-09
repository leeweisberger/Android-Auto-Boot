package com.example.leeweisberger.boot;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

;

/**
 * Created by leeweisberger on 3/9/16.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent myIntent = new Intent();
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myIntent.setComponent(new ComponentName("com.k4connect.k4app", "com.k4connect.k4app.K4MainActivity"));
        context.startActivity(myIntent);
    }
}
