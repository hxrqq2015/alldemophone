package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/23.
 */
public class Day09 extends Activity implements View.OnClickListener{
    Button day09_but01,day09_but02,day09_but03,day09_but04,day09_but05,day09_but06,day09_but07,
            day09_but08,day09_but09;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day09layout);

        day09_but01 = (Button) findViewById(R.id.day09_but01);
        day09_but01.setOnClickListener(this);
        day09_but02 = (Button) findViewById(R.id.day09_but02);
        day09_but02.setOnClickListener(this);
        day09_but03 = (Button) findViewById(R.id.day09_but03);
        day09_but03.setOnClickListener(this);
        day09_but04 = (Button) findViewById(R.id.day09_but04);
        day09_but04.setOnClickListener(this);
        day09_but05 = (Button) findViewById(R.id.day09_but05);
        day09_but05.setOnClickListener(this);
        day09_but06 = (Button) findViewById(R.id.day09_but06);
        day09_but06.setOnClickListener(this);
        day09_but07 = (Button) findViewById(R.id.day09_but07);
        day09_but07.setOnClickListener(this);
        day09_but08 = (Button) findViewById(R.id.day09_but08);
        day09_but08.setOnClickListener(this);
        day09_but09 = (Button) findViewById(R.id.day09_but09);
        day09_but09.setOnClickListener(this);
    }

    public void openActivity(Class a){
        Intent intent = new Intent(Day09.this,a);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day09_but01:
                openActivity(Day09_01.class);
                break;
            case R.id.day09_but02:
                openActivity(Day09_02.class);
                break;
            case R.id.day09_but03:
                openActivity(Day09_03.class);
                break;
            case R.id.day09_but04:
                openActivity(Day09_04.class);
                break;
            case R.id.day09_but05:
                openActivity(Day09_05.class);
                break;
            case R.id.day09_but06:
                openActivity(Day09_06.class);
                break;
            case R.id.day09_but07:
                openActivity(Day09_07.class);
                break;
            case R.id.day09_but08:
                openActivity(Day09_08.class);
                break;
            case R.id.day09_but09:
                openActivity(Day09_09.class);
                break;

        }
    }
}
