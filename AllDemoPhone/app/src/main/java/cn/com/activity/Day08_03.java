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
 * Created by admin on 2015/8/22.
 */
public class Day08_03 extends Activity {
    Day08_03_02 binder;
    MyConn conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_03layout);
    }

    // 启动服务
    public void bind(View v) {
        //startService(new Intent(this, ServiceDemo.class))
        Intent intent = new Intent(this, Day08_03_01.class);
		/*
		 * 第一个参数是intent对象，指定要绑定什么服务呀。
		 * 第二个参数是：是一个serviceConnection对象，用于获取当前服务的一些状态
		 * 第三个参数： 创建服务，绑定服务的可选项 。BIND_AUTO_CREATE
		 *
		 */
        conn = new MyConn() ;
        bindService(intent, conn, BIND_AUTO_CREATE);


    }
    /**
     * 服务连接的内部类
     */
    class MyConn implements ServiceConnection {


        //如果服务成功连接上，实际上就是绑定上了，那么这个方法将会调用
        //将会返回服务中的内部代理对象 service 就是服务中的内部代理对象
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("服务连接上了，开始返回内部对象");
            //得到了内部代理对象
            binder = (Day08_03_02) service;

        }

        //如果服务已经断开连接了，那么这个方法将会调用
        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("服务断开连接了");

        }

    }

    // 调用服务中的方法
    public void call(View v) {
        binder.callMethodInService("张三丰", 2000000);
    binder.aa("小明",700000);
		//binder.硕士研究生("张三三", 200092832);
    }

    // 停止服务
    public void unbind(View v) {
        unbindService(conn);
    }
}
