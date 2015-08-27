package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 乡级部门
 * Created by admin on 2015/8/21.
 */
public class Day07_08_03 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("我是乡级部门, 收到的指令是："+getResultData());
        setResultData("主席讲话：每人奖励2斤土豆。");
        Toast.makeText(context, "我是乡级部门, 收到的指令是" + getResultData(), Toast.LENGTH_SHORT).show();


    }
}
