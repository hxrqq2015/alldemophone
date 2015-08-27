package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;

import cn.com.alldemophone.R;

/**
 * Activity生命周期
 * Created by admin on 2015/8/21.
 */
public class Day06_06 extends Activity {
    //当界面创建的时候调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_06layout);
    }
    // 界面可见的时候调用。
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart----1");

    }

    //暂停  ，当前界面失去了焦点
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause----3");
    }

    //继续： 当前界面可以获取到焦点
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume----2");
    }



    // 界面不可见的时候调用
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop----4");
    }

    // 当界面已经销毁的时候调用
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy----5");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart----");
    }
}
