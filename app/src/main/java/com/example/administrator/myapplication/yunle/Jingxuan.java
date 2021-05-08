package com.example.administrator.myapplication.yunle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.Webvi;
import com.example.administrator.myapplication.uilts.BitmapCache;
import com.example.administrator.myapplication.uilts.PeiZhiActivity;
import com.example.administrator.myapplication.uilts.Shuju;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 董豪华 on 2017/1/5.
 */
public class Jingxuan  extends AppCompatActivity {
    ArrayList<Shuju> list = new ArrayList<>();
    ListView listView;
    MyBaseAdater adapter;
    Button shagnyi;
    Button xiayiye;
    int ii = 1;
    TextView tv_yeshu;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weixin_acitivty);
        shagnyi = (Button) findViewById(R.id.shagnyi);
        xiayiye = (Button) findViewById(R.id.xiayiye);
        tv_yeshu = (TextView) findViewById(R.id.tv_yeshu);

        shagnyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ii != 1){
                    ii--;
                    jiexi(ii);
                    tv_yeshu.setText("第"+ii+"页");
                }else {
                    Toast.makeText(getApplicationContext(),"已到最后一页",Toast.LENGTH_SHORT).show();
                }

            }
        });
        xiayiye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ii ++;
                jiexi(ii);
                tv_yeshu.setText("第"+ii+"页");
            }
        });
        inn();
        jiexi(1);
    }
    public void tuichu(View view){
        System.exit(0);
    }



    public void jiexi(int i){
        list = new ArrayList<>();
        String path = "http://v.juhe.cn/weixin/query?key=a10d3b5acd9255b1fbfd6459ae84765b&pno="+i;
        StringRequest stringRequest = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String reason = jsonObject.optString("reason");
                    JSONObject result = jsonObject.optJSONObject("result");
                    int error_code = jsonObject.getInt("error_code");
                    JSONArray lis = result.optJSONArray("list");
                    Toast.makeText(Jingxuan.this,reason,Toast.LENGTH_LONG).show();
                    if (error_code == 0 ){
                        for (int i = 0; i < lis.length(); i++) {
                            Shuju shuju = new Shuju();
                            JSONObject jsonObject1 = lis.optJSONObject(i);
                            String id = jsonObject1.optString("id");
                            shuju.setId(id);
                            String te = jsonObject1.optString("title");
                            shuju.setTitle(te);
                            String so = jsonObject1.optString("source");
                            shuju.setSource(so);
                            String fi = jsonObject1.optString("firstImg");
                            shuju.setFirstImg(fi);
                            String ma= jsonObject1.optString("mark");
                            shuju.setMark(ma);
                            String ut = jsonObject1.optString("url");
                            shuju.setUrl(ut);
                            list.add(shuju);
                        }
                        adapter.notifyDataSetChanged();
                    }else {
                        Toast.makeText(Jingxuan.this,"无法解析",Toast.LENGTH_LONG).show();
                    }
                    int totalPage =result.getInt("totalPage");
                    int ps = result.getInt("ps");
                    int pno= result.getInt("pno");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Jingxuan.this,"数据异常",Toast.LENGTH_LONG).show();
            }
        });
        PeiZhiActivity.mrequestQueue.add(stringRequest);

    }

    class MyBaseAdater extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Zhidai zhidai;
            if (convertView == null){
                zhidai = new Zhidai();
                convertView = View.inflate(Jingxuan.this, R.layout.weixin_item,null);
                zhidai.title = (TextView) convertView.findViewById(R.id.title);
                zhidai.source = (TextView) convertView.findViewById(R.id.source);
                zhidai.firstImg = (ImageView) convertView.findViewById(R.id.firstImg);
                convertView.setTag(zhidai);
            }else {
                zhidai = (Zhidai) convertView.getTag();
            }
            zhidai.title.setText(list.get(position).getTitle());
            zhidai.source.setText(list.get(position).getSource());
            BitmapCache bitmapCache = new BitmapCache();
            bitmapCache.setImageLoader(list.get(position).getFirstImg(), zhidai.firstImg);
            return convertView;
        }

        class Zhidai{
            TextView title;
            TextView source;
            ImageView firstImg;
        }
    }

    public void inn(){
        listView = (ListView) findViewById(R.id.listView);
        adapter = new MyBaseAdater();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Jingxuan.this,Webvi.class);
                intent.putExtra("url",list.get(position).getUrl());
                intent.putExtra("biaoti",list.get(position).getTitle());
                startActivity(intent);
            }
        });
    }

}

