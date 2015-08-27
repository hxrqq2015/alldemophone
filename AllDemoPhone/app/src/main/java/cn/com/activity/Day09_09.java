package cn.com.activity;

import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import cn.com.alldemophone.R;

/**
 * day09_09短信内容观察者
 * Created by admin on 2015/8/25.
 */
public class Day09_09 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day09_09layout);

        //一直关心短信的数据库
        Uri uri = Uri.parse("content://sms");
        getContentResolver().registerContentObserver(uri,true,new MyObserver(new Handler()));
    }

    private class MyObserver extends ContentObserver {
        public MyObserver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
            //练习： 回去使用这种内容观察者的手法去实现短信的窃听。
            // 不过这个方式并不会直接拿到短信的数据，而是返回短信的最新数据对应的uri
            //有了URI，也就可以通过ContentResolver去查询到最新的短信数据
            System.out.println("---数据发生改变了----uri="+uri);
        }
    }
}
