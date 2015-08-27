package cn.com.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import cn.com.alldemophone.MainActivity;
import cn.com.alldemophone.R;

/**
 * day09_05装X神奇
 * Created by admin on 2015/8/25.
 */
public class Day09_05 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day09_05layout);
    }

    public void click(View v){
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 需求： 1. 给短信数据库添加一条到来的短信--农业银行
                // 2. 发送一个通知，然后点击通知之后，跳转到短信的列表界面
                ContentResolver resolver = getContentResolver();
                ContentValues values = new ContentValues();
                // 添加短信
                values.put("address", "95599");
                values.put("date", System.currentTimeMillis());
                values.put("type", 1);
                values.put("body",
                        "尊敬的张先生,您的尾号8976的VIP金卡收到了一笔网银转账交易，金额为：3,000,000.00 , "
                                + "当前的活期余额为: 860,800,900,00,感谢您使用中国农业银行.【农业银行深圳支行】");
                // 定义Uri， 如果不会写，详见day06中的上层应用源代码中的provider/ telephonyprovider
                Uri uri = Uri.parse("content://sms");
                resolver.insert(uri, values);
                // 低版本兼容的通知
                // 得到通知管理者
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // 定义一个通知
                Notification notification = new Notification(R.drawable.qq,
                        "你有一条新的短信消息", System.currentTimeMillis());
                // 指定跳转的界面
                Intent intent = new Intent();
                intent.setClassName("com.android.mms", "com.android.mms.ui.ConversationList");
                // 定义一个PendingIntent的对象，里面指定点击之后，跳转到什么界面
                PendingIntent contentIntent = PendingIntent.getActivity(Day09_05.this, 1,
                        intent, 0);
                // 把通知拖拉下来之后显示的内容以及点击之后的去向
                notification.setLatestEventInfo(Day09_05.this, "95599", "尊敬的张先生,您的尾号8976的VIP金卡收到了一笔网银转账交易，金额为：3,000,000.00 , "
                        + "当前的活期余额为: 860,800,900,00,感谢您使用中国农业银行.【农业银行深圳支行】", contentIntent);

                // 显示通知
                manager.notify(1, notification);

            }
        }.start();
    }
}
