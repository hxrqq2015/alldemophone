package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/18.
 */
public class Day05 extends Activity implements View.OnClickListener {
    Button day05_but01,day05_but02,day05_but03,day05_but04,day05_but05,
            day05_but06,day05_but07,day05_but08,day05_but09,day05_but10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day05layout);
        day05_but01 = (Button) findViewById(R.id.day05_but01);
        day05_but01.setOnClickListener(this);
        day05_but02= (Button) findViewById(R.id.day05_but02);
        day05_but02.setOnClickListener(this);
        day05_but03= (Button) findViewById(R.id.day05_but03);
        day05_but03.setOnClickListener(this);
        day05_but04= (Button) findViewById(R.id.day05_but04);
        day05_but04.setOnClickListener(this);
        day05_but05= (Button) findViewById(R.id.day05_but05);
        day05_but05.setOnClickListener(this);
        day05_but06= (Button) findViewById(R.id.day05_but06);
        day05_but06.setOnClickListener(this);
        day05_but07= (Button) findViewById(R.id.day05_but07);
        day05_but07.setOnClickListener(this);
       // day05_but08= (Button) findViewById(R.id.day05_but08);
       // day05_but08.setOnClickListener(this);
        day05_but09= (Button) findViewById(R.id.day05_but09);
        day05_but09.setOnClickListener(this);
        day05_but10= (Button) findViewById(R.id.day05_but10);
        day05_but10.setOnClickListener(this);
    }

    public void openac(Class a){
        Intent intent = new Intent(Day05.this,a);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day05_but01:
                openac(Day05_01.class);
                break;
            case R.id.day05_but02:
                openac(Day05_02.class);
                break;
            case R.id.day05_but03:
                openac(Day05_03.class);
                break;
            case R.id.day05_but04:
                openac(Day05_04.class);
                break;
            case R.id.day05_but05:
                openac(Day05_05.class);
                break;
            case R.id.day05_but06:
                openac(Day05_06.class);
                break;
            case R.id.day05_but07:
                openac(Day05_07.class);
                break;
          //  case R.id.day05_but08:
           //     openac(Day05_08.class);
             //   break;
            case R.id.day05_but09:
                openac(Day05_09.class);
                break;
            case R.id.day05_but10:
                openac(Day05_10.class);
                break;
        }
    }
}
