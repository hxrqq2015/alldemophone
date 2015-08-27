package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.com.alldemophone.R;
/**
 * Created by admin on 2015/8/20.
 */
public class Day06_05 extends Activity {
    EditText et_content,day06_edi_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_05layout);
        et_content = (EditText) findViewById(R.id.et_content);
        day06_edi_01= (EditText) findViewById(R.id.day06_edi_01);
        Intent intent=getIntent();
        String sms = intent.getStringExtra("sms");
        if(sms !=null){
            et_content.setText(sms);
        }
       // et_content.setText(sms);
        String smsa = intent.getStringExtra("smsa");
        if(smsa !=null){
            day06_edi_01.setText(smsa);
        }
       // day06_edi_01.setText(smsa);
    }
    //选择短信模板
    public void selectSms(View v){
        Intent intent = new Intent(Day06_05.this,Day06_05_01.class);
        //		startActivity(intent); 有去无回的启动
        //1. 启动下一个界面，并且等待结果的返回
        startActivityForResult(intent, 2);
    }

    //选择联系人
    public void selectContact(View v){
        Intent intent = new Intent(this , Day06_05_02.class);
//		startActivity(intent); 有去无回的启动
        //1. 启动下一个界面，并且等待结果的返回
        startActivityForResult(intent, 2) ;
    }
public void sendSms(View v){
    String aa =et_content.getText().toString().trim();
    String bb =day06_edi_01.getText().toString().trim();
    if(TextUtils.isEmpty(aa) || TextUtils.isEmpty(bb)){
        Toast.makeText(Day06_05.this,"发送号码或发送内容不能为空。",Toast.LENGTH_SHORT).show();
        return;
    }
    et_content.setText("");
    day06_edi_01.setText("");
    Toast.makeText(Day06_05.this,"短信已发送。",Toast.LENGTH_SHORT).show();

}
    //回调方法，返回值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1://短信请求已经返回数据了
                break;
            case 2://联系人的数据返回了。
                break;
        }
        if(data !=null){
            String sms = data.getStringExtra("sms");
            if(sms !=null){
                et_content.setText(sms);
            }
           // System.out.println("数据已经回来了。。。。。"+sms);
            String smsa = data.getStringExtra("smsa");
            if(smsa !=null){
                day06_edi_01.setText(smsa);
            }

        }
    }
}
