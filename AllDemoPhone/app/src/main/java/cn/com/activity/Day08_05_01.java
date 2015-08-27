package cn.com.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * 两种服务的区别
 * Created by admin on 2015/8/22.
 */
public class Day08_05_01 extends Service {
    class MyBinder extends Binder implements Day08_05_02{

        @Override
        public void callMethodInServcie() {
            methodInService();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind...");
        return new MyBinder();
    }

    //断开连接，或者是服务取消绑定了。


    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind...");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate-----");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand-----");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        System.out.println("onStart-----");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy-----");
    }


    public void methodInService(){
        Toast.makeText(this, "我是服务内部的方法，我被调用了。", Toast.LENGTH_SHORT).show();
    }

}
