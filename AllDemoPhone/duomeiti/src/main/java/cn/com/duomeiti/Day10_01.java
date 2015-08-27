package cn.com.duomeiti;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


/**
 *day10_01加载图片到内存
 * Created by admin on 2015/8/23.
 */
public class Day10_01 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_01layout);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        //解码一张图片，得到位图图像
        //android系统里面显示的位图都是32位位图，  argb---透明8位、红色8位、绿色8位、蓝色8位
        //一个像素点有4个字节长度
        //Bitmap bitmap =  BitmapFactory.decodeFile("/mnt/sdcard/very_large_photo.jpg");
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tp1);
        //显示位图到imageview上
        iv.setImageBitmap(bitmap);

    }
}
