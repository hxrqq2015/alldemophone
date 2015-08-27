package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/26.
 */
public class Day11 extends Activity implements View.OnClickListener {
    Button day11_01,day11_02,day11_03,day11_04,day11_05,day11_06,day11_07,
            day11_08,day11_09,day11_10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day11layout);
        day11_01 = (Button) findViewById(R.id.day11_01);
        day11_01.setOnClickListener(this);
        day11_02 = (Button) findViewById(R.id.day11_02);
        day11_02.setOnClickListener(this);
        day11_03 = (Button) findViewById(R.id.day11_03);
        day11_03.setOnClickListener(this);
        day11_04 = (Button) findViewById(R.id.day11_04);
        day11_04.setOnClickListener(this);
        day11_05 = (Button) findViewById(R.id.day11_05);
        day11_05.setOnClickListener(this);
        day11_06 = (Button) findViewById(R.id.day11_06);
        day11_06.setOnClickListener(this);
        day11_07 = (Button) findViewById(R.id.day11_07);
        day11_07.setOnClickListener(this);
        day11_08 = (Button) findViewById(R.id.day11_08);
        day11_08.setOnClickListener(this);
    }

    public void openActivity(Class a){
        Intent intent = new Intent(Day11.this,a);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day11_01:
                openActivity(Day11_01.class);
                break;
            case R.id.day11_02:
                openActivity(Day11_02.class);
                break;
            case R.id.day11_03:
                openActivity(Day11_03.class);
                break;
            case R.id.day11_04:
                openActivity(Day11_04.class);
                break;
            case R.id.day11_05:
                openActivity(Day11_05.class);
                break;
            case R.id.day11_06:
                openActivity(Day11_06.class);
                break;
            case R.id.day11_07:
                openActivity(Day11_07.class);
                break;
            case R.id.day11_08:
                openActivity(Day11_08.class);
                break;
        }
    }
}
