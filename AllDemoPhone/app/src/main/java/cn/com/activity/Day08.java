package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/22.
 */
public class Day08 extends Activity implements View.OnClickListener {
    Button day08_but01,day08_but02,day08_but03,day08_but04,day08_but05,day08_but06,
            day08_but07,day08_but08,day08_but09,day08_but10,day08_but11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08layout);
        day08_but01 = (Button) findViewById(R.id.day08_but01);
        day08_but01.setOnClickListener(this);
        day08_but02 = (Button) findViewById(R.id.day08_but02);
        day08_but02.setOnClickListener(this);
        day08_but03 = (Button) findViewById(R.id.day08_but03);
        day08_but03.setOnClickListener(this);
        day08_but04 = (Button) findViewById(R.id.day08_but04);
        day08_but04.setOnClickListener(this);
        day08_but05 = (Button) findViewById(R.id.day08_but05);
        day08_but05.setOnClickListener(this);
        day08_but06 = (Button) findViewById(R.id.day08_but06);
        day08_but06.setOnClickListener(this);
        day08_but07 = (Button) findViewById(R.id.day08_but07);
        day08_but07.setOnClickListener(this);
        day08_but08 = (Button) findViewById(R.id.day08_but08);
        day08_but08.setOnClickListener(this);
        day08_but09 = (Button) findViewById(R.id.day08_but09);
        day08_but09.setOnClickListener(this);
        day08_but10 = (Button) findViewById(R.id.day08_but10);
        day08_but10.setOnClickListener(this);
    }

    public void openActivity(Class a){
        Intent intent = new Intent(Day08.this,a);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day08_but01:
                openActivity(Day08_01.class);
                break;
            case R.id.day08_but02:
                openActivity(Day08_02.class);
                break;
            case R.id.day08_but03:
                openActivity(Day08_03.class);
                break;
            case R.id.day08_but04:
                openActivity(Day08_04.class);
                break;
            case R.id.day08_but05:
                openActivity(Day08_05.class);
                break;
            case R.id.day08_but06:
                openActivity(Day08_06.class);
                break;
            case R.id.day08_but07:
                openActivity(Day08_07.class);
                break;
            case R.id.day08_but08:
                openActivity(Day08_08.class);
                break;
            case R.id.day08_but09:
                openActivity(Day08_09.class);
                break;
            case R.id.day08_but10:
                openActivity(Day08_10.class);
                break;
        }
    }
}
