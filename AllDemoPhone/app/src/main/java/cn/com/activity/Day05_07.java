package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.Header;

import java.io.File;
import java.io.FileNotFoundException;

import cn.com.alldemophone.R;
import cn.com.loopj.android.http.AsyncHttpClient;
import cn.com.loopj.android.http.AsyncHttpResponseHandler;
import cn.com.loopj.android.http.RequestParams;

/**
 * 文件上传
 * Created by admin on 2015/8/19.
 */
public class Day05_07 extends Activity {
    EditText day05_edi_01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day05_07layout);
        day05_edi_01= (EditText) findViewById(R.id.day05_edi_01);
    }

    /**
     * 上传文件
     * @param v
     */
    public void upload(View v){
        String path =day05_edi_01.getText().toString().trim();
        if(TextUtils.isEmpty(path)){
            Toast.makeText(Day05_07.this, "路径不能为空", Toast.LENGTH_SHORT).show();
            return ;
        }

        File file = new File(path);
        //如果文件存在，并且里面真的有内容
        if(file.exists() && file.length()>0){
            try {
                AsyncHttpClient client = new AsyncHttpClient();
                RequestParams params = new RequestParams();
                params.put("file",file);
                String url = "http://188.188.7.23:8080/AllTestWeb/uploadfile";
                client.post(url, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Toast.makeText(Day05_07.this, "上传成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(Day05_07.this, "上传失败", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
