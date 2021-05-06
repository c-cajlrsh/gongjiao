package com.example.administrator.myapplication.uilts;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by 董豪华 on 2017/1/3.
 */
public class Wangluo {
    String month;
    String day;
    ArrayList<Lishishuju> lishishujus = new ArrayList<>();

    public static String shuju(String path){
        final String[] str = new String[1];
        StringRequest stringRequest = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                str[0] = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        PeiZhiActivity.mrequestQueue.add(stringRequest);
        return String.valueOf(str);
    }














    private void shijain(){
        Calendar calendar=Calendar.getInstance();  //获取当前时间，作为图标的名字
        String year=calendar.get(Calendar.YEAR)+"";
        month=calendar.get(Calendar.MONTH)+"";
        day=calendar.get(Calendar.DAY_OF_MONTH)+"";
        String hour=calendar.get(Calendar.HOUR_OF_DAY)+"";
        String minute=calendar.get(Calendar.MINUTE)+"";
        String second=calendar.get(Calendar.SECOND)+"";
    }
}
