package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import cn.com.alldemophone.R;
import cn.com.util.StreamTool;

/**
 * QQ登录_post
 * Created by admin on 2015/8/18.
 */
public class Day05_02 extends Activity {
    protected static final int SUCCESS = 1;
    protected static final int ERROR = 2;
    EditText day05_edi_01,day05_edi_02;
    TextView day05_tex__01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day05_02layout);
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
                case  ERROR:
                    day05_tex__01.setText(result);
                    break;
            }
        }
    };

    /**
     * 执行登录请求
     * @param v
     */
    public void login_post(View v){
       final String username = day05_edi_01.getText().toString().trim();
       final String password =day05_edi_02.getText().toString().trim();
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(Day05_02.this,"用户名或密码不能为空!",Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(){
            @Override
            public void run() {
                try {
                    String path = "http://188.188.7.23:8080/AllTestWeb/logintest";
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //指定使用POST请求
                    conn.setRequestMethod("POST");
                    conn.setConnectTimeout(5000);

                    //事先定义好传递给服务器的数据
                    String data = "username="+username+"&password="+password;
                    //  指定content-type -实际上就是指定传输的数据类型
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    //指定content-length Content-Length: 21
                    conn.setRequestProperty("Content-Length", data.length()+"");
                    //打开输出流  告诉服务器，我要写数据了
                    conn.setDoOutput(true);
                    //开始写数据
                    OutputStream os = conn.getOutputStream();
                    os.write(data.getBytes());
                    os.close();

                    if(200==conn.getResponseCode()){
                        InputStream is = conn.getInputStream();
                        String resutl = StreamTool.readStream(is);
                        is.close();
                        Message msg = new Message();
                        msg.obj = resutl;
                        msg.what = SUCCESS;
                        handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    Message msg = new Message();
                    msg.obj = "登录失败，请检查网络!";
                    msg.what =ERROR;
                    handler.sendMessage(msg);
                    e.printStackTrace();
                }

            }
        }.start();
    }
}
