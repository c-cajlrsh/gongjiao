package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.myapplication.fragmentlei.Fragment1;
import com.example.administrator.myapplication.fragmentlei.Fragment2;

/**
 * Created by 董豪华 on 2017/1/3.
 */
public class ZhuJianMian extends AppCompatActivity {
    com.ashokvarma.bottomnavigation.BottomNavigationBar bb_db;
    Fragment1 fragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhujianmian);
        fragment1 = new Fragment1();
        bb_db = (BottomNavigationBar) findViewById(R.id.bb_db);
        bb_db.setMode(BottomNavigationBar.MODE_FIXED);
        bb_db
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        bb_db.addItem(new BottomNavigationItem(R.drawable.home, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.star, "玩吧"))
                .setFirstSelectedPosition(0)
                .initialise();
        setDefaultFragment();
        bb_db.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position){
                   case 0:
                   {
                       android.app.FragmentManager manager = getFragmentManager();
                       android.app.FragmentTransaction fragmentTransaction = manager.beginTransaction();
                       fragmentTransaction.replace(R.id.ll_layout,fragment1);
                       fragmentTransaction.commit();
                   }
                       break;
                   case 1:
                   {
                       android.app.FragmentManager manager = getFragmentManager();
                       android.app.FragmentTransaction fragmentTransaction = manager.beginTransaction();
                       fragmentTransaction.replace(R.id.ll_layout,new Fragment2());
                       fragmentTransaction.commit();
                   }
                       break;
               }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        android.app.FragmentManager manager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_layout,fragment1);
        fragmentTransaction.commit();
    }


}