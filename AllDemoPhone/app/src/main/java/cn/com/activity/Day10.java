package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/25.
 */
public class Day10 extends Activity implements View.OnClickListener {
    Button day10_but01, day10_but02, day10_but03, day10_but04, day10_but05, day10_but06, day10_but07,
            day10_but08, day10_but09, day10_but10, day10_but11, day10_but12, day10_but13, day10_but14, day10_but15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10layout);


        day10_but01 = (Button) findViewById(R.id.day10_but01);
        day10_but01.setOnClickListener(this);
        day10_but02 = (Button) findViewById(R.id.day10_but02);
        day10_but02.setOnClickListener(this);
        day10_but03 = (Button) findViewById(R.id.day10_but03);
        day10_but03.setOnClickListener(this);
        day10_but04 = (Button) findViewById(R.id.day10_but04);
        day10_but04.setOnClickListener(this);
        day10_but05 = (Button) findViewById(R.id.day10_but05);
        day10_but05.setOnClickListener(this);
        day10_but06 = (Button) findViewById(R.id.day10_but06);
        day10_but06.setOnClickListener(this);
        day10_but07 = (Button) findViewById(R.id.day10_but07);
        day10_but07.setOnClickListener(this);
        day10_but08 = (Button) findViewById(R.id.day10_but08);
        day10_but08.setOnClickListener(this);
        day10_but09 = (Button) findViewById(R.id.day10_but09);
        day10_but09.setOnClickListener(this);
        day10_but10 = (Button) findViewById(R.id.day10_but10);
        day10_but10.setOnClickListener(this);
        day10_but11 = (Button) findViewById(R.id.day10_but11);
        day10_but11.setOnClickListener(this);
        day10_but12 = (Button) findViewById(R.id.day10_but12);
        day10_but12.setOnClickListener(this);
        day10_but13 = (Button) findViewById(R.id.day10_but13);
        day10_but13.setOnClickListener(this);
        day10_but14 = (Button) findViewById(R.id.day10_but14);
        day10_but14.setOnClickListener(this);
        day10_but15 = (Button) findViewById(R.id.day10_but15);
        day10_but15.setOnClickListener(this);
    }

    public void openActivity(Class a) {
        Intent intent = new Intent(Day10.this, a);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.day10_but01:
                openActivity(Day10_01.class);
                break;
            case R.id.day10_but02:
                openActivity(Day10_02.class);
                break;
            case R.id.day10_but03:
                openActivity(Day10_03.class);
                break;
            case R.id.day10_but04:
                openActivity(Day10_04.class);
                break;
            case R.id.day10_but05:
                openActivity(Day10_05.class);
                break;
            case R.id.day10_but06:
                openActivity(Day10_06.class);
                break;
            case R.id.day10_but07:
                openActivity(Day10_07.class);
                break;
            case R.id.day10_but08:
                openActivity(Day10_08.class);
                break;
            case R.id.day10_but09:
                openActivity(Day10_09.class);
                break;
            case R.id.day10_but10:
                openActivity(Day10_10.class);
                break;
            case R.id.day10_but11:
                openActivity(Day10_11.class);
                break;
            case R.id.day10_but12:
                openActivity(Day10_12.class);
                break;
            case R.id.day10_but13:
                openActivity(Day10_13.class);
                break;
            case R.id.day10_but14:
                openActivity(Day10_14.class);
                break;
            case R.id.day10_but15:
                openActivity(Day10_15.class);
                break;
        }
    }
}
