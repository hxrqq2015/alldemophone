package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import java.io.File;

import cn.com.alldemophone.R;


/**
 * 多线程下载开源框架
 * Created by admin on 2015/8/19.
 */
public class Day05_10 extends Activity {
    private static final int THREAD_COUNT = 3; //线程个数是3个
    EditText day05_edi_01;
    String path;
    ProgressBar pb1 , pb2 , pb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day05_10layout);
        day05_edi_01= (EditText) findViewById(R.id.day05_edi_01);
        pb1 = (ProgressBar) findViewById(R.id.pb1);
        pb2 = (ProgressBar) findViewById(R.id.pb2);
        pb3 = (ProgressBar) findViewById(R.id.pb3);
    }
    public void dowload(View v){
        path =day05_edi_01.getText().toString();

        HttpUtils utils = new HttpUtils();
         utils.download(path,getFileName(path),true,new RequestCallBack<File>(){


             @Override
             public void onSuccess(ResponseInfo<File> responseInfo) {
                 Toast.makeText(Day05_10.this, "下载完成", Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onFailure(HttpException error, String msg) {
                 Toast.makeText(Day05_10.this, "下载失败："+msg, Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onLoading(long total, long current, boolean isUploading) {
                 super.onLoading(total, current, isUploading);

                 pb1.setMax((int) total);
                 pb1.setProgress((int) current);
             }

         });
    }



    /**
     * 获取文件的名字
     * @param path
     * @return
     */
    public  String getFileName(String path){
        int index = path.lastIndexOf("/")+1;

        //  Environment.getExternalStorageDirectory().toString()+"/" 等于  /storage/sdcard/
        return  Environment.getExternalStorageDirectory().toString()+"/"+path.substring(index);
    }
}
