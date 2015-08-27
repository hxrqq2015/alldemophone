package cn.com.service;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.com.domain.NewsItem;

/**
 * Created by admin on 2015/8/18.
 */
public class NewsServcie {
    /**
     * 请求新闻数据，并且解析数据，返回List集合<NewsItem>
     * @param path  新闻路径
     * @return
     */
    public static List<NewsItem> getAllNews (String path){
        List<NewsItem> items = new ArrayList<NewsItem>();
        try {
            // 1.定位资源
            URL url = new URL(path);
            // 2.打开连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置请求方式以及超时时间
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            if(200==conn.getResponseCode()){// 判断状态码
                // 获取服务器返回过来的输入流，但是我们请求的是一个xml文件，所以接下来要进行xml文件的解析
                InputStream is = conn.getInputStream();
                // 1.获取xmlpull解析器
                XmlPullParser parser = Xml.newPullParser();
                // 2.指定解析数据源
                parser.setInput(is,"utf-8");
                // 获取当前的事件类型
                int type = parser.getEventType();
                // 只要不是文档的结束，就一直解析
                NewsItem item = null  ;
                while (type!=XmlPullParser.END_DOCUMENT){
                    if(type==XmlPullParser.START_TAG){
                        String name = parser.getName();
                        if("item".equals(name)){
                            item= new NewsItem();
                        }else if ("title".equals(name)) { //标题
                            String title = parser.nextText();
                            item.setTitle(title);
                        } else if ("description".equals(name)) {  //描述
                            String description = parser.nextText();
                            item.setDescription(description);
                        } else if ("image".equals(name)) { //图片
                            String image = parser.nextText();
                            item.setImage(image);
                        }else if ("type".equals(name)) { //类型
                            String typeStr = parser.nextText();
                            item.setType(typeStr);
                        }else if ("comment".equals(name)) { //评论
                            int comment = Integer.parseInt(parser.nextText());
                            item.setComment(comment);
                        }
                    }

                    if(type == XmlPullParser.END_TAG){
                        String name = parser.getName();
                        if("item".equals(name)){
                            //如果解析完了一个item组，那么就代表一个新闻数据已经解析完毕，这个时候就要装到list集合里面。
                            items.add(item);
                        }
                    }
                    type=parser.next();
                }
                    is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
