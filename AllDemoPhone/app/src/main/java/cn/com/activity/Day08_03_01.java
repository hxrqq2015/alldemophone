package cn.com.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by admin on 2015/8/22.
 */
public class Day08_03_01 extends Service  {


    /**
     * 服务中内部类，可以把它看成是中国人民大学的内部招生老师。
     * 一会我们绑定服务后将操作的是这个内部类的对象
     *
     */
    private class MyBinder extends Binder implements Day08_03_02{

        /**
         * 内部代理对象中的方法，它要做的操作就是去访问服务中的方法
         * 在activity里面，得到的是我这个内S部类的对象，然后由activity操作内部类中的这个方法，
         * 然后让我去操作服务中的方法。
         * @param name
         * @param money
         */
        @Override
        public void callMethodInService(String name , int money){
            methodInService(name, money);
        }



        public void aa(String name , int money){
            if(money < 500000){
                Toast.makeText(Day08_03_01.this, "钱还不够喝茶呢..", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(Day08_03_01.this, name+",您的中国人民大学的硕士研究生录取通知书已经办妥了。", 0).show();
            }
        }
        public void bb(String name , int money){
            if(money < 1000000){
                Toast.makeText(Day08_03_01.this, "钱还不够喝茶呢..", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(Day08_03_01.this, name+",您的中国人民大学的博士俺就是录取通知书已经办妥了。", 0).show();
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBinder---");
        //服务绑定后，返回内部代理对象
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate---");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy---");
    }

    /**
     * 服务中的方法。
     * @param name  姓名
     * @param money 钱
     */
    public void methodInService(String name , int money){
        if(money < 100000){
            Toast.makeText(this, "钱还不够喝茶呢..", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, name + ",您的中国人民大学的本科录取通知书已经办妥了。", Toast.LENGTH_SHORT).show();
        }
    }
}
