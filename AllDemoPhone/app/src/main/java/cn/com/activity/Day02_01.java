package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.FormatFlagsConversionMismatchException;

import cn.com.alldemophone.R;

/**
 * 个人资料编辑外存，以文件形式，存在SD卡中
 * Created by admin on 2015/8/8.
 */
public class Day02_01 extends Activity {
    EditText day02_01_edi_nc,day02_01_edi_xb,day02_01_edi_nl,day02_01_edi_xz,day02_01_edi_ah;
    Button day02_01_but_qd,day02_01_but_cx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day02_01layout);
        //找到控件
        day02_01_edi_nc = (EditText) findViewById(R.id.day02_01_edi_nc);
        day02_01_edi_xb = (EditText) findViewById(R.id.day02_01_edi_xb);
        day02_01_edi_nl = (EditText) findViewById(R.id.day02_01_edi_nl);
        day02_01_edi_xz = (EditText) findViewById(R.id.day02_01_edi_xz);
        day02_01_edi_ah = (EditText) findViewById(R.id.day02_01_edi_ah);

        day02_01_but_qd = (Button) findViewById(R.id.day02_01_but_qd);
        day02_01_but_cx = (Button) findViewById(R.id.day02_01_but_cx);
        //匿名内部类绑定点击事件   查询
        day02_01_but_cx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先判断有没有插入SD卡  判断SD卡是否已经挂在，也就是有没有SD卡
                if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                    try {
                        File file =new File(Environment.getExternalStorageDirectory(),"gerenziliao.txt");
                        //如果文件存在，则读取数据
                        if(file.exists() && file.length()>0){
                            //读取以前的数据
                            FileInputStream fis = new FileInputStream(file);
                            //转换流读一行
                            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                            String line = br.readLine();
                            String nc1 = line.split("##")[0].trim();
                            String xb = line.split("##")[1];
                            String nl = line.split("##")[2];
                            String xz = line.split("##")[3];
                            String ah = line.split("##")[4];
                            //设置显示数据
                            day02_01_edi_xb.setText(xb);
                            day02_01_edi_nl.setText(nl);
                            day02_01_edi_xz.setText(xz);
                            day02_01_edi_ah.setText(ah);
                            String nc =day02_01_edi_nc.getText().toString().trim();
                            if(nc.equals(nc1)){

                                //设置显示数据
                                day02_01_edi_xb.setText(xb);
                                day02_01_edi_nl.setText(nl);
                                day02_01_edi_xz.setText(xz);
                                day02_01_edi_ah.setText(ah);
                            }else{
                                cle();
                                Toast.makeText(Day02_01.this,"没有找到该昵称:"+nc,Toast.LENGTH_SHORT).show();

                            }
                            br.close();
                            fis.close();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(Day02_01.this, "SD卡没有被挂载..", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //清空数据
    public void cle(){
        day02_01_edi_nc.setText("");
        day02_01_edi_xb.setText("");
        day02_01_edi_nl.setText("");
        day02_01_edi_xz.setText("");
        day02_01_edi_ah.setText("");
    }

    //信息加入到外部文件
    public void add(View v){
        //判断SD卡是否已经挂在，也就是有没有SD卡
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            //判断SD卡容量还有多少
            File file2 = Environment.getExternalStorageDirectory();
            long free =file2.getFreeSpace();//获得可用字节数
            long total = file2.getTotalSpace();//获得SD卡的总大小字节数
            String freestr = Formatter.formatFileSize(this, free);
            String totalstr = Formatter.formatFileSize(this,total);
            Toast.makeText(this,"当前可用大小是："+freestr+"，总大小是："+totalstr,Toast.LENGTH_SHORT);
        try {
            //获取文本框值
            String nc =day02_01_edi_nc.getText().toString().trim();
            String xb = day02_01_edi_xb.getText().toString().trim();
            String nl = day02_01_edi_nl.getText().toString().trim();
            String xz = day02_01_edi_xz.getText().toString().trim();
            String ah = day02_01_edi_ah.getText().toString().trim();

            //判断输入框不为空
            if((TextUtils.isEmpty(nc)) ||(TextUtils.isEmpty(xb)) ||(TextUtils.isEmpty(nl)) ||(TextUtils.isEmpty(xz)) ||(TextUtils.isEmpty(ah)) ){
                Toast.makeText(Day02_01.this,"输入框不能为空，请输入！",Toast.LENGTH_SHORT).show();
                return;
            }

            //File file = new File("/mnt/sdcard/cache.txt");
            File file = new File(Environment.getExternalStorageDirectory(),"gerenziliao.txt");
            FileOutputStream fos = new FileOutputStream(file);
            String allinfo = nc+"##"+xb+"##"+nl+"##"+xz+"##"+ah;
            fos.write(allinfo.getBytes());
            fos.close();
            Toast.makeText(this,"以外存文件保存成功。",Toast.LENGTH_SHORT).show();
            cle();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }else {
            Toast.makeText(this,"没有插入SD卡，请插入SD卡。",Toast.LENGTH_SHORT).show();
        }
    }
}
