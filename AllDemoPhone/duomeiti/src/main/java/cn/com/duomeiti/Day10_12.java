package cn.com.duomeiti;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 *day10_12拍照
 * Created by admin on 2015/8/24.
 */
public class Day10_12 extends Activity {
    ImageView iv;
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_12layout);
        iv = (ImageView) findViewById(R.id.iv);

    }
    public void click(View v){
        // 定义intent，指定action动作
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //指定输出的文件路径
        file = new File(Environment.getExternalStorageDirectory(),System.currentTimeMillis()+".jpg");
        //指定Uri
        Uri fileUri = Uri.fromFile(file);
        //设置捕获的图片输出的路径所在
        intent.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(file.exists() && file.length()>0){
            //如果拍照能够成功返回，那么代表上面输出的文件已经存在，这里就直接解码文件成bitmap位图即可
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            iv.setImageBitmap(bitmap);
        }
    }
}
