package cn.com.alldemophone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.activity.Day01;
import cn.com.activity.Day02;
import cn.com.activity.Day03;
import cn.com.activity.Day04;
import cn.com.activity.Day05;
import cn.com.activity.Day06;
import cn.com.activity.Day07;
import cn.com.activity.Day08;
import cn.com.activity.Day09;
import cn.com.activity.Day10;
import cn.com.activity.Day11;


public class MainActivity extends Activity implements View.OnClickListener {
    Button day01,day02,day03,day04,day05,day06,day07,day08,day09,day10,day11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //调用方法
        findViewId();
    }
    public void findViewId(){
        //找到控件
        day01 = (Button) findViewById(R.id.day01);
        //绑定监听事件
        day01.setOnClickListener(this);
        day02 = (Button) findViewById(R.id.day02);
        day02.setOnClickListener(this);
        day03 = (Button) findViewById(R.id.day03);
        day03.setOnClickListener(this);
        day04 = (Button) findViewById(R.id.day04);
        day04.setOnClickListener(this);
        day05 = (Button) findViewById(R.id.day05);
        day05.setOnClickListener(this);
        day06 = (Button) findViewById(R.id.day06);
        day06.setOnClickListener(this);
        day07 = (Button) findViewById(R.id.day07);
        day07.setOnClickListener(this);
        day08 = (Button) findViewById(R.id.day08);
        day08.setOnClickListener(this);
        day09 = (Button) findViewById(R.id.day09);
        day09.setOnClickListener(this);
        day10 = (Button) findViewById(R.id.day10);
        day10.setOnClickListener(this);
        day11 = (Button) findViewById(R.id.day11);
        day11.setOnClickListener(this);

    }

    public  void startActy(Class b){
        Intent intent = new Intent(MainActivity.this,b);
        startActivity(intent);
    }
    //监听事件实现
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day01:
                startActy(Day01.class);
                break;
            case R.id.day02:
                startActy(Day02.class);
                break;
            case  R.id.day03:
                startActy(Day03.class);
                break;
            case  R.id.day04:
                startActy(Day04.class);
                break;
            case  R.id.day05:
                startActy(Day05.class);
                break;
            case  R.id.day06:
                startActy(Day06.class);
                break;
            case  R.id.day07:
                startActy(Day07.class);
                break;
            case  R.id.day08:
                startActy(Day08.class);
                break;
            case  R.id.day09:
                startActy(Day09.class);
                break;
            case  R.id.day10:
                startActy(Day10.class);
                break;
            case  R.id.day11:
                startActy(Day11.class);
                break;
        }
    }


}
