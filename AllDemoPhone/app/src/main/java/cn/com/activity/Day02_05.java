package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/9.
 */
public class Day02_05 extends Activity {
    EditText day02_05_edi_xm,day02_05_edi_xb,day02_05_edi_nl;
    Button day02_05_edi_tjxs;
    LinearLayout day02_05_layou;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day02_05layout);

//        day02_05_edi_xm= (EditText) findViewById(R.id.day02_05_edi_xm);
//        day02_05_edi_xb= (EditText) findViewById(R.id.day02_05_edi_xb);
//        day02_05_edi_nl= (EditText) findViewById(R.id.day02_05_edi_nl);
//
//        day02_05_edi_tjxs = (Button) findViewById(R.id.day02_05_edi_tjxs);
//
//        day02_05_layou = (LinearLayout) findViewById(R.id.day02_05_layou);
    }

//    public  void add(View v){
//        //使用代码创建一个textView对象
//        TextView tv = new TextView(this);
//
////        day02_05_edi_xm.getText();
//        tv.setText(day02_05_edi_xm.getText().toString()+day02_05_edi_xb.getText().toString()+day02_05_edi_nl.getText().toString());
//
//        //往容器里面添加一个控件对象
//        day02_05_layou.addView(tv);
//    }
}
