package com.example.day01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.TipUtils;

public class SecondActivity extends AppCompatActivity {

    private EditText et_second_msg;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        intent = this.getIntent();

        et_second_msg = findViewById(R.id.et_second_msg);
        String msg = intent.getStringExtra("msg").toString();
        et_second_msg.setText(msg);

    }

    // activity_second.xml 中两个按钮的onClick中的回调方法，在此重写
    public void return1(View view) {
        TipUtils.shortTips(this, "一般返回");
        // 关闭Activity
        this.finish();
    }

    public void return2(View view) {
        TipUtils.shortTips(this, "带回调返回");

        String msgReturn = et_second_msg.getText().toString();
        intent.putExtra("msgReturn", msgReturn);

        int resultCode = 1;
        setResult(resultCode, intent);
        // 关闭Activity
        this.finish();
    }
}