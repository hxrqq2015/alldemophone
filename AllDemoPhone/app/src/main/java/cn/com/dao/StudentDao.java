package cn.com.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.com.domain.Student;
import cn.com.util.DBOpenHelper;

/**
 * 学生数据库操作类
 * Created by admin on 2015/8/11.
 */
public class StudentDao {
    DBOpenHelper dbOpenHelper;
    public StudentDao(Context context){
        dbOpenHelper = new DBOpenHelper(context);
    }

    /**
     * 增加一条数据
     * @param stu_name 学生姓名
     * @param stu_age  学生年龄
     * @param stu_sex  学生性别
     */
    public void insert(String stu_name,String stu_age,String stu_sex){
        //得到一个数据库对象
        SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
        String sql ="insert into student_user(stu_name,stu_age,stu_sex) values(?,?,?)";
        // 执行一条sql语句 ，由于语句里面包含了多个数据，所以可以选择使用占位符的方式添加
        database.execSQL(sql,new Object[]{stu_name,stu_age,stu_sex});
        //关闭数据库
        database.close();
    }

    /**
     * 删除一条数据
     * @param stu_name 学生姓名
     */
    public void delete(String stu_name){
        //得到一个数据库对象
        SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
        String sql ="delete from student_user where stu_name=?";
        database.execSQL(sql,new Object[]{stu_name});
        database.close();
    }

    /**
     * 更新一条数据
     * @param stu_age 学生年龄
     * @param stu_name 学生姓名
     */
    public void update(String stu_age,String stu_name){
        SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
        String sql ="update student_user set stu_age=? where stu_name=? ";
        database.execSQL(sql,new Object[]{stu_age,stu_name});
        database.close();
    }

    /**
     * 查找一条记录
     * @param stu_name 学生姓名
     */
    public Student findname(String stu_name){
        SQLiteDatabase database= dbOpenHelper.getReadableDatabase();
        String sql = "select * from student_user where stu_name=?";
        //执行查询，返回一个cursor对象
        Cursor cursor = database.rawQuery(sql, new String[]{stu_name});
        //让游标移动到下一条记录
        boolean flag = cursor.moveToNext();
        Student student = new Student();
        //如果能成功移动，那么就获取对应的数据
        if(flag){
            //要注意，如果存的是string  ,getString
            student.setStu_name(cursor.getString(cursor.getColumnIndex("stu_name")));
            student.setStu_age(cursor.getString(cursor.getColumnIndex("stu_age")));
            student.setStu_sex(cursor.getString(cursor.getColumnIndex("stu_sex")));
        }
        cursor.close();
        database.close();
        return  student;
    }

    /**
     * 返回所有学生数据
     * @return
     */
    public List<Student>  findall(){
        List<Student> students = new ArrayList<Student>();
        SQLiteDatabase database = dbOpenHelper.getReadableDatabase();
        //以  _id  降序desc 查询  asc升序
        String sql ="select * from student_user order by _id desc ";
        //执行查询，返回一个cursor对象
        Cursor cursor = database.rawQuery(sql, null);
        //如果游标能够一直不断的移动，那么就取数据
        //数据多了，用对象装 ，对象多了，用集合装
        while (cursor.moveToNext()){
           String setStu_name =cursor.getString(cursor.getColumnIndex("stu_name"));
           String setStu_age =cursor.getString(cursor.getColumnIndex("stu_age"));
           String setStu_sex=cursor.getString(cursor.getColumnIndex("stu_sex"));
            Student student = new Student(setStu_name,setStu_age,setStu_sex);
            students.add(student);
        }

        cursor.close();
        database.close();
        return students;
    }
}

