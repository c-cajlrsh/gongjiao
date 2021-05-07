package com.example.administrator.myapplication.uilts;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2017/1/4.
 */
public class Fragment2Adapter2 extends BaseAdapter {
    String names[] = {"星座运势","历史的今天","微信精选","驾照题库"};
    int tu [] ={R.drawable.xinzuo,R.drawable.lishi,R.drawable.weixin,R.drawable.jiazaho};
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
