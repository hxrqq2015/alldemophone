package cn.com.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * day02首页
 * Created by admin on 2015/8/8.
 */
public class Day02 extends Activity implements View.OnClickListener {
    Button day02_but01,day02_but02,day02_but03,day02_but04,day02_but05,day02_but06,day02_but07;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day02layout);
        //获取控件
        day02_but01= (Button) findViewById(R.id.day02_but01);
        //绑定点击事件
        day02_but01.setOnClickListener(this);
        day02_but02= (Button) findViewById(R.id.day02_but02);
        day02_but02.setOnClickListener(this);
        day02_but03= (Button) findViewById(R.id.day02_but03);
        day02_but03.setOnClickListener(this);
        day02_but04= (Button) findViewById(R.id.day02_but04);
        day02_but04.setOnClickListener(this);
        day02_but05= (Button) findViewById(R.id.day02_but05);
        day02_but05.setOnClickListener(this);
        day02_but06 = (Button) findViewById(R.id.day02_but06);
        day02_but06.setOnClickListener(this);
        day02_but07 = (Button) findViewById(R.id.day02_but07);
        day02_but07.setOnClickListener(this);

    }
    //启动跳转到其他Activity
    public void stata(Class b){
        Intent intent = new Intent(Day02.this,b);
        startActivity(intent);
    }
    //监听按钮点击
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day02_but01:
                stata(Day02_01.class);
                break;
            case R.id.day02_but02:
                stata(Day02_02.class);
                break;
            case R.id.day02_but03:
                stata(Day02_03.class);
                break;
            case R.id.day02_but04:
                stata(Day02_04.class);
                break;
            case R.id.day02_but05:
                stata(Day02_05.class);
                break;
            case R.id.day02_but06:
                stata(Day02_06.class);
                break;
            case R.id.day02_but07:
                stata(Day02_07.class);
                break;
        }
    }
}
