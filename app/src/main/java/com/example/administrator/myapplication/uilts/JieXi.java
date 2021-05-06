package com.example.administrator.myapplication.uilts;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 董豪华 on 2017/1/3.
 */
public class JieXi {
    ArrayList<Lishishuju> lishishujulist = new ArrayList<>();
    public ArrayList<Lishishuju> lishi(String shuju){
        try {
            JSONObject jsonObject = new JSONObject(shuju);
            int error_code = jsonObject.optInt("error_code");
            String reason = jsonObject.optString("reason");
            JSONArray result = jsonObject.optJSONArray("result");
            for (int i = 0 ;i <result.length();i++){
                Lishishuju lishishuju = new Lishishuju();
                JSONObject jsonObject1 = result.optJSONObject(i);
                int day = jsonObject1.optInt("day");
                lishishuju.setDay(day);
                String des = jsonObject1.optString("des");
                lishishuju.setDes(des);
                int id = jsonObject1.optInt("id");
                String lunar = jsonObject1.optString("lunar");
                lishishuju.setLunar(lunar);
                int month = jsonObject1.optInt("month");
                lishishuju.setMonth(month);
                String pic = jsonObject1.optString("pic");
                lishishuju.setPic(pic);
                String title = jsonObject1.optString("title");
                lishishuju.setTitle(title);
                int year = jsonObject1.optInt("year");
                lishishuju.setYear(year);
                lishishujulist.add(lishishuju);
            }
            return lishishujulist;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

}
