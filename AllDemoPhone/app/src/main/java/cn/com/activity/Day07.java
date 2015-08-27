package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/21.
 */
public class Day07 extends Activity implements View.OnClickListener {
    Button day07_but01,day07_but02,day07_but03,day07_but04,day07_but05,day07_but06,
    day07_but07,day07_but08,day07_but09,day07_but10,day07_but11,day07_but12,day07_but13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day07layout);
        day07_but01 = (Button) findViewById(R.id.day07_but01);
        day07_but01.setOnClickListener(this);
        day07_but02 = (Button) findViewById(R.id.day07_but02);
        day07_but02.setOnClickListener(this);
        day07_but03 = (Button) findViewById(R.id.day07_but03);
        day07_but03.setOnClickListener(this);
        day07_but04 = (Button) findViewById(R.id.day07_but04);
        day07_but04.setOnClickListener(this);
        day07_but05 = (Button) findViewById(R.id.day07_but05);
        day07_but05.setOnClickListener(this);
        day07_but06 = (Button) findViewById(R.id.day07_but06);
        day07_but06.setOnClickListener(this);
        day07_but07 = (Button) findViewById(R.id.day07_but07);
        day07_but07.setOnClickListener(this);
        day07_but08 = (Button) findViewById(R.id.day07_but08);
        day07_but08.setOnClickListener(this);
        day07_but09 = (Button) findViewById(R.id.day07_but09);
        day07_but09.setOnClickListener(this);
        day07_but10 = (Button) findViewById(R.id.day07_but10);
        day07_but10.setOnClickListener(this);
        day07_but11 = (Button) findViewById(R.id.day07_but11);
        day07_but11.setOnClickListener(this);
    }

    //跳转界面
    public void openAtivity(Class a){
        Intent intent = new Intent(Day07.this,a);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day07_but01:
                openAtivity(Day07_01.class);
                break;
            case R.id.day07_but02:
                openAtivity(Day07_02.class);
                break;
            case R.id.day07_but03:
                openAtivity(Day07_03.class);
                break;
            case R.id.day07_but04:
                openAtivity(Day07_04.class);
                break;
            case R.id.day07_but05:
                openAtivity(Day07_05.class);
                break;
            case R.id.day07_but06:
                openAtivity(Day07_06.class);
                break;
            case R.id.day07_but07:
                openAtivity(Day07_07.class);
                break;
            case R.id.day07_but08:
                openAtivity(Day07_08.class);
                break;
            case R.id.day07_but09:
                openAtivity(Day07_09.class);
                break;
            case R.id.day07_but10:
                openAtivity(Day07_10.class);
                break;
            case R.id.day07_but11:
                openAtivity(Day07_11.class);
                break;
        }
    }
}
