package cn.com.mydemotest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;


import cn.com.alldemophone.Day08_06_02;


public class MainActivity extends Activity  implements View.OnClickListener{
   Button but_01,but_02,but_03,but_04;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but_01 = (Button) findViewById(R.id.but_01);
        but_01.setOnClickListener(this);
        but_02 = (Button) findViewById(R.id.but_02);
        but_02.setOnClickListener(this);
    }

    public void openActivity(Class a){
        Intent intent = new Intent(MainActivity.this,a);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_01:
                openActivity(Day08_07.class);
                break;
            case R.id.but_02:
                openActivity(Day08_08.class);
        }
    }
}
