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
public class Day06_04 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_04layout);

    }

    public void share(View v){
        	/*	发送信息的属性
        	<intent-filter>
            <action android:name="android.intent.action.VIEW" />
            <action android:name="android.intent.action.SENDTO" />
            <category android:name="android.intent.category.DEFAULT" />
            <category android:name="android.intent.category.BROWSABLE" />
            <data android:scheme="sms" />
            <data android:scheme="smsto" />
         </intent-filter>*/
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SENDTO");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("android.intent.category.BROWSABLE");
        //指定收件人
        intent.setData(Uri.parse("smsto:"));
        intent.putExtra("sms_body", "推荐您使用一款应用，非常的有意思，这款应用叫做：人品计算器。是由高大上的黑马训练营学员开发的，" +
                "应用的下载地址是：http://www.itheima.com");

        startActivity(intent);
    }

    public void staron(View v){
        Intent intent = new Intent(this,Day06_05.class);
        startActivity(intent);

    }
}
