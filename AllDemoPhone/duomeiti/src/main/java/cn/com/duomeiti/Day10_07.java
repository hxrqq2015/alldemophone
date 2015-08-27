package cn.com.duomeiti;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

/**
 * 音乐播放器
 * Created by admin on 2015/8/24.
 */
public class Day10_07 extends Activity {
    EditText et_path;
    MediaPlayer mediaPlayer;

    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_07layout);

        et_path = (EditText) findViewById(R.id.path);
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在加载中...");
    }
    //播放
    public void play(View v){
        try {
            String path = et_path.getText().toString();
            // 创建播放器对象
            mediaPlayer = new MediaPlayer();
            // 如果播放出现错误，则调用这个方法，一般音频文件损坏。
			/*
			 * mediaPlayer.setOnErrorListener(new OnErrorListener() {
			 *
			 * @Override public boolean onError(MediaPlayer mp, int what, int
			 * extra) { return false; } });
			 */
            // 播放完毕之后，会调用，去播放下一首歌
        	/*
			 * mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			 *
			 * @Override public void onCompletion(MediaPlayer mp) {
			 *
			 * } })
			 */
            mediaPlayer.setDataSource(path);
            // 准备 这是一个同步的操作，什么叫同步的操作呢？ 运行在主线程中。
            // mediaPlayer.prepare();
            //设置异步缓冲，执行在子线程中。
            mediaPlayer.prepare();
            dialog.show();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    dialog.dismiss();
                    // mediaPlayer.seekTo(1000);//跳转到指定的长度，从这个地方开始播放
                    // 播放
                    mediaPlayer.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //暂停
    public void pause(View v){
        if(mediaPlayer.isPlaying()){ // 如果是播放，则暂停
            mediaPlayer.pause();
        }else {// 如果现在是暂停，则点击暂停按钮也可以恢复播放
            mediaPlayer.start();
        }
    }
    //停止
    public void stop(View v){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();// 释放资源
        }
    }
}
