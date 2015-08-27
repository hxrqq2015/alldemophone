package cn.com.activity;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/13.
 */
public class Day03_04 extends Activity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day03_04layout);
        imageView = (ImageView) findViewById(R.id.day03_04_ima_01);
        //设置背景资源是我们做好的图形动画集合
        imageView.setBackgroundResource(R.drawable.bg);
        //获取它的背景资源，强制类型转化成 动画对象
        AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
        //让动画播放
        drawable.start();
    }
}
