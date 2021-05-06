package com.example.administrator.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.myapplication.yunle.Lishi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              SharedPreferences sp = MainActivity.this.getSharedPreferences("apkifo", MODE_APPEND);
              String ste  = sp.getString("diyi"," ");
              if (ste.equals("1")){
                  Intent intent = new Intent(MainActivity.this, Lishi.class);
                  startActivity(intent);
                  finish();
              }else {
                  diao();
              }
          }
      },2000);


    }

    public void chun(){
        SharedPreferences apkifo = MainActivity.this.getSharedPreferences("apkifo", MODE_APPEND);
        SharedPreferences.Editor dp = apkifo.edit();
        dp.putString("diyi","1");
        dp.commit();
    }

    public void diao(){

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("本数据来自于聚合数据平台，仅供参考\n你确定使用吗？");
                builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
                builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, Lishi.class);
                        startActivity(intent);
                        chun();
                        finish();
                    }
                });
                builder.show();
    }


}
