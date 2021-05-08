package com.example.administrator.myapplication.uilts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017/1/4.
 */
public class Fragment2Adapter extends BaseAdapter {
    Context context;
    public Fragment2Adapter(Context context){
        this.context = context;
    }
    String names[] = {"星座运势","历史的今天","微信精选","驾照题库"};
    int tus [] ={R.drawable.xinzuo,R.drawable.lishi,R.drawable.weixin,R.drawable.jiazaho};
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
        View view = View.inflate(context,R.layout.fragnent__wan_list_item,null);
        ImageView tu = (ImageView) view.findViewById(R.id.tu);
        TextView tv_yingyong = (TextView) view.findViewById(R.id.tv_yingyong);
        tu.setBackgroundResource(tus[position]);
        tv_yingyong.setText(names[position]);
        return view;
    }

}
