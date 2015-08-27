package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import cn.com.alldemophone.R;
import cn.com.util.StreamTool;

/**
 * QQ登录_get
 * Created by admin on 2015/8/18.
 */
public class Day05_01 extends Activity {
    protected static final int SUCCESS = 1;
    protected static final int ERROR = 2;
    EditText day05_edi_01,day05_edi_02;
    TextView day05_tex__01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day05_01layout);
        day05_edi_01 = (EditText) findViewById(R.id.day05_edi_01);
        day05_edi_02 = (EditText) findViewById(R.id.day05_edi_02);
        day05_tex__01 = (TextView) findViewById(R.id.day05_tex_01);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
                    String result = (String) msg.obj;
            switch (msg.what){
                case SUCCESS:
                    day05_tex__01.setText(result);
                    break;
                case ERROR:
                    day05_tex__01.setText(result);
                   // Toast.makeText(Day05_01.this,"",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    /**
     * 执行登录请求
     * @param v
     */
    public void login_get(View v){
      final   String username =day05_edi_01.getText().toString().trim();
      final   String password = day05_edi_02.getText().toString().trim();
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(Day05_01.this,"用户名或密码不能为空。",Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(){
            @Override
            public void run() {
        try {
            String path = "http://188.188.7.23:8080/AllTestWeb/logintest?" +
                    "username="+username+"&password="+ URLEncoder.encode(password, "utf-8");
            URL url = new URL(path);
          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");//GET必须大写
            conn.setConnectTimeout(5000);
            if(200==conn.getResponseCode()){
                InputStream is = conn.getInputStream();
                String result = StreamTool.readStream(is);
                is.close();
                Message msg = new Message();
                msg.obj=result;
                msg.what=SUCCESS;
                handler.sendMessage(msg);
            }
        } catch (Exception e) {
            Message msg = new Message();
            msg.obj="登录失败，请检查网络!";
            msg.what=ERROR;
            handler.sendMessage(msg);
            e.printStackTrace();
        }
            }
        }.start();

    }
}
