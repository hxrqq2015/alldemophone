package cn.com.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import cn.com.alldemophone.R;

/**
 * day09_02银行行长
 * Created by admin on 2015/8/25.
 */
public class Day09_02 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day09_02layout);
    }
    /**
     * 对数据库进行增加操作
     *
     * @param v
     */
    public void insert(View v){
        // 内部程序使用content provider (内容提供者)暴露出来数据
        // 其他程序想让它工作，必须用ContentResolver（内容解析者） 去操作它

        // 获取到内容解析者
        ContentResolver resolver = getContentResolver();
        // 定义访问的口令 必须加上前缀 content://
        Uri uri = Uri.parse("content://cn.com.activity.Day09_01_02/account");

        ContentValues values = new ContentValues();
        values.put("name","zhangsan");
        values.put("money", 100000);
        // 让内容提供者去执行添加的方法
        resolver.insert(uri, values);
    }

    /**
     * 对数据库进行删除操作
     * @param v
     */
    public void delete(View v){
        // 获取到内容解析者
        ContentResolver resolver = getContentResolver();
        // 定义访问的口令 必须加上前缀 content://
        Uri uri = Uri.parse("content://cn.com.activity.Day09_01_02/account");
        resolver.delete(uri, "name=?", new String[]{"zhangsan"});
    }
    /**
     * 对数据库进行更新操作
     * @param v
     */
    public void update(View v){
        // 获取到内容解析者
        ContentResolver resolver = getContentResolver();
        // 定义访问的口令 必须加上前缀 content://
        Uri uri = Uri.parse("content://cn.com.activity.Day09_01_02/account");
        ContentValues values = new ContentValues();
        values.put("money",100);
        resolver.update(uri, values, "name=?", new String[]{"zhangsan"});
    }
    /**
     * 对数据库进行查询操作
     * @param v
     */
    public void query(View v){
        // 获取到内容解析者
        ContentResolver resolver = getContentResolver();
        // 定义访问的口令 必须加上前缀 content://
        Uri uri = Uri.parse("content://cn.com.activity.Day09_01_02/account");

        Cursor cursor = resolver.query(uri,null,null,null,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int money = cursor.getInt(cursor.getColumnIndex("money"));
            System.out.println("id==="+id+"--name-==="+name+"--money==="+money);
        }
        cursor.close(); //要记得关闭
    }
}
