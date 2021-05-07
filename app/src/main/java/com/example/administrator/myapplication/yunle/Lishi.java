package com.example.administrator.myapplication.yunle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.uilts.Lishishuju;
import com.example.administrator.myapplication.uilts.MyAdapter;
import com.example.administrator.myapplication.uilts.PeiZhiActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by 董豪华 on 2017/1/3.
 */
public class Lishi extends AppCompatActivity {
    ListView listView;
    String month;
    String day;
    MyAdapter myAdapter;
    ArrayList<Lishishuju> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity);
        shijain();
        shuju();
        myAdapter = new MyAdapter(Lishi.this,list);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myAdapter);
    }


    private void shijain(){
        Calendar calendar=Calendar.getInstance();  //获取当前时间，作为图标的名字
        String year=calendar.get(Calendar.YEAR)+"";
        month=calendar.get(Calendar.MONTH)+1+"";
        day=calendar.get(Calendar.DAY_OF_MONTH)+"";
        String hour=calendar.get(Calendar.HOUR_OF_DAY)+"";
        String minute=calendar.get(Calendar.MINUTE)+"";
        String second=calendar.get(Calendar.SECOND)+"";
    }



    public void  shuju(){
        String path = "http://api.juheapi.com/japi/toh?key=d16ea4a26d94d03a7b39116dc003fff8&v=1.0&month="+month+"&day="+day;
        StringRequest stringRequest = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int error_code = jsonObject.optInt("error_code");
                    String reason = jsonObject.optString("reason");
                    JSONArray result = jsonObject.optJSONArray("result");
                    for (int i = 0 ;i <result.length();i++){
                        Lishishuju li = new Lishishuju();
                        JSONObject jsonObject1 = result.optJSONObject(i);
                        int day = jsonObject1.optInt("day");
                        li.setDay(day);
                        String des = jsonObject1.optString("des");
                        li.setDes(des);
                        int id = jsonObject1.optInt("id");
                        String lunar = jsonObject1.optString("lunar");
                        li.setLunar(lunar);
                        int month = jsonObject1.optInt("month");
                        li.setMonth(month);
                        String pic = jsonObject1.optString("pic");
                        li.setPic(pic);
                        String title = jsonObject1.optString("title");
                        li.setTitle(title);
                        int year = jsonObject1.optInt("year");
                        li.setYear(year);
                        list.add(li);
                    }
                    myAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        PeiZhiActivity.mrequestQueue.add(stringRequest);

    }



}
