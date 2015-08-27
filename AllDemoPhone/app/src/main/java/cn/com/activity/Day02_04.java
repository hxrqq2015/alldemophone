package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.com.alldemophone.R;

/**
 * 个人资料编辑内存，以xml形式，存在手机上
 * Created by admin on 2015/8/9.
 */
public class Day02_04 extends Activity {
    EditText day02_01_edi_nc,day02_01_edi_xb,day02_01_edi_nl,day02_01_edi_xz,day02_01_edi_ah;
    Button day02_01_but_qd,day02_01_but_cx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day02_04layout);

        //找到控件
        day02_01_edi_nc = (EditText) findViewById(R.id.day02_01_edi_nc);
        day02_01_edi_xb = (EditText) findViewById(R.id.day02_01_edi_xb);
        day02_01_edi_nl = (EditText) findViewById(R.id.day02_01_edi_nl);
        day02_01_edi_xz = (EditText) findViewById(R.id.day02_01_edi_xz);
        day02_01_edi_ah = (EditText) findViewById(R.id.day02_01_edi_ah);

        day02_01_but_qd = (Button) findViewById(R.id.day02_01_but_qd);
        //设置点击事件监听 使用内部类的方式
        day02_01_but_qd.setOnClickListener(new Myqd());
        day02_01_but_cx = (Button) findViewById(R.id.day02_01_but_cx);
        day02_01_but_cx.setOnClickListener(new Mycxa());


    }
    //清空数据
    public void cle(){
        day02_01_edi_nc.setText("");
        day02_01_edi_xb.setText("");
        day02_01_edi_nl.setText("");
        day02_01_edi_xz.setText("");
        day02_01_edi_ah.setText("");
    }
    //保存
    class Myqd implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //获取控件文本内容
            String nc =day02_01_edi_nc.getText().toString().trim();
            String xb = day02_01_edi_xb.getText().toString().trim();
            String nl = day02_01_edi_nl.getText().toString().trim();
            String xz = day02_01_edi_xz.getText().toString().trim();
            String ah = day02_01_edi_ah.getText().toString().trim();
            //判断输入框不为空
            if((TextUtils.isEmpty(nc)) ||(TextUtils.isEmpty(xb)) ||(TextUtils.isEmpty(nl)) ||(TextUtils.isEmpty(xz)) ||(TextUtils.isEmpty(ah)) ){
                Toast.makeText(Day02_04.this,"输入框不能为空，请输入！",Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                //得到XML序列器
                XmlSerializer xml = Xml.newSerializer();
                //写入文件  data/data/包名/files
                FileOutputStream fos = openFileOutput(nc+".xml",0);
                xml.setOutput(fos, "UTF-8");
                //拼接XML字符串
                xml.startDocument("UTF-8",true);
                xml.startTag(null, "stu");

                xml.startTag(null, "昵称");
                xml.text(nc);
                xml.endTag(null, "昵称");
                xml.startTag(null, "性别");
                xml.text(xb);
                xml.endTag(null, "性别");
                xml.startTag(null, "年龄");
                xml.text(nl);
                xml.endTag(null, "年龄");
                xml.startTag(null, "星座");
                xml.text(xz);
                xml.endTag(null, "星座");
                xml.startTag(null, "爱好");
                xml.text(ah);
                xml.endTag(null, "爱好");

                xml.endTag(null,"stu");
                xml.endDocument();
                Toast.makeText(Day02_04.this, "保存成功", Toast.LENGTH_SHORT).show();
                cle();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(Day02_04.this, "保存失败", Toast.LENGTH_SHORT).show();
            }

        }
    }
    //查询
    class Mycxa implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //获取控件文本内容
            String nc =day02_01_edi_nc.getText().toString().trim();
            //判断有没有这个文件，有就解析
            File file = new File(getFilesDir(),nc+".xml");
            if(file.exists()&&file.length()>0){
                try {
                    //得到pull解析器对象
                    XmlPullParser parser = Xml.newPullParser();
                    //设置解析数据源
                    FileInputStream fis = new FileInputStream(file);
                    parser.setInput(fis,"UTF-8");
                    //开始解析
                    //获取当前的事件类型
                    int type = parser.getEventType();
                    //只要当前的事件类型，不是文档额结束，那么一直不断的解析
                    while (type!=XmlPullParser.END_DOCUMENT){
                        //如果当前的事件类型是开始标签
                        if(type==XmlPullParser.START_TAG){
                            //获取到开始标签的名字
                            String evename = parser.getName();
                            //如果开始标签的名字是昵称，那么就获取后面的值
                            if("昵称".equals(evename)){
                                day02_01_edi_nc.setText(parser.nextText());
                            }else if("性别".equals(evename)){
                                day02_01_edi_xb.setText(parser.nextText()) ;
                            }else   if("年龄".equals(evename)){
                                 day02_01_edi_nl.setText(parser.nextText());
                            }else  if("星座".equals(evename)){
                                 day02_01_edi_xz.setText(parser.nextText());
                            }else  if("爱好".equals(evename)){
                                 day02_01_edi_ah.setText(parser.nextText());
                            }
                        }
                        //让事件类型，跳转到下一个节点，也就是让指针移动到下一个分析的节点
                        type = parser.next();
                    }
                    fis.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                Toast.makeText(Day02_04.this,"没有该用户:"+nc,Toast.LENGTH_SHORT).show();
                cle();
            }
        }
    }
}
