package cn.com.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import cn.com.alldemophone.R;

/**
 * day11_02fragment与activity通讯和生命周期
 * Created by admin on 2015/8/26.
 */
public class Day11_02 extends Activity {
    FragmentManager manager;
    FragmentTransaction ft;
    FrameLayout fl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day11_02layout);
        fl = (FrameLayout) findViewById(R.id.fl);
        // 获取到fragment的管理者
        manager = getFragmentManager();
        // 开启事务 :事务只能提交一次，如果还想操作，只有再次打开事务，然后再次提交
        ft = manager.beginTransaction();


    }

    public void sound(View v){
        ft = manager.beginTransaction();
        Day11_02_01 frament = new Day11_02_01();
        // 替换指定的容器，显示什么界面
        ft.replace(R.id.fl,frament);
        // 提交事务，让系统去刷新界面，显示fragment
        ft.commit();
    }

    public void show(View v){
        ft = manager.beginTransaction();
        Day11_02_02 frament = new Day11_02_02();
        // 替换指定的容器，显示什么界面
        ft.replace(R.id.fl,frament);
        // 提交事务，让系统去刷新界面，显示fragment
        ft.commit();
    }

    public void net(View v){
        ft = manager.beginTransaction();
        Day11_02_03 frament = new Day11_02_03();
        // 替换指定的容器，显示什么界面
        ft.replace(R.id.fl,frament);
        // 提交事务，让系统去刷新界面，显示fragment
        ft.commit();
    }

    public void save(View v){
        ft = manager.beginTransaction();
        Day11_02_04 frament = new Day11_02_04();
        // 替换指定的容器，显示什么界面
        ft.replace(R.id.fl,frament);
        // 提交事务，让系统去刷新界面，显示fragment
        ft.commit();
    }
}
