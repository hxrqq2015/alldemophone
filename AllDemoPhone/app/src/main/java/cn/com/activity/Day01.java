package cn.com.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/8.
 */
public class Day01 extends Activity implements View.OnClickListener{

    Button but01,but02,but03,but04,but05;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day01layout);
        //  findViewById(R.id.btn).cast
      //  ((Button) findViewById(R.id.btn)).var
     //wo

        but01 = (Button) findViewById(R.id.day01_01);
        but01.setOnClickListener(this);
        but02 = (Button) findViewById(R.id.day01_02);
        but02.setOnClickListener(this);
        but03 = (Button) findViewById(R.id.day01_03);
        but03.setOnClickListener(this);
        but04 = (Button) findViewById(R.id.day01_04);
        but04.setOnClickListener(this);
        but05 = (Button) findViewById(R.id.day01_05);
        but05.setOnClickListener(this);
    }
    //启动Activity
    public void intent(Class b){
        Intent inten = new Intent(Day01.this,b);
        startActivity(inten);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day01_01:
                intent(Day01_01.class);
                break;
            case R.id.day01_02:
                intent(Day01_02.class);
                break;
            case R.id.day01_03:
                intent(Day01_03.class);
                break;
            case R.id.day01_04:
                intent(Day01_04.class);
                break;
            case R.id.day01_05:
                intent(Day01_05.class);
                break;

        }
    }
}
