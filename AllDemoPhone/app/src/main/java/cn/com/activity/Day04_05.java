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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import cn.com.alldemophone.R;
import cn.com.util.StreamTool;

/**
 * 天气查询 json方式服务器向客户端
 * Created by admin on 2015/8/17.
 */
public class Day04_05 extends Activity{
    EditText edi_01;
    TextView tex_01;
    protected static final int SUCCESS = 1;
    protected static final int ERROR_CITY = 2;
    protected static final int ERROR = 3;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day04_05layout);
        edi_01 = (EditText) findViewById(R.id.edi_01);
        tex_01 = (TextView) findViewById(R.id.tex_01);
        dialog =new ProgressDialog(this);
        dialog.setMessage("亲，正在拼命加载中~~");
    }

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            dialog.dismiss();//让对话框消失
            switch (msg.what){
                case SUCCESS:
                    try {
                        JSONArray array= (JSONArray) msg.obj;
                        JSONObject obj0 = (JSONObject) array.get(0);
                        JSONObject obj1= (JSONObject) array.get(1);
                        JSONObject obj2 = (JSONObject) array.get(2);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(obj0+"\r\n");
                        stringBuilder.append(obj1+"\r\n");
                        stringBuilder.append(obj2+"\r\n");
                        tex_01.setText(stringBuilder);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case ERROR_CITY:
                    Toast.makeText(Day04_05.this,"非法的城市名称",Toast.LENGTH_SHORT).show();
                    break;
                case  ERROR:
                    Toast.makeText(Day04_05.this,"查询失败",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    public void serachweath(View v){
       final String city = edi_01.getText().toString().trim();
        if(TextUtils.isEmpty(city)){
            Toast.makeText(Day04_05.this,"城市名称不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        dialog.show();//显示对话框
        new Thread(){
            @Override
            public void run() {


        try {
            String path = "http://wthrcdn.etouch.cn/weather_mini?city="+ URLEncoder.encode(city);
            URL url = new URL(path);
           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            if(200==conn.getResponseCode()){
                InputStream is = conn.getInputStream();
                String result = StreamTool.readStream(is);
                // 指定解析的是哪一个字符串
                JSONObject jsonObject = new JSONObject(result);
                String desc = jsonObject.getString("desc");
                int status = jsonObject.getInt("status");
                if(status==1000){// 正常请求，没问题
                    JSONObject dataObj = jsonObject.getJSONObject("data");
                    JSONArray array = dataObj.getJSONArray("forecast");
                    Message msg = Message.obtain();
                    msg.obj = array;
                    msg.what = SUCCESS;
                    handler.sendMessage(msg);
                }else if(status ==1002){// 非法的城市名称
                    Message msg = Message.obtain();
                    msg.what = ERROR_CITY;
                    handler.sendMessage(msg);
                }
                is.close();
            }
        }  catch (Exception e) {
            Message msg = Message.obtain();
            msg.what =ERROR;
            handler.sendMessage(msg);
            e.printStackTrace();
        }

            }
        }.start();
    }
}
