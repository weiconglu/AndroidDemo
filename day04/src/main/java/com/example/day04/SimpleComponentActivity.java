package com.example.day04;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.TipUtils;

public class SimpleComponentActivity extends AppCompatActivity {

    private TextView tv_simple;
    private EditText et_simple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_component);

        tv_simple = findViewById(R.id.tv_simple);
        tv_simple.setText("简单常见组件测试");

        et_simple = findViewById(R.id.et_simple);

    }

    public void submit(View view) {
        TipUtils.shortTips(this, et_simple.getText().toString());
        et_simple.setText("");
    }
}