package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import cn.com.alldemophone.R;

/**
 * day11_05补间动画-xml
 * Created by admin on 2015/8/26.
 */
public class Day11_05 extends Activity{
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day11_05layout);
        iv = (ImageView) findViewById(R.id.iv);
    }


    // 平移动画
    public void trans(View v) {
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.translate_demo);
        iv.startAnimation(animation);

    }

    // 旋转动画
    public void rotate(View v) {
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.rotate_demo);
        iv.startAnimation(animation);

    }

    // 缩放动画
    public void scale(View v) {

        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.scale_demo);
        iv.startAnimation(animation);
    }

    // 透明度渐变动画
    public void alpha(View v) {

        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.alpha_demo);
        iv.startAnimation(animation);
    }

    public void set(View v) {
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.set_demo);
        iv.startAnimation(animation);



    }
}
