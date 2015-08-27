package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 农民部门
 * Created by admin on 2015/8/21.
 */
public class Day07_08_04 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("我是农民部门, 收到的指令是：" + getResultData());
        Toast.makeText(context, "我是农民部门, 收到的指令是：" + getResultData(), Toast.LENGTH_SHORT).show();
        Toast.makeText(context,"啊~~！！！感谢我的太阳~~", Toast.LENGTH_SHORT).show();
        System.out.println("啊~~！！！感谢我的太阳~~");
    }
}
