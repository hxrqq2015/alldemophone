package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 监听应用安装与卸载
 * Created by admin on 2015/8/21.
 */
public class Day07_04_01 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)){ //应用程序被卸载了。
            System.out.println("有一个应用被卸载了。。。" + intent.getData());
            Toast.makeText(context,"有一个应用被卸载了。。。"+intent.getData(),Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)){//应用程序被安装了
            System.out.println("有一个应用被安装了。。。" + intent.getData());
            Toast.makeText(context,"有一个应用被安装了。。。"+intent.getData(),Toast.LENGTH_SHORT).show();
        }
    }
}
