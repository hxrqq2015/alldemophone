package cn.com.activity;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import cn.com.alldemophone.R;

/**
 * day10_14传感器
 * Created by admin on 2015/8/24.
 */
public class Day10_14 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_14layout);

        final  TextView  tv = (TextView) findViewById(R.id.tv);
        //获取到传感器的管理者
        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
/*        //列出所有的传感器
        List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder stringBuilder = new StringBuilder();
        for(Sensor s:sensors){
            String name =s.getName();
            int type = s.getType();
            stringBuilder.append("name"+name+"---type="+type);
        }
        tv.setText(stringBuilder.toString());*/

        //得到光线传感器
        Sensor lightSensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT);
        //注册一个监听器。
        manager.registerListener(new SensorEventListener() {
            //当监听到的数据发生了改变，这个方法会调用
            @Override
            public void onSensorChanged(SensorEvent event) {
                float value = event.values[0];
                tv.setText("当前的光线强度是："+value);
            }
            //当传感器的精度发生了变化
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        },lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
