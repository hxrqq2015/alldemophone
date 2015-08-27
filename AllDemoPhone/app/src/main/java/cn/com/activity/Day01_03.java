package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/12.
 */
public class Day01_03 extends Activity {
    Button but1;
    EditText edi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day01_03layout);
        but1= (Button) findViewById(R.id.day01_03_but_01);
        but1.setOnClickListener(new Mybut());
        edi = (EditText) findViewById(R.id.day01_03_edi_01);
    }
    class  Mybut implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(TextUtils.isEmpty(edi.getText())){
                Toast.makeText(Day01_03.this,"请输入手机号码，再拨打!",Toast.LENGTH_SHORT).show();
                return;
            }
            //定义一个意图对象
            Intent intent = new Intent();
            //给意图设置一个动作，系统根据这个动作去执行不同的操作。
            intent.setAction(Intent.ACTION_CALL);

            /**
             * URL: http://www.itheima.com  http://xunlei.com/asdf
             * uri: itheima://zhangsan  tel://10086
             *
             */
            //告诉系统，电话是打给谁的。
            intent.setData(Uri.parse("tel://"+edi.getText()));
            //启动某个界面
            startActivity(intent);
        }
    }
}
