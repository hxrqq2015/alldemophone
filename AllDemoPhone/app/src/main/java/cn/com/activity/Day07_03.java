package cn.com.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/21.
 */
public class Day07_03 extends Activity {
    EditText et_ip;
    SharedPreferences sp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day07_03layout);
        et_ip = (EditText) findViewById(R.id.et_ip);
        sp = getSharedPreferences("config", 0);
        //回显数据
        String number = sp.getString("number","");
        et_ip.setText(number);
    }

    public void save(View v){
        //保存数据
        String number = et_ip.getText().toString();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("number",number);
        editor.commit();
    }
}
