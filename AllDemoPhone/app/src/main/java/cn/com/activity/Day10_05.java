package cn.com.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import cn.com.alldemophone.R;

/**
 * 撕衣服
 * Created by admin on 2015/8/24.
 */
public class Day10_05 extends Activity {
    Bitmap copyBitmap;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_05layout);

        iv = (ImageView) findViewById(R.id.pre);
        // 1.得到原图
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pre);
        // 2.创建拷贝图片
        copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(),
                srcBitmap.getHeight(),srcBitmap.getConfig());
        // 3.定义画板
        Canvas canvas = new Canvas(copyBitmap);
        // 4.开始作画
        canvas.drawBitmap(srcBitmap,new Matrix(),new Paint());
        // 5.显示图片
        iv.setImageBitmap(copyBitmap);
        // 6.为了能够让手指移动的时候。路过的像素点都变成了透明的，那么必须对imageView进行触摸事件监听
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        try {
                            if (x >= 0 && y >= 0) {
                                for (int i = -15; i < 16; i++) {
                                    for (int j = -15; j < 16; j++) {
                                        // 用于判定当前的按下点是否位于圆内
                                        if (Math.sqrt(i * i + j * j) <= 15) {
                                            // 通过这个方法设置指定的像素点颜色。
                                            copyBitmap.setPixel(x + i, y + j,
                                                    Color.TRANSPARENT);
                                            // 设置完像素点的颜色后，要马上更新显示图片。
                                            iv.setImageBitmap(copyBitmap);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x2 = (int) event.getX();
                        int y2 = (int) event.getY();
                        if (x2 >= 0 && y2 >= 0) {

                            try {
                                for (int i = -15; i < 16; i++) {
                                    for (int j = -15; j < 16; j++) {
                                        if (Math.sqrt(i * i + j * j) <= 15) {
                                            // 通过这个方法设置指定的像素点颜色。
                                            copyBitmap.setPixel(x2 + i, y2 + j,
                                                    Color.TRANSPARENT);
                                            // 设置完像素点的颜色后，要马上更新显示图片。
                                            iv.setImageBitmap(copyBitmap);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                        break;
                    case MotionEvent.ACTION_UP:

                        break;

                    default:
                        break;
                }
                return true;
            }
        });

    }
}
