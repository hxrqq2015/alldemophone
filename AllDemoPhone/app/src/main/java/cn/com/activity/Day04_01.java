package cn.com.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import cn.com.alldemophone.R;

/**
 * 网络图片查看器
 * Created by admin on 2015/8/14.
 */
public class Day04_01 extends Activity {
    EditText day04_01_edi01;
    ImageView day04_01_img01;
    private static final int SUCCESS = 1;
    private static final int ERROR = 2;
    ProgressDialog dialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day04_01layout);
        dialog = new ProgressDialog(this);
        dialog.setMessage("亲，正在拼命加载中~~");

        day04_01_edi01= (EditText) findViewById(R.id.day04_01_edi01);
        day04_01_img01 = (ImageView) findViewById(R.id.day04_01_img01);
    }

    //1.定义消息处理器，它的工作是处理子线程发送过来的消息实体
    Handler handler = new Handler(){
        public void handleMessage(Message msg){
            dialog.dismiss();//让对话框消失
            switch (msg.what){
                case SUCCESS://如果是成功，则设置图片
                    Bitmap bitmap = (Bitmap) msg.obj;
                    day04_01_img01.setImageBitmap(bitmap);
                    break;
                case ERROR://如果失败，则显示toast
                    String result = (String) msg.obj;
                    Toast.makeText(Day04_01.this, result, Toast.LENGTH_SHORT).show();
            }
        };
    };

    public void openimage(View v){
        //获取输入的网络地址
       final String path = day04_01_edi01.getText().toString().trim();
        //判断不为空
        if(TextUtils.isEmpty((path))){
            Toast.makeText(Day04_01.this, "地址路径不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        dialog.show();//显示对话框
        new Thread(){
            public void run() {
        //请求图片，然后显示到imageView上
        //统一资源定位符:
        try {
        //1. 定位资源
            URL url= new URL(path);
            //2. 建立连接 转化成一个http的请求
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置执行get请求，默认使用的就是get请求
            connection.setRequestMethod("GET");
            //如果超过了5秒钟还没有连接上服务器，将会抛出请求超时异常
            connection.setConnectTimeout(5000);

            int length = connection.getContentLength();
           String type = connection.getContentType();

            int aa =connection.getResponseCode();
            Log.d("BBBBBBB", aa + "");
            System.out.println("type=="+type+"---length="+length);
            if(200 == connection.getResponseCode()){ //请求成功，没问题
                //3.获取服务器传递过来的输入流
                InputStream is = connection.getInputStream();
                //4.解析输入流，得到一个图片的位图
                Bitmap bitmap = BitmapFactory.decodeStream(is);

                Message msg = new Message();

                msg.what = SUCCESS;
                //指定消息的数据实体是bitmap对象
                msg.obj = bitmap;
                //发送消息到队列 里面去
                handler.sendMessage(msg);

//                //5.设置iamgeView显示的是什么位图
//                day04_01_img01.setImageBitmap(bitmap);
                is.close();
                //Toast.makeText(Day04_01.this,"dianji",Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Message msg = Message.obtain();
            msg.what=ERROR;
            msg.obj ="图片请求失败" ;
            handler.sendMessage(msg);
            e.printStackTrace();
        }
            };
        }.start();
    }
}
