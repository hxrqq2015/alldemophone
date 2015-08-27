package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import cn.com.alldemophone.R;

/**
 * day11_03fragment的向下兼容
 * 低版本的activity要继承fragmentactivity，
 * 高版本的不用，还是继承activity，原因是高版本的jar里面结成了这个方法
 * Created by admin on 2015/8/26.
 */
public class Day11_03 extends FragmentActivity {
    FragmentManager manager;
    FrameLayout fl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day11_03layout);
        manager = getSupportFragmentManager();
        fl = (FrameLayout) findViewById(R.id.fl);

    }
    //声音
    public void sound(View v){
    /*    // 获取到fragment的管理者
        FragmentManager manager = getFragmentManager();*/
        // 开启事务
        FragmentTransaction ft = manager.beginTransaction();
        Day11_03_01 frament =new Day11_03_01();
        // 替换指定的容器，显示什么界面
        ft.replace(R.id.fl,frament);
        // 提交事务，让系统去刷新界面，显示fragment
        ft.commit();
    }
    //显示
    public void show(View v){
     /*   // 获取到fragment的管理者
        FragmentManager manager = getFragmentManager();*/
        // 开启事务
        FragmentTransaction ft = manager.beginTransaction();
        Day11_03_02 frament = new Day11_03_02();
        // 替换指定的容器，显示什么界面
        ft.replace(R.id.fl,frament);
        // 替换指定的容器，显示什么界面
        ft.commit();
    }
    //网络
    public void net(View v){
      /*  // 获取到fragment的管理者
        FragmentManager manager = getFragmentManager();*/
        // 开启事务
        FragmentTransaction ft = manager.beginTransaction();
        Day11_03_03 frament = new Day11_03_03();
        // 替换指定的容器，显示什么界面
        ft.replace(R.id.fl,frament);
        // 替换指定的容器，显示什么界面
        ft.commit();
    }
    //储存
    public void save(View v){
    /*    // 获取到fragment的管理者
        FragmentManager manager = getFragmentManager();*/
        // 开启事务
        FragmentTransaction ft = manager.beginTransaction();
        Day11_03_04 frament = new Day11_03_04();
        // 替换指定的容器，显示什么界面
        ft.replace(R.id.fl, frament);
        // 替换指定的容器，显示什么界面
        ft.commit();
    }
}
