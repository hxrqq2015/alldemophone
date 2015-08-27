package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import cn.com.alldemophone.R;


/**
 * Created by admin on 2015/8/20.
 */
public class Day06_03 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_03layout);

    }

    /**
     * 隐式应用
     * @param v
     */
    public void one(View v){
        Intent intent = new Intent();
        //指定动作
        intent.setAction("cn.com.alldemophone.action.Day06_03_01");
        //指定类型
        intent.addCategory("android.intent.category.DEFAULT");
        //指定数据
        intent.setDataAndType(Uri.parse("baidu://www.baidu.com"),"text/plain");
        /*	intent.setType("text/plain");
		intent.setData(Uri.parse("baidu://www.baidu.com"));*/
        startActivity(intent);
    }

    /**
     * 版权应用
     * @param v
     */
    public void two(View v){
        Intent intent = new Intent(Day06_03.this,Day06_03_02.class);
        startActivity(intent);
    }
}
