package cn.com.activity;

import android.animation.Animator;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import cn.com.alldemophone.R;

/**
 * 我是声音界面
 * Created by admin on 2015/8/26.
 */
public class Day11_01_01 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.day11_01_01layout, null);
    }
}
