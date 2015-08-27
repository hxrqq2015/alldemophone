package cn.com.activity;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * 这是银行内部的一个后门程序，实际上是行长的亲戚，它可以去操作数据库，然后对外暴露出来增删改查的方法。
 * Created by admin on 2015/8/23.
 */
public class Day09_01_02 extends ContentProvider{
    /**
     * 内容提供者应用在安装的时候，就对外发布了口令，所以人尽皆知。每个人只要拿到口令，都可以来访问数据。
     * 这时为了提升数据访问的安全性，有必要对口令进行升级。
     */
    //定义出来一个保安，用户匹配一会传递过来的uri口令
    static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        //给uriMatcher先保存一些uri匹配规则，该匹配规则由三部分组成
    //	 1. 主机名  ， 2 ，path路径  ， 3 匹配成功之后，返回的状态码 code
    //一般为了让主机名活着path路径 变得有意义，都不会写一些乱七八糟的字符。一般path都写表名，
    // 用于说明当前访问的是哪一张表
        matcher.addURI("cn.com.activity.Day09_01_02","account",1);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    //查询
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor;
        if(matcher.match(uri)==1){//匹配成功，可以做坏事
            System.out.println("口令正确，可以执行query操作..");
            //得到数据库帮助类对象
            Day09_01_01 dbhelp = new Day09_01_01(getContext());
            //得到数据库对象
            SQLiteDatabase database = dbhelp.getWritableDatabase();
            cursor =database.query("account",projection,selection,selectionArgs,null,null,sortOrder);
            //	database.close();  千万不要关闭数据库，否则cursor在外部程序将无法访问。
        }else {//口令不对，匹配失败
            throw new IllegalArgumentException("口令错误、小样、滚犊子..");
        }
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }
    //添加
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if(matcher.match(uri)==1){//匹配成功，可以做坏事
            System.out.println("口令正确，可以执行insert操作..");
            //得到数据库帮助类对象
            Day09_01_01 dbhelp = new Day09_01_01(getContext());
            //得到数据库对象
            SQLiteDatabase database = dbhelp.getWritableDatabase();
            database.insert("account",null,values);
            database.close();
            //通知改变的意思。  参数： 1. 属于什么样的uri对应的数据已经发生改变了， 2. 内容观察者
            //如果内容观察者给null， 代表的时候数据发生改变，我就发出来一个通知，关心这个通知的人，就会收到改变的通知。
//			如果直接指定了一个对象，达标数据一旦改变，那么这个内容观察者就能收到通知
             getContext().getContentResolver().notifyChange(uri,null);
        }else {//口令不对，匹配失败
            throw new IllegalArgumentException("口令错误、小样、滚犊子..");
        }


        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if(matcher.match(uri)==1){//匹配成功，可以做坏事
            System.out.println("口令正确，可以执行delete操作..");
            //删除数据库中的内容
            //得到数据库帮助类对象
            Day09_01_01 dbhelp = new Day09_01_01(getContext());
            //得到数据库对象
            SQLiteDatabase database = dbhelp.getWritableDatabase();
            database.delete("account", selection, selectionArgs);
            database.close();
            //通知改变的意思。  参数： 1. 属于什么样的uri对应的数据已经发生改变了， 2. 内容观察者
            //如果内容观察者给null， 代表的时候数据发生改变，我就发出来一个通知，关心这个通知的人，就会收到改变的通知。
//			如果直接指定了一个对象，达标数据一旦改变，那么这个内容观察者就能收到通知
            getContext().getContentResolver().notifyChange(uri,null);
        }else {//口令不对，匹配失败
            throw new IllegalArgumentException("口令错误、小样、滚犊子..");
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if(matcher.match(uri)==1){//匹配成功，可以做坏事
            System.out.println("口令正确，可以执行update操作..");
            //得到数据库帮助类对象
            Day09_01_01 dbhelp = new Day09_01_01(getContext());
            //得到数据库对象
            SQLiteDatabase database = dbhelp.getWritableDatabase();
            database.update("account",values,selection,selectionArgs);
            database.close();
            //通知改变的意思。  参数： 1. 属于什么样的uri对应的数据已经发生改变了， 2. 内容观察者
            //如果内容观察者给null， 代表的时候数据发生改变，我就发出来一个通知，关心这个通知的人，就会收到改变的通知。
//			如果直接指定了一个对象，达标数据一旦改变，那么这个内容观察者就能收到通知
            getContext().getContentResolver().notifyChange(uri,null);
        }else {//口令不对，匹配失败
            throw new IllegalArgumentException("口令错误、小样、滚犊子..");
        }
        return 0;
    }
}
