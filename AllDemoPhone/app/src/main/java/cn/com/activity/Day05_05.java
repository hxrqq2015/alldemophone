package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.Header;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cn.com.alldemophone.R;
import cn.com.loopj.android.http.AsyncHttpClient;
import cn.com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * QQ登录_开源框架_get
 * Created by admin on 2015/8/19.
 */
public class Day05_05 extends Activity {
    protected static final int SUCCESS = 1;
    protected static final int ERROR = 2;
    EditText day05_edi_01,day05_edi_02;
    TextView day05_tex__01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day05_05layout);
        day05_edi_01 = (EditText) findViewById(R.id.day05_edi_01);
        day05_edi_02 = (EditText) findViewById(R.id.day05_edi_02);
        day05_tex__01 = (TextView) findViewById(R.id.day05_tex_01);
    }

    public void login_ky_get(View v){
        final String username = day05_edi_01.getText().toString().trim();
        final String password =day05_edi_02.getText().toString().trim();
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(Day05_05.this, "用户名或密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            String path = "http://188.188.7.23:8080/AllTestWeb/logintest?" +
                    "username="+username+"&password="+ URLEncoder.encode(password, "utf-8");
            //定义一个异步的http请求客户端
            AsyncHttpClient client = new AsyncHttpClient();
            //执行一个get请求
            client.get(path, new AsyncHttpResponseHandler() {
                //请求执行成功的时候调用  能访问到服务器，但是有可能返回404 ，500内部错误
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    try {
                        day05_tex__01.setText(new String(responseBody , "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                //请求执行失败的时候调用
                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    try {
                        day05_tex__01.setText(new String(responseBody , "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
