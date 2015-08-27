package cn.com.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.com.domain.Student;
import cn.com.util.DBOpenHelper;

/**
 * Student数据库操作类  API
 * Created by admin on 2015/8/13.
 */
public class StudentAPIDao {
    DBOpenHelper db ;
    public StudentAPIDao(Context context){
        db= new DBOpenHelper(context);
    }

    /**
     * 执行添加方法
     * @param stu_name
     * @param stu_age
     * @param stu_sex
     * @return 如果返回-1 代表插入失败 。 否则返回的将是插入的最新行ID
     */
    public long insert(String stu_name,String stu_age,String stu_sex){
        // 得到一个数据库对象
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        //生成一个键值 对的contentValues对象
        ContentValues values = new ContentValues(  );
        //key: 列的名字 ， value: 要往这一列里面添加的值
        values.put("stu_name",stu_name);
        values.put("stu_age",stu_age);
        values.put("stu_sex",stu_sex);
        long result = sqLiteDatabase.insert("student_user",null,values);
        // 关闭数据库
        sqLiteDatabase.close();
        return result;
    }

    /**
     * 删除的方法 ，根据名字删除
     * @param stu_name
     * @return 返回的影响行个数，如果是0 代表没有删除成功
     */
    public int delete(String stu_name){
        // 得到一个数据库对象
        SQLiteDatabase sqLiteDatabase =db.getWritableDatabase();
       int result = sqLiteDatabase.delete("student_user", "stu_name=?", new String[]{stu_name});
        // 关闭数据库
        sqLiteDatabase.close();
        return result;
    }

    /**
     * 更新数据 根据姓名去修改年龄数据
     * @param stu_age
     * @param stu_name
     * @return 返回的影响行个数，如果是0 代表没有删除成功
     */
    public int update (String stu_age,String stu_name){
        // 得到一个数据库对象
        SQLiteDatabase database = db.getWritableDatabase();
        //生成一个键值 对的contentValues对象
        ContentValues values = new ContentValues();
        values.put("stu_age", stu_age);
        int result = database.update("student_user", values, "stu_name=?", new String[]{stu_name});
        // 关闭数据库
        database.close();
        return result;
    }

    /**
     * 根据姓名去查询学生
     * @param stu_name
     * @return 如果返回null ，代表没有该学生。
     */
    public Student findone(String stu_name){
        // 得到一个数据库对象
       SQLiteDatabase database= db.getReadableDatabase();
        //Cursor cursor =database.query(
        // "stu", new String[]{"gender"},
        // "name=?", new String[]{name}, null, null, null);
      Cursor cursor = database.query("student_user",
                new String[]{"stu_name","stu_age","stu_sex"},
                "stu_name=?",new String[]{stu_name},null,null,null);
        // 让游标移动到下一条记录
      boolean flag =  cursor.moveToNext();
        Student student = new Student();
        if(flag){
            //要注意，如果存的是string  ,getString
            student.setStu_name(cursor.getString(cursor.getColumnIndex("stu_name")));
            student.setStu_age(cursor.getString(cursor.getColumnIndex("stu_age")));
            student.setStu_sex(cursor.getString(cursor.getColumnIndex("stu_sex")));
        }
        return  student;
    }

    /**
     * 获取所有的学生数据
     * @return
     */
    public List<Student> findall(){
        List<Student> students = new ArrayList<Student>();
        // 得到一个数据库对象
        SQLiteDatabase database= db.getReadableDatabase();
        // 执行查询，返回一个cursor对象
        Cursor cursor = database.query("student_user", null, null, null, null, null, null);
        // 如果游标能够一直不断的移动，那么就取数据
        // 数据多了，用对象装 ，对象多了，用集合装
        while (cursor.moveToNext()){
            String setStu_name =cursor.getString(cursor.getColumnIndex("stu_name"));
            String setStu_age =cursor.getString(cursor.getColumnIndex("stu_age"));
            String setStu_sex=cursor.getString(cursor.getColumnIndex("stu_sex"));
            Student student = new Student(setStu_name,setStu_age,setStu_sex);
            students.add(student);
        }
        cursor.close();
        database.close();
        return  students;
    }
}
