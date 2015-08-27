package cn.com.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 继承一个SQLiteOpenHelper (数据库的打开帮助类)
 * Created by admin on 2015/8/11.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    /**
     * 用于声明数据库的名字  、 数据库游标工厂 、 数据库的版本号
     * @param context 上下文
     * //@param name 数据库名字
     * //@param factory  游标工厂 ， null 使用默认的工厂
     * //@param version 数据库的版本号
     */
    public DBOpenHelper(Context context ) {

        super(context, "student.db", null, 1);
    }
    //数据库第一次创建的额时候调用。这里一般用来创建数据库表
    /**
     * 这里的参数db ，代表早前已经创建好的数据库对象
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql ="create table student_user(_id integer primary key autoincrement,stu_name varchar,stu_age varchar,stu_sex varchar)";
        db.execSQL(sql);
    }
    /**
     * 在数据需要更新的时候调用，什么时候更新数据库呢?现在的数据库版本比以前的版本要高的时候调用。
     * 请注意：数据库可以升级，但是不能降级。
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
