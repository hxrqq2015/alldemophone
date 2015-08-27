package cn.com.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cn.com.alldemophone.R;

/**
 * day09_03短信内容提供者
 * Created by admin on 2015/8/25.
 */
public class Day09_03 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day09_03layout);

    }
    /**
     * 关注的字段只有  address  date   type  body
     * 添加短信
     * @param v
     */
    public void insert(View v){
        // 获取到内容解析者
        ContentResolver resolver =getContentResolver();
        ContentValues values = new ContentValues();
        //添加短信
        values.put("address", "110");
        values.put("date", System.currentTimeMillis());
        values.put("type", 1);
        values.put("body", "恭喜您，荣获好市民奖，希望您在以后的生活，勇于和敢于扶老奶奶过马路。");
        //定义Uri， 如果不会写，详见day06中的上层应用源代码中的provider/ telephonyprovider
        Uri uri = Uri.parse("content://sms");
        resolver.insert(uri, values);
        Toast.makeText(this,"短信添加成功。",Toast.LENGTH_SHORT).show();
    }
    //删除短信
    public void delete(View v){
        // 获取到内容解析者
        ContentResolver resolver = getContentResolver();
        Uri uri = Uri.parse("content://sms");
        resolver.delete(uri,"address=?",new String[]{"110"});
        Toast.makeText(this,"短信删除成功。",Toast.LENGTH_SHORT).show();
    }

}
