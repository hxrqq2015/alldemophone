package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * day07_06自定义广播
 * Created by admin on 2015/8/21.
 */
public class Day07_06_01 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("我收到了自定义的广播,数据是："+intent.getStringExtra("data"));
        Toast.makeText(context,"我收到了自定义的广播,数据是：" + intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();
    }
}
