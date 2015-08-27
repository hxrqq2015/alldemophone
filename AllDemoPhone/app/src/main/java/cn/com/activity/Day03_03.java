package cn.com.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/12.
 */
public class Day03_03 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day03_03layout);
    }

    // 确定取消对话框
    public  void click01(View v){
        // 1.得到对话框的构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告：");
        builder.setMessage("欲练此功，必先自宫.");
        builder.setPositiveButton("我要自宫", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Day03_03.this, "啊...", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("我要想想",null);
        //创建对话框
        AlertDialog dialog = builder.create();
        // 显示
        dialog.show();
    }
    // 单选对话框
    public void click02(View v){
        // 1.得到对话框的构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择您的性别");
        final String[] items = {"男性", "女性", "未知"};
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Day03_03.this, "选中了：" + items[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消",null);
        builder.show();
    }
    // 多选对话框
    public void click03(View v){
        // 1.得到对话框的构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择您的兴趣爱好");
        final String[] items = {"看书","上网", "学习", "旅游", "运动" };
        final  boolean[] checkedItems={true,false,false,false,false};
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(Day03_03.this, "选中了：" + items[which] + "---isChecked=="
                                + isChecked, Toast.LENGTH_SHORT).show();
                        checkedItems[which] = isChecked;
                    }
                }
        );
        builder.setNegativeButton("取消", null);
        builder.show();
    }
    //进度对话框
    public void click04(View v){
        // 1.得到对话框的构建器
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("提示：");
        progressDialog.setMessage("正在努力加载中...");
        progressDialog.show();
        new Thread(){
            public  void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 过3秒之后，消失对话框
                progressDialog.dismiss();
            }
        }.start();
    }
    //进度条对话框
    public  void click05(View v){
        final ProgressDialog progress =new ProgressDialog(this);
        //指定类型是水平方向的进度对话框
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setMax(100);//设置最大值
        progress.setTitle("提示：");
        progress.setMessage("正在努力加载中...");
        progress.show();
        new Thread(){
            public  void run(){
                try {
                 for(int i=0;i<=100;i++){
                     progress.setProgress(i);
                    sleep(30);
                 }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 过3秒之后，消失对话框
                progress.dismiss();
            }
        }.start();
    }
}
