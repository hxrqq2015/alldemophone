package cn.com.mydemotest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

import cn.com.alldemophone.Day08_08_02;

/**
 * Created by admin on 2015/8/22.
 */
public class Day08_08 extends Activity {
    Day08_08_02 binder;
    MyConn conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_08layout);
    }
    class MyConn implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = Day08_08_02.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    public void bind(View v) {
        Intent service = new Intent();
        service.setAction("cn.com.activity.Day08_08_01");
        conn = new MyConn();
        bindService(service, conn, BIND_AUTO_CREATE);
    }

    public void buy(View v) {

        try {
            int code = binder.callSafePay("zhangsan", "10086", 300);
            String str = "";
            switch (code) {
                case 200:
                    str ="张三先生，您的100发炮弹已经充值成功.";
                    break;
                case 250:
                    str ="小样，你的钱够么?";
                    break;
                case 404:
                    str ="账号或者密码错误.";
                    break;
            }

            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void unbind(View v) {
        unbindService(conn);
    }



}
