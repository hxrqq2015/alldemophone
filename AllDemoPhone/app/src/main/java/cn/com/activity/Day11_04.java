package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import cn.com.alldemophone.R;

/**
 * day11_04补间动画和集合
 * Created by admin on 2015/8/26.
 */
public class Day11_04 extends Activity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day11_04layout);
        iv = (ImageView) findViewById(R.id.iv);
    }
    // 平移动画
    public void trans(View v){
        // 定义平移动画
		/*
		 * 从当前位置，向右边，并且向下边移动200距离
		 * TranslateAnimation anima = new TranslateAnimation( 0,200, 0, 200);
		 * RELATIVE_TO_SELF : 移动它本身的宽度或者高度，后面指定的值，是倍数
		 * RELATIVE_TO_PARENT:以屏幕的宽度和高度为参照点，移动多少倍。
		 */
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
                Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f);
        // 设置动画实行时间2秒
        animation.setDuration(2000);
        // 设置动画无限循环
        animation.setRepeatCount(TranslateAnimation.INFINITE);
        // 设置循环的模式，播放完毕后，倒着播放   RESTART从开始播放
        animation.setRepeatMode(TranslateAnimation.REVERSE);
        // 让指定的控件播放这个动画
        iv.startAnimation(animation);
    }
    // 旋转动画
    public void rotate(View v){
        // RotateAnimation anima = new RotateAnimation(0, 90);
        //Animation.RELATIVE_TO_SELF 以自身的宽和高
        RotateAnimation animation = new RotateAnimation(
                0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        // 设置动画实行时间
        animation.setDuration(2000);
        // 设置动画无限循环
        animation.setRepeatCount(TranslateAnimation.INFINITE);
        // 设置循环的模式，播放完毕后，倒着播放
        animation.setRepeatMode(TranslateAnimation.REVERSE);
        iv.startAnimation(animation);
    }
    // 缩放动画
    public void scale(View v){
        // 从3倍的初始大小，缩小到1倍。到底是放大还是缩小，只需要比较初始值和最终值的大小关系即可。
        ScaleAnimation animation = new ScaleAnimation(3,1,3,1,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        // 设置动画实行时间
        animation.setDuration(2000);
        // 设置动画无限循环
        animation.setRepeatCount(TranslateAnimation.INFINITE);
        // 设置循环的模式，播放完毕后，倒着播放
        animation.setRepeatMode(TranslateAnimation.REVERSE);
        // 让指定的控件播放这个动画
        iv.startAnimation(animation);
    }
    // 透明度渐变动画
    public void alpha(View v){
        //完全透明状态到完全不投名状态 。0代表的是完全透明 ，1代表的是完全不透明
        AlphaAnimation animation = new AlphaAnimation(0,1.0f);
        // 设置动画实行时间
        animation.setDuration(2000);
        // 设置动画无限循环
        animation.setRepeatCount(TranslateAnimation.INFINITE);
        // 设置循环的模式，播放完毕后，倒着播放
        animation.setRepeatMode(TranslateAnimation.REVERSE);
        // 让指定的控件播放这个动画
        iv.startAnimation(animation);
    }
    //动画集合
    public void set(View v){
        // 1.定义一个动画集合 false：每一个动画使用自己的插入器
        AnimationSet set = new AnimationSet(false);
        // 2.往这个集合里面填充动画

        // 完全透明状态到完全不投名状态 。0代表的是完全透明 ，1代表的是完全不透明
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1.0f);
        // 设置动画实行时间
        alphaAnimation.setDuration(2000);
        // 设置动画无限循环
        alphaAnimation.setRepeatCount(TranslateAnimation.INFINITE);
        // 设置循环的模式，播放完毕后，倒着播放
        alphaAnimation.setRepeatMode(TranslateAnimation.REVERSE);

        // 从3倍的初始大小，缩小到1倍。到底是放大还是缩小，只需要比较初始值和最终值的大小关系即可。
        ScaleAnimation animation = new ScaleAnimation(3,1,3,1,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        // 设置动画实行时间
        animation.setDuration(2000);
        // 设置动画无限循环
        animation.setRepeatCount(TranslateAnimation.INFINITE);
        // 设置循环的模式，播放完毕后，倒着播放
        animation.setRepeatMode(TranslateAnimation.REVERSE);

        // RotateAnimation anima = new RotateAnimation(0, 90);
        //Animation.RELATIVE_TO_SELF 以自身的宽和高
        RotateAnimation rotateAnimation = new RotateAnimation(
                0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        // 设置动画实行时间
        rotateAnimation.setDuration(2000);
        // 设置动画无限循环
        rotateAnimation.setRepeatCount(TranslateAnimation.INFINITE);
        // 设置循环的模式，播放完毕后，倒着播放
        rotateAnimation.setRepeatMode(TranslateAnimation.REVERSE);

        set.addAnimation(alphaAnimation);
        set.addAnimation(animation);
        set.addAnimation(rotateAnimation);
        // 3.让控件播放集合动画
        iv.startAnimation(set);
    }
}
