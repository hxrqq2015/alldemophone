package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

import cn.com.alldemophone.R;

/**
 * day10_13视频录制
 * Created by admin on 2015/8/24.
 */
public class Day10_13 extends Activity {
    VideoView vv;
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_13layout);
        vv = (VideoView) findViewById(R.id.vv);
    }

    public  void click(View v){
        //create new Intent
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

//	    fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);  // create a file to save the video
        file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis()+".3gp");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));  // set the image file name

        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1); // set the video image quality to high

        // start the Video Capture Intent
        startActivityForResult(intent, 33);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(file.exists()&& file.length()> 0){

            //设置视频播放的路径
            vv.setVideoPath(file.getAbsolutePath());

            MediaController controller = new MediaController(this);
            controller.setAnchorView(vv);
            vv.setMediaController(controller);
            vv.start();

        }
    }
}
