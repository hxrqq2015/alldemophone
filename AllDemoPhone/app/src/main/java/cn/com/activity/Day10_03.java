package cn.com.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import cn.com.alldemophone.R;

/**
 * 图片操作：缩放、旋转、平移、镜面、倒影
 * Created by admin on 2015/8/23.
 */
public class Day10_03 extends Activity {
    ImageView iv_src, iv_target;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_03layout);
        iv_src = (ImageView) findViewById(R.id.iv_src);
        iv_target = (ImageView) findViewById(R.id.iv_target);
    }
    // 实现图片的缩放
    public void suofang(View v){
        // 1.显示原图
        //Bitmap srcBitmap = BitmapFactory.decodeFile("/mnt/sdcard/tp1.jpg");
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tp1);
        iv_src.setImageBitmap(srcBitmap);
        // 2.显示缩放后的图片
        // 在android要想显示缩放后的图片，实际上并不是在原图的基础上做修改的。
        // 而是把原图做成了一份拷贝的图片，宽高与之一模一样，然后操作这张拷贝的图片

        //1.得到一份空白的位图，这个位图的宽高与原图一模一样。
        Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(),
                srcBitmap.getHeight(),srcBitmap.getConfig());
        //2.开始定义画板-画布-画架 ,指定在哪一个空白的纸张上作画
        Canvas canvas = new Canvas(copyBitmap);
        //3.创建画笔
        Paint paint = new Paint();
       // paint.setColor(getResources().getColor(R.color.red));
        //4.定义矩阵 做出来一张1：1比例的图片
        Matrix matrix = new Matrix();
        //指定缩放，宽度是原来的一半，高度也是原来的一半。
        matrix.setScale(0.5f,0.5f);//参数为0-2
        //5开始作画：指定参照那一张图片作画 ，参照原图作画
        canvas.drawBitmap(srcBitmap,matrix,paint);
        //6.显示拷贝好的图片到imageView上
        iv_target.setImageBitmap(copyBitmap);
    }
    // 实现图片的旋转
    public void xuanzhuan(View v){
        // 1.显示原图
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tp1);
        iv_src.setImageBitmap(srcBitmap);
        // 2.显示旋转后的图片
        //1.得到一份空白的位图，这个位图的宽高与原图一模一样。
        Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(),
                srcBitmap.getHeight(),srcBitmap.getConfig());
        //2.开始定义画板-画布-画架 ,指定在哪一个空白的纸张上作画
        Canvas canvas = new Canvas(copyBitmap);
        //3.创建画笔
        Paint paint = new Paint();
        //4.定义矩阵 做出来一张1：1比例的图片
        Matrix matrix = new Matrix();
        //旋转15度，默认以0点为旋转中心点，也就是图片的左上角
//		matrix.setRotate(15);
        //以图片的中心为旋转点，然后旋转90度
        matrix.setRotate(180, copyBitmap.getWidth() / 2, copyBitmap.getHeight() / 2);
        //5开始作画：指定参照那一张图片作画 ，参照原图作画
        canvas.drawBitmap(srcBitmap,matrix,paint);
        //6.显示拷贝好的图片到imageView上
        iv_target.setImageBitmap(copyBitmap);
    }
    // 实现图片的平移
    public void pingyi(View v){
        // 1.显示原图
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tp1);
        iv_src.setImageBitmap(srcBitmap);
        // 2.显示平移后的图片
        //1.得到一份空白的位图，这个位图的宽高与原图一模一样。
        Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(),
                srcBitmap.getHeight(),srcBitmap.getConfig());
        //2.开始定义画板-画布-画架 ,指定在哪一个空白的纸张上作画
        Canvas canvas = new Canvas(copyBitmap);
        //3.创建画笔
        Paint paint = new Paint();
        //4.定义矩阵 做出来一张1：1比例的图片
        Matrix matrix = new Matrix();
        //x轴平移了50个像素点长度，y轴也平移了20个像素的长度
        matrix.setTranslate(50, 20);
        //5开始作画：指定参照那一张图片作画 ，参照原图作画
        canvas.drawBitmap(srcBitmap,matrix,paint);
        //6.显示拷贝好的图片到imageView上
        iv_target.setImageBitmap(copyBitmap);
    }
    // 实现图片的镜面
    public void jingmian(View v){
        // 1.显示原图
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tp1);
        iv_src.setImageBitmap(srcBitmap);
        // 2.显示镜面后的图片
        //1.得到一份空白的位图，这个位图的宽高与原图一模一样。
        Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(),
                srcBitmap.getHeight(),srcBitmap.getConfig());
        //2.开始定义画板-画布-画架 ,指定在哪一个空白的纸张上作画
        Canvas canvas = new Canvas(copyBitmap);
        //3.创建画笔
        Paint paint = new Paint();
        //4.定义矩阵 做出来一张1：1比例的图片
        Matrix matrix = new Matrix();
        //把x轴的像素变成负数 Y轴不需要变
        matrix.setScale(-1, 1);
        //移动宽度 setXXX的功能不会在原来的效果基础上做变更，
        // 所以为了能够让前面执行的逻辑也生效，这里应该用postXXX
        matrix.postTranslate(copyBitmap.getWidth(), 0);
        //5开始作画：指定参照那一张图片作画 ，参照原图作画
        canvas.drawBitmap(srcBitmap,matrix,paint);
        //6.显示拷贝好的图片到imageView上
        iv_target.setImageBitmap(copyBitmap);
    }
    // 实现图片的倒影
    public void daoying(View v){
        // 1.显示原图
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tp1);
        iv_src.setImageBitmap(srcBitmap);
        // 2.显示倒影后的图片
        //1.得到一份空白的位图，这个位图的宽高与原图一模一样。
        Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(),
                srcBitmap.getHeight(),srcBitmap.getConfig());
        //2.开始定义画板-画布-画架 ,指定在哪一个空白的纸张上作画
        Canvas canvas = new Canvas(copyBitmap);
        //3.创建画笔
        Paint paint = new Paint();
        //4.定义矩阵 做出来一张1：1比例的图片
        Matrix matrix = new Matrix();
        //x轴不需要变,把y轴的像素变成负数
        matrix.setScale(1,-1);
        //移动宽度 setXXX的功能不会在原来的效果基础上做变更，
        // 所以为了能够让前面执行的逻辑也生效，这里应该用postXXX
        matrix.postTranslate(0,copyBitmap.getHeight());
        //5开始作画：指定参照那一张图片作画 ，参照原图作画 ，给定矩阵、 画笔
        canvas.drawBitmap(srcBitmap,matrix,paint);
        //6.显示拷贝好的图片到imageView上
        iv_target.setImageBitmap(copyBitmap);

    }
}
