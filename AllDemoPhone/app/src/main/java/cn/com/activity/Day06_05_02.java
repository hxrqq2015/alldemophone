package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import cn.com.alldemophone.R;
/**
 * Created by admin on 2015/8/20.
 */
public class Day06_05_02 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_05_02layout);
        ListView listView = (ListView) findViewById(R.id.lv);
        final  String [] objects={
                "1008611123123",
                "1008611123125",
                "1008611123124",
                "1008611123126",
                "1008611123127",
                "1008611123128",
                "1008611123129",
                "1008611123121",
        };
        listView.setAdapter(new ArrayAdapter<String >(Day06_05_02.this,android.R.layout.simple_list_item_1, objects));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Day06_05_02.this, "你点击了：" + position, Toast.LENGTH_SHORT).show();
                String smsa = objects[position];
                //给短信主界面传递数据
				/*Intent intent =new Intent(SmsListActivity.this , MainActivity.class);
				intent.putExtra("sms", sms);
				startActivity(intent);*/
                Intent intent = new Intent();
                intent.putExtra("smsa",smsa);
                //2 . 给上一个界面返回数据，这个数据实际上就是一个字符串 sms
                setResult(0,intent);
                //3. 把当前界面关闭掉
                finish();
            }
        });
    }
}
