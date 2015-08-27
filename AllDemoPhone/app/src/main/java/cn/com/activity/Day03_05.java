package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import cn.com.alldemophone.R;

/**
 * 国际化、样式、主题
 * Created by admin on 2015/8/13.
 */
public class Day03_05 extends Activity{
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day03_05layout);
        imageView = (ImageView) findViewById(R.id.day03_05_ima_01);
        imageView.setImageResource(R.drawable.flag);
    }
}
