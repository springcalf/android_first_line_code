package com.example.administrator.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/10/12.
 */
public class MyBroadcastReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context,Intent intent){
        Toast.makeText(context, "received in com.example.administrator.broadcasttest.MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
    }
}
