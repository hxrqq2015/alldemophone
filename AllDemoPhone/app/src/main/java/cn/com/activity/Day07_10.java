package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.com.alldemophone.R;

/**
 * 服务入门
 * Created by admin on 2015/8/21.
 */
public class Day07_10 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day07_10layout);
    }

    //启动服务
    public void start(View v){
        Intent service =new Intent(this,Day07_10_01.class);
        startService(service);
    }
    //停止服务
    public void stop(View v){
        Intent service =new Intent(this,Day07_10_01.class);
        stopService(service);
    }
}
