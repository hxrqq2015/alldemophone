package cn.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import cn.com.alldemophone.R;

/**
 * Created by admin on 2015/8/19.
 */
public class Day06_01_01 extends Activity {
    EditText et_name;
    TextView tv_result;
    RadioGroup rg_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day06_01_01layout);

        et_name = (EditText) findViewById(R.id.name);
        tv_result = (TextView) findViewById(R.id.tv_result);


        rg_gender = (RadioGroup) findViewById(R.id.rg_gender);

    }

    public void calc(View v){
        String name = et_name.getText().toString();
        Intent intent = new Intent(this , Day06_01_02.class);

        /*
	 * 单一传递
	 * //传递数据 给下一个界面传递数据， key:str 值： str
		intent.putExtra("name", name);
		//传递过去当前选中的是哪一个性别的控件id ，然后在下一个界面进行性别判定
		intent.putExtra("gender" , rg_gender.getCheckedRadioButtonId());*/

        //打包传递
        //封装数据到bundle里面
        Bundle value = new Bundle();
        value.putString("name",name);
        value.putInt("gender",rg_gender.getCheckedRadioButtonId());
        //传递bundle
        intent.putExtra("bundle",value);
        //传递一个bitmap位图
        Bitmap  bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.logo);
        intent.putExtra("icon",bitmap);
        startActivity(intent);

    }
}
