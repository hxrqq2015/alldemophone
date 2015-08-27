package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 监听屏幕的锁定和点亮
 * Created by admin on 2015/8/21.
 */
public class Day07_09_01 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            System.out.println("---屏幕被点亮了。。。。");
            Toast.makeText(context,"屏幕被点亮了",Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            System.out.println("---屏幕被锁定了。。。。");
            Toast.makeText(context,"屏幕被锁定了",Toast.LENGTH_SHORT).show();
        }
    }
}
