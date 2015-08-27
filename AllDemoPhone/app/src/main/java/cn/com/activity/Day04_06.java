package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cn.com.alldemophone.R;
import cn.com.domain.NewsItem;
import cn.com.service.NewsServcie;
import cn.com.view.SmartImageView;

/**
 * Created by admin on 2015/8/17.
 */
public class Day04_06 extends Activity{
    List<NewsItem> itemList;
    ListView listView;
    View dialog;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            dialog.setVisibility(View.GONE);
            NewsAdapter  adapter = new NewsAdapter();
            listView.setAdapter(adapter);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day04_06layout);
        listView = (ListView) findViewById(R.id.lis_01);
        dialog = findViewById(R.id.dialog);
        //请求网络上的数据 ，然后显示到lsitView上
        //让对话框显示
        dialog.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String path = "http://188.188.7.23:8080/AllTestWeb/news.xml";
                itemList = NewsServcie.getAllNews(path);
                handler.sendEmptyMessage(1);
            }
        }.start();
    }

    class NewsAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return itemList.size();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View  v= View.inflate(Day04_06.this,R.layout.day04_06item,null);
            TextView tv_title = (TextView) v.findViewById(R.id.tv_title);
            TextView tv_desc = (TextView) v.findViewById(R.id.tv_desc);
            TextView tv_comment = (TextView) v.findViewById(R.id.tv_comment);
            SmartImageView iv = (SmartImageView) v.findViewById(R.id.icon);

            NewsItem item = itemList.get(position);
            tv_title.setText(item.getTitle());
            tv_desc.setText(item.getDescription());
          //  String image =item.getImage();
            //请求图片
            iv.setImageUrl(item.getImage());
            String type = item.getType();
            if("1".equals(type)){
                //设置评论
                tv_comment.setText("评论："+item.getComment()+"");
            }else if("2".equals(type)){
                tv_comment.setText("视频");
                tv_comment.setBackgroundColor(0xBBff0000);
            }else if("3" .equals(type)){
                tv_comment.setText("LIVE");
                tv_comment.setBackgroundColor(0xBB0000ff);
            }
            return v;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


    }
}
