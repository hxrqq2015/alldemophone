package cn.com.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import cn.com.alldemophone.R;

/**
 * 调色板
 * Created by admin on 2015/8/24.
 */
public class Day10_06 extends Activity {
    Matrix matrix;
    Paint paint;
    Bitmap bitmap;
    Bitmap copytBitmap;
    Canvas canvas;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_06layout);

        iv = (ImageView) findViewById(R.id.iv);
        // 1.得到原图
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tp1);
        // 2.得到拷贝图片
        copytBitmap = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
        // 定义画布
        final Canvas canvas = new Canvas(copytBitmap);
        // 定义矩阵
        matrix = new Matrix();
        // 定义画笔
        paint = new Paint();
        // 开始作画
        canvas.drawBitmap(bitmap, matrix, paint);
        // 显示画好的图片
        iv.setImageBitmap(copytBitmap);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float result = seekBar.getProgress()/50.0f;
                System.out.println("当前的色彩比例是：" + result);
                // 定义一个颜色矩阵
                ColorMatrix cm = new ColorMatrix();
                cm.set(new float[] {
                        1 * result, 0, 0, 0, 0, // red
                        0, 1, 0, 0, 0, // green
                        0, 0, 1, 0, 0, // blue
                        0, 0, 0, 1, 0 // alfa
                });
                paint.setColorFilter(new ColorMatrixColorFilter(cm));
                // 开始作画
                canvas.drawBitmap(bitmap,matrix,paint);
                // 显示画好的图片
                iv.setImageBitmap(copytBitmap);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                float result = seekBar.getProgress()/50.0f;
//                System.out.println("当前的色彩比例是：" + result);
//                // 定义一个颜色矩阵
//                ColorMatrix cm = new ColorMatrix();
//                cm.set(new float[] {
//                        1 * result, 0, 0, 0, 0, // red
//                        0, 1, 0, 0, 0, // green
//                        0, 0, 1, 0, 0, // blue
//                        0, 0, 0, 1, 0 // alfa
//                });
//                paint.setColorFilter(new ColorMatrixColorFilter(cm));
//                // 开始作画
//                canvas.drawBitmap(bitmap,matrix,paint);
//                // 显示画好的图片
//                iv.setImageBitmap(copytBitmap);

            }
        });

    }
}
