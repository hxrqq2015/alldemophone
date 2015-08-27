package cn.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;


/**
 * 短信窃听器
 * Created by admin on 2015/8/21.
 */
public class Day07_05_01 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("有一条短信到来了。。。");
        Object[] message = (Object[]) intent.getSerializableExtra("pdus");
        //读取短信内容
        for (Object obj:message){
            byte[] buffer = (byte[]) obj;
            //转化为短信内容
            SmsMessage msg = SmsMessage.createFromPdu(buffer);
            System.out.println("收到来自了---"+msg.getOriginatingAddress()+"--短信的内容是："+msg.getMessageBody());
        }

        abortBroadcast(); //终止广播,让短信不再广播，不让其他的应用收到。
	/*	SmsMessage[] messages = getMessagesFromIntent(intent);
		for (SmsMessage msg : messages) {
			System.out.println("收到来自了"+msg.getOriginatingAddress()+"--短信的内容是："+msg.getMessageBody());
		}*/
    }



    /**
     * 读取短信的内容
     * @param intent
     * @return
     */
    public static final SmsMessage[] getMessagesFromIntent(
            Intent intent) {
        Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
        byte[][] pduObjs = new byte[messages.length][];

        for (int i = 0; i < messages.length; i++) {
            pduObjs[i] = (byte[]) messages[i];
        }
        byte[][] pdus = new byte[pduObjs.length][];
        int pduCount = pdus.length;
        SmsMessage[] msgs = new SmsMessage[pduCount];
        for (int i = 0; i < pduCount; i++) {
            pdus[i] = pduObjs[i];
            msgs[i] = SmsMessage.createFromPdu(pdus[i]);
        }
        return msgs;
    }
}
