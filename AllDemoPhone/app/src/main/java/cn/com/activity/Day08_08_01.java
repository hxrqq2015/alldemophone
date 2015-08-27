package cn.com.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import cn.com.alldemophone.Day08_08_02;

/**
 * 黑马支付宝
 * Created by admin on 2015/8/22.
 */
public class Day08_08_01 extends Service {


    private class MyBinder extends Day08_08_02.Stub{

        @Override
        public int callSafePay(String username, String pwd, int money) {
            //调用服务中的支付方法
            return safePay(username, pwd, money);
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
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


    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind---");
        return super.onUnbind(intent);
    }


    /**
     * 安全支付方法
     * @param username 账号
     * @param pwd 密码
     * @param money 金额
     * @return  支付成功的状态码 ： 200  OK   ， 404： 账号或者密码错误 , 250 : 金额不足
     */
    public int safePay(String username  ,String pwd , int money ){
        System.out.println("res 加密账号传输");
        System.out.println("res 加密密码传输");

        if("zhangsan".equals(username) && "10086".equals(pwd)){
            if(money < 500){//支付成功
                return 200;
            }else{//支付失败
                return 250 ;
            }
        }
        return 404 ;
    }
}
