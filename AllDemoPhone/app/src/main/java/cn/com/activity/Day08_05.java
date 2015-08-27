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
 * 两种服务的区别
 * Created by admin on 2015/8/22.
 */
public class Day08_05 extends Activity {
    Day08_05_02 binder;
    MyConn conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_05layout);
    }

    class  MyConn implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("onServiceConnected---");
            binder = (Day08_05_02) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("onServiceDisconnected---");
        }
    }

    // 绑定服务
    public void bind(View v){
        Intent intent = new Intent(this,Day08_05_01.class);
        conn = new MyConn();
        bindService(intent,conn,BIND_AUTO_CREATE);
    }
    // 调用服务中的方法
    public void call(View v){
        binder.callMethodInServcie();
    }
    // 取消绑定服务
    public void unbind(View v){
        // 取消绑定服务，要求使用早前绑定服务的serviceconnection对象
        unbindService(conn);
    }

    public void start(View v) {

        startService(new Intent(this, Day08_05_01.class));
    }

    public void stop(View v) {
        stopService(new Intent(this, Day08_05_01.class));
    }
}
