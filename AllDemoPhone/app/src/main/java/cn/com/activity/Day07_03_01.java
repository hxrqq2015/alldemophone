package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * 监听电话向外呼叫的广播接收者
 * Created by admin on 2015/8/21.
 */
public class Day07_03_01 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
//获取向外呼叫的电话号码。   获取广播的数据，和给广播重新赋值数据
        System.out.println("向外拨打电话了。。。"+getResultData());
        String number = getResultData();
        if(number.startsWith("0")){
            SharedPreferences sp = context.getSharedPreferences("config",0);
            String prefix = sp.getString("number","");
            setResultData(prefix+number);
          //  setResultData(null);//设置不用呼叫，呼叫的号码是null.系统判定如果是null,
            // 就不知道打给谁了。
        }
        abortBroadcast(); // 试图终止向外呼叫电话 无法终止，原因是内部有一个最终结果接收者，
        // 它就启动了拨号的界面
    }
}
