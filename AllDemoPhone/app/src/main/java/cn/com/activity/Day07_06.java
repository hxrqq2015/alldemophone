package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/21.
 */
public class Day07_06 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day07_06layout);
    }
    //自己发布一条广播
    public void start(View v){
        //startActivity 启动界面
        //定义意图对象
        Intent intent = new Intent();
        //指定广播使用的频道，就是action动作
        intent.setAction("cn.com.alldemophone.XWLB");
        //指定带上的数据
        intent.putExtra("data", "这是今天的主要内容：习近平主席出访...");
        //发布一条广播：  无序广播
        sendBroadcast(intent);
    }
}
