package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/10.
 */
public class Day03  extends Activity implements View.OnClickListener{
    Button day03_but01,day03_but02,day03_but03,day03_but04,day03_but05;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day03layout);
        //获取控件
       day03_but01= (Button) findViewById(R.id.day03_but01);
        //绑定点击事件
        day03_but01.setOnClickListener(this);
       day03_but02= (Button) findViewById(R.id.day03_but02);
        day03_but02.setOnClickListener(this);
        day03_but03= (Button) findViewById(R.id.day03_but03);
        day03_but03.setOnClickListener(this);
        day03_but04 = (Button) findViewById(R.id.day03_but04);
        day03_but04.setOnClickListener(this);
        day03_but05= (Button) findViewById(R.id.day03_but05);
        day03_but05.setOnClickListener(this);

    }
    //实现跳转
    public void statActivi(Class a){
        Intent intent = new Intent(Day03.this,a);
        startActivity(intent);
    }

    //判断跳转到哪个Activiyt
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day03_but01:
                statActivi(Day03_01.class);
                break;
            case R.id.day03_but02:
                statActivi(Day03_02.class);
                break;
            case R.id.day03_but03:
                statActivi(Day03_03.class);
                break;
            case R.id.day03_but04:
                statActivi(Day03_04.class);
                break;
            case R.id.day03_but05:
                statActivi(Day03_05.class);
                break;
        }
    }
}
