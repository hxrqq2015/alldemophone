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
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cn.com.alldemophone.R;
import cn.com.util.StreamTool;

/**
 * QQ登录_httpclient_post
 * Created by admin on 2015/8/19.
 */
public class Day05_04 extends Activity {
    protected static final int SUCCESS = 1;
    protected static final int ERROR = 2;
    EditText day05_edi_01,day05_edi_02;
    TextView day05_tex__01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day05_04layout);
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
    public void login_hc_post(View v){
        final String username = day05_edi_01.getText().toString().trim();
        final String password =day05_edi_02.getText().toString().trim();
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(Day05_04.this, "用户名或密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }

        new   Thread(){
            @Override
            public void run() {
                try {
                    String path = "http://188.188.7.23:8080/AllTestWeb/logintest";

                    //1.创建出来一个httpclient对象  ，http客户端
                    HttpClient client = new DefaultHttpClient();
                    //2. 定义一个httppost请求
                    HttpPost request = new HttpPost(path);
                    //定义传递给服务器的键值对数据。
                    List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                    pairs.add(new BasicNameValuePair("username",username));
                    pairs.add(new BasicNameValuePair("password",password));
                    //定义一个url编码过的form表单实体 ,要对中文数据进行编码。
                    HttpEntity httpEntity = new UrlEncodedFormEntity(pairs,"utf-8");
                    //给服务器传输的数据实体
                    request.setEntity(httpEntity);
                    //执行一个请求。
                    HttpResponse res = client.execute(request);
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
