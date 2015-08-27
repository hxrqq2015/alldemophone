package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cn.com.alldemophone.R;

/**
 * day09_06读取联系人
 * Created by admin on 2015/8/25.
 */
public class Day09_06 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day09_06layout);
        //1.查询所有的联系人
        final List<Day09_06_01> contacts = Day09_06_02.getAllContacts(this);
        //2.找到联系人之后，再显示到界面上
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return contacts.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = new TextView(Day09_06.this);
                tv.setText(contacts.get(position).toString());
                return tv;
            }
        });
    }
    //查询通讯录的联系人
    public void read(View v){
        List<Day09_06_01> contacts = Day09_06_02.getAllContacts(this);
        for (Day09_06_01 contactInfo : contacts) {
            System.out.println("---》"+contactInfo);
        }
    }
}
