package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import cn.com.alldemophone.R;

/**
 * 练习activity生命周期
 * Created by admin on 2015/8/21.
 */
public class Day06_07 extends Activity {
    ImageView iv_boss , iv_people;
    ProgressBar pb ;
    int value = 100 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_07layout);

        iv_people = (ImageView) findViewById(R.id.iv_people);
        iv_boss = (ImageView) findViewById(R.id.iv_boss);

        pb = (ProgressBar) findViewById(R.id.pb);
        pb.setProgress(value);
    }

    public void qq(View v) {
        iv_people.setImageResource(R.drawable.qq1);
        value-=5;
        pb.setProgress(value);
        if(value <= 0 ){
            iv_boss.setImageResource(R.drawable.die);
        }
    }

    public void zq(View v) {
        iv_people.setImageResource(R.drawable.zq);
        value-=7;
        pb.setProgress(value);
        if(value <= 0 ){
            iv_boss.setImageResource(R.drawable.die);
        }
    }

    public void zj(View v) {
        iv_people.setImageResource(R.drawable.zj);
        value-=9;
        pb.setProgress(value);
        if(value <= 0 ){
            iv_boss.setImageResource(R.drawable.die);
        }
    }

}
