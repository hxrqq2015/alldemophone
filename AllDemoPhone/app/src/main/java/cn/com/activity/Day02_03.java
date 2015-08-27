package cn.com.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.com.alldemophone.R;

/**
 * 个人资料编辑内存，以SharedPreferences形式，存在手机上
 * Created by admin on 2015/8/9.
 */
public class Day02_03 extends Activity {
    EditText day02_01_edi_nc,day02_01_edi_xb,day02_01_edi_nl,day02_01_edi_xz,day02_01_edi_ah;
    Button day02_01_but_qd,day02_01_but_cx;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day02_03layout);
        //创建一个sp对象，指定2个参数：第一个是文件的名字 。  ,第二个是生成的文件模式
        sp=getSharedPreferences("config",0);
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
        day02_01_but_cx.setOnClickListener(new Mycx());
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
            String nc =day02_01_edi_nc.getText().toString().trim();
            String xb = day02_01_edi_xb.getText().toString().trim();
            String nl = day02_01_edi_nl.getText().toString().trim();
            String xz = day02_01_edi_xz.getText().toString().trim();
            String ah = day02_01_edi_ah.getText().toString().trim();
            if(TextUtils.isEmpty(nc) ||TextUtils.isEmpty(xb)|| TextUtils.isEmpty(nl)||TextUtils.isEmpty(xz)||TextUtils.isEmpty(ah)){
                Toast.makeText(Day02_03.this, "内容不能为空。", Toast.LENGTH_SHORT).show();
                return;
            }
            //得到编辑器的对象
            Editor editor = sp.edit();
            editor.putString("nc",nc);
            editor.putString("xb",xb);
            editor.putString("nl",nl);
            editor.putString("xz",xz);
            editor.putString("ah", ah);
            //如果数据已经存储完毕，要记得提交
            editor.commit();
            Toast.makeText(Day02_03.this, "保存成功", Toast.LENGTH_SHORT).show();
                cle();

        }
    }
    //查询
    class Mycx implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            //获取已保存到的数据
            String nc1 = sp.getString("nc","").trim();
            String nc =day02_01_edi_nc.getText().toString().trim();

            String xb = sp.getString("xb","");
            String nl = sp.getString("nl","");
            String xz = sp.getString("xz","");
            String ah = sp.getString("ah","");
            if(nc.equals(nc1)){
            day02_01_edi_xb.setText(xb);
            day02_01_edi_nl.setText(nl);
            day02_01_edi_xz.setText(xz);
            day02_01_edi_ah.setText(ah);
            }else{
                Toast.makeText(Day02_03.this, "没有该昵称："+nc, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
