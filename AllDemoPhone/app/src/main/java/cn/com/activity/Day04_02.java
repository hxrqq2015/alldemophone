package cn.com.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import cn.com.alldemophone.R;


/**
 * 02子线程更新UI
 * Created by admin on 2015/8/14.
 */
public class Day04_02 extends Activity {
    ImageView iv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day04_02layout);
        tv = (TextView) findViewById(R.id.tex_01);
        iv = (ImageView) findViewById(R.id.ima_01);

        new Thread(){
            @Override
            public void run() {
                for (int i=5;i>0;i--){
                    //定义消息实体
                    Message msg = new Message();
                    msg.obj="子线程更新UI----"+i;
                    if(i==5){
                        msg.what=1;
                    }else if(i==4){
                        msg.what=2;
                    }else if(i==3){
                        msg.what=3;
                    }else if(i==2){
                        msg.what=4;
                    }else if(i==1){
                        msg.what=5;
                    }
                    //2.发送消息实体，发送到消息队列里面去。
                    handler.sendMessage(msg);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
                //获取消息实体里面数据
                String  result = (String) msg.obj;
                //设置显示图片
            tv.setText(result);
            switch (msg.what){
                case 1:
                    iv.setImageResource(R.drawable.number_005);
                    break;
                case 2:
                    iv.setImageResource(R.drawable.number_004);
                    break;
                case 3:
                    iv.setImageResource(R.drawable.number_003);
                    break;
                case 4:
                    iv.setImageResource(R.drawable.number_002);
                    break;
                case 5:
                    iv.setImageResource(R.drawable.number_001);
                    break;
            }
        }
    };
}
