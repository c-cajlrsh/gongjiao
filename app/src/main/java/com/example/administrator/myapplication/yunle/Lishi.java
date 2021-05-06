package com.example.administrator.myapplication.yunle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.uilts.Lishishuju;
import com.example.administrator.myapplication.uilts.MyAdapter;
import com.example.administrator.myapplication.uilts.Wangluo;

import java.util.ArrayList;

/**
 * Created by 董豪华 on 2017/1/3.
 */
public class Lishi extends AppCompatActivity {
    ListView listView;
    ArrayList<Lishishuju> list = new ArrayList<>();
    String shuju;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity);
        String str = "http://api.juheapi.com/japi/toh?key=d16ea4a26d94d03a7b39116dc003fff8&v=1.0&month=11&day=1";
        shuju = Wangluo.shuju(str);
        listView = (ListView) findViewById(R.id.listView);
    }
}
