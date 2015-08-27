package cn.com.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import cn.com.alldemophone.Day08_06_02;

/**
 * Created by admin on 2015/8/22.
 */
public class Day08_06_01 extends Service {

    //内部人员 ，修改继承IService中的内部类
   private   class MyBinder  extends Day08_06_02.Stub{
        //内部对象的方法，直接访问了外部类中的方法。
       @Override
       public void callMethodInService() throws RemoteException {
           methodInService();
       }
   }

    //绑定成功，返回内部对象
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind---");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate---");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy---");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind---");
        return super.onUnbind(intent);
    }

    public void methodInService(){
        System.out.println("我是Day08_06_01应用中服务的方法，我被调用了"+Thread.currentThread().getName());
//		Toast.makeText(this, "我是06应用中服务的方法，我被调用了", 0).show();
    }
}
