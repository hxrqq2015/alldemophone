package cn.com.activity;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.io.IOException;

/**
 * 监听电话
 * Created by admin on 2015/8/22.
 */
public class Day08_10_01 extends Service{

    TelephonyManager tm ;
    MediaRecorder mRecorder;
    MyListener listener ;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //服务一创建，就获取到电话电话管理者
        tm= (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        listener = new MyListener();
        //注册电话监听状态 监听电话的状态
        tm.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }

    class MyListener extends PhoneStateListener{
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            switch (state){
                case TelephonyManager.CALL_STATE_IDLE://空闲状态
                    System.out.println("当前没有电话接入");
                    stopRecording();
                    break;
                case  TelephonyManager.CALL_STATE_RINGING://响铃状态
                    System.out.println("来电话了，正在响铃中..");
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK://通话状态
                    System.out.println("来电话了，正在通话中..");
                    startRecording();
                    break;

            }
        }


    }
    //开始录制
    private void startRecording() {
        //创建一个音频录制对象
        mRecorder =new MediaRecorder();
        //设置捕获的声音来源
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //设置保存的文件格式，是3gp格式
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        //设置保存的路径
        mRecorder.setOutputFile("/mnt/sdcard/"+System.currentTimeMillis()+".3gp");
        //设置音频编码
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            mRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mRecorder.start();
    }

    //停止录制
    private void stopRecording(){
        if(mRecorder!=null){
            mRecorder.stop();
            mRecorder.release();
            mRecorder=null;

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //当服务销毁的时候，停止监听。
        tm.listen(listener,PhoneStateListener.LISTEN_NONE);
    }
}
