package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 监听SD卡的状态
 * 1.继承BroadcastReceiver
 * 2. 重写onReceiver
 * Created by admin on 2015/8/21.
 */
public class Day07_01_01 extends BroadcastReceiver {
    //当广播到来的时候，该方法将会被调用。
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"储存卡已被拔出、微信头像、图片、声音、视频功能将暂时不可用.",Toast.LENGTH_SHORT).show();
    }
}
