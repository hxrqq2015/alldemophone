package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import cn.com.alldemophone.R;

/**
 * 人品计算器
 * Created by admin on 2015/8/19.
 */
public class Day06_01 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_01layout);
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Day06_01.this , Day06_01_01.class);
                //启动一个界面
                startActivity(intent);

                //马上让这个当前logo界面关闭掉

                finish();
            }
        }.start();
    }
}
