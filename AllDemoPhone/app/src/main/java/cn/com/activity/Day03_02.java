package cn.com.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.com.alldemophone.R;
import cn.com.dao.StudentDao;
import cn.com.domain.Student;

/**
 * day03_02学生管理系统_数据库版
 * Created by admin on 2015/8/10.
 */
public class Day03_02 extends Activity implements View.OnClickListener {
    StudentDao dao ;
    RadioGroup day03_02_rad_01;
    EditText day03_02_edi_01,day03_02_edi_02;
    Button day03_02_but_01,day03_02_but_02,day03_02_but_03;
    ListView day03_02_lis_01;
    List<Student> stus;
    MyAdapter adapter;
    ImageView day03_02_ima_01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day03_02layout);
        day03_02_edi_01 = (EditText) findViewById(R.id.day03_02_edi_01);
        day03_02_edi_02 = (EditText) findViewById(R.id.day03_02_edi_02);

        day03_02_rad_01 = (RadioGroup) findViewById(R.id.day03_02_rad_01);
        dao = new StudentDao(this);
        //获取控件 添加学生
        day03_02_but_01 = (Button) findViewById(R.id.day03_02_but_01);
        day03_02_but_01.setOnClickListener(this);
       // day03_02_but_02 = (Button) findViewById(R.id.day03_02_but_02);
       // day03_02_but_03 = (Button) findViewById(R.id.day03_02_but_03);

        day03_02_lis_01 = (ListView) findViewById(R.id.day03_02_lis_01);
        day03_02_ima_01 = (ImageView) findViewById(R.id.day03_02_ima_01);

        day03_02_ima_01.setBackgroundResource(R.drawable.bg);
        //获取它的背景资源，强制类型转化成 动画对象
        AnimationDrawable drawable = (AnimationDrawable) day03_02_ima_01.getBackground();
        //让动画播放
        drawable.start();

        refreshData();
    }
    @Override
    public void onClick(View v) {
        String stu_name =day03_02_edi_01.getText().toString().trim();
        String stu_age =day03_02_edi_02.getText().toString().trim();
        if(TextUtils.isEmpty(stu_name) || TextUtils.isEmpty(stu_age)){
            Toast.makeText(Day03_02.this,"姓名或年龄不能为空。",Toast.LENGTH_SHORT).show();
            return;
        }
        String gender = null;
        int id = day03_02_rad_01.getCheckedRadioButtonId();
        if(id == R.id.rb_male){ //选中男性
            gender = "男";
        }else { //女性
            gender = "女";
        }

        switch (v.getId()){
            case R.id.day03_02_but_01:


                dao.insert(stu_name,stu_age,gender);
                //清空
                day03_02_edi_01.setText("");
                day03_02_edi_02.setText("");
                //刷新
                refreshData();
                break;
//            case R.id.day03_02_but_02:
//                break;
//            case R.id.day03_02_but_03:
//                break;
        }
    }
    //刷新数据
    public  void refreshData(){
        //查找数据库所有数据
        stus = dao.findall();
        if(adapter==null){
            //创建一个adapter适配器
            adapter = new MyAdapter();
            //给listView绑定上做好的适配器，就能显示数据库
            day03_02_lis_01.setAdapter(adapter);
        }else{
            //数据发生了改变，通知listView刷新一下界面
            adapter.notifyDataSetChanged();
        }

    }

    class MyAdapter extends BaseAdapter{

        // 从数据库里面找到多少条信息，就应该显示多少条记录， item条目
        @Override
        public int getCount() {

            return stus.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
        // position： 每一个条目对应的下标 ，索引
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //把一个layout布局变成一个view对象 ，里面有三个参数：
            // 上下文 ， layout布局文件的id ，
            // view的容器{生成的view是否要挂载到这个容器里面} null
            View v = View.inflate(Day03_02.this, R.layout.day03_02item, null);
            //获取条目上的学生对象
            final Student stu = stus.get(position);

            //注意： 查找控件的时候要极其小心 ，findViewByid ---
            // 是到与activity关联的布局里面查找控件
            // v.findViewById(); 到当前的item转化成v的对象中查找控件，
            // 实际上也就是到item中找控件
            //性别图标控件
            ImageView iv1 = (ImageView) v.findViewById(R.id.day03_02_ima_item_01);
            //显示学生对象 姓名
            TextView tv = (TextView) v.findViewById(R.id.day03_02_tex_item_01);
            //显示学生对象 年龄
            TextView tv1 = (TextView) v.findViewById(R.id.day03_02_tex_item_02);
            TextView tv2 = (TextView) v.findViewById(R.id.day03_02_tex_item_03);
            //删除图标控件
            v.findViewById(R.id.day03_02_ima_item_02).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Day03_02.this);
                    builder.setTitle("提示:");
                    builder.setMessage("确定要删除该学生吗？");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //ListView里面的删除要做两个工作，
                            //1. 从数据库里面删除这一条记录
                            String name = stu.getStu_name();
                            dao.delete(name);
                            //2. 要求要刷新一遍界面，也就是显示最新的数据
                            refreshData();
                        }
                    });
                    builder.setNegativeButton("取消", null);
                    builder.show();
                }
            });

            //设置姓名
            tv.setText(stu.getStu_name());
            tv1.setText(stu.getStu_age());
            tv2.setText(stu.getStu_sex());
            if(stu.getStu_sex().equals("男")){
                //给图形控件设置图片
                iv1.setImageResource(R.drawable.nan);
            }else{
                iv1.setImageResource(R.drawable.nv);
            }
            return v;
        }
    }

}
