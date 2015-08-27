package cn.com.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import java.net.HttpURLConnection;

import cn.com.alldemophone.R;

/**
 * 查询号码归属地 XML方式服务器向客户端
 * Created by admin on 2015/8/17.
 */
public class Day04_04 extends Activity {
    EditText edi_01;
    TextView tex_01;
    ProgressDialog dialog ;
    private static final int SUCCESS=1;
    private static final int ERROR=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day04_04layout);
        edi_01= (EditText) findViewById(R.id.edi_01);
        tex_01= (TextView) findViewById(R.id.tex_01);
        dialog = new ProgressDialog(this);
        dialog.setMessage("亲，正在拼命加载中~~");

    }

    protected Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            dialog.dismiss();//让对话框消失
            switch (msg.what){
                case SUCCESS:
             //设置显示数据
             String result = (String) msg.obj;
             tex_01.setText(result);
                    break;
                case ERROR:
                    String resulta = (String) msg.obj;
                    Toast.makeText(Day04_04.this, resulta, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public void search(View v){
       final String phonenumber =edi_01.getText().toString().trim();
        if(TextUtils.isEmpty(phonenumber)){
            Toast.makeText(Day04_04.this,"电话号码不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }
        dialog.show();//显示对话框
        new Thread(){
            @Override
            public void run() {


        try {

            String path = "http://www.096.me/api.php?phone="+phonenumber+"&mode=xml";
            //1.定位资源，访问的路径地址
            URL url = new URL(path);
            //2.打开连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            if(200==conn.getResponseCode()){
                InputStream is = conn.getInputStream();
                StringBuilder stringBuilder = new StringBuilder();
                //XML文件解析
                //1.得到pull解析器
                XmlPullParser parser = Xml.newPullParser();
                //2.设置解析源
                parser.setInput(is, "gbk");
                //获取当前的事件类型
                int type = parser.getEventType();
                while (type!=XmlPullParser.END_DOCUMENT){
                    if(type ==XmlPullParser.START_TAG){//如果是开始标签
                        String eventName = parser.getName();
                        if("phonenum".equals(eventName)){
                            String phone = parser.nextText();
                            stringBuilder.append("电话:"+phone+"\r\n");

                        }else if("location".equals(eventName)){
                            String location = parser.nextText();
                            stringBuilder.append("归属地："+location+"\r\n");

                        }else if("phoneJx".equals(eventName)){
                            String phoneJx = parser.nextText();
                            stringBuilder.append("电话运势："+phoneJx+"\r\n");
                        }
                    }
                    type = parser.next();//获取下一个解析的事件
                }
                is.close();
                Message msg = Message.obtain();
                msg.obj = stringBuilder.toString();
                msg.what=SUCCESS;
                handler.sendMessage(msg);
            }
        } catch (Exception e) {
            //如果异常里面也要发送消息，那么要加上what来区分
            Message msg = Message.obtain();
            msg.obj="手机号码查询失败或网络未连接";
                    msg.what=ERROR;
            handler.sendMessage(msg);
            e.printStackTrace();
        }
            }
        }.start();
    }
}
