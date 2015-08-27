package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.com.alldemophone.R;

/**
 * 自定义有序广播示例
 * Created by admin on 2015/8/21.
 */
public class Day07_07 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day07_07layout);
    }

    //主席讲话：每人奖励10斤土豆 ，  发布有序广播
    public void start(View v){
        //sendBroadcast(intent)   发布无序广播
        Intent intent= new Intent();
        //发布一条广播，广播的动作。
        intent.setAction("cn.com.alldemophone.action.POTATO");
        /**
         * intent: 意图对象，注意要指定动作名称
         *  receiverPermission: 接收权限，null
         * resultReceiver: 最终的结果接收者 ，null
         * scheduler : handler null
         * initialCode : 初始代码
         * initialData : 初始数据
         * initialExtras ： 初始的额外数据 ，bundle对象
         *
         */
        //发布有序广播 指定最终结果接收者
        sendOrderedBroadcast(intent, null, new Day07_07_01(), null, 1, "主席讲话：每人奖励10斤土豆。", null);
    }
}
