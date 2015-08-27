package cn.com.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.alldemophone.R;

/**
 * 我是显示界面
 * fragment实际上就是一个轻量级的activity
 * Created by admin on 2015/8/26.
 */
public class Day11_02_02 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.day11_02_02layout,null);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("oncreate---");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("onStart---");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume---");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onPause---");
    }


    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop---");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy---");
    }
}
