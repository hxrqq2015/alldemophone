package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStream;

import cn.com.alldemophone.R;

/**
 * 极光推送， 个推，百度云推送，
 * day10_04随手涂鸦
 * Created by admin on 2015/8/23.
 */
public class Day10_04 extends Activity implements View.OnClickListener{
    ImageView iv;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    float denisity;
    float dpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_04layout);

        findViewById(R.id.red).setOnClickListener(this);
        findViewById(R.id.green).setOnClickListener(this);
        findViewById(R.id.blue).setOnClickListener(this);
        findViewById(R.id.yellow).setOnClickListener(this);
        findViewById(R.id.purple).setOnClickListener(this);
        findViewById(R.id.hei).setOnClickListener(this);
        iv = (ImageView) findViewById(R.id.iv);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
       Display display   =  wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
       dpi= dm.densityDpi;  //160   240
       denisity = dm.density;  //1  1.5 得到像素密度
        System.out.println("dpi==="+dpi+"----denisity==="+denisity);

        bitmap= Bitmap.createBitmap(720, 888, Bitmap.Config.ARGB_8888);

        //创建画布
        canvas = new Canvas(bitmap);
        //为了让画布是白色的背景，所以一上来就画一遍颜色。
        canvas.drawColor(Color.WHITE);
        //创建画笔
        paint = new Paint();
        //设置画笔的粗细，宽度 默认是5大小
        paint.setStrokeWidth(5);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                //设置画笔的粗细，宽度
                paint.setStrokeWidth(progress);
                Toast.makeText(Day10_04.this,"当前画笔粗细值："+progress,Toast.LENGTH_SHORT).show();
            }
        });
        //要想在下面的imageview上显示线条，作画，那么必须对其进行触摸事件监听
        iv.setOnTouchListener(new View.OnTouchListener() {


            float startX, startY;
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {//处于按下的动作
                    case MotionEvent.ACTION_DOWN:
                       startX =event.getX()/denisity;

                       startY =event.getY()/denisity;
                        System.out.println("down----"+startX+"-"+startY);
                        break;
                    case MotionEvent.ACTION_MOVE://移动的动作
                      float moveX = event.getX()/denisity;
                     float moveY = event.getY()/denisity;

                        //一边移动，一边画线条
                        canvas.drawLine(startX, startY, moveX, moveY, paint);
                        //canvas.drawCircle(cx, cy, radius, paint) 画圆
                        //一边作画，一边显示。
                        iv.setImageBitmap(bitmap);
                        //每次显示完毕，都重新刷新起始位置
                        startX =moveX;
                        startY =moveY;
                        System.out.println("move----"+moveX+"-"+moveY);
                        break;
                    case MotionEvent.ACTION_UP://手指弹起的动作
                        System.out.println("up----");
                        break;

                }
                //false，代表的是这个监听器并不会消费这个事件，这个事件到此并没有结束，系统还是回把这个手指的触摸向下传递
                //true :当前监听器要消费这个时间，系统不会再往下传递，事件到此结束
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_settings){
            try {
                //保存图片到SD卡里面 ，由于图像是显示到了bitmap里面，所以接下来要保存的就是bitmap

                //指定图像保存到SD卡
                OutputStream os = new FileOutputStream(Environment.getExternalStorageDirectory()+"/"+
                        System.currentTimeMillis()+".jpg");
                //保存位图图像
                /**
                 * 保存图像
                 * 1. 保存的图片类型
                 * 2. 保存图片的压缩质量 100，表示高精度
                 * 3. 图片输出的位置，保存到哪里。
                 */
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,os);
                //一旦图片保存成功，就发送出来一个广播，这个广播是SD卡被挂载的广播 ，欺骗一下系统，让它重新扫描SD卡
                Intent intent = new Intent();
                //sd卡被挂载
                intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
                intent.setData(Uri.parse("file://"));
                sendBroadcast(intent);
                Toast.makeText(this,"保存图片成功", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this,"保存图片失败", Toast.LENGTH_SHORT).show();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
     //清空画布
    public void qingkong(View v){
        canvas.drawColor(Color.WHITE);
        iv.setImageBitmap(bitmap);
    }
    @Override
    public void onClick(View v) {
        String str = "";
        switch (v.getId()) {
            case R.id.red://选中了红色
                str= "红色";
                paint.setColor(Color.RED);
                break;
            case R.id.green://选中了绿色
                str= "绿色";
                paint.setColor(Color.GREEN);
                break;
            case R.id.blue://选中了蓝色
                str= "蓝色";
                paint.setColor(Color.BLUE);
                break;
            case R.id.yellow://选中了 黄色  0xFFFFFF00
                str= "黄色";
                paint.setColor(Color.YELLOW);
                break;
            case R.id.purple://选中了紫色
                str= "紫色";
                paint.setColor(0xffff00ff);
                break;
            case R.id.hei://选中了黑色
                str= "黑色";
                paint.setColor(Color.BLACK);
                break;
        }
        Toast.makeText(this	,"当前的画笔颜色是："+str, Toast.LENGTH_SHORT).show();
    }
}
