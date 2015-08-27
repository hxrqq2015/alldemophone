package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/19.
 */
public class Day06 extends Activity implements View.OnClickListener{
    Button day06_but01,day06_but02,day06_but03,day06_but04,day06_but05,day06_but06,day06_but07;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06layout);
        day06_but01 = (Button) findViewById(R.id.day06_but01);
        day06_but01.setOnClickListener(this);
        day06_but02 = (Button) findViewById(R.id.day06_but02);
        day06_but02.setOnClickListener(this);
        day06_but03 = (Button) findViewById(R.id.day06_but03);
        day06_but03.setOnClickListener(this);
        day06_but04 = (Button) findViewById(R.id.day06_but04);
        day06_but04.setOnClickListener(this);
        day06_but05 = (Button) findViewById(R.id.day06_but05);
        day06_but05.setOnClickListener(this);
        day06_but06 = (Button) findViewById(R.id.day06_but06);
        day06_but06.setOnClickListener(this);
        day06_but07 = (Button) findViewById(R.id.day06_but07);
        day06_but07.setOnClickListener(this);

    }

    public void openActivity(Class a){
        Intent intent = new Intent(Day06.this,a);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day06_but01:
                openActivity(Day06_01.class);
                break;
            case R.id.day06_but02:
                openActivity(Day06_02.class);
                break;
            case R.id.day06_but03:
                openActivity(Day06_03.class);
                break;
            case R.id.day06_but04:
                openActivity(Day06_04.class);
                break;
            case R.id.day06_but05:
                openActivity(Day06_06.class);
                break;
            case R.id.day06_but06:
                openActivity(Day06_07.class);
                break;
            case R.id.day06_but07:
                openActivity(Day06_08.class);
                break;

        }
    }
}
