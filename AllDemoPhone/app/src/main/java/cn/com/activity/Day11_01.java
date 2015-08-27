package cn.com.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import cn.com.alldemophone.R;

/**
 * day11_01fragment入门
 * Created by admin on 2015/8/26.
 */
public class Day11_01 extends Activity {
    FrameLayout fl;
    FragmentManager  manager;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day11_01layout);
        fl = (FrameLayout) findViewById(R.id.fl);


        // 获取到fragment的管理者
        manager = getFragmentManager();
        // 开启事务 :事务只能提交一次，如果还想操作，只有再次打开事务，然后再次提交
        ft = manager.beginTransaction();


        //默认打开
        Day11_01_01 fragemnt = new Day11_01_01();

        // 替换指定的容器，显示什么界面
        ft.replace(R.id.fl, fragemnt);

        // 提交事务，让系统去刷新界面，显示fragment
        ft.commit();

    }
    //声音
    public void sound(View v){
    /*    // 获取到fragment的管理者
        FragmentManager manager = getFragmentManager();*/
        // 开启事务
        FragmentTransaction ft = manager.beginTransaction();
        Day11_01_01 frament =new Day11_01_01();
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
        Day11_01_02 frament = new Day11_01_02();
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
        Day11_01_03 frament = new Day11_01_03();
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
        Day11_01_04 frament = new Day11_01_04();
        // 替换指定的容器，显示什么界面
        ft.replace(R.id.fl,frament);
        // 替换指定的容器，显示什么界面
        ft.commit();
    }
}
