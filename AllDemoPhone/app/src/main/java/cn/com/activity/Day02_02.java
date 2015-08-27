package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import cn.com.alldemophone.R;

/**
 * 个人资料编辑内存，以文件形式，存在手机上
 * Created by admin on 2015/8/8.
 */
public class Day02_02 extends Activity{
    EditText day02_01_edi_nc,day02_01_edi_xb,day02_01_edi_nl,day02_01_edi_xz,day02_01_edi_ah;
    Button day02_01_but_qd,day02_01_but_cx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day02_02layout);
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
    //以内存储方式保存文件
    class Myqd implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //判断SD卡是否已经挂在，也就是有没有SD卡
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                try {
                    String nc =day02_01_edi_nc.getText().toString().trim();
                    String xb = day02_01_edi_xb.getText().toString().trim();
                    String nl = day02_01_edi_nl.getText().toString().trim();
                    String xz = day02_01_edi_xz.getText().toString().trim();
                    String ah = day02_01_edi_ah.getText().toString().trim();
                    //判断输入框不为空
                    if((TextUtils.isEmpty(nc)) ||(TextUtils.isEmpty(xb)) ||(TextUtils.isEmpty(nl)) ||(TextUtils.isEmpty(xz)) ||(TextUtils.isEmpty(ah)) ){
                        Toast.makeText(Day02_02.this,"输入框不能为空，请输入！",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //File file = new File("/data/data/cn.com.alltestdemo/gerenziliao1.txt");
                    File file = new File(Day02_02.this.getFilesDir(),"gerenziliao1.txt");
                    FileOutputStream fos = new FileOutputStream(file);
                    String allinfo = nc+"##"+xb+"##"+nl+"##"+xz+"##"+ah;
                    fos.write(allinfo.getBytes());
                    fos.close();
                    Toast.makeText(Day02_02.this,"以内存文件保存成功。",Toast.LENGTH_SHORT).show();
                    cle();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Toast.makeText(Day02_02.this,"没有插入SD卡，请插入SD卡。",Toast.LENGTH_SHORT).show();
            }
        }
    }
    //查询数据
    class Mycx implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //判断有没有SD卡
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                    try {
                File file = new File(Day02_02.this.getFilesDir(),"gerenziliao1.txt");
                     //如果文件存在就读取数据
                          if(file.exists()&&file.length()>0){
                        //读取以前的数据
                        FileInputStream fis = new FileInputStream(file);
                        //转换流读一行
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                        String line = br.readLine();String nc1 = line.split("##")[0].trim();
                        String xb = line.split("##")[1];
                        String nl = line.split("##")[2];
                        String xz = line.split("##")[3];
                        String ah = line.split("##")[4];
                        String nc =day02_01_edi_nc.getText().toString().trim();
                              if(nc.equals(nc1)){

                        //设置显示数据
                        day02_01_edi_xb.setText(xb);
                        day02_01_edi_nl.setText(nl);
                        day02_01_edi_xz.setText(xz);
                        day02_01_edi_ah.setText(ah);
                              }else{
                                  cle();
                Toast.makeText(Day02_02.this,"没有找到该昵称:"+nc,Toast.LENGTH_SHORT).show();

                              }
                        br.close();
                        fis.close();}
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }else{
                Toast.makeText(Day02_02.this,"没有插入SD卡，请插入SD卡。",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
