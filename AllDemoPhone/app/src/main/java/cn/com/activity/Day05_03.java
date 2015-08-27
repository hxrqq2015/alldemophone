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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cn.com.alldemophone.R;
import cn.com.util.StreamTool;

/**
 * QQ登录_httpclient_get
 * Created by admin on 2015/8/19.
 */
public class Day05_03 extends Activity {
    protected static final int SUCCESS = 1;
    protected static final int ERROR = 2;
    EditText day05_edi_01,day05_edi_02;
    TextView day05_tex__01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day05_03layout);
        day05_edi_01 = (EditText) findViewById(R.id.day05_edi_01);
        day05_edi_02 = (EditText) findViewById(R.id.day05_edi_02);
        day05_tex__01 = (TextView) findViewById(R.id.day05_tex_01);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String result = (String) msg.obj;
            switch (msg.what){
                case SUCCESS:
                    day05_tex__01.setText(result);
                    break;
                case ERROR:
                    day05_tex__01.setText(result);
                    break;
            }
        }
    };

    public void login_hc_get(View v){
        final String username = day05_edi_01.getText().toString().trim();
        final String password =day05_edi_02.getText().toString().trim();
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(Day05_03.this, "用户名或密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(){
            @Override
            public void run() {


                try {
                    String path = "http://188.188.7.23:8080/AllTestWeb/logintest?" +
                            "username="+username+"&password="+ URLEncoder.encode(password, "utf-8");
                    //1.创建出来一个httpclient对象  ，http客户端
                    HttpClient client = new DefaultHttpClient();
                    //2. 定义一个httpget请求
                    HttpGet httpGet = new HttpGet(path);
                    //3. 执行一个请求。
                    HttpResponse res = client.execute(httpGet);
                    //获取状态码
                    int code = res.getStatusLine().getStatusCode();
                    if(code==200){
                        // 获取响应对象中包含的数据实体
                        HttpEntity entity = res.getEntity();
                        //获取实体里面输入流
                        InputStream is = entity.getContent();
                        String result = StreamTool.readStream(is);
                        Message msg = new Message();
                        msg.obj = result;
                        msg.what = SUCCESS;
                        handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    Message msg = new Message();
                    msg.obj = "登录失败，请检查网络!";
                    msg.what=ERROR;
                    handler.sendMessage(msg);
                    e.printStackTrace();
                }

            }
        }.start();
    }

}
