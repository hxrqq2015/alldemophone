package cn.com.activity;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import cn.com.alldemophone.R;

/**
 * day10_08音乐池soundpool
 * Created by admin on 2015/8/24.
 */
public class Day10_08 extends Activity {
    int id ;
    SoundPool pool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_08layout);
        //定义声音池 ，第一个参数：池子里面可以放多少个音频文件，第二个：音频的流格式，一般是STREAM_MUSIC
        //第三个没什么影响，给0就可以
        pool = new SoundPool(3, AudioManager.STREAM_MUSIC,0);
        //加载一个音频文件到池子里面
        id = pool.load(this, R.raw.shoot, 1);
    }
    public void shoot(View v){
        //指定播放的声音id，左声道右声道、 优先级、是否循环、播放速率
        pool.play(id, 1, 1, 0, 0, 1.0f);//0-2.0
    }
    public void shoot2(View v){
        //指定播放的声音id，左声道右声道、 优先级、是否循环、播放速率
        pool.play(id, 1, 1, 0, 0, 2.0f);//0-2.0
    }
    public void shoot0(View v){
        //指定播放的声音id，左声道右声道、 优先级、是否循环、播放速率
        pool.play(id, 1, 1, 0, 0, 0.0f);//0-2.0
    }
}
