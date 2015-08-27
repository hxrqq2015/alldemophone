package cn.com.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.alldemophone.R;

/**
 * 我是存储界面
 * Created by admin on 2015/8/26.
 */
public class Day11_01_04 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.day11_01_04layout, null);
    }
}
