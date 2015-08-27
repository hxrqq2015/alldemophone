package cn.com.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

import cn.com.alldemophone.R;

/**
 * day10_11视频播放器
 * Created by admin on 2015/8/24.
 */
public class Day10_11 extends Activity {
    MediaPlayer mediaPlayer;
    SharedPreferences sp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_11layout);
        sp = getSharedPreferences("config",0);

        SurfaceView sv = (SurfaceView) findViewById(R.id.sv);
        //得到surface的控制器
        SurfaceHolder holder = sv.getHolder();
        //注册一个回调
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource("/mnt/sdcard/oppo.3gp");
                    mediaPlayer.prepare();
                    //代表显示画面到哪一个控件上，显示到surfaceview上
                    mediaPlayer.setDisplay(holder);
//                    // 获取早前播放到的位置信息
//                    int position = sp.getInt("position",0);
//                    System.out.println("position======"+position);
//                    //跳转到上次播放的位置
//                    mediaPlayer.seekTo(position);
                    mediaPlayer.start();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if(mediaPlayer !=null){
                    //销毁的时候记住当前的播放位置，以便下一次播放的时候从这个位置开始播放
                    int position = mediaPlayer.getCurrentPosition();
                    SharedPreferences.Editor editor= sp.edit();
                    editor.putInt("position",position);
                    editor.commit();
                    //释放资源
                    mediaPlayer.release();
                    mediaPlayer=null;
                }
            }
        });
    }
}
