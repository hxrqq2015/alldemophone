package cn.com.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by admin on 2015/8/18.
 */
public class SmartImageView extends ImageView {
    public SmartImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SmartImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public SmartImageView(Context context) {
        super(context);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
             Bitmap bitmap = (Bitmap) msg.obj;
            setImageBitmap(bitmap);
        }
    };

    public void setImageUrl(final String path) {
        //开启一个子线程，然后去请求图片，下来显示
         new Thread(){
             @Override
             public void run() {
                 try {
                     URL url=new URL(path);
                   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                     conn.setRequestMethod("GET");
                     conn.setConnectTimeout(5000);
                     if(200==conn.getResponseCode()){
                         InputStream is = conn.getInputStream();
                         Bitmap bitmap = BitmapFactory.decodeStream(is);
                         Message msg = new Message();
                         msg.obj=bitmap;
                         handler.sendMessage(msg);
                         is.close();
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }

             }
         }.start();
    }
}
