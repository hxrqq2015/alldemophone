package cn.com.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.IOException;

import cn.com.alldemophone.R;

/**
 * day10_02加载大图片到内存
 * Created by admin on 2015/8/23.
 */
public class Day10_02 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_02layout);

        ImageView iv = (ImageView) findViewById(R.id.iv);
        //创建一个位图解析选项对象
        BitmapFactory.Options options = new BitmapFactory.Options();
        //代表的是取原图的宽度1/4的像素个数，和高度的1/4的像素个数，就是总大小的1/16
        //设置采样率
        //这个采样率一般不会写死，而是根据你的图片宽高和 屏幕分辨率的宽高得出的中间比例

        //1.获取屏幕的分辨率
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        //Point outSize = new Point();
        // display.getSize(outSize);

        //得到屏幕的宽高
        int width = display.getWidth();
        int height = display.getHeight();
        //2.获取图片的宽高
        try {
           ExifInterface exif = new ExifInterface(Environment.getExternalStorageDirectory()+"/very_large_photo.jpg");
            //  ExifInterface exif = new ExifInterface("/mnt/sdcard/very_large_photo.jpg");
            String imgHeight = exif.getAttribute(ExifInterface.TAG_IMAGE_LENGTH);
            String imgWidth = exif.getAttribute(ExifInterface.TAG_IMAGE_WIDTH);
            System.out.println("屏幕分辨率---width="+width+"--height="+height);
            System.out.println("图片分辨率---imgWidth="+imgWidth+"--imgHeight="+imgHeight);
            //这里可以计算得到他们的宽高比例，然后取中间值即可。
        } catch (IOException e) {
            e.printStackTrace();
        }

        options.inSampleSize =4;
        // Bitmap bitmap = BitmapFactory.decodeFile("/mnt/sdcard/very_large_photo.jpg", opts);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.very_large_photo,options);
        //显示位图到imageview上
        iv.setImageBitmap(bitmap);
    }
}
