package com.example.administrator.myapplication.uilts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;

/**
 * Created by 董豪华 on 2017/1/3.
 */
public class MyAdapter extends BaseAdapter {
    ArrayList<Lishishuju> list;
    Context context;
    MyAdapter(ArrayList<Lishishuju> list,Context context){
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Zhidai zhidai = null;
        if (convertView == null){
            zhidai = new Zhidai();
            convertView = View.inflate(context, R.layout.lishi_item,null);
            zhidai.title = (TextView) convertView.findViewById(R.id.title);
            zhidai.tu_yi = (ImageView) convertView.findViewById(R.id.tu_yi);
            zhidai.date = (TextView) convertView.findViewById(R.id.date);
            zhidai.des = (TextView) convertView.findViewById(R.id.des);
            convertView.setTag(zhidai);
        }else {
            zhidai = (Zhidai) convertView.getTag();
        }
        zhidai.title.setText(list.get(position).getTitle());
        BitmapCache bitmapCache = new BitmapCache();
        bitmapCache.setImageLoader(list.get(position).getPic(),zhidai.tu_yi);
        zhidai.date.setText(list.get(position).getYear()+"年"+list.get(position).getMonth()+"月"+list.get(position).getDay()+"天");
        zhidai.des.setText(list.get(position).getDes());
        return convertView;
    }

    class Zhidai{
        TextView title;
        TextView date;
        TextView des;
        ImageView tu_yi;
    }
}
