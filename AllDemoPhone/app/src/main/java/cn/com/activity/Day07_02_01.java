package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 开机启动完成的广播接收者
 * Created by admin on 2015/8/21.
 */
public class Day07_02_01 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("开机启动完成了~~~。。。。。");
        //开机完成，马上进入到另一个主界面
        Intent intent1 = new Intent(context,Day07_02.class);
        //指定让activity放到一个新的任务栈中，当前的广播上下文是没有界面的，所以也就没有了栈的概念。
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//有栈就不启动栈，没栈就启动栈
        context.startActivity(intent1);
    }
}
