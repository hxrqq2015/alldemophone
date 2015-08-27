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

import cn.com.alldemophone.R;
import cn.com.loopj.android.http.AsyncHttpClient;
import cn.com.loopj.android.http.AsyncHttpResponseHandler;
import cn.com.loopj.android.http.RequestParams;

/**
 * QQ登录_开源框架_post
 * Created by admin on 2015/8/19.
 */
public class Day05_06 extends Activity {
    protected static final int SUCCESS = 1;
    protected static final int ERROR = 2;
    EditText day05_edi_01,day05_edi_02;
    TextView day05_tex__01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day05_06layout);
        day05_edi_01 = (EditText) findViewById(R.id.day05_edi_01);
        day05_edi_02 = (EditText) findViewById(R.id.day05_edi_02);
        day05_tex__01 = (TextView) findViewById(R.id.day05_tex_01);
    }

    public void login_ky_post(View v){
        final String username = day05_edi_01.getText().toString().trim();
        final String password =day05_edi_02.getText().toString().trim();
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(Day05_06.this, "用户名或密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }

        String path = "http://188.188.7.23:8080/AllTestWeb/logintest";
        //定义一个异步的http请求客户端
        AsyncHttpClient client = new AsyncHttpClient();
        //定义传递的参数数据，
        RequestParams params = new RequestParams();
        params.add("username",username);
        params.add("password",password);
        //执行一个post请求
        client.post(path, params, new AsyncHttpResponseHandler() {
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


    }


}
