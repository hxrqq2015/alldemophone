package cn.com.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import cn.com.alldemophone.MainActivity;
import cn.com.alldemophone.R;
import cn.com.util.StreamTool;

/**
 * 网页源码查看器
 * Created by admin on 2015/8/17.
 */
public class Day04_03 extends Activity {
    protected final static int SUCCESS =1;
    protected final  static int ERROR =2;
    EditText edi01;
    TextView tex01;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day04_03layout);
        edi01 = (EditText) findViewById(R.id.edi_01);
        tex01 = (TextView) findViewById(R.id.tex_01);

        dialog = new ProgressDialog(this);
        dialog.setMessage("正在拼命加载中...");
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            dialog.dismiss();
            String result = (String) msg.obj;
            switch (msg.what){
                case SUCCESS:
                    tex01.setText(result);
                    break;
                case  ERROR:
                    Toast.makeText(Day04_03.this, result, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public void getsource(View v){
        final String path =edi01.getText().toString().trim();
        if(TextUtils.isEmpty(path)){
            Toast.makeText(this,"输入框不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(){
            @Override
            public void run() {
                try {
                    //1.定位资源
                    URL url = new URL(path);
                    //2.建立连接
                    HttpURLConnection conn = (HttpURLConnection ) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    //3.判断返回的状态码
                    if(200==conn.getResponseCode()){//请求成功
                        InputStream is= conn.getInputStream();//获取服务器返回客户端的输入流
                        //转化输入流成字符串
                        String result = StreamTool.readStream(is);
                        Message msg = Message.obtain();
                        msg.obj = result;
                        msg.what=SUCCESS;
                        handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    Message msg = Message.obtain();
                    msg.obj = "请求失败...";
                    msg.what=ERROR;
                    handler.sendMessage(msg);
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
