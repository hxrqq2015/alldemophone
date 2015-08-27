package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/19.
 */
public class Day06_01_02 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_01_02layout);
        TextView tv_result = (TextView) findViewById(R.id.tv_result);
        ImageView iv = (ImageView) findViewById(R.id.icon);

        //获取启动当前界面的intent对象
        Intent intent = getIntent();

	/*	//获取单一的数据
		获取上一个界面传递过来的数据
		String name = intent.getStringExtra("name");
		int gender = intent.getIntExtra("gender", R.id.rb_male);*/

        //获取打包的数据
        Bundle data = intent.getBundleExtra("bundle");
        String name = data.getString("name");
        int gender = data.getInt("gender",R.id.rb_male);
        Bitmap bitmap = intent.getParcelableExtra("icon");
        //显示上一个界面传递过来的图片
        iv.setImageBitmap(bitmap);
        byte [] bytes = null ;
        try {
            if(gender ==R.id.rb_male){ //男性
                bytes = name.getBytes(); //以UTF-8的编码获取字节
            }else if(gender == R.id.rb_female){
                bytes = name.getBytes("GBK"); //以gbk的编码获取字节
            }else if(gender == R.id.rb_unkonw){
                bytes = name.getBytes("ISO-8859-1"); //以ISO-8859-1的编码获取字节
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int total = 0 ;
        for (byte b : bytes) {
            //把bayte字节转化成了int类型 取绝对值
            total+= Math.abs(b&0xff);
        }

        int value  = total%100;


        String str = "";
        if(value > 90){
            str = "姓名："+name+"\r\n人品得分："+value+"\r\n评价：你是世人的榜样！";
        }else if(value > 70){
            str = "姓名："+name+"\r\n人品得分："+value+"\r\n评价：你的人品不错..应该一表人才吧?";
        }else if(value > 50){
            str = "姓名："+name+"\r\n人品得分："+value+"\r\n评价：你的人品勉勉强强..要自己好自为之";
        }else if(value > 30){
            str = "姓名："+name+"\r\n人品得分："+value+"\r\n评价：你的人品太差了..稍不小心就会去干坏事了吧?";
        }else{
            str = "姓名："+name+"\r\n人品得分："+value+"\r\n评价：对不起，我不该跟你谈人品。";
        }


        tv_result.setText(str);
    }
}
