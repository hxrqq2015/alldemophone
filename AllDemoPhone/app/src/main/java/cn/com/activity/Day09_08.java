package cn.com.activity;

import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import cn.com.alldemophone.R;

/**
 * day09_08内容观察者
 * Created by admin on 2015/8/25.
 */
public class Day09_08 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day09_08layout);

        Uri uri = Uri.parse("content://cn.com.activity.Day09_01_02/account");
        //注册一个内容观察者
        /**
         * 让它观察指定的uri路径，如果通过了这个uri去改变了数据库的数据，俺么后面的内容观察者将会得到通知。
         * 中间这个参数的意思是：true；只要匹配对了前半段的Uri,那么也能收到通知。
         * false，代表全部uri，一个字母不漏，都要完全匹配，才能收到通知
         */
        getContentResolver().registerContentObserver(uri, true, new ContentObserver(new Handler()) {
            @Override
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                System.out.println("来人啊，银行行长又来偷钱了..");
            }
        });
    }
}
