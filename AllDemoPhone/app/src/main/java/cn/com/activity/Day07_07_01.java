package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 自定义广播示例 有序广播
 * Created by admin on 2015/8/21.
 */
public class Day07_07_01 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("我是恩恩主席的内线 ，微服私访，我收到的指令是："+getResultData());
        Toast.makeText(context,"我是恩恩主席的内线 ，微服私访，我收到的指令是："+getResultData(),Toast.LENGTH_SHORT).show();
    }
}
