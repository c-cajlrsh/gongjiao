package com.example.administrator.myapplication.fragmentlei;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.uilts.Fragment2Adapter;
import com.example.administrator.myapplication.yunle.Jingxuan;
import com.example.administrator.myapplication.yunle.Lishi;

/**
 * Created by Administrator on 2017/1/4.
 */
public class Fragment2 extends Fragment {
    GridView gv_wan;
    Context context;
    public Fragment2(Context context){
        this.context = context;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhu_fragment2,container,false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Fragment2Adapter adapter = new Fragment2Adapter(context);
        gv_wan = (GridView) getActivity().findViewById(R.id.gv_wan);
        gv_wan.setAdapter(adapter);
        gv_wan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        break;
                    case 1: {
                        Intent intent = new Intent(getActivity(), Lishi.class);
                        startActivity(intent);
                    }break;
                    case 2: {
                        Intent intent1 = new Intent(getActivity(), Jingxuan.class);
                        startActivity(intent1);
                    }   break;
                    case 3:
                        break;
                }
            }
        });

    }
}
