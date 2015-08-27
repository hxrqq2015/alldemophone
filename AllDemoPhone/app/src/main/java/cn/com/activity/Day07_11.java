package cn.com.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/21.
 */
public class Day07_11 extends Activity {
    EditText et_path ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day07_11layout);
        et_path = (EditText) findViewById(R.id.path);

    }

    public void play(View v){
        String path = et_path.getText().toString();
        if(TextUtils.isEmpty(path)){
            Toast.makeText(this, "地址路径不能为空", Toast.LENGTH_SHORT).show();
            return ;
        }

        File file = new File(path);
        if(!file.exists()){
            Toast.makeText(this, "非法的文件路径。",  Toast.LENGTH_SHORT).show();
            return ;
        }

        Day07_11_01.PATH = path;
        //开始播放音乐
        Intent service = new Intent(this , Day07_11_01.class);
        service.putExtra("code", 1);
        startService(service);
    }

    public void pause(View v){
        Intent service = new Intent(this , Day07_11_01.class);
        service.putExtra("code", 2);
        startService(service);
    }

    public void stop(View v){
        Intent service = new Intent(this , Day07_11_01.class);
        service.putExtra("code", 3);
        startService(service);
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("提醒");
        dialog.setMessage("是否继续播放音乐?");
        dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent service = new Intent(Day07_11.this, Day07_11_01.class);
                stopService(service);
                finish();
            }
        });
        dialog.show();
    }
}
