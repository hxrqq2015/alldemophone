package cn.com.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import cn.com.alldemophone.R;

/**
 * 我是声音界面
 * Created by admin on 2015/8/26.
 */
public class Day11_02_01 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //让当前的碎片，显示指定的布局
        final View view = inflater.inflate(R.layout.day11_02_01layout, null);
        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getActivity（）是拿到了当前的fragment依附于哪一个activity身上，就拿到那个activity的对象。
                EditText editText= (EditText) getActivity().findViewById(R.id.et);
              String text =   editText.getText().toString();
               TextView tv = (TextView) view.findViewById(R.id.tv);
                tv.setText(text);
            }
        });
        return view ;
    }
}
