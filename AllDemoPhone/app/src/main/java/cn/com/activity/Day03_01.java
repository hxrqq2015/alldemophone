package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import cn.com.alldemophone.R;

/**
 * ListView的简单使用方法
 * Created by admin on 2015/8/10.
 */
public class Day03_01 extends Activity {
    ListView day03_lis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day03_01layout);
        day03_lis = (ListView) findViewById(R.id.day03_lis);
        //设置显示的数据适配器 ，实际上就是绑定控制器
        day03_lis.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {
        //用于控制到底显示多少个条目
        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
        //用于控制每一个条目到底长什么样子，说的专业一点就是：到底每一个条目显示什么控件，这些控件是如何摆放的。
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            //ListView优化
            if(convertView==null){//不存在缓存，需要创建 TextView
                tv  = new TextView(Day03_01.this);
            }else{//存在缓存，不需要创建 TextView
                tv= (TextView) convertView;
            }

            tv.setText("这是第" + position + "个item");
            tv.setTextSize(25);
            //一定要返回显示的视图


            return tv;
        }
    }
}

