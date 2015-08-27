package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.com.alldemophone.R;

/**
 * 电话窃听器
 * Created by admin on 2015/8/22.
 */
public class Day08_10 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_10layout);
    }

    public void start(View v){
        Intent service = new Intent(this, Day08_10_01.class);
        startService(service);
    }
}
