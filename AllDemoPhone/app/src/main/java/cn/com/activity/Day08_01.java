package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/22.
 */
public class Day08_01 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_01layout);
    }

    //启动服务
    public void start(View v){
        Intent service = new Intent(this,Day08_01_01.class);
        //启动服务了，但是没法拿到服务的对象，拿到的是组件的名字
        startService(service);
    }
    //调用服务中的方法
    public void cal(View v){
        Day08_01_01 day08_01_01 = new Day08_01_01();
        day08_01_01.testmenthd();
    }
    //停止服务
    public void stop(View v){
        Intent service = new Intent(this,Day08_01_01.class);
        stopService(service);
    }
}
