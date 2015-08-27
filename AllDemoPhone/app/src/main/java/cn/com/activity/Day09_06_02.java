package cn.com.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * 联系人工具类
 * Created by admin on 2015/8/25.
 */
public class Day09_06_02 {
    public static List<Day09_06_01> getAllContacts(Context context){
        // 由于是访问其他应用的数据库数据，所以需要用到内容解析者
        ContentResolver resolver = context.getContentResolver();
        // 指定查询的是raw_contacts表，注意，此处的主机名和path路径名可以通过查看上层应用源码得到。
        Uri contactUri = Uri.parse("content://com.android.contacts/raw_contacts");
        Uri dataUri = Uri.parse("content://com.android.contacts/data");
        // 得到查询的游标结果集
        Cursor cursor=resolver.query(contactUri,new String[]{"contact_id"},null,null,null);
        List<Day09_06_01> list = new ArrayList<Day09_06_01>();
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            System.out.println("id===" + id);
            //当循环得到一个联系人的时候，就创建出来一个对象，下面的循环将是去补充数据
            Day09_06_01 info = new Day09_06_01();
            // 注意：此处查询mimetype_id将会抛出不被识别列的异常，所以要想查询mimetype,就直接写mimetype即可。
            // 执行data表查询的时候，并不是真正查询data表，而是查询data的视图表 view_data
            Cursor dataCursor = resolver.query(dataUri,new String[]{ "data1", "mimetype" },"raw_contact_id=?", new String[] { id }, null);
            while (dataCursor.moveToNext()){
                String data = dataCursor.getString(0);
                String mimetype =dataCursor.getString(1);
                if(mimetype.equals("vnd.android.cursor.item/name")){ //姓名数据
                    info.setName(data);
                }else if(mimetype.equals("vnd.android.cursor.item/phone_v2")){
                    info.setPhone(data);
                }else if(mimetype.equals("vnd.android.cursor.item/email_v2")){
                    info.setEmail(data);
                }else if(mimetype.equals("vnd.android.cursor.item/im")){
                    info.setIm(data);
                }
                System.out.println("data===" + data);
                System.out.println("mimetype===" + mimetype);
            }
            //把对象装到集合里面，然后返回给调用者
            list.add(info);
            dataCursor.close();
        }
        cursor.close();
        return list;
    }
}
