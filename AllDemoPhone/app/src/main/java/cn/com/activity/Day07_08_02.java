package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 县级部门
 * Created by admin on 2015/8/21.
 */
public class Day07_08_02 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("我是县级部门, 收到的指令是："+getResultData());
        Toast.makeText(context, "我是县级部门, 收到的指令是：" + getResultData(), Toast.LENGTH_SHORT).show();
        setResultData("主席讲话：每人奖励4斤土豆。");//重置广播内容
    }
}
