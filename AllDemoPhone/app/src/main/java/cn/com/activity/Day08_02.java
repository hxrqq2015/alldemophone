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
public class Day08_02 extends Activity {

    Day08_02_01.MyBinder binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_02layout);
    }
    // 启动服务
    public void bind(View v){
        Intent service = new Intent(this,Day08_02_01.class);
        	/*
		 * 第一个参数是intent对象，指定要绑定什么服务呀。
		 * 第二个参数是：是一个serviceConnection对象，用于获取当前服务的一些状态
		 * 第三个参数： 创建服务，绑定服务的可选项 。BIND_AUTO_CREATE
		 *
		 */
        bindService(service,new MyConn(),BIND_AUTO_CREATE);
    }

    /**
     * 服务连接的内部类
     */
    private class MyConn implements ServiceConnection {
        //如果服务成功连接上，实际上就是绑定上了，那么这个方法将会调用
        //将会返回服务中的内部代理对象 service 就是服务中的内部代理对象
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //得到了内部代理对象
            binder = (Day08_02_01.MyBinder) service;
        }
        //如果服务已经断开连接了，那么这个方法将会调用
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
    public void call(View v){
        binder.callmethodInService("张三丰", 2000000);
    }

    public void unbind(View v){
//        Intent service = new Intent(Day08_02.this,Day08_02_01.class);
//       unbindService(new MyConn());
    }


}
