package cn.com.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by admin on 2015/8/22.
 */
public class Day08_01_01 extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy...");
    }

    public void testmenthd(){
        System.out.println("服务中的方法被调用了...");
        //自己创建的服务对象，是没有上下文环境的，所以如果在里面做一些需要用到上下文数据的逻辑，将不可执行。
        Toast.makeText(this, "我是服务中的方法，我被调用了", Toast.LENGTH_SHORT).show();
    }
}
