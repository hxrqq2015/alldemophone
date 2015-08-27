package cn.com.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import cn.com.alldemophone.R;

/**
 * binderService服务生命周期
 * Created by admin on 2015/8/22.
 */
public class Day08_04 extends Activity {
    Day08_04_02 binder;
    MyConn conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_04layout);
    }
    class MyConn implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("onServiceConnected---3");
            binder= (Day08_04_02) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("onServiceDisconnected---");
        }
    }


    //绑定服务
    public void bind(View v){
        Intent service = new Intent(Day08_04.this,Day08_04_01.class);
        conn = new MyConn();
        bindService(service,conn,BIND_AUTO_CREATE);
    }
    //调用服务中的方法
    public void call(View v){
        binder.callMethodInServcie();
    }
    //取消绑定服务
    public void unbind(View v){
        //取消绑定服务，要求使用早前绑定服务的serviceconnection对象
        unbindService(conn);
    }
}
