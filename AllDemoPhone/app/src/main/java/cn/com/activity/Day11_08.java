package cn.com.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import cn.com.alldemophone.R;

/**
 * day11_08属性动画集合-xml
 * Created by admin on 2015/8/27.
 */
public class Day11_08 extends Activity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day11_08layout);
        iv = (ImageView) findViewById(R.id.iv);
    }
    // 平移动画 xml定义
    public void trans(View v){
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.objecttranslate_demo);
        //指定一个控件，播放这个动画
        animator.setTarget(iv);
        //播放动画
        animator.start();
    }
    // 旋转动画
    public void rotate(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv,"rotation",new float[]{0,360});
        animator.setDuration(2000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.start();
    }
    // 缩放动画
    public void scale(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv,"scaleX",new float[]{1,3});
        animator.setDuration(2000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.start();
    }
    // 透明度渐变动画
    public void alpha(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv,"alpha",new float[]{0,1});
        animator.setDuration(2000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.start();
    }
    //集合动画
    public void set(View v){
        //1。定义属性动画集合
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv,"translationX",new float[]{0,100});
        animator.setDuration(2000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.REVERSE);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv,"translationY",new float[]{0,100});
        animator1.setDuration(2000);
        animator1.setRepeatCount(ObjectAnimator.INFINITE);
        animator1.setRepeatMode(ObjectAnimator.REVERSE);
        //设置两个动画，顺序播放。
        //set.playSequentially(animator, animator2);
        //一起播放。同时影响这个控件
        set.playTogether(animator,animator1);
        set.start();//播放动画集合

    }
}
