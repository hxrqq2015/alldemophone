package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import cn.com.alldemophone.R;

/**
 * day10_09视频播放器
 * Created by admin on 2015/8/24.
 */
public class Day10_09 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_09layout);
        //1.找到视频播放控件
        VideoView vv = (VideoView) findViewById(R.id.vv);
        //2.设置播放什么资源
        vv.setVideoPath("/mnt/sdcard/oppo.3gp");
        //设置videoview里面显示控制按钮
        MediaController  controller = new MediaController(this);
        //设置controller控制哪一个view
        controller.setAnchorView(vv);
        //设置多媒体控制器
        vv.setMediaController(controller);
        //3.设置播放
        vv.start();
    }
}
