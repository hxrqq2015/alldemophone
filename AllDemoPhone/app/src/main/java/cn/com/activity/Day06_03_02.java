package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/20.
 */
public class Day06_03_02 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_03_02layout);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Day06_03_02.this,"要打开浏览器了",Toast.LENGTH_SHORT).show();
                	/*
                	浏览器中的配置属性
                	<intent-filter>
	                <action android:name="android.intent.action.VIEW" />
	                <category android:name="android.intent.category.DEFAULT" />
	                <category android:name="android.intent.category.BROWSABLE" />
	                <data android:scheme="http" />
	                <data android:scheme="https" />
	                <data android:scheme="about" />
	                <data android:scheme="javascript" />
	            </intent-filter>*/
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
    public void click(View v){
        //Toast.makeText(this, "要打开浏览器了。", 0).show();
    }
}
