package com.example.administrator.myapplication.uilts;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by 董豪华 on 2017/1/3.
 */
public class PeiZhiActivity extends Application {
    static RequestQueue mrequestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        mrequestQueue = Volley.newRequestQueue(getApplicationContext());
    }
}
