package cn.com.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import cn.com.alldemophone.R;

/**
 * day09_04界面提醒通知
 * Created by admin on 2015/8/25.
 */
public class Day09_04 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day09_04layout);
    }

    public void start(View v){
/*        //高版本代码
        //得到通知管理者
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //定义一个通知： 标题、内容、小图片、大图片
        Notification noti = new Notification.Builder(this)
                .setContentTitle("我是标题")
                .setContentText("我是内容")
                .setSmallIcon(R.drawable.qq)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.qq))
                .build();
        //显示通知
        manager.notify(1, noti);*/

        //低版本兼容的通知
        //得到通知管理者
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //定义一个通知
        Notification notification = new Notification(
                R.drawable.qq, "你有一条新的未读消息", System.currentTimeMillis());
        //指定跳转的界面
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("10086"));
        //定义一个PendingIntent的对象，里面指定点击之后，跳转到什么界面
        PendingIntent contentIntent =PendingIntent.getActivity(this,1,intent,0);
        //把通知拖拉下来之后显示的内容以及点击之后的去向
        notification.setLatestEventInfo(this,"我是标题", "我是内容", contentIntent);
        //显示通知
        manager.notify(1, notification);
    }
}
