package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import cn.com.alldemophone.R;

/**
 *在布局里面指定onClick属性
 *方法一定要有一个View对象参数---不建议使用
 * Created by admin on 2015/8/12.
 */
public class Day02_06 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day02_06layout);
    }

    /**
     * 在本应用的内部空间生成一个文件
     * @param v
     */
    public void createPrivate(View v){
        File file = new File(getFilesDir(),"private.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("在本应用的内部空间生成一个文件".getBytes());
            fos.close();
            Toast.makeText(Day02_06.this,"生成一个文件",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成公开的文件
     * @param v
     */
    public void createPublic(View v){
        try {
            FileOutputStream fos = openFileOutput("public.txt",
                    MODE_WORLD_READABLE + MODE_WORLD_WRITEABLE);
            fos.write("生成公开的文件".getBytes());
            fos.close();
            Toast.makeText(Day02_06.this,"生成公开的文件",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 只写
     * @param v
     */
    public void createWriteOnly(View v){
        try {
            FileOutputStream fos = openFileOutput("writeOnly.txt",MODE_WORLD_WRITEABLE);
            fos.write("只写".getBytes());
            fos.close();
            Toast.makeText(Day02_06.this,"生成只写的文件",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 只读
     * @param v
     */
    public void createReadOnly(View v){
        try {
            FileOutputStream fos = openFileOutput("readOnly.txt",MODE_WORLD_READABLE);
            fos.write("只读".getBytes());
            fos.close();
            Toast.makeText(Day02_06.this,"生成只读的文件",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
