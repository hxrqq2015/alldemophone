package cn.com.mydemotest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import cn.com.alldemophone.Day08_06_02;


public class Day08_07 extends Activity {
    Day08_06_02 binder;
    MyConn conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_07layout);
    }
    class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = Day08_06_02.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

    }

    public void bind(View v) {



        Intent intent = new Intent();
        intent.setAction("cn.com.alldemo.phone.DAY08_06_01");
        conn = new MyConn() ;
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void call(View v) {
        try {
            binder.callMethodInService();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void unbind(View v) {
        unbindService(conn);
    }

}
