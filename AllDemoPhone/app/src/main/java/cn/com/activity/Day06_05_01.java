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
public class Day06_05_01 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_05_01layout);
        ListView listView = (ListView) findViewById(R.id.lv);
        final String [] objects = {
                "你是我的心，你是我的肝，你是我生命的四分之三。你是我的胃，你是我的肺，你是我心中的红玫瑰！宝贝，情人节快乐！",
                "我问过烦恼，它根本不爱你，还让我转告你不要自做多情，还有健康让我带封情书给你，他暗恋你很久，并一生不变。祝圣诞快乐！",
                "除了母亲，谁能荣膺，让我们齐颂母亲我爱你！母亲你永远快乐！",
                "外边风吹雨打折磨着我，屋内和煦的阳光温暖着我，因为屋内有您，我爱您妈妈，永远永远！童年的青灯里有，你讲的故事，和我的笑声！",
                "妈妈，谢谢你给我生命，在今天属于你的节日里，做儿女的祝你健康长寿。",
                "圆圆的月亮，圆圆的饼，中秋佳节等着你！美丽的星空，美丽的景，愉快心情陪伴你！美好的祝福，美好的心，美好情意滋润你！提前预祝你中秋节快乐！",
                "月儿圆圆，情谊绵绵，月饼圆圆，合家团圆，中秋节日，送上祝愿，生活美满，身体康健，工作顺意，万事如愿，真心诚意，携手相约，协力共建，美好明天。衷心祝愿，中秋快乐！",
                "愿所有心绪化作一只喜鹊，今夜随风飞上九天宫阙，银河上空展翅辉映浩魄明月，俯瞰苍茫参透花开花谢，祝福有情人幸福永久，不管月圆圆缺。七夕快乐。",
                "通告：鉴于你长期独霸我心，害我失神，待我事业进步，经济提升，定会将你双手紧抱，押你至民政局签字画押！七夕前的这条短信算是对你的警告。",
        };

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,objects));
        //对条目进行点击事件监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Day06_05_01.this, "你点击了：" + position, Toast.LENGTH_SHORT).show();
                String sms = objects[position];
                //给短信主界面传递数据
				/*Intent intent =new Intent(SmsListActivity.this , MainActivity.class);
				intent.putExtra("sms", sms);
				startActivity(intent);*/
                Intent intent = new Intent();
                intent.putExtra("sms",sms);
                //2 . 给上一个界面返回数据，这个数据实际上就是一个字符串 sms
                setResult(0,intent);
                //3. 把当前界面关闭掉
                finish();
            }
        });
    }
}
