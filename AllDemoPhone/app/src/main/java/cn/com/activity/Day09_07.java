package cn.com.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.com.alldemophone.R;

/**
 * day09_07添加联系人
 * Created by admin on 2015/8/25.
 */
public class Day09_07 extends Activity {
    EditText et_name,et_phone,et_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day09_07layout);
        et_name = (EditText) findViewById(R.id.name);
        et_phone = (EditText) findViewById(R.id.phone);
        et_email = (EditText) findViewById(R.id.email);
    }

    public void save(View v){
        String name = et_name.getText().toString();
        String phone = et_phone.getText().toString();
        String email = et_email.getText().toString();

        // 在本地生成一个联系人
        ContentResolver resolver = getContentResolver();
        // 指定查询的是raw_contacts表，注意，此处的主机名和path路径名可以通过查看上层应用源码得到。
        Uri contactUri = Uri
                .parse("content://com.android.contacts/raw_contacts");
        Uri dataUri = Uri.parse("content://com.android.contacts/data");
        // 要想插入数据之前，先得做好当前的contact_id是多少。
        //查询出来后，倒序排列，取第一条，就能拿到以前的id最大值了。
        Cursor cursor = resolver.query(contactUri,new String[]{"_id"},null,null,"_id desc");
        //cursor默认的position位置是-1 ，也就是没有指向任何记录，所以应该让它移动到第一条记录。
        int position = cursor.getPosition();
        System.out.println("position1111==" + position);  //打印出来是-1

        cursor.moveToFirst();

       int position2 = cursor.getPosition();
     System.out.println("position222222=="+position2); //打印出来是0 代表是第一条记录

        int newId = 0;
        try {
            newId = cursor.getInt(0)+1;
        } catch (Exception e) {
            newId=1;
            e.printStackTrace();

        }
        System.out.println("最新一条记录的ID是==" + newId);


        //先往raw_contact表里面生成一条记录，该记录要注意contact_id为最新的id
        ContentValues values = new ContentValues();
        values.put("contact_id", newId);
        resolver.insert(contactUri,values);

        //往data表里面添加记录  电话，邮箱、姓名
        ContentValues nameVal = new ContentValues();
        nameVal.put("data1", name);//指定写入什么数据
        nameVal.put("mimetype", "vnd.android.cursor.item/name"); //指定写入的数据是什么类型
        nameVal.put("raw_contact_id", newId); //指定这一条记录属于哪一个联系人
        resolver.insert(dataUri, nameVal);


        ContentValues phoneVal = new ContentValues();
        phoneVal.put("data1", phone);//指定写入什么数据
        phoneVal.put("mimetype", "vnd.android.cursor.item/phone_v2"); //指定写入的数据是什么类型
        phoneVal.put("raw_contact_id", newId); //指定这一条记录属于哪一个联系人
        resolver.insert(dataUri, phoneVal);


        ContentValues emailVal = new ContentValues();
        emailVal.put("data1", email);//指定写入什么数据
        emailVal.put("mimetype", "vnd.android.cursor.item/email_v2"); //指定写入的数据是什么类型
        emailVal.put("raw_contact_id", newId); //指定这一条记录属于哪一个联系人
        resolver.insert(dataUri, emailVal);
        Toast.makeText(this, "添加联系人成功", Toast.LENGTH_SHORT).show();
    }
}
