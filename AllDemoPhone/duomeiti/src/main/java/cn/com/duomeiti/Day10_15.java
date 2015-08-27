package cn.com.duomeiti;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * day10_15指南针
 * Created by admin on 2015/8/24.
 */
public class Day10_15 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_15layout);
        final TextView tv = (TextView) findViewById(R.id.tv);
        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // 得到方向传感器
        Sensor sensor =manager.getDefaultSensor(3);
        manager.registerListener(new SensorEventListener(){
            // values[0]: 当前手机的Y轴与北极的夹角， 0=North, 90=East, 180=South,
            // 270=West
            @Override
            public void onSensorChanged(SensorEvent event) {
                int value = (int) event.values[0];
                String result = "";
                if (value == 0) { // 正北方向
                    result = "正北--->" + value;
                } else if (value == 90) {
                    result = "正东--->" + value;

                } else if (value == 180) {
                    result = "正南--->" + value;

                } else if (value == 270) {
                    result = "正西--->" + value;
                }else if (value > 0 && value< 90) {
                    result = "东北方向--->" + value;
                }else if (value > 90 && value< 180) {
                    result = "东南方向--->" + value;
                }else if (value > 180 && value< 270) {
                    result = "西南方向--->" + value;
                }else if (value > 270 && value< 360) {
                    result = "西北方向--->" + value;
                }


                tv.setText(result);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        },sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
