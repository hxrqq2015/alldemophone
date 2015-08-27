package cn.com.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/12.
 */
public class Day02_07 extends Activity {
    CheckBox che ;
    SeekBar seekbar ;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day02_07layout);
        sp=getSharedPreferences("config",0);
        //得到选择框对象
        che = (CheckBox) findViewById(R.id.day02_07_che_01);
        //回显数据
        boolean flag = sp.getBoolean("isheck",false);
        che.setChecked(flag);
        che.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //得到编辑器的对象
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("isheck",isChecked);
                editor.commit();
            }
        });
        //找到seekBar控件
        seekbar = (SeekBar) findViewById(R.id.day02_07_see_01);
        //设置以前保存过的进度值
        int progress = sp.getInt("progress",0);
        seekbar.setProgress(progress);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //获取进度值
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("progress",seekbar.getProgress());
                editor.commit();
            }
        });


    }
}
