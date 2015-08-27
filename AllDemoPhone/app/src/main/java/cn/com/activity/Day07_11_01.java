package cn.com.activity;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

/**
 * 简易播放器
 * Created by admin on 2015/8/21.
 */
public class Day07_11_01 extends Service {
    MediaPlayer mediaPlayer; // 多媒体播放器
    public static String PATH = "";
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 在此进行音乐播放器的准备工作
        try {
            // 1. 创建一个多媒体播放器
            mediaPlayer = new MediaPlayer();
            // 2.指定播放的音乐数据源
            mediaPlayer.setDataSource(PATH);
            // mediaPlayer.setLooping(true);//设置无线循环播放这首歌
            // 3.缓冲一下，准备一下
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int code = intent.getIntExtra("code", 1);
        switch (code) {
            case 1: // 播放
                play();
                break;
            case 2: // 暂停
                pause();
                break;
            case 3: // 停止
                stop();
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(mediaPlayer !=null){
            mediaPlayer.release() ;//释放多媒体资源
            mediaPlayer= null;
        }
    }

    //播放音乐
    void play() {
        // 在此进行音乐播放器的准备工作
        try {
            // 1. 创建一个多媒体播放器
            mediaPlayer = new MediaPlayer();
            // 2.指定播放的音乐数据源
            mediaPlayer.setDataSource(PATH);
            // mediaPlayer.setLooping(true);//设置无线循环播放这首歌
            // 3.缓冲一下，准备一下
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!mediaPlayer.isPlaying()){ //如果没有在播放音乐，那么就播放
            mediaPlayer.start();
        }

    }

    void pause() {
        if(mediaPlayer.isPlaying()){ //如果正在播放，就暂停
            mediaPlayer.pause();
        }
    }

    void stop() {

        if(mediaPlayer.isPlaying()){ //如果在播放，就停止
            mediaPlayer.stop();

        mediaPlayer.reset(); //重置资源
        }
    }
}
