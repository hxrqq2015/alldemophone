package cn.com.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.Toast;

/**
 * 服务实际上就是一个长期运行在后台，没有界面的activity
 * Created by admin on 2015/8/21.
 */
public class Day07_10_01 extends Service {
    boolean flag ;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate。。。--->");

        System.out.println("服务被创建了。。。--->" + Thread.currentThread().getName());
        new Thread(){
            @Override
            public void run() {
                flag = true;
                while(flag){
                    System.out.println("在等待新的设备接入...");
                   // Toast.makeText(Day07_10_01.this,"在等待新的设备接入...",Toast.LENGTH_SHORT).show();
                    SystemClock.sleep(1000);//android自带的睡眠
                }
            }
        }.start();
    }

    //过时的开启服务方法
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        System.out.println("onStart。。。--->");
    }

    //现在使用的开启服务方法
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        System.out.println("onStartCommand。。。--->");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        System.out.println("onDestroy。。。");
        super.onDestroy();
        System.out.println("服务被销毁了。。。");
       // Toast.makeText(Day07_10_01.this,"服务被销毁了。。。",Toast.LENGTH_SHORT).show();
        flag=false;
    }
}
