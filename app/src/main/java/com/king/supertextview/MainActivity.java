package com.king.supertextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.king.view.supertextview.SuperTextView;

public class MainActivity extends AppCompatActivity {

    private SuperTextView superTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        superTextView = (SuperTextView) findViewById(R.id.superTextView);
        superTextView.setDynamicText("莫听穿林打叶声，何妨吟啸且徐行。\n竹杖芒鞋轻胜马，谁怕？一蓑烟雨任平生。");
        superTextView.setOnDynamicListener(new SuperTextView.OnDynamicListener() {
            @Override
            public void onChange(int position) {
                Log.i("Jenly","onChange：" + position);
            }

            @Override
            public void onCompile() {
                Log.i("Jenly","onCompile");
            }
        });
    }

    private void clickByDynamicStyle(SuperTextView.DynamicStyle style){
        superTextView.setDynamicStyle(style);
        superTextView.start();

    }


    public void OnClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                clickByDynamicStyle(SuperTextView.DynamicStyle.NORMAL);
                break;
            case R.id.btn2:
                clickByDynamicStyle(SuperTextView.DynamicStyle.TYPEWRITING);
                break;
            case R.id.btn3:
                clickByDynamicStyle(SuperTextView.DynamicStyle.CHANGE_COLOR);
                break;
        }
    }
}
