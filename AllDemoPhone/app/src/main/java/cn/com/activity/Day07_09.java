package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import cn.com.alldemophone.R;

/**
 *  监听屏幕的锁定和点亮
 * Created by admin on 2015/8/21.
 */
public class Day07_09 extends Activity {
    Day07_09_01 receiver ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day07_09layout);
        //创建广播接收者的对象
        receiver= new Day07_09_01();
        //指定该广播接收者，收听什么样的广播。
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        //注册广播接收者
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        receiver=null;
    }
}
