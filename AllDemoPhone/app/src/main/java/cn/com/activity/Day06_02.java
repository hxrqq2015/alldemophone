package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.com.alldemophone.R;

/**
 * 开启界面两种方式
 * Created by admin on 2015/8/20.
 */
public class Day06_02 extends Activity implements View.OnClickListener {
    Button day06_but01,day06_but02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_02layout);
        day06_but01 = (Button) findViewById(R.id.day06_but01);
        day06_but01.setOnClickListener(this);
        day06_but02 = (Button) findViewById(R.id.day06_but02);
        day06_but02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.day06_but01:
                //使用显式意图启动界面01
                Intent intent = new Intent();
                intent.setClassName("cn.com.alldemophone","cn.com.activity.Day06_02_01");
                startActivity(intent);
                break;
            case R.id.day06_but02:
                //使用隐式意图启动界面02
                Intent intent1 = new Intent();
                //指定该意图的动作是 早前定义好的action，如果写错，将不能启动界面
                intent1.setAction("cn.com.activity.action.Day06_02_02");
                //默认的分类不加也可以，因为本身就是默认的
                intent1.addCategory("android.intent.category.DEFAULT");
                startActivity(intent1);
        }
    }
}
