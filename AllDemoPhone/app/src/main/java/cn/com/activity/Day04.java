package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/14.
 */
public class Day04 extends Activity implements View.OnClickListener{
   private Button day04_but01,day04_but02,day04_but03,day04_but04,day04_but05,day04_but06;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day04layout);
        day04_but01 = (Button) findViewById(R.id.day04_but01);
        day04_but01.setOnClickListener(this);
        day04_but02 = (Button) findViewById(R.id.day04_but02);
        day04_but02.setOnClickListener(this);
        day04_but03 = (Button) findViewById(R.id.day04_but03);
        day04_but03.setOnClickListener(this);
        day04_but04 = (Button) findViewById(R.id.day04_but04);
        day04_but04.setOnClickListener(this);
        day04_but05= (Button) findViewById(R.id.day04_but05);
        day04_but05.setOnClickListener(this);
        day04_but06= (Button) findViewById(R.id.day04_but06);
        day04_but06.setOnClickListener(this);
    }

    public void openView(Class a){
        Intent intent = new Intent(Day04.this,a);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day04_but01:
                openView(Day04_01.class);
                break;
            case R.id.day04_but02:
                openView(Day04_02.class);
                break;
            case R.id.day04_but03:
                openView(Day04_03.class);
                break;
            case R.id.day04_but04:
                openView(Day04_04.class);
                break;
            case R.id.day04_but05:
                openView(Day04_05.class);
                break;
            case R.id.day04_but06:
                openView(Day04_06.class);
                break;
        }
    }
}
